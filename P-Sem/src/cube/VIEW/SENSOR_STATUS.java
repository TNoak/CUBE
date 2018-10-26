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
import cube.WIDGETS.CText;

public class SENSOR_STATUS extends BJPanel {

	private int status, sensortype;
	CText stat, tex;

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

		tex = new CText(10,10,super.getWidth()-20,super.getHeight()/2-20,"Sensor Status");
		super.add(tex);

		stat = new CText(10,super.getHeight()/2,super.getWidth()-20,super.getHeight()/2-20,"--");
		super.add(stat);
	}


	public void setStatus(int status) {
		this.status = status;
		switch (status) {
		case 1:
			stat.setText("OK");
			stat.setColor(COLORS.buttonGreen);
		case 2:
			stat.setText("FEHLER");
			stat.setColor(COLORS.buttonRed);
		}
	}

	public int getStatus() {
		return status;
	}

}