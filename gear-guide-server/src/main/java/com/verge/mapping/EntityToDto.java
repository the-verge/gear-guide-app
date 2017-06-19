package com.verge.mapping;

import java.util.Collection;
import java.util.List;

public interface EntityToDto<E, D> {

    D entityToDto(E entity);

    List<D> entitiesToDtos(Collection<E> entities);
}
