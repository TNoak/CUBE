package cube.MODEL;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.fazecast.jSerialComm.SerialPort;

public class ARDUINO_COMMUNICATION_APP extends Thread {
	MODEL_MAIN model;

	SerialPort serialPort;
	Scanner scanner;

	int failcounter;

	String message;

	int id;
	String stringnum;
	String stringtemp;
	String stringhumi;

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
			message = "";
			id = -1;
			stringhumi = "";
			stringtemp = "";

			message = read();

			System.out.println(message);
			processString(message);
		}

	}

	void processString(String message) {
		if (failcounter > 25) {
			serialPort.closePort();
			setupCommunication();
			return;
		}

		if (message == null) {
			failcounter++;
			return;
		} else if (message.length() < 17 || message.length() > 22) {
			failcounter++;
			System.out.println("Message has incorrect length!");
			return;
		} else if (!message.substring(0, 1).equals("a") || !message.substring(message.length() - 1).equals("b")) {
			failcounter++;
			System.out.println("AAAAAA    " + message.substring(0, 1));
			System.out.println("BBBBBB    " + message.substring(message.length() - 1));
			System.out.println("Message is missing start and/or end character (a,b)");
			return;
		}

		failcounter = 0;

		try {
			stringnum = message.substring(message.indexOf("n") + 1, message.lastIndexOf("n"));
			id = Integer.parseInt(stringnum);
			System.out.println(stringnum);

			stringtemp = message.substring(message.indexOf("t") + 1, message.lastIndexOf("t"));
			System.out.println(stringtemp);

			stringhumi = message.substring(message.indexOf("h") + 1, message.lastIndexOf("h"));
			System.out.println(stringhumi);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Incorrect message!");
		}

		try {
			model.sensor_app[id].newData(id, stringtemp, stringhumi);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Failed to wirte data to sensorapp!");
		}

	}

	void setupCommunication() {
		SerialPort[] ports = SerialPort.getCommPorts();

		if (ports.length == 0) {
			System.out.println("No devices detected!");
			return;
		} else if (ports.length == 1) {
			serialPort = ports[0];
		} else {
			System.out.println("Select a port:");
			int i = 1;
			for (SerialPort port : ports)
				System.out.println(i++ + ": " + port.getSystemPortName());
			Scanner s = new Scanner(System.in);
			int chosenPort = s.nextInt();

			serialPort = ports[chosenPort - 1];
		}

		if (serialPort.openPort()) {
			System.out.println("Port opened successfully.");
			failcounter = 0;
		} else {
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
				if (scanner.hasNextLine()) {
					return (scanner.nextLine());
				}
			} catch (Exception e) {
				System.out.println("Failed to read!");
			}
		}
		return message;

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
