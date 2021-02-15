package timesheet;

import java.time.Duration;
import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.HOURS;

public class TimeSheetItem {

    Employee employee;
    Project project;
    LocalDateTime beginDate;
    LocalDateTime endDate;

    public TimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        this.employee = employee;
        this.project = project;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
        return project;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public long hoursBetweenDates(){
        //return HOURS.between(endDate, beginDate);
        return Duration.between(beginDate, endDate).toHours();
    }
}
