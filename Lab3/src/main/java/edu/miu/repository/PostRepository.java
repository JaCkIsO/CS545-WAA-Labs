package edu.miu.repository;

import edu.miu.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PostRepository {

    public List<Post> getAll();
    public Post getById(long id);
    public boolean save(Post post);
    public boolean deleteById(long id);
}
