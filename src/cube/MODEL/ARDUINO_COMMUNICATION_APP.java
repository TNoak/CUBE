package cube.MODEL;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.fazecast.jSerialComm.SerialPort;

public class ARDUINO_COMMUNICATION_APP extends Thread {
	MODEL_MAIN model;

	SerialPort serialPort;
	Scanner scanner;

	String rawStringValue;
	String stringValueAndId;
	String stringValue;
	String stringID;

	int id;
	int value;

	public ARDUINO_COMMUNICATION_APP(MODEL_MAIN model) {
		// TODO Auto-generated constructor stub
		this.model = model;
		this.start();
	}

	public void run() {
		ReadWriteArduinoORG();
	}

	public void ReadWriteArduinoORG() {
		// TODO Auto-generated constructor stub
		setupCommunication();
		while (true) {

			System.out.println("");
			System.out.println("Read: ");
			rawStringValue = read();
			System.out.println(rawStringValue);
			System.out.println("processToStringValueAndId: ");
			stringValueAndId = processToStringValueAndId(rawStringValue);
			System.out.println(stringValueAndId);
			System.out.println("processToStringValue: ");
			stringValue = processToStringValue(stringValueAndId);
			System.out.println(stringValue);
			System.out.println("processToStringId: ");
			stringID = processToStringId(stringValueAndId);
			System.out.println(stringID);
			System.out.println("giveDataToSensor: ");
			giveDataToSensor(stringID, stringValue);

			// >>>>>>>>>>>>>>>>>>>>>>>>>>> writetoArduino
			// if (false) {
			// serialWrite(ThreadLocalRandom.current().nextInt(0, 1 + 1));
			// }
			// >>>>>>>>>>>>>>>>>>>>>>>>>>>
		}

	}

	public void giveDataToSensor(String stringID, String stringValue) {

		if (stringID == "" || stringID == null || stringValue == "" || stringValue == null
				|| stringValue.length() < 3) {
			System.out.println("Ich mach nichts damit");
		} else {

			id = Integer.parseInt(stringID);
			System.out.println("ID: " + id);
			value = Integer.parseInt(stringValue);
			System.out.println("Value: " + value);

			model.sensor_app[id].newData(id, value);
		}

	}

	public String processToStringValue(String stringValueAndId) { /////////////////////////////////////////////
		if (stringValueAndId != null && stringValueAndId.length() >= 5 && stringValueAndId.length() <= 8) {
			return stringValueAndId.substring(2);
		} else {
			return null;
		}
	}

	public String processToStringId(String stringValue) {
		if (stringValueAndId != null && stringValueAndId.length() >= 3) {
			return stringValue.substring(0, 2);
		}
		return null;
	}

	public String processToStringValueAndId(String rawStringValue) {

		if (rawStringValue != null && rawStringValue.length() >= 6 && rawStringValue.length() <= 8) {
			rawStringValue = rawStringValue.replace(".", "");
			rawStringValue = rawStringValue.substring(0, rawStringValue.length() - 1);
			return rawStringValue;
		} else {
			return null;
		}

	}

	void setupCommunication() {
		SerialPort[] ports = SerialPort.getCommPorts();

		System.out.println("Select a port:");
		int i = 1;
		for (SerialPort port : ports)
			System.out.println(i++ + ": " + port.getSystemPortName());
		Scanner s = new Scanner(System.in);
		int chosenPort = s.nextInt();

		serialPort = ports[chosenPort - 1];
		if (serialPort.openPort())
			System.out.println("Port opened successfully.");
		else {
			System.out.println("Unable to open the port.");
			return;
		}
		// serialPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
		serialPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);

		scanner = new Scanner(serialPort.getInputStream());
	}

	public String read() {
		if (scanner.hasNextLine()) {
			try {
				return (scanner.nextLine());
			} catch (Exception e) {

			}
		}
		return null;
	}

	public void serialWrite(int s) {
		// writes the entire string at once.
		serialPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
		try {
			Thread.sleep(5);
		} catch (Exception e) {
		}
		PrintWriter pout = new PrintWriter(serialPort.getOutputStream());
		pout.print(s);
		pout.flush();

	}

}
