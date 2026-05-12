package tests;

import assertions.BookingAssertions;
import base.BookingService;
import com.fasterxml.jackson.databind.JsonNode;
import datafactory.BookingDataFactory;
import io.restassured.response.Response;
import models.request.BookingDates;
import models.request.PartialBookingUpdateRequest;
import models.request.BookingRequest;
import models.response.Booking;
import models.response.BookingResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Bookinghelper;
import utils.TestDataLoader;

public class BookingTest {
    @Test (description = "Create a new booking" , groups = {"booking"})
    public void testCreateBooking() {

        //Load the data from Json
        JsonNode data = TestDataLoader.loadJson("src/test/resources/testdata/booking.json");

        String firstName = data.get("firstname").asText();
        String lastName = data.get("lastname").asText();
        double totalPrice = data.get("totalprice").asDouble();
        boolean depositPaid = data.get("depositpaid").asBoolean();
        String checkin = data.get("bookingdates").get("checkin").asText();
        String checkout = data.get("bookingdates").get("checkout").asText();
        String additionalNeeds = data.get("additionalneeds").asText();
        // Initialize the Booking Dates class
        BookingDates dates = new BookingDates.Builder()
                .checkin(checkin)
                .checkout(checkout)
                .build();
        BookingRequest bookingRequest = new BookingRequest.Builder()
                .firstname(firstName)
                .lastname(lastName)
                .totalprice(totalPrice)
                .depositpaid(depositPaid)
                .bookingdates(dates)
                .additionalneeds(additionalNeeds)
                .build();
        BookingService bookingService = new BookingService();
        Response response = bookingService.createBooking(bookingRequest);
         BookingResponse bookingdetail =  response.as(BookingResponse.class);
         int bookingId = bookingdetail.getBookingid();
         System.out.println("Booking ID: " + bookingId);
        Assert.assertEquals(response.statusCode(), 200, "Expected status code 200");
        BookingAssertions.verifyBookingIdIsValid(bookingdetail);

        BookingAssertions.verifyCreateBookingDetails(
                bookingdetail,
                firstName,
                lastName,
                totalPrice,
                depositPaid,
                checkin,
                checkout,
                additionalNeeds
        );


    }
    @Test (description = "Get Booking details by ID",groups = {"booking"})
    public void testGetBookingById() {
        JsonNode data = TestDataLoader.loadJson("src/test/resources/testdata/booking.json");
        System.out.println(data.toPrettyString());
        BookingRequest request = BookingDataFactory.fromJson(data);
        System.out.println(request.toString());
        int bookingId = Bookinghelper.createbookingAndgetId(request);
        BookingService bookingService = new BookingService();
        Response response =bookingService.getBookingbyId(bookingId);
        Booking booking =  response.as(Booking.class);
        System.out.println(response.asPrettyString());
        BookingAssertions.verifyGetBookingDetails(
                booking,
                request.getFirstname(),
                request.getLastname(),
                request.getTotalprice(),
                request.isDepositpaid(),
                request.getBookingdates().getCheckin(),
                request.getBookingdates().getCheckout(),
                request.getAdditionalneeds()
        );

    }
    @Test (description = "Get Booking details by Lastname",groups = {"booking"})
    public void testGetBookingByLastname() {
        JsonNode data = TestDataLoader.loadJson("src/test/resources/testdata/booking.json");
        System.out.println(data.toPrettyString());
        BookingRequest request = BookingDataFactory.fromJson(data);
        System.out.println(request.toString());
        BookingResponse bookingdetails = Bookinghelper.createbookingAndreturnResponse(request);
        String bookingname = bookingdetails.getBooking().getLastname();
        BookingService bookingService = new BookingService();
        Response response = bookingService.getBookingbyLastname(bookingname);
        Booking booking = response.as(Booking.class);
        System.out.println(response.asPrettyString());
        BookingAssertions.verifyGetBookingDetails(
                booking,
                request.getFirstname(),
                request.getLastname(),
                request.getTotalprice(),
                request.isDepositpaid(),
                request.getBookingdates().getCheckin(),
                request.getBookingdates().getCheckout(),
                request.getAdditionalneeds()
        );
    }
    @Test (description = "Verify update booking PUt request" ,groups = {"booking"})
    public void testUpdateBookingWithPUT() {
        //Load Cooking Creating Data
        JsonNode data = TestDataLoader.loadJson("src/test/resources/testdata/booking.json");
        BookingRequest request = BookingDataFactory.fromJson(data);
        int bookingId = Bookinghelper.createbookingAndgetId(request);
        System.out.println("This is Created Booking" + bookingId);

        //Load the Update booking request Data
        JsonNode data1 = TestDataLoader.loadJson("src/test/resources/testdata/updatebooking.json");
        BookingRequest Updatedrequest = BookingDataFactory.fromJson(data1);


            BookingService bookingService = new BookingService();
            Response response = bookingService.putUpdateBooking(Updatedrequest,bookingId);
            Assert.assertEquals(response.statusCode(), 200, "Expected status code 200");
            Booking booking = response.as(Booking.class);
            System.out.println(response.asPrettyString());
            BookingAssertions.verifyPutBookingDetails(
                    booking,
                    Updatedrequest.getFirstname(),
                    Updatedrequest.getLastname(),
                    Updatedrequest.getTotalprice(),
                    Updatedrequest.isDepositpaid(),
                    Updatedrequest.getBookingdates().getCheckin(),
                    Updatedrequest.getBookingdates().getCheckout(),
                    Updatedrequest.getAdditionalneeds()
            );


    }

    @Test (description = "Verify partial update booking Patch request" , groups = {"booking"})
    public void testPartialUpdateBookingWithPATCH() {
        //Load Cooking Creating Data
        JsonNode data = TestDataLoader.loadJson("src/test/resources/testdata/booking.json");
        BookingRequest request = BookingDataFactory.fromJson(data);
        int bookingId = Bookinghelper.createbookingAndgetId(request);
        System.out.println("This is Created Booking" + bookingId);
        //Update one field of the request
        PartialBookingUpdateRequest partialUpdate = new PartialBookingUpdateRequest();
        partialUpdate.setTotalprice(999);
        partialUpdate.setAdditionalneeds("Late Checkout");
        System.out.println("****This is Updated Booking request****" );
        System.out.println(partialUpdate);
        BookingService bookingService = new BookingService();
        Response response = bookingService.patchBooking(partialUpdate,bookingId);
        Assert.assertEquals(response.statusCode(), 200, "Expected status code 200");
        Booking booking = response.as(Booking.class);
        System.out.println(response.asPrettyString());
        BookingAssertions.verifyPatchBookingDetails(
                booking,
                request.getFirstname(),
                request.getLastname(),
                partialUpdate.getTotalprice(),
                request.isDepositpaid(),
                request.getBookingdates().getCheckin(),
                request.getBookingdates().getCheckout(),
                partialUpdate.getAdditionalneeds()
        );



    }
    @Test (description = "Verify delete booking request" , groups = {"booking"})
    public void testDeleteBooking() {
        JsonNode data = TestDataLoader.loadJson("src/test/resources/testdata/booking.json");
        System.out.println(data.toPrettyString());
        BookingRequest request = BookingDataFactory.fromJson(data);
        BookingResponse bookingdetails = Bookinghelper.createbookingAndreturnResponse(request);
        int bookingId = bookingdetails.getBookingid();
        BookingService bookingService = new BookingService();
        Response response = bookingService.deleteBooking(bookingId);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 201, "Default HTTP 201 response");
    }
}
