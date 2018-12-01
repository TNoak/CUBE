package cube.WIDGETS;

import java.awt.Color;

import javax.swing.JSlider;
import javax.swing.border.SoftBevelBorder;

import cube.STATICS.COLORS;

public class CSlider extends JSlider {

	int minVal, maxVal, val;
	int x, y, width, height;

	public CSlider(int x, int y, int width, int height, int max, int min, Color background) {
		super();
		maxVal = max;
		minVal = min;
		val = minVal;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		super.setMaximum(maxVal);
		super.setMinimum(minVal);
		super.setBounds(x, y, width, height);
		super.setVisible(true);
		super.setLayout(null);
		super.setValue(val);
		super.setBackground(background);
		super.setOpaque(true);
		super.setBorder(new SoftBevelBorder(1));
	}
}
