package com.verge.mapping;

import java.util.Collection;
import java.util.List;

public interface DtoToEntity<D, E> {

    E dtoToEntity(D dto, Class<E> entityClass);

    List<E> dtosToEntities(Collection<D> dtos, Class<E> entityClass);
}
