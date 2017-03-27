/*
 <열기>
 버퍼스트림 : 한줄씩 읽어오는 것 왜쓰나? 속도 향상을 위해서!
 버퍼처리기능도 있으면서 한글도 안깨지는 것은? BufferedReader
 
 BufferedReader(Reader in)  -> Reader 잡아먹을 수 있다.
 
 ------------------------------------------------------------------
<저장>
BufferedReader 쓰다
다른것도 써보자! 	writer2 = new PrintWriter(fos); 깨진다 싶으면 이거쓴다.

ImageIcon 쓰려는데 inteface 
다시 확인해보니 ImageIcon 으로 new가 가능하다.


 */

package io;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoEditor extends JFrame {

	JPanel p_north;
	JButton bt_open, bt_save;
	ImageIcon icon;
	JTextArea area;
	JScrollPane scroll;
	String ori = "C:/java_workspace2/Project0327/res/memo.txt"; // 원본
	String dest = "C:/java_workspace2/Project0327/res/memo_copy.txt"; // 다른 파일의 저장경로
	FileInputStream fis;
	FileOutputStream fos;

	InputStreamReader reader; // 문자기반의 입력스트림!
	BufferedReader buffr; // 버퍼처리된 문자기반 입력스트림-> 선택사항이지만 
	
	//문자기반의 출력스트림
	OutputStreamWriter writer;
	PrintWriter writer2; //문자기반의 출력스트림

	public MemoEditor() {

		p_north = new JPanel();
		icon = new ImageIcon("C:/java_workspace2/Project0327/res/folder_on.png");
		bt_open = new JButton(icon);
		bt_save = new JButton("저장");
		area = new JTextArea();
		scroll = new JScrollPane(area);  

		p_north.add(bt_open);
		p_north.add(bt_save);

		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		bt_open.setBorderPainted(false);
		bt_open.setContentAreaFilled(false);
		bt_open.setFocusPainted(false);
		bt_open.setOpaque(false);
		this.setPreferredSize(new Dimension(10, 10));

		// 버튼 2개 내부익명으로 받기 열기, 저장하기
		bt_open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});

		bt_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});

		setSize(700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// 열기 현재 실행중인
	public void open() {

		try {
			fis = new FileInputStream(ori);
			// 문자기반 스트림에는 문자인코딩 속성을 지정할 수 있다.
			reader = new InputStreamReader(fis, "utf-8"); // fis를 잡아먹자
			buffr = new BufferedReader(reader); //3겹자리 피복이 되었다고 생각하자!

			//int data;
			String data; //더이상 int아니므로
			int count=0; //read의 횟수를 알기위해!

			while (true) {
				// data = fis.read(); ->1byte
				//data = reader.read(); 이제 2byte
				data = buffr.readLine();  //한줄을 읽어드리는데 byte 예상 못하므로 메서드가 필요하다. -> reaLing String으로 반환
				count++;
				//if (data == -1)
				if (data == null) //null일 때 까지로 바뀐다.
					break;
				// append는 String을 원한다 그럼 어떻게? Wrapper클래스 이용!
				// Integer.toString(data)???? 안된다.
				//area.append(Character.toString((char)data)); 
				area.append(data+"\n"); //String으로 반환했으므로 더이상 형변환 필요x but 우리는 줄바꿈 표시해줘야한다.
			} System.out.println("count="+ count); //한줄씩 읽으면 더 줄것이다!

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "파일이 존재하지 않습니다");
			e.printStackTrace(); // 개발자를 위한 로그정보! stack으로 쌓임! 이걸 지우면 에러가 안보임
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 저장하기
	public void save() {
		try{
			//FileOutputStream은 지정한 경로의 파일을 생성해버린다.
			//크기는 0바이트인 empty빈파일
			fos = new FileOutputStream(dest);
			//writer = new OutputStreamWriter(fos, "utf-8");		
			writer2 = new PrintWriter(fos); 
			writer2.write(area.getText());

		} catch(FileNotFoundException e) {
			e.printStackTrace();
			
		/*} catch (UnsupportedEncodingException e) {
			JOptionPane.showMessageDialog(this, "존재하지 않는 파일의 인코딩입니다");
			e.printStackTrace();  PrintWriter 는 이거 쓸필요 없다.*/  
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "입출력시 오류 발생");
			e.printStackTrace();
		} finally{
			//열어놓은 스트림은 전부 닫는 처리
			//명시적으로 하나씩 닫는다. 순서는 중요하지 않지만 바깥부터 닫자.
			if(writer2!=null){
				/*try {
					writer2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}	PrintWriter 는 이거 쓸필요 없다. */	
				writer2.close();
			}
			
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}		
			}
		}
	}

	public static void main(String[] args) {
		new MemoEditor();
	}
}
