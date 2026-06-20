package com.example.pub.s3;

import java.io.IOException;

public class S3Client {

    public byte[] read(String path) throws IOException {
        throw new IOException("S3 read failure");
    }

    public void write(String path, byte[] data) throws IOException {
        // Implement S3 write logic
        // Throw IOException on failure
    }
}
