package datafactory;

import com.fasterxml.jackson.databind.JsonNode;
import models.request.BookingDates;
import models.request.BookingRequest;

public class BookingDataFactory {

    public static BookingRequest fromJson(JsonNode data) {
        //first load the nested POJO as it is required for the Booking request POJO
        BookingDates dates = new BookingDates.Builder()
                .checkin(data.get("bookingdates").get("checkin").asText())
                .checkout(data.get("bookingdates").get("checkout").asText())
                .build();
        return new BookingRequest.Builder()
                .firstname(data.get("firstname").asText())
                .lastname(data.get("lastname").asText())
                .totalprice(data.get("totalprice").asDouble())
                .depositpaid(data.get("depositpaid").asBoolean())
                .bookingdates(dates)
                .additionalneeds(data.get("additionalneeds").asText())
                .build();
    }
}
