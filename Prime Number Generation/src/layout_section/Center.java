package layout_section;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Center {
	private JTextArea primesList;
	private JScrollPane primesScroll;
	
	public Center() {
		primesList = new JTextArea();
		primesScroll = new JScrollPane(primesList,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		buildTextArea();
	}
	
	private void buildTextArea() {
		primesList.setEditable(true);
		primesList.setLineWrap(true);
		primesList.setWrapStyleWord(false);
	}

	public JTextArea getPrimesList() {
		return primesList;
	}	
	
	public JScrollPane getPrimesScroll() {
		return primesScroll;
	}
}
