package timesheet;

public class Employee {
    final String firstName;
    final String lastName;

    public Employee(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return lastName + " " + lastName;
    }
}
