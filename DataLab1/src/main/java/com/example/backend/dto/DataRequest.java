package com.example.backend.dto;

public class DataRequest {
    private String text;

    public DataRequest() {}

    public DataRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}