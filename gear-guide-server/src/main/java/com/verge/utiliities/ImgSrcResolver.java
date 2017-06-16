package com.verge.utiliities;

import com.verge.entity.Player;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImgSrcResolver {

    @Value("${img.src.root}")
    private String imgSrcRoot;

    public String resolveImgSrc(Player player) {
        return imgSrcRoot + player.getImage();
    }
}
