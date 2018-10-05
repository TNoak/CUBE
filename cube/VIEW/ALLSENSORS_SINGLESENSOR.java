package cube.VIEW;

import java.awt.Color;

import cube.STATICS.COLORS;
import cube.WIDGETS.BJPanel;
import cube.WIDGETS.CButton;

public class ALLSENSORS_SINGLESENSOR extends BJPanel {

	SENSOR_BAR humid, temp;
	CButton but;
	int number;

	public ALLSENSORS_SINGLESENSOR(int x, int y, int width, int height, Color foreground, Color bordercolor,
			int roundness, int sensorNumber) {

		super();
		super.setSize(width, height);
		super.setLocation(x, y);
		super.setForeground(foreground);
		super.setBordercolor(bordercolor);
		super.setBordersize(1);
		super.setRoundness(roundness);
		super.setLayout(null);
		super.setVisible(true);

		but = new CButton(10, 10, super.getHeight() - 20, super.getHeight() - 20, 10, COLORS.buttonSensor,
				super.getForeground());
		but.setText(Integer.toString(sensorNumber + 1));

		humid = new SENSOR_BAR(super.getHeight() + (super.getWidth() - super.getHeight()) / 2, 10,
				(super.getWidth() - super.getHeight() - 20) / 2, super.getHeight() - 20, 10, COLORS.mainBackground,
				COLORS.greyLight, 2);
		temp = new SENSOR_BAR(super.getHeight(), 10, (super.getWidth() - super.getHeight() - 20) / 2,
				super.getHeight() - 20, 10, COLORS.mainBackground, COLORS.greyLight, 1);

		super.add(humid);
		super.add(temp);
		super.add(but);

	}

	public CButton getButton() {
		return but;
	}

	public int getNumber() {
		return number;
	}
	
	public void updateData(int t,int h) {	
		temp.setData(t);
		humid.setData(h);
	}

}
