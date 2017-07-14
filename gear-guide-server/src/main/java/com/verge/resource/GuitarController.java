package com.verge.resource;

import com.verge.dto.GuitarInfo;
import com.verge.service.GuitarService;
import com.verge.utiliities.Deserialiser;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<GuitarInfo> create(@RequestPart("details") @Valid String guitarDetails,
                                             @RequestPart("image") @NotNull @NotBlank MultipartFile image) {

        GuitarInfo guitarInfo = Deserialiser.deserialise(guitarDetails, GuitarInfo.class);
        return service.create(guitarInfo, image);
    }
}
