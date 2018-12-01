
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
import cube.WIDGETS.CButton;
import cube.WIDGETS.CText;

public class CONTROLLPANEL_OUTDOOR extends BJPanel {

	CButton control;
	private int temperature;
	CText text1, text2;

	public CONTROLLPANEL_OUTDOOR(int x, int y, int width, int height, Color background, Color border, int roundness) {
		super();
		super.setSize(width, height);
		super.setLocation(x, y);
		super.setForeground(background);
		super.setBordercolor(border);
		super.setBordersize(1);
		super.setRoundness(roundness);

		text1 = new CText(10, 10, width - 20, height / 2 - 20, "Outdoor Temp.");
		super.add(text1);
		text2 = new CText(super.getWidth()/4, super.getHeight() / 2, super.getWidth()/2, super.getHeight() / 2 - 20, "--,-�C");
		super.add(text2);
	}

	public void setTemp(int temperature) {
		this.temperature = temperature;
		text2.setText(Integer.toString(temperature / 100) + ","
				+ Integer.toString(temperature - temperature / 100 * 100) + "�C");
		repaint();
	}

	public int getTemp() {
		return temperature;
	}


}