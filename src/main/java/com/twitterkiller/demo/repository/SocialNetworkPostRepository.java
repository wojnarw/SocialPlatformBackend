package com.twitterkiller.demo.repository;

import com.twitterkiller.demo.entity.SocialNetworkPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

public interface SocialNetworkPostRepository extends JpaRepository<SocialNetworkPost, Long> {

    List<SocialNetworkPost> getReferenceByAuthor(String author);
    List<SocialNetworkPost> findTop10ByOrderByViewCountDesc();
//    List<SocialNetworkPost> findTop10ByOrderByViewCountDescContentLike();
//    @Query("select * from posts where content like '%:text%' limit 10")
//    List<SocialNetworkPost> findByName(@Param("text") String text);
//    int countAllByAuthor(String author);
//    Page<SocialNetworkPost> findAllByAuthor(String author, Pageable pageable);
//    List<SocialNetworkPost> findAllByAuthor(String author);

}