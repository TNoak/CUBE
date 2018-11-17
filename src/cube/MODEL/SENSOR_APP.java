package cube.MODEL;

import cube.CONTROLLER.CONTROLLER_MAIN;

public class SENSOR_APP {

	MODEL_MAIN model;
	CONTROLLER_MAIN controller;

	int id;

	int tick;

	String stringtemp;
	String stringhumi;
	
	int temp;
	int humi;

	int statustemp = 1;
	int statushumi = 1;

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

	public void newData(int id, String stringtemp, String stringhumi) {
		
		this.stringtemp = stringtemp;
		this.stringhumi = stringhumi;

		convertData();

		
		System.out.println(temp);

		updateData(id, tick, temp, humi, statustemp, statustemp);
		tick++;
	}
	
	void convertData() {
		
		try {
			stringtemp = stringtemp.replace(".", "");	
			temp = Integer.parseInt(stringtemp.substring(0, stringtemp.length() -1));
			statustemp = 0;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Sensorapp failed to convert temperatur!");
			statustemp = 1;
			return;
		}
		
		try {
			stringhumi = stringhumi.replace(".", "");
			humi = Integer.parseInt(stringhumi.substring(0, stringhumi.length() -1));
			statushumi = 0;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Sensorapp failed to convert humdity!");
			statushumi = 1;
			return;
		}
		
	}

}
