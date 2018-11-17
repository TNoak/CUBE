package cube.MODEL;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.fazecast.jSerialComm.SerialPort;

public class ARDUINO_COMMUNICATION_APP extends Thread {
	MODEL_MAIN model;

	SerialPort serialPort;
	Scanner scanner;

	String message;

	int id;
	double valuetemp;
	double valuehumi;

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
			valuehumi = -1;
			valuetemp = -1;
			message = read();
			System.out.println(message);
			processString(message);
		}

	}

	void processString(String message) {
		if (message.length() >= 17 && message.length() <= 22) {

			try {
				String stringnum = message.substring(message.indexOf("n") + 1, message.lastIndexOf("n"));
				id = Integer.parseInt(stringnum);
				System.out.println(id);
				String stringtemp = message.substring(message.indexOf("t") + 1, message.lastIndexOf("t"));
				valuetemp = Double.parseDouble(stringtemp);
				System.out.println(valuetemp);
				String stringhumi = message.substring(message.indexOf("h") + 1, message.lastIndexOf("h"));
				valuehumi = Double.parseDouble(stringhumi);
				System.out.println(valuehumi);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Incorrect message!");
			}

			try {
				model.sensor_app[id].newData(id, valuetemp, valuehumi);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Failed to wirte data to sensorapp!");
			}
		} else {
			System.out.println("Message has incorrect length!");
			return;
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
