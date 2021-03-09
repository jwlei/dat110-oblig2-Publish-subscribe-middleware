package no.hvl.dat110.messages;

public class UnsubscribeMsg extends Message {

	// message sent from client to unsubscribe on a topic 

	// TODO:
	// Implement object variables - a topic is required
	// Constructor, get/set-methods, and toString method
	// as described in the project text
	// DONE
	
	private String topic;
	
	//Constructor
	public UnsubscribeMsg(String name, String topic) {
		super(MessageType.UNSUBSCRIBE, name);
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
		return "UnsubscribeMsg [topic=" + getTopic() + "]Message [type=" + getType() + ", user=" + getUser() + "]";
	}
	
}
