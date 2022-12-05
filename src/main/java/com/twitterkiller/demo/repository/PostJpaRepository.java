package com.twitterkiller.demo.repository;

import com.twitterkiller.demo.entity.SocialNetworkPost;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PostJpaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(SocialNetworkPost post) {
        entityManager.merge(post);
    }

    public void update(SocialNetworkPost post) {
        entityManager.merge(post);
    }

    public void deleteById(long id) {
        SocialNetworkPost post = findById(id);
        entityManager.remove(post);
    }

    public SocialNetworkPost findById(long id) {
        return entityManager.find(SocialNetworkPost.class, id);
    }
}
