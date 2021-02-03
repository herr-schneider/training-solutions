package week14d03;

import java.util.*;

public class Student {
    private String name;
    private Map<String, List<Integer>> marks = new HashMap<>();

    public Student(String name) {
        this.name = name;
    }

    public void giveAMark(String subject, int mark){
        if (!marks.containsKey(subject)) {
            List<Integer> temp = new ArrayList<>();
            temp.add(mark);
            marks.put(subject, temp);
        }
        marks.get(subject).add(mark);
    }

    public String getName() {
        return name;
    }

    public Map<String, List<Integer>> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
