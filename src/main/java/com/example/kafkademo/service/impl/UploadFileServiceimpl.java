package com.example.kafkademo.service.impl;

import com.example.kafkademo.dto.UploadFileDto;
import com.example.kafkademo.service.UploadFileService;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
public class UploadFileServiceimpl implements UploadFileService {
    @Override
    public UploadFileDto uploadImageSupport(MultipartFile file) {
        return uploadFile(file, "test", file.getName() + "test");
    }

    private UploadFileDto uploadFile(MultipartFile file, String basePath, String fileName) {
        String destPath = "/" + basePath + "/" + fileName;
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect("10.10.151.188", 21);
            boolean loginOk = ftpClient.login("server01", "Vis@2021");
            if (!loginOk) {
                System.out.println("deo the login");
                return null;
            }
            ftpClient.enterLocalPassiveMode();
            ftpClient.mkd(basePath);
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            boolean done = ftpClient.storeFile(destPath, file.getInputStream());
            if (done) {
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        UploadFileDto uploadFileDto = new UploadFileDto();
        uploadFileDto.setUploadTime(new Date());
        uploadFileDto.setImgUrl(destPath);
        return uploadFileDto;
    }
}
