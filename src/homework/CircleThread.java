/*
 ���� ǥ���� ��ü �� �� ������
 ������ ���ư��� ���� run�̰�!
 ��Ŭ�� ��ü������ run�޼ҵ尡 render�� ȣ���ϸ� �ȴ�. - >���ѷ���������
 
	public void render(Graphics g) {
		g.drawOval(x, y, width, height);
	}

	public void run() {
	}
	
�̻��¿��� render() �Ұ���! render�� Graphics g �� �ʿ���ϴµ�..
run�� ���� �̹� Graphics g ������ �Ѵ�... -> ��ΰ� �� �� �ֵ��� ���� �÷����Ѵ�.

-------------------------------------------------------------------------------------
�ٵ��̰� �ʹ� �ӻ�,,,�׸� ������� �� �� Ŭ���� ��������???
�ֻ���Ŭ���� ������!!
���� �θ� ShaprThread�� �ȴ�.
��ӹ������� �ڵ��ߺ����� ã�Ƽ� ������.


 */
package homework;

import java.awt.Color;
import java.awt.Graphics;

public class CircleThread extends ShapeThread {
	
	/*���� ������
	x,y,width,height�� ������ �������� ȣ���Ҷ�!
	 
	int x;
	int y;
	int width;
	int height;
	Graphics g;
	*/

	public CircleThread(int x, int y, int width, int height, int interval, Graphics g) {
		super(x, y, width, height, interval, g);

		/* ���� ������
		this.g = g;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		*/
	}
	
	//�̰� �ٷ� override ���� upgrade - �θ� ������ �ִµ� �ڽ��� �ٽ� �������Ѵ�.
	public void render() {
		System.out.println(g);
		//����� ����Ʈ�� �����쿡 �����ϰ�
		g.setColor(Color.pink);
		g.fillRect(0, 0, 700, 600); 
				
		//�Ʒ��ʿ� �׸���	
		x+=5;
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);
	}

	/* ���� ������ run�ʿ� x..
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
