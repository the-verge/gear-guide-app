package com.verge.mapping;

import com.verge.dto.BaseGearInfo;
import com.verge.type.HasImg;

import java.util.Collection;
import java.util.List;

public interface EntityToDto<E extends HasImg, D extends BaseGearInfo> {

    D entityToDto(E entity, Class<D> dtoClass);

    List<D> entitiesToDtos(Collection<E> entities, Class<D> dtoClass);
}
