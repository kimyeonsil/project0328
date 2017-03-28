package file;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
	패널이 라벨과 버튼을 가지고 있다.
	JPanel has a Label and JButton
*/
public class MyPanel extends JPanel{
	JLabel label;
	JButton btn;
	
	public MyPanel(String title, Icon icon){
		//패널이 태어날 때, 그 부품도 같이 태어나야 하므로, 생성자에서 초기화 하자
		label = new JLabel(title);
		btn = new JButton(icon);
		
		btn.setFocusPainted(false); //포커스에 의한 경계 없애기
		btn.setBorderPainted(false); //컨텐트 테두리 없애기
		btn.setOpaque(false); //투명
		btn.setContentAreaFilled(false); //컨텐트 영역의 색 채우기 없애기
		
		this.setLayout(new BorderLayout());
		add(label, BorderLayout.NORTH);
		add(btn);
	}
}
