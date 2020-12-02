package week06d03;

import java.util.Scanner;

public class WordEraser {

    public String eraseWord (String words, String word) {
        Scanner scanner = new Scanner(words);
        scanner.useDelimiter(" "); // nem kell, mert a space az alapértelmezett limiter
        StringBuilder strBuilder = new StringBuilder();
        String strStream;
        while (scanner.hasNext()) {
            strStream = scanner.next();
            if (!strStream.equals(word)){
                strBuilder.append(strStream + " ");
            }
        }
      return  strBuilder.toString().trim();
     }
}
