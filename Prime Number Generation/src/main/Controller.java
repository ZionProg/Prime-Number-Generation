package main;

import javax.swing.JTextArea;

import assistant.ListAction;
import assistant.Prime;
import display.Display;

public class Controller implements ComponentListener {

	private final Display display;
	private final Prime assistant;
	
	public Controller() {
		display = new Display();
		display.setComponentListener(this);
		assistant = new Prime();	
	}	

	@Override
	public void testPressed() {
		if(!display.getSouth().getInputText().getText().isEmpty()) {
			int num = Integer.parseInt(display.getSouth().getInputText().getText());
			boolean prime = assistant.test(num);
			String isPrime = prime ? " is prime" : " is not prime";
			JTextArea outPut = display.getCenter().getPrimesList();
			outPut.insert(num + isPrime, outPut.getText().length());
			outPut.insert("\n", outPut.getText().length());
			isPrime = prime ? "1" : "0";
			display.getSouth().getPrimesFoundText().setText(isPrime);
		}	
	}


	@Override
	public void listPressed() {
		Thread listThread = null;
		if(!ListAction.getProcessing()) {
			ListAction.setProcessing(true);
			ListAction.setStop(false);
			clearPressed();
			int maxNum = Integer.parseInt(display.getSouth().getInputText().getText());
			listThread = new Thread(new ListAction(display,assistant,maxNum));
			listThread.start();
			display.getWest().getList().setText("Stop");
		}
		
		else {
			ListAction.setProcessing(false);
			ListAction.setStop(true);
			display.getWest().getList().setText("List");
		}
	}


	@Override
	public void clearPressed() {
		display.getCenter().getPrimesList().setText("");
		display.getSouth().getPrimesFoundText().setText("0");
	}
	
}
