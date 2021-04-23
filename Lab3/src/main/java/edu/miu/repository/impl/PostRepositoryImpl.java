package edu.miu.repository.impl;

import edu.miu.domain.Post;
import edu.miu.repository.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    List<Post> posts = new ArrayList<>();

    @Override
    public List<Post> getAll() {
        return posts;
    }

    @Override
    public Post getById(long id) {
        return posts.stream().filter(post -> post.getId() == id).findFirst().get();
    }

    @Override
    public boolean save(Post post) {
        post.setId(posts.size() + 1);
        return posts.add(post);
    }

    @Override
    public boolean deleteById(long id) {
        return posts.remove(getById(id));
    }
}
