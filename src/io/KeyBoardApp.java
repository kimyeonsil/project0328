package io;

/*
	FileInoutStream 등은 개발자가 원하는 시점에 스트림을 생성할 수 있지만,
	키보드와 같은 표준 입력 하드웨어의 경우엔 자바가 스트림을 생성하지 못하고 해당 OS가 관리하므로
	자바 개발자는 OS로부터 표준 입력 스트림을 얻어와야 한다.

	지바의 클래스 중 System 클래스의 static 멤버변수 중 즉, has a 관계로 보유한 InputStream 형 in 객체가 바로 표준 입력 스트림을 받아놓은 클래스이다.
	따라서 사용시엔 그냥 System.in으로 쓸 수 있다.

	문자 기반 스트림 클래스의 이름 규칙
	입력 : ~Reader
	출력 : ~Writer
*/
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class KeyBoardApp{
	public static void main(String[] args){
		InputStream is = System.in;

		//문자기반 스트림은 단독으로 존재하는 것이 아니라, 이미 바이트 기반 스트림을 전제로 한다.
		//따라서 생성시 생성자의 인수에 바이트 기반 스트림을 넣는다.
		InputStreamReader reader = null;
		reader = new InputStreamReader(is);

		int data;

		try{
			while(true){
				data = reader.read(); //1byte 읽어들임
				System.out.print((char)data);
			}
		}catch(IOException e){
			System.out.println("스트림을 읽을 수 없습니다");
		}
	}
}
