package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

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

public class ActivityTrackerMain {

    private String url;
    private String username;
    private String password;

    public static void main(String[] args) {
        ActivityTrackerMain act = new ActivityTrackerMain();
        act.readProperties();
        // MariaDbDataSource dataSource = act.initDB();
        // act.insertALine(dataSource, LocalDateTime.now(), "valami", "BASKETBALL"));
        // act.selectALine(dataSource, 7);
        System.out.println(act.saveActivity(new Activity(LocalDateTime.now(), "Jozsi", ActivityType.RUNNING)));
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
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getLong("id");
                } else {
                    throw new IllegalStateException("No generated key!");
                }
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    public Activity insertActivity(Activity activity) {
        readProperties();
        MariaDbDataSource dataSource = initDB();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "insert into activities (start_time, activity_desc, activity_type) values (?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getActivityType().name());
            stmt.executeUpdate();
            Activity result = getIdAfterExecuted(activity, stmt);
            insertActivityTrackPoints(activity.getTrackPoints(), result.getId());
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    private void insertActivityTrackPoints(List<TrackPoint> trackPoints, long activityID) throws SQLException {
        readProperties();
        MariaDbDataSource dataSource = initDB();
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement smtm = conn.prepareStatement(
                    "insert into track_points(act_time, lat, lon, activityID) values (?, ?, ?,?)")){
                for (TrackPoint trackPoint : trackPoints){
                    if (trackPoint.getLat()>90 || trackPoint.getLat()<-90 || trackPoint.getLon()<-180 || trackPoint.getLon()>180){
                        throw new IllegalArgumentException("Invalid Coordinates!");
                    }
                    smtm.setDate(1, Date.valueOf(trackPoint.getTime()));
                    smtm.setDouble(2, trackPoint.getLat());
                    smtm.setDouble(3, trackPoint.getLon());
                    smtm.setLong(4, activityID);
                }
            } catch (IllegalArgumentException ia) {
                conn.rollback();
            }
        }
    }

    private Activity getIdAfterExecuted(Activity activity, PreparedStatement stmt) throws SQLException {
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) {
                return new Activity(rs.getLong("id"),
                        activity.getStartTime(),
                        activity.getDesc(),
                        activity.getActivityType());
            } else {
                throw new IllegalStateException("No generated key!");
            }
        }
    }

    public void saveActivityOld(Activity activity) {
        readProperties();
        insertALine(initDB(), activity.getStartTime(), activity.getDesc(), activity.getActivityType().name());
    }

    public Activity saveActivity(Activity activity) {
        readProperties();
        MariaDbDataSource dataSource = initDB();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "insert into activities (start_time, activity_desc, activity_type) values (?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getActivityType().name());
            stmt.executeUpdate();
            return getIdAfterExecuted(activity, stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    public Activity findActivityById(long id) {
        readProperties();
        return selectALine(initDB(), id);
    }

    public List<Activity> listActivities() {
        readProperties();
        MariaDbDataSource dataSource = initDB();
        List<Activity> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from activities")
        ) {
            while (rs.next()) {
                result.add(new Activity(
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        ActivityType.valueOf(rs.getString("activity_type"))));
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
        return result;
    }

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

    public List<Activity> selectActivitiesBefore(MariaDbDataSource dataSource, LocalDate date) {
        List<Activity> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "select * from activities where start_time < ?")
        ) {
            LocalDateTime actualtime = date.atTime(0, 0);
            stmt.setTimestamp(1, Timestamp.valueOf(actualtime));

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    result.add(
                            new Activity(
                                    rs.getTimestamp("start_time").toLocalDateTime(),
                                    rs.getString("activity_desc"),
                                    ActivityType.valueOf(rs.getString("activity_type"))));
                }
                return result;
            } catch (SQLException sqle) {
                throw new IllegalStateException("Cannot query", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    public List<Activity> selectActivitiesByType(ActivityType activityType) {
        MariaDbDataSource dataSource = initDB();
        List<Activity> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "select * from activities where activity_type = ?")
        ) {
            stmt.setString(1, activityType.name());

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    result.add(
                            new Activity(
                                    rs.getTimestamp("start_time").toLocalDateTime(),
                                    rs.getString("activity_desc"),
                                    ActivityType.valueOf(rs.getString("activity_type"))));
                }
                return result;
            } catch (SQLException sqle) {
                throw new IllegalStateException("Cannot query", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
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