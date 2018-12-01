package cube.VIEW;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cube.STATICS.COLORS;
import cube.WIDGETS.BJPanel;
import cube.WIDGETS.CButton;
import cube.WIDGETS.CSlider;
import cube.WIDGETS.CText;

public class MENUE_PUMPCONTROL extends BJPanel implements ChangeListener, ActionListener {

	CButton pump, heat;
	CSlider temp;
	CText tempanz;
	int slidervalue;
	boolean pumpOnOff, heatOnOff;

	GUI_MAIN gui;

	public MENUE_PUMPCONTROL(GUI_MAIN gui, int x, int y, int width, int height, int roundness, Color foreground,
			Color border) {
		super();
		super.setBounds(x, y, width, height);
		super.setBordersize(1);
		super.setBordercolor(border);
		super.setForeground(foreground);
		super.setRoundness(roundness);
		super.setVisible(true);
		super.setLayout(null);

		this.gui = gui;

		pump = new CButton(10, 10, super.getWidth() / 3, super.getHeight() / 2 - 15, 5, COLORS.buttonRed, foreground);
		pump.setText("Pump");
		pump.addActionListener(this);
		super.add(pump);

		heat = new CButton(10, super.getHeight() / 2 + 5, super.getWidth() / 3, super.getHeight() / 2 - 15, 5,
				COLORS.buttonRed, foreground);
		heat.setText("Heating");
		heat.addActionListener(this);
		super.add(heat);

		temp = new CSlider(super.getWidth() / 3 + 20, super.getHeight() / 2 + 5, super.getWidth() / 3 * 2 - 30,
				super.getHeight() / 2 - 15, 80, 40, foreground);
		temp.setValue(55);
		temp.addChangeListener(this);
		super.add(temp);

		tempanz = new CText(super.getWidth() / 3 + 20, 10, super.getWidth() / 3 * 2 - 30, super.getHeight() / 2 - 15,
				"Temperature: "+temp.getValue()+"°C");
		super.add(tempanz);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == temp) {
			slidervalue = temp.getValue();
			tempanz.setText("Temperature: " + Integer.toString(slidervalue) + "°C");
			gui.sendDataHeating(heatOnOff, pumpOnOff, slidervalue);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pump) {
			pumpOnOff = !pumpOnOff;
			if (pumpOnOff)
				pump.setColor(COLORS.buttonGreen);
			else
				pump.setColor(COLORS.buttonRed);
		}
		if (e.getSource() == heat) {
			heatOnOff = !heatOnOff;
			if (heatOnOff)
				heat.setColor(COLORS.buttonGreen);
			else
				heat.setColor(COLORS.buttonRed);
		}
		gui.sendDataHeating(heatOnOff, pumpOnOff, slidervalue);
	}
}
