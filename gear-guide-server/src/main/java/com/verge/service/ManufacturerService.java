package com.verge.service;

import com.google.common.collect.Lists;
import com.verge.dto.ManufacturerInfo;
import com.verge.entity.Manufacturer;
import com.verge.repository.ManufacturerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManufacturerService {

    private ManufacturerRepository repository;

    private ModelMapper modelMapper;

    @Autowired
    public ManufacturerService(ManufacturerRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public List<ManufacturerInfo> findAll() {
        List<Manufacturer> manufacturers = Lists.newArrayList(repository.findAll());
        return manufacturers.stream()
                .map(m -> modelMapper.map(m, ManufacturerInfo.class))
                .collect(Collectors.toList());
    }
}
