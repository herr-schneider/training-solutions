package week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Airport {
    private List<Fly> flies = new ArrayList<>();

    public void readFromFile(String fileName) {
        Path file = Path.of(fileName);
        try (BufferedReader bf = new BufferedReader(Files.newBufferedReader(file))) {
            String line;
            String[] lineSplit;
            int hour = 0;
            int minutes = 0;
            while ((line = bf.readLine()) != null) {
                lineSplit = line.split(" ");
                hour = Integer.parseInt(lineSplit[3].substring(0, lineSplit[3].indexOf(":")));
                minutes = Integer.parseInt(lineSplit[3].substring(lineSplit[3].indexOf(":") + 1));
                flies.add(new Fly(lineSplit[0], lineSplit[1], lineSplit[2], hour, minutes));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new IllegalStateException("File not found");
        }
    }

    public void readFromFile2(String fileName) {
        Path file = Path.of(fileName);
        try (BufferedReader bf = new BufferedReader(Files.newBufferedReader(file))) {
            String line;
            String[] lineSplit;
            while ((line = bf.readLine()) != null) {
                lineSplit = line.split(" ");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m");
                LocalTime time = LocalTime.parse(lineSplit[3], formatter);
                flies.add(new Fly(lineSplit[0], lineSplit[1], lineSplit[2], time));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new IllegalStateException("File not found");
        }
    }

    public List<Fly> getFlies() {
        return new ArrayList<>(flies);
    }

    public String typeFinder() {
        int arrival = 0;
        int departure = 0;
        for (Fly fly : flies) {
            if (fly.getType().equals("Departure")) {
                departure++;
            } else {
                arrival++;
            }
        }
        return arrival > departure ? "Arrival" : "Departure";
    }

    public Fly flyFinder(String keyword) {
        for (Fly fly : flies) {
            if (fly.getName().equals(keyword)) {
                return fly;
            }
        }
        throw new IllegalStateException("Fly not find!");
    }

    public List<Fly> flyFinderByCityAndType(String city, String type) {
        List<Fly> flights = new ArrayList<>();
        for (Fly fly : flies) {
            if (fly.getTarget().equals(city) && fly.getType().equals(type)) {
                flights.add(fly);
            }
        }
        if (flights.size() > 0) {
            return flights;
        }
        throw new IllegalStateException("Fly can not be found!");
    }

    public Fly earlierFly() {
        int minHour = 24 * 60;
        Fly result = flies.get(0);
        int temp = 0;
        for (Fly fly : flies) {
            temp = fly.getHour() * 60 + fly.getMinute(); //departure
            if (minHour > temp && fly.getType().equals("Departure")) {
                minHour = temp;
                result = fly;
            }
        }
        return result;
    }

    public Fly earliestDeparture() {
        Fly result = new Fly("000000", "Arrival", "NoWhere", LocalTime.of(00,00));
        LocalTime temp = LocalTime.of(23, 59);
        for (Fly fly : flies) {
            if (fly.getTime().isBefore(temp) && fly.getType().equals("Departure")) {
                temp = fly.getTime();
                result = fly;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Airport ar = new Airport();
        ar.readFromFile("src/main/java/week13d02/cities.txt");
        System.out.println(ar.getFlies().size());
        System.out.println(ar.typeFinder());
        System.out.println(ar.flyFinder("JP2694"));
        System.out.println(ar.flyFinderByCityAndType("Dublin", "Arrival"));
        System.out.println(ar.earlierFly());

    }
}
