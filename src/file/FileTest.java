package file;

import java.io.File;

/*
	�ڹٿ����� ���͸��� �����ϱ� ���� Ŭ������ ������ �������� �ʴ´�.
	���͸� ���� ���Ϸ� �����Ѵ�.
	��� : java.io.File Ŭ������ ���� + ���͸����� ó���Ѵ�.
*/
public class FileTest {

	public static void main(String[] args) {
		//C ����̺��� ������ �����ϴ� ��� ���͸� �� ������ ����غ���
		File file = new File("c:/");
		
		//���� ���͸� �� ������ ��� ����
		File[] dir = file.listFiles();
		
		for(int i=0; i<dir.length; i++){
			if(dir[i].isDirectory()){
				System.out.println(dir[i].getName());
			}
		}
 	}

}
