package school;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Diary {
    final Charset latin1 = Charset.forName("ISO-8859-1");
    final Charset latin2 = Charset.forName("ISO-8859-2");
    final Charset utf8 = StandardCharsets.UTF_8; // csak a gyakorlas kedveert
    final String separator = FileSystems.getDefault().getSeparator();


    public void newMark(Path pathOfFile, int mark) {
        StandardOpenOption option = StandardOpenOption.CREATE;
        if (Files.exists(pathOfFile)) {
            option = StandardOpenOption.APPEND;
        } // nem biztos, hogy kell, kerdezni kell
        try {
            Files.writeString(pathOfFile, String.valueOf(mark)+"\n", utf8, option);
        } catch (
                IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public void average(Path pathOfFile) {
        //if (Files.exists(pathOfFile)) { //         if (Files.exists(pathOfFile))
        //    throw new IllegalArgumentException("The file is not exist!");
        //}
        double quotient = 0.0;
        double divider = 0.0;
        try {
            List<String> marks = Files.readAllLines(pathOfFile, utf8);
            for (String markStr : marks) {
                quotient += Double.parseDouble(markStr);
                divider++;
            }
            Files.writeString(pathOfFile, "average: " + (quotient / divider), StandardOpenOption.APPEND);
        } catch (
                IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

    }

}
