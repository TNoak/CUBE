package cube.VIEW;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import cube.STATICS.COLORS;
import cube.WIDGETS.BJPanel;
import cube.WIDGETS.CButton;

import cube.WIDGETS.CText;


public class SENSOR_MAIN extends BJPanel implements ActionListener {

	SENSOR_GRAPH tempGr, humidGr;
	SENSOR_STATUS tempSt, humidSt;
	SENSOR_NUMMER sensNum;
	SENSOR_BAR tempBar, humidBar;
	CButton exit;
	GUI_MAIN gui;


	CText tex;

	int[] tempAr, humidAr;

	public SENSOR_MAIN(GUI_MAIN gui, int x, int y, int width, int height, Color foreground, Color bordercolor,
			int roundness, int sensorNummer, int time) {

		super();
		super.setSize(width, height);
		super.setLocation(x, y);
		super.setForeground(foreground);
		super.setBordercolor(bordercolor);
		super.setBordersize(1);
		super.setRoundness(roundness);
		super.setLayout(null);
		super.setVisible(true);

		this.gui = gui;

		tempGr = new SENSOR_GRAPH(10, super.getHeight() / 2 - 10, super.getWidth() / 2 - 20, super.getHeight() / 2, 30,

				COLORS.mainBackground, COLORS.greyLight, 1, time);
		humidGr = new SENSOR_GRAPH(super.getWidth() / 2 + 20, super.getHeight() / 2 - 10, super.getWidth() / 2 - 30,
				super.getHeight() / 2, 30, COLORS.mainBackground, COLORS.greyLight, 2, time);


		tempSt = new SENSOR_STATUS(super.getWidth() / 2 - 15 - super.getWidth() / 6, super.getHeight() / 4 - 15,
				super.getWidth() / 6, super.getHeight() / 4 - 30, 30, COLORS.mainBackground, COLORS.greyLight, 1);
		humidSt = new SENSOR_STATUS(super.getWidth() - 10 - super.getWidth() / 6, super.getHeight() / 4 - 15,
				super.getWidth() / 6, super.getHeight() / 4 - 30, 30, COLORS.mainBackground, COLORS.greyLight, 2);

		tempBar = new SENSOR_BAR(10, super.getHeight() / 4 - 15, super.getWidth() / 4, super.getHeight() / 4 - 30, 30,
				COLORS.mainBackground, COLORS.greyLight, 1);
		humidBar = new SENSOR_BAR(super.getWidth() / 2 + 20, super.getHeight() / 4 - 15, super.getWidth() / 4,
				super.getHeight() / 4 - 30, 30, COLORS.mainBackground, COLORS.greyLight, 2);

		sensNum = new SENSOR_NUMMER(10, 10, super.getHeight() / 8 - 10, super.getHeight() / 8 - 10,

				COLORS.mainBackground, COLORS.greyLight, sensorNummer);

		exit = new CButton(super.getWidth() - 40, 10, 30, 30, 5, COLORS.buttonRed, super.getForeground());
		exit.addActionListener(this);
		exit.setText("exit");

		super.add(humidBar);
		super.add(humidGr);
		super.add(humidSt);
		super.add(sensNum);
		super.add(tempBar);
		super.add(tempGr);
		super.add(tempSt);
		super.add(exit);


		tempAr = new int[1];
		humidAr = new int[1];

		tex = new CText(sensNum.getX() + sensNum.getWidth() + 10, sensNum.getY() ,
				super.getWidth() / 2, sensNum.getHeight(), "Temperature & Humidity Sensor");
		super.add(tex);
	}



	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {
			setVisible(false);
			gui.showAllSens();
		}
	}

	public void setVisible(boolean vis) {
		super.setVisible(vis);
	}


	public void updateData(int tick, int temp, int humid, int statusTemp, int statusHumid) {
		tempBar.setData(temp);
		humidBar.setData(humid);

		int[] temp1 = new int[tick + 1];
		for (int x = 0; x < tempAr.length; x++) {
			temp1[x] = tempAr[x];
		}
		temp1[temp1.length - 1] = temp;
		tempAr = temp1;

		tempGr.setData(temp1);
		int[] humid1 = new int[tick + 1];
		for (int x = 0; x < humidAr.length; x++) {
			humid1[x] = humidAr[x];
		}
		humid1[humid1.length - 1] = humid;
		humidAr = humid1;

		humidGr.setData(humid1);

		setStatus(statusTemp, 1);
		setStatus(statusHumid, 2);

	}

	public void setStatus(int status, int sensortype) {
		if (sensortype == 1) {
			tempSt.setStatus(status);
		} else {
			humidSt.setStatus(status);
		}
	}

}
