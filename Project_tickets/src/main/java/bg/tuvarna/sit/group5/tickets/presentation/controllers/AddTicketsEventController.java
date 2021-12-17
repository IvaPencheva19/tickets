package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.Event;
import bg.tuvarna.sit.group5.tickets.data.entities.Tickets;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.ShowWarning;
import bg.tuvarna.sit.group5.tickets.presentation.models.TicketsModel;
import bg.tuvarna.sit.group5.tickets.service.DistributorService;
import bg.tuvarna.sit.group5.tickets.service.EventService;
import bg.tuvarna.sit.group5.tickets.service.TicketsService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class AddTicketsEventController {
    @FXML
    Label hello;
   @FXML
   TextField evName;
    @FXML
    TextField type;
    @FXML
    TextField price;
    @FXML
    TextField count;
    @FXML
    ListView listTickets;
    @FXML
    Pane ticketsPane;
    private Event event;
    private EventService service = EventService.getInstance();
    private TicketsService tserv=TicketsService.getInstance();
    private TicketsModel tmodel;

    public void goBack(ActionEvent event) {
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }

    public void setUser() {
        hello.setText(HelloController.user.getUsername());
    }
    public void showTickets(){
        listTickets.getItems().clear();
        String ename=evName.getText();
        event=service.getByName(ename);
        if (event==null){
            ShowWarning.showWarning("There is no event with this name!");
            ticketsPane.setDisable(true);}
        else{
            for(Tickets t:event.getTicketsByIdEvent()){
                tmodel=new TicketsModel(t.getType(),t.getPrice(),t.getCount());
                listTickets.getItems().add(tmodel);
            }
            ticketsPane.setDisable(false);
        }
    }
    public void addNewTicket(){
        String ntype=type.getText();
        Double nprice=Double.parseDouble(this.price.getText());
        Integer ncount=Integer.parseInt(this.count.getText());
        Tickets ticks=new Tickets(ntype,nprice,ncount,event);
        tserv.createTickets(ticks);
        service.addTicket(event,ticks);
        tmodel=new TicketsModel(ticks.getType(),ticks.getPrice(),ticks.getCount());
        listTickets.getItems().add(tmodel);
        clear();

    }
    public void clear(){
        type.clear();
        price.clear();
        count.clear();
    }
}
