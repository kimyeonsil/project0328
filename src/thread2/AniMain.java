/*
�����͸� ����ؼ� �����̴� �� �ٽ��غ���!
<thread�� �����͸����� ����>
���� : ��������� ���� ����� ����� �� �ִ�.
���� : ���뼺�� ������

 */

package thread2;

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
	Thread thread; //�����͸� ��Ÿ�Ϸ� ����

	public AniMain() {
		
		thread = new Thread(){

			public void run() {
				while(true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					move(); //�����͸��� ��������� �����ϹǷ� move����!
				}
			}		
		};
		
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
				thread.start();
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
