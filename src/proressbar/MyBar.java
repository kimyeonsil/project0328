package proressbar;

import javax.swing.JProgressBar;

public class MyBar extends Thread {
	JProgressBar bar;
	int count;
	int interval;
	
	public MyBar(JProgressBar bar, int interval){
		this.bar=bar;
		this.interval=interval;
		
		start();
	}
	public void run(){
		while(true){
			try{
				Thread.sleep(interval);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			count++;
			bar.setValue(count);
		}
		
		
	}
}
