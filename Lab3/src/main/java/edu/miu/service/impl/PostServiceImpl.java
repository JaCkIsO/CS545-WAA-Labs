package edu.miu.service.impl;

import edu.miu.domain.Post;
import edu.miu.repository.PostRepository;
import edu.miu.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> getAll() {
        return StreamSupport.stream(postRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Post getById(long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deleteById(long id) {
        postRepository.deleteById(id);
    }
}
