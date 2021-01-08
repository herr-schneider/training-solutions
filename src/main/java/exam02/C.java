package exam02;

public class C extends B{

    public C(){
        i=i+1;
    }

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.i);
    }
}
