package io;

import java.awt.BorderLayout;
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
	
	FileInputStream fis;
	FileOutputStream fos;
	
	InputStreamReader reader; //문자기반 입력 스트림
	BufferedReader buffr; //버퍼 처리된 문자기반 입력 스트림 (선택사항이나 한글안깨져야 하고 엔터쳤을 때 보낼때 사용하는 것이 좋음)
	
	OutputStreamWriter writer; //문자기반 출력 스트림
	PrintWriter writer2; //문자기반 출력 스트림
	
	String ori = "C:/java_eclipse_workspace/Project0327/res/memo.txt"; //원본 경로
	String dest = "C:/java_eclipse_workspace/Project0327/res/memo_copy.txt";; //다른 파일의 저장 경로
	
	public MemoEditor(){
		p_north = new JPanel();
		
		icon = new ImageIcon("C:/java_eclipse_workspace/Project0327/res/folder_up.png");
		
		bt_open = new JButton(icon);
		
		bt_open.setBorderPainted(false); //바깥 테두리 생략
		bt_open.setContentAreaFilled(false); //배경 색상 생략
		bt_open.setFocusPainted(false);//안쪽 테두리 생략
		bt_open.setOpaque(false); //불투명 생략
		
		bt_save = new JButton("저장");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		p_north.add(bt_open);
		p_north.add(bt_save);
		
		bt_open.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				open();	
			}
		});
		
		bt_save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					save();
			}
		});
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		setBounds(100, 100, 700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	//열기
	private void open(){
		try {
			fis = new FileInputStream(ori);
			//문자 기반 스트림에는 문자 인코딩 속성을 지정할 수 있다.
			reader = new InputStreamReader(fis, "utf-8");
			buffr = new BufferedReader(reader);
			//총 3번의 스트림 빨대를 업그레이드!!!!!
			
			//int data;
			String data;
			int count = 0; //read 횟수를 알기 위해
			
			while(true){
				data = buffr.readLine(); //fis.read() = 1byte 읽어들임, reader.read() = 2byte 읽어들임, buffr.readLine() = 한 줄씩 읽음
				count++;
				
				if(data == null){ //data가 String 즉 객체이므로 null이면 읽어들인 객체가 없음을 의미
					break;
				}
				System.out.println(count);
				
				//area.append(Character.toString((char)data));
				area.append(data+"\n"); //한 줄 읽고 줄바꾸기를 해줘야 함
			}
		} catch (FileNotFoundException e) {
			//FileNotFoundException 객체가 가지고 있는 printStackTrace() 메소드 호출
			//에러가 위로 쌓이는 구조로 출력
			JOptionPane.showMessageDialog(this, "파일이 존재하지 않습니다"); //<<이 구문은 사용자를 위한 정보이다.
			e.printStackTrace(); //이 구문이 없다면 에러를 눈으로 볼 수 없다. << 이 구문은 개발자를 위한 로그 정보이다.
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//저장
	private void save(){
		try {
			//FileOutputStream은 지정한 경로의 파일을 생성해버린다 (크기는 0바이트인 empty 파일, 따라서 기존 파일이 있다면 파일을 날려버림)
			fos = new FileOutputStream(dest);
			//writer = new OutputStreamWriter(fos, "utf-8");
			writer2 = new PrintWriter(fos);
			writer2.write(area.getText()); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} /*catch (UnsupportedEncodingException e) {
			//인코딩을 잘못 기재했을 경우 발생하는 익셉션
			e.printStackTrace();
		}*/ catch (IOException e) {
			e.printStackTrace();
		} finally{
			//스트림을 닫아주지 않으면 파일은 생성되나 글이 저장되지 않는다.
			//스트림은 명시적으로 하나씩 닫아주는 것이 좋다.
			if(writer2 != null){
				writer2.close();
			}
			if(fos != null){
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
