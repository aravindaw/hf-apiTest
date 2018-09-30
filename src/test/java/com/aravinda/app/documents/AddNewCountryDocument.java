package com.aravinda.app.documents;

import com.aravinda.app.contexts.AddNewCountryContext;
import com.gemstone.org.json.JSONException;
import com.gemstone.org.json.JSONObject;
import com.jayway.restassured.response.Response;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.testng.Assert;

import static com.jayway.restassured.RestAssured.given;

public class AddNewCountryDocument {
    private final AddNewCountryContext context;

    public AddNewCountryDocument(AddNewCountryContext context) {
        this.context = context;
    }

    public void add() throws JSONException, ConfigurationException {

        CompositeConfiguration config = new CompositeConfiguration();
        config.addConfiguration(new PropertiesConfiguration("src/test/resources/config.properties"));

        JSONObject json = new JSONObject();
        json.put("name", context.getName());
        json.put("alpha2_code", context.getAlpha2_code());
        json.put("alpha3_code", context.getAlpha3_code());

        Response response = given().
                when().
                header("content-Type", "application/json").
                header("url", config.getProperty("baseURI").toString().trim()).
                body(json).
                post("API_FOR_ADD_NEW_USER").
                then().
                extract().
                response();
        Assert.assertEquals(response.statusCode(), 200);

    }
}
