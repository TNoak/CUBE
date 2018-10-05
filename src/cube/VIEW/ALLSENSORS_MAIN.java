package cube.VIEW;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cube.STATICS.COLORS;
import cube.WIDGETS.BJPanel;

public class ALLSENSORS_MAIN extends BJPanel implements ActionListener {

	ALLSENSORS_SINGLESENSOR[] sens;
	GUI_MAIN gui;
	int sensorCount;

	public ALLSENSORS_MAIN(GUI_MAIN gui, int x, int y, int width, int height, Color foreground, Color bordercolor,
			int roundness, int sensorCount) {
		super();
		super.setSize(width, height);
		super.setLocation(x, y);
		super.setForeground(foreground);
		super.setBordercolor(bordercolor);
		super.setBordersize(1);
		super.setRoundness(roundness);
		super.setLayout(null);
		super.setVisible(true);

		this.sensorCount = sensorCount;
		this.gui = gui;

		sens = new ALLSENSORS_SINGLESENSOR[sensorCount];
		for (int x1 = 0; x1 < sensorCount; x1++) {
			if (x1 < sensorCount / 2) {
				sens[x1] = new ALLSENSORS_SINGLESENSOR(10, (x1 * (super.getHeight() - 20) / (sensorCount / 2)) + 10,
						(super.getWidth() - 30) / 2, (super.getHeight() - 20) / sensorCount * 2 - 5,
						COLORS.mainBackground, COLORS.greyLight, 10, x1);
			} else {
				sens[x1] = new ALLSENSORS_SINGLESENSOR((super.getWidth() - 30) / 2 + 20,
						((x1 - sensorCount / 2) * (super.getHeight() - 20) / (sensorCount / 2)) + 10,
						(super.getWidth() - 30) / 2, (super.getHeight() - 20) / sensorCount * 2 - 5,
						COLORS.mainBackground, COLORS.greyLight, 10, x1);
			}
			super.add(sens[x1]);
			sens[x1].getButton().addActionListener(this);
		}
	}

	public void setVisible(boolean vis) {
		super.setVisible(vis);
	}

	public void actionPerformed(ActionEvent e) {
		for (int x = 0; x <= sensorCount; x++) {
			if (e.getSource() == sens[x].getButton()) {
				gui.showSensor(x);
				setVisible(false);
				break;
			}
		}
	}

	public void updateData(int sensor ,int tick, int temp, int humid, int statusTemp, int statusHumid) {
		sens[sensor].updateData( temp, humid);
	}
}
