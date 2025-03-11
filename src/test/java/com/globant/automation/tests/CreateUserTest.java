package com.globant.automation.tests;

import com.globant.automation.config.TestRunner;
import com.globant.automation.model.ApiResponseDTO;
import com.globant.automation.model.UserDTO;
import com.globant.automation.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Test for creating a user.
 */
public class CreateUserTest extends TestRunner {

    @Test(testName = "Create User Test")
    public void testCreateUser() {

        // Create a user using the builder pattern.
        UserDTO user = UserDTO.builder()
                .id(0L)
                .username("usuarioTest")
                .firstName("Nombre")
                .lastName("Apellido")
                .email("usuario@test.com")
                .password("password123")
                .phone("123456789")
                .userStatus(1)
                .build();

        // Perform POST request to create the user.
        Response response = RequestBuilder.postRequest(getBaseUrl(), "/user", user);
        Assert.assertEquals(response.getStatusCode(), 200, "User should be created successfully");

        // Deserialize response to ApiResponseDTO and validate key fields.
        ApiResponseDTO apiResponse = response.as(ApiResponseDTO.class);
        Assert.assertNotNull(apiResponse.getMessage(), "Response message should not be null");
    }
}