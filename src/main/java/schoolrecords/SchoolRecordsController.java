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
                    System.out.println("Please enter deletable student's name:");
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
            if (i == 5) {
                System.out.println("The Winner is "+ classRecords.repetition().getName());
            }

            if (i == 6) {
                System.out.println("The average of Class is "+ classRecords.calculateClassAverage());
            }

            if (i == 7) {
                System.out.println("Please subject's name:");
                double d = classRecords.calculateClassAverageBySubjectReal(new Subject(keyboardReader.nextLine()));
                if (d == 0.0) {
                    System.out.println("There is no subject!");
                } else if (d != 0.0) {System.out.println(d);}
            }

            if (i == 8) {
                System.out.println("Students' averages:");
                for (StudyResultByName studyResultByName : classRecords.listStudyResults()) {
                    System.out.println(studyResultByName.getStudentName() + " " + studyResultByName.getStudyAverage());
                }
            }

            if (i == 9) {
                System.out.println("Please student's name:");
                double d = classRecords.findStudentByName(keyboardReader.nextLine()).calculateAverage();
                if (d == 0.0) {
                    System.out.println("There is no student!");
                } else if (d != 0.0) {System.out.println(d);}
            }

            if (i == 10) {
                System.out.println("Please student's name:");
                String student = keyboardReader.nextLine();
                System.out.println("Please name of subject:");
                String subject = keyboardReader.nextLine();

                double d = classRecords.calculateStudentAverageBySubjectReal(student, subject);
                if (d == 0.0) {
                    System.out.println("Unknown error(s)!");
                } else if (d != 0.0) {System.out.println(d);}
            }
        }
    }
   }



