package bg.tuvarna.sit.group5.tickets.presentation.models;


import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Tickets;

public class SellTicketsModel {
    private int count;

    private String customerName;
    private String ticketsType;
    //private DistribEvent distribEvent;

    public SellTicketsModel(int count,  String customerName,
                            Tickets ticketsType) {
        this.count = count;

        this.customerName = customerName;
        this.ticketsType = ticketsType.getType();

    }



    public String toString() {
        return  String.format("%s                                       %s                                                                        %s ",count,
                customerName, ticketsType);
    }
}
