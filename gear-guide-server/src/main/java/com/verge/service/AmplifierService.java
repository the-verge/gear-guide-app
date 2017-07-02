package com.verge.service;

import com.google.common.collect.Lists;
import com.verge.dto.AmplifierInfo;
import com.verge.entity.Amplifier;
import com.verge.mapping.AmplifierMapper;
import com.verge.repository.AmplifierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;


@Service
public class AmplifierService {

    private AmplifierRepository repository;

    private AmplifierMapper mapper;

    @Autowired
    public AmplifierService(AmplifierRepository repository, AmplifierMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<AmplifierInfo> findAll() {
        return mapper.entitiesToDtos(Lists.newArrayList(repository.findAll()));
    }

    public ResponseEntity<AmplifierInfo> findById(Long id) {
        Optional<Amplifier> guitar = Optional.ofNullable(repository.findOne(id));
        return guitar.isPresent() ? new ResponseEntity<>(mapper.entityToDto(guitar.get()), OK) : new ResponseEntity<>(NOT_FOUND);
    }
}
