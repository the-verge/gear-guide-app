package com.verge.mapping;

import com.verge.dto.BaseGearInfo;
import com.verge.entity.GearItem;
import com.verge.entity.Manufacturer;
import com.verge.repository.ManufacturerRepository;
import com.verge.utiliities.ImgSrcResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GearMapper<E extends GearItem, D extends BaseGearInfo> implements EntityToDto<E, D>, DtoToEntity<D, E> {

    private ImgSrcResolver srcResolver;

    private ModelMapper modelMapper;

    private ManufacturerRepository repository;

    @Autowired
    public GearMapper(ImgSrcResolver srcResolver, ModelMapper modelMapper, ManufacturerRepository repository) {
        this.srcResolver = srcResolver;
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public D entityToDto(E entity, Class<D> dtoClass) {
        D dto = modelMapper.map(entity, dtoClass);
        dto.setImage(srcResolver.resolveImgSrc(entity));
        return dto;
    }

    @Override
    public List<D> entitiesToDtos(Collection<E> entities, Class<D> dtoClass) {
        return entities.stream()
                .map(e -> entityToDto(e, dtoClass))
                .collect(Collectors.toList());
    }

    @Override
    public E dtoToEntity(D dto, Class<E> entityClass) {
        E entity = modelMapper.map(dto, entityClass);
        Manufacturer manufacturer = repository.findOne(dto.getManufacturer().getId());
        entity.setManufacturer(manufacturer);
        return entity;
    }

    @Override
    public List<E> dtosToEntities(Collection<D> dtos, Class<E> entityClass) {
        return dtos.stream()
                .map(d -> dtoToEntity(d, entityClass))
                .collect(Collectors.toList());
    }
}
