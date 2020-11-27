package introexception.patient;

public class SsnValidator {
    String ssn;

    public SsnValidator(String ssn) {
        this.ssn = ssn;
    }

    public boolean validator() {
        if (ssn.length() != 9) {return false;}
        try {
            int ssnInt = Integer.parseInt(ssn);
        } catch (NumberFormatException nfe) {
           throw new IllegalArgumentException("");
        }
        return true;
    }
}
