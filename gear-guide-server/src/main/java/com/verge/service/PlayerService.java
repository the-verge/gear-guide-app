package com.verge.service;

import com.google.common.collect.Lists;
import com.verge.dto.PlayerInfo;
import com.verge.entity.Player;
import com.verge.mapping.PlayerMapper;
import com.verge.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Autowired
    private PlayerMapper mapper;

    public List<PlayerInfo> findAll() {
        List<Player> players = Lists.newArrayList(repository.findAll());
        return players.stream()
                .map(entity -> mapper.entityToDto(entity))
                .collect(Collectors.toList());
    }

    public PlayerInfo findById(Long id) {
        Player player = repository.findOne(id);
        return mapper.entityToDto(player);
    }

    public List<PlayerInfo> nameLike(String query) {
        List<Player> players = repository.nameLike(query);
        return players.stream()
                .map(entity -> mapper.entityToDto(entity))
                .collect(Collectors.toList());
    }
}
