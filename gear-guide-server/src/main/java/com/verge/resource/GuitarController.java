package com.verge.resource;

import com.verge.dto.GuitarInfo;
import com.verge.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guitars")
public class GuitarController {

    private GuitarService service;

    @Autowired
    public GuitarController(GuitarService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<GuitarInfo> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<GuitarInfo> findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }
}
