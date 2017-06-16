package com.verge.repository;

import com.verge.entity.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {

    @Query("SELECT p from Player p WHERE p.name LIKE %:query%")
    List<Player> nameLike(@Param("query") String query);

}
