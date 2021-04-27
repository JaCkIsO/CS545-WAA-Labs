package edu.miu.service;

import edu.miu.domain.Post;
import edu.miu.domain.User;

import java.util.List;

public interface UserService {

    public List<User> getAll();

    public User getById(long id);

    public User save(User user);

    public List<Post> getUserPosts(long id);

    public List<User> getUsersWithMoreThanOnePost();
}
