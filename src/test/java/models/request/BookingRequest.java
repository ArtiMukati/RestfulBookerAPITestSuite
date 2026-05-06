package models.request;

public class BookingRequest {
        private String firstname;
        private String lastname;
        private double  totalprice;
        private boolean depositpaid;
        private BookingDates bookingdates;
        private String  additionalneeds;

    public BookingRequest(String firstname, String lastname, double totalprice, boolean depositpaid, BookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
        this.depositpaid = depositpaid;
    }

    public BookingRequest() {}

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
        return "createBookingRequest{" +
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
        private double  totalprice;
        private boolean depositpaid;
        private BookingDates bookingdates;
        private String  additionalneeds;

        public Builder firstname(String firstname){
            this.firstname = firstname;
            return this;
        }
        public Builder lastname(String lastname){
            this.lastname = lastname;
            return this;
        }
        public Builder totalprice(double totalprice){
            this.totalprice = totalprice;
            return this;
        }
        public Builder depositpaid(boolean deposit){
            this.depositpaid = deposit;
            return this;
        }
        public Builder bookingdates(BookingDates bookingdates){
            this.bookingdates = bookingdates;
            return this;
        }
        public Builder additionalneeds(String additionalneeds){
            this.additionalneeds = additionalneeds;
            return this;
        }
        
        public BookingRequest build(){
            return new BookingRequest(firstname, lastname, totalprice, depositpaid, bookingdates, additionalneeds);
        }
    }
}
