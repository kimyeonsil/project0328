package io;

/*
	FileInoutStream ���� �����ڰ� ���ϴ� ������ ��Ʈ���� ������ �� ������,
	Ű����� ���� ǥ�� �Է� �ϵ������ ��쿣 �ڹٰ� ��Ʈ���� �������� ���ϰ� �ش� OS�� �����ϹǷ�
	�ڹ� �����ڴ� OS�κ��� ǥ�� �Է� ��Ʈ���� ���;� �Ѵ�.

	������ Ŭ���� �� System Ŭ������ static ������� �� ��, has a ����� ������ InputStream �� in ��ü�� �ٷ� ǥ�� �Է� ��Ʈ���� �޾Ƴ��� Ŭ�����̴�.
	���� ���ÿ� �׳� System.in���� �� �� �ִ�.

	���� ��� ��Ʈ�� Ŭ������ �̸� ��Ģ
	�Է� : ~Reader
	��� : ~Writer
*/
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class KeyBoardApp{
	public static void main(String[] args){
		InputStream is = System.in;

		//���ڱ�� ��Ʈ���� �ܵ����� �����ϴ� ���� �ƴ϶�, �̹� ����Ʈ ��� ��Ʈ���� ������ �Ѵ�.
		//���� ������ �������� �μ��� ����Ʈ ��� ��Ʈ���� �ִ´�.
		InputStreamReader reader = null;
		reader = new InputStreamReader(is);

		int data;

		try{
			while(true){
				data = reader.read(); //1byte �о����
				System.out.print((char)data);
			}
		}catch(IOException e){
			System.out.println("��Ʈ���� ���� �� �����ϴ�");
		}
	}
}
