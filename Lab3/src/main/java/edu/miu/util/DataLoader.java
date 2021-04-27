package edu.miu.util;

import edu.miu.domain.Post;
import edu.miu.domain.User;
import edu.miu.service.PostService;
import edu.miu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        Post post1 = new Post(1, "Hi", "Saying Hi", "Its me.");
        Post post2 = new Post(2, "Hi", "Saying Hi", "Its me.");
        Post post3 = new Post(3, "Hi", "Saying Hi", "Its me.");
        Post post4 = new Post(4, "Hi", "Saying Hi", "Its me.");
        Post post5 = new Post(5, "Hi", "Saying Hi", "Its me.");

        postService.save(post1);
        postService.save(post2);
        postService.save(post3);
        postService.save(post4);
        postService.save(post5);

        User user1 = new User(1, "Sam", Arrays.asList(post1, post2, post3));
        User user2 = new User(1, "Sam", Arrays.asList(post4, post5));

        userService.save(user1);
        userService.save(user2);
    }
}
