package cube.VIEW;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cube.STATICS.COLORS;
import cube.WIDGETS.BJPanel;
import cube.WIDGETS.CButton;
import cube.WIDGETS.CText;

public class CONTROLLPANEL_MAIN extends BJPanel implements ActionListener {

	CButton  lights, startStop;
	CONTROLLPANEL_OUTDOOR outdoor;
	CONTROLLPANEL_WINDOWS windows;
	boolean lightsOnOff, startOnOff;
	GUI_MAIN gui;

	public CONTROLLPANEL_MAIN(GUI_MAIN gui,int x, int y, int width, int height, Color background) {
		super();
		super.setSize(width, height);
		super.setLocation(x, y);
		super.setForeground(background);
		super.setBordercolor(background);
		super.setBordersize(0);
		super.setRoundness(30);
		
		this.gui=gui;

		windows=new CONTROLLPANEL_WINDOWS(gui, 10, super.getHeight() * 3 / 8-10, super.getWidth()-20, super.getHeight()/2-10, COLORS.mainBackground, COLORS.greyLight, 10);
		super.add(windows);

		lights = new CButton(10,super.getHeight() * 2 / 8 - 20 , super.getWidth() - 20, super.getHeight() / 8, 10,
				COLORS.buttonRed, background);
		lights.setText("Lights");
		lights.addActionListener(this);
		super.add(lights);
		lightsOnOff = false;

		startStop = new CButton(10, super.getHeight() * 7 / 8 - 10, super.getWidth() - 20, super.getHeight() / 8, 10,
				COLORS.buttonGreen, background);
		startStop.setText("Start");
		startStop.addActionListener(this);
		super.add(startStop);
		startOnOff = false;

		outdoor = new CONTROLLPANEL_OUTDOOR(10, 10, super.getWidth() - 20,
				super.getHeight() * 2 / 8 - 40, COLORS.mainBackground, COLORS.greyLight, 10);
		super.add(outdoor);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startStop) {
			startOnOff = !startOnOff;
			if (startOnOff) {
				startStop.setColor(COLORS.buttonRed);
				startStop.setText("Stop");
			} else {
				startStop.setColor(COLORS.buttonGreen);
				startStop.setText("Start");
			}
			gui.sendDataStartStop(startOnOff);
		}

		if (e.getSource() == lights) {
			if (lightsOnOff) {
				lights.setColor(COLORS.buttonRed);
			} else {
				lights.setColor(COLORS.buttonGreen);
			}
			lightsOnOff = !lightsOnOff;
			gui.sendDataLights(lightsOnOff);
		}
		
	}

	public void updateData(int sensor, int temp) {
		if (sensor == -1) {
			outdoor.setTemp(temp);
		}
	}

}
