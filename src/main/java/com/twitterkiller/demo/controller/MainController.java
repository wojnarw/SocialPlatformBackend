package com.twitterkiller.demo.controller;

import com.twitterkiller.demo.entity.SocialNetworkPost;
import com.twitterkiller.demo.service.SocialNetworkPostServiceDb;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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
        if (pageNumber < 0) return null;
        return postRepository.getPostsPage(pageSize, pageNumber);
    }

    @GetMapping("/top")
    public List<SocialNetworkPost> showTop10Posts() {
        return postRepository.findTop10ByOrderByViewCountDesc();
    }

    @PostMapping("/post/new")
    public SocialNetworkPost addPost(@RequestBody @Valid SocialNetworkPost post, BindingResult validation) {
        System.out.println(post);
        if (validation.hasErrors()) {
            return null;
        }
        //if post already exists edit it
        Long id = post.getId();
        if (id != null) {
            //authentication not implemented
            return null;
        }

        SocialNetworkPost postWithAllData = postRepository.save(post);
        return postWithAllData;
    }

    @GetMapping("/generate")
    public String generateDummyData() {
        List<SocialNetworkPost> posts = Arrays.asList(
                new SocialNetworkPost("admin", "first post!", 1),
                new SocialNetworkPost("some_user", "Second post", 3),
                new SocialNetworkPost("some_other_user", "the third and the longest post", 5),
                new SocialNetworkPost("The Fourth", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum", 2),
                new SocialNetworkPost("some_other_user", "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum", 20),
                new SocialNetworkPost("u4564", " et dolore magna ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum", 11),
                new SocialNetworkPost("superuser", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum", 100),
                new SocialNetworkPost("jt5655", "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum", 0),
                new SocialNetworkPost("bloutooth_driver", "has failed", 0),
                new SocialNetworkPost("some_other_user", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum", 99),
                new SocialNetworkPost("00000", "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum", 1)
        );
        postRepository.saveAll(posts);
        return "dummy data inserted! Length: " + posts.size();
    }

    @GetMapping("/post/{id}")
    public SocialNetworkPost getPost(@PathVariable Long id) {
        SocialNetworkPost post = postRepository.findById(id);
        if (post != null) {
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