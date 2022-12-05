package com.twitterkiller.demo.service;

import com.twitterkiller.demo.entity.SocialNetworkPost;
import java.util.List;

public interface SocialNetworkPostService {

    SocialNetworkPost save(SocialNetworkPost post);
    void delete(SocialNetworkPost post);
    void update(SocialNetworkPost post);
    SocialNetworkPost findOneById(Long id);
    List<SocialNetworkPost> findAll();
    int countAllByAuthor(String author);
    List<SocialNetworkPost> findAllByAuthor(String author);
    List<SocialNetworkPost> getLastTenByAuthor(String author);
    int count();
}

