package file;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
	�г��� �󺧰� ��ư�� ������ �ִ�.
	JPanel has a Label and JButton
*/
public class MyPanel extends JPanel{
	JLabel label;
	JButton btn;
	
	public MyPanel(String title, Icon icon){
		//�г��� �¾ ��, �� ��ǰ�� ���� �¾�� �ϹǷ�, �����ڿ��� �ʱ�ȭ ����
		label = new JLabel(title);
		btn = new JButton(icon);
		
		btn.setFocusPainted(false); //��Ŀ���� ���� ��� ���ֱ�
		btn.setBorderPainted(false); //����Ʈ �׵θ� ���ֱ�
		btn.setOpaque(false); //����
		btn.setContentAreaFilled(false); //����Ʈ ������ �� ä��� ���ֱ�
		
		this.setLayout(new BorderLayout());
		add(label, BorderLayout.NORTH);
		add(btn);
	}
}
