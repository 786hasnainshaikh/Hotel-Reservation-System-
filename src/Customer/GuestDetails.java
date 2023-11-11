package Customer;

public class GuestDetails {
    private String guest_name;
    private String room_number;
    private String contact_number;

    public GuestDetails(String guest_name, String room_number, String contact_number) {
        this.guest_name = guest_name;
        this.room_number = room_number;
        this.contact_number = contact_number;
    }

    public GuestDetails() {
    }

    public String getGuest_name() {
        return guest_name;
    }

    public String setGuest_name(String guest_name) {
        this.guest_name = guest_name;
        return guest_name;
    }

    public String getRoom_number() {
        return room_number;
    }

    public String setRoom_number(String room_number) {
        this.room_number = room_number;
        return room_number;
    }

    public String getContact_number() {
        return contact_number;
    }

    public String setContact_number(String contact_number) {
        this.contact_number = contact_number;
        return contact_number;
    }

    @Override
    public String toString() {
        return "GuestDetails{" +
                "guest_name='" + guest_name + '\'' +
                ", room_number='" + room_number + '\'' +
                ", contact_number='" + contact_number + '\'' +
                '}';
    }
}
