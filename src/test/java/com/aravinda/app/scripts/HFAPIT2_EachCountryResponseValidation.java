package com.aravinda.app.scripts;

import com.aravinda.app.documents.EachCountryValidationDocument;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HFAPIT2_EachCountryResponseValidation {

    @BeforeTest
    public void checkConnectivity() throws ConfigurationException {
        new ConnectivityStatus().checkNetworkConnectivity();
    }

    @Test
    public void ValidateReturnedResponse() {
        String countryName = "US";
        EachCountryValidationDocument country = new EachCountryValidationDocument();
        country.validate(countryName);
    }
}
