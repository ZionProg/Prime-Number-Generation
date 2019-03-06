package button;

import java.awt.event.ActionEvent;

public class ClearButton extends Button {

	public ClearButton(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		listener.clearPressed();
	}

}
