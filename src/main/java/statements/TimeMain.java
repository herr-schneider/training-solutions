package statements;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. időpont óra:");
        int hours1 = scanner.nextInt();
        System.out.println("1. időpont perc:");
        int minutes1 = scanner.nextInt();
        System.out.println("1. időpont másodperc:");
        int seconds1 = scanner.nextInt();

        System.out.println("2. időpont óra:");
        int hours2 = scanner.nextInt();
        System.out.println("2. időpont perc:");
        int minutes2 = scanner.nextInt();
        System.out.println("2. időpont másodperc:");
        int seconds2 = scanner.nextInt();

        Time timea = new Time(hours1, minutes1, seconds1);
        Time timeb = new Time(hours2, minutes2, seconds2);

        System.out.println("First appointment: " + timea.toString() + "in minutes: " + timea.getInMinutes());
        System.out.println("Second appointment: " + timeb.toString() + " seconds:" + timeb.getInSeconds());
        System.out.println("1st time is earlier than 2nd: " + timea.isEarlier(timeb));
    }
    }
