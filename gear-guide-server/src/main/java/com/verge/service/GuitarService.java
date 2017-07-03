package com.verge.service;

import com.google.common.collect.Lists;
import com.verge.dto.GuitarInfo;
import com.verge.entity.Guitar;
import com.verge.mapping.GearMapper;
import com.verge.repository.GuitarRepository;
import com.verge.utiliities.Responses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
        if (guitar.isPresent()) {
            GuitarInfo guitarInfo = mapper.entityToDto(guitar.get(), GuitarInfo.class);
            return Responses.ok(guitarInfo);
        } else {
            return Responses.notFound();
        }
    }

    public ResponseEntity<GuitarInfo> create(GuitarInfo guitarInfo) {
        Guitar guitar = mapper.dtoToEntity(guitarInfo, Guitar.class);
        guitar = repository.save(guitar);
        return Responses.created(mapper.entityToDto(guitar, GuitarInfo.class));
    }
}
