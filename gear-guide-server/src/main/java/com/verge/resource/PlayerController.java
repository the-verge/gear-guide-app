package com.verge.resource;

import com.verge.dto.PlayerInfo;
import com.verge.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService  playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<PlayerInfo> findAll() {
        return playerService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PlayerInfo> findById(@PathVariable("id") Long id) {
        return playerService.findById(id);
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public List<PlayerInfo> nameLike(@RequestParam("query") String query) {
        return playerService.nameLike(query);
    }

}
