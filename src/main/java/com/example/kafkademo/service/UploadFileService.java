package com.example.kafkademo.service;

import com.example.kafkademo.dto.UploadFileDto;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {

    UploadFileDto uploadImageSupport(MultipartFile file);
}
