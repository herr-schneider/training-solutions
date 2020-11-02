package statements;

public class StatementMain {
    public static void main(String[] args) {
    int x = 5 + 6;
    int y = 11 - x;
    int z = 8;
    boolean b;
    boolean c;

    if (x < y) {
        b = false;
    } else {
        b = true;}
    z++;

        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(b);
        System.out.println(x > y);
        c = b || (z > 5);
        System.out.println(c);/* Definiálj egy boolean típusú c változót, mely értéke true,
        ha a b értéke true, vagy z értéke nagyobb, mint 5. */
    }

}
