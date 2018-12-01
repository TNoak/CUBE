
package cube.VIEW;

import javax.swing.JFrame;

import cube.STATICS.COLORS;

public class GUI_MAIN extends JFrame {

	SENSOR_MAIN[] senm;
	SENSOR_FILEREADER[] file;
	CONTROLLPANEL_MAIN conm;
	MENUE_MAIN menm;
	ALLSENSORS_MAIN all;

	GUI_MAIN(int sensorCount) {
		super.setSize(1280, 720);
		super.setExtendedState(MAXIMIZED_BOTH);
		super.setVisible(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.getContentPane().setBackground(COLORS.mainBackground);
		super.setForeground(getBackground());
		super.setLayout(null);

		senm=new SENSOR_MAIN[sensorCount];
		for (int x = 0; x < sensorCount; x++) {
			senm[x] = new SENSOR_MAIN(this,20, super.getHeight() / 6 + 40, super.getHeight() / 6 * 9 - 30,
					super.getHeight() / 6 * 5 - 100, COLORS.mainBackground, COLORS.greyLight, 30, x+1);
			super.add(senm[x]);
			senm[x].setVisible(false);
		}

		all = new ALLSENSORS_MAIN(this,20, super.getHeight() / 6 + 40, super.getHeight() / 6 * 9 - 30,
				super.getHeight() / 6 * 5 - 100, COLORS.mainBackground, COLORS.greyLight, 30, sensorCount);
		super.add(all);

		conm = new CONTROLLPANEL_MAIN(super.getHeight() / 6 * 9 + 10, super.getHeight() / 6 + 40,
				super.getWidth() - super.getHeight() / 6 * 9 - 40, super.getHeight() / 6 * 5 - 100,
				COLORS.lightBackground);
		super.add(conm);

		menm = new MENUE_MAIN(super.getWidth(), super.getHeight() / 6);
		super.add(menm);

		repaint();

	}

	public void showSensor(int sens) {
		senm[sens].setVisible(true);
	}
	
	public void showAllSens() {
		all.setVisible(true);
	}
	
	
	

	public static void main(String[] args) {
		new GUI_MAIN(10);
	}
}

