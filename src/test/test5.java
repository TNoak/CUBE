package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class test5 {

	PrintWriter pWriter;
	FileReader fr;
	BufferedReader reader;

	public test5()  {
		try {
			pWriter = new PrintWriter(new BufferedWriter(new FileWriter("test.txt")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fr=null;
		try {
			fr = new FileReader("test.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reader = new BufferedReader(fr);
		
		
	}

	public void write(String s) {
		pWriter.println(s);
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

	public static void main(String[] args) {
		new test5();
	}

}
