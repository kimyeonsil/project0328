/*
 ���ÿ� �����ϰ� ���� �ڵ�� �����ڰ� �����ؾ� �ϱ� ������ �����带 �������ؾ� �Ѵ�.
 �׳� run�� �ϰ���� �� �ϸ� �ȴ�.
 
 */

package thread;

public class MyThread extends Thread{
	/*
	 �����ڴ� ���������� �����ϰ� ���� �ڵ带 �����忡 run �޼��� �ȿ� �ڵ��ϸ� �ȴ�.
	 run���� ctrl+space bar�ϸ� ���� */
	
	@Override
	public void run() {
		//��� ����
		//�츮�����嵵 ��ǥ�ϳ� ��� �극�̽� �����ϱ� �׾���ȴ�.
		//��ǥ ������ ��� ������? } ������ �ȵȴ�. ���ѹݺ� �ʿ�! -> while
		while(true){ //�̷����ϸ� ������ ���� �ױ� ������ sleep���� ���ٿ������
			
			try {
				Thread.sleep(1000); //1�ʽ��ٿ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("��");			
		}
	}

}
