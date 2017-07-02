package com.verge.repository;

import com.google.common.collect.Lists;
import com.verge.BaseITest;
import com.verge.entity.Player;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.verge.utiliities.PlayerUtils.getNames;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class PlayerRepositoryITest extends BaseITest {

    @Autowired
    private PlayerRepository repository;

    @Test
    @FlywayTest
    public void testFindAll() {
        List<Player> entities = Lists.newArrayList(repository.findAll());
        assertThat(entities.size(), equalTo(6));

        List<String> playerNames = getNames(entities);
        assertThat(playerNames, containsInAnyOrder("Slash", "Jimi Hendrix", "Jimmy Page", "Eric Clapton", "John Mayer", "Keith Richards"));
    }

}
