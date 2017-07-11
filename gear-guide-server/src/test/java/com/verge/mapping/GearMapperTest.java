package com.verge.mapping;

import com.verge.dto.GuitarInfo;
import com.verge.entity.Guitar;
import com.verge.repository.ManufacturerRepository;
import com.verge.utiliities.ImgSrcResolver;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class GearMapperTest {

    @Autowired
    private GearMapper<Guitar, GuitarInfo> gearMapper;

    @MockBean
    private ImgSrcResolver imgSrcResolver;

    @MockBean
    private ManufacturerRepository repository;

    @Ignore
    @Test
    public void testEntityToDto() {
        gearMapper.entityToDto(null, null);
    }
}
