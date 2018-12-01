package cube.WIDGETS;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import cube.STATICS.COLORS;

public class CGraph extends JPanel {

	protected int sensortype;

	protected int timePerMeasure;

	protected int[] data;

	public CGraph(int sensortype) {
		super();
		super.setVisible(true);
		super.setOpaque(false);
		super.setLayout(null);

		this.sensortype = sensortype;


		data = new int[1];
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics.create();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.setStroke(new BasicStroke(1));

		g.setColor(Color.WHITE);
		g.drawLine(25, 0, 25, getHeight() - 1);
		g.drawLine(25, getHeight() - 1, getWidth() - 1, getHeight() - 1);

		if (sensortype == 1) {
			g.setColor(Color.WHITE);
			Font f = new Font("Arial", Font.PLAIN, 9);
			g.setFont(f);
			g.drawString("0°C", 2, super.getHeight());
			g.drawString("35°C", 2, 9);

		} else {
			g.setColor(Color.WHITE);
			Font f = new Font("Arial", Font.PLAIN, 9);
			g.setFont(f);
			g.drawString("0%", 2, super.getHeight());
			g.drawString("100%", 2, 9);

		}

		if (sensortype == 1) {
			g.setColor(COLORS.temp);
			for (int x = 0; x < data.length - 1; x++) {
				g.drawLine((getWidth() - 25) / data.length * x + 25, (int) getHeight() - (data[x] * getHeight() / 350),
						(getWidth() - 25) / data.length * (x + 1) + 25,
						(int) getHeight() - (data[x + 1] * getHeight() / 350));
			}
		} else {
			g.setColor(COLORS.humid);
			for (int x = 0; x < data.length - 1; x++) {
				g.drawLine((getWidth() - 25) / data.length * x + 25, (int) getHeight() - (data[x] * getHeight() / 1000),
						(getWidth() - 25) / data.length * (x + 1) + 25,
						(int) getHeight() - (data[x + 1] * getHeight() / 1000));
				// System.out.println(((int) getHeight() - (data[x] * getHeight() / 1000))+"
				// ,"+((int) getHeight() - (data[x + 1] * getHeight() / 1000)));
			}
		}

		g.setColor(Color.WHITE);
		Font f = new Font("Arial", Font.PLAIN, 9);
		g.setFont(f);
		if (timePerMeasure * data.length < 60) {
			g.drawString("      "+timePerMeasure * data.length + "s", getWidth() - 60, getHeight() - 6);
		} else {
			int sec=timePerMeasure*data.length-60;
			int min=1;
			while(sec>60) {
				min++;
				sec-=60;
			}
			g.drawString(Integer.toString(min)+"min "+Integer.toString(sec)+"sec",getWidth() - 60, getHeight() - 6);
		}
	}

	public void setSize(int width, int height) {
		super.setSize(width, height);
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

	public void setData(int[] data) {
		this.data = data;
		repaint();
	}

	public void setTime(int time) {
		timePerMeasure = time;
	}

	public Component add(Component c) {
		super.add(c);
		repaint();
		return c;
	}

}
