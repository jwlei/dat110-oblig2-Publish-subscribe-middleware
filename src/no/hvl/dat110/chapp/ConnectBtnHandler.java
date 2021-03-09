package no.hvl.dat110.chapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ConnectBtnHandler implements EventHandler<ActionEvent> {

	private Controller controller;
	private Button button;
	private MessageArea marea;
	
	public ConnectBtnHandler(Controller controller, Button button, MessageArea marea) {
		this.controller = controller;
		this.button = button;
		this.marea = marea;
	}

	@Override
    public void handle(ActionEvent actionEvent) {
    	
    	System.out.println("Connect/Disconnect");
    	    	
    	if (controller.isConnected()) {
    		
    		controller.disconnect();
    		button.setText("Connect");
    		marea.stopMessageHandler();
    		
    		
    	} else {
    		
    		controller.connect();
    		button.setText("Disconnect");
    		marea.startMessageHandler();
    		
    	}
    		
    }
}
