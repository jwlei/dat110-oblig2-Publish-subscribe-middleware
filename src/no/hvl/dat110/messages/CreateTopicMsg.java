package no.hvl.dat110.messages;

public class CreateTopicMsg extends Message {
	private String topic;

		// message sent from client to create topic on the broker
	
		// TODO: 
		// Implement object variables - a topic is required
		// Constructor, get/set-methods, and toString method
	    // as described in the project text	
		// DONE
	
	//Constructor
	public CreateTopicMsg(String user, String topic) {
		super(MessageType.CREATETOPIC, user);
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
		return "CreateTopicMsg [topic=" + topic + "]Message [type=" + getType() + ", user=" + getUser() + "]";
	}

}