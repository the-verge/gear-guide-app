package com.verge.resource.impl;

import com.verge.dto.PlayerInfo;
import com.verge.resource.PlayerResource;
import com.verge.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController implements PlayerResource {

    @Autowired
    private PlayerService playerService;

    @Override
    public List<PlayerInfo> findAll() {
        return playerService.findAll();
    }

    @Override
    public PlayerInfo findById(@PathVariable("id") Long id) {
        return playerService.findById(id);
    }

    @Override
    public List<PlayerInfo> nameLike(@RequestParam("query") String query) {
        return playerService.nameLike(query);
    }

}
