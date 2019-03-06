package display;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import layout_section.Center;
import layout_section.South;
import layout_section.West;
import main.ComponentListener;

public class Display {
	public static final Dimension frameDim = new Dimension(600, 400);
	private final JFrame frame;
	private final JPanel panel;
	private final Center center;
	private final West west;
	private final South south;

	public Display() {
		frame = new JFrame("Prime Number Generation");
		panel = new JPanel(new BorderLayout());
		buildFrame();
		addToFrame(panel);
		//Center-------------------------------------------------------------------------------------
		center = new Center();
		addToPanel(center.getPrimesScroll(),BorderLayout.CENTER);
		//West---------------------------------------------------------------------------------------
		west = new West();
		addToPanel(west.getWestPanel(),BorderLayout.WEST);
		//South--------------------------------------------------------------------------------------
		south = new South();
		addToPanel(south.getSouthPanel(), BorderLayout.SOUTH);
		frame.setVisible(true);
	}

	private void buildFrame() {
		frame.setMinimumSize(frameDim);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addToFrame(Component c) {
		frame.add(c);
	}

	public void addToPanel(Component c) {
		panel.add(c);
	}
	public void addToPanel(Component c,String postionOnPanel) {
		panel.add(c,postionOnPanel);
	}
	
	public void setComponentListener(ComponentListener listener) {
		west.getTest().setComponentListener(listener);
		west.getList().setComponentListener(listener);
		west.getClear().setComponentListener(listener);
	}

	public JFrame getFrame() {
		return frame;
	}

	public JPanel getPanel() {
		return panel;
	}

	public Center getCenter() {
		return center;
	}

	public West getWest() {
		return west;
	}

	public South getSouth() {
		return south;
	}
	
	
}
