
package cube.WIDGETS;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;

import cube.STATICS.COLORS;

public class CButton extends JButton {

	private int width, height;
	private int x, y;
	private Color color, background;
	private int roundness;

	private String text;

	public CButton(int x, int y, int width, int height, int roundness, Color color, Color background) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.roundness = roundness;
		this.color = color;
		this.background = background;
		text = "";

		initialize();
	}

	void initialize() {
		super.setBorder(null);
		super.setFocusPainted(false);
		super.setOpaque(false);
		super.setVisible(true);
		super.setBounds(this.x, this.y, this.width, this.height);
		repaint();
	}

	protected void paintComponent(Graphics graphics) {
		// TODO Auto-generated method stub
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics.create();

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(background);

		g.fillRect(0, 0, width, height);

		g.setColor(color);

		g.fillRoundRect(0, 0, width, height, roundness, roundness);

		g.setColor(COLORS.white);

		if (text != "exit") {
			for (int x = 40; x > 5; x--) {
				Font f = new Font("Arial", Font.BOLD, x);
				g.setFont(f);
				FontMetrics m = g.getFontMetrics(g.getFont());
				Rectangle2D r = m.getStringBounds(text, g);

				if (r.getWidth() < ((this.getWidth()/3)*2) && r.getHeight() < ((this.getHeight()/2)*3)) {
					g.drawString(text, (int) (super.getWidth()-r.getWidth())/2, (int) (this.getHeight()+r.getHeight())/2-5);
					break;
				}
			}
		} else {
			g.setStroke(new BasicStroke(4));
			g.drawLine(roundness, roundness, getWidth()-roundness, getHeight()-roundness);
			g.drawLine(roundness, getHeight()-roundness, getWidth()-roundness, roundness);
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
		repaint();
	}

	public int getRoundness() {
		return roundness;
	}

	public void setRoundness(int roundness) {
		this.roundness = roundness;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}

