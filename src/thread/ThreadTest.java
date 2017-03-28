/*
 OS가 여러 프로세스를 동시에 수행하면서 관리할 수 있듯이(멀티태스킹-MultiTasking)
 하나의 자바 프로그램 내에서도 세부적 실행단위를 만들어 동시에 수행시킬 수 있다.
 이러한 세부적 실행 단위를 쓰레드라 한다.
 
 <실행 흐름을 풀이해보자>
 메인실행부로가면 new ThreadTest()호출!
 그러다가 thread = new MyThrea()만나면
 분신을 하나 만들어놓고 자기 갈길을 간다.
 sysout 흰별 출력한다. 그리고 }닫히니까 끝!
 
 그럼 머리카락 뽑은 이 분신은?
 MyThread.java에서 ★출력시키기게 했다.
 동생이 보유하고 있는것은 run()인데 대놓고 run()호출하면 안돈다.
 thread.start(); 라고해야함! 나중에 설명..
 
run()을 쓰면?
시스템한테 맡기지 않고 일반메서드처럼 메인메서드가 실행하러간다.
분신으로 생성한 run메소드를 메인쓰레드 자신이 MyThread.java가서 실행한다.
조심해야 한다!!

즉, run()이 아닌 start()라고하면 개발자가 하는게아니라
JVM님 해주세요 하는거! 그리고 자기는 갈길간다. 실행부는 흰별을 찍고
따로따로~

*/

package thread;

public class ThreadTest {
	
	/*
	 2. 메인쓰레드 말고 개발자가 원하는 사용자 정의 쓰레드 하나 만들어서
	 원하는 동시 작업을 시켜보자.
	 쓰레드는 Thread class가 있음
	 import 에러가 나지 않는다?  java.lang에 있기때문에
	 */
	
	//Threa thread; 였지만이제 MyThread로 바뀐다.
	MyThread thread;

	public ThreadTest() {
		
		/*
		 메인쓰레드와는 독립적으로 실행될 수 있는 세부 실행단위 생성
		쓰레드가 어떤 일을 할지는 개발자가 결정해야 하기 때문에
		개발자가 결정해라? = 코딩 영역이 있어야 한다. 
		한마디로 쓰레드 재정의 하자! = 상속받자라는 의미 = MyThread 만들자! */
		thread = new MyThread();
		thread.start();
		
		//	thread.run(); 써보면?
		// 분신으로 생성한 run메소드를 메인쓰레드 자신이 MyThread.java가서 실행한다.
	
		//메인쓰레드에도 시간을주자
		while(true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("☆");
		}		
	}

	public static void main(String[] args) {
		
		new ThreadTest();
		
		/*
		int[] arr = new int[3];
		System.out.println(arr[3]); //문제있다
		
		 1. 컴파일때 못잡고 실행타임에 잡을 수 잇는 에러이다 -> 런타임exception
		 console창 보면 Exception in thread "main"?????
		 -> java는 개발자가 정의하지 않아도 이미 기본적으로 제공되는
		 실행용 쓰레드가 있으며 이러한 쓰레드를 가리켜 메인쓰레드라 한다.
		 결국 자바는 쓰레드 기반이다!
		 */

	}
}
