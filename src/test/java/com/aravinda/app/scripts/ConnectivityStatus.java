package com.aravinda.app.scripts;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.testng.Assert;

import static com.jayway.restassured.RestAssured.given;

class ConnectivityStatus {

    void checkNetworkConnectivity() throws ConfigurationException {
        CompositeConfiguration config = new CompositeConfiguration();
        config.addConfiguration(new PropertiesConfiguration("src/test/resources/config.properties"));

        RestAssured.baseURI = config.getProperty("BASE_URL").toString().trim();
//        RestAssured.baseURI = "http://services.groupkt.com/";
        Response response = given().get();
        Assert.assertEquals(response.statusCode(), 200);
    }

}
