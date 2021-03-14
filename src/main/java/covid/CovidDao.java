package covid;

import activitytracker.Activity;
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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.Timestamp;

public class CovidDao {
    private String url, username, password;
    private MariaDbDataSource dataSource = initDB();
    private Path filename = Path.of("src/main/java/covid/massReg.csv");

    public void writeToDB(String name, int zip, int age, String email, String taj) {
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
            smtm.executeUpdate();
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
                    smtm.executeUpdate();
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

    private long getIdAfterExecuted(PreparedStatement stmt) throws SQLException {
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getLong("id");
            } else {
                throw new IllegalStateException("No generated key!");
            }
        }
    }

//    public void interactiveGivingVaccine(String taj, LocalDate date, String status, String note) {
//        if (!isValidCDV(taj)) {
//            throw new IllegalArgumentException("TAJ is not valid!");
//        }
//        try (Connection conn = dataSource.getConnection();
//             PreparedStatement smtm = conn.prepareStatement(
//                     "insert into vaccinations(citizen_id, vaccination_date, status, note) values (?, ?, ?, ?)");
//             PreparedStatement smtm2 = conn.prepareStatement(
//                     "UPDATE citizens SET vaccination_date = ?, " +
//                             "status = ?, " +
//                             "note = ?, " +
//                             "num_of_vacc = ? " +
//                             "WHERE citizen_id = ?", Statement.RETURN_GENERATED_KEYS);
//        ) {
//            smtm.setLong(1, getIdAfterExecuted(smtm2));
//            smtm2.setLong(5, idToGiveVaccine(taj));
//            smtm.setDate(2, Date.valueOf(date));
//            smtm2.setDate(1, Date.valueOf(date));
//            smtm.setString(3, status);
//            smtm2.setString(2, status);
//            smtm.setString(4, note);
//            smtm2.setString(3, note);
//            int numOfvacc = numOfgivenVaccine(taj) + 1;
//            smtm2.setInt(4, numOfvacc);
//            smtm.executeUpdate();
//            smtm2.executeUpdate();
//        } catch (SQLException sqle) {
//            throw new IllegalStateException("");
//        }
//    }



    public void giveVaccine(String taj, LocalDate date, String status, String note) {
        if (!isValidCDV(taj)) {
            throw new IllegalArgumentException("TAJ is not valid!");
        }
        try (Connection conn = dataSource.getConnection();
             PreparedStatement smtm = conn.prepareStatement(
                     "insert into vaccinations(citizen_id, vaccination_date, status, note) values (?, ?, ?, ?)");
             PreparedStatement smtm2 = conn.prepareStatement(
                     "UPDATE citizens SET vaccination_date = ?, " +
                             "status = ?, " +
                             "note = ?, " +
                             "num_of_vacc = ? " +
                             "WHERE citizen_id = ?");
        ) {
            long id = idToGiveVaccine(taj);
            smtm.setLong(1, id);
            smtm2.setLong(5, id);
            smtm.setDate(2, Date.valueOf(date));
            smtm2.setDate(1, Date.valueOf(date));
            smtm.setString(3, status);
            smtm2.setString(2, status);
            smtm.setString(4, note);
            smtm2.setString(3, note);
            int numOfvacc = numOfgivenVaccine(taj) + 1;
            smtm2.setInt(4, numOfvacc);
            smtm.executeUpdate();
            smtm2.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException("");
        }
    }

    private int numOfgivenVaccine(String taj) throws SQLException {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT num_of_vacc FROM citizens " +
                             "WHERE taj = ?");
             ResultSet rs = stmt.executeQuery()) {
            stmt.setString(1, taj);
            if (rs.next()) {
                return rs.getInt("num_of_vacc");
            }
            return 0;
        }
    }

    public void givingVaccineFailed(String taj, String note) {
        if (!isValidCDV(taj)) {
            throw new IllegalArgumentException("TAJ is not valid!");
        }
        try (Connection conn = dataSource.getConnection();
             PreparedStatement smtm = conn.prepareStatement(
                     "UPDATE vaccinations SET `status`='failed', note = ? WHERE vaccination_id = 2;")
        ) {
            smtm.setString(1, note);
            smtm.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException("");
        }
    }

    public long idToGiveVaccine(String taj) throws SQLException {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT citizen_id FROM citizens " +
                             "WHERE taj = ?");
             ResultSet rs = stmt.executeQuery()) {

            stmt.setString(1, taj);
            if (rs.next()) {
                return rs.getLong("citizen_id");
            }
            throw new IllegalStateException("No ID!");
        }
    }

    public void readvaccinatable(Path outputFile) {
        try (BufferedWriter writer = new BufferedWriter(Files.newBufferedWriter(outputFile));
             Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT citizen_name, " +
                             "zip, " +
                             "age, " +
                             "email, " +
                             "taj " +
                             "FROM citizens " +
                             "WHERE (last_vaccination < ?) AND " +
                             "(num_of_vacc < 2) " +
                             "ORDER BY age, citizen_name " +
                             "LIMIT 16;")) {
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT citizen_name, zip, age, email, taj FROM citizens WHERE last_vaccination < '2021.09.30' ORDER BY age, citizen_name;")) {
//             stmt.setString(1,"2021.09.30");
            stmt.setDate(1, Date.valueOf(LocalDate.now()));

            ResultSet rs = stmt.executeQuery();
            Citizen citizen = new Citizen();
            LocalTime time = LocalTime.of(8, 00);
            while (rs.next()) {
                citizen.setTime(time);
                citizen.setCitizen_name(rs.getString("citizen_name"));
                citizen.setEmail(rs.getString("email"));
                citizen.setTaj(rs.getString("taj"));
                citizen.setZip(rs.getInt("zip"));
                citizen.setAge(rs.getInt("age"));
                writer.write(citizen.toString());
                time = time.plusMinutes(30);
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("SQL problem!" + sqle);
        } catch (IOException ioe) {
            throw new IllegalStateException("File not found!");
        }
    }

    public void generateReport() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT cities.zip AS c_zip, cities.city AS c_city, " +
                     "(SELECT COUNT(*) FROM citizens WHERE citizens.zip = c_zip AND num_of_vacc = 0) " +
                     "AS nonvaccinated, " +
                     "(SELECT COUNT(*) FROM citizens WHERE citizens.zip = c_zip AND num_of_vacc = 1) AS oncevaccinated, " +
                     "(SELECT COUNT(*) FROM citizens WHERE citizens.zip = c_zip AND num_of_vacc = 2) AS twicevaccinated " +
                     "FROM citizens JOIN cities ON citizens.zip = cities.zip GROUP BY cities.zip;")) {

            while (rs.next()) {
                System.out.println(rs.getString("c_zip") + " " +
                        rs.getString("c_zip") + " " +
                        rs.getString("nonvaccinated") + " " +
                        rs.getString("oncevaccinated") + " " +
                        rs.getString("twicevaccinated"));
            }

        } catch (SQLException sqle) {
            throw new IllegalStateException("");
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