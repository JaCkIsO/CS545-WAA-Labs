package edu.miu.service.impl;

import edu.miu.domain.Post;
import edu.miu.repository.PostRepository;
import edu.miu.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> getAll() {
        return postRepository.getAll();
    }

    @Override
    public Post getById(long id) {
        return postRepository.getById(id);
    }

    @Override
    public boolean save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public boolean deleteById(long id) {
        return postRepository.deleteById(id);
    }
}
