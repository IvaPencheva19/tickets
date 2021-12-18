package bg.tuvarna.sit.group5.tickets.service;

import bg.tuvarna.sit.group5.tickets.data.entities.SellTickets;
import bg.tuvarna.sit.group5.tickets.data.entities.Tickets;
import bg.tuvarna.sit.group5.tickets.data.repositories.SellTicketsRepository;
import bg.tuvarna.sit.group5.tickets.presentation.models.SellTicketsModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class SellTicketsService {
    private final SellTicketsRepository repository = SellTicketsRepository.getInstance();

    public static SellTicketsService getInstance() {
        return SellTicketsService.SellTicketsHolder.INSTANCE;
    }

    private static class SellTicketsHolder {
        public static final SellTicketsService INSTANCE = new SellTicketsService();
    }

    public void createSellTickets(SellTickets sellTickets){
        repository.save(sellTickets);
    }

    /*public void deleteEvent(SellTickets sellTickets){
        repository.delete(sellTickets);
    }*/
    public boolean checkSellTickets(Tickets tick){
        List<SellTickets>stickets=repository.getAll();
        for(SellTickets t:stickets){
            if (t.getTicket_type().equals(tick))
                return true;
        }
        return false;
    }




}
