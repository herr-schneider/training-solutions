package week12d03;

import java.io.BufferedReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

//        Készítsd el a week12d03.NumberStat osztályt melyben legyen egy metódus,
//        ami paraméterül vár egy egész számokból álló listát.
//        Add vissza azt a számot amelyik pontosan egyszer szerepel a listában.
//        Ha több ilyen szám van akkor a kisebbet! Ellenőrizd, hogy olyan listát fogadunk el,
//        ami legalább 1 elemű, ha a lista nem ilyen, dobj kivételt!
//        pl: {1,1,5,3,4,5,6,5,6,4,1,6,5,4} A megoldás: 3
//        Bónusz: Módosítsd az osztályt. Legyen egy egész számokból álló lista attribútuma.
//        A fent megírt metódus ezen a listán dolgozzon.
//        A lista elemeit fájlból töltsük fel. A file úgy néz ki,
//        hogy egy sorban három szám van vesszővel elválasztva.

public class NumberStat {
    List<Integer> numbers = new ArrayList<>();


    public int findSmallestUnique() {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("empty");
        }
        if (numbers.size() == 1) {
            return numbers.get(0);
        }
        List<Integer> sortNumbers = new ArrayList<>(numbers);
        Collections.sort(sortNumbers);
        //if (numbers.size() == 2) {
        if (sortNumbers.get(0) != sortNumbers.get(1)) {
            return sortNumbers.get(0);
        } else {
            // throw new IllegalStateException("Wrong list!");
        }
        // }
        for (int i = 1; i < sortNumbers.size(); i++) {
            if (sortNumbers.get(i - 1) != sortNumbers.get(i) && sortNumbers.get(i + 1) != sortNumbers.get(i)) {
                return sortNumbers.get(i);
            }
        }
        if (sortNumbers.get(sortNumbers.size() - 1) != sortNumbers.get(sortNumbers.size() - 2)) {
            return sortNumbers.get(sortNumbers.size() - 1);
        }
        throw new IllegalStateException("");
    }

    public void readFromFile(String filename) {
        Path path = Path.of(filename);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");

            }
        } catch (NoSuchFileException fnfe) {
            throw new IllegalStateException("Cannot load file!");
        } catch (IOException e) {
            throw new IllegalArgumentException("Something went wrong!", e);
        }
    }

    private void addLine(String[] temp) {
        for (String str : temp) {
            numbers.add(Integer.parseInt(str));
        }
    }
}

