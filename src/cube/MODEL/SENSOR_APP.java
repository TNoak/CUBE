package cube.MODEL;

import cube.CONTROLLER.CONTROLLER_MAIN;

public class SENSOR_APP {
	
	MODEL_MAIN model;
	CONTROLLER_MAIN controller;

	public SENSOR_APP(MODEL_MAIN mm) {
		// TODO Auto-generated constructor stub
		model = mm;
		controller = model.getController();
	}

}
