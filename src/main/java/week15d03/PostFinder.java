package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostFinder {

    private List<Post> posts = new ArrayList<>();

    public PostFinder(List<Post> posts) {
        if (posts.isEmpty()) {
            throw new IllegalArgumentException("Empty list!");
        }
        this.posts = posts;
    }

    public void addPost(Post newOne){
        posts.add(newOne);
    }

    public List<Post> findPostsFor(String user) {
        Objects.requireNonNull(user, "Hulye vagy!"); // hibat dob, ha a user null
        List<Post> result = new ArrayList<>();
        for (Post post : posts) {
            if (post.getPublishedAt() == null){
                throw new IllegalArgumentException("\"Publish at\" is NULL");
            }
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
