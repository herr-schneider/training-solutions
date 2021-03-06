package ioreadstring.names;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    final Charset latin1 = Charset.forName("ISO-8859-1");
    final Charset latin2 = Charset.forName("ISO-8859-2");
    final Charset utf8 = StandardCharsets.UTF_8;
    private Path pathOfFile;
    String separator;
    List<Human> humans = new ArrayList<>();

    {
        separator = FileSystems.getDefault().getSeparator();
    }

    // Path file = Path.of("employees").resolve("a.dat");

    public FileManager(String pof) {
        this.pathOfFile = Path.of(pof);
    }

    public boolean isFileNotExist() {
        return !Files.isRegularFile(pathOfFile);
    }

    public void readFromFile() {
        if (isFileNotExist()) {throw new IllegalArgumentException("The file is not exist!");}
        try {
            List<String> employees = Files.readAllLines(pathOfFile, utf8);
            for (String str : employees) {
                String names[] = str.split(" ");
                humans.add(new Human(names[0], names[1]));
            }
        } catch (
                IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public Path getMyFile() {
        return pathOfFile;
    }

    public List<Human> getHumans() {
        return humans;
    }


}
