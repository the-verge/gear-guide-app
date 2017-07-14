package com.verge.service.image;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    String save(MultipartFile image) throws ImageSaveException;
}
