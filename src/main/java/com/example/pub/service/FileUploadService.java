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
        int maxRetries = 3;
        int attempt = 0;
        while (attempt < maxRetries) {
            try {
                byte[] data = s3Client.read(s3Path);
                advertiserClient.uploadSegment(s3Path, data);
                return;
            } catch (Exception e) {
                attempt++;
                if (attempt >= maxRetries) {
                    throw new RetriableActivityException(
                        "Unable to upload file from '" + s3Path + "' after " + maxRetries + " attempts", e
                    );
                }
                // Optionally, add a short delay between retries
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new RetriableActivityException(
                        "Upload interrupted for file '" + s3Path + "'", ie
                    );
                }
            }
        }
    }
}
