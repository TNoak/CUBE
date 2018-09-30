package cube.WIDGETS;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class CBar extends JLabel {

	private int width, height;
	private int x, y;
	private Color color,color2;
	private int roundness;
	private int pixellevel;
	private double level;

	public CBar() {
		initialize();
	}

	public CBar(int x, int y, int width, int height, int roundness, Color color,Color color2) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.roundness = roundness;
		this.color = color;
		this.color2=color2;

		initialize();
	}

	void initialize() {
		this.setBorder(null);
		this.setOpaque(false);

	}

	void generatePixelLevel(double level, int lenght) {
		pixellevel = (int) (lenght * level);
		System.out.println(pixellevel);
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		// TODO Auto-generated method stub

		Graphics2D g = (Graphics2D) graphics.create();

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(color2);
		g.fillRoundRect(0, 0, width, height, roundness, roundness);

		g.setColor(color);
		g.fillRoundRect(0, 0, pixellevel, height, roundness, roundness); // x, y m�ssen 0 sein da sonst das gezeichnete
																			// sont au�erhalb des Buttons liegt

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

	public double getLevel() {
		return level;
	}

	public void setLevel(double level) {
		this.level = level;
		generatePixelLevel(level, getWidth());
		repaint();
	}

}
