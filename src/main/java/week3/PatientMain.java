package week3;

public class PatientMain {

    public static void main(String[] args) {
        try{
            Patient patient = new Patient("John", "987654321", "1870");
            System.out.println(patient.toString());
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
        }
    }
}
