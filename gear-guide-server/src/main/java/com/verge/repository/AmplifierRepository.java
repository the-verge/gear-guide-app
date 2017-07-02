package com.verge.repository;

import com.verge.entity.Amplifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmplifierRepository extends CrudRepository<Amplifier, Long> {
}
