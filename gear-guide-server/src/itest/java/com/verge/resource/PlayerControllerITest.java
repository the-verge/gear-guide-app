package com.verge.resource;

import com.google.common.collect.Lists;
import com.verge.BaseITest;
import com.verge.dto.AmplifierInfo;
import com.verge.dto.GuitarInfo;
import com.verge.dto.PlayerInfo;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.verge.utiliities.GearUtils.getModels;
import static com.verge.utiliities.PlayerUtils.getNames;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PlayerControllerITest extends BaseITest {

    @Autowired
    private PlayerController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @FlywayTest
    public void testFindAll() {
        ResponseEntity<PlayerInfo[]> response = restTemplate.getForEntity("/players", PlayerInfo[].class);
        List<PlayerInfo> dtos = Lists.newArrayList(response.getBody());
        assertThat(dtos.size(), equalTo(6));

        List<String> playerNames = getNames(dtos);
        assertThat(playerNames, containsInAnyOrder("Slash", "Jimi Hendrix", "Jimmy Page", "Eric Clapton", "John Mayer", "Keith Richards"));
    }

    @Test
    @FlywayTest
    public void testFindById() {
        ResponseEntity<PlayerInfo> response = restTemplate.getForEntity("/players/1", PlayerInfo.class);
        PlayerInfo dto = response.getBody();

        assertThat(dto.getName(), equalTo("Jimmy Page"));
        assertTrue(dto.getDescription().startsWith("Jimmy Page is the mastermind and sonic architect behind Led Zeppelin"));
        assertTrue(dto.getImage().endsWith("jimmy-page.jpg"));

        List<GuitarInfo> guitars = dto.getGuitars();
        assertThat(guitars.size(), equalTo(3));
        assertThat(getModels(guitars), containsInAnyOrder("Les Paul Standard", "Les Paul Custom", "Standard Telecaster"));

        List<AmplifierInfo> amps = dto.getAmplifiers();
        assertThat(amps.size(), equalTo(3));
        assertThat(getModels(amps), containsInAnyOrder("JTM45", "1959", "AC30"));
    }

}
