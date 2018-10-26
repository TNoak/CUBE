package cube.VIEW;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import cube.STATICS.COLORS;
import cube.WIDGETS.BJPanel;

public class ALLSENSORS_MAIN extends BJPanel implements ActionListener {

	ALLSENSORS_SINGLESENSOR[] sens;
	GUI_MAIN gui;
	int sensorCount;
	JPanel panel;

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

		panel = new JPanel();
		panel.setBounds(10, 10, super.getWidth() - 20, (sensorCount + 1) / 2 * 90);
		panel.setVisible(true);
		panel.setOpaque(false);
		panel.setLayout(new GridLayout((sensorCount + 1) / 2, 2, 10, 10));

		this.sensorCount = sensorCount;
		this.gui = gui;

		sens = new ALLSENSORS_SINGLESENSOR[sensorCount];
		for (int x1 = 0; x1 < sensorCount; x1++) {
			/*
			 * if (x1 < sensorCount / 2) { sens[x1] = new ALLSENSORS_SINGLESENSOR(10, (x1 *
			 * (super.getHeight() - 20) / (sensorCount / 2)) + 10, (super.getWidth() - 30) /
			 * 2, (super.getHeight() - 20) / sensorCount * 2 - 5, COLORS.mainBackground,
			 * COLORS.greyLight, 10, x1); } else { sens[x1] = new
			 * ALLSENSORS_SINGLESENSOR((super.getWidth() - 30) / 2 + 20, ((x1 - sensorCount
			 * / 2) * (super.getHeight() - 20) / (sensorCount / 2)) + 10, (super.getWidth()
			 * - 30) / 2, (super.getHeight() - 20) / sensorCount * 2 - 5,
			 * COLORS.mainBackground, COLORS.greyLight, 10, x1); }
			 */
			sens[x1] = new ALLSENSORS_SINGLESENSOR((super.getWidth() - 30) / 2 + 20,
					((x1 - sensorCount / 2) * (super.getHeight() - 20) / (sensorCount / 2)) + 10,
					(super.getWidth() - 30) / 2, 85, COLORS.mainBackground, COLORS.greyLight, 10, x1);

			panel.add(sens[x1]);
			sens[x1].getButton().addActionListener(this);
		}

		super.add(panel);
		
		setVisible(false);
		setVisible(true);

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

	public void updateData(int sensor, int tick, int temp, int humid, int statusTemp, int statusHumid) {
		sens[sensor].updateData(temp, humid);
	}
}
