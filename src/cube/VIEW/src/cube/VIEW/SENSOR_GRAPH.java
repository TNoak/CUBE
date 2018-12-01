package cube.VIEW;

import java.awt.Color;
import java.util.Random;

import cube.WIDGETS.BJPanel;
import cube.WIDGETS.CGraph;

public class SENSOR_GRAPH extends BJPanel {

	private int sensortype;
	CGraph graph;

	public SENSOR_GRAPH(int x, int y, int width, int height, int roundness, Color foreground, Color border,
			int sensortype,int time) {
		super();
		super.setSize(width, height);
		super.setLocation(x, y);
		super.setForeground(foreground);
		super.setBordercolor(border);
		super.setBordersize(1);
		super.setRoundness(roundness);

		this.sensortype = sensortype;
		
		graph=new CGraph(this.sensortype);
		graph.setSize(super.getWidth()-40,super.getHeight()-40);
		graph.setLocation(20,20);
		super.add(graph);
		
		setTime(time);
	}
	
	
	public void setData(int[] data) {
		graph.setData(data);
	}
	
	public void setTime(int time) {
		graph.setTime(time);
	}

}
