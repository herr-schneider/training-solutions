package ioreaderclasspath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Country {
    String country;
    int numOfNeighbors;

    public Country(){
        super();
    }

    public Country(String country, int numOfNeighbors) {
        this.country = country;
        this.numOfNeighbors = numOfNeighbors;
    }

    public String getName() {
        return country;
    }

    public int getBorderCountries(){
        return numOfNeighbors;
    }
}
