package edu.miu.service;

import edu.miu.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {

    public List<Post> getAll();
    public Post getById(long id);
    public Post save(Post post);
    public void deleteById(long id);
}
