//package com.twitterkiller.demo.service;
//
//import com.twitterkiller.demo.entity.SocialNetworkPost;
////import com.twitterkiller.demo.repository.SocialNetworkPostRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Set;
//
//@Service
//public class SocialNetworkPostServiceDb implements SocialNetworkPostService {
//
//    private SocialNetworkPostRepository postRepository;
//
//    @Autowired
//    public SocialNetworkPostServiceDb(SocialNetworkPostRepository postRepository) {
//        this.postRepository = postRepository;
//    }
//
//    @Override
//    public SocialNetworkPost save(SocialNetworkPost post) {
//        return this.postRepository.save(post);
//    }
//
//    @Override
//    public void delete(SocialNetworkPost post) {
//        this.postRepository.delete(post);
//    }
//
//    @Override
//    public void update(SocialNetworkPost post) {
//        this.postRepository.update(post);
//    }
//
//    @Override
//    public SocialNetworkPost findOneById(Long id) {
//        return this.postRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public List<SocialNetworkPost> findAll() {
//        return this.postRepository.findAll();
//    }
//
//    @Override
//    public int countAllByAuthor(String author) {
//        return this.postRepository.countAllByAuthor(author);
//    }
//
//    @Override
//    public List<SocialNetworkPost> findAllByAuthor(String author) {
//        return this.postRepository.findAllByAuthor(author);
//    }
//
//    @Override
//    public List<SocialNetworkPost> getLastTenByAuthor(String author) {
//        Pageable lastTenSortedByDate = PageRequest.of(0, 5, Sort.by("postDate").descending());
//        Page<SocialNetworkPost> postsPage = postRepository.findAllByAuthor(author, lastTenSortedByDate);
//        List<SocialNetworkPost> postsList = postsPage.getContent();
//        return postsList;
//    }
//
//    @Override
//    public int count() {
//        return 0;
//    }
//}