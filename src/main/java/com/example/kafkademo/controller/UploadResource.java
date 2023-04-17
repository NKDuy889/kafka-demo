package com.example.kafkademo.controller;

import com.example.kafkademo.dto.UploadFileDto;
import com.example.kafkademo.service.UploadFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * REST controller for managing upload file
 */
@RestController
@RequestMapping("ftp")
public class UploadResource {

  private final UploadFileService uploadService;

  @Autowired
  public UploadResource(UploadFileService uploadService) {
    this.uploadService = uploadService;
  }

  /**
   * api to upload image for send request support
   *
   * @param file MultipartFile
   * @return UploadFileDto
   */
  @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<UploadFileDto> uploadImage(@RequestPart MultipartFile file) {
    return new ResponseEntity<>(uploadService.uploadImageSupport(file), HttpStatus.OK);
  }
}
