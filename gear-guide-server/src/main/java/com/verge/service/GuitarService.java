package com.verge.service;

import com.google.common.collect.Lists;
import com.verge.dto.GuitarInfo;
import com.verge.entity.Guitar;
import com.verge.mapping.GearMapper;
import com.verge.repository.GuitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;


@Service
public class GuitarService {

    private GuitarRepository repository;

    private GearMapper<Guitar, GuitarInfo> mapper;

    @Autowired
    public GuitarService(GuitarRepository repository, GearMapper<Guitar, GuitarInfo> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<GuitarInfo> findAll() {
        return mapper.entitiesToDtos(Lists.newArrayList(repository.findAll()), GuitarInfo.class);
    }

    public ResponseEntity<GuitarInfo> findById(Long id) {
        Optional<Guitar> guitar = Optional.ofNullable(repository.findOne(id));
        return guitar.isPresent() ? new ResponseEntity<>(mapper.entityToDto(guitar.get(), GuitarInfo.class), OK) :
                new ResponseEntity<>(NOT_FOUND);
    }
}
