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

public class SENSOR_BAR extends BJPanel {

	private int sensortype;
	private int data;
	CBar cb;

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
		} else {
			cb = new CBar(30, super.getHeight() / 2, super.getWidth() - 60, 20, 20, COLORS.humid, COLORS.humid2);
			super.add(cb);
		}

		setData(250);
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics.create();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (sensortype == 1) {
			g.setColor(COLORS.white);
			Font f = new Font("Arial", Font.BOLD, 20);
			g.setFont(f);
			FontMetrics m = g.getFontMetrics(g.getFont());
			Rectangle2D r = m.getStringBounds("Temperature: __,_°C", g);
			g.drawString("Temperature: " + Integer.toString(data / 10) + "," + Integer.toString(data - data / 10 * 10)
					+ "°C", (int) (super.getWidth() - r.getWidth()) / 2, 30);

		} else {
			g.setColor(COLORS.white);
			Font f = new Font("Arial", Font.BOLD, 20);
			g.setFont(f);
			FontMetrics m = g.getFontMetrics(g.getFont());
			Rectangle2D r = m.getStringBounds("Humidity: ___,_%", g);
			g.drawString(
					"Humidity: " + Integer.toString(data / 10) + "," + Integer.toString(data - data / 10 * 10) + "%",
					(int) (super.getWidth() - r.getWidth()) / 2, 30);

		}
	}

	public void setData(int data) {
		this.data = data;
		if (sensortype == 2) {
			cb.setLevel((double) data / 1000);
		} else {
			cb.setLevel((double) data / 350);
		}
		repaint();
	}

}
