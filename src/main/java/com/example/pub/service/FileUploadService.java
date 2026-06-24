package com.example.pub.service;

import com.example.pub.client.AdvertiserClient;
import com.example.pub.exception.RetriableActivityException;
import com.example.pub.s3.S3Client;

public class FileUploadService {

    private final S3Client s3Client;
    private final AdvertiserClient advertiserClient;

    public FileUploadService(S3Client s3Client, AdvertiserClient advertiserClient) {
        this.s3Client = s3Client;
        this.advertiserClient = advertiserClient;
    }

    public void uploadFile(String s3Path) {

        try {
            byte[] data = s3Client.read(s3Path);
            advertiserClient.uploadSegment(s3Path, data);
        } catch (RetriableActivityException e) {
            int retryCount = 3;

            for (int i = 0; i < retryCount; i++) {
                try {
                    byte[] data = s3Client.read(s3Path);
                    advertiserClient.uploadSegment(s3Path, data);
                    return;
                } catch (Exception ex) {
                    // Retry the operation if it fails
                }
            }
            throw new RetriableActivityException("Unable to upload file from '" + s3Path + "'", e);
        }
    }
}
