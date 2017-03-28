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
	
	InputStreamReader reader; //���ڱ�� �Է� ��Ʈ��
	BufferedReader buffr; //���� ó���� ���ڱ�� �Է� ��Ʈ�� (���û����̳� �ѱ۾ȱ����� �ϰ� �������� �� ������ ����ϴ� ���� ����)
	
	OutputStreamWriter writer; //���ڱ�� ��� ��Ʈ��
	PrintWriter writer2; //���ڱ�� ��� ��Ʈ��
	
	String ori = "C:/java_eclipse_workspace/Project0327/res/memo.txt"; //���� ���
	String dest = "C:/java_eclipse_workspace/Project0327/res/memo_copy.txt";; //�ٸ� ������ ���� ���
	
	public MemoEditor(){
		p_north = new JPanel();
		
		icon = new ImageIcon("C:/java_eclipse_workspace/Project0327/res/folder_up.png");
		
		bt_open = new JButton(icon);
		
		bt_open.setBorderPainted(false); //�ٱ� �׵θ� ����
		bt_open.setContentAreaFilled(false); //��� ���� ����
		bt_open.setFocusPainted(false);//���� �׵θ� ����
		bt_open.setOpaque(false); //������ ����
		
		bt_save = new JButton("����");
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
	
	//����
	private void open(){
		try {
			fis = new FileInputStream(ori);
			//���� ��� ��Ʈ������ ���� ���ڵ� �Ӽ��� ������ �� �ִ�.
			reader = new InputStreamReader(fis, "utf-8");
			buffr = new BufferedReader(reader);
			//�� 3���� ��Ʈ�� ���븦 ���׷��̵�!!!!!
			
			//int data;
			String data;
			int count = 0; //read Ƚ���� �˱� ����
			
			while(true){
				data = buffr.readLine(); //fis.read() = 1byte �о����, reader.read() = 2byte �о����, buffr.readLine() = �� �پ� ����
				count++;
				
				if(data == null){ //data�� String �� ��ü�̹Ƿ� null�̸� �о���� ��ü�� ������ �ǹ�
					break;
				}
				System.out.println(count);
				
				//area.append(Character.toString((char)data));
				area.append(data+"\n"); //�� �� �а� �ٹٲٱ⸦ ����� ��
			}
		} catch (FileNotFoundException e) {
			//FileNotFoundException ��ü�� ������ �ִ� printStackTrace() �޼ҵ� ȣ��
			//������ ���� ���̴� ������ ���
			JOptionPane.showMessageDialog(this, "������ �������� �ʽ��ϴ�"); //<<�� ������ ����ڸ� ���� �����̴�.
			e.printStackTrace(); //�� ������ ���ٸ� ������ ������ �� �� ����. << �� ������ �����ڸ� ���� �α� �����̴�.
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//����
	private void save(){
		try {
			//FileOutputStream�� ������ ����� ������ �����ع����� (ũ��� 0����Ʈ�� empty ����, ���� ���� ������ �ִٸ� ������ ��������)
			fos = new FileOutputStream(dest);
			//writer = new OutputStreamWriter(fos, "utf-8");
			writer2 = new PrintWriter(fos);
			writer2.write(area.getText()); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} /*catch (UnsupportedEncodingException e) {
			//���ڵ��� �߸� �������� ��� �߻��ϴ� �ͼ���
			e.printStackTrace();
		}*/ catch (IOException e) {
			e.printStackTrace();
		} finally{
			//��Ʈ���� �ݾ����� ������ ������ �����ǳ� ���� ������� �ʴ´�.
			//��Ʈ���� ��������� �ϳ��� �ݾ��ִ� ���� ����.
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
