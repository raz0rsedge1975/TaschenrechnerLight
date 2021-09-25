package handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class PlusMinusHandler implements EventHandler<ActionEvent> {

    private final TextField ausgabe;


    public PlusMinusHandler(TextField ausgabe ) { this.ausgabe = ausgabe; }
    @Override
    public void handle(ActionEvent actionEvent) {
        //Hier fehlt Fallunterscheidung ob Erste oder weitere Zahl, wenn weitere Zahl dann Vorzeichen
        //vor weitere Zahl in Klammern
        CharSequence charlist = ausgabe.getCharacters();
        if (charlist.charAt(charlist.length()-1) == '+' || charlist.charAt(charlist.length()-1) == '-') {
            ausgabe.setText("ERROR");
        }
        else if (!ausgabe.getText().contains("+") && !ausgabe.getText().contains("-")) {
            double dtmp = Double.parseDouble(ausgabe.getText());
            dtmp*=-1.;
            ausgabe.setText(Double.toString(dtmp));
        }
        else if (ausgabe.getText().contains("+") || ausgabe.getText().contains("-")) {
            try {
                double dtmp = Double.parseDouble(ausgabe.getText());
                dtmp*=-1.;
                ausgabe.setText(Double.toString(dtmp));
            } catch (NumberFormatException e) {
                //e.printStackTrace();
                ausgabe.setText("ERROR");
            }
        }


    }

    }
