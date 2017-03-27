/*
java에는 디렉터리를 제어하기 위한 클래스가 별도로 존재하지 않고,
디렉터리도 파일로 간주한다.
결론 : java.io.File 클래스가 파일+디렉터리까지 처리

하나의 패널에 묶은 것!
내가 누른것만 펼쳐지도록 다른 건 닫히고 전체는 flowLayout
각각은 패널로 for문 돌리기!

fileExplorer

 */
package file;
import java.io.File;

public class FileTest {	
	public static void main(String[] args) {
		//C드라이브의 하위에 존재하는 모든 디렉터리 및 파일을 출력해보자!!
		
		File file = new File("C:/");
		
		//하위 디렉토리 및 파일을 목록 추출
		//String[] dir = file.list(); 디렉터리 명단만 받는것이로
		File[] dir = file.listFiles(); 
		
		for(int i=0; i<dir.length; i++) {
			if(dir[i].isDirectory()){
				System.out.println(dir[i].getName());
			}	
		}
	}
}
