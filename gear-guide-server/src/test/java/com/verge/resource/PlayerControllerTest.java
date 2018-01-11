package com.verge.resource;

import com.google.common.collect.Lists;
import com.verge.dto.PlayerInfo;
import com.verge.service.PlayerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class PlayerControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    @InjectMocks
    PlayerController controller;

    @Mock
    PlayerService service;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).dispatchOptions(true).build();
        when(service.findAll()).thenReturn(Lists.newArrayList(createPlayerInfo()));
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/players"))
                .andExpect(status().isOk());

        //assertThat(dtos.size(), equalTo(1));
    }

    public PlayerInfo createPlayerInfo() {
        PlayerInfo dto = new PlayerInfo();
        dto.setName("Jimmy");
        dto.setDescription("Led Zeppelin");
        return dto;
    }
}
