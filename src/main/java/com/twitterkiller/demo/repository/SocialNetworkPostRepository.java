package com.twitterkiller.demo.repository;

import com.twitterkiller.demo.entity.SocialNetworkPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocialNetworkPostRepository extends JpaRepository<SocialNetworkPost, Long> {

    List<SocialNetworkPost> getReferenceByAuthor(String author);

    List<SocialNetworkPost> findTop10ByOrderByViewCountDesc();

    List<SocialNetworkPost> findAllByAuthorOrderByViewCount(String author);

    List<SocialNetworkPost> findAllByAuthor(String author);

    Page<SocialNetworkPost> findAllByAuthor(String author, Pageable pageable);

//    List<SocialNetworkPost> findTop10ByOrderByViewCountDescContentLike();
//    @Query("select * from posts where content like '%:text%' limit 10")
//    List<SocialNetworkPost> findByName(@Param("text") String text);
//    int countAllByAuthor(String author);
//    Page<SocialNetworkPost> findAllByAuthor(String author, Pageable pageable);
//    List<SocialNetworkPost> findAllByAuthor(String author);

}