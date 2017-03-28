package homework;

import javax.swing.JLabel;

public class CountThead extends Thread{
	JLabel lb;
	int interval;
	int count;
	
	public CountThead(JLabel lb, int interval){
		this.lb=lb;
		this.interval=interval;
		
		this.start();
	}
	
	public void run() {
		// 특정 라벨의 값을 1씩 증가시키되, 지정한 속도대로..
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			lb.setText(Integer.toString(count));
		}
	}

}
