package no.hvl.dat110.chapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Chapp extends Application {

	@Override
	public void start(Stage stage) {

		stage.setTitle("ChApp - Chat Application");

		HBox hbox = new HBox();

		CommandArea carea = new CommandArea();
		MessageArea marea = new MessageArea();

		Menus menus = new Menus(stage, carea, marea);

		Controller controller = new Controller(marea);

		carea.setupCommandArea(hbox, controller, marea);
		marea.setupMessageAera(hbox, controller);

		menus.setController(controller);
		MenuBar menuBar = menus.getMenuBar();

		VBox vbox = new VBox(menuBar, hbox);

		Scene scene = new Scene(vbox, 750, 500);

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		
		Application.launch(args);
		
	}
}
