/*
 아이콘 생성시 그 크기를 조절하려면 코드가 복잡하므로
 앞으로 재사용가능성을 염두해두고 나만의 재조정 이미지 아이콘을
 새로 정의해본다.
 */

package file;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class MyIcon extends ImageIcon{
	
	//얘가 태어날떄 MyIcon쓰자	
	public MyIcon(URL url, int width, int height) {
		//URL url = this.getClass().getResource("/folder_on.png") 라고 하지 말고
		//내가 태어나면되니까 더이상 new는 없다.
		super(url);

		Image scaledImg = this.getImage();
		//크기를 재조정한 후 결과적으로 이미지 객체를 
		Image result = scaledImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		this.setImage(result);
	}
}
