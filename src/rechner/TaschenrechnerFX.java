package rechner;

import handler.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TaschenrechnerFX extends Application {

	private final FlowPane root = new FlowPane();
	private final TextField ausgabe = new TextField("");
	private final char[] buttons = {
			'7', '8', '9', 'C',
			'4', '5', '6', '+',
			'1', '2', '3', '-',
			'.', '0', '±', '*',
			 '/', '²','Ѵ', '='};

	public static void main(String[] args) {
		launch(args);
	}

	private void buildSceneLayout() {
		//Alle Zeichen von buttons in ButtonArray schubsen
		//Hier für 16 Buttons
		Button[] bArray = new Button[20];
		for (int i = 0; i < buttons.length; i++) {
			String name = buttons[i] + ""; //Type conversion from char to string
			bArray[i] = new Button(name);
		}
		//FlowPane settings
		root.setAlignment(Pos.TOP_CENTER);
		root.setPadding(new Insets(15.));
		root.setVgap(7.);
		root.setHgap(5.);
		ausgabe.setPrefSize(235., 38.);
		ausgabe.setEditable(false);
		ausgabe.setAlignment(Pos.BASELINE_RIGHT);
		ausgabe.setStyle("-fx-font-size: 18;-fx-border-color: #00CCCC;" +
				"-fx-border-size: 9px;-fx-font-weight: bold;" +
				"-fx-background-color: #D0D0D1;-fx-border-radius: 5px");
		//ausgabe.setSkin(new TextAreaSkin(new TextArea("*")));
		DropShadow shadow = new DropShadow();

		//Buttons erstellen und settings
		for (Button buttons : bArray) {
			buttons.setMinSize(55, 55);
			buttons.setPadding(new Insets(5.));
			buttons.setCursor(Cursor.HAND);
			buttons.setStyle("-fx-font-weight: bold;-fx-font-size: 18;-fx-border-radius: 10px");
			buttons.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					buttons.isFocused();
					buttons.setEffect(shadow);
				}
			});
			buttons.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseEvent) {
					buttons.disarm();
					buttons.setEffect(null);
				}
			});
			String buttonname = String.valueOf(buttons.getText());
			switch (buttonname) {
				case "C":
					buttons.setOnAction(new ResetHandler(ausgabe));
					break;
				case "+":
					buttons.setOnAction(new PlusHandler(ausgabe));
					break;
				case "*":
					buttons.setOnAction(new MalHandler(ausgabe));
					break;
				case "/":
					buttons.setOnAction(new DivHandler(ausgabe));
					break;
				case "-":
					buttons.setOnAction(new MinusHandler(ausgabe));
					break;
				case "±":
					buttons.setOnAction(new PlusMinusHandler(ausgabe));
					break;
				case ".":
					buttons.setOnAction(new KommaHandler(ausgabe));
					break;
				case "=":
					buttons.setOnAction(new CalcHandler(ausgabe));
					break;
				case "²":
					buttons.setOnAction(new SquareHandler(ausgabe));
					break;
				case "Ѵ":
					buttons.setOnAction(new RootHandler(ausgabe));
					break;
				default:
					buttons.setOnAction(new ZahlenHandler(ausgabe, buttons));
					break;
			}

		}



		root.setStyle("-fx-border-color: darkgrey;-fx-border-size: 5px");
		root.getChildren().add(ausgabe);
		root.getChildren().addAll(bArray);
	}

	@Override
	public void start(Stage window) {
		Scene scene = new Scene(root, 270, 375);
		window.setScene(scene);
		window.setResizable(false);
		window.setTitle("   Tasche Rechne!  ");
		buildSceneLayout();
		window.show();
	}

}

