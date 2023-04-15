package com.jsuryakt.postservice.service;

import com.jsuryakt.postservice.entity.Post;
import com.jsuryakt.postservice.entity.Response;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    Response createPost(Post post);
    Response getPosts();
    Response getPostById(Long id);
    Response updatePost(Long id, Post post);
    Response deletePost(Long id);
}
