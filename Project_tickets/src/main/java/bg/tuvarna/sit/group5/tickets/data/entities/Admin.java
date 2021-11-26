package bg.tuvarna.sit.group5.tickets.data.entities;

import bg.tuvarna.sit.group5.tickets.presentation.FormActions.OpenForm;
import bg.tuvarna.sit.group5.tickets.presentation.controllers.AdminAccountController;
import bg.tuvarna.sit.group5.tickets.presentation.controllers.DistributorAccountController;
import javafx.fxml.FXMLLoader;

import javax.persistence.*;


@Entity
@DiscriminatorValue("admin")
public class Admin extends User{
    public Admin(){}

    public Admin(String username, String password, String firstname, String lastname,
                 String phone, String email) {
        super(username, password, firstname, lastname, phone, email);
    }
    @Override
    public void loadController()
    {
        FXMLLoader loader = OpenForm.openNewForm("AdminAccountForm.fxml", "Admin");
        AdminAccountController next = loader.getController();
        next.setUser(this);
    }
}
