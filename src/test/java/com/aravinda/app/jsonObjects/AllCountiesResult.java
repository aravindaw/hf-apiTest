package com.aravinda.app.jsonObjects;

public class AllCountiesResult {
    private RestResponse RestResponse;

    public AllCountiesResult() {
    }

    public AllCountiesResult(RestResponse restResponse) {
        this.RestResponse = restResponse;
    }

    public RestResponse getRestResponse() {
        return RestResponse;
    }

    public void setRestResponse(RestResponse restResponse) {
        this.RestResponse = restResponse;
    }
}
