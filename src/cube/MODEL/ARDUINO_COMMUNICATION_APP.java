package cube.MODEL;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.fazecast.jSerialComm.SerialPort;

public class ARDUINO_COMMUNICATION_APP extends Thread{

	public ARDUINO_COMMUNICATION_APP() {
		// TODO Auto-generated constructor stub
		this.start();
	}
	
	public void run() {
		ReadWriteArduinoORG();
	}
	
	SerialPort serialPort;

	public void ReadWriteArduinoORG() {
		// TODO Auto-generated constructor stub

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

		Scanner data = new Scanner(serialPort.getInputStream());
		int value = 0;
		while (true) {

			if (data.hasNextLine()) {
				try {
					value = Integer.parseInt(data.nextLine());
				} catch (Exception e) {
				}
				System.out.println(value);
			}

			if (false) {
				serialWrite(ThreadLocalRandom.current().nextInt(0, 1 + 1));
			}

		}
		// System.out.println("Done.");

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
