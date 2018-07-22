package cube;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MAIN extends JPanel implements ActionListener{

	CBar bar;
	CPanel panel;
	CButton button;

	public MAIN() {
		// TODO Auto-generated constructor stub
		bar = new CBar(300, 300, 800, 100, 90, new Color(5, 214, 165));
		this.add(bar);
		bar.setLevel(75);

		panel = new CPanel(600, 600, 400, 300, 90, new Color(5, 214, 165), new Color(100, 100, 165));
		this.add(panel);
		
		button = new CButton(1400, 400, 200, 100, 90, new Color(5, 214, 165));
		this.add(button);
		button.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();

		frame.setSize(600, 300);
		frame.setVisible(true);
		frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

		MAIN testpanel = new MAIN();
		testpanel.setSize(frame.getSize());
		testpanel.setBackground(new Color(33, 32, 49));
		frame.add(testpanel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() ==  button) {
			System.out.println("Why is this not working correct");
		}
		System.out.println("lol");
		
	}

}
