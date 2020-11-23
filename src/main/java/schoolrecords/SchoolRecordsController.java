package schoolrecords;

import java.util.*;

public class SchoolRecordsController {
    static ClassRecords classRecords;
    List<Tutor> ListOfTutor = new ArrayList<>();


    public void initSchool() {

        Tutor tutor = new Tutor("Nagy Csilla",
                Arrays.asList(new Subject("földrajz"),
                        new Subject("matematika"),
                        new Subject("biológia"),
                        new Subject("zene"),
                        new Subject("fizika"),
                        new Subject("kémia")));

        ListOfTutor.add(tutor);
        classRecords = new ClassRecords("Fourth Grade A", new Random(5));
        Student firstStudent = new Student("Kovács Rita");
        Student secondStudent = new Student("Nagy Béla");
        Student thirdStudent = new Student("Varga Márton");
        firstStudent.grading(new Mark(MarkType.A, new Subject("földrajz"), tutor));
        firstStudent.grading(new Mark(MarkType.C, new Subject("matematika"), tutor));
        firstStudent.grading(new Mark(MarkType.D, new Subject("földrajz"), tutor));
        secondStudent.grading(new Mark(MarkType.A, new Subject("biológia"), tutor));
        secondStudent.grading(new Mark(MarkType.C, new Subject("matematika"), tutor));
        secondStudent.grading(new Mark(MarkType.D, new Subject("zene"), tutor));
        thirdStudent.grading(new Mark(MarkType.A, new Subject("fizika"), tutor));
        thirdStudent.grading(new Mark(MarkType.C, new Subject("kémia"), tutor));
        thirdStudent.grading(new Mark(MarkType.D, new Subject("földrajz"), tutor));
        classRecords.addStudent(firstStudent);
        classRecords.addStudent(secondStudent);
        classRecords.addStudent(thirdStudent);
    }

    public static void main(String[] args) {
        try (Scanner fileReader = new Scanner(ClassRecords.class.getResourceAsStream("/menu.csv"))) {
            ;
            while (fileReader.hasNextLine()) {
                System.out.println(fileReader.nextLine());
            }
            // fileRead.close(); Not needed in order to use try.
        }

        SchoolRecordsController controller = new SchoolRecordsController();
        controller.initSchool();

        Scanner keyboardReader = new Scanner(System.in);
        int i = 0;
        while (i != 11) {
            System.out.println("Enter your choice:");
            try {
                i = keyboardReader.nextInt();
                keyboardReader.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println("You are not only beauty, but clever!");
                break;
            }

            if (i > 11 || i < 1) {
                System.out.println("You should enter a number between 1 and 11!");
            }

            if (i == 1) {
                System.out.println(classRecords.listStudentNames());
            }
            if (i == 2) {
                System.out.println("Please enter student's name:");
                try {
                    System.out.println(classRecords.findStudentByName(keyboardReader.nextLine()).toString());
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            }
            if (i == 3) {
                System.out.println("Please enter new student's name:");
                try {
                    classRecords.addStudent(new Student(keyboardReader.nextLine()));
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            }
                if (i == 4) {
                    System.out.println("Please enter new student's name:");
                    try {
                        if (classRecords.removeStudent(new Student(keyboardReader.nextLine()))) {
                            System.out.println("Done.");
                        }   else {
                            System.out.println("There is no student.");
                        }
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }

                }
            }
        }
    }



