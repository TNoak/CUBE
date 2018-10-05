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

public class SENSOR_NUMMER extends BJPanel {

	private int nummer;

	public SENSOR_NUMMER(int x, int y, int width, int height, int roundness, Color foreground, Color border,
			int nummer) {
		super();
		super.setSize(width, height);
		super.setLocation(x, y);
		super.setForeground(foreground);
		super.setBordercolor(border);
		super.setRoundness(roundness);
		super.setBordersize(1);

		this.nummer = nummer;
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics.create();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Font f = new Font("Arial", Font.BOLD, 25);
		g.setFont(f);
		g.setColor(COLORS.white);

		FontMetrics m = g.getFontMetrics(getFont());
		Rectangle2D r = m.getStringBounds(Integer.toString(nummer)+".", g);

		g.drawString(Integer.toString(nummer)+".", (int) ((super.getWidth()-r.getWidth())/3),
				(int) (super.getWidth() / 2 + r.getBounds().getHeight() / 2));

	}

}
