package utils;

import base.BookingService;
import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;
import models.request.BookingDates;
import models.request.BookingRequest;
import models.response.BookingResponse;

public class Bookinghelper {
    // Create a new booking and return booking id
    public static int  createbookingAndgetId(BookingRequest bookingRequest) {
        BookingService service = new BookingService();
        Response response = service.createBooking(bookingRequest);

        BookingResponse bookingResponse = response.as(BookingResponse.class);

        return bookingResponse.getBookingid();
    }

    public static BookingResponse createbookingAndreturnResponse(BookingRequest bookingRequest) {
        BookingService service = new BookingService();
        Response response = service.createBooking(bookingRequest);
        return response.as(BookingResponse.class);
    }

}