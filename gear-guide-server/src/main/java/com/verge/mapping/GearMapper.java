package com.verge.mapping;

import com.verge.dto.GearInfo;
import com.verge.entity.Guitar;
import com.verge.utiliities.ImgSrcResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GearMapper implements EntityToDto<Guitar, GearInfo> {

    private ImgSrcResolver srcResolver;

    private ModelMapper modelMapper;

    @Autowired
    public GearMapper(ImgSrcResolver srcResolver, ModelMapper modelMapper) {
        this.srcResolver = srcResolver;
        this.modelMapper = modelMapper;
    }

    @Override
    public GearInfo entityToDto(Guitar entity) {
        GearInfo dto = modelMapper.map(entity, GearInfo.class);
        dto.setImgSrc(srcResolver.resolveImgSrc(entity));
        return dto;
    }

    @Override
    public List<GearInfo> entitiesToDtos(Collection<Guitar> entities) {
        return entities.stream()
                .map(e -> entityToDto(e))
                .collect(Collectors.toList());
    }
}
