package file;

import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

/*
	클래스는 코드의 재사용 때문에 나온 기술이다.
*/
public class FileExplorerStudy extends JFrame{
	MyIcon folder_on, folder_off;
	//이미지를 현재 프로젝트를 기준으로 가져올 수 있음 >> res를 classpath로 등록!!!
	
	public FileExplorerStudy(){
		setLayout(new FlowLayout());
		
		folder_on = new MyIcon(this.getClass().getResource("/folder_up.png"), 50, 50);
		folder_off = new MyIcon(this.getClass().getResource("/folder_down.png"), 50, 50);
		
		ArrayList<String> list = getDirList();
		
		for(int i=0; i<list.size(); i++){
			String dirName = list.get(i);
			MyPanel mp = new MyPanel(dirName, folder_off);
			add(mp);
		}
		
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//원하는 경로의 하위 디렉터리 및 파일 구하기
	private ArrayList<String> getDirList(){
		File file = new File("C:/");
		File[] filelist = file.listFiles();
		ArrayList<String> dirlist = new ArrayList<String>();
		
		//디렉토리만 골라내자
		for(int i=0; i<filelist.length; i++){
			if(filelist[i].isDirectory()){
				//디렉터리가 발견될 때마다 리스트에 추가
				dirlist.add(filelist[i].getName());
			}
		}
		
		return dirlist;
	}
	
	public static void main(String[] args) {
		new FileExplorerStudy();
	}

}
