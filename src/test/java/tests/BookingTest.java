package tests;

import base.BookingService;
import io.restassured.response.Response;
import models.request.BookingDates;
import models.request.BookingRequest;
import models.response.BookingResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingTest {
    @Test (description = "Create a new booking")
    public void createNewBooking() {
        BookingDates dates = new BookingDates.Builder()
                .checkin("2018-01-01")
                .checkout("2019-01-01")
                .build();
        BookingRequest bookingRequest = new BookingRequest.Builder()
                .firstname("John")
                .lastname("Doe")
                .totalprice(150.00)
                .depositpaid(true)
                .bookingdates(dates)
                .additionalneeds("Breakfast")
                .build();
        BookingService bookingService = new BookingService();
        Response response = bookingService.createBooking(bookingRequest);
         BookingResponse bookingdetail =  response.as(BookingResponse.class);
         int bookingId = bookingdetail.getBookingid();
         System.out.println("Booking ID: " + bookingId);
         System.out.println("Booking Details: " + bookingdetail.getBooking());
        Assert.assertEquals(response.statusCode(), 200, "Expected status code 200");
        Assert.assertTrue(bookingdetail.getBookingid() > 1,
                "Expected booking ID" + bookingId +"to be greater than 1");
    }

}
