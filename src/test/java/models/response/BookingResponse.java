package models.response;

import models.request.BookingRequest;

public class BookingResponse {
     private int bookingid ;
     private BookingRequest booking;
    public BookingResponse() {
    }
    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public void setBooking(BookingRequest booking) {
        this.booking = booking;
    }

    public BookingRequest getBooking() {
        return booking;
    }


    public BookingResponse(int bookingid, BookingRequest booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }
}
