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

        int retryCount = 0;
        while (retryCount < 3) {
            try {
                byte[] data = s3Client.read(s3Path);
                advertiserClient.uploadSegment(s3Path, data);
                return;
            } catch (Exception e) {
                retryCount++;
                if (retryCount >= 3) {
                    throw new RetriableActivityException(
                        "Unable to upload file from '" + s3Path + "' after 3 retries", e
                    );
                }
                // Retry with exponential backoff
                try {
                    Thread.sleep((int) Math.pow(2, retryCount) * 1000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
