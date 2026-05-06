package base;

import io.restassured.response.Response;
import models.request.TokenRequest;

import static io.restassured.RestAssured.given;

public class AuthService extends BaseService {

    public Response createToken(TokenRequest payload) {
        return postRequest(payload , "/auth/" );
    }
}
