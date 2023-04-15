package com.jsuryakt.postservice.controller;

import com.jsuryakt.postservice.entity.Post;
import com.jsuryakt.postservice.entity.Response;
import com.jsuryakt.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping(path = "/posts")
    public Response createPost(@Validated @RequestBody Post post) {
        return postService.createPost(post);
    }

    @GetMapping(path = "/posts")
    public Response getPosts() {
        return postService.getPosts();
    }

    @GetMapping(path = "/posts/{id}")
    public Response getPostById(@Validated @PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PutMapping(path = "/posts/{id}")
    public Response updatePost(@Validated @PathVariable Long id, @Validated @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping(path = "/posts/{id}")
    public Response deletePost(@Validated @PathVariable Long id) {
        return postService.deletePost(id);
    }
}
