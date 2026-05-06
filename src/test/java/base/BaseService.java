package base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseService {
    // wrapper for Rest Assured!! Sets up request Specification and provides common methods for making requests

    private static final String BASE_URL = "https://restful-booker.herokuapp.com";

    private final RequestSpecification requestSpecification;

    public BaseService() {
        requestSpecification = given().baseUri(BASE_URL);
    }
    protected Response postRequest(Object payload, String endpoint) {
       return requestSpecification.contentType("application/json").body(payload).post(endpoint);

    }
    protected void setToken(String token) {
        requestSpecification.header("Authorization", "Bearer " + token);

    }

}
