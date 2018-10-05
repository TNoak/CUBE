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

public class CONTROLLPANEL_OUTDOOR extends BJPanel {

	CButton control;
	private int temperature;

	public CONTROLLPANEL_OUTDOOR(int x, int y, int width, int height, Color background, Color border, int roundness) {
		super();
		super.setSize(width, height);
		super.setLocation(x, y);
		super.setForeground(background);
		super.setBordercolor(border);
		super.setBordersize(1);
		super.setRoundness(roundness);

	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics.create();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(COLORS.white);

		Font f = new Font("Arial", Font.BOLD, 16);
		g.setFont(f);
		FontMetrics m = g.getFontMetrics(g.getFont());
		Rectangle2D r = m.getStringBounds("Outdoor Temp.", g);
		g.drawString("Outdoor Temp.", (int) (super.getWidth() - r.getWidth()) / 2, 10 + (int) r.getHeight() / 2);

		Font f2 = new Font("Arial", Font.BOLD, 20);
		g.setFont(f2);
		FontMetrics m2 = g.getFontMetrics(g.getFont());
		Rectangle2D r2 = m2.getStringBounds(Integer.toString(temperature) + "°C", g);
		g.drawString(Integer.toString(temperature/100) +","+Integer.toString(temperature-temperature/100*100)+ "°C", (int) (super.getWidth() - r2.getWidth()) / 2,
				super.getHeight() / 2 + (int) r2.getHeight() / 2);

	}

	public void setTemp(int temperature) {
		this.temperature = temperature;
		repaint();
	}

	public int getTemp() {
		return temperature;
	}
	
	

}