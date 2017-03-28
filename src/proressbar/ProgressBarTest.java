package proressbar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBarTest extends JFrame {

	JProgressBar[] bar = new JProgressBar[3];
	MyBar[] mb = new MyBar[3];
	JButton bt;
	JButton bt1;
	JButton bt2;
	int count;
	int[] interval = { 100, 500, 1000 };

	public ProgressBarTest() {
		setLayout(new FlowLayout());

		for (int i = 0; i < bar.length; i++) {
			bar[i] = new JProgressBar();
			mb[i] = new MyBar(bar[i], interval[i]);
			bar[i].setPreferredSize(new Dimension(400, 40));
			add(bar[i]);

		}

		bt = new JButton("작동");
		bt1 = new JButton("열기");
		bt2 = new JButton("저장");
		// bar.setPreferredSize(new Dimension(450, 40));

		// add(bar);

		add(bt);
		add(bt1);
		add(bt2);

		setLayout(new FlowLayout());

		// this.add(bt,BorderLayout.SOUTH);
		// this.add(bt1,BorderLayout.WEST);
		// this.add(bt2,BorderLayout.WEST);

		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		// setBackground(Color.PINK);
		setSize(500, 150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ProgressBarTest();
	}
}
