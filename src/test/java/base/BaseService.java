package base;

import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.request.PartialBookingUpdateRequest;
import models.request.BookingRequest;
import models.request.TokenRequest;
import models.response.TokenResponse;
import utils.TestDataLoader;

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
    protected Response getRequest( String endpoint) {
        return requestSpecification.contentType("application/json").get(endpoint);

    }
    // Set the Auth Token
    protected String setToken() {
        JsonNode data = TestDataLoader.loadJson("src/test/resources/testdata/Auth.json");
        TokenRequest request = new TokenRequest();
        request.setUsername(data.get("username").asText());
        request.setPassword(data.get("password").asText());
        AuthService auth = new AuthService();
        Response response = auth.createToken(request);
        TokenResponse token = response.as(TokenResponse.class);
        System.out.println("Token: " + token.getToken());
        return token.getToken();

    }
    protected Response putRequest(Object payload, String endpoint){
        Response response = requestSpecification.contentType("application/json").header("Cookie","token=" + setToken()).body(payload).put(endpoint);
        System.out.println(response.asPrettyString());
        return response;
    }

    protected Response patchRequest(Object payload, String endpoint){
        Response response = requestSpecification.contentType("application/json").header("Cookie","token=" + setToken()).body(payload).patch(endpoint);
        return response;
    }
    protected Response deleteRequest(String endpoint){
        Response response = requestSpecification.contentType("application/json").header("Cookie","token=" + setToken()).delete(endpoint);
        return response;
    }

}
