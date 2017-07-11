package com.verge.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Profile("dev")
public class DevImageService implements ImageService {

    @Override
    public String save(MultipartFile image) {
        return image.getName();
    }
}
