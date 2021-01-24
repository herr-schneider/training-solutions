package iowriter;

import ioreader.IdManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {
//    Ebben a fájl olvasását és írását is gyakorolhatod.
//    Adott a bands_and_years.txt állomány, melyben zenekarok nevét és alapítási évét találod.
//    Készíts egy metódust melynek a paramétere egy fájl és egy évszám!
//    Ez a metódus ki fogja írni a fájlba az évszámnál régebben alakult zenekarokat.
//    Megoldási javaslat, hogy készíts egy privát metódust, ami kigyűjti ezeket a zenekarokat egy listába.
//    Minden zenekart egy Band objektum reprezentál, melynek attribútumai a név és az évszám.

    private List<Band> bands = new ArrayList<>();

    public void readBandsFromFile(Path inputFile) {
        try (BufferedReader reader = new BufferedReader(Files.newBufferedReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] band = line.split(";");
                bands.add(new Band(band[0], Integer.parseInt(band[1])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File not found");
        }
    }

    public void writeBandsBefore(Path outputFile, int year) {
        try (BufferedWriter writer = new BufferedWriter(Files.newBufferedWriter(outputFile))) {
            for (Band band : bands) {
                if (band.getYear() < year) {
                    writer.write(band.getName() + ";" + String.valueOf(band.getYear()) + "\n"); // valueOf nem kell
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File not found");
        }
    }

}
