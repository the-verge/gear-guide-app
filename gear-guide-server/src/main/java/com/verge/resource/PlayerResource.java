package com.verge.resource;

import com.verge.dto.PlayerInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
public interface PlayerResource {

    @RequestMapping(method = RequestMethod.GET)
    List<PlayerInfo> findAll();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    PlayerInfo findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    List<PlayerInfo> nameLike(@RequestParam("query") String query);

}
