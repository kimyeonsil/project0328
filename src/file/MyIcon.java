package file;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

/*
	������ ������ �� ũ�⸦ �����Ϸ��� �ڵ尡 �����ϹǷ�
	������ ���� ���ɼ��� �����صΰ� ������ ������ �̹��� �������� ���� �����غ���.
*/
public class MyIcon extends ImageIcon {
	public MyIcon(URL url, int width, int height){
		//URL url = this.getClass().getResource("/forder_on.png"); //<<res�� classpath�� �����߱⿡ ������ �� �ִ�.
		
		//�̹��� �������� �����ϵ� ���ҽ� �����κ��� �����Ѵ�.
		//new ImageIcon(this.getClass().getResource("/folder_up.png"));�� ������ ���� �ٲ۴�.
		super(url); //URL(Uniformed Resource Locator : ���յ� �ڿ��� ��ġ) << ���û� �ڿ��� �� ���� ���
				
		Image scaledImg = this.getImage();
		
		//ũ�⸦ �������� �� ��������� �̹��� ��ü�� �ٽ� ��� 
		scaledImg = scaledImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		this.setImage(scaledImg);
	}
}
