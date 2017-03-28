package file;

import java.io.File;

/*
	자바에서는 디렉터리를 제어하기 위한 클래스가 별도로 존재하지 않는다.
	디렉터리 조차 파일로 간주한다.
	결론 : java.io.File 클래스가 파일 + 디렉터리까지 처리한다.
*/
public class FileTest {

	public static void main(String[] args) {
		//C 드라이브의 하위에 존재하는 모든 디렉터리 및 파일을 출력해보자
		File file = new File("c:/");
		
		//하위 디렉터리 및 파일의 목록 추출
		File[] dir = file.listFiles();
		
		for(int i=0; i<dir.length; i++){
			if(dir[i].isDirectory()){
				System.out.println(dir[i].getName());
			}
		}
 	}

}
