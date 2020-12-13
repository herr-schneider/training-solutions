package week07d05;

public class SaveInputTest {

    public static void main(String[] args) {
        SaveInput s = new SaveInput();
        s.input("1", "2","./src/main/java/week07d05/file.txt");
        s.fileReader("./src/main/java/week07d05/file.txt",".");
    }
}
