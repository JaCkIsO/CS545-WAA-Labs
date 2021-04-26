package edu.miu.controller;

import edu.miu.domain.Post;
import edu.miu.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/")
    public List<Post> getAll(){
        return postService.getAll();
    }
    @GetMapping("/{id}")
    public Post getById(@PathVariable long id){
        return postService.getById(id);
    }
    @PostMapping("/")
    public boolean save(@RequestBody Post post){
        return postService.save(post);
    }
    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable long id){
        return postService.deleteById(id);
    }
}