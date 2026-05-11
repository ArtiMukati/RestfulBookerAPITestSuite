package models.request;

public class PartialBookingUpdateRequest {
    private double totalprice;
    private String  additionalneeds;

    public PartialBookingUpdateRequest(){
        //Required for Jackson deserialization
    }

    @Override
    public String toString() {
        return "PartialBookingUpdateRequest{" +
                "totalprice=" + totalprice +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }

    public PartialBookingUpdateRequest(double totalprice, String additionalneeds) {
        this.totalprice = totalprice;
        this.additionalneeds = additionalneeds;
    }

    public void setTotalprice(double totalprice) {

        this.totalprice = totalprice;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }
}
