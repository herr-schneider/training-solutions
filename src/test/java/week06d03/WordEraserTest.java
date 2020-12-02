package week06d03;

import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordEraserTest {
    WordEraser w = new WordEraser();

    @Test
    public void testWordEraser(){
        assertEquals("kakao vaj zsiros kenyer", w.eraseWord("kakao vaj zsiros kenyer tuzolto", "tuzolto") );
    }

}
