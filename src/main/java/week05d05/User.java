package week05d05;

public class User {
    String firstName;
    String lastName;
    String email;

    public User(String firstName, String lastName, String email) {
        if (isEmpty(firstName) || isEmpty(lastName)) {
            throw new IllegalArgumentException("Empty name!");
        }
        if (isEmpty(email) || !isEmailOk(email)) {
            throw new IllegalArgumentException("Invalid Email!");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Username" + firstName + " " + lastName + ", email='" + email;
    }

    private boolean isEmpty (String toBeChecked) {
        if (toBeChecked == null || toBeChecked.isBlank() || toBeChecked.isEmpty()){
            return true;
        }
        return false;
    }

    private boolean isEmailOk (String toBeChecked) {

        if (isEmpty(toBeChecked) || toBeChecked.indexOf('@')< 1 || toBeChecked.indexOf(".") < 2){
            return false;
        }
        return true;
    }

}
