package com.verge.mapping;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.verge.dto.AmplifierInfo;
import com.verge.dto.GuitarInfo;
import com.verge.dto.PlayerInfo;
import com.verge.entity.Amplifier;
import com.verge.entity.Guitar;
import com.verge.entity.Player;
import com.verge.utiliities.ImgSrcResolver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.List;

import static com.verge.testutils.TestUtils.IMG_SRC;
import static com.verge.testutils.TestUtils.createAmplifier;
import static com.verge.testutils.TestUtils.createAmplifierInfo;
import static com.verge.testutils.TestUtils.createGuitar;
import static com.verge.testutils.TestUtils.createGuitarInfo;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerMapperTest {

    @InjectMocks
    private PlayerMapper playerMapper;

    @Mock
    private ImgSrcResolver imgSrcResolver;

    @Mock
    private GearMapper<Guitar, GuitarInfo> guitarMapper;

    @Mock
    private GearMapper<Amplifier, AmplifierInfo> ampMapper;

    @Spy
    private ModelMapper modelMapper;

    private Guitar lesPaul = guitarEntity("Gibson", "Les Paul");
    private Guitar tele = guitarEntity("Fender", "Telecaster");
    private GuitarInfo lesPaulDto = guitarDto("Gibson", "Les Paul");
    private GuitarInfo teleDto = guitarDto("Fender", "Telecaster");

    @Before
    public void setUp() {
        when(imgSrcResolver.resolveImgSrc(any(Player.class))).thenReturn(IMG_SRC);

        when(guitarMapper.entityToDto(eq(lesPaul), eq(GuitarInfo.class))).thenReturn(lesPaulDto);
        when(guitarMapper.entityToDto(eq(tele), eq(GuitarInfo.class))).thenReturn(teleDto);
    }

    @Test
    public void testEntityToDto() {
        PlayerInfo dto = playerMapper.entityToDto(createPlayer());
        assertThat(dto.getId(), equalTo(1L));
    }

    private Player createPlayer() {
        Player entity = new Player();
        entity.setId(1L);
        entity.setName("Jimmy Page");
        entity.setDescription("Les Paul player");
        entity.setImage("image.png");
        entity.setGuitars(Sets.newHashSet(lesPaul, tele));
        entity.setAmplifiers(Sets.newHashSet(createAmplifier("Marshall", "JTM45"),
                createAmplifier("Fender", "Deluxe Reverb")));

        return entity;
    }

    private PlayerInfo createPlayerInfo() {
        PlayerInfo dto = new PlayerInfo();
        dto.setId(1L);
        dto.setName("Jimmy Page");
        dto.setDescription("Les Paul player");
        dto.setGuitars(getGuitarDtos());
        dto.setAmplifiers(getAmplifierDtos());

        return dto;
    }

    private static Guitar guitarEntity(String manufacturer, String model) {
        return createGuitar(manufacturer, model);
    }

    private static GuitarInfo guitarDto(String manufacturer, String model) {
        return createGuitarInfo(manufacturer, model);
    }

    private static List<GuitarInfo> getGuitarDtos() {
        return Lists.newArrayList(createGuitarInfo("Gibson", "Les Paul"),
                createGuitarInfo("Fender", "Telecaster"));
    }

    private static List<AmplifierInfo> getAmplifierDtos() {
        return Lists.newArrayList(createAmplifierInfo("Marshall", "JTM45"),
                createAmplifierInfo("Fender", "Deluxe Reverb"));
    }
}
