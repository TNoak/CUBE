package cube.VIEW;

import java.awt.Color;
import java.util.Random;

import cube.WIDGETS.BJPanel;
import cube.WIDGETS.CGraph;

public class SENSOR_GRAPH extends BJPanel {

	private int sensortype;
	CGraph graph;

	public SENSOR_GRAPH(int x, int y, int width, int height, int roundness, Color foreground, Color border,
			int sensortype) {
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
		
		int[] i =new int[360];
		for(int x1=0;x1<i.length;x1++) {
			i[x1]=new Random().nextInt(325);
		}
		graph.setData(i);
	}

}
