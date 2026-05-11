package assertions;

import models.response.Booking;
import models.response.BookingResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;



public class BookingAssertions {

    private static final Logger log = LoggerFactory.getLogger(BookingAssertions.class);

    public static void verifyBookingIdIsValid(BookingResponse response) {
        Assert.assertTrue(response.getBookingid() > 1,
                "Booking ID should be greater than 1");
    }

    public static void verifyCreateBookingDetails(BookingResponse response,
                                            String expectedFirstname,
                                            String expectedLastname,
                                            double expectedTotalPrice,
                                            boolean expectedDepositPaid,
                                            String expectedCheckin,
                                            String expectedCheckout,
                                            String expectedAdditionalNeeds) {

        Assert.assertEquals(response.getBooking().getFirstname(), expectedFirstname,
                "Firstname mismatch");

        Assert.assertEquals(response.getBooking().getLastname(), expectedLastname,
                "Lastname mismatch");
        Assert.assertEquals(
                String.format("%.2f", response.getBooking().getTotalprice()),
                String.format("%.2f", expectedTotalPrice),
                "Total price mismatch"
        );

        Assert.assertEquals(response.getBooking().isDepositpaid(), expectedDepositPaid,
                "Deposit paid mismatch");

        Assert.assertEquals(response.getBooking().getBookingdates().getCheckin(), expectedCheckin,
                "Checkin date mismatch");

        Assert.assertEquals(response.getBooking().getBookingdates().getCheckout(), expectedCheckout,
                "Checkout date mismatch");

        Assert.assertEquals(response.getBooking().getAdditionalneeds(), expectedAdditionalNeeds,
                "Additional needs mismatch");
        log.info("POST booking verification successful");
    }
    public static void verifyGetBookingDetails(Booking response,
                                     String expectedFirstname,
                                     String expectedLastname,
                                     double expectedTotalPrice,
                                     boolean expectedDepositPaid,
                                     String expectedCheckin,
                                     String expectedCheckout,
                                     String expectedAdditionalNeeds) {

        Assert.assertEquals(response.getFirstname(), expectedFirstname,
                "Firstname mismatch");
        Assert.assertEquals(response.getLastname(), expectedLastname,
                "Lastname mismatch");
        Assert.assertEquals(response.getTotalprice(), expectedTotalPrice,
                "Total price mismatch");
        Assert.assertEquals(response.isDepositpaid(), expectedDepositPaid,
                "Deposit paid mismatch");
        Assert.assertEquals(response.getBookingdates().getCheckin(), expectedCheckin,
                "Checkin date mismatch");
        Assert.assertEquals(response.getBookingdates().getCheckout(), expectedCheckout,
                "Checkout date mismatch");
        Assert.assertEquals(response.getAdditionalneeds(), expectedAdditionalNeeds,
                "Additional needs mismatch");
        log.info("GET booking details verification successful ");
    }

    public static void verifyPutBookingDetails(Booking response,
                                               String expectedFirstname,
                                               String expectedLastname,
                                               double expectedTotalPrice,
                                               boolean expectedDepositPaid,
                                               String expectedCheckin,
                                               String expectedCheckout,
                                               String expectedAdditionalNeeds) {

        Assert.assertEquals(response.getFirstname(), expectedFirstname,
                "Firstname mismatch");
        Assert.assertEquals(response.getLastname(), expectedLastname,
                "Lastname mismatch");
        Assert.assertEquals(
                String.format("%.2f", response.getTotalprice()),
                String.format("%.2f", expectedTotalPrice),
                "Total price mismatch"
        );
        Assert.assertEquals(response.isDepositpaid(), expectedDepositPaid,
                "Deposit paid mismatch");
        Assert.assertEquals(response.getBookingdates().getCheckin(), expectedCheckin,
                "Checkin date mismatch");
        Assert.assertEquals(response.getBookingdates().getCheckout(), expectedCheckout,
                "Checkout date mismatch");
        Assert.assertEquals(response.getAdditionalneeds(), expectedAdditionalNeeds,
                "Additional needs mismatch");
        log.info("PUT booking details Update successful ");
    }
    public static void verifyPatchBookingDetails(Booking response,
                                                 String expectedFirstname,
                                                 String expectedLastname,
                                                 double expectedTotalPrice,
                                                 boolean expectedDepositPaid,
                                                 String expectedCheckin,
                                                 String expectedCheckout,
                                                 String expectedAdditionalNeeds) {

        Assert.assertEquals(response.getFirstname(), expectedFirstname,
                "Firstname mismatch");
        Assert.assertEquals(response.getLastname(), expectedLastname,
                "Lastname mismatch");
        Assert.assertEquals(
                String.format("%.2f", response.getTotalprice()),
                String.format("%.2f", expectedTotalPrice),
                "Total price mismatch"
        );
        Assert.assertEquals(response.isDepositpaid(), expectedDepositPaid,
                "Deposit paid mismatch");
        Assert.assertEquals(response.getBookingdates().getCheckin(), expectedCheckin,
                "Checkin date mismatch");
        Assert.assertEquals(response.getBookingdates().getCheckout(), expectedCheckout,
                "Checkout date mismatch");
        Assert.assertEquals(response.getAdditionalneeds(), expectedAdditionalNeeds,
                "Additional needs mismatch");
        log.info("Partial booking details update successful with bookingid: {}");
    }
}

