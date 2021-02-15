package timesheet;

import java.io.InputStream;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Company {
    List<Employee> listOfEmployees = new ArrayList<>();
    List<Project> projects = new ArrayList<>();

    public Company(InputStream employeesFile, InputStream projectFile) {

    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        if (beginDate.toLocalDate().equals(endDate.toLocalDate()) && beginDate.isBefore(endDate)) {
            new TimeSheetItem(employee, project, beginDate, endDate);
        }
    }

    public void calculateProjectByNameYearMonth(String name, int year, int num) {
    }

    public void printToFile(String name, int year, int num, Path report) {
    }

    public List<Employee> getEmployees() {
        return listOfEmployees;
    }

    public List<Project> getProjects() {
        return projects;
    }
}