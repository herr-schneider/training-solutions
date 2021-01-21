package week12d04;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Decrypter {

    public byte[] readFromFile(String pathString) {
        Path file = Path.of(pathString);
        byte[] data;
        try {
            data = Files.readAllBytes(file);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return data;
    }

    public List<Byte> bufferedReadFromFile(String pathString) {
        Path file = Path.of(pathString);
        List<Byte> result = new ArrayList<>();
        try (InputStream inputStream = new BufferedInputStream(Files.newInputStream(file))) {
            byte[] bytes = new byte[1000];
            int size;
            while ((size = inputStream.read(bytes)) > 0) {
                for (byte b : bytes) {
                    result.add(b);
                }
                System.out.println(size);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return result;
    }

    public byte[] readFromScream() {
        byte[] data;
        try {
            InputStream inputStream = Decrypter.class.getResourceAsStream("/secret.dat");
            data = inputStream.readAllBytes();
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return data;
    }

    public char[] decrypter(byte[] dataset) {
        int position = 0;
        char[] result = new char[dataset.length];
        for (byte data : dataset) {
            result[position] = (char) (data + 10); // cast: tipus kenyszerites
            position++;
        }
        return result;
    }

    public String converter(char[] chars) {
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            result.append(c);
        }
        return result.toString();
    }
}
