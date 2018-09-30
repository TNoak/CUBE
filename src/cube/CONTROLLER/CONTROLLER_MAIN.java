package cube.CONTROLLER;

import cube.MODEL.MODEL_MAIN;

public class CONTROLLER_MAIN {

	MODEL_MAIN model;
	//GUI_MAIN gui;

	public CONTROLLER_MAIN() {
		// TODO Auto-generated constructor stub
		//gui = new GUI_MAIN(model);
		model = new MODEL_MAIN(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CONTROLLER_MAIN();
	}

}
