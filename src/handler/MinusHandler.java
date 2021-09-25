package handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class MinusHandler implements EventHandler<ActionEvent> {

    private final TextField ausgabe;

    public MinusHandler(TextField ausgabe) {
        this.ausgabe = ausgabe;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        char tmp = ausgabe.getText().charAt(ausgabe.getLength()-1);
        if (tmp == '-') ausgabe.setText(ausgabe.getText());
        else ausgabe.setText(ausgabe.getText() + '-');

    }
}
