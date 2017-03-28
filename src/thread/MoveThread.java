/*
 쓰레드에서 움직임 로직을 담게 될 쓰레드 만들자!
 */

package thread;

public class MoveThread extends Thread {

	// 받아와야한다 = 메서드를 의미한다. 이게 생성자일지 일반메서드일지는 고민해본다?
	// 지금은 어차피 누군가가 MoveThread new할꺼니까 현재클래스의 생성자로 얻어오는 것은 어떨지?
	AniMain aniMain;

	public MoveThread(AniMain aniMain) {
		this.aniMain = aniMain;
	}

	// 개발자는 독립 실행할 코드를 run에 기재해라
	// 그럼 jvm이 이run을 알아서 호출해준다.
	public void run() {
		// 끝나지 않고 호출해야 한다. AniMain의 move를 가져와야한다.
		while(true){ //이렇게하면 너무나 빨리돌아서 인간의 눈으로 볼 수가 없다. 휴가보내야 한다.
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			aniMain.move();			
		}

	}

}
