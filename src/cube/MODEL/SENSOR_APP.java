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


	public SENSOR_APP(int id, MODEL_MAIN mm) {
		// TODO Auto-generated constructor stub
		this.id = id;
		model = mm;
		controller = model.getController();
		
		updateData(id, 0, 300, 400, 0, 0); // nur temporär
	}

	public void updateData(int sensor, int tick, int temp, int humid, int statusTemp, int statusHumid) {
		// sensor: -1=outdoor; -2=flowin; -3=flowout
		controller.updateData(sensor, tick, temp, humid, statusTemp, statusHumid);
	}

	public void newData(int id, double valuetemp, double valuehumi) {
		
		temp = (int) valuetemp; 
		humi = (int) valuehumi;
		
		updateData(id , 3, temp, humi, 0, 0);

	}

}
