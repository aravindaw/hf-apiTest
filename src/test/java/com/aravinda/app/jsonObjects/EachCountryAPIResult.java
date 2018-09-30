package com.aravinda.app.jsonObjects;

public class EachCountryAPIResult {
    private EachCountryRestResponse RestResponse;

    public EachCountryAPIResult(EachCountryRestResponse restResponse) {
        RestResponse = restResponse;
    }

    public EachCountryRestResponse getRestResponse() {
        return RestResponse;
    }

    public void setRestResponse(EachCountryRestResponse restResponse) {
        RestResponse = restResponse;
    }
}
