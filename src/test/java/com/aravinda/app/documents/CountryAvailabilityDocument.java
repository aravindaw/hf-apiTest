package com.aravinda.app.documents;

import com.aravinda.app.jsonObjects.AllCountiesResult;
import com.aravinda.app.jsonObjects.Result;
import com.google.gson.Gson;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;

import static com.jayway.restassured.RestAssured.given;

public class CountryAvailabilityDocument {

    public void validate(String[] countryList) {
        Response response = given().
                when().
                get("/country/get/all").
                then().
                contentType(ContentType.JSON).
                extract().
                response();
        Assert.assertEquals(response.statusCode(), 200);

        ArrayList<String> available = new ArrayList<String>();
        Gson gson = new Gson();
        AllCountiesResult jsonResponse = gson.fromJson(response.asString(), AllCountiesResult.class);
        for (String country : countryList) {
            for (Result x : jsonResponse.getRestResponse().getResult()) {
                if (country.equals(x.getAlpha2_code())) {
                    available.add(x.getAlpha2_code());
                }
            }
        }
        if (countryList.length == available.size()) {
            Assert.assertTrue(true, "Available countries :" + available);
        } else {
            Assert.assertTrue(false, "Available countries :" + available);
        }
    }

}
