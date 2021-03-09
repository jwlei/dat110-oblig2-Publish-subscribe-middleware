package no.hvl.dat110.chapp;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MessageArea {

	private Controller controller;
    private MessageHandler msghandler;
    private TextArea messages;

	public void setupMessageAera(HBox hbox, Controller controller) {

		this.controller = controller;

		VBox vbox = new VBox();

		Label msg = new Label("Messages");

		vbox.setPadding(new Insets(10, 10, 10, 10));

		messages = new TextArea();

		messages.setPrefHeight(500);
		messages.setPrefWidth(300);
		
		messages.setEditable(false);
    	
		vbox.getChildren().addAll(msg, messages);
		hbox.getChildren().add(vbox);
	}
	
	public void startMessageHandler () {
		
    	msghandler = new MessageHandler(controller,messages);

    	msghandler.start();	
    	
	}
	
	public void stopMessageHandler () {
		msghandler.doStop();
	}
	
	/*
	public MessageHandler getMessageHandler() {
		return msghandler;
	}*/
}
