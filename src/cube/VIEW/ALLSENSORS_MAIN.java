package cube.VIEW;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;


import cube.STATICS.COLORS;
import cube.WIDGETS.BJPanel;

public class ALLSENSORS_MAIN extends BJPanel implements ActionListener {

	ALLSENSORS_SINGLESENSOR[] sens;
	GUI_MAIN gui;
	int sensorCount;

	JScrollPane scrollPane;
	JPanel panel, pan;

	public ALLSENSORS_MAIN(GUI_MAIN gui, int x, int y, int width, int height, int bordersize, Color foreground,
			Color bordercolor, int roundness, int sensorCount) {
		super();
		super.setLayout(null);
		super.setBounds(x, y, width, height);
		super.setForeground(foreground);
		super.setBordercolor(bordercolor);
		super.setBordersize(bordersize);
		super.setVisible(true);
		super.setRoundness(roundness);

		pan = new JPanel();
		pan.setPreferredSize(new Dimension(width - 30, (height / 5) * ((sensorCount + 1) / 2)));
		pan.setSize(pan.getPreferredSize());
		pan.setLocation(10, 10);
		pan.setVisible(true);
		pan.setLayout(null);
		pan.setBackground(foregroundcolor);

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(pan.getWidth() - 15, pan.getHeight()));
		panel.setSize(panel.getPreferredSize());
		panel.setLocation(0, 0);
		panel.setVisible(true);
		panel.setLayout(new GridLayout((sensorCount + 1) / 2, 2, 10, 10));
		panel.setBackground(foregroundcolor);

		pan.add(panel);

		scrollPane = new JScrollPane(pan);
		scrollPane.setVisible(true);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 10, width - 20, height - 20);
		scrollPane.setBackground(foregroundcolor);
		scrollPane.setBorder(null);


		this.sensorCount = sensorCount;
		this.gui = gui;

		sens = new ALLSENSORS_SINGLESENSOR[sensorCount];
		for (int x1 = 0; x1 < sensorCount; x1++) {


			sens[x1] = new ALLSENSORS_SINGLESENSOR(0, 0, (panel.getWidth() / 2 - 5), ((height - 20) / 5) - 5,
					COLORS.mainBackground, COLORS.greyLight, 10, x1);

			panel.add(sens[x1]);
			sens[x1].getButton().addActionListener(this);
		}
		super.add(scrollPane);

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
