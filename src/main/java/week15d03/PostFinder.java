package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostFinder {

    List<Post> posts = new ArrayList<>();

    public List<Post> findPostsFor(String user) {
        List<Post> result = new ArrayList<>();
        for (Post post : posts) {
            if (post.getOwner().equals(user) &&
                    !post.getContent().isEmpty() &&
                    !post.getTitle().isEmpty() &&
                    post.getPublishedAt().isBefore(LocalDate.now())) {
                result.add(post);
            }
        }
        return result;
    }
}
