package button;

import java.awt.event.ActionEvent;

public class TestButton extends Button {

	public TestButton(String name) {
		super(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		listener.testPressed();
	}

}
