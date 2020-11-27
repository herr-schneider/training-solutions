package introexception.patient;

import java.time.LocalDate;

public class Patient {
    String name;
    String socialSecurityNumber;
    LocalDate dateOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth, int mouthOfBirth, int dayOfBirth) {
        if (!isYearOk(yearOfBirth)) {
            throw new  IllegalArgumentException("You are dead!");
        }
        this.name = name;
        SsnValidator ssn = new SsnValidator(socialSecurityNumber);
        if (ssn.validator() == false){throw new IllegalArgumentException("");};
        this.socialSecurityNumber = socialSecurityNumber;
        dateOfBirth = LocalDate.of(yearOfBirth,mouthOfBirth,dayOfBirth);
    }

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
        if (!isYearOk(yearOfBirth)) {
            throw new  IllegalArgumentException("You are dead!");
        }
        this.name = name;
        SsnValidator ssn = new SsnValidator(socialSecurityNumber);
        if (ssn.validator() == false){throw new IllegalArgumentException("");};
        this.socialSecurityNumber = socialSecurityNumber;
        dateOfBirth = LocalDate.of(yearOfBirth,1,1);
    }

    public boolean isYearOk (int year) {
        if (year <1900) {return false;}
        return true;
    }
    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return dateOfBirth.getYear();
    }

    public int getMonthOfBirth() {
        return dateOfBirth.getMonthValue();
    }

    public int getDayOfBirth() {
        return dateOfBirth.getDayOfMonth();
    }

    public static void main(String[] args) {
        SsnValidator ssn = new SsnValidator("abc");
        int ssnInt = Integer.parseInt("abc");
        System.out.println(ssn.validator());

    }
}
