package com.globant.automation.tests;

import com.globant.automation.config.TestRunner;
import com.globant.automation.model.ApiResponseDTO;
import com.globant.automation.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test for user login.
 */
public class LoginTest extends TestRunner {

    @Test(testName = "User Login Test")
    public void testLogin() {

        String username = "usuarioTest";
        String password = "password123";

        Response response = RequestBuilder.getRequest(getBaseUrl(), "/user/login?username=" + username + "&password=" + password);
        Assert.assertEquals(response.getStatusCode(), 200, "Login should be successful");

        // Deserialize response to ApiResponseDTO and validate the message.
        ApiResponseDTO apiResponse = response.as(ApiResponseDTO.class);
        Assert.assertTrue(apiResponse.getMessage().contains("logged in user session"), "Login message should be correct");
    }
}
