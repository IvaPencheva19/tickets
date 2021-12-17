package bg.tuvarna.sit.group5.tickets.presentation.controllers;

import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Event;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.CloseForm;
import bg.tuvarna.sit.group5.tickets.presentation.FormActions.ShowWarning;
import bg.tuvarna.sit.group5.tickets.presentation.models.DistributorShortModel;
import bg.tuvarna.sit.group5.tickets.service.DistributorService;
import bg.tuvarna.sit.group5.tickets.service.EventService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.Set;

public class ChangeDistributorsEventController {
    @FXML
    Label hello;
    @FXML
    ListView loadList;
    @FXML
    TextField iEvent;
    @FXML
    TextField newVal;
    private Set<Distributor> dists;
    private Event event;
    private  Distributor dist;
    private EventService evserv=EventService.getInstance();
    private DistributorService dserv=DistributorService.getInstance();
    public void goBack(ActionEvent event){
        HelloController.user.loadController();
        CloseForm.closeForm(event);
    }
    public void setUser() {
        hello.setText (HelloController.user.getUsername());
    }
  public void searchByEvent(){
        loadList.getItems().clear();
        String toSearch=iEvent.getText();
         event= evserv.getByName(toSearch);
        dists=event.getDistribEvent();
      DistributorShortModel dmodel;
        for(Distributor d:dists){
            dmodel=new DistributorShortModel(d.getUsername(),d.getFirstname(),d.getLastname());
            loadList.getItems().add(dmodel);
        }


  }
  public void addDistributor(){

      String username=this.newVal.getText();
       dist=dserv.getByUsername(username);
      if (dist==null) ShowWarning.showWarning("There is no distributor with this username!");
      else{
        evserv.addDistributor(event,dist);
          DistributorShortModel dmodel=new DistributorShortModel(dist.getUsername(),dist.getFirstname(),dist.getLastname());
          loadList.getItems().add(dmodel);
      }
  }

        public void deleteDistributor(){
        String username=this.newVal.getText();
         dist=dserv.getByUsername(username);
        if (dist==null) ShowWarning.showWarning("There is no distributor with this username!");
        else{
            evserv.deleteDistributor(event,dist);
        }
    }


}
