package handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ZahlenHandler implements EventHandler<ActionEvent> {
    private final Button button;
    private final TextField ausgabe;


    public ZahlenHandler(TextField ausgabe, Button button) {
        this.button = button;
        this.ausgabe = ausgabe;
    }
    @Override
    public void handle(ActionEvent actionEvent) {

        if (!ausgabe.getText().contains(".") && ausgabe.getText().contains("0") && button.getText().contains("0"))
            ausgabe.setText(ausgabe.getText());
        else ausgabe.setText(ausgabe.getText() + button.getText());
    }

}
