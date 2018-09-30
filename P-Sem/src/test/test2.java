package test;

import java.awt.Color;

import javax.swing.JFrame;

public class test2 extends JFrame {

	test ss;

	test2() {
		super.setSize(1920, 1080);
		super.setVisible(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.getContentPane().setBackground(new Color(255, 100, 0));
		super.setForeground(getBackground());
		super.setLayout(null);

		ss = new test();
		super.add(ss);
	}

	public static void main(String[] args) {
		new test2();
	}
}