package com.verge.repository;

import com.google.common.collect.Lists;
import com.verge.entity.Player;
import org.flywaydb.test.annotation.FlywayTest;
import org.flywaydb.test.junit.FlywayTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = com.verge.infrastructure.Application.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, FlywayTestExecutionListener.class })
public class PlayerRepositoryITest {

    @Autowired
    private PlayerRepository repository;

    @Test
    @FlywayTest
    public void testFindAll() {
        List<Player> entities = Lists.newArrayList(repository.findAll());
        assertThat(entities.size(), equalTo(6));

        List<String> playerNames = getPlayerNames(entities);
        assertThat(playerNames, containsInAnyOrder("Slash", "Jimi Hendrix", "Jimmy Page", "Eric Clapton", "John Mayer", "Keith Richards"));
    }

    private List<String> getPlayerNames(List<Player> entities) {
        return entities.stream()
                .map(e -> e.getName())
                .collect(Collectors.toList());
    }

}
