package com.verge.service;

import com.google.common.collect.Lists;
import com.verge.dto.PlayerInfo;
import com.verge.entity.Player;
import com.verge.mapping.PlayerMapper;
import com.verge.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@Service
public class PlayerService {

    private PlayerRepository repository;

    private PlayerMapper mapper;

    @Autowired
    public PlayerService(PlayerRepository repository, PlayerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<PlayerInfo> findAll() {
        List<Player> players = Lists.newArrayList(repository.findAll());
        return players.stream()
                .map(entity -> mapper.entityToDto(entity))
                .collect(Collectors.toList());
    }

    public ResponseEntity<PlayerInfo> findById(Long id) {
        Optional<Player> player = Optional.ofNullable(repository.findOne(id));
        return player.isPresent() ? new ResponseEntity<>(mapper.entityToDto(player.get()), OK) : new ResponseEntity<>(NOT_FOUND);
    }

    public List<PlayerInfo> nameLike(String query) {
        List<Player> players = repository.nameLike(query);
        return players.stream()
                .map(entity -> mapper.entityToDto(entity))
                .collect(Collectors.toList());
    }
}
