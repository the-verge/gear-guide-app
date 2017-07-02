package com.verge.resource;

import com.verge.dto.AmplifierInfo;
import com.verge.service.AmplifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/amplifiers")
public class AmplifierController {

    private AmplifierService service;

    @Autowired
    public AmplifierController(AmplifierService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<AmplifierInfo> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AmplifierInfo> findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }
}
