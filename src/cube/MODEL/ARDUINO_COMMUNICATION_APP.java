package cube.MODEL;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.fazecast.jSerialComm.SerialPort;

public class ARDUINO_COMMUNICATION_APP extends Thread {
	MODEL_MAIN model;

	SerialPort serialPort;
	Scanner scanner;

	String rawStringValueAndDataType;
	String rawStringValue;
	String stringValueAndId;
	String stringValue;
	String stringID;

	int id;
	int value;
	char datatype;

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
			rawStringValueAndDataType = read();
			System.out.println(rawStringValueAndDataType);
			System.out.println("processRawStringValueAndDataType: "); 
			rawStringValue = processRawStringValueAndDataType(rawStringValueAndDataType);
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
			
			
			datatype = extractDataType(rawStringValueAndDataType);
			
			giveDataToSensor(stringID, stringValue, datatype);

			// >>>>>>>>>>>>>>>>>>>>>>>>>>> writetoArduino
			// if (false) {
			// serialWrite(ThreadLocalRandom.current().nextInt(0, 1 + 1));
			// }
			// >>>>>>>>>>>>>>>>>>>>>>>>>>>
		}

	}

	public char extractDataType(String rawStringValueAndDataType) {
		if(rawStringValueAndDataType.indexOf('t') >= 0) {
			return 't';
		} else if(rawStringValueAndDataType.indexOf('h') >= 0) {
			return 'h';
		}
		return 'n';
	}

	public void giveDataToSensor(String stringID, String stringValue, char datatype) {

		if (stringID == "" || stringID == null || stringValue == "" || stringValue == null
				|| stringValue.length() < 3 || datatype == 'n') {
			if(id + 1 <= model.sensorcount) {
				model.sensor_app[id].newData(id + 1, 0, 'n', 1);
			} else {
				model.sensor_app[id].newData(0, 0, 'n', 1);
			}
			
		} else {

			id = Integer.parseInt(stringID);
			System.out.println("ID: " + id);
			value = Integer.parseInt(stringValue);
			System.out.println("Value: " + value);
			System.out.println("Datatype: " + datatype);
			
			if(id < model.sensorcount) {
				model.sensor_app[id].newData(id, value, datatype, 0);
			} else {
				System.out.println("Too many sensors connected");
			}

			
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

	public String processRawStringValueAndDataType(String rawStringValueAndDataType) {
		if (rawStringValueAndDataType != null && rawStringValueAndDataType.length() >= 7
				&& rawStringValueAndDataType.length() <= 9) {
			rawStringValueAndDataType = rawStringValueAndDataType.replace("t", "");
			rawStringValueAndDataType = rawStringValueAndDataType.replace("h", "");
			return rawStringValueAndDataType;
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
