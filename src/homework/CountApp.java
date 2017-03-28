package homework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountApp extends JFrame {
	JLabel lb1;
	JLabel lb2;

	public CountApp() {

		lb1 = new JLabel("0");
		lb2 = new JLabel("0");

		setLayout(new FlowLayout());

		// 알아보기 위해 잠시 색상주자
		lb1.setBackground(Color.PINK);
		lb2.setBackground(Color.pink);

		lb1.setPreferredSize(new Dimension(300, 380));
		lb2.setPreferredSize(new Dimension(300, 380));
		lb1.setFont(new Font("Dotum", Font.BOLD, 75));
		lb2.setFont(new Font("Dotum", Font.BOLD, 75));

		add(lb1);
		add(lb2);

		setSize(700, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 쓰레드 2개 생성
		CountThead ct1 = new CountThead(lb1, 500);
		CountThead ct2 = new CountThead(lb2, 100);

	}

	public static void main(String[] args) {
		new CountApp();
	}
}
