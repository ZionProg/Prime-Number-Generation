package assistant;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import display.Display;

public class ListAction implements Runnable {
	private static boolean processing;
	private static boolean stop;
	private Display display;
	private Prime prime;
	private int maxNum;
	private int primesFound;
	private String outPut;
	private long prevTime;
	private long currentTime;
	
	
	public ListAction(Display display,Prime prime,int maxNum) {
		this.display = display;
		this.prime = prime;
		this.maxNum = maxNum;
		this.prevTime = System.currentTimeMillis();
		this.currentTime = 0;
	}
	
	@Override
	public void run() {
		//init
		primesFound = 0;
		if(prime.getLength() < maxNum) {
			prime = new Prime(maxNum, prime);
		}
		prime.reset();
		
		JProgressBar progressBar = display.getSouth().getProgressBar();
		progressBar.setMaximum(maxNum);
		progressBar.setValue(0);
		progressBar.setString("processing");
		
		int primeNum = prime.nextPrime(); // cus of prime.reset() this will always give 2 at first
		++primesFound;
		outPut = ""+ primeNum;
		primeNum = prime.nextPrime();
		//////////////////////////////////////////////////////////
		
		//starting loop
		while(primeNum < maxNum && primeNum != -1 && !stop) {
			outPut += ", " + primeNum;
			++primesFound;
			currentTime = System.currentTimeMillis();
			if((currentTime - prevTime) >100){
				updateDisplay(primeNum);
				prevTime=currentTime;
			}
			primeNum = prime.nextPrime();
		}
		
		updateDisplay(primeNum);
		if(stop) {
			progressBar.setString("process aborted");
		}
		else {
			progressBar.setString("completed");
		}
		
		display.getWest().getList().setText("List");
		stop = false;
		processing = false;
	}
	
	private void updateDisplay(int primeNum) {
		JProgressBar progressBar = display.getSouth().getProgressBar();
		JTextArea primeList = display.getCenter().getPrimesList();
		progressBar.setValue(primeNum);
		progressBar.setString("processing (" + (int)(progressBar.getPercentComplete() * 100) + "%)");
		display.getSouth().getPrimesFoundText().setText("" + primesFound);
		primeList.insert(outPut, primeList.getText().length());
		outPut = "";
	}
	
	public static boolean getProcessing() {
		return processing;
	}


	public static void setProcessing(boolean processing) {
		ListAction.processing = processing;
	}


	public static boolean getStop() {
		return stop;
	}


	public static void setStop(boolean stop) {
		ListAction.stop = stop;
	}
	
}
