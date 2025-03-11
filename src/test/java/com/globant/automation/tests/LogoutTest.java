package com.globant.automation.tests;

import com.globant.automation.config.TestRunner;
import com.globant.automation.model.ApiResponseDTO;
import com.globant.automation.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test to perform user logout.
 */
public class LogoutTest extends TestRunner {

    @Test(testName = "User Logout Test")
    public void testLogout() {
        Response response = RequestBuilder.getRequest(getBaseUrl(), "/user/logout");
        Assert.assertEquals(response.getStatusCode(), 200, "Logout realizado exitosamente");

        // Deserialize response to ApiResponseDTO and validate that the message is not null.
        ApiResponseDTO apiResponse = response.as(ApiResponseDTO.class);
        Assert.assertNotNull(apiResponse.getMessage(), "El mensaje de logout no debe ser nulo");
    }
}
