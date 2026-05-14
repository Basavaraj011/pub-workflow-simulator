package com.example.pub;

import com.example.pub.workflow.PubWorkflowExecutor;

public class Main {

    public static void main(String[] args) {
        PubWorkflowExecutor executor = new PubWorkflowExecutor();

        try {
            executor.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
