package covid;

public class CovidMain {


    public static void main(String[] args) {
        CovidDao dao = new CovidDao();
        System.out.println(dao.isValidCDV("1234567819"));
    }

}