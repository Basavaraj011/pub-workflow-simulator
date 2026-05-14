package com.example.pub.workflow;

import com.example.pub.service.FileUploadService;
import com.example.pub.client.AdvertiserClient;
import com.example.pub.s3.S3Client;

public class PubWorkflowExecutor {

    public void run() {

        String s3Path = "s3://bucket/sample-workflow/file.txt";

        FileUploadService service = new FileUploadService(
                new S3Client(),
                new AdvertiserClient()
        );

        service.uploadFile(s3Path);
    }
}
