package cube.VIEW;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import cube.STATICS.COLORS;
import cube.WIDGETS.BJPanel;
import cube.WIDGETS.CBar;
import cube.WIDGETS.CText;

public class SENSOR_BAR extends BJPanel {

	private int sensortype;
	private int data;
	CBar cb;
	CText ct;

	public SENSOR_BAR(int x, int y, int width, int height, int roundness, Color foreground, Color border,
			int sensortype) {
		super();
		super.setSize(width, height);
		super.setLocation(x, y);
		super.setForeground(foreground);
		super.setBordercolor(border);
		super.setBordersize(1);
		super.setRoundness(roundness);

		this.sensortype = sensortype;

		if (sensortype == 1) {
			cb = new CBar(30, super.getHeight() / 2, super.getWidth() - 60, 20, 20, COLORS.temp, COLORS.temp2);
			super.add(cb);

			ct = new CText(10, 5, super.getWidth() - 20, super.getHeight() / 2 - 10, "Temperature: --,-°C");
			super.add(ct);
		} else {
			cb = new CBar(30, super.getHeight() / 2, super.getWidth() - 60, 20, 20, COLORS.humid, COLORS.humid2);
			super.add(cb);

			ct = new CText(10, 5, super.getWidth() - 20, super.getHeight() / 2 - 10, "Humidity: --,-%");
			super.add(ct);
		}
	}

	public void setData(int data) {
		this.data = data;
		if (sensortype == 2) {
			cb.setLevel((double) data / 1000);
			ct.setText("Temperature: " + Integer.toString(data / 10) + "," + Integer.toString(data - data / 10 * 10)
					+ "°C");
		} else {
			cb.setLevel((double) data / 350);
			ct.setText(
					"Humidity: " + Integer.toString(data / 10) + "," + Integer.toString(data - data / 10 * 10) + "%");
		}
	}

}
