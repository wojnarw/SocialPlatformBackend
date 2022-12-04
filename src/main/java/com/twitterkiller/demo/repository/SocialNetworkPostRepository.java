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

@Repository
public interface SocialNetworkPostRepository extends JpaRepository<SocialNetworkPost, Long> {
    SocialNetworkPost findByName(String text);
    @Query("select c from SocialNetworkPost c join fetch c.user u")
    List<SocialNetworkPost> find10By

    @Query("select c from SocialNetworkPost c left join fetch c.user left join fetch c.inputFields where c.id = :id")
        //  join fetch t.publications p")
    SocialNetworkPost findOneByIdWithAllData(@Param("id") Long id);
    int countAllByAuthor(String author);
    SocialNetworkPost findOneByIdAndUser(String id);
    Page<SocialNetworkPost> findAllByUser(String author, Pageable pageable);
    List<SocialNetworkPost> findAllByUser(String author);
}