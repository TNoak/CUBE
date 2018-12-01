package cube.VIEW;

import java.awt.Color;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cube.WIDGETS.BJPanel;
import cube.WIDGETS.CText;

public class CONTROLLPANEL_WINDOWS extends BJPanel implements ChangeListener {

	CText wind;
	CONTROLLPANEL_SINGLEWINDOW lo, ro, lu, ru;
	GUI_MAIN gui;

	public CONTROLLPANEL_WINDOWS(GUI_MAIN gui,int x, int y, int width, int height, Color background, Color border, int roundness) {
		super();
		super.setSize(width, height);
		super.setLocation(x, y);
		super.setForeground(background);
		super.setBordercolor(border);
		super.setBordersize(1);
		super.setRoundness(roundness);

		this.gui=gui;
		
		wind = new CText(10, 10, super.getWidth() - 20, super.getHeight() / 3 - 30, "Windows");
		super.add(wind);

		lo = new CONTROLLPANEL_SINGLEWINDOW(10, height / 3, width / 2 - 15, height / 3 - 10, background, 1);
		lo.getSlider().addChangeListener(this);
		super.add(lo);
		ro = new CONTROLLPANEL_SINGLEWINDOW(width / 2 + 5, height / 3, width / 2 - 15, height / 3 - 10, background, 2);
		ro.getSlider().addChangeListener(this);
		super.add(ro);

		lu = new CONTROLLPANEL_SINGLEWINDOW(10, height / 3 * 2, width / 2 - 15, height / 3 - 10, background, 3);
		lu.getSlider().addChangeListener(this);
		super.add(lu);
		ru = new CONTROLLPANEL_SINGLEWINDOW(width / 2 + 5, height / 3 * 2, width / 2 - 15, height / 3 - 10, background,
				4);
		ru.getSlider().addChangeListener(this);
		super.add(ru);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource()==lo.getSlider()) {
			lo.setText(Integer.toString(lo.getValue()));
			gui.sendDataWindow(1, lo.getValue());
		}
		if(e.getSource()==lu.getSlider()) {
			lu.setText(Integer.toString(lu.getValue()));
			gui.sendDataWindow(3, lu.getValue());
		}
		if(e.getSource()==ro.getSlider()) {
			ro.setText(Integer.toString(ro.getValue()));
			gui.sendDataWindow(2, ro.getValue());
		}
		if(e.getSource()==ru.getSlider()) {
			ru.setText(Integer.toString(ru.getValue()));
			gui.sendDataWindow(4, ru.getValue());
		}
	}

}
