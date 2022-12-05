package com.twitterkiller.demo.service;

import com.twitterkiller.demo.entity.SocialNetworkPost;

import java.util.List;

public interface SocialNetworkPostService {

    List<SocialNetworkPost> getReferenceByAuthor(String author);
    List<SocialNetworkPost> findTop10ByOrderByViewCountDesc();
    List<SocialNetworkPost> findAllByAuthorOrderByViewCount(String author);
    SocialNetworkPost findById(Long id);
    SocialNetworkPost save(SocialNetworkPost post);
    void saveAll(List<SocialNetworkPost> posts);
    void delete(SocialNetworkPost post);
    void update(SocialNetworkPost post);
    SocialNetworkPost findOneById(Long id);
    List<SocialNetworkPost> findAll();
    List<SocialNetworkPost> findAllByAuthor(String author);
    List<SocialNetworkPost> getPostsPage(int pageSize, int pageNum);
    List<SocialNetworkPost> getLastTenByAuthor(String author);
    int count();

}

