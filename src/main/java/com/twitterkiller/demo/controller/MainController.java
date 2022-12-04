package com.twitterkiller.demo.controller;

import com.twitterkiller.demo.entity.SocialNetworkPost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping
public class MainController {

    @GetMapping
    public List<SocialNetworkPost> showMainPage() {
        List<SocialNetworkPost> posts = Arrays.asList(
                new SocialNetworkPost(new Date(), "admin", "First post!"),
                new SocialNetworkPost(new Date(), "some_user", "Second comment"),
                new SocialNetworkPost(new Date(), "troll", "trolling")
        );
        return posts;
    }

    @GetMapping("/top")
    public List<SocialNetworkPost> showTopPosts() {
        List<SocialNetworkPost> posts = Arrays.asList(
                new SocialNetworkPost(new Date(), "admin", "top post!"),
                new SocialNetworkPost(new Date(), "some_user", "Second top"),
                new SocialNetworkPost(new Date(), "troll", "topper")
        );
        return posts;
    }
}