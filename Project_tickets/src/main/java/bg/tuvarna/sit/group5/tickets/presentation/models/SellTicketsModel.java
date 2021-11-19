package bg.tuvarna.sit.group5.tickets.presentation.models;

import bg.tuvarna.sit.group5.tickets.data.entities.DistribEvent;
import bg.tuvarna.sit.group5.tickets.data.entities.Tickets;

public class SellTicketsModel {
    private int count;
    private int seat;
    private String customerName;
    private Tickets ticketsType;
    private DistribEvent distribEvent;

    public SellTicketsModel(int count, int seat, String customerName,
                            Tickets ticketsType, DistribEvent distribEvent) {
        this.count = count;
        this.seat = seat;
        this.customerName = customerName;
        this.ticketsType = ticketsType;
        this.distribEvent = distribEvent;
    }

    public String toString() {
        return  String.format("%s %s %s %s %s  ",count, seat,
                customerName, ticketsType, distribEvent);
    }
}
