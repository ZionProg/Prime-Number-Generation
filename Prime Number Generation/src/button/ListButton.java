package button;

import java.awt.event.ActionEvent;

public class ListButton extends Button {

	public ListButton(String name) {
		super(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		listener.listPressed();
	}
	
	
}
