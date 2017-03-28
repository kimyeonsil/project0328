/*
 서로 다른 그래픽, 속도, 기타 값을 갖는 물체를 움직이게 하자!!
 
 각자 틀린 도형이 나와야 한다고 생각하면? Thread가 3개로 가야 한다.
if문 많이 쓰면 유지/보수가 떨어진다.

------------------------------------------------------------------------------------
sysout(g) 는 null이 나온다. 이유는..?
 
public void paint(Graphics g) {
	// 여기서 CircleThread new 하면 윈도우 건들때마다 여러개 만들어지므로 여기서 안된다.
	gp = g;
}
			
이경우 위험하다. gp가 아직 메모리로 올라가지 않았다는 뜻,,타임 차이에서 나는 오류이다.
-> 
		// Graphics 얻어오야하므로 밑에
		ct = new CircleThread(gp, 0, 0, 50, 50); // g는 어떻게 얻어오지? 꼭꼭 숨어잇다.
		// 내부익명 클래스 안에 페인트 안에 숨겨있다.
		ct.start(); // jvm으로 이제 보내자.

을 생성자에서 생성하지말고 버튼을 눌렀을 때 이걸 생성하도록 바꾸자!

		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Graphics 얻어오야하므로 밑에
				ct = new CircleThread(gp, 0, 0, 50, 50); // g는 어떻게 얻어오지? 꼭꼭 숨어잇다.
				// 내부익명 클래스 안에 페인트 안에 숨겨있다.
				ct.start(); // jvm으로 이제 보내자.
			}
		});
이렇게하면 시점이 늦춰진다
------------------------------------------------------------------------------------

//gp = g; 막자!
 */

package homework;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MultiAni extends JFrame {

	JButton bt;
	Canvas can;
	//Graphics gp; // ct가 못보니까 뺏다. 변수명 다르게 / this안써도 된다.

	CircleThread ct; // 언제 메모리에 올라와야하나 ? 캔버스가 완성 된 다음에!
	// 지금 캔버스에 paint 없다..!! paint 올리자!

	public MultiAni() {

		bt = new JButton("각자 움직이기");
		can = new Canvas() {

			public void paint(Graphics g) {
				// 여기서 CircleThread new 하면 윈도우 건들때마다 여러개 만들어지므로 여기서 안된다.
				//gp = g;
			}
		};

		can.setBackground(Color.pink);
		add(bt, BorderLayout.NORTH);
		add(can);

		bt.addActionListener(new ActionListener() {
			// 이렇게하면 시점이 늦춰진다.
			public void actionPerformed(ActionEvent e) {
				
				//모든 컴퍼넌트는 자기가 넘겨받은 팔레트를 넘겨받는 메서드가 있다.
				Graphics g = can.getGraphics();
				ct = new CircleThread(0, 0, 50, 50, 100, g);
				//이것도 가능
				ShapeThread st = ct;
				st.start(); //우리는 상속받았으므로 start도 호출할 수 있다.
				//ct.start(); 도 가능!
				
				/* 이제 지우자
				// Graphics 얻어오야하므로 밑에
				ct = new CircleThread(g, 0, 0, 50, 50); 
				// g는 어떻게 얻어오지? 꼭꼭 숨어잇다. 내부익명 클래스 안에 페인트 안에 숨겨있다.
				ct.start(); // jvm으로 이제 보내자.
				*/
			}
		});

		setSize(700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new MultiAni();
	}

}
