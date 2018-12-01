package test;

import java.awt.Color;

import cube.WIDGETS.BJPanel;

public class test extends BJPanel {
	
	test3 t;
	
	test(){
		super();
		super.setSize(100, 1000);
		super.setLocation(10, 20);
		super.setRoundness(90);
		super.setBordersize(2);
		super.setBordercolor(Color.WHITE);
		super.setForeground(Color.DARK_GRAY);
		
		t=new test3();
		super.add(t);
	}

}
