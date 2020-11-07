package week2;

import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom (MeetingRoom meetingRoom){
        meetingRooms.add(meetingRoom);

    }

    public List<String> printNames() {
        List data = new ArrayList();
        for (MeetingRoom room : meetingRooms) {
            data.add(room.getName());
        }
        return data;
    }

    public List<String> printNamesReverse() {
        List output = new ArrayList();
        for (int i = meetingRooms.size(); i > 1; i--) {
            output.add(meetingRooms.get(i).getName());
        }
        return output;
    }
    public List<String> printEventNames() {
        List output = new ArrayList();
        for (int i = 1; i > meetingRooms.size(); i++) {
            if (i % 2 == 0) {
                output.add(meetingRooms.get(i).getName());
            }
        }
        return output;
    }

    public List<String> printAreas() {
        List output = new ArrayList();
            for (MeetingRoom room : meetingRooms) {
                output.add(room.getArea());
            }
            return output;
        }

    public List<String> printAreasLargerThan(int area) {
        List output = new ArrayList();
        for (MeetingRoom room : meetingRooms) {
            if (room.getArea() > area) {
                output.add(room.getName());
            }
        }
        return output;
    }

    public List<String> printMeetingRoomsWithName(String name) {
        List output = new ArrayList();
        for (MeetingRoom room : meetingRooms) {
            if (room.getName().equals(name)) {
                output.add(room.getName());
            }
        }
        return output;
    }

    public List<String> printMeetingRoomContainsWithName(String part) {
        List output = new ArrayList();
        for (MeetingRoom room : meetingRooms) {
            if (room.getName().indexOf(part) > -1) {
               output.add(room.getName());
            }
        }
        return output;
    }
}