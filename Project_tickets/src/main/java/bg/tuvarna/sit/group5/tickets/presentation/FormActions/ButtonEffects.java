package bg.tuvarna.sit.group5.tickets.presentation.FormActions;

import javafx.scene.control.Button;
import javafx.scene.effect.Glow;

public class ButtonEffects {
    public static void makeEffect(Button button){
        Glow glow = new Glow();

        glow.setLevel(0.5);
        button.setEffect(glow);
    }
    public static void removeEffect(Button button){
        button.setEffect(null);
    }
}
