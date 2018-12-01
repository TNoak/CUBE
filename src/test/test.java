package test;


import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class test extends JDialog {
	JLabel l;
	JScrollPane pa;

	public test() {
		Container cb = super.getContentPane();
		super.setBounds(0, 0, 200, 200);
		super.setVisible(true);

		l = new JLabel("bvhdsbvjbavlkabvcj w hvnkbvwbcqbvk�");
		l.setBounds(0, 0, 200, 200);
		l.setVisible(true);
		super.add(l);

		pa = new JScrollPane(l, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		cb.add(l, BorderLayout.CENTER);
		l.add(pa);

		pa.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test();

	}

}
