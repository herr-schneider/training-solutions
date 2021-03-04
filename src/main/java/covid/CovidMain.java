package covid;

import java.nio.file.Path;

public class CovidMain {


    public static void main(String[] args) {
        CovidDao dao = new CovidDao();
        System.out.println(dao.isValidCDV("1234567819"));
        dao.readvaccinatable(Path.of("src/main/java/activitytracker/vacc.csv"));
    }

}