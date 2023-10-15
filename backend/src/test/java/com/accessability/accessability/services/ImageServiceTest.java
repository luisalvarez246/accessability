package com.accessability.accessability.services;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
class ImageServiceTest
{
    @Autowired
    TestImageService    imageService;

    @Nested
    class ImageProcessing
    {
        @Test
        void returns_the_image_path_if_a_valid_image_is_given() throws IOException
        {
            //arrange
            MockMultipartFile   mockImage;
            String              imagePath;

            mockImage = new MockMultipartFile("image", "test.jpg", "image/jpeg", "Test data".getBytes());
            //act
            imagePath = imageService.imageProcessing(mockImage);
            //assert
            assertNotNull(imagePath);
        }

        @Test
        void returns_default_png_if_an_empty_image_file_is_given() throws IOException
        {
            //arrange
            MockMultipartFile   mockImage;
            String              imagePath;

            mockImage = new MockMultipartFile("image", new byte[0]);
            //act
            imagePath = imageService.imageProcessing(mockImage);
            //assert
            assertEquals("default.png",imagePath);
        }
    }
}