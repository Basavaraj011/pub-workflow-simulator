package com.example.pub.workflow;

import com.example.pub.service.FileUploadService;
import com.example.pub.client.AdvertiserClient;
import com.example.pub.s3.S3Client;

public class PubWorkflowExecutor {

    private final FileUploadService fileUploadService;

    public PubWorkflowExecutor(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
        this.s3Client = new S3Client();
    }

    public void run() {
        String s3Path = "s3://bucket/sample-workflow/file.txt";
        fileUploadService.uploadFile(s3Path);
    }
}
