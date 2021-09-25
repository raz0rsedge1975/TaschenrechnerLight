package handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class ResetHandler implements EventHandler<ActionEvent> {

    private final TextField ausgabe;


    public ResetHandler(TextField ausgabe ) { this.ausgabe = ausgabe; }
    @Override
    public void handle(ActionEvent actionEvent) {
        ausgabe.setText("");
        }

    }
