package week12d04;

import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.*;

class DecrypterTest {

    @Test
    public void readFromScream() {
        Decrypter decrypter = new Decrypter();
        System.out.println(decrypter.converter(decrypter.decrypter(decrypter.readFromScream())));
    }
}