package models.response;

import models.request.BookingDates;


public class Booking {
    private String firstname;
    private String lastname;
    private double totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String  additionalneeds;
    public Booking(String firstname, String lastname, double totalprice, boolean depositpaid, BookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
        this.depositpaid = depositpaid;
    }

    public Booking() {}

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    @Override
    public String toString() {
        return "createBooking{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }


    public static class Builder{
        private String firstname;
        private String lastname;
        private  double  totalprice;
        private boolean depositpaid;
        private BookingDates bookingdates;
        private String  additionalneeds;

        public Booking.Builder firstname(String firstname){
            this.firstname = firstname;
            return this;
        }
        public Booking.Builder lastname(String lastname){
            this.lastname = lastname;
            return this;
        }
        public Booking.Builder totalprice(double totalprice){
            this.totalprice = totalprice;
            return this;
        }
        public Booking.Builder depositpaid(boolean deposit){
            this.depositpaid = deposit;
            return this;
        }
        public Booking.Builder bookingdates(BookingDates bookingdates){
            this.bookingdates = bookingdates;
            return this;
        }
        public Booking.Builder additionalneeds(String additionalneeds){
            this.additionalneeds = additionalneeds;
            return this;
        }

        public Booking build(){
            return new Booking(firstname, lastname, totalprice, depositpaid, bookingdates, additionalneeds);
        }
    }
}

