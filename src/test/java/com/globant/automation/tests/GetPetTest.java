package com.globant.automation.tests;

import com.globant.automation.config.TestRunner;
import com.globant.automation.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test to retrieve pet details using JsonPath.
 */
public class GetPetTest extends TestRunner {

    @Test(testName = "Get Pet Details Test")
    public void testGetPet() {

        // Assume we know the pet ID to query (for example, 10L)
        Long expectedPetId = 10L;
        Response response = RequestBuilder.getRequest(getBaseUrl(), "/pet/" + expectedPetId);
        Assert.assertEquals(response.getStatusCode(), 200, "Pet details should be retrieved successfully");

        // Extract key values using JsonPath
        Long petId = response.jsonPath().getLong("id");
        String petName = response.jsonPath().getString("name");
        String petStatus = response.jsonPath().getString("status");

        // Validate extracted values.
        Assert.assertNotNull(petId, "Pet ID should not be null");
        Assert.assertEquals(petId, expectedPetId, "Pet ID should match the expected value");
        Assert.assertNotNull(petName, "Pet name should not be null");
        Assert.assertNotNull(petStatus, "Pet status should not be null");
    }
}
