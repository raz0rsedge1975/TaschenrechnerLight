package handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class KommaHandler implements EventHandler<ActionEvent> {

    private final TextField ausgabe;

    public KommaHandler(TextField ausgabe ) { this.ausgabe = ausgabe; }
    @Override
    public void handle(ActionEvent actionEvent) {
        char tmp ='0';
        try {
            tmp = ausgabe.getText().charAt(ausgabe.getLength()-1);
        } catch (Exception e) {
            System.out.println("Letztes Zeichen:"+tmp);
        }

        if (tmp == '.') {
            if (ausgabe.getText().contains(".")) ausgabe.setText(ausgabe.getText());
        }
        if (tmp != '.')
            if (ausgabe.getText().contains("+")) ausgabe.setText(ausgabe.getText() + '.');
            else ausgabe.setText(ausgabe.getText() + '.');
        }
}
