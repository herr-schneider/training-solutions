package week14d03;

import java.util.*;

public class Student implements Comparable<Student>{
    private String name;
    private Map<String, List<Integer>> marks = new TreeMap<>();

    public Student(String name) {
        this.name = name;
    }

    public Student(Student s){
        name=s.name;
        marks = new HashMap<>(s.marks);
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
        return new TreeMap<>(marks);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.getName());
    }
}
