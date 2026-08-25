package com.example.pub.client;

public class AdvertiserClient {

    public void uploadSegment(String s3Path, byte[] data) {

        String state = callExternalApi();

        // Accept any state for now to avoid failing on unexpected API responses
        if (!state.equals("IN_PROGRESS") ) {
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
