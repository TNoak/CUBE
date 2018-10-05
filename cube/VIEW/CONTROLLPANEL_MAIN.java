package cube.VIEW;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cube.STATICS.COLORS;
import cube.WIDGETS.BJPanel;
import cube.WIDGETS.CButton;

public class CONTROLLPANEL_MAIN extends BJPanel implements ActionListener {

	CButton window, lights, startStop;
	CONTROLLPANEL_PUMP pump;
	CONTROLLPANEL_OUTDOOR outdoor;
	boolean pumpOnOff, lightsOnOff, startOnOff, windowOnOff;

	public CONTROLLPANEL_MAIN(int x, int y, int width, int height, Color background) {
		super();
		super.setSize(width, height);
		super.setLocation(x, y);
		super.setForeground(background);
		super.setBordercolor(background);
		super.setBordersize(0);
		super.setRoundness(30);

		window = new CButton(10, 10, super.getWidth() - 20, super.getHeight() / 8, 10, COLORS.buttonRed, background);
		window.setText("Windows");
		window.addActionListener(this);
		super.add(window);
		windowOnOff = false;

		lights = new CButton(10, super.getHeight() / 8 + 20, super.getWidth() - 20, super.getHeight() / 8, 10,
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

		pump = new CONTROLLPANEL_PUMP(10, super.getHeight() * 4 / 8, super.getWidth() - 20,
				super.getHeight() * 3 / 8 - 20, COLORS.mainBackground, COLORS.greyLight, 30);
		pump.getButton().addActionListener(this);
		super.add(pump);
		pumpOnOff = false;

		outdoor = new CONTROLLPANEL_OUTDOOR(10, super.getHeight() * 2 / 8 + 30, super.getWidth() - 20,
				super.getHeight() * 2 / 8 - 40, COLORS.mainBackground, COLORS.greyLight, 30);
		super.add(outdoor);

		repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pump.getButton()) {
			if (pumpOnOff) {
				pump.getButton().setColor(COLORS.buttonRed);
			} else {
				pump.getButton().setColor(COLORS.buttonGreen);
			}
			pumpOnOff = !pumpOnOff;
		}

		if (e.getSource() == startStop) {
			startOnOff = !startOnOff;
			if (startOnOff) {
				startStop.setColor(COLORS.buttonRed);
				startStop.setText("Stop");
			} else {
				startStop.setColor(COLORS.buttonGreen);
				startStop.setText("Start");
			}
		}

		if (e.getSource() == lights) {
			if (lightsOnOff) {
				lights.setColor(COLORS.buttonRed);
			} else {
				lights.setColor(COLORS.buttonGreen);
			}
			lightsOnOff = !lightsOnOff;
		}

		if (e.getSource() == window) {
			if (windowOnOff) {
				window.setColor(COLORS.buttonRed);
			} else {
				window.setColor(COLORS.buttonGreen);
			}
			windowOnOff = !windowOnOff;
		}

	}

	public void updateData(int sensor, int temp) {
		if (sensor == -1) {
			outdoor.setTemp(temp);
		}

		if (sensor == -2) {
			pump.setFlowIn(temp);
		}
		if (sensor == -3) {
			pump.setFlowOut(temp);
		}

	}

}
