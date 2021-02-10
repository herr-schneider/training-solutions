package week15d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostFinder {

    private List<Post> posts = new ArrayList<>();

    public PostFinder(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post newOne){
        posts.add(newOne);
    }

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
