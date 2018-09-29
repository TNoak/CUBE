package test;

import java.awt.Color;

import javax.swing.JFrame;

import cube.VIEW.CONTROLLPANEL_MAIN;
import cube.VIEW.MENUE_MAIN;
import cube.VIEW.SENSOR_MAIN;

public class GUI extends JFrame {

	SENSOR_MAIN senm;
	CONTROLLPANEL_MAIN conm;
	MENUE_MAIN menm;

	GUI() {
		super.setSize(1280, 720);
		//super.setExtendedState(MAXIMIZED_BOTH);
		super.setVisible(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.getContentPane().setBackground(new Color(33, 32, 49));
		super.setForeground(getBackground());
		super.setLayout(null);

		senm = new SENSOR_MAIN(20, super.getHeight() / 6 + 40, super.getHeight() / 6 * 9 - 30,
				super.getHeight() / 6 * 5 - 100, new Color(33, 32, 49), Color.WHITE, 30);
		super.add(senm);

		conm = new CONTROLLPANEL_MAIN(super.getHeight() / 6 * 9+10, super.getHeight() / 6 + 40,
				super.getWidth() - super.getHeight() / 6 * 9 - 40, super.getHeight() / 6 * 5 - 100,
				new Color(54, 53, 80));
		super.add(conm);

		menm = new MENUE_MAIN(super.getWidth(), super.getHeight() / 6);
		super.add(menm);
		
		repaint();

	}

	public static void main(String[] args) {
		new GUI();
	}
}
