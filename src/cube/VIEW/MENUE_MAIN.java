package cube.VIEW;

import javax.swing.JPanel;

import cube.STATICS.COLORS;
import cube.WIDGETS.CButton;

public class MENUE_MAIN extends JPanel {

	CButton load, save;

	public MENUE_MAIN(int width, int height) {
		super();
		super.setBounds(0, 0, width, height);
		super.setBackground(COLORS.lightBackground);
		super.setLayout(null);
		super.setVisible(true);

		
	}
}
