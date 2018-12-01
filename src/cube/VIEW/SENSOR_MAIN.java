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

public class SENSOR_MAIN extends BJPanel implements ActionListener {

	SENSOR_GRAPH tempGr, humidGr;
	SENSOR_STATUS tempSt, humidSt;
	SENSOR_NUMMER sensNum;
	SENSOR_BAR tempBar, humidBar;
	CButton exit;
	GUI_MAIN gui;

	SENSOR_FILEREADER file;
	
	int[] tempAr,humidAr;

	public SENSOR_MAIN(GUI_MAIN gui, int x, int y, int width, int height, Color foreground, Color bordercolor,
			int roundness, int sensorNummer) {
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
		file = new SENSOR_FILEREADER(Integer.toString(sensorNummer - 1));

		tempGr = new SENSOR_GRAPH(10, super.getHeight() / 2 - 10, super.getWidth() / 2 - 20, super.getHeight() / 2, 30,
				COLORS.mainBackground, COLORS.greyLight, 1);
		humidGr = new SENSOR_GRAPH(super.getWidth() / 2 + 20, super.getHeight() / 2 - 10, super.getWidth() / 2 - 30,
				super.getHeight() / 2, 30, COLORS.mainBackground, COLORS.greyLight, 2);

		tempSt = new SENSOR_STATUS(super.getWidth() / 2 - 15 - super.getWidth() / 6, super.getHeight() / 4 - 15,
				super.getWidth() / 6, super.getHeight() / 4 - 30, 30, COLORS.mainBackground, COLORS.greyLight, 1);
		humidSt = new SENSOR_STATUS(super.getWidth() - 10 - super.getWidth() / 6, super.getHeight() / 4 - 15,
				super.getWidth() / 6, super.getHeight() / 4 - 30, 30, COLORS.mainBackground, COLORS.greyLight, 2);

		tempBar = new SENSOR_BAR(10, super.getHeight() / 4 - 15, super.getWidth() / 4, super.getHeight() / 4 - 30, 30,
				COLORS.mainBackground, COLORS.greyLight, 1);
		humidBar = new SENSOR_BAR(super.getWidth() / 2 + 20, super.getHeight() / 4 - 15, super.getWidth() / 4,
				super.getHeight() / 4 - 30, 30, COLORS.mainBackground, COLORS.greyLight, 2);

		sensNum = new SENSOR_NUMMER(10, 10, super.getHeight() / 8 - 10, super.getHeight() / 8 - 10, 60,
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

		tempAr=new int[1];
		humidAr=new int[1];
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics.create();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Font f = new Font("Arial", Font.BOLD, 25);
		g.setFont(f);
		g.setColor(COLORS.white);

		FontMetrics m = g.getFontMetrics(getFont());
		Rectangle2D r = m.getStringBounds("Temperature & Humidity Sensor", g);

		g.drawString("Temperature & Humidity Sensor", sensNum.getX() + sensNum.getWidth() + 10,
				(int) ((sensNum.getY() + sensNum.getHeight() + r.getHeight() + 10) / 2));

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

	public void updateData() {
		String[] seg = file.updateData();
		tempBar.setData(Integer.valueOf(seg[2]));
		humidBar.setData(Integer.valueOf(seg[3]));

		int[] temp = new int[Integer.valueOf(seg[1])+1];
		for(int x=0;x<tempAr.length;x++) {
			temp[x]=tempAr[x];
		}
		temp[temp.length-1]=Integer.valueOf(seg[2]);
		tempAr=temp;
		
		tempGr.setData(temp);
		int[] humid = new int[Integer.valueOf(seg[1])+1];
		for(int x=0;x<humidAr.length;x++) {
			humid[x]=humidAr[x];
		}
		humid[humid.length-1]=Integer.valueOf(seg[3]);
		humidAr=humid;
		
		humidGr.setData(humid);
	}

	public void setStatus(int status, int sensortype) {
		if (sensortype == 1) {
			tempSt.setStatus(status);
		} else {
			humidSt.setStatus(status);
		}
	}

}
