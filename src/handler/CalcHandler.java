package handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class CalcHandler implements EventHandler<ActionEvent> {

    private final TextField ausgabe;

    public CalcHandler(TextField ausgabe ) { this.ausgabe = ausgabe; }
    @Override
    public void handle(ActionEvent actionEvent) {
        char[] zeichen = ausgabe.getText().toCharArray(); //alle Zeichen des Strings separieren
        System.out.println("Zeichenfolge: "+ Arrays.toString(zeichen));
        String tmpZiffer ="";
        double zwischenErg = 0;
        char op = ' ';
        int opcounter = 0;
        //debug
        // Laufe durch das Zeichen-Array
        for (char c : zeichen) {

            if (c != '-' && c != '+' && c != '*' && c != '/' && opcounter == 0) tmpZiffer+=c; //prüfe auf Ziffern
            else if (c != '-' && c != '+' && c != '*' && c != '/' && opcounter == 1) {
                double a = Double.parseDouble(tmpZiffer); //schiebt Wert aus tmp in Variable A
                tmpZiffer="";
                tmpZiffer+=c;
                double b = Double.parseDouble(tmpZiffer); //Aktuellen Wert in B
                System.out.println("Variable A:"+a);
                System.out.println("Variable B:"+b);
                zwischenErg = doOperation(op,a,b);
                tmpZiffer = String.valueOf(zwischenErg);
                System.out.println("Zwischenergebnis: "+tmpZiffer);
                ausgabe.setText(tmpZiffer);
                opcounter = 0;
            }

            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '²' || c == 'Ѵ') {
                op = c;
                opcounter++;
                System.out.println("Erkannter Operator: "+op);
                if (c == '²' || c == 'Ѵ') {
                    double b = Double.parseDouble(String.valueOf(tmpZiffer.charAt(tmpZiffer.length()-2)));
                    //schiebt Wert aus tmp in Variable A
                    System.out.println("SingleVar B:"+b);
                    zwischenErg = doOperation(op,0,b); //A wird auf 0 gesetzt, da b*b
                }
                ausgabe.setText(String.valueOf(zwischenErg));
            }
        }
    }

    // A utility method to apply an operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static double doOperation(char op, double a, double b)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                try {
                    return a / b;
                } catch (Exception e) {
                    return 666;
                }
            case '²':
                return b*b;
            case 'Ѵ':
                return Math.sqrt(b);
        }
        return 0;
    }
}


