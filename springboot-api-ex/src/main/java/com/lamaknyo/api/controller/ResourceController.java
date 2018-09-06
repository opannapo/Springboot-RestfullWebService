package com.lamaknyo.api.controller;

import com.lamaknyo.api.common.ResComponent;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.activation.FileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
public class ResourceController {
    @GetMapping("/res/product/{prd_id}/{path}")
    public ResponseEntity<byte[]> getProductImage(@PathVariable(value = "prd_id") int prd_id,
                                                  @PathVariable(value = "path") String path) {
        File img = new File(ResComponent.productDir + prd_id + "/" + path);
        try {
            if (!img.exists()) {
                img = new File(ResComponent.productImgDef);
            }
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img)))
                    .body(Files.readAllBytes(img.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}