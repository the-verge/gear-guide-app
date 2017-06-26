package com.verge.mapping;

import com.verge.dto.GuitarInfo;
import com.verge.entity.Guitar;
import com.verge.utiliities.ImgSrcResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GuitarMapper implements EntityToDto<Guitar, GuitarInfo> {

    private ImgSrcResolver srcResolver;

    private ModelMapper modelMapper;

    @Autowired
    public GuitarMapper(ImgSrcResolver srcResolver, ModelMapper modelMapper) {
        this.srcResolver = srcResolver;
        this.modelMapper = modelMapper;
    }

    @Override
    public GuitarInfo entityToDto(Guitar entity) {
        GuitarInfo dto = modelMapper.map(entity, GuitarInfo.class);
        dto.setImgSrc(srcResolver.resolveImgSrc(entity));
        return dto;
    }

    @Override
    public List<GuitarInfo> entitiesToDtos(Collection<Guitar> entities) {
        return entities.stream()
                .map(e -> entityToDto(e))
                .collect(Collectors.toList());
    }
}
