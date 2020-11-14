package enumtype.unit;

import java.util.Scanner;

public class ConverterMain {

    public static void main(String[] args) {
        LengthUnit mm = LengthUnit.MM;
        LengthUnit mm2 = LengthUnit.valueOf("MM");

        /*System.out.println(mm);
        System.out.println(mm2);

        System.out.println(mm.name());
        System.out.println(mm2.name());

        System.out.println(mm.ordinal());
        System.out.println(mm2.ordinal());

        System.out.println(mm.isSI());
        System.out.println(mm2.isSI());

        System.out.println(mm.getValueInMm());
        System.out.println(mm2.getValueInMm()); */

        System.out.println("What unit of measure do you want to convert and for what?");
        System.out.println("For example: 9 mm to inch");
        Scanner scanner = new Scanner(System.in);
        String inputUnit = scanner.nextLine();
        int firstSpace = inputUnit.indexOf(" ");
        int num = Integer.parseInt(inputUnit.substring(0, firstSpace));
        System.out.println(num);
        int secondSpace = inputUnit.indexOf(" ", firstSpace+1);
        String fromUnit = inputUnit.substring(firstSpace+1, secondSpace);
        System.out.println(fromUnit);
        int thirdSpace = inputUnit.indexOf(" ", secondSpace+1);
        String toUnit = inputUnit.substring(thirdSpace+1);
        System.out.println(toUnit);
        double num2 = (double) num;
        Converter converter = new Converter();
        System.out.println(num/LengthUnit.INCH.getValueInMm());
        System.out.println(converter.Converting(num, toUnit));
    }
}

