package week15d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PostFinderTest {

    @Test
    public void testPost() {
        Post postman = new Post("postman st 12.", LocalDate.of(2020, 12, 30), "com", "Feri");
        Post jozsi = new Post("valami u. 14.", LocalDate.of(2020, 12, 29), "com", "Jozsi");
        Post pisti = new Post("hgt u. 12.", LocalDate.of(2020, 6, 30), "com", "Pisti");
        Post dani = new Post("pohos u. 32", LocalDate.of(2020, 8, 30), "com", "Dani");
        Post vlk = new Post("postman", LocalDate.of(2020, 11, 30), "com", "Feri");
        PostFinder pf = new PostFinder(List.of(postman, jozsi, pisti, dani, vlk));

        assertEquals("[Post{title='postman st 12.', publishedAt=2020-12-30, content='com', owner='Feri'}, Post{title='postman', publishedAt=2020-11-30, content='com', owner='Feri'}]",
                pf.findPostsFor("Feri").toString());
    }

    @Test
    public void testException() {
        Post postman = new Post("postman st 12.", LocalDate.of(2020, 12, 30), "com", "Feri");
        Post jozsi = new Post("valami u. 14.", LocalDate.of(2020, 12, 29), "com", "Jozsi");
        Post pisti = new Post("hgt u. 12.", LocalDate.of(2020, 6, 30), "com", "Pisti");
        Post dani = new Post("pohos u. 32", LocalDate.of(2020, 8, 30), "com", "Dani");
        Post vlk = new Post("postman", LocalDate.of(2020, 11, 30), "com", "Feri");
        PostFinder pf = new PostFinder(List.of(postman, jozsi, pisti, dani, vlk));
        Exception ex = assertThrows(NullPointerException.class, () -> pf.findPostsFor(null));
        Assertions.assertEquals("Hulye vagy!", ex.getMessage());
    }
}