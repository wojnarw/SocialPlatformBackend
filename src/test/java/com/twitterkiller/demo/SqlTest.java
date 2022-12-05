package com.twitterkiller.demo;

import com.twitterkiller.demo.entity.SocialNetworkPost;
import com.twitterkiller.demo.service.SocialNetworkPostServiceDb;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SqlTest {

    @Autowired
    private SocialNetworkPostServiceDb postServiceDb;

    public SqlTest(SocialNetworkPostServiceDb postServiceDb) {
        this.postServiceDb = postServiceDb;
    }

    @Test
    @Sql("createPosts.sql")
    void whenInitializedByDbUnit_thenFindsByAuthor() {
        List<SocialNetworkPost> posts = postServiceDb.findAllByAuthor("autor");
        assertThat(posts).isNotNull();
    }

    @Test
    @Sql("createPosts.sql")
    void whenInitializedByDbUnit_thenCountTopPosts() {
        List<SocialNetworkPost> posts = postServiceDb.findTop10ByOrderByViewCountDesc();
        assertThat(posts.size()).isEqualTo(10);
    }

}