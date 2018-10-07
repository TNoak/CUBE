package cube.MODEL;

import cube.CONTROLLER.CONTROLLER_MAIN;

public class SENSOR_APP {

	MODEL_MAIN model;
	CONTROLLER_MAIN controller;

	int id;

	int tick;

	int temp;
	int humi;

	int statusTemp;
	int statusHumid;

	int t = 0;

	int[] read;
	boolean firstvalue = true;

	public SENSOR_APP(int id, MODEL_MAIN mm) {
		// TODO Auto-generated constructor stub
		this.id = id;
		model = mm;
		controller = model.getController();
		read = new int[2];
		updateData(id, 3, 300, 400, 0, 0); // nur temporär
	}

	public void updateData(int sensor, int tick, int temp, int humid, int statusTemp, int statusHumid) {
		// sensor: -1=outdoor; -2=flowin; -3=flowout
		controller.updateData(sensor, tick, temp, humid, statusTemp, statusHumid);
	}

	public void newData(int id, int value, char datatype, int status) {

		if (datatype == 't') {
			temp = value;
		} else if (datatype == 'h') {
			humi = value;
		} else if(datatype == 'n') {
			temp = 0;
			humi = 0;
		}

		read[0] = value;

		updateData(id + 1, 5, temp, humi, status, status); // +1 weg machen
		
		tick++;

	}

}
