package com.verge.mapping;


import com.verge.dto.AmplifierInfo;
import com.verge.dto.GuitarInfo;
import com.verge.dto.PlayerInfo;
import com.verge.entity.Amplifier;
import com.verge.entity.Guitar;
import com.verge.entity.Player;
import com.verge.utiliities.ImgSrcResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PlayerMapper {

    private ImgSrcResolver srcResolver;

    private GearMapper<Guitar, GuitarInfo> guitarMapper;

    private GearMapper<Amplifier, AmplifierInfo> amplifierMapper;

    private ModelMapper modelMapper;

    @Autowired
    public PlayerMapper(ImgSrcResolver srcResolver, GearMapper<Guitar, GuitarInfo> guitarMapper,
                        GearMapper<Amplifier, AmplifierInfo> amplifierMapper, ModelMapper modelMapper) {

        this.srcResolver = srcResolver;
        this.guitarMapper = guitarMapper;
        this.amplifierMapper = amplifierMapper;
        this.modelMapper = modelMapper;
    }

    public PlayerInfo entityToDto(Player entity) {
        PlayerInfo dto = modelMapper.map(entity, PlayerInfo.class);
        dto.setImage(srcResolver.resolveImgSrc(entity));
        dto.setGuitars(guitarMapper.entitiesToDtos(entity.getGuitars(), GuitarInfo.class));
        dto.setAmplifiers(amplifierMapper.entitiesToDtos(entity.getAmplifiers(), AmplifierInfo.class));
        return dto;
    }

    public List<PlayerInfo> entitiesToDtos(Collection<Player> entities) {
        return entities.stream()
                .map(e -> entityToDto(e))
                .collect(Collectors.toList());
    }

    public Player dtoToEntity(PlayerInfo dto) {
        Player entity = modelMapper.map(dto, Player.class);
        entity.setGuitars(mapGuitars(dto.getGuitars()));
        entity.setAmplifiers(mapAmplifiers(dto.getAmplifiers()));
        return entity;
    }

    private Set<Guitar> mapGuitars(List<GuitarInfo> dtos) {
        return guitarMapper.dtosToEntities(dtos, Guitar.class);
    }

    private Set<Amplifier> mapAmplifiers(List<AmplifierInfo> dtos) {
        return amplifierMapper.dtosToEntities(dtos, Amplifier.class);
    }

}
