package com.example.pub.client;

public class AdvertiserClient {

    public void uploadSegment(String s3Path, byte[] data) {

        String state = callExternalApi();

        // BUG: Only handles IN_PROGRESS
        if (state.equals("IN_PROGRESS")) {
            // Do nothing, success case
        } else {
            throw new RuntimeException(
                "Unexpected state returned by advertiser request to upload file segment " + s3Path,
                new IllegalStateException("Advertiser API returned unexpected state: " + state)
            );
        }
    }

    private String callExternalApi() {
        return "FAILED";
    }
}
