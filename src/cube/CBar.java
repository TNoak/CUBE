package cube;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

public class CBar extends JButton {

	private int width, height;
	private int x, y;
	private Color color;
	private int roundness;
	private int pixellevel;
	private double level;

	public CBar() {
		// TODO Auto-generated constructor stub
		initialize();
	}

	public CBar(int x, int y, int width, int height, int roundness, Color color) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.roundness = roundness;
		this.color = color;

		initialize();
	}

	void initialize() {
		this.setBorder(null);
		this.setFocusPainted(false);
		this.setOpaque(false);
	}

	void generatePixelLevel(double level, int lenght) {
		pixellevel = (int) (lenght * level / 100);
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		// TODO Auto-generated method stub

		Graphics2D g = (Graphics2D) graphics.create();

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(color.darker());
		g.fillRoundRect(0, 0, width, height, roundness, roundness);

		g.setColor(color);
		g.fillRoundRect(0, 0, pixellevel, height, roundness, roundness); // x, y müssen 0 sein da sonst das gezeichnete
																			// sont außerhalb des Buttons liegt

		if (this.getModel().isPressed()) {

		} else if (this.getModel().isRollover()) {
			g.setColor(color.brighter());
			g.fillRoundRect(0, 0, width, height, roundness, roundness);
		}

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
		generatePixelLevel(level, width);
	}

}
