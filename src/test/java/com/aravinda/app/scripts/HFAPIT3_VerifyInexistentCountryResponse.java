package com.aravinda.app.scripts;

import com.aravinda.app.documents.InexistentCountryResponseDocument;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HFAPIT3_VerifyInexistentCountryResponse {
    @BeforeTest
    public void checkConnectivity() throws ConfigurationException {
        new ConnectivityStatus().checkNetworkConnectivity();
    }

    @Test
    public void ValidateReturnedResponse() {
        String countryName = "INVALIDCOUNTRYCODE";
        InexistentCountryResponseDocument country = new InexistentCountryResponseDocument();
        country.validate(countryName);
    }
}
