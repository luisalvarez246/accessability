package com.accessability.accessability.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class TestImageService extends ImageService
{
    @Override
    public void copyImageFile(MultipartFile image, String fileName) throws IOException
    {
        System.out.println("No file manipulation at testing scenarios");
    }
}
