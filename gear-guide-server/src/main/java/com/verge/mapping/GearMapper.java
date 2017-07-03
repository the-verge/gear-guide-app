package com.verge.mapping;

import com.verge.dto.BaseGearInfo;
import com.verge.type.HasImg;
import com.verge.utiliities.ImgSrcResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GearMapper<E extends HasImg, D extends BaseGearInfo> implements EntityToDto<E, D> {

    private ImgSrcResolver srcResolver;

    private ModelMapper modelMapper;

    @Autowired
    public GearMapper(ImgSrcResolver srcResolver, ModelMapper modelMapper) {
        this.srcResolver = srcResolver;
        this.modelMapper = modelMapper;
    }

    @Override
    public D entityToDto(E entity, Class<D> dtoClass) {
        D dto = modelMapper.map(entity, dtoClass);
        dto.setImgSrc(srcResolver.resolveImgSrc(entity));
        return dto;
    }

    @Override
    public List<D> entitiesToDtos(Collection<E> entities, Class<D> dtoClass) {
        return entities.stream()
                .map(e -> entityToDto(e, dtoClass))
                .collect(Collectors.toList());
    }
}
