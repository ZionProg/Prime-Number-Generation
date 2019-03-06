package layout_section;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

import button.Button;
import button.ClearButton;
import button.ListButton;
import button.TestButton;

public class West {
	private JPanel westPanel;
	private Button test;
	private Button list;
	private Button clear;

	public West() {
		westPanel = new JPanel(new GridLayout(10, 1));
		test = new TestButton("Test");
		list = new ListButton("List");
		clear = new ClearButton("Clear");
		test.addActionListener(test);
		list.addActionListener(list);
		clear.addActionListener(clear);
		addToPanel(test);
		addToPanel(list);
		addToPanel(clear);
	}
	
	private void addToPanel(Component c) {
		westPanel.add(c);
	}
	
	public JPanel getWestPanel() {
		return westPanel;
	}

	public Button getTest() {
		return test;
	}

	public Button getList() {
		return list;
	}

	public Button getClear() {
		return clear;
	}
	
	
}
