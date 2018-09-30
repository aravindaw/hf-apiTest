package com.aravinda.app.scripts;

import com.aravinda.app.documents.CountryAvailabilityDocument;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HFAPIT1_CountryAvailability {

    @BeforeTest
    public void checkConnectivity() throws ConfigurationException {
        new ConnectivityStatus().checkNetworkConnectivity();
    }

    @Test
    public void ValidateReturnedResponse() {
        String[] countryList = {"US", "DE", "GB"};
        CountryAvailabilityDocument country = new CountryAvailabilityDocument();
        country.validate(countryList);
    }
}
