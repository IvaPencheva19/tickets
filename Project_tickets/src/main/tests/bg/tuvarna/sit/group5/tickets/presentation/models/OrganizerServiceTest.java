package bg.tuvarna.sit.group5.tickets.presentation.models;

import bg.tuvarna.sit.group5.tickets.data.entities.Distributor;
import bg.tuvarna.sit.group5.tickets.data.entities.Organizer;
import bg.tuvarna.sit.group5.tickets.data.repositories.UserRepository;
import bg.tuvarna.sit.group5.tickets.service.OrganizerService;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrganizerServiceTest {
    OrganizerService oserv = OrganizerService.getInstance();
    UserRepository urep = UserRepository.getInstance();

    @Test
    void testChangeUserName() {
        Organizer org = (Organizer) urep.getByUsername("org1");
        oserv.changeUserName(org, "organizer1");
        assertEquals("organizer1", org.getUsername());
    }

    @Test
    void testChangePassword() {
        Organizer org = (Organizer) urep.getByUsername("organizer1");
        oserv.changePassword(org, "organizer1");
        assertEquals("organizer1", org.getPassword());
    }

    @Test
    void testChangeFirstName() {
        Organizer org = (Organizer) urep.getByUsername("organizer1");
        oserv.changeFirstName(org, "Diqn");
        assertEquals("Diqn", org.getFirstname());
    }

    @Test
    void testChangeLastName() {
        Organizer org = (Organizer) urep.getByUsername("organizer1");
        oserv.changeLastName(org, "Zlatkov");
        assertEquals("Zlatkov", org.getLastname());
    }

    @Test
    void testChangePhone() {
        Organizer org = (Organizer) urep.getByUsername("organizer1");
        oserv.changePhone(org, "0882237834");
        assertEquals("0882237834", org.getPhone());
    }

    @Test
    void testChangeEmail() {
        Organizer org = (Organizer) urep.getByUsername("organizer1");
        oserv.changeEmail(org, "ddzlatkov301@gmail.com");
        assertEquals("ddzlatkov301@gmail.com", org.getEmail());
    }

    @Test
    void testChangeHonor() {
        Organizer org = (Organizer) urep.getByUsername("organizer1");
        oserv.changeHonor(org, 1700);
        assertEquals(1700, org.getHonor());
    }

    @Test
    void testCreateOrganizer() {
        Organizer org = new Organizer("todort9", "todort9", "Todor", "Stanchev", "0886746112", "t_stanchev8@gmail.com", 1300);
        oserv.createOrganizer(org);
        Organizer reptype = oserv.getByUsername("todort9");
        assertNotNull(reptype);
        assertEquals(org, reptype);
    }

    @Test
    void testDeleteOrganizer() {
        Organizer org = oserv.getByUsername("org2");
        oserv.deleteOrganizer(org);
        Organizer reptype = oserv.getByUsername("org2");
        assertNull(reptype);
    }

    @Test
    void testGetByUserName() {
        Organizer org = oserv.getByUsername("todort9");
        assertNotNull(org);
        assertEquals("todort9", org.getUsername());
    }
    @Test
    void getAllOrganizers(){
        ObservableList<OrganizerModel> org=oserv.getAllOrganizers();
        assertNotNull(org);
        assertEquals(3,org.size());
    }

}