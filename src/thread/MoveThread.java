/*
 �����忡�� ������ ������ ��� �� ������ ������!
 */

package thread;

public class MoveThread extends Thread {

	// �޾ƿ;��Ѵ� = �޼��带 �ǹ��Ѵ�. �̰� ���������� �Ϲݸ޼��������� ����غ���?
	// ������ ������ �������� MoveThread new�Ҳ��ϱ� ����Ŭ������ �����ڷ� ������ ���� ���?
	AniMain aniMain;

	public MoveThread(AniMain aniMain) {
		this.aniMain = aniMain;
	}

	// �����ڴ� ���� ������ �ڵ带 run�� �����ض�
	// �׷� jvm�� ��run�� �˾Ƽ� ȣ�����ش�.
	public void run() {
		// ������ �ʰ� ȣ���ؾ� �Ѵ�. AniMain�� move�� �����;��Ѵ�.
		while(true){ //�̷����ϸ� �ʹ��� �������Ƽ� �ΰ��� ������ �� ���� ����. �ް������� �Ѵ�.
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			aniMain.move();			
		}

	}

}
