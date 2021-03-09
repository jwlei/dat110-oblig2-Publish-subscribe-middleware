package no.hvl.dat110.chapp;

import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class Menus {

	private Controller controller;
	private CommandArea carea;
	private MessageArea marea;
	
	private MenuBar menuBar;
	
	public Menus(Stage stage, CommandArea area, MessageArea marea) {

		menuBar = new MenuBar();

		this.carea = area;
		this.marea = marea;
		
		// Configure Menu
		Menu menuConfigure = new Menu("Configure");

		MenuItem userItem = new MenuItem("User ...");

		EventHandler<ActionEvent> userhandler = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				TextInputDialog dialog = new TextInputDialog("");
				dialog.setTitle("User");
				dialog.setHeaderText("Username");
				dialog.setContentText("");

				Optional<String> result = dialog.showAndWait();

				if (result.isPresent()) {
					String user = result.get();
					controller.setUser(user);
					carea.setUser(user);
				}

			}
		};

		userItem.setOnAction(userhandler);
		
		MenuItem brokerItem = new MenuItem("Broker ...");

		EventHandler<ActionEvent> brokerhandler = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				TextInputDialog dialog = new TextInputDialog("");
				dialog.setTitle("Broker");
				dialog.setHeaderText("Hostname");
				dialog.setContentText("");

				Optional<String> result = dialog.showAndWait();

				if (result.isPresent()) {
					String hostname = result.get();
					controller.setBrokerhost(hostname);
					carea.setHostPort(hostname,Integer.toString(controller.getBrokerport()));
				}

			}
		};

		brokerItem.setOnAction(brokerhandler);
		
		MenuItem portItem = new MenuItem("Port ...");

		EventHandler<ActionEvent> porthandler = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				TextInputDialog dialog = new TextInputDialog("");
				dialog.setTitle("Broker");
				dialog.setHeaderText("Port");
				dialog.setContentText("");

				Optional<String> result = dialog.showAndWait();

				if (result.isPresent()) {
					String port = result.get();
					controller.setBrokerport(Integer.parseInt(port));
					carea.setHostPort(controller.getBrokerhost(),port);
				}

			}
		};

		portItem.setOnAction(porthandler);
		
		MenuItem exitItem = new MenuItem("Exit");

		EventHandler<ActionEvent> exithandler = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				
				// assume that the user does not quit without first doing disconnect
				Platform.exit();
				
			}
		};
		
		exitItem.setOnAction(exithandler);
		
		menuConfigure.getItems().addAll(userItem,brokerItem,portItem,exitItem);
		
		menuBar.getMenus().addAll(menuConfigure);
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public Controller getController() {
		return controller;
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}
	
	

}
