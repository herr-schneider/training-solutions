package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ActivityTrackerMain {

    private String url;
    private String username;
    private String password;

    public static void main(String[] args) {
        ActivityTrackerMain act = new ActivityTrackerMain();
        act.readProperties();
        MariaDbDataSource dataSource = act.initDB();
        //act.insertALine(dataSource, LocalDateTime.now(), "valami", "BASKETBALL"));
        act.selectALine(dataSource, 7);
        //System.out.println(act.selectAllLine(act.initDB()));
    }

    public long insertALine(MariaDbDataSource dataSource, LocalDateTime startTime, String act, String act_type) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "insert into activities (start_time, activity_desc, activity_type) values (?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            stmt.setTimestamp(1, Timestamp.valueOf(startTime));
            stmt.setString(2, act);
            stmt.setString(3, act_type);
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()){
                if (rs.next()){
                 return  rs.getLong("id");
                } else {throw new IllegalStateException("No generated key!");}
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    public void saveActivity(Activity){}
    public Activity findActivityById(long id){}
    public List<Activity> listActivities(){}

    public List<String> selectAllLine(MariaDbDataSource dataSource) {
        List<String> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select activity_desc from activities")
        ) {
            while (rs.next()) {
                String name = rs.getString("activity_desc");
                result.add(name);
                System.out.println(name);
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
        return result;
    }

    public Activity selectALine(MariaDbDataSource dataSource, long index) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "select * from activities where id = ?")
        ) {

            stmt.setLong(1, index);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("activity_desc");
                    System.out.println(name);
                    return new Activity(
                            rs.getTimestamp("start_time").toLocalDateTime(),
                            rs.getString("activity_desc"),
                            ActivityType.valueOf(rs.getString("activity_type")));
                }
            } catch (SQLException sqle) {
                throw new IllegalStateException("Cannot query", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
        throw new IllegalStateException("There is no" + "line");
    }

    public MariaDbDataSource initDB() {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            // System.out.println(url + username + password);
            dataSource.setUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }
        return dataSource;
    }

    public void readProperties() {
        Properties p = new Properties();
        try (InputStream is = Activity.class.getResourceAsStream("/activity.properties")) {
            p.load(is);
            url = p.getProperty("url", "jdbc:mariadb://localhost:3308/employees?useUnicode=true");
            username = p.getProperty("username", "employees");
            password = p.getProperty("password", "employees");
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not found");
        }
    }

    public void writeProperties(String newUrl, String newUsername, String newPwd) {
        Properties p = new Properties();
        try (BufferedWriter bfw = Files.newBufferedWriter(Path.of("src/main/java/resource/activity.properties"))) {
            p.setProperty("url", newUrl);
            p.setProperty("username", newUsername);
            p.setProperty("password", newPwd);
            p.store(bfw, String.valueOf(LocalDateTime.now()));
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not found");
        }
    }
}