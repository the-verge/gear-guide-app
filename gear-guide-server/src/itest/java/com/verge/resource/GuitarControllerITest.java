package com.verge.resource;


import com.verge.BaseITest;
import com.verge.dto.GuitarInfo;
import com.verge.dto.ManufacturerInfo;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.verge.testutils.ITestUtils.createRequest;
import static com.verge.testutils.ITestUtils.getFormRestTemplate;
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

    @Ignore
    @Test
    @FlywayTest
    public void testCreate() throws IOException {
        RestTemplate template = getFormRestTemplate();

        GuitarInfo dto = createGuitarInfo("Gibson", "Les Paul");
        HttpEntity<MultiValueMap<String, Object>> request = createRequest(dto, new File("/Users/john/code/gear-guide-app/stoker.png"));

        GuitarInfo result = template.postForObject("http://localhost:8080/api/guitars", request, GuitarInfo.class);
    }

    public static GuitarInfo createGuitarInfo(String manufacturer, String model) {
        GuitarInfo guitarInfo = new GuitarInfo();
        guitarInfo.setManufacturer(createManufacturerInfo(manufacturer));
        guitarInfo.setModel(model);
        guitarInfo.setDescription("desc");
        guitarInfo.setPickups("pick");
        guitarInfo.setScale(24.75);
        guitarInfo.setImage("image");
        return guitarInfo;
    }

    public static ManufacturerInfo createManufacturerInfo(String name) {
        return new ManufacturerInfo(4L, name);
    }

}
