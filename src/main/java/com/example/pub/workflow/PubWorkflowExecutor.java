package com.example.pub.workflow;

import com.example.pub.service.FileUploadService;
import com.example.pub.client.AdvertiserClient;
import com.example.pub.s3.S3Client;

public class PubWorkflowExecutor {

    private final FileUploadService fileUploadService;

    public PubWorkflowExecutor(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    public void run() {
        String s3Path = "s3://bucket/sample-workflow/file.txt";
        this.fileUploadService.uploadFile(s3Path);
    }
}
