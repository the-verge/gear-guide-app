package com.verge.service.image;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Profile("test")
public class TestImageService implements ImageService {

    @Override
    public String save(MultipartFile image) throws ImageSaveException {
        return image.getOriginalFilename();
    }
}
