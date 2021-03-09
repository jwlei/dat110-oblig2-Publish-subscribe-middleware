package no.hvl.dat110.messages;

public class DeleteTopicMsg extends Message {

		// message sent from client to create topic on the broker
	
		// TODO: 
		// Implement object variables - a topic is required
		// Constructor, get/set-methods, and toString method
	    // as described in the project text	
		// DONE
	
	private String topic;

	//Constructor
	public DeleteTopicMsg(String user, String topic) {
		super(MessageType.DELETETOPIC, user);
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
		return "DeleteTopicMsg [topic=" + topic + "]Message [type=" + getType() + ", user=" + getUser() + "]";
		}
	

}
