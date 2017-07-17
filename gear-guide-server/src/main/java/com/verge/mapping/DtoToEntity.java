package com.verge.mapping;

import java.util.Collection;
import java.util.Set;

public interface DtoToEntity<D, E> {

    E dtoToEntity(D dto, Class<E> entityClass);

    Set<E> dtosToEntities(Collection<D> dtos, Class<E> entityClass);
}
