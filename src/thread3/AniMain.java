/*
 개발자가 쓰레드를 상속하여 개발할 수 있으나
 이미 다른 클래스의 작일 경우, 상속은 불가하다
 이럴 때 사용할 수 있는 객체가 바로 Runaable 인터페이스이다!
 
public Thread(Runnable target)
여기서 Runnable 은 this에 있는거 호출
내가 누군가의 자식일 때 Runanable을 사용해서 호출할 수 있다.

 <thread를 Runnable로 쓰면>
장점 : 내가 이미 남의 자식이면 쓰레드 상속이 불가능하므로 쓰레드 상속 피할 수 있다.
	run이 같은 클래스에 있으니 멤버변수 마음대로 쓸 수 있다.
단점 : 

 */

package thread3;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AniMain extends JFrame implements Runnable {
	
	JButton bt;
	Canvas can;
	int x=0;
	int y=0;
	AniMain aniMain;
	Thread thread; //내부익명 스타일로 개발

	public AniMain() {
		
		//Runnable인 객체를 인수로 넘긴다.
		//그러면 run 메서드의 호출은 Runnable을 
		//재정의한 객체의 run을 호출한다.
		thread = new Thread(this);
		
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
	
	//기존에 run 생성했떤거 여기로 가져온다.
	public void run() {
		{
				while(true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					move(); //내부익명은 멤버접근이 가능하므로 move가능!
				}
		}
	}

	public static void main(String[] args) {
		new AniMain();
	}



}
