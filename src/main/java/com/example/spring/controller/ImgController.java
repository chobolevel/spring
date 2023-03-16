package com.example.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("img")
public class ImgController {

    @Value("${spring.servlet.multipart.location}")
    private String filePath;

    @PostMapping("upload")
    public void upload(@RequestParam("uploadfile") MultipartFile[] uploadFile) throws IOException {
        for(MultipartFile file : uploadFile) {
            file.transferTo(new File(UUID.randomUUID() + ".jpg"));
        }
    }

    @GetMapping("download")
    public ResponseEntity<Resource> download() throws IOException {
        Path path = Paths.get(filePath + "/" + "ddd17fe8-dddc-4832-8e0e-bec170dc7098.jpg");
        String contentType = Files.probeContentType(path);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, contentType);
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=test_img.jpg");

        Resource resource = new InputStreamResource(Files.newInputStream(path));

        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }

}
