package com.aravinda.app.scripts;

import com.aravinda.app.contexts.AddNewCountryContext;
import com.aravinda.app.documents.AddNewCountryDocument;
import com.gemstone.org.json.JSONException;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HFAPIT4_AddNewCountry {
    private AddNewCountryContext context;

    @BeforeTest
    public void checkConnectivity() throws ConfigurationException {
        new ConnectivityStatus().checkNetworkConnectivity();
    }

    @Test
    public void addNewCountry() throws JSONException, ConfigurationException {
        context.setName("Test Country");
        context.setAlpha2_code("TC");
        context.setAlpha3_code("TCY");

        AddNewCountryDocument country = new AddNewCountryDocument(context);
        country.add();
    }
}
