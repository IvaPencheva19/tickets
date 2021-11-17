package bg.tuvarna.sit.group5.tickets.presentation.models;

public class EventTypeModel {
    private String type;


    public EventTypeModel(String type) {
        this.type = type;

    }

    @Override
    public String toString() {
        return  String.format("%s",type);
    }
}
