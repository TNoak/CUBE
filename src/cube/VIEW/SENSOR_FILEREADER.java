package cube.VIEW;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SENSOR_FILEREADER {
	PrintWriter pWriter;
	FileReader fr;
	BufferedReader reader;

	public SENSOR_FILEREADER() {
		fr = null;
		try {
			fr = new FileReader("test.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reader = new BufferedReader(fr);

	}

	public String read() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
