package com.verge.mapping;


import com.verge.dto.PlayerInfo;
import com.verge.entity.Player;
import com.verge.utiliities.ImgSrcResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerMapper implements EntityToDto<Player, PlayerInfo> {

    private ImgSrcResolver srcResolver;

    private GearMapper mapper;

    private ModelMapper modelMapper;

    @Autowired
    public PlayerMapper(ImgSrcResolver srcResolver, GearMapper mapper, ModelMapper modelMapper) {
        this.srcResolver = srcResolver;
        this.mapper = mapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public PlayerInfo entityToDto(Player entity) {
        PlayerInfo dto = modelMapper.map(entity, PlayerInfo.class);
        dto.setImgSrc(srcResolver.resolveImgSrc(entity));
        dto.setGuitars(mapper.entitiesToDtos(entity.getGuitars()));
        return dto;
    }

    @Override
    public List<PlayerInfo> entitiesToDtos(Collection<Player> entities) {
        return entities.stream()
                .map(e -> entityToDto(e))
                .collect(Collectors.toList());
    }

}
