package com.twitterkiller.demo.controller;

import com.twitterkiller.demo.entity.SocialNetworkPost;
import com.twitterkiller.demo.repository.SocialNetworkPostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MainController {
    private final SocialNetworkPostRepository postRepository;
//    private final PostJpaRepository postJpaRepository;

    @Autowired
    public MainController(SocialNetworkPostRepository postRepository) {
        this.postRepository = postRepository;
    }
//    public MainController(PostJpaRepository postJpaRepository) {
//        this.postJpaRepository = postJpaRepository;
//    }


    @GetMapping("/posts")
    public List<SocialNetworkPost> showMainPage() {
        List<SocialNetworkPost> posts = Arrays.asList(
                new SocialNetworkPost("admin", "First post!"),
                new SocialNetworkPost("some_user", "Second comment"),
                new SocialNetworkPost("troll", "trolling")
        );
        return posts;
    }

    @GetMapping("/top")
    public List<SocialNetworkPost> showTopPosts() {
        List<SocialNetworkPost> posts = Arrays.asList(
                new SocialNetworkPost("admin", "top post!"),
                new SocialNetworkPost("some_user", "Second top"),
                new SocialNetworkPost("troll", "topper")
        );
        return posts;
    }

    @GetMapping("/generate")
    public String generate() {
        postRepository.save(new SocialNetworkPost("admin", "top post!"));
        postRepository.save(new SocialNetworkPost("some_user", "Second top"));
        postRepository.save(new SocialNetworkPost("troll", "topper"));
        return "inserted!";
    }
//    @GetMapping("/generate2")
//    public String generate2() {
//        postJpaRepository.insert(new SocialNetworkPost("admin", "top post!"));
//        postJpaRepository.insert(new SocialNetworkPost("some_user", "Second top"));
//        postJpaRepository.insert(new SocialNetworkPost("troll", "topper"));
//        return "inserted!";
//    }

    @GetMapping("/post/{id}")
    public SocialNetworkPost getPost(@PathVariable Long id) {
        try {
            SocialNetworkPost post = postRepository.getReferenceById(id);
            post.setViewCount(post.getViewCount() + 1);
            postRepository.save(post);
            return post;
        } catch (EntityNotFoundException e) {
            return null;
        }
    }
}