package cube.MODEL;

import cube.CONTROLLER.CONTROLLER_MAIN;

public class MODEL_MAIN {
	
	int sensorcount; //gui unterstützt bis jetzt nur max 10 Sensoren
	
	private CONTROLLER_MAIN controller;
	SENSOR_APP[] sensor_app;
	ARDUINO_COMMUNICATION_APP com_app;

	public MODEL_MAIN(CONTROLLER_MAIN cm, int sensorcount) {
		// TODO Auto-generated constructor stub
		controller = cm;
		this.sensorcount = sensorcount;
		createSensorApps();
		createArduinoCommunicationApp();
		
	}
	
	void createSensorApps() {
		sensor_app = new SENSOR_APP[sensorcount];
		
		for(int i = 0 ; i < sensor_app.length; i++) {
			sensor_app[i] = new SENSOR_APP(i, this);
		}
	}
	
	void createArduinoCommunicationApp() {
		com_app = new ARDUINO_COMMUNICATION_APP();
	}
	
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> GETTER/SETTER

	public CONTROLLER_MAIN getController() {
		return controller;
	}

}
