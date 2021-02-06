package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.DAYS;

public class TimeSheetItem {
    private Employee employee;
    private Project project;
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeSheetItem(Employee employee, Project project, LocalDateTime from, LocalDateTime to) {
        if (from.isAfter(to) || DAYS.between(from, to) > 0) {
            throw new IllegalArgumentException("");
        }
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }

    public TimeSheetItem(TimeSheetItem other) {
        this(new Employee(other.employee.firstName, other.employee.surName), new Project(other.project.getName()), other.from, other.to);
    } // nem a referenciát akarjuk masolni, ezért új objektumot kell létrehozni

    public static TimeSheetItem withDifferentDay(TimeSheetItem another, LocalDate date) {
        TimeSheetItem TSI = new TimeSheetItem(another);
        TSI.from = LocalDateTime.of(date, TSI.from.toLocalTime());
        TSI.to = LocalDateTime.of(date, TSI.to.toLocalTime());
        return TSI;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
        return project;
    }

    public LocalDateTime getBeginDate() {
        return from;
    }

    public LocalDateTime getEndDate() {
        return to;
    }

    public long hoursBetweenDates() {
        return HOURS.between(from, to);
    }
}
