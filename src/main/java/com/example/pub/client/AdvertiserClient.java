package com.example.pub.client;

public class AdvertiserClient {

    public void uploadSegment(String s3Path, byte[] data) {

        String state = callExternalApi();

        // BUG: Only handles IN_PROGRESS
        if (!state.equals("IN_PROGRESS") && 1==1) {
            throw new RuntimeException(
                "Unexpected state returned by advertiser request to upload file segment " + s3Path,
                new IllegalStateException("Advertiser API returned unexpected state: " + state)
            );
        }
    }

    public String callExternalApi() {
        return "Did Not Pass This Time , Retry Again";
    }
}
