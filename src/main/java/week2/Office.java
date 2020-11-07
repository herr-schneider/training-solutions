package week2;

import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom (MeetingRoom meetingRoom){
        meetingRooms.add(meetingRoom);

    }

    public void printNames() {
        for (MeetingRoom room : meetingRooms) {
            System.out.println(room.getName());
        }
    }

    public void printNamesReverse() {
        for (int i = meetingRooms.size(); i > 1; i--) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }
    public void printEventNames() {
        for (int i = 1; i > meetingRooms.size(); i++) {
            if (i % 2 == 0) {
                System.out.println(meetingRooms.get(i).getName());
            }
        }
    }

    public void printAreas() {
            for (MeetingRoom room : meetingRooms) {
                System.out.println(room.getArea());
            }
        }

    public void printAreasLargerThan(int area) {
        for (MeetingRoom room : meetingRooms) {
            if (room.getArea() > area) {
                System.out.println(room.getName());
            }
        }
    }

    public void printMeetingRoomsWithName(String name) {
        for (MeetingRoom room : meetingRooms) {
            if (room.getName().equals(name)) {
                System.out.println(room.getName());
            }
        }
    }

    public void printMeetingRoomContainsWithName(String part) {
        for (MeetingRoom room : meetingRooms) {
            if (room.getName().indexOf(part) > -1) {
                System.out.println(room.getName());
            }
        }
    }
}