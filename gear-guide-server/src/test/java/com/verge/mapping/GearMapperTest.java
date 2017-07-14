package com.verge.mapping;

import com.verge.dto.AmplifierInfo;
import com.verge.dto.GuitarInfo;
import com.verge.entity.Amplifier;
import com.verge.entity.Guitar;
import com.verge.repository.ManufacturerRepository;
import com.verge.type.HasImg;
import com.verge.utiliities.ImgSrcResolver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import static com.verge.testutils.TestUtils.DESCRIPTION;
import static com.verge.testutils.TestUtils.GIBSON;
import static com.verge.testutils.TestUtils.GIBSON_ID;
import static com.verge.testutils.TestUtils.IMAGE;
import static com.verge.testutils.TestUtils.IMG_SRC;
import static com.verge.testutils.TestUtils.PICKUPS;
import static com.verge.testutils.TestUtils.SCALE;
import static com.verge.testutils.TestUtils.VALVES;
import static com.verge.testutils.TestUtils.createAmplifier;
import static com.verge.testutils.TestUtils.createAmplifierInfo;
import static com.verge.testutils.TestUtils.createGuitar;
import static com.verge.testutils.TestUtils.createGuitarInfo;
import static com.verge.testutils.TestUtils.createManufacturer;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GearMapperTest {

    @InjectMocks
    private GearMapper<Guitar, GuitarInfo> guitarMapper;

    @InjectMocks
    private GearMapper<Amplifier, AmplifierInfo> ampMapper;

    @Mock
    private ImgSrcResolver imgSrcResolver;

    @Spy
    private ModelMapper modelMapper;

    @Mock
    private ManufacturerRepository repository;

    @Before
    public void setUp() {
        when(repository.findOne(anyLong())).thenReturn(createManufacturer(GIBSON));
        when(imgSrcResolver.resolveImgSrc(any(HasImg.class))).thenReturn(IMG_SRC);
    }

    @Test
    public void testGuitarToGuitarInfo() {
        GuitarInfo dto = guitarMapper.entityToDto(createGuitar("Gibson", "Les Paul"), GuitarInfo.class);
        assertThat(dto.getId(), equalTo(1L));
        assertThat(dto.getManufacturer().getId(), equalTo(GIBSON_ID));
        assertThat(dto.getManufacturer().getName(), equalTo(GIBSON));
        assertThat(dto.getModel(), equalTo("Les Paul"));
        assertThat(dto.getDescription(), equalTo(DESCRIPTION));
        assertThat(dto.getPickups(), equalTo(PICKUPS));
        assertThat(dto.getScale(), equalTo(SCALE));
        assertThat(dto.getImage(), equalTo(IMG_SRC));
    }

    @Test
    public void testGuitarInfoToGuitar() {
        Guitar entity = guitarMapper.dtoToEntity(createGuitarInfo("Gibson", "Les Paul"), Guitar.class);
        assertThat(entity.getId(), equalTo(1L));
        assertThat(entity.getManufacturer().getName(), equalTo(GIBSON));
        assertThat(entity.getManufacturer().getId(), equalTo(GIBSON_ID));
        assertThat(entity.getModel(), equalTo("Les Paul"));
        assertThat(entity.getDescription(), equalTo(DESCRIPTION));
        assertThat(entity.getPickups(), equalTo(PICKUPS));
        assertThat(entity.getScale(), equalTo(SCALE));
        assertThat(entity.getImage(), equalTo(IMAGE));
    }

    @Test
    public void testAmplifierToAmplifierInfo() {
        AmplifierInfo dto = ampMapper.entityToDto(createAmplifier("Fender", "Twin Reverb"), AmplifierInfo.class);
        assertThat(dto.getId(), equalTo(2L));
        assertThat(dto.getManufacturer().getId(), equalTo(GIBSON_ID));
        assertThat(dto.getManufacturer().getName(), equalTo("Fender"));
        assertThat(dto.getModel(), equalTo("Twin Reverb"));
        assertThat(dto.getDescription(), equalTo(DESCRIPTION));
        assertThat(dto.getValves(), equalTo(VALVES));
        assertThat(dto.getImage(), equalTo(IMG_SRC));
    }

    @Test
    public void testAmplifierInfoToAmplifier() {
        Amplifier entity = ampMapper.dtoToEntity(createAmplifierInfo(GIBSON, "Skylark"), Amplifier.class);
        assertThat(entity.getId(), equalTo(2L));
        assertThat(entity.getManufacturer().getId(), equalTo(GIBSON_ID));
        assertThat(entity.getManufacturer().getName(), equalTo(GIBSON));
        assertThat(entity.getDescription(), equalTo(DESCRIPTION));
        assertThat(entity.getValves(), equalTo(VALVES));
        assertThat(entity.getImage(), equalTo(IMAGE));
    }

}
