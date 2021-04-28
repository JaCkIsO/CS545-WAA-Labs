package edu.miu.service.impl;

import edu.miu.domain.Post;
import edu.miu.domain.User;
import edu.miu.repository.UserRepository;
import edu.miu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public User getById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<Post> getUserPosts(long id) {
        return userRepository.findPostsForUser(id);
    }

    @Override
    public List<User> getUsersWithMoreThanOnePost() {
        return userRepository.findUsersWithMoreThanOnePost();
    }
}
