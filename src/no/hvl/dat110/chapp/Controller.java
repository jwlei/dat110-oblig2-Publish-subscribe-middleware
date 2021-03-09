package no.hvl.dat110.chapp;

import no.hvl.dat110.client.*;
import no.hvl.dat110.messages.PublishMsg;

public class Controller {

	private String user;
	private String brokerhost;
	private int brokerport;
	
	private Client client;
	private boolean isconnected = false;
	
	private static String DEFAULT_USER = "me";
	private static String DEFAULT_BROKERHOST = "localhost";
	private static int DEFAULT_BROKERPORT = 8080;
	
	public Controller (MessageArea messagearea) {
		this.brokerport = DEFAULT_BROKERPORT;
		this.brokerhost = DEFAULT_BROKERHOST;
		this.user = DEFAULT_USER;
	}

	public String getBrokerhost() {
		return brokerhost;
	}

	public int getBrokerport() {
		return brokerport;
	}
	
	public String getUser () {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}

	public void setBrokerhost(String brokerhost) {
		this.brokerhost = brokerhost;
	}

	public void setBrokerport(int brokerport) {
		this.brokerport = brokerport;
	}
	
	public boolean connect () {
		
		boolean success = true;
		
		this.client = new Client(user,brokerhost,brokerport);
		
		client.connect();
		
		if (success) {
			isconnected = true;
		}
		
		return success;
	}
	
	public void disconnect () {
		 
		 client.disconnect();
		 isconnected = false;
	}
	
	public void createTopic(String topic) {
	
		if (isconnected) {
			client.createTopic(topic);
		}
		
	}
	
	public void deleteTopic(String topic) {
	
		if (isconnected) {
			client.deleteTopic(topic);
		}
	}
	
	public void subscribe(String topic) {
		
		if (isconnected) {
			client.subscribe(topic);
		}
	}
	
	public void unsubscribe(String topic) {
	
		if (isconnected) {
			client.unsubscribe(topic);
		}
	}
	
	public void publish(String topic, String message) {
	
		if (isconnected) {
			client.publish(topic, message);
		}
		
	}
	
	public boolean isConnected () {
		return isconnected;
	}
	
	public String receive() {
		
		String message = null;
		
		if (isconnected) {
			
			PublishMsg msg = (PublishMsg)client.receive();
			
			if (msg != null) {
				message = "[" + msg.getUser() + "]" + msg.getMessage();
			}
		}
		
		return message;
	}
}
