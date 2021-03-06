package com.verge.service;

import com.google.common.collect.Lists;
import com.verge.dto.GuitarInfo;
import com.verge.entity.Guitar;
import com.verge.mapping.GearMapper;
import com.verge.repository.GuitarRepository;
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


@Service
public class GuitarService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GuitarService.class);

    private GuitarRepository repository;

    private GearMapper<Guitar, GuitarInfo> mapper;

    private ImageService imageService;

    @Autowired
    public GuitarService(GuitarRepository repository, GearMapper<Guitar, GuitarInfo> mapper, ImageService imageService) {
        this.repository = repository;
        this.mapper = mapper;
        this.imageService = imageService;
    }

    public List<GuitarInfo> findAll() {
        return mapper.entitiesToDtos(Lists.newArrayList(repository.findAll()), GuitarInfo.class);
    }

    public ResponseEntity findById(Long id) {
        Optional<Guitar> guitar = Optional.ofNullable(repository.findOne(id));
        if (guitar.isPresent()) {
            GuitarInfo guitarInfo = mapper.entityToDto(guitar.get(), GuitarInfo.class);
            return Responses.ok(guitarInfo);
        } else {
            return Responses.notFound();
        }
    }

    @Transactional
    public ResponseEntity create(GuitarInfo guitarInfo, MultipartFile image) {
        String imageName;
        try {
            imageName = imageService.save(image);
        } catch (ImageSaveException e) {
            LOGGER.error(e.getMessage(), e);
            return Responses.internalServerError(e.getMessage());
        }
        guitarInfo.setImage(imageName);
        Guitar guitar = mapper.dtoToEntity(guitarInfo, Guitar.class);
        guitar = repository.save(guitar);

        return Responses.created(mapper.entityToDto(guitar, GuitarInfo.class));
    }
}
