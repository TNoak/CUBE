
package cube.WIDGETS;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public abstract class BJPanel extends JPanel {

	protected Color foregroundcolor, bordercolor;
	protected int roundness, bordersize;

	public BJPanel() {
		super();
		super.setVisible(true);
		super.setOpaque(false);
		super.setLayout(null);
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics.create();

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(foregroundcolor);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), roundness, roundness);

		g.setColor(bordercolor);
		g.setStroke(new BasicStroke(bordersize));
		g.drawRoundRect(0, 0, getWidth() - bordersize, getHeight() - bordersize, roundness, roundness);
	}

	public void setSize(int width, int height) {
		super.setSize(width, height);
		repaint();
	}
	
	public void setBounds(int x,int y ,int width,int height) {
		super.setBounds(x, y, width, height);
		repaint();
	}

	public int getHeight() {
		return super.getHeight();
	}

	public int getWidth() {
		return super.getWidth();
	}

	public void setLocation(int x, int y) {
		super.setLocation(x, y);
		repaint();
	}

	public int getX() {
		return super.getX();
	}

	public int getY() {
		return super.getY();
	}

	public void setForeground(Color foregroundcolor) {
		this.foregroundcolor = foregroundcolor;
		repaint();
	}

	public Color getForeground() {
		return foregroundcolor;
	}

	public void setBordercolor(Color bordercolor) {
		this.bordercolor = bordercolor;
		repaint();
	}

	public Color getBordercolor() {
		return bordercolor;
	}

	public int getRoundness() {
		return roundness;
	}

	public void setRoundness(int roundness) {
		this.roundness = roundness;
	}

	public int getBordersize() {
		return bordersize;
	}

	public void setBordersize(int bordersize) {
		this.bordersize = bordersize;
	}

	public Component add(Component c) {
		super.add(c);
		repaint();
		return c;
	}

}

