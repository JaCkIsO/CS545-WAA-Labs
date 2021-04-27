package edu.miu.repository;

import edu.miu.domain.Post;
import edu.miu.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT user.posts FROM User user WHERE user.id = :id")
    List<Post> findPostsForUser(long id);

    @Query(value = "SELECT user FROM User user WHERE user.posts.size > 1")
    List<User> findUsersWithMoreThanOnePost();
}
