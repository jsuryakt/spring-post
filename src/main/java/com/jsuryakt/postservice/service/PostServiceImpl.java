package com.jsuryakt.postservice.service;

import com.jsuryakt.postservice.constant.PostResponseMsg;
import com.jsuryakt.postservice.entity.Post;
import com.jsuryakt.postservice.entity.Response;
import com.jsuryakt.postservice.repository.PostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Response createPost(Post post) {
        Post createdPost = postRepository.save(post);
        if (createdPost.getId() == null) {
            return new Response(HttpStatus.BAD_REQUEST, PostResponseMsg.ERROR_POST_OPERATION, null);
        }
        return new Response(HttpStatus.CREATED, PostResponseMsg.POST_CREATED, createdPost);
    }

    @Override
    public Response getPosts() {
        List<Post> posts = postRepository.findAll();
        return new Response(HttpStatus.OK, PostResponseMsg.POSTS_RETRIEVED, posts);
    }

    @Override
    public Response getPostById(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            return new Response(HttpStatus.NOT_FOUND, PostResponseMsg.POST_NOT_FOUND, null);
        }
        return new Response(HttpStatus.OK, PostResponseMsg.POST_RETRIEVED, post);
    }

    @Override
    public Response updatePost(Long id, Post post) {
        Post existingPost = postRepository.findById(id).orElse(null);
        if (existingPost == null) {
            return new Response(HttpStatus.NOT_FOUND, PostResponseMsg.POST_NOT_FOUND, null);
        } else {
            post.setId(existingPost.getId());
            Post updatedPost = postRepository.save(post);
            if (updatedPost.getId() == null) {
                return new Response(HttpStatus.BAD_REQUEST, PostResponseMsg.ERROR_POST_OPERATION, null);
            }
            return new Response(HttpStatus.OK, PostResponseMsg.POST_UPDATED, updatedPost);
        }
    }

    @Override
    public Response deletePost(Long id) {
        if (postRepository.findById(id).isEmpty()) {
            return new Response(HttpStatus.BAD_REQUEST, PostResponseMsg.ERROR_POST_OPERATION, null);
        }
        postRepository.deleteById(id);
        if (postRepository.findById(id).isPresent()) {
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR, PostResponseMsg.ERROR_POST_OPERATION, null);
        }
        return new Response(HttpStatus.OK, PostResponseMsg.POST_DELETED, null);
    }
}
