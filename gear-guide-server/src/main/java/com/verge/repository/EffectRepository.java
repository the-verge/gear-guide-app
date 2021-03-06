package com.verge.repository;

import com.verge.entity.Effect;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EffectRepository extends CrudRepository<Effect, Long> {
}
