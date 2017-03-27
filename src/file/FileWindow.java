/*
 클래스는 코드의 재사용때문에 나온 기술이다.
 1. 세팅을 끝내고 제대로 붙는지 확인해보자.
 
 <tip>
  경로를 c 드라이브나 d드라이브에 의존하지 말고 현재 프로젝트 기준으로해서
  접근하는 방법이 있다. -> res 디렉터리를 classpath에 등록함
  java에서 classpath에서 img도 넣을 수 있다.
  res오른쪽버튼 build path -> use
  
 url = Uniformed Resource Locator - 통합된 자원의 위치!
 
 2. 버튼클릭은 어떻게? for문돌려서 해결한다.
 내가 눌렀을 때 for문으로 하나씩 물어본다. 
 눌렀니? 아니요 -> 닫힌 img
 
  */

package file;

import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FileWindow extends JFrame{
	
	MyIcon folder_on, folder_off;
	
	public FileWindow() {
		
		setLayout(new FlowLayout());
		
		//이미지 아이콘을 생성하되 res 폴더로부터	
		folder_on = new MyIcon(this.getClass().getResource("/folder_on.png"),50,50);
		folder_off = new MyIcon(this.getClass().getResource("/folder_off.png"),50,50);
		
/*
 		//URL url = this.getClass().getResource("/folder_on.png") 라고 하지 말고

		Image scaledImg = folder_on.getImage();
		//크기를 재조정한 후 결과적으로 이미지 객체를 
		Image result = scaledImg.getScaledInstance(50, 50, SCALE_SMOOTH);
		folder_on.setImage(result);		
 */

		//제대로 붙는지 테스트해보자.
		ArrayList<String> list = getDirList();
		for(int i=0; i<list.size(); i++){
			String dirName = list.get(i);
			MyPanel mp = new MyPanel(dirName, folder_off);
			add(mp);
		}
	
		setVisible(true);
		setSize(600,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}

	//원하는 경로의 하위 디렉터리 및 파일 구하기
	public ArrayList getDirList() {
		//지금 현재 여기엔 디렉터리랑 파일이 섞여 있다 골라내야함!!
		File file = new File("C:/");
		File[] fileList = file.listFiles();
		
		//배열과 차이점? 크기를 명시하지 않아도 늘어나고 불순물이 섞이지 않음! String만 담을 수 있다.
		ArrayList<String> dirList = new ArrayList<String>(); 
		
		//디렉터리만 골라내자
		for(int i=0; i<fileList.length; i++){
			if(fileList[i].isDirectory()) {
				//디렉터리가 발견될 때마다 dirList에 추가
				dirList.add(fileList[i].getName()); //fileList의 i번째의 디렉터리명을 담자!						
			}	
		}
		return dirList;
	}
	
	public static void main(String[] args) {
		new FileWindow();
		
	}

}
