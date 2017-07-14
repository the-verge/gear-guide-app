package com.verge.service.image;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@Profile("dev")
public class DevImageService implements ImageService {

    @Override
    public String save(MultipartFile image) throws ImageSaveException {
        String imageName = image.getOriginalFilename();
        File file = new File(getImgDir() + imageName);
        try {
            image.transferTo(file);
        } catch (IOException e) {
            throw new ImageSaveException("Could not save image " + imageName);
        }
        return image.getOriginalFilename();
    }

    private static String getImgDir() {
        String pwd = System.getProperty("user.dir");
        String sep = System.getProperty("file.separator");

        return pwd + sep + "gear-guide-client" + sep + "dev-images" + sep;
    }
}
