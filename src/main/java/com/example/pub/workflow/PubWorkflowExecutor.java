package com.example.pub.workflow;

import com.example.pub.service.FileUploadService;
import com.example.pub.client.AdvertiserClient;
import com.example.pub.s3.S3Client;

public class PubWorkflowExecutor {

    private final FileUploadService fileUploadService;

    private final AdvertiserClient advertiserClient;
    public PubWorkflowExecutor(FileUploadService fileUploadService) {
    private PubWorkflowExecutor(FileUploadService fileUploadService, S3Client s3Client, AdvertiserClient advertiserClient) {
        this.s3Client = s3Client;
    }
        this.advertiserClient = advertiserClient;

    public void run() {
        String s3Path = "s3://bucket/sample-workflow/file.txt";
        fileUploadService.uploadFile(s3Path);
    }
}
