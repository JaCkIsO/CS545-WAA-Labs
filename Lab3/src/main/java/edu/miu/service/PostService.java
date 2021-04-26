package edu.miu.service;

import edu.miu.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {

    public List<Post> getAll();
    public Post getById(long id);
    public boolean save(Post post);
    public boolean deleteById(long id);
}