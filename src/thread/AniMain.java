/*
 1. �������ϱ�
 2. �����͸����� ���� -> �����̰�
 3. ���� �����带 �����غ���
 - �̹� ���� JFrame�� �ڽ�extends�����Ƿ� run�������´�. MoveThread ������
 4. ���������� ����
 5. ���⼭ ���������� Ȱ������
 
 <thread�� .java�� ����?>
���� : ���뼺�� ����. ex) �Ѿ��̶��? �Ѿ��� �������̷�  new�ϸ� ���� �����δ�.
���� : ���۷����� �Ѱܾ��ϱ� ������ �ణ ����������.


 */

package thread;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AniMain extends JFrame {
	
	JButton bt;
	Canvas can;
	int x=0;
	int y=0;
	AniMain aniMain;
	MoveThread mt;
	
	public AniMain() {
		aniMain = this;
		
		bt = new JButton("��ü�̵�");
		add(bt,BorderLayout.NORTH);
		
		can = new Canvas(){
			public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);
			}
		};

		can.setBackground(Color.pink);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mt = new MoveThread(aniMain); 
				//�̷����ϸ� this�� �����͸� Ŭ������ ���,,��� �ذ�����?
				//���� �ִϸ��̼��� ���۷��� �޾ƿ;���
				//AniMain���� �޾ƿ;��ϹǷ� ��������.
				
				/*
				 �Ǵٸ� ����������Ѵ�.
				 mt = new MoveThread(AniMain.this);�� ������. 
				 */
				mt.start();
			}
		});
		
		add(can);
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void move(){
		x+=5;
		can.repaint();
	}

	public static void main(String[] args) {
		new AniMain();
	}

}
