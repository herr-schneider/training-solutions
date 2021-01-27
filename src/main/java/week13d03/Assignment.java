package week13d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Assignment {

    private final String fileName = "src/main/java/week13d03/beosztas.txt";
    private List<Lesson> lessons = new ArrayList<>();

    public void readFromFile() {
        Path file = Path.of(fileName);
        try (BufferedReader bf = new BufferedReader(Files.newBufferedReader(file))) {
            String line1;
            String line2;
            String line3;
            String line4;
            while ((line1 = bf.readLine()) != null) { // for átirni optimalizalni
                line2 = bf.readLine();
                line3 = bf.readLine();
                line4 = bf.readLine();
                lessons.add(new Lesson(line1, line2, line3, Integer.parseInt(line4)));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new IllegalStateException("File not found");
        }
    }

    public void readFromFileBlock() {
        Path file = Path.of(fileName);
        try (BufferedReader bf = new BufferedReader(Files.newBufferedReader(file))) {
            String[] line = new String[4];
            while ((line[0] = bf.readLine()) != null) {
                for (int i = 1; i < 4; i++) {
                    line[i] = bf.readLine();
                }
                lessons.add(new Lesson(line[0], line[1], line[2], Integer.parseInt(line[3])));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new IllegalStateException("File not found");
        }
    }

    public List<Lesson> getLessons() {
        return new ArrayList<>(lessons);
    }

    public int lessonsPerTeacher(String name) {
        int result = 0;
        for (Lesson lesson : lessons) {
            if (lesson.getTeacher().equals(name)) {
                result += lesson.getLessonPerWeek();
            }
        }
        return result;
    }
}
