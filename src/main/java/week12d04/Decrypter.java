package week12d04;

import java.io.*;
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
            InputStream inputStream = Decrypter.class.getResourceAsStream("/secret.dat"); // resource csak olvasas, nincs irás az alkalmazas resources konyvtarabe
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

    public void bestSolution() {
        Path path = Path.of("secret.dat");
        try {
            byte[] bytes = Files.readAllBytes(path);
            for (byte b : bytes) {
                char c = (char) (b + 10);
                System.out.print(c);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public String bestSolutionStringBuilder() {
        StringBuilder sb = new StringBuilder();
        Path path = Path.of("secret.dat");
        try {
            byte[] bytes = Files.readAllBytes(path);
            for (byte b : bytes) {
                char c = (char) (b + 10);
                sb.append(c);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return sb.toString();
    }

    public String bestSolutionStringPieced() {
        StringBuilder sb = new StringBuilder();
        Path path = Path.of("secret.dat");
        try (InputStream is = Files.newInputStream(path)) {
            byte[] buffer = new byte[100]; // eles 64k buffer
            int size;
            while ((size = is.read()) > 0) {
                System.out.println(size);
                for (int i = 0; i < size; i++) {
                    char c = (char) (buffer[i] + 10);
                    sb.append(c);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return sb.toString();
    }

    public void ReadWriterByte(Path source, Path destination) {

        StringBuilder sb = new StringBuilder();
        Path path = Path.of("secret.dat");
        try (InputStream is = Files.newInputStream(source);
             OutputStream os = Files.newOutputStream(destination)) {
            byte[] buffer = new byte[100]; // eles 64k buffer
            int size;
            while ((size = is.read()) > 0) {
                System.out.println(size);
                for (int i = 0; i < size; i++) {
                    char c = (char) (buffer[i] + 10);
                    os.write(c);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public void ReadWriterString(Path source, Path destination) {
        try (InputStream is = Files.newInputStream(source);
             Writer os = Files.newBufferedWriter(destination)) {
            byte[] buffer = new byte[100]; // eles 64k buffer
            int size;
            while ((size = is.read()) > 0) {
                System.out.println(size);
                for (int i = 0; i < size; i++) { // fontos, hogy csak a size-ig meg a ciklus
                    char c = (char) (buffer[i] + 10);
                    os.write(Character.toString(c));
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}