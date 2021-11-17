package bg.tuvarna.sit.group5.tickets.presentation.models;

public class AllOrganizerModel {
    private String username;


    public AllOrganizerModel(String username) {
        this.username = username;

    }


    @Override
    public String toString() {
        return  String.format("%s",username);
    }
}
