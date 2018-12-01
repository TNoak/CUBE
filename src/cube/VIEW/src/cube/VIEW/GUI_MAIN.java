package cube.VIEW;

import javax.swing.JFrame;

import cube.STATICS.COLORS;

public class GUI_MAIN extends JFrame {

	SENSOR_MAIN[] senm;
	CONTROLLPANEL_MAIN conm;
	MENUE_MAIN menm;
	ALLSENSORS_MAIN all;

	private int sensorCount;

	GUI_MAIN(int sensorCount, int time) {
		super.setSize(1280, 720);
		super.setExtendedState(MAXIMIZED_BOTH);
		super.setVisible(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.getContentPane().setBackground(COLORS.mainBackground);
		super.setForeground(getBackground());
		super.setLayout(null);

		this.sensorCount = sensorCount;

		senm = new SENSOR_MAIN[sensorCount];
		for (int x = 0; x < sensorCount; x++) {
			senm[x] = new SENSOR_MAIN(this, 20, super.getHeight() / 6 + 40, super.getHeight() / 6 * 9 - 30,
					super.getHeight() / 6 * 5 - 100, COLORS.mainBackground, COLORS.greyLight, 30, x + 1, time);
			super.add(senm[x]);
			senm[x].setVisible(false);
		}

		all = new ALLSENSORS_MAIN(this, 20, super.getHeight() / 6 + 40, super.getHeight() / 6 * 9 - 30,
				super.getHeight() / 6 * 5 - 100, 1, COLORS.mainBackground, COLORS.greyLight, 30, sensorCount);
		super.add(all);

		conm = new CONTROLLPANEL_MAIN(this,super.getHeight() / 6 * 9 + 10, super.getHeight() / 6 + 40,
				super.getWidth() - super.getHeight() / 6 * 9 - 40, super.getHeight() / 6 * 5 - 100,
				COLORS.lightBackground);
		super.add(conm);

		menm = new MENUE_MAIN(this, super.getWidth(), super.getHeight() / 6, super.getHeight());
		super.add(menm);

		showSensor(1);
		showAllSens();

		repaint();

	}

	public void showSensor(int sens) {
		senm[sens].setVisible(true);
		all.setVisible(false);
	}

	public void showAllSens() {
		all.setVisible(true);
		for (int x = 0; x < sensorCount; x++) {
			senm[x].setVisible(false);
		}
	}

	public void updateData(int sensor, int tick, int temp, int humid, int statusTemp, int statusHumid) {
		// sensor: -1=outdoor; -2=flowin; -3=flowout

		if (sensor >= 0) {
			senm[sensor].updateData(tick, temp, humid, statusTemp, statusHumid);
			all.updateData(sensor, tick, temp, humid, statusTemp, statusHumid);
		}

		if (sensor < 0) {
			conm.updateData(sensor, temp);
			menm.updateData(sensor, temp);
		}
	}
	
	public void sendDataStartStop(boolean start) {
		//Aufruf im model
		System.out.println(start);
	}
	public void sendDataHeating(boolean heatOnOff, boolean pumpOnOff, int temp) {
		// Aufruf im model
		System.out.println(temp);
	}
	public void sendDataLights(boolean lights) {
		// Aufruf im model
		System.out.println(lights);
	}
	// window: 1:lo, 2:ro, 3:lu, 4:ru
	public void sendDataWindow(int window, int value) {
		// Aufruf im model
		System.out.println(window+", "+value);
	}

	public static void main(String[] args) {
		new GUI_MAIN(15, 10);
	}


	//wow 35 Seiten Code inzwischen und mehr W�rter(�ber 4250 W�rter und 39000 Zeichen) als meine Seminararbeit...

}
