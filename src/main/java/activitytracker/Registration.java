package activitytracker;


import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.*;

public class Registration {

    public MariaDbDataSource initDB(String source) {
        Properties p = new Properties();
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try (InputStream is = sourseSelector(source)) {
            p.load(is);
            dataSource.setUrl(p.getProperty("url", "jdbc:mariadb://localhost:3308/coronavirus?useUnicode=true"));
            dataSource.setUser(p.getProperty("username", "foni"));
            dataSource.setPassword(p.getProperty("password", "haverok"));
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not found");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }
        return dataSource;
    }

    private InputStream sourseSelector(String source) throws IOException {
        if (source == null || source.isBlank() || source.isEmpty() || source.equals("o")) {
            return Registration.class.getResourceAsStream("/covid.properties");
        } else {
            Path filename = Path.of(source);
            return Files.newInputStream(filename);
        }
    }

    private List<String> cityNameFromPostCode(MariaDbDataSource dataSource, int postCode) {
        if (postCode <= 1000) {
            return List.of("Nincs ilyen város");
        }
        List<String> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT city FROM cities WHERE zip = ?;")) {
            stmt.setInt(1, postCode);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("city"));
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("DataBase error!");
        }
        return result;
    }

    private long writeRegistration(MariaDbDataSource dataSource, String name, int postCode, int age, String email, String taj) {
        long result = 0;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "insert into citizens (citizen_name, zip, age, email, taj) values(?, ?, ?, ?, ?);",
                     Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.setInt(2, postCode);
            stmt.setInt(3, age);
            stmt.setString(4, email);
            stmt.setString(5, taj);
            result = stmt.executeUpdate();

        } catch (SQLException sqle) {
            writeLog(sqle.getMessage());
            throw new IllegalStateException("DataBase error!", sqle);
        }
        return result;
    }

    public void writeLog(String message) {
        Path file = Path.of("src\\main\\java\\covid\\log.txt");
        try (BufferedWriter bf = Files.newBufferedWriter(file, StandardOpenOption.APPEND)) {
            bf.write(message + "\n");
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not found", ioe);
        }
    }


    public boolean isEmailValid(String email) {
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);
        return m.find();
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

    public boolean isValidAge(int age) {
        return (age < 150 && age > 10);
    }

    public boolean isValidName(String name) {
        return (name.length() > 3);
    }

    public static void main(String[] args) {
        Registration reg = new Registration();
        String name = "";
        int age = 0;
        int zip = 0;
        String taj = "";
        String email = "";
        boolean ok = false;
        Scanner answerScanner = new Scanner(System.in);
        while (!ok) {
            System.out.println("Beteg neve:");
            name = answerScanner.nextLine();
            ok = reg.isValidName(name);
        }
        System.out.println("Iranyitoszam:");
        zip = answerScanner.nextInt();
        answerScanner.nextLine();
        System.out.println(reg.cityNameFromPostCode(reg.initDB(null), zip));
        ok = false;
        while (!ok) {
            System.out.println("Életkor:");
            age = answerScanner.nextInt();
            answerScanner.nextLine();
            ok = reg.isValidAge(age);
        }
        ok = false;
        while (!ok) {
            System.out.println("Email:");
            email = answerScanner.nextLine();
            ok = reg.isEmailValid(email);
        }
        ok = false;
        while (!ok) {
            System.out.println("Taj:");
            taj = answerScanner.nextLine();
            ok = true;
        } //reg.isValidCDV(taj);}

        reg.writeRegistration(reg.initDB(null), name, zip, age, email, taj);
    }

}
