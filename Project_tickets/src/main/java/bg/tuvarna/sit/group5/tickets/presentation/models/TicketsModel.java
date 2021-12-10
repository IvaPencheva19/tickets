package bg.tuvarna.sit.group5.tickets.presentation.models;

import bg.tuvarna.sit.group5.tickets.data.entities.Event;

public class TicketsModel {
    private String type;
    private double price;
    private int count;
    private Event event;

    public TicketsModel(String type, double price, int count, Event event) {
        this.type = type;
        this.price = price;
        this.count = count;
    }

    public String toString() {
        return  String.format("%s %s %s  ",type, price,
                count);
    }
}
