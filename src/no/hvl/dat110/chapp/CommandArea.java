package no.hvl.dat110.chapp;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CommandArea {

	private Controller controller;
	private MessageArea marea;
	private Label hostport, user;
	
	public void setHostPort (String host, String port) {
		this.hostport.setText(host + ":" + port);
	}
	
	public void setUser (String user) {
		this.user.setText(user);
	}
	
	public void setupCommandArea(HBox hbox, Controller controller, MessageArea marea) {
		
		this.controller = controller;
		this.marea = marea;
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		// connect/disconnect
		Button connect = new Button("Connect");
		hostport = 
				new Label(controller.getBrokerhost() + ":" + 
							controller.getBrokerport());
		
		user = new Label(controller.getUser());
		
		grid.add(connect, 0, 0);
		grid.add(user, 1, 0);
		grid.add(hostport, 2, 0);
		
		ConnectBtnHandler connecthandler = new ConnectBtnHandler(controller,connect,marea);
		connect.setOnAction(connecthandler);
		
		// create/delete topic
		Button createtopic = new Button("Create Topic");
		Button deletetopic = new Button("Delete Topic");
		TextField topiccrt = new TextField();
		
		grid.add(createtopic, 0, 1);
		grid.add(deletetopic, 2, 1);
		grid.add(topiccrt, 1, 1);
		
		createtopic.setOnAction((event) -> {
			
			String topic = topiccrt.getText();
			
			if (!topic.equals("")) {
				controller.createTopic(topic);
				System.out.println("Create Topic: " + topic);
			}
	    	
		});
		
		deletetopic.setOnAction((event) -> {
			
			String topic = topiccrt.getText();
			
			if (!topic.equals("")) {
				controller.deleteTopic(topic);
				System.out.println("Delete Topic: " + topic);
			}
	    	
		});
		
		// subscribe/unsubscribe
		Button subscribe = new Button("Subscribe");
		Button unsubscribe = new Button("Unsubscribe");
		TextField topicsub = new TextField();
		
		grid.add(subscribe, 0, 2);
		grid.add(unsubscribe, 2, 2);
		grid.add(topicsub, 1, 2);
		
		subscribe.setOnAction((event) -> {
			

			String topic = topicsub.getText();
			
			if (!topic.equals("")) {
				controller.subscribe(topic);
				System.out.println("Subscribe:" + topic);
			}
	    	
		});
		
		unsubscribe.setOnAction((event) -> {
			

			String topic = topicsub.getText();
			
			if (!topic.equals("")) {
				controller.unsubscribe(topic);
				System.out.println("Unsubscribe:" + topic);
			}
	    	
		});
		
		// publish
		Button publish = new Button("Publish");
		TextField topicpub = new TextField();
		
		grid.add(publish, 0, 3);
		grid.add(topicpub, 1, 3);
	
		TextArea message = new TextArea();
		message.setPrefHeight(100);  
		message.setPrefWidth(250); 
		
		grid.add(message, 0, 4, 3,3);
	
		publish.setOnAction((event) -> {
			

			String msg = message.getText();
			String topic = topicpub.getText();
			
			if ((!msg.equals("")) && (!topic.equals(""))) {
				controller.publish(topic, msg);
				System.out.println("Publish:" + topic + "\n" + msg);
				message.setText("");
			}
	    	
		});
		
		hbox.getChildren().add(grid);
	}
}
