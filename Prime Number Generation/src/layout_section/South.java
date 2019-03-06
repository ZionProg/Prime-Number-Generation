package layout_section;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class South {
	private JPanel southPanel;
	private JLabel inputLabel;
	private JLabel primesFoundLabel;
	private JTextField inputText;
	private JTextField primesFoundText;
	private JProgressBar progressBar;
	
	public South() {
		southPanel = new JPanel();
		inputLabel = new JLabel("Input");
		primesFoundLabel = new JLabel("Primes Found");
		inputText = new JTextField(10); // 10 columns
		primesFoundText = new JTextField(10);
		progressBar = new JProgressBar();
		//init
		progressBar.setString("Waiting");
		progressBar.setStringPainted(true);
		primesFoundText.setEditable(false);
		//addToSouthPanel
		addToPanel(inputLabel);
		addToPanel(inputText);
		addToPanel(progressBar);
		addToPanel(primesFoundLabel);
		addToPanel(primesFoundText);
	}
	
	private void addToPanel(Component c) {
		southPanel.add(c);
	}
	
	public JPanel getSouthPanel() {
		return southPanel;
	}
	
	public JTextField getInputText() {
		return inputText;
	}
	
	public JTextField getPrimesFoundText() {
		return primesFoundText;
	}
	
	public JProgressBar getProgressBar() {
		return progressBar;
	}
}
