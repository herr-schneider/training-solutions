package week04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NameChanger {
    String fullName;

    public NameChanger(String fullName) {
        if (fullName == "" || fullName == " " || fullName == null || fullName.isBlank() || fullName.isEmpty()) {
            throw new IllegalArgumentException("Invalid Name!");}
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFirstName(String newFirstName) {
        String[] names = fullName.split(" ");
        fullName = names[0] + " " + newFirstName;
       }


}

