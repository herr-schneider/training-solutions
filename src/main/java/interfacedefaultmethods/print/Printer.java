package interfacedefaultmethods.print;

public class Printer {

    public String print(Printable printable) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < printable.getLength(); i++) {
            if (printable.getColor(i) != "#000000"){result.append("["+printable.getColor(i)+"]");}
            result.append(printable.getPage(i)+"\n");
        }
        return result.toString();
    }
}
