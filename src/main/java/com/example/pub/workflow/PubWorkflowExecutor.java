package com.example.pub.workflow;

import com.example.pub.service.FileUploadService;
import com.example.pub.client.AdvertiserClient;
import com.example.pub.s3.S3Client;

public class PubWorkflowExecutor {

    private final FileUploadService fileUploadService;
    private final AdvertiserClient advertiserClient;

    public PubWorkflowExecutor(FileUploadService fileUploadService, AdvertiserClient advertiserClient) {
        this.fileUploadService = fileUploadService;
        this.advertiserClient = advertiserClient;
    }

    public void run() {
        String s3Path = "s3://bucket/sample-workflow/file.txt";
        boolean advertiserReady = advertiserClient.isReadyForUpload(s3Path);
        if (advertiserReady) {
            fileUploadService.uploadFile(s3Path);
        } else {
            throw new IllegalStateException("Advertiser not ready for upload: " + s3Path);
        }
    }
}
        service.uploadFile(s3Path);
    }
}
