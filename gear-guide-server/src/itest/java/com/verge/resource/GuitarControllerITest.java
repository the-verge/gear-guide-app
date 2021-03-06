package com.verge.resource;


import com.google.gson.Gson;
import com.verge.BaseITest;
import com.verge.dto.GuitarInfo;
import com.verge.dto.ManufacturerInfo;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.List;

import static com.verge.utiliities.GearUtils.getModels;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.notNullValue;
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
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        GuitarInfo dto = response.getBody();
        assertThat(dto.getManufacturer().getName(), equalTo("Gibson"));
        assertThat(dto.getModel(), equalTo("Les Paul Standard"));
        assertTrue(dto.getDescription().startsWith("The Gibson Les Paul is simply one of the most iconic guitars in rock history."));
        assertThat(dto.getPickups(), equalTo("Originally released with P-90s but the definitive configuration came into being in 1958 with the first double humbucker model."));
        assertThat(dto.getScale(), equalTo(24.75));
        assertTrue(dto.getImage().endsWith("les-paul-standard.png"));
    }

    @Test
    @FlywayTest
    public void testCreate() throws IOException, URISyntaxException {
        String details = new Gson().toJson(createGuitarInfo("ES-335"));

        InputStream inputStream = getClass().getResourceAsStream("/guitar.png");
        File image = new File("guitar.png");
        MultipartFile multipartFile = new MockMultipartFile("image", image.getName(), "image/png", inputStream);

        ResponseEntity<GuitarInfo> response = controller.create(details, multipartFile);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));

        GuitarInfo created = response.getBody();

        assertThat(created.getId(), notNullValue());
        assertThat(created.getModel(), equalTo("ES-335"));
        assertThat(created.getManufacturer().getName(), equalTo("Gibson"));
        assertThat(created.getManufacturer().getId(), equalTo(1L));
        assertThat(created.getDescription(), equalTo("description"));
        assertThat(created.getPickups(), equalTo("pickups"));
        assertThat(created.getScale(), equalTo(24.75));
        assertTrue(created.getImage().endsWith("guitar.png"));
    }

    public static GuitarInfo createGuitarInfo(String model) {
        GuitarInfo guitarInfo = new GuitarInfo();
        guitarInfo.setManufacturer(createManufacturerInfo());
        guitarInfo.setModel(model);
        guitarInfo.setDescription("description");
        guitarInfo.setPickups("pickups");
        guitarInfo.setScale(24.75);
        return guitarInfo;
    }

    public static ManufacturerInfo createManufacturerInfo() {
        return new ManufacturerInfo(1L, "Gibson");
    }

}
