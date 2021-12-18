package bg.tuvarna.sit.group5.tickets.presentation.models;

import bg.tuvarna.sit.group5.tickets.data.entities.Admin;
import bg.tuvarna.sit.group5.tickets.data.repositories.UserRepository;
import bg.tuvarna.sit.group5.tickets.service.AdminService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminServiceTest {
    AdminService admserv=AdminService.getInstance();
    UserRepository urep=UserRepository.getInstance();
    @Test
    void testChangeUserName() {
        Admin admr=(Admin)urep.getByUsername("admin1");
        admserv.changeUserName(admr,"admin");
        assertEquals("admin",admr.getUsername());
    }
    @Test
    void testChangePassword() {
        Admin admr=(Admin)urep.getByUsername("admin");
        admserv.changePassword(admr,"admin");
        assertEquals("admin",admr.getPassword());
    }
    @Test
    void testChangeFirstName() {
        Admin admr=(Admin)urep.getByUsername("admin");
        admserv.changeFirstName(admr,"Georgi");
        assertEquals("Georgi",admr.getFirstname());
    }
    @Test
    void testChangeLastName() {
        Admin admr=(Admin)urep.getByUsername("admin");
        admserv.changeLastName(admr,"Petrov");
        assertEquals("Petrov",admr.getLastname());
    }
    @Test
    void testChangePhone() {
        Admin admr=(Admin)urep.getByUsername("admin");
        admserv.changePhone(admr,"0882677855");
        assertEquals("0882677855",admr.getPhone());
    }
    @Test
    void testChangeEmail() {
        Admin admr=(Admin)urep.getByUsername("admin");
        admserv.changeEmail(admr,"gpetrov21@gmail.com");
        assertEquals("gpetrov21@gmail.com",admr.getEmail());
    }



}
