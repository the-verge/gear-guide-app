package com.verge.mapping;


import com.verge.dto.PlayerInfo;
import com.verge.entity.Player;
import com.verge.utiliities.ImgSrcResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerMapper implements Mapper<Player, PlayerInfo> {

    @Autowired
    private ImgSrcResolver srcResolver;

    @Override
    public PlayerInfo entityToDto(Player entity) {
        PlayerInfo dto = new PlayerInfo();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setImgSrc(srcResolver.resolveImgSrc(entity));

        return dto;
    }

    @Override
    public List<PlayerInfo> entitiesToDtos(Collection<Player> entities) {
        return entities.stream()
                .map(e -> entityToDto(e))
                .collect(Collectors.toList());
    }

    @Override
    public Player dtoToEntity(PlayerInfo dto) {
        return null;
    }

    @Override
    public List<Player> dtosToEntities(Collection<PlayerInfo> dtos) {
        return null;
    }

}
