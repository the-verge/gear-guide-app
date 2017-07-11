package com.verge.resource;

import com.verge.BaseITest;
import com.verge.dto.AmplifierInfo;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.verge.utiliities.GearUtils.getModels;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

public class AmplifierControllerITest extends BaseITest {

    @Autowired
    private AmplifierController controller;

    @Test
    @FlywayTest
    public void testFindAll() {
        List<AmplifierInfo> dtos = controller.findAll();
        assertThat(dtos.size(), equalTo(7));
        assertThat(getModels(dtos), containsInAnyOrder("JTM45", "1962", "1959", "Bassman", "Deluxe Reverb", "AC30", "JCM800"));
    }

    @Test
    @FlywayTest
    public void testFindById() {
        ResponseEntity<AmplifierInfo> response = controller.findById(1L);
        AmplifierInfo dto = response.getBody();
        assertThat(dto.getManufacturer().getName(), equalTo("Marshall"));
        assertThat(dto.getModel(), equalTo("JTM45"));
        assertTrue(dto.getDescription().startsWith("The JTM series was a relatively short-lived reissue of the original Marshall amps"));
        assertThat(dto.getValves(), equalTo("12AX7s in the preamp section KT66s in the power section"));
        assertTrue(dto.getImage().endsWith("marshall-jtm45.png"));
    }
}
