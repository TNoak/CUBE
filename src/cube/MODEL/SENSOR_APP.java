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

	public SENSOR_APP(int id, MODEL_MAIN mm) {
		// TODO Auto-generated constructor stub
		this.id = id;
		model = mm;
		controller = model.getController();
		updateData(id, 3, 300, 400, 0, 0);
	}

	public void updateData(int sensor, int tick, int temp, int humid, int statusTemp, int statusHumid) {
		// sensor: -1=outdoor; -2=flowin; -3=flowout
		controller.updateData(sensor, tick, temp, humid, statusTemp, statusHumid);
	}

	public void newData(String data) {
		
		System.out.println(data);
		String result = data.substring(2);
		result = result.replace(".", "");
		result = result.substring(0, result.length() - 1);
		int res = Integer.parseInt(result);
		System.out.println(result);
		if (res >= 0) {
			if(res <= 300) {
				t = res;
			}
			updateData(id, 10, t, res, 0, 0);
		}

	}

}
