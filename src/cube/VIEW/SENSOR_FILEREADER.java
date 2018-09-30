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

	public SENSOR_FILEREADER(String file) {
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
		/*
		pWriter.println(file+"_1_111_600");
		pWriter.println(file+"_2_200_600");
		pWriter.println(file+"_3_220_550");
		pWriter.println(file+"_4_310_650");
		pWriter.println(file+"_5_301_400");
		pWriter.println(file+"_6_280_300"); */
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