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

public class SENSOR_STATUS extends BJPanel {

	private int status, sensortype;

	public SENSOR_STATUS(int x, int y, int width, int height, int roundness, Color foreground, Color border,
			int sensortype) {
		super();
		super.setSize(width, height);
		super.setLocation(x, y);
		super.setForeground(foreground);
		super.setBordercolor(border);
		super.setRoundness(roundness);
		super.setBordersize(1);

		status = 0;
		this.sensortype = sensortype;
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics.create();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Font f = new Font("Arial", Font.BOLD, 20);
		g.setFont(f);

		FontMetrics m = g.getFontMetrics(g.getFont());

		Rectangle2D r = m.getStringBounds("Sensor Status", g);

		g.setColor(COLORS.white);
		g.drawString("Sensor Status", (int) ((super.getWidth() / 2) - (r.getWidth() / 2)), (int) (r.getHeight() + 5));

		if (status == 0) {
			g.setColor(COLORS.buttonGreen);
			f = new Font("Arial", Font.BOLD, 30);
			g.setFont(f);
			m = g.getFontMetrics(g.getFont());
			r = m.getStringBounds("OK", g);
			g.drawString("OK", (int) (super.getWidth() - r.getWidth()) / 2,
					(int) (super.getHeight() + r.getHeight()) / 2);
		} else {
			g.setColor(COLORS.buttonRed);
			f = new Font("Arial", Font.BOLD, 30);
			g.setFont(f);
			m = g.getFontMetrics(g.getFont());
			r = m.getStringBounds("FEHLER", g);
			g.drawString("FEHLER", (int) (super.getWidth() - r.getWidth()) / 2,
					(int) (super.getHeight() + r.getHeight()) / 2);
		}
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}