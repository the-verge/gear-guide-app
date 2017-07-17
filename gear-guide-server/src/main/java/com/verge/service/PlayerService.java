package com.verge.service;

import com.google.common.collect.Lists;
import com.verge.dto.PlayerInfo;
import com.verge.entity.Player;
import com.verge.mapping.PlayerMapper;
import com.verge.repository.PlayerRepository;
import com.verge.service.image.ImageSaveException;
import com.verge.service.image.ImageService;
import com.verge.utiliities.Responses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@Service
public class PlayerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerService.class);

    private PlayerRepository repository;

    private PlayerMapper mapper;

    private ImageService imageService;

    @Autowired
    public PlayerService(PlayerRepository repository, PlayerMapper mapper, ImageService imageService) {
        this.repository = repository;
        this.mapper = mapper;
        this.imageService = imageService;
    }

    public List<PlayerInfo> findAll() {
        List<Player> players = Lists.newArrayList(repository.findAll());
        return mapper.entitiesToDtos(players);
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

    @Transactional
    public ResponseEntity create(PlayerInfo playerInfo, MultipartFile image) {
        String imageName;
        try {
            imageName = imageService.save(image);
        } catch (ImageSaveException e) {
            LOGGER.error(e.getMessage(), e);
            return Responses.internalServerError(e.getMessage());
        }
        playerInfo.setImage(imageName);
        Player player = mapper.dtoToEntity(playerInfo);
        player = repository.save(player);

        return Responses.created(mapper.entityToDto(player));
    }
}
