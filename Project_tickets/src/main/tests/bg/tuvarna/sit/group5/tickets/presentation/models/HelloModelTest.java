package bg.tuvarna.sit.group5.tickets.presentation.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloModelTest {

    private HelloModel helloModel;

    @BeforeEach
    void setUp() {
        helloModel=new HelloModel();
    }

    @Test
    void getWelcomeMessage() {
        assertEquals("Hello", helloModel.getWelcomeMessage());
    }
}