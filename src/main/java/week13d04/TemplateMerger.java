package week13d04;

import week13d03.Lesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TemplateMerger {
//    Írj egy a TemplateMerger osztályba egy public String merge(Path file, List<Employee> employees)
//    metódust, ami felolvassa a fájlt, melynek tartalma:
//    Az alkalmazott neve: {nev}, születési éve: {ev}
//    Nyugodtan beolvashatod egy utasítással!
//    Majd a visszatérési értékként add vissza soronként az alkalmazottakat, abban a formátumban,
//    mint ahogy a fájlban van, azaz:
//    Az alkalmazott neve: John Doe, születési éve: 1980
//    Az alkalmazott neve: Jack Doe, születési éve: 1990
//    (Persze ehhez kell egy Employee osztály is a megfelelő attribútumokkal.



    private String createString(Path file, List<Employee> employees) {
        StringBuilder str = new StringBuilder();
        String sablon = readFromFileBlock(file);
        for (Employee employee : employees) {
            String name = employee.getName();
            String year = String.valueOf(employee.getYear());
            String employeeString = sablon.replace("{nev}", name).replace("{ev}", year); //line.replace(line.indexOf("{"), line.indexOf("}", name);
            str.append(employeeString).append("\n");
        }
        return str.toString();
    }

    public String readFromFileBlock(Path file) {
        try (BufferedReader bf = new BufferedReader(Files.newBufferedReader(file))) {
            return bf.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new IllegalStateException("File not found");
        }
    }
}
