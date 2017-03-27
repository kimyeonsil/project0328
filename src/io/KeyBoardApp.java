/*
FileInputStream 등은 개발자가 원하는 시점에 스트림을 생성할 수 있지만
키보드와 같은 표준 입력 하드웨어의 경우엔 자바가 스트림을 생성하지 못하고
해당 OS가 관리하므로 자바 개발자는 OS로부터 표준입력 스트림을 얻어와야 한다.

자바의 클래스 중 System클래스의 static 멤버변수 중 
즉 has a 관계로 보유한 InputStream형 in객체가 바로 표준입력스트림을 받아놓은 클래스이다.
따라서 사용시엔 System.in;

문자기반 스트림 클래스의 이름 규칙
입력 : ~~Reader
출력 : ~~Writer
Reader/Writer 붙으면 안깨진다!
*/
package io;

import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class KeyBoardApp{


	public static void main(String[] args) {
		InputStream is = System.in;

		//문자기반 스트림은 단독으로 존재하는 것이 아니라
		//이미 Byte 기반 스트림을 전제로 한다. 따라서 생성시 생성자의
		//인수에 바이트 기반 스트림을 넣는다.

		InputStreamReader reader=null;
		reader = new InputStreamReader(is);
		
		int data;
		try{
			while(true) {
				//data = is.read(); //1. 1byte읽어들임 -> 한글은 깨짐
				data = reader.read();// 2. 이제 2byte읽을 수 있다.

				//System.out.print((char)data); 1.이렇게하면 a만뜬다. 1byte씩읽으므로 엔터랑 커서는 안나옴 -> while문필요!
				//System.out.print((char)data);  1.라고하면 문자로 나옴! 13과 10은 어디가고 a가 나오나요?
				//13은 기능을 담당하므로 표현이 안됨,,!!그치만 효과는 나고있다.
				//System.out.print(data); 2. 이제 reader.raad로하면 글씨 읽기 가능!! 2byte씩 읽을수 있으므로
				System.out.print((char)data); //2. 국은 제대로 나오지만 13,14등 나머지는 나오지x
			}

		} catch(IOException e) {
			
		}


		


	}

}
