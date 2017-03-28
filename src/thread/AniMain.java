/*
 1. 디자인하기
 2. 내부익명으로 가자 -> 움직이게
 3. 이제 쓰레드를 적용해보자
 - 이미 나는 JFrame의 자식extends했으므로 run못가져온다. MoveThread 만들자
 4. 동생쓰레드 만듬
 5. 여기서 동생쓰레드 활용하자
 
 <thread를 .java로 빼면?>
장점 : 재사용성이 높다. ex) 총알이라면? 총알을 마구잡이로  new하면 각자 움직인다.
단점 : 레퍼런스를 넘겨야하기 때문에 약간 귀찮아진다.


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
				mt = new MoveThread(aniMain); 
				//이렇게하면 this는 내부익명 클래스의 상수,,어떻게 해결할지?
				//기존 애니메이션의 레퍼런스 받아와야함
				//AniMain형을 받아와야하므로 선언하자.
				
				/*
				 또다른 방법도존재한다.
				 mt = new MoveThread(AniMain.this);도 먹힌다. 
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
