package com.globant.automation.tests;

import com.globant.automation.config.TestRunner;
import com.globant.automation.model.PetDTO;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.equalTo;
import com.globant.automation.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Test to list all available pets and validate that each pet's status is "available".
 */
public class ListAvailablePetsTest extends TestRunner {

    @Test(testName = "List Available Pets Test")
    public void testListAvailablePets() {
        Response response = RequestBuilder.getRequest(getBaseUrl(), "/pet/findByStatus?status=available");

        // Validate that the response has HTTP status 200 and each pet has status "available".
        response.then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("status", everyItem(equalTo("available")));
    }
}
