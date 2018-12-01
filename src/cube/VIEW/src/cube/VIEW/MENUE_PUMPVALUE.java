package cube.VIEW;

import java.awt.Color;

import cube.WIDGETS.BJPanel;
import cube.WIDGETS.CText;

public class MENUE_PUMPVALUE extends BJPanel {

	private int flowin, flowout;
	CText fin, fout;

	public MENUE_PUMPVALUE(int x, int y, int width, int height, Color background, Color border, int roundness) {
		super();
		super.setSize(width, height);
		super.setLocation(x, y);
		super.setForeground(background);
		super.setBordercolor(border);
		super.setBordersize(1);
		super.setRoundness(roundness);

		fin = new CText(10, 10, super.getWidth() - 20, super.getHeight() / 2 - 15, "Flow IN:   --,-°C");
		super.add(fin);

		fout = new CText(10, super.getHeight() / 2 + 5, super.getWidth() - 20, super.getHeight() / 2 - 15,
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

}
