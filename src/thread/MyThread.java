/*
 동시에 수행하고 싶은 코드는 개발자가 결정해야 하기 때문에 쓰레드를 재정의해야 한다.
 그냥 run에 하고싶은 것 하면 된다.
 
 */

package thread;

public class MyThread extends Thread{
	/*
	 개발자는 독립적으로 수행하고 싶은 코드를 쓰레드에 run 메서드 안에 코딩하면 된다.
	 run적고 ctrl+space bar하면 나옴 */
	
	@Override
	public void run() {
		//까만별 찍어보자
		//우리쓰레드도 별표하나 찍고 브레이스 끝나니까 죽어버렸다.
		//별표 여러개 찍고 싶으면? } 만나면 안된다. 무한반복 필요! -> while
		while(true){ //이렇게하면 동생이 빨리 죽기 때문에 sleep으로 쉬다오라고함
			
			try {
				Thread.sleep(1000); //1초쉬다와
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("★");			
		}
	}

}
