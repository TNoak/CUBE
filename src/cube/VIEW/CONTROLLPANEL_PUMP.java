package cube.VIEW;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import cube.STATICS.COLORS;
import cube.WIDGETS.BJPanel;
import cube.WIDGETS.CButton;

import cube.WIDGETS.CText;


public class CONTROLLPANEL_PUMP extends BJPanel {

	CButton control;
	private int flowin, flowout;

	CText fin, fout;


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


		fin = new CText(10, super.getHeight() / 5 * 3, super.getWidth() - 20, super.getHeight() / 5, "Flow IN:   --,-°C");
		super.add(fin);

		fout = new CText(10, super.getHeight() / 5 * 4, super.getWidth() - 20, super.getHeight() / 5,
				"Flow OUT: --,-°C");
		super.add(fout);

	}

	public void setFlowIn(int flowin) {
		this.flowin = flowin;

		fin.setText("Flow IN:   " + Integer.toString(flowin / 100) + "," + Integer.toString(flowin - flowin / 100 * 100)
				+ "°C");

		repaint();
	}

	public void setFlowOut(int flowout) {
		this.flowout = flowout;

		fout.setText("Flow OUT: " + Integer.toString(flowout / 100) + ","
				+ Integer.toString(flowout - flowout / 100 * 100) + "°C");

		repaint();
	}

	public CButton getButton() {
		return control;
	}
}
