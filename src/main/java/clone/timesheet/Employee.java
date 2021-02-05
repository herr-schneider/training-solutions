package clone.timesheet;

public class Employee {
    String firstName;
    String surName;

    public Employee(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

    public String getName() {
        return firstName + " " + surName;
    }

}
