package com.verge.service.image;

public class ImageSaveException extends Exception {

    public ImageSaveException(String message) {
        super(message);
    }

    public ImageSaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
