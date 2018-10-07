package cube.CONTROLLER;

import cube.MODEL.MODEL_MAIN;
import cube.VIEW.GUI_MAIN;

public class CONTROLLER_MAIN {
	
	int sensorcount = 10;
	int intervall = 10;

	MODEL_MAIN model;
	GUI_MAIN gui;

	public CONTROLLER_MAIN() {
		// TODO Auto-generated constructor stub
		
		gui = new GUI_MAIN(sensorcount, intervall);
		model = new MODEL_MAIN(this, sensorcount);
		//updateData(9, 6, 300, 1000, 0, 1);
		
	}
	
	public void updateData(int sensor, int tick, int temp, int humid, int statusTemp, int statusHumid) {
		// sensor: -1=outdoor; -2=flowin; -3=flowout
		gui.updateData(sensor, tick, temp, humid, statusTemp, statusHumid);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CONTROLLER_MAIN();
	}
	
	

}
