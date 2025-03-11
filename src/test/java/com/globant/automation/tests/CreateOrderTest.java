package com.globant.automation.tests;

import com.globant.automation.config.TestRunner;
import com.globant.automation.model.OrderDTO;
import com.globant.automation.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test to create an order for a pet.
 */
public class CreateOrderTest extends TestRunner {

    @Test(testName = "Create Order Test")
    public void testCreateOrder() {

        // Create an order for a pet (ensure you use a valid petId)
        OrderDTO order = OrderDTO.builder()
                .id(1L)
                .petId(10L)
                .quantity(1)
                .shipDate("2025-03-10T00:00:00.000Z")
                .status("placed")
                .complete(true)
                .build();

        Response response = RequestBuilder.postRequest(getBaseUrl(), "/store/order", order);
        Assert.assertEquals(response.getStatusCode(), 200, "Order should be created successfully");

        // Deserialize response to OrderDTO and validate expected fields.
        OrderDTO orderResponse = response.as(OrderDTO.class);
        Assert.assertEquals(orderResponse.getStatus(), "placed", "Order status should be 'placed'");
        Assert.assertEquals(orderResponse.getPetId(), order.getPetId(), "Order petId should match");
    }
}
