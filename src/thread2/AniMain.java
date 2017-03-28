/*
내부익명 사용해서 움직이는 것 다시해보기!
<thread를 내부익명으로 가면>
장점 : 멤버변수를 내가 맘대로 사용할 수 있다.
단점 : 재사용성이 떨어짐

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
	Thread thread; //내부익명 스타일로 개발

	public AniMain() {
		
		thread = new Thread(){

			public void run() {
				while(true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					move(); //내부익명은 멤버접근이 가능하므로 move가능!
				}
			}		
		};
		
		bt = new JButton("물체이동");
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
