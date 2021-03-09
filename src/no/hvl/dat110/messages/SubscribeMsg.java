package no.hvl.dat110.messages;

public class SubscribeMsg extends Message {

	// message sent from client to subscribe on a topic 

	// TODO:
	// Implement object variables - a topic is required
	// Constructor, get/set-methods, and toString method
	// as described in the project text
	// DONE
	private String topic;
	
	//Constructor
	public SubscribeMsg(String user, String topic) {
		super(MessageType.SUBSCRIBE, user);
		this.topic = topic;
	}
	//Set
	public void setTopic(String topic) {
		this.topic = topic;
	}

	//Get
	public String getTopic() {
		return topic;
	}

	//toString
	@Override
	public String toString() {
		return "SubscribeMsg [topic=" + getTopic() + "]Message [type=" + getType() + ", user=" + getUser() + "]";
	}
		
}
