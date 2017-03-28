package file;

import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

/*
	Ŭ������ �ڵ��� ���� ������ ���� ����̴�.
*/
public class FileExplorerStudy extends JFrame{
	MyIcon folder_on, folder_off;
	//�̹����� ���� ������Ʈ�� �������� ������ �� ���� >> res�� classpath�� ���!!!
	
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
	
	//���ϴ� ����� ���� ���͸� �� ���� ���ϱ�
	private ArrayList<String> getDirList(){
		File file = new File("C:/");
		File[] filelist = file.listFiles();
		ArrayList<String> dirlist = new ArrayList<String>();
		
		//���丮�� �����
		for(int i=0; i<filelist.length; i++){
			if(filelist[i].isDirectory()){
				//���͸��� �߰ߵ� ������ ����Ʈ�� �߰�
				dirlist.add(filelist[i].getName());
			}
		}
		
		return dirlist;
	}
	
	public static void main(String[] args) {
		new FileExplorerStudy();
	}

}
