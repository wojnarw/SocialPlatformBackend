package com.twitterkiller.demo.controller;

import com.twitterkiller.demo.entity.SocialNetworkPost;
import com.twitterkiller.demo.service.SocialNetworkPostServiceDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MainController {
    private final SocialNetworkPostServiceDb postRepository;

    @Autowired
    public MainController(SocialNetworkPostServiceDb postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts")
    public List<SocialNetworkPost> getPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/posts/p/{num}")
    public List<SocialNetworkPost> getPage(@PathVariable int num) {
        int pageSize = 20;
        int pageNumber = num - 1; // page 1 should be the first page
        if(pageNumber < 0) return null;
        return postRepository.getPostsPage(pageSize, pageNumber);
    }

    @GetMapping("/top")
    public List<SocialNetworkPost> showTop10Posts() {
        return postRepository.findTop10ByOrderByViewCountDesc();
    }

    @GetMapping("/generate")
    public String generateDummyData() {
        List<SocialNetworkPost> posts = Arrays.asList(
                new SocialNetworkPost("admin", "first post!", 1),
                new SocialNetworkPost("some_user", "Second post", 3),
                new SocialNetworkPost("some_other_user", "the third and the longest post", 5),
                new SocialNetworkPost("fdgfdg", "safsa", 2),
                new SocialNetworkPost("some_other_user", "safasfs", 20),
                new SocialNetworkPost("4564", "the dsfs and the longest post", 11),
                new SocialNetworkPost("some_other_user", "the sdfsd and the longest post", 100),
                new SocialNetworkPost("jt5655", "the sdf and the longest post", 0),
                new SocialNetworkPost("some_other_user", "the sdf and the longest post", 0),
                new SocialNetworkPost("some_other_user", "the sdf and the longest post", 99),
                new SocialNetworkPost("00000", "the sdfdsf and the longest post", 1)
        );
        postRepository.saveAll(posts);
        return "dummy data inserted! Length: " + posts.size();
    }

    @GetMapping("/post/{id}")
    public SocialNetworkPost getPost(@PathVariable Long id) {
        SocialNetworkPost post = postRepository.findById(id);
        if(post != null) {
            post.setViewCount(post.getViewCount() + 1);
            postRepository.save(post);
        }
        return post;
    }

    @GetMapping("/author/{name}")
    public List<SocialNetworkPost> getPostsByAuthor(@PathVariable String name) {
        return postRepository.getLastTenByAuthor(name);
    }
}