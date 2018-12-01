package cube.WIDGETS;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;

import cube.STATICS.COLORS;

public class CText extends JLabel {

	private String text;
	private Color color;

	public CText(int x, int y, int width, int height, String text) {
		super();
		super.setBounds(x, y, width, height);
		super.setVisible(true);
		super.setOpaque(false);

		this.text = text;
		color=COLORS.white;
	}

	public void paintComponent(Graphics graphics) {

		Graphics2D g = (Graphics2D) graphics.create();

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(color);

		for (int x = 40; x > 5; x--) {
			Font f = new Font("Arial", Font.BOLD, x);
			g.setFont(f);
			FontMetrics m = g.getFontMetrics(g.getFont());
			Rectangle2D r = m.getStringBounds(text, g);

			if (r.getWidth() < this.getWidth() && r.getHeight() < this.getHeight()) {
				g.drawString(text, (int) (super.getWidth() - r.getWidth()) / 2,
						(int) (this.getHeight() + r.getHeight()) / 2 - 5);
				break;
			}
		}

	}
	
	public void setColor(Color c) {
		color=c;
		repaint();
	}

	public void setSize(int width, int height) {
		super.setSize(width, height);
		repaint();
	}

	public void setBounds(int x, int y, int width, int height) {
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

	public void setText(String s) {
		this.text = s;
		repaint();
	}
}
