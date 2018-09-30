package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class test4 {

	public test4() {
		writefile();

		FileReader fr = null;
		try {
			fr = new FileReader("test.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);

		String zeile1 = null;
		try {
			zeile1 = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(zeile1);
		
		String zeile2 = null;
		try {
			zeile2 = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(zeile2);
	}

	public static void writefile() {
		PrintWriter pWriter = null;
		try {
			pWriter = new PrintWriter(new BufferedWriter(new FileWriter("test.txt")));
			pWriter.println("Hallo Welt!");
			pWriter.println("Idiot");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (pWriter != null) {
				pWriter.flush();
				pWriter.close();
			}
		}
	}

	public static void main(String[] args) {
		new test4();
	}

}
