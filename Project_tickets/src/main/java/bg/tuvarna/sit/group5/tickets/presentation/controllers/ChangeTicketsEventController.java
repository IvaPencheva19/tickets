package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.Event;
import bg.tuvarna.sit.group5.tickets.data.entities.Tickets;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.ShowWarning;
import bg.tuvarna.sit.group5.tickets.presentation.models.TicketsModel;
import bg.tuvarna.sit.group5.tickets.service.DistributorService;
import bg.tuvarna.sit.group5.tickets.service.EventService;
import bg.tuvarna.sit.group5.tickets.service.SellTicketsService;
import bg.tuvarna.sit.group5.tickets.service.TicketsService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class ChangeTicketsEventController {
    @FXML
    private Label hello;
    @FXML
    private ListView listTickets;
    @FXML
    private TextField evName;
    @FXML
    private TextField type;
    @FXML
    private ComboBox comboChange;
    @FXML
    private TextField newVal;
    @FXML
    private Pane ticketsPane;
    private Event event;

    private SellTicketsService sellserv=SellTicketsService.getInstance();
    private EventService service = EventService.getInstance();
    private TicketsService tserv=TicketsService.getInstance();

    private TicketsModel tmodel;
    public void setUser() {
        hello.setText (HelloController.user.getUsername());
    }
    public void goBack(ActionEvent event) {
        HelloController.user.loadController();
        CloseForm.closeForm(event);
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
        comboChange.getItems().addAll("type","price","count");
    }
    public void changeValue(){
        String choice=comboChange.getValue().toString();
        String ntype=type.getText();
        Tickets tick=tserv.getByType(ntype,event);

        if(choice=="type"){
           String nVal=newVal.getText();
         tserv.changeType(tick,nVal);
        }
        if(choice=="price"){
            Double nprice=Double.parseDouble(this.newVal.getText());
            tserv.changePrice(tick,nprice);
        }
        if(choice=="price"){
            Integer ncount=Integer.parseInt(this.newVal.getText());
            tserv.changeCount(tick,ncount);
        }

    }
    public void deleteTicket(){
        String ntype=type.getText();
        Tickets tick=tserv.getByType(ntype,event);
      if (sellserv.checkSellTickets(tick)) {
            ShowWarning.showWarning("Can't delete ticket. There are selled tickets!");
        }

      else{
            tserv.deleteTickets(tick);
        }
    }
}
