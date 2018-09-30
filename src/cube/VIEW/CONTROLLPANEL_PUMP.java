package cube.VIEW;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import cube.STATICS.COLORS;
import cube.WIDGETS.BJPanel;
import cube.WIDGETS.CButton;

public class CONTROLLPANEL_PUMP extends BJPanel {

	CButton control;
	private int flowin, flowout;

	public CONTROLLPANEL_PUMP(int x, int y, int width, int height, Color background, Color border, int roundness) {
		super();
		super.setSize(width, height);
		super.setLocation(x, y);
		super.setForeground(background);
		super.setBordercolor(border);
		super.setBordersize(1);
		super.setRoundness(roundness);

		control = new CButton(10, 10, super.getWidth() - 20, super.getHeight() / 5 * 2, 10, Color.RED,
				super.getForeground());
		control.setText("Heating");
		super.add(control);

		flowin = 6025;
		flowout = 4065;

	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics.create();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(COLORS.white);

		Font f = new Font("Arial", Font.BOLD, 14);

		g.setFont(f);
		g.drawString("Flow IN: " + Integer.toString(flowin / 100) + "," + Integer.toString(flowin - flowin / 100 * 100)
				+ "°C", 10, super.getHeight() / 5 * 3);
		g.drawString("Flow OUT: " + Integer.toString(flowout / 100) + ","
				+ Integer.toString(flowout - flowout / 100 * 100) + "°C", 10, super.getHeight() / 5 * 4);
	}

	public void setFlowIn(int flowin) {
		this.flowin = flowin;
		repaint();
	}

	public void setFlowOut(int flowout) {
		this.flowout = flowout;
		repaint();
	}

	public CButton getButton() {
		return control;
	}
}
