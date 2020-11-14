package week3;

public class Patient {
    private String name;
    private String socialSecurityNumber;
    private String yearOfBirth;

    public Patient(String name, String socialSecurityNumber, String yearOfBirth) {
        if (name == "" || name == " " || name == null || name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid Name!");}
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        int year = Integer.parseInt(yearOfBirth);
        if (year < 1900){
            throw new IllegalArgumentException("Invalid year of Birth!");}
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "name:" + name + ", socialSecurityNumber: " + socialSecurityNumber + ", yearOfBirth='" + yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

}

