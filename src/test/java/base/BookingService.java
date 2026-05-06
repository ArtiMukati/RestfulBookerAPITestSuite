package base;

import io.restassured.response.Response;
import models.request.BookingRequest;

public class BookingService extends BaseService{

    private static final String BASE_PATH = "/booking";
    public Response createBooking(BookingRequest payload) {
        return postRequest(payload , BASE_PATH );
    }
}
