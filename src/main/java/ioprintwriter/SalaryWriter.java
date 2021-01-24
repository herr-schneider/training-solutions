package ioprintwriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SalaryWriter {
    List<String> names = new ArrayList<>();

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public void writeNamesAndSalaries(Path fileName) {
        int salary = 0;
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(fileName))) {
            for (String name : names) {
                writer.print(name);
                writer.print(": ");
                switch (name.trim().substring(0, name.indexOf(" "))) {
                    case "Dr.":
                        salary = 500000;
                        break;
                    case "Mrs.":
                    case "Mr.":
                        salary = 200000;
                        break;
                    default:
                        salary = 100000;
                }
                writer.println(salary);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
