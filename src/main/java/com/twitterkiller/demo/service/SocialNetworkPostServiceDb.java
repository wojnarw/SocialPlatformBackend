package com.twitterkiller.demo.service;

import com.twitterkiller.demo.entity.SocialNetworkPost;
import com.twitterkiller.demo.repository.SocialNetworkPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialNetworkPostServiceDb implements SocialNetworkPostService {

    private final SocialNetworkPostRepository postRepository;

    @Autowired
    public SocialNetworkPostServiceDb(SocialNetworkPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<SocialNetworkPost> getReferenceByAuthor(String author) {
        return this.postRepository.getReferenceByAuthor(author);
    }

    @Override
    public List<SocialNetworkPost> findTop10ByOrderByViewCountDesc() {
        return this.postRepository.findTop10ByOrderByViewCountDesc();
    }

    @Override
    public SocialNetworkPost findById(Long id) {
        return this.postRepository.findById(id).orElse(null);
    }

    @Override
    public void saveAll(List<SocialNetworkPost> posts) {
        this.postRepository.saveAll(posts);
    }

    @Override
    public SocialNetworkPost save(SocialNetworkPost post) {
        return this.postRepository.save(post);
    }

    @Override
    public void delete(SocialNetworkPost post) {
        this.postRepository.delete(post);
    }

    @Override
    public void update(SocialNetworkPost post) {
        this.postRepository.save(post);
    }

    @Override
    public SocialNetworkPost findOneById(Long id) {
        return this.postRepository.findById(id).orElse(null);
    }

    @Override
    public List<SocialNetworkPost> findAll() {
        return this.postRepository.findAll();
    }

    @Override
    public List<SocialNetworkPost> findAllByAuthor(String author) {
        return this.postRepository.findAllByAuthor(author);
    }

    @Override
    public List<SocialNetworkPost> getPostsPage(int pageSize, int pageNum) {
        Pageable page = PageRequest.of(pageNum, pageSize, Sort.by("postDate").descending());
        Page<SocialNetworkPost> postsPage = postRepository.findAll(page);
        List<SocialNetworkPost> postsList = postsPage.getContent();
        return postsList;
    }

    @Override
    public List<SocialNetworkPost> findAllByAuthorOrderByViewCount(String author) {
        return this.postRepository.findAllByAuthorOrderByViewCount(author);
    }

    @Override
    public List<SocialNetworkPost> getLastTenByAuthor(String author) {
        Pageable lastTenSortedByDate = PageRequest.of(0, 10, Sort.by("postDate").descending());
        Page<SocialNetworkPost> postsPage = postRepository.findAllByAuthor(author, lastTenSortedByDate);
        List<SocialNetworkPost> postsList = postsPage.getContent();
        return postsList;
    }

    @Override
    public int count() {
        return 0;
    }
}