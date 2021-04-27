package edu.miu.controller;

import edu.miu.domain.Post;
import edu.miu.domain.User;
import edu.miu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable long id) {
        return userService.getById(id);
    }

    @PostMapping("/")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getUserPosts(@PathVariable long id) {
        return userService.getUserPosts(id);
    }

    @GetMapping("/with-more-than-one-post")
    public List<User> getUsersWithMoreThanOnePost() {
        return userService.getUsersWithMoreThanOnePost();
    }
}
