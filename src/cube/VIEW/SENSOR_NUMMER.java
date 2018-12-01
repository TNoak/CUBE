
package cube.VIEW;

import java.awt.Color;

import cube.WIDGETS.BJPanel;
import cube.WIDGETS.CText;

public class SENSOR_NUMMER extends BJPanel {

	private int nummer;
	CText num;

	public SENSOR_NUMMER(int x, int y, int width, int height, Color foreground, Color border, int nummer) {
		super();
		super.setSize(width, height);
		super.setLocation(x, y);
		super.setForeground(foreground);
		super.setBordercolor(border);
		super.setRoundness(height);
		super.setBordersize(1);

		this.nummer = nummer;
		num = new CText(0, 0, width, height, Integer.toString(nummer));
		super.add(num);
	}

}

