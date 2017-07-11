package com.verge.resource;


import com.verge.BaseITest;
import com.verge.dto.GuitarInfo;
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

public class GuitarControllerITest extends BaseITest {

    @Autowired
    private GuitarController controller;

    @Test
    @FlywayTest
    public void testFindAll() {
        List<GuitarInfo> dtos = controller.findAll();
        assertThat(dtos.size(), equalTo(7));
        assertThat(getModels(dtos), containsInAnyOrder(
                "Les Paul Standard", "Les Paul Custom", "SG Standard", "SG Custom",
                "Flying V", "Standard Telecaster", "Standard Stratocaster"));
    }

    @Test
    @FlywayTest
    public void testFindById() {
        ResponseEntity<GuitarInfo> response = controller.findById(1L);
        GuitarInfo dto = response.getBody();
        assertThat(dto.getManufacturer().getName(), equalTo("Gibson"));
        assertThat(dto.getModel(), equalTo("Les Paul Standard"));
        assertTrue(dto.getDescription().startsWith("The Gibson Les Paul is simply one of the most iconic guitars in rock history."));
        assertThat(dto.getPickups(), equalTo("Originally released with P-90s but the definitive configuration came into being in 1958 with the first double humbucker model."));
        assertThat(dto.getScale(), equalTo(24.75));
        assertTrue(dto.getImage().endsWith("les-paul-standard.png"));
    }
}
