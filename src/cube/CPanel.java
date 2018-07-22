package cube;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

public class CPanel extends JButton {

	private int width, height;
	private int x, y;
	private Color color;
	private Color bordercolor;
	private int roundness;
	private int bordersize = 1;

	public CPanel() {
		// TODO Auto-generated constructor stub
		initialize();
	}

	public CPanel(int x, int y, int width, int height, int roundness, int bordersize, Color color, Color bordercolor) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.roundness = roundness;
		this.color = color;
		this.bordercolor = bordercolor;
		this.bordersize = bordersize;

		initialize();
	}
	
	public CPanel(int x, int y, int width, int height, int roundness, Color color, Color bordercolor) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.roundness = roundness;
		this.color = color;
		this.bordercolor = bordercolor;
		this.bordersize = bordersize;

		initialize();
	}

	void initialize() {
		this.setBorder(null);
		this.setFocusPainted(false);
		this.setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		// TODO Auto-generated method stub

		Graphics2D g = (Graphics2D) graphics.create();

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.fillRoundRect(0, 0, width, height, roundness, roundness);

		g.setColor(bordercolor);
		g.setStroke(new BasicStroke(bordersize));
		g.drawRoundRect(0, 0, width - bordersize, height - bordersize, roundness,
				roundness);
	}

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Getters/Setters	

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getRoundness() {
		return roundness;
	}

	public void setRoundness(int roundness) {
		this.roundness = roundness;
	}

	public Color getBordercolor() {
		return bordercolor;
	}

	public void setBordercolor(Color bordercolor) {
		this.bordercolor = bordercolor;
	}

	public int getBordersize() {
		return bordersize;
	}

	public void setBordersize(int bordersize) {
		this.bordersize = bordersize;
	}

}
