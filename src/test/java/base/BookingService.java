package base;

import io.restassured.response.Response;
import models.request.PartialBookingUpdateRequest;
import models.request.BookingRequest;

public class BookingService extends BaseService{

    private static final String BASE_PATH = "/booking";
    public Response createBooking(BookingRequest payload) {

        return postRequest(payload , BASE_PATH );
    }

    public Response getBookingbyId(int bookingId) {
        return getRequest(BASE_PATH + "/" + bookingId );
    }
    public Response getBookingbyLastname(String lastname) {
        return getRequest(BASE_PATH + "/" + lastname );
    }
    public Response putUpdateBooking(BookingRequest payload, int bookingId) {
        return putRequest(payload,BASE_PATH + "/" + bookingId );

    }
    public Response patchBooking(PartialBookingUpdateRequest payload, int bookingId) {
        return patchRequest(payload ,BASE_PATH + "/" + bookingId );
    }
    public Response deleteBooking(int bookingId) {
        return deleteRequest(BASE_PATH + "/" + bookingId );
    }
}
