package covid;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class CovidMain {


    public static void main(String[] args) {
        CovidDao dao = new CovidDao();
        CovidMain main = new CovidMain();
        int answer = main.menuDrawer();
        switch (answer) {
            case 1:
                break;
            case 2:
                dao.readvaccinatable(Path.of("src/main/java/activitytracker/vacc.csv"));
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("Nem jó");
        }


    }

    private int menuDrawer() {
        try (Scanner scanner = new Scanner(Path.of("src/main/java/covid/menu.csv"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        Scanner answerScanner = new Scanner(System.in);
        System.out.println("What do you want?");
        int chosen = answerScanner.nextInt();
        return chosen;
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