package com.verge.repository;

import com.verge.entity.Guitar;
import org.springframework.data.repository.CrudRepository;

public interface GuitarRepository extends CrudRepository<Guitar, Long> {
}
