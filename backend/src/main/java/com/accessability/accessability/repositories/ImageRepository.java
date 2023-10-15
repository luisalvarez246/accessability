package com.accessability.accessability.repositories;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageRepository
{
    String          imageProcessing(MultipartFile image);
    String          saveImage(MultipartFile image) throws IOException;
    String          formatImageName();
    StringBuilder   deleteUnusedImages() throws IOException;
}
