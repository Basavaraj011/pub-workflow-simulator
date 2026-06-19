# Pub Workflow Simulator (Broken Repo)

This repository simulates failures in a PUB workflow system.

## Observed Errors

1. Unexpected state returned by advertiser request to upload file segment 
2. RetriableActivityException: Unable to upload file from S3

## Known Issues

- Advertiser API state handling is incomplete
- No retry mechanism for S3 upload failures

## Goal

AI system should:
- Read error logs
- Identify faulty code
- Fix logic
- Raise PR
