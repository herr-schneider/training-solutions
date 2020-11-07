package week2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controller {

    public void readOffice() {}

    public List<String> printMenu() {
        String[] menuPoints = {"1. Meeting room in order.", "2. Meeting room in reverse order.", "3. Every event meeting rooms", "4. Areas", "5. Search", "6. Particularly search. ", "7. Area search."};
        List<String> menu = Arrays.asList(menuPoints);
        return menu;
        }




    public static void main(String[] args) {
        Office office = new Office();

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many room are there:");
        int numberOfItem = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfItem; i++) {
            System.out.println("Name of " + (i + 1) + ". meeting room:");
            String name = scanner.nextLine();
            System.out.println("Width of meeting room:");
            int width = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Length of meeting room:");
            int length = scanner.nextInt();
            scanner.nextLine();
            MeetingRoom meetingRoom = new MeetingRoom(name, width, length);
            office.addMeetingRoom(meetingRoom);
        }

        Controller controlMenu = new Controller();

        for (String points : controlMenu.printMenu()) {
            System.out.println(points);
        }


        System.out.println("What do you want?");
        String chosen = scanner.nextLine();
        if (chosen.equals("1")) {
            for (String points : office.printNames()) {
                System.out.println(points);
            }
        }
        if (chosen.equals("2")) {
            for (String point3 : office.printNamesReverse()) {
                System.out.println(point3);
            }
        }

        if (chosen.equals("3")) {
            for (String point2 : office.printEventNames()) {
                System.out.println(point2);
            }
        }

        if (chosen.equals("4")) {
            for (int points : office.printAreas()) {
                System.out.println(points);
            }
        }

        if (chosen.equals("5")) {
            System.out.println("Search full:");
            String full = scanner.nextLine();
            for (String fullSearch : office.printMeetingRoomsWithName(full)) {
                System.out.println(fullSearch);
            }
        }

        if (chosen.equals("6")) {
            System.out.println("Search full:");
            String part = scanner.nextLine();
            for (String partSearch : office.printMeetingRoomContainsWithName(part)) {
                System.out.println(partSearch);
            }
        }

        if (chosen.equals("7")) {
            System.out.println("Please write the minimum area:");
            int minimumArea = scanner.nextInt();
            scanner.nextLine();
            for (String largerArea : office.printAreasLargerThan(minimumArea)) {
                System.out.println(largerArea);
            }
        }

        }
    }




