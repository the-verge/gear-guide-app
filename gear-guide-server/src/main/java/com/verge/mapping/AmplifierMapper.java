package com.verge.mapping;

import com.verge.dto.AmplifierInfo;
import com.verge.entity.Amplifier;
import com.verge.utiliities.ImgSrcResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AmplifierMapper implements EntityToDto<Amplifier, AmplifierInfo> {

    private ImgSrcResolver srcResolver;

    private ModelMapper modelMapper;

    @Autowired
    public AmplifierMapper(ModelMapper modelMapper, ImgSrcResolver srcResolver) {
        this.modelMapper = modelMapper;
        this.srcResolver = srcResolver;
    }

    @Override
    public AmplifierInfo entityToDto(Amplifier entity) {
        AmplifierInfo dto = modelMapper.map(entity, AmplifierInfo.class);
        dto.setImgSrc(srcResolver.resolveImgSrc(entity));
        return dto;
    }

    @Override
    public List<AmplifierInfo> entitiesToDtos(Collection<Amplifier> entities) {
        return entities.stream()
                .map(e -> entityToDto(e))
                .collect(Collectors.toList());
    }
}
