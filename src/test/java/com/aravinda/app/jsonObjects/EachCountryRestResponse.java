package com.aravinda.app.jsonObjects;

import java.util.List;

public class EachCountryRestResponse {
    private List<String> messages;
    private EachCountryResult result;

    public EachCountryRestResponse(List<String> messages, EachCountryResult result) {
        this.messages = messages;
        this.result = result;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public EachCountryResult getResult() {
        return result;
    }

    public void setResult(EachCountryResult result) {
        this.result = result;
    }
}
