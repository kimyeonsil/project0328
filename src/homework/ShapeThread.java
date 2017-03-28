/*
 원이던 사각형이던 어떤 도형을 표현한 객체이던
 모두 이 클래스의 자식으로 두자.
 왜?? 공통적 특징이 있으므로..!!
 
 
 자식은 이걸 override해서 써야함
 부모가 render 를 정의하는 것이 이상하다.
 어떤 자식이 어떤 그림을 그릴지 모르니까..!!
 추상으로 남겨놓자!
 하나라도 추상메서드 보유하면? 추상클래스가 된다!
 
 */

package homework;

import java.awt.Color;
import java.awt.Graphics;

abstract public class ShapeThread extends Thread {

	int x;
	int y;
	int width;
	int height;
	int interval;
	Graphics g;
	
	//생성자하나 만들어서 초기화 하자
	public ShapeThread(int x, int y, int width, int height, int interval, Graphics g) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.interval=interval;
		this.g=g;
	}

	abstract public void render();

	public void run() {
		while (true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();
		}
	}

}
