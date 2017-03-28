package file;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

/*
	아이콘 생성시 그 크기를 조정하려면 코드가 복잡하므로
	앞으로 재사용 가능성을 염두해두고 나만의 재조정 이미지 아이콘을 새로 정의해본다.
*/
public class MyIcon extends ImageIcon {
	public MyIcon(URL url, int width, int height){
		//URL url = this.getClass().getResource("/forder_on.png"); //<<res를 classpath로 지정했기에 가져올 수 있다.
		
		//이미지 아이콘을 생성하되 리소스 폴더로부터 생성한다.
		//new ImageIcon(this.getClass().getResource("/folder_up.png"));를 다음과 같이 바꾼다.
		super(url); //URL(Uniformed Resource Locator : 통합된 자원의 위치) << 로컬상 자원을 쓸 때도 사용
				
		Image scaledImg = this.getImage();
		
		//크기를 재조정한 후 결과적으로 이미지 객체를 다시 등록 
		scaledImg = scaledImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		this.setImage(scaledImg);
	}
}
