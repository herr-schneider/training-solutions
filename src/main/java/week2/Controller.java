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
        } else {
            if (chosen.equals("2")) {
                for (String points : office.printNamesReverse()) {
                    System.out.println(points);
                }
            } else {
                if (chosen.equals("3")) {
                    for (String points : office.printEventNames()) {
                        System.out.println(points);
                    }
                } else {
                    if (chosen.equals("4")) {
                        for (String points : office.printAreas()) {
                            System.out.println(points);
                        }}
                }
            }
            /* case "3": {
                for (String points : office.printEventNames()) {
                    System.out.println(points);
                }
            }
                default: {
                    System.out.println("Hülye vagy");}
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
            } */

        }
    }}




