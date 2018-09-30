package cube.VIEW;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class SENSOR_FILEREADER {
	PrintWriter pWriter;
	FileReader fr;
	BufferedReader reader;
	GUI_MAIN gui;

	public SENSOR_FILEREADER(String file) {
		this.gui = gui;
		try {
			pWriter = new PrintWriter(new BufferedWriter(new FileWriter(file+".txt")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		fr = null;
		try {
			fr = new FileReader(file + ".txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reader = new BufferedReader(fr);
		
		pWriter.println(file+"_0_0_0");
		pWriter.flush();

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

	public String[] updateData() {
		return read().split(Pattern.quote("_"));
	}

}
