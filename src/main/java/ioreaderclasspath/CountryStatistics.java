package ioreaderclasspath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {
    List<Country> countryList = new ArrayList<>();

    public void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Country.class.getResourceAsStream("/" + fileName)))) {
            String str;
            while ((str = reader.readLine()) != null) {
                String names[] = str.split(" ");
                countryList.add(new Country(names[0], Integer.parseInt(names[1])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        } catch (NumberFormatException nfe) {
            throw new IllegalStateException("It is not a number", nfe);
        }
    }

    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }

    public int numberOFCountries() {
        return countryList.size();
    }

    public Country mostBorderCountries() {
        Country result = new Country();
        int max = Integer.MIN_VALUE;
        for (Country country : countryList){
          if (country.getBorderCountries() > max) {
              result = country;
              max = country.getBorderCountries();
          }
        }
        return result;
    }
}
