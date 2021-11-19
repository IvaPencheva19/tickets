package bg.tuvarna.sit.group5.tickets.presentation.models;

import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Event;

public class DistribEventModel {
    private Event event;
    private Distributor distributor;

    public DistribEventModel(Event event, Distributor distributor) {
        this.event = event;
        this.distributor = distributor;
    }

    public String toString() {
        return  String.format("%s %s ",event, distributor);
    }
}
