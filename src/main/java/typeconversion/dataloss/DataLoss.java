package typeconversion.dataloss;

public class DataLoss {
    public static void main(String[] args) {
    String binNumber, otherBinNumber;
    int n=0;
        for (long l = 1; l < 1000000000; l = l+1) {

            float f = (float) l;

            long i = (long) f;

            long d;

            if (l != i) {
                n = n + 1;
                System.out.println(n + ". result");
                binNumber = Long.toBinaryString(l);
                System.out.println("Long number Before: " + l + " Long to bin: " + binNumber);
                System.out.println("Float number: " + f);
                otherBinNumber = Long.toBinaryString(i);
                System.out.println("Longnumber After: " + i + " Long to bin: " + otherBinNumber);
                d = i - l;
                System.out.println("Difference: " + d);
                if (n == 3) {break;}
            }
        }
        System.out.println(13 << 1);
        System.out.println(13 >> 1);
        System.out.println(16 << 1);
        System.out.println(16 >> 1);
    }
}
