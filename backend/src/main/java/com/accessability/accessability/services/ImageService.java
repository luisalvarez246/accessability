package com.accessability.accessability.services;

import com.accessability.accessability.models.Store;
import com.accessability.accessability.repositories.IStoreRepository;
import com.accessability.accessability.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.Normalizer;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageService implements ImageRepository
{
    private final String storePath = System.getProperty("user.dir") + "/src/main/webapp/images";

    @Autowired
    IStoreRepository iStoreRepository;

    public String imageProcessing(MultipartFile image)
    {
        String  fileName;

        if ((image != null) && (!image.isEmpty()))
        {
            try
            {
                fileName = saveImage(image);
            }
            catch (Exception error)
            {
                throw new RuntimeException("Error image could not be saved: " + error.getMessage());
            }
        }
        else
            fileName = "default.png";
        return (fileName);
    }

    public String saveImage(MultipartFile image) throws IOException
    {
        String  originalFileName;
        String  extension;
        String  fileNameWithoutExtension;
        String  fileName;

        originalFileName = image.getOriginalFilename();
        extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
        fileNameWithoutExtension = originalFileName.substring(0, originalFileName.lastIndexOf('.'));
        fileName = fileNameWithoutExtension + formatImageName() + extension;
        copyImageFile(image, fileName);
        return (fileName);
    }

    public void copyImageFile(MultipartFile image, String fileName) throws IOException
    {
        Files.copy(image.getInputStream(), Path.of(storePath, fileName), StandardCopyOption.REPLACE_EXISTING);
    }

    public String formatImageName()
    {
        String timestamp;
        Instant instant = Instant.now();
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH_mm_ss");

        timestamp = formatter.format(localDateTime);
        return (timestamp);
    }

    public StringBuilder deleteUnusedImages() throws IOException
    {
        List<Store>         storeList;
        List<String>        imageList;
        File directory;
        File[]              files;
        String              normalizedFileNames;
        StringBuilder       deletedImages;

        storeList = iStoreRepository.findAll();
        imageList = storeList.stream()
                    .map(store -> Normalizer.normalize(store.getImage(), Normalizer.Form.NFD))
                    .distinct()
                    .collect(Collectors.toList());
        directory = new File(storePath);
        files = directory.listFiles();
        deletedImages = new StringBuilder();
        for (File file : files)
        {
            normalizedFileNames = Normalizer.normalize(file.getName(), Normalizer.Form.NFD);
            if ((!imageList.contains(normalizedFileNames)) && (!normalizedFileNames.equals("default.png")))
            {
                deletedImages.append(file.getName()).append(" ");
                Files.delete(Path.of(storePath, file.getName()));
            }
        }
        return (deletedImages);
    }
}
