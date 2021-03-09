package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start
		// create a client object
		Client sensorClient = new Client("TemperaturSensor", Common.BROKERHOST, Common.BROKERPORT);
		
		// - connect to the broker
		sensorClient.connect();
		
		int i = 0;
		int temperaturInt;
		String temperaturString;
		
		// - publish the temperature(s)
		while (i < COUNT) {
			temperaturInt = sn.read();
			try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			
			temperaturString = Integer.toString(temperaturInt);
			
			sensorClient.publish(Common.TEMPTOPIC, temperaturString);
			i++;
		}
		
		// - disconnect from the broker
		sensorClient.disconnect();
		
		// TODO - end
		// DONE

		System.out.println("Temperature device stopping ... ");

		// throw new UnsupportedOperationException(TODO.method());

	}
}
