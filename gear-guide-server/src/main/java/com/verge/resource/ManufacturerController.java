package com.verge.resource;

import com.verge.dto.ManufacturerInfo;
import com.verge.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {

    private ManufacturerService service;

    @Autowired
    public ManufacturerController(ManufacturerService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ManufacturerInfo> findAll() {
        return service.findAll();
    }
}
