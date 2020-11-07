package week2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controller {

    public void readOffice() {}

    public List<String> printMenu() {
        String[] menuPoints = {"1. Meeting room in order.", "2. Meeting room in reverse order.", "3. Every event meeting rooms", "4. Areas", "5. Search", "6. Particularly search. ", "Area search."};
        List<String> menu = Arrays.asList(menuPoints);
        return menu;
        }

    public List<String> runMenu(Office office, int chosen) {
        switch(chosen) {
            case 1:{
            return office.printNames();
            }
            case 2:{
            return office.printNamesReverse();
            }
            case 3:{
            return office.printEventNames();
            }
            case 4:{
            return office.printAreas();
            }
            case 5:{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Search full:");
                String full = scanner.nextLine();
                return office.printMeetingRoomsWithName(full);
            }
            case 6:{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Search part:");
                String part = scanner.nextLine();
                return office.printMeetingRoomContainsWithName(part);
            }
            case 7:{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please write the minimum area:");
                int minimumArea = scanner.nextInt();
                scanner.nextLine();
                return office.printAreasLargerThan(minimumArea);
            }
            default:{
                String[] output = {"Adam", "Eve", "Jonathan"};
                List<String> outList = Arrays.asList(output);
                return outList;
            }
            }
        }


    public static void main(String[] args) {
        Office office = new Office();

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many room are there:");
        int numberOfItem = scanner.nextInt();
        scanner.nextLine();
        for (int i=0; i < numberOfItem; i++) {
            System.out.println("Name of " + (i+1) + ". meeting room:");
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
        int chosen = scanner.nextInt();
        scanner.nextLine();
        Controller controller = new Controller();
        for (String outText : controller.runMenu(office, chosen)) {
            System.out.println(outText);
        }

    }
}

