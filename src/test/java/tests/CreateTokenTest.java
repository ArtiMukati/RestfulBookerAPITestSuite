package tests;

import base.AuthService;
import io.restassured.response.Response;
import models.request.TokenRequest;
import models.response.TokenResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateTokenTest {
    @Test (description = "Create a new token with valid credentials", groups = {"auth"})
    public void testCreateToken() {
        TokenRequest payload = new TokenRequest("admin", "password123");
        AuthService auth = new AuthService();
        Response response = auth.createToken(payload);
        TokenResponse token = response.as(TokenResponse.class);
        System.out.println("Token: " + token.getToken());
        Assert.assertEquals(response.statusCode(), 200, "Expected status code 200");
    }
}
