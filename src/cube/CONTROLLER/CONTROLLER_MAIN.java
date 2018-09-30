package cube.CONTROLLER;

import cube.MODEL.MODEL_MAIN;
import cube.VIEW.GUI_MAIN;

public class CONTROLLER_MAIN {

	MODEL_MAIN model;
	GUI_MAIN gui;

	public CONTROLLER_MAIN() {
		// TODO Auto-generated constructor stub
		model = new MODEL_MAIN(this);
		gui = new GUI_MAIN(10);
		gui.senm[0].updateData();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CONTROLLER_MAIN();
	}

}
