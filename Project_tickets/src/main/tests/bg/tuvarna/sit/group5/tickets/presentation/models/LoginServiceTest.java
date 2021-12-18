package bg.tuvarna.sit.group5.tickets.presentation.models;

import bg.tuvarna.sit.group5.tickets.data.entities.User;
import bg.tuvarna.sit.group5.tickets.service.LoginService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


public class LoginServiceTest {
    LoginService lserv=new LoginService();
    @Test
    void testValidateUserLoginTrue(){
        User user= lserv.validateUserLogin("ivan222","222");
        assertNotNull(user);
    }
    @Test
    void testValidateUserLoginFalse(){
        User user= lserv.validateUserLogin("ivan","222");
        assertNull(user);
    }
}
