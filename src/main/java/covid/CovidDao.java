package covid;

import iowriter.Band;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.Timestamp;

public class CovidDao {
    private String url, username, password;
    private MariaDbDataSource dataSource = initDB();
    private Path filename = Path.of("src/main/java/covid/massReg.csv");

    private void writeToDB(String name, int zip, int age, String email, String taj) {
        if (name.isEmpty() || name.isBlank() || name.length() < 3) {
            throw new IllegalArgumentException("Name is invalid!");
        }
        try {
            if (Integer.toString(zip).isEmpty()) {
                throw new NumberFormatException("It is empty!");
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Zip is invalid!");
        }
        if (age < 10 || age > 150) {
            throw new IllegalArgumentException("Age is invalid!");
        }
        if (email.length() < 3 || !email.contains("@") || email.startsWith("@")) {
            throw new IllegalArgumentException("Email is invalid!");
        }
        if (taj.isEmpty() || taj.isBlank() || !isValidCDV(taj)) {
            throw new IllegalArgumentException("TAJ is not valid!");
        }
        writingDB(name, zip, age, email, taj);
    }

    private void writingDB(String name, int zip, int age, String email, String taj) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement smtm = conn.prepareStatement(
                     "insert into citizens(citizen_name, zip, age, email, taj) values (?, ?, ?, ?, ?)")) {
            smtm.setString(1, name);
            smtm.setInt(2, zip);
            smtm.setInt(3, age);
            smtm.setString(4, email);
            smtm.setString(5, taj);
        } catch (SQLException sqle) {
            throw new IllegalStateException("");
        }
    }

    private String readCityName(int zip) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT city FROM cities WHERE zip=?");
             ResultSet rs = stmt.executeQuery()) {
            stmt.setInt(1, zip);
            if (rs.next()) {
                return rs.getString("city");
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("");
        }

        return "Unknown city"; // throw new
    }

    public void registrationFromCSV() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(Files.newBufferedReader(filename))) {
            String line;
            headerSkipper(bf);
            while ((line = bf.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new IllegalStateException("File not found");
        }
        writeListToDB(lines);
    }

    private void writeListToDB(List<String> lines) {
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement smtm = conn.prepareStatement(
                    "insert into citizens(citizen_name, zip, age, email, taj) values (?, ?, ?, ?, ?)")) {
                for (String line : lines) {
                    String[] tags = splitLine(line);
                    if (!isValidCDV(tags[4])) {
                        throw new IllegalArgumentException("TAJ is not valid!");
                    }
                    smtm.setString(1, tags[0]);
                    smtm.setInt(2, Integer.valueOf(tags[1]));
                    smtm.setInt(3, Integer.valueOf(tags[2]));
                    smtm.setString(4, tags[3]);
                    smtm.setString(5, tags[4]);
                }
            } catch (IllegalArgumentException ia) {
                conn.rollback();
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("");
        }
    }

    private void headerSkipper(BufferedReader br) throws IOException {
        br.readLine();
    }

    private String[] splitLine(String line) throws IllegalStateException {
        String[] temp = line.split(";");
        if (temp.length < 1) {
            throw new IllegalStateException("");
        }
        return temp;
    }

    public void readvaccinatable(Path outputFile) {
        try (BufferedWriter writer = new BufferedWriter(Files.newBufferedWriter(outputFile));
             Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT citizen_name, " +
                             "zip, " +
                             "age, " +
                             "email, " +
                             "taj FROM citizens WHERE last_vaccination < ? ORDER BY age, citizen_name;")) {
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT citizen_name, zip, age, email, taj FROM citizens WHERE last_vaccination < '2021.09.30' ORDER BY age, citizen_name;")) {
//             stmt.setString(1,"2021.09.30");
            stmt.setDate(1, Date.valueOf(LocalDate.now()));

            ResultSet rs = stmt.executeQuery();
            Citizen citizen = new Citizen();
            while (rs.next()) {
                citizen.setCitizen_name(rs.getString("citizen_name"));
                citizen.setEmail(rs.getString("email"));
                citizen.setTaj(rs.getString("taj"));
                citizen.setZip(rs.getInt("zip"));
                citizen.setAge(rs.getInt("age"));
                writer.write(citizen.toString());
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("SQL problem!" + sqle);
        } catch (IOException ioe) {
            throw new IllegalStateException("File not found!");
        }
    }

    public MariaDbDataSource initDB() {
        readProperties("covid.properties");
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }
        return dataSource;
    }

    public boolean isValidCDV(String taj) {
        if (!(taj.length() == 10)) {
            return false;
        }
        double cdvCode = 0;
        int temp = 0;
        try {
            for (int i = 0; i < 8; i += 2) {
                temp = Integer.parseInt(taj.substring(i, i + 1)) * 3;
                cdvCode += temp;
            }
            for (int i = 1; i < 8; i += 2) {
                temp = Integer.parseInt(taj.substring(i, i + 1)) * 7;
                cdvCode += temp;
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Nem vagy túl okos");
        }
        return Math.round(cdvCode / 10) == Integer.parseInt(taj.substring(8, 10));
    }

    public void readProperties(String source) {
        Properties p = new Properties();
        try (InputStream is = CovidDao.class.getResourceAsStream("/" + source)) {
            p.load(is);
            url = p.getProperty("url", "jdbc:mariadb://localhost:3308/employees?useUnicode=true");
            username = p.getProperty("username", "employees");
            password = p.getProperty("password", "employees");
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not found");
        }
    }

    public void writeProperties(String target, String newUrl, String newUsername, String newPwd) {
        Properties p = new Properties();
        try (BufferedWriter bfw = Files.newBufferedWriter(Path.of("src/main/java/resource/" + target))) {
            p.setProperty("url", newUrl);
            p.setProperty("username", newUsername);
            p.setProperty("password", newPwd);
            p.store(bfw, String.valueOf(LocalDateTime.now()));
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not found");
        }
    }

}
