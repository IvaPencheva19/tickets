package bg.tuvarna.sit.group5.tickets.presentation.models;

public class DistributorShortModel {
    private String username;
    private String firstName;
    private String lastName;



    public DistributorShortModel(String username,String firstName, String lastName) {
        this.username = username;

        this.firstName=firstName;
        this.lastName=lastName;

    }


    @Override
    public String toString() {
        return  String.format("%s                %s                 %s",username,
                firstName, lastName);
    }
}
