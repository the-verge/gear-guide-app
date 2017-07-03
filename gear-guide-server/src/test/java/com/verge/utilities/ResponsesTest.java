package com.verge.utilities;

import com.verge.dto.GuitarInfo;
import com.verge.utiliities.Responses;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ResponsesTest {

    @Test
    public void testOkResponse() {
        GuitarInfo dto = new GuitarInfo();
        ResponseEntity<GuitarInfo> response = Responses.ok(dto);
        assertThat(response.getBody(), equalTo(dto));
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void testNotFoundResponse() {
        ResponseEntity response = Responses.notFound();
        assertThat(response.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
    }

    @Test
    public void testCreatedResponse() {
        GuitarInfo dto = new GuitarInfo();
        ResponseEntity<GuitarInfo> response = Responses.created(dto);
        assertThat(response.getBody(), equalTo(dto));
        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));
    }
}
