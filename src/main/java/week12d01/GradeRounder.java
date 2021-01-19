package week12d01;

import java.util.Arrays;

public class GradeRounder {
//    Készíts egy GradeRounder osztályt, amiben van egy int[] roundGrades(int[] grades) metódus.
//    A grades tömb pontszámokat tartalmaz 0 és 100 között.
//    A feladat az, hogy kerekítsük a benne lévő számokat a következő szabály szerint:
//    Ha a pontszám és az 5 következő többszöröse közötti különbség kisebb, mint 3,
//    akkor kerekítsük fel a számot az 5 következő többszörösére.
//    Fontos: a 40 pont alatti pontszámok elégtelenek, ezeket egyáltalán nem kell kerekíteni.
//    Példa: a pontszám 84. 85 - 84 kevesebb mint 3, így felfelé kerekítünk.

    public int[] roundGrades(int[] grades) {
        int limit = grades.length;
        int[] result = new int[limit];
        for (int i = 0; i < limit; i++) {
            if (grades[i] < 40 && grades[i] > 0) {
                result[i] = grades[i];
            } else if (grades[i] > 40 && grades[i] < 100) {
                result[i] = calculator(grades[i]);
            } else {
                throw new IllegalArgumentException("The point must be less than 100!");
            }
        }
        return result;
    }

    public int calculator(int num) {
       return num % 5 <= 2 ? ((int) (num / 5)) * 5 : ((int) (num / 5) + 1) * 5;
    }

    public int[] OrgRoundGrades(int[] grades) {
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 40 && grades[i] > 0) {
                int floor = grades[i] / 5;
                int next = (floor + 1) * 5;
                if (next - grades[i] < 3) {
                    grades[i] = next;
                }
            }
        }
        return grades;
    }

    public String toString(int[] grades) {
        return Arrays.toString(grades);
    }
}
