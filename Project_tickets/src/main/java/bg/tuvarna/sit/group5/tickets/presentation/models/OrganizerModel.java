package bg.tuvarna.sit.group5.tickets.presentation.models;

public class OrganizerModel {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private double honor;


    public OrganizerModel(String username, String password, String firstName, String lastname,
                         String phone, String email, double honor ) {
        this.username = username;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastname;
        this.phone=phone;
        this.email=email;
        this.honor=honor;
    }


    @Override
    public String toString() {
        return  String.format("%s %s %s %s %s %s %s",username, password,
                firstName, lastName, phone,email, honor);
    }
}
