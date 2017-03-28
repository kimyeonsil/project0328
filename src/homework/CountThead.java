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
		// Ư�� ���� ���� 1�� ������Ű��, ������ �ӵ����..
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
