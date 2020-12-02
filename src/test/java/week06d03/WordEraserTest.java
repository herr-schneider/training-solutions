package week06d03;

import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordEraserTest {
    WordEraser w = new WordEraser();
    WordEraser2 w2 = new WordEraser2();

    @Test
    public void testWordEraser(){
        assertEquals("kakao vaj zsiros kenyer", w.eraseWord("kakao vaj zsiros kenyer tuzolto", "tuzolto") );
    }

    @Test
    public void testWordEraser2(){
        assertEquals("kakao vaj zsiros kenyer", w2.eraseWord("kakao vaj zsiros kenyer tuzolto", "tuzolto") );
    }
}
