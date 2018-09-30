package com.aravinda.app.jsonObjects;

import java.util.List;

public class RestResponse {
    private List<String> messages;
    private List<Result> result;

    public RestResponse() {
    }

    public RestResponse(List<String> messages, List<Result> countryList) {
        this.messages = messages;
        this.result = countryList;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }
}