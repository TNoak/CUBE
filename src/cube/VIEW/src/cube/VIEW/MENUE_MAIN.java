package cube.VIEW;

import javax.swing.JPanel;

import cube.STATICS.COLORS;

public class MENUE_MAIN extends JPanel {

	MENUE_PUMPCONTROL pump;
	MENUE_PUMPVALUE pval;
	GUI_MAIN gui;

	public MENUE_MAIN(GUI_MAIN gui,int width, int height, int frameheight) {
		super();
		super.setBounds(0, 0, width, height);
		super.setBackground(COLORS.lightBackground);
		super.setLayout(null);
		super.setVisible(true);
		
		this.gui=gui;

		pump = new MENUE_PUMPCONTROL(gui,frameheight / 6 * 9 - 10 - super.getWidth() / 4, 10, super.getWidth() / 4,
				super.getHeight() - 20, 10, COLORS.mainBackground, COLORS.greyLight);
		super.add(pump);

		pval = new MENUE_PUMPVALUE(frameheight / 6 * 9 + 10, 10, super.getWidth() - frameheight / 6 * 9 - 40,
				super.getHeight() - 20, COLORS.mainBackground, COLORS.greyLight, 10);
		super.add(pval);
	}
	
	
	public void updateData(int sensor, int temp) {
		if (sensor == -2) {
			pval.setFlowIn(temp);
		}
		if (sensor == -3) {
			pval.setFlowOut(temp);
		}

	}
}
