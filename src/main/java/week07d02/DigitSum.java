package week07d02;

public class DigitSum {

    public static int sumOfDigits(int x){
        String strX = "" + x;
        int result =0;
        String control;
        for ( int num = 0; num < strX.length(); num++) {
            control = strX.substring(num,num+1);
            if (control == "-") {throw new IllegalArgumentException("");}
            result = result + Integer.parseInt(control);
        }
        return result;
    }
}
