package com.aravinda.app.documents;

import com.aravinda.app.jsonObjects.EachCountryAPIResult;
import com.google.gson.Gson;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.Assert;

import static com.jayway.restassured.RestAssured.given;

public class EachCountryValidationDocument {
    public void validate(String country) {
        Response response = given().
                when().
                get("/country/get/iso2code/" + country).
                then().
                contentType(ContentType.JSON).
                extract().
                response();
        Assert.assertEquals(response.statusCode(), 200);

        Gson gson = new Gson();
        EachCountryAPIResult jsonResponse = gson.fromJson(response.asString(), EachCountryAPIResult.class);
        Assert.assertTrue(jsonResponse.getRestResponse().getMessages().contains("Country found matching code [US]."));
    }
}
