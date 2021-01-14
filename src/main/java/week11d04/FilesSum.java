package week11d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {

    /*public int sumNumbers(InputStream input){
        Path file = Path.of("employees.txt");
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    } */
    public int sumNumbers() {
        int result = 0;
        String eleresi;
        String temp;
        for (int i = 1; i < 100; i++) {
            if (i<10){eleresi = "src/main/java/week11d04/number0" + i + ".txt";}
            else{eleresi = "src/main/java/week11d04/number" + i + ".txt";}
            if (Files.isRegularFile(Path.of(eleresi))) {
                try{
                    temp = Files.readString(Path.of(eleresi));
                    result += Integer.parseInt(temp);
                } catch (IOException ioe) {
                 throw new IllegalArgumentException("Fájl hiba", ioe);
                };
            }
        }
      return result;
    }

    public static void main(String[] args) {

        FilesSum fs = new FilesSum();
        System.out.println(fs.sumNumbers());
    }
}
