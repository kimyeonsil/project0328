/*
 ���� �ٸ� �׷���, �ӵ�, ��Ÿ ���� ���� ��ü�� �����̰� ����!!
 
 ���� Ʋ�� ������ ���;� �Ѵٰ� �����ϸ�? Thread�� 3���� ���� �Ѵ�.
if�� ���� ���� ����/������ ��������.

------------------------------------------------------------------------------------
sysout(g) �� null�� ���´�. ������..?
 
public void paint(Graphics g) {
	// ���⼭ CircleThread new �ϸ� ������ �ǵ鶧���� ������ ��������Ƿ� ���⼭ �ȵȴ�.
	gp = g;
}
			
�̰�� �����ϴ�. gp�� ���� �޸𸮷� �ö��� �ʾҴٴ� ��,,Ÿ�� ���̿��� ���� �����̴�.
-> 
		// Graphics �������ϹǷ� �ؿ�
		ct = new CircleThread(gp, 0, 0, 50, 50); // g�� ��� ������? ���� �����մ�.
		// �����͸� Ŭ���� �ȿ� ����Ʈ �ȿ� �����ִ�.
		ct.start(); // jvm���� ���� ������.

�� �����ڿ��� ������������ ��ư�� ������ �� �̰� �����ϵ��� �ٲ���!

		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Graphics �������ϹǷ� �ؿ�
				ct = new CircleThread(gp, 0, 0, 50, 50); // g�� ��� ������? ���� �����մ�.
				// �����͸� Ŭ���� �ȿ� ����Ʈ �ȿ� �����ִ�.
				ct.start(); // jvm���� ���� ������.
			}
		});
�̷����ϸ� ������ ��������
------------------------------------------------------------------------------------

//gp = g; ����!
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
	//Graphics gp; // ct�� �����ϱ� ����. ������ �ٸ��� / this�Ƚᵵ �ȴ�.

	CircleThread ct; // ���� �޸𸮿� �ö�;��ϳ� ? ĵ������ �ϼ� �� ������!
	// ���� ĵ������ paint ����..!! paint �ø���!

	public MultiAni() {

		bt = new JButton("���� �����̱�");
		can = new Canvas() {

			public void paint(Graphics g) {
				// ���⼭ CircleThread new �ϸ� ������ �ǵ鶧���� ������ ��������Ƿ� ���⼭ �ȵȴ�.
				//gp = g;
			}
		};

		can.setBackground(Color.pink);
		add(bt, BorderLayout.NORTH);
		add(can);

		bt.addActionListener(new ActionListener() {
			// �̷����ϸ� ������ ��������.
			public void actionPerformed(ActionEvent e) {
				
				//��� ���۳�Ʈ�� �ڱⰡ �Ѱܹ��� �ȷ�Ʈ�� �Ѱܹ޴� �޼��尡 �ִ�.
				Graphics g = can.getGraphics();
				ct = new CircleThread(0, 0, 50, 50, 100, g);
				//�̰͵� ����
				ShapeThread st = ct;
				st.start(); //�츮�� ��ӹ޾����Ƿ� start�� ȣ���� �� �ִ�.
				//ct.start(); �� ����!
				
				/* ���� ������
				// Graphics �������ϹǷ� �ؿ�
				ct = new CircleThread(g, 0, 0, 50, 50); 
				// g�� ��� ������? ���� �����մ�. �����͸� Ŭ���� �ȿ� ����Ʈ �ȿ� �����ִ�.
				ct.start(); // jvm���� ���� ������.
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
