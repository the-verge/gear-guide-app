package com.verge.utiliities;

import com.verge.type.HasImg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImgSrcResolver {

    @Value("${img.src.root}")
    private String imgSrcRoot;

    public String resolveImgSrc(HasImg entity) {
        return imgSrcRoot + entity.getImage();
    }
}
