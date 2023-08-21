package pojos;

public class BookingDatesPojo {



    private String checkin;
    private String checkout;

    public BookingDatesPojo (){//parametresiz constructor

    }

    public BookingDatesPojo(String ckeckin, String checkout) {
        this.checkin = ckeckin;
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String ckeckin) {
        this.checkin = ckeckin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
