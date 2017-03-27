/*
 패널이 라벨과 버튼을 가지고 있다.
 Jpanel has Label & Button.
 
 라벨과 버튼이 생성되야함
 */

package file;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	JLabel la;
	JButton bt;

	// 패널이 태어날 때 그 부품도 같이 태어나야 하므로 생성자에서 초기화하자, 라벨의 이름도 넘겨받자
	public MyPanel(String title, ImageIcon icon) {
		la = new JLabel(title);
		bt = new JButton(icon);

		bt.setBorderPainted(false); // 버튼의 경계선 없애기
		bt.setContentAreaFilled(false); // 컨텐트 영역에 색채우기 없음
		bt.setFocusPainted(false); // 포커스에 의한 경계없애기
		bt.setOpaque(false);// 불투명한것

		setLayout(new BorderLayout());
		add(la, BorderLayout.NORTH);
		add(bt, BorderLayout.CENTER);
	}
}
