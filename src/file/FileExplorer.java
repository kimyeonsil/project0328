package file;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileExplorer extends JFrame{
	File file;
	File[] dir;
	ArrayList<JButton> btns;
	ArrayList<JPanel> panels;
	String src1 = "C:/java_eclipse_workspace/Project0327/res/folder_down.png";
	String src2 = "C:/java_eclipse_workspace/Project0327/res/folder_up.png";
	ImageIcon icon1, icon2;
	boolean flag = false;
	
	public FileExplorer(){
		file = new File("C:/");
		dir = file.listFiles();
		btns = new ArrayList<JButton>();
		panels = new ArrayList<JPanel>();
		icon1 = new ImageIcon(src1);
		icon2 = new ImageIcon(src2);
		
		for(int i=0; i<dir.length; i++){
			if(dir[i].isDirectory()){
				JPanel panel = new JPanel(new GridLayout(2, 1));
				JLabel label = new JLabel(dir[i].getName());
				JButton btn = new JButton(icon1);
				
				btn.setBorderPainted(false);
				btn.setFocusPainted(false);
				btn.setContentAreaFilled(false);
				btn.setOpaque(false);
				
				btn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						for(int i=0; i<btns.size(); i++){
							btns.get(i).setIcon(icon1);
						}
						
						btn.setIcon(icon2);
					}
				});
				
				panel.setLayout(new BorderLayout());
				panel.add(label, BorderLayout.NORTH);
				panel.add(btn);
				
				btns.add(btn);
				panels.add(panel);
			}
		}
		
		setLayout(new FlowLayout());
		
		for(int i=0; i<panels.size(); i++){
			add(panels.get(i));
		}
		
		setBounds(100, 100, 600, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new FileExplorer();
	}

}
