package com.verge.resource;

import com.verge.dto.GuitarInfo;
import com.verge.dto.PlayerInfo;
import com.verge.service.PlayerService;
import com.verge.utiliities.Deserialiser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private PlayerService service;

    @Autowired
    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<PlayerInfo> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PlayerInfo> findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public List<PlayerInfo> nameLike(@RequestParam("query") String query) {
        return service.nameLike(query);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<GuitarInfo> create(@RequestPart("details") @NotNull String playerDetails,
                                             @RequestPart("image") @NotNull MultipartFile image) {

        PlayerInfo playerInfo = Deserialiser.deserialise(playerDetails, PlayerInfo.class);
        return service.create(playerInfo, image);
    }

}
