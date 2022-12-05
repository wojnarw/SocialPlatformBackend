package com.twitterkiller.demo;

import com.twitterkiller.demo.service.SocialNetworkPostServiceDb;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SocialNetworkPostRepositoryTest {

    @Autowired
    private SocialNetworkPostServiceDb postServiceDb;

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(postServiceDb).isNotNull();
    }
}