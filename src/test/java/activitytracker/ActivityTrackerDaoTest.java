package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ActivityTrackerDaoTest {
    ActivityTrackerDao actTest = new ActivityTrackerDao();

    @BeforeEach
    public void init() {
        MariaDbDataSource dataSource;

        actTest.readProperties();
        dataSource = actTest.initDB();

        Flyway flyway = Flyway.configure()
                .locations("/db/migration/activitytracker")
                .dataSource(dataSource)
                .load();

        flyway.clean();
        flyway.migrate();

    }

    @Test
    public void testInsertLine() {
        Activity act = new Activity(LocalDateTime.of(2021, 02, 23, 10, 11),
                "Biking in fasztudjahol",
                ActivityType.BIKING);
        actTest.insertActivity(act);

        assertEquals(actTest.listActivities().size(), 1);
    }

    @Test
    public void testSelectByActivityType() {
        Activity act = new Activity(LocalDateTime.of(2021, 02, 23, 10, 11),
                "Biking in fasztudjahol",
                ActivityType.BIKING);
        Activity act2 = new Activity(LocalDateTime.of(2021, 02, 22, 10, 11),
                "Baskettball in fasztudjahol",
                ActivityType.BASKETBALL);
        Activity act3 = new Activity(LocalDateTime.of(2021, 02, 23, 8, 11),
                "Running in fasztudjahol",
                ActivityType.RUNNING);
        actTest.insertActivity(act);
        actTest.insertActivity(act2);
        actTest.insertActivity(act3);

        assertEquals(actTest.selectActivitiesByType(ActivityType.RUNNING).size(), 1);
    }

    @Test
    public void testselectActivitiesBefore() {
        Activity act = new Activity(LocalDateTime.of(2021, 02, 23, 10, 11),
                "Biking in fasztudjahol",
                ActivityType.BIKING);
        Activity act2 = new Activity(LocalDateTime.of(2021, 02, 22, 10, 11),
                "Baskettball in fasztudjahol",
                ActivityType.BASKETBALL);
        Activity act3 = new Activity(LocalDateTime.of(2021, 02, 23, 8, 11),
                "Running in fasztudjahol",
                ActivityType.RUNNING);
        actTest.insertActivity(act);
        actTest.insertActivity(act2);
        actTest.insertActivity(act3);

        assertEquals(actTest.selectActivitiesBefore(actTest.initDB(), LocalDate.now()).size(), 3);
    }

    @Test
    public void testInsertALine() {
        actTest.insertALine(actTest.initDB(), LocalDateTime.of(2021, 02, 23, 10, 11),
                "Biking in fasztudjahol","BIKING");
        assertEquals(actTest.listActivities().size(), 1);
    }
}