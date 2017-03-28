/*
 원을 표현한 객체 및 그 움직임
 끝없이 돌아가는 것이 run이고!
 써클은 자체적으로 run메소드가 render를 호출하면 된다. - >무한루프돌리자
 
	public void render(Graphics g) {
		g.drawOval(x, y, width, height);
	}

	public void run() {
	}
	
이상태에서 render() 불가능! render는 Graphics g 를 필요로하는데..
run이 돌때 이미 Graphics g 얻어놔야 한다... -> 모두가 쓸 수 있도록 위로 올려야한다.

-------------------------------------------------------------------------------------
근데이거 너무 속상,,,네모 만들려면 또 이 클래스 만들어야함???
최상위클래스 만들자!!
이제 부모가 ShaprThread가 된다.
상속받으려면 코드중복부터 찾아서 없애자.


 */
package homework;

import java.awt.Color;
import java.awt.Graphics;

public class CircleThread extends ShapeThread {
	
	/*이제 지우자
	x,y,width,height의 생성은 누군가가 호출할때!
	 
	int x;
	int y;
	int width;
	int height;
	Graphics g;
	*/

	public CircleThread(int x, int y, int width, int height, int interval, Graphics g) {
		super(x, y, width, height, interval, g);

		/* 이제 지우자
		this.g = g;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		*/
	}
	
	//이게 바로 override 이자 upgrade - 부모가 가지고 있는데 자식이 다시 재정의한다.
	public void render() {
		System.out.println(g);
		//노란색 페인트로 윈도우에 적용하고
		g.setColor(Color.pink);
		g.fillRect(0, 0, 700, 600); 
				
		//아래쪽에 그리자	
		x+=5;
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);
	}

	/* 이제 지우자 run필요 x..
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();
		}
	} */

}
