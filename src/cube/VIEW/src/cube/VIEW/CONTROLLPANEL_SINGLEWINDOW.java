package cube.VIEW;

import java.awt.Color;

import cube.STATICS.COLORS;
import cube.WIDGETS.BJPanel;
import cube.WIDGETS.CSlider;
import cube.WIDGETS.CText;

public class CONTROLLPANEL_SINGLEWINDOW extends BJPanel {

	int number;
	CSlider cs;
	CText ct;

	public CONTROLLPANEL_SINGLEWINDOW(int x, int y, int width, int height, Color bg,int nr) {
		super();
		super.setBackground(bg);
		super.setBounds(x, y, width, height);
		super.setLayout(null);
		super.setVisible(true);
		super.setBordercolor(COLORS.greyLight);
		super.setBordersize(1);
		super.setRoundness(10);
		super.setForeground(bg);
		
		number=nr;

		cs=new CSlider(5,height/2,width-10, height/2-5,45,0,bg);
		super.add(cs);
		
		ct=new CText(5,5,width-10,height/2-10,cs.getValue()+"°");
		super.add(ct);
	}
	
	public void setText(String text) {
		ct.setText(text+"°");
	}
	
	public int getValue() {
		return cs.getValue();
	}
	
	public CSlider getSlider() {
		return cs;
	}

}
