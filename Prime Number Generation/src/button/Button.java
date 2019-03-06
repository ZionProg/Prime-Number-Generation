package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.ComponentListener;

public class Button extends JButton implements ActionListener {

	protected ComponentListener listener;
	
	public Button(String name) {
		super(name);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setComponentListener(ComponentListener listener) {
		this.listener = listener;
	}

}
