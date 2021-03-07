package covid;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Scanner;

public class CovidMain {


    public static void main(String[] args) {
        CovidDao dao = new CovidDao();
        CovidMain main = new CovidMain();
        int answer = 0;
        while (answer != 7) {
            answer = main.mainMenu();
            switch (answer) {
                case 1:
                    main.singleReg();
                    break;
                case 2:
                    dao.readvaccinatable(Path.of("src/main/java/activitytracker/vacc.csv"));
                    break;
                case 3:
                    dao.registrationFromCSV();
                    break;
                case 4:
                    main.giveVaccine();
                    break;
                case 5:
                    main.failedVaccine();
                    break;
                case 6:
                    dao.generateReport();
                    break;
                default:
                    System.out.println("Nem jó");
            }
        }


    }

    private int mainMenu() {
        try (Scanner scanner = new Scanner(Path.of("src/main/java/covid/menu.csv"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        Scanner answerScanner = new Scanner(System.in);
        System.out.println("Válasz a lehetőségek közül:");
        int chosen = answerScanner.nextInt();
        answerScanner.nextLine();
        return chosen;
    }

    private void singleReg() {
        CovidDao dao = new CovidDao();

        Scanner answerScanner = new Scanner(System.in);
        System.out.println("Beteg neve:");
        String name = answerScanner.nextLine();
        System.out.println("Posta:");
        int zip = answerScanner.nextInt();
        answerScanner.nextLine();
        System.out.println("Életkor:");
        int age = answerScanner.nextInt();
        answerScanner.nextLine();
        System.out.println("Email:");
        String email = answerScanner.nextLine();
        System.out.println("Taj:");
        String taj = answerScanner.nextLine();
        dao.writeToDB(name, zip, age, email, taj);
        System.out.println("Sikeres regisztráció.");
    }

    private void giveVaccine() {
        CovidDao dao = new CovidDao();

        Scanner answerScanner = new Scanner(System.in);
        System.out.println("Beteg neve:");
        String name = answerScanner.nextLine();
        System.out.println("Posta:");
        int zip = answerScanner.nextInt();
        answerScanner.nextLine();
        System.out.println("Életkor:");
        int age = answerScanner.nextInt();
        answerScanner.nextLine();
        System.out.println("Email:");
        String email = answerScanner.nextLine();
        System.out.println("Taj:");
        String taj = answerScanner.nextLine();
        System.out.println("Status:");
        String status = answerScanner.nextLine();
        System.out.println("Note:");
        String note = answerScanner.nextLine();
        System.out.println("Datum (yyyy-mm-dd):");
        String datum = answerScanner.nextLine();
        int year = Integer.parseInt(datum.substring(0,3));
        int month = Integer.parseInt(datum.substring(5,7));
        int day = Integer.parseInt(datum.substring(8,10));
        dao.giveVaccine(taj, LocalDate.of(year, month, day), status, note);
        System.out.println("Sikeres regisztráció.");
    }

    private void failedVaccine() {
        CovidDao dao = new CovidDao();
        Scanner answerScanner = new Scanner(System.in);
        System.out.println("Taj:");
        String taj = answerScanner.nextLine();
        System.out.println("Note:");
        String note = answerScanner.nextLine();
        dao.givingVaccineFailed(taj, note);
        System.out.println("Sikeres regisztráció.");
    }

    public int cdvGenerator(String taj) {
        double cdvCode = 0;
        int temp = 0;
        for (int i = 0; i < 8; i += 2) {
            temp = Integer.parseInt(taj.substring(i, i + 1)) * 3;
            cdvCode += temp;
        }
        for (int i = 1; i < 8; i += 2) {
            temp = Integer.parseInt(taj.substring(i, i + 1)) * 7;
            cdvCode += temp;
        }
        return (int) (Math.round(cdvCode / 10));
    }
}