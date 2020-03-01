package mobangame;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.awt.*;

public class DigitGame extends JFrame implements ActionListener{
	private Frame f;//整体
	private JPanel p1;//上边
	private JButton b1;//3*3按钮
	private JButton b2;//4*4按钮
	private JButton b3;//结束按钮
	public static Choice choice;//静态变量直接类名调用
	PuzzlePad puzzlePad;
	
	
	
	
	public DigitGame(){
		 f = new JFrame("数字玩法");
		 p1 = new JPanel();
		 b1 = new JButton("3X3");
		 b2 = new JButton("4X4");
		 b3 = new JButton("结束");
		
		 puzzlePad = new PuzzlePad();
		
		 f.setLayout(null);
		 f.add(p1);
		 f.add(puzzlePad);
		 puzzlePad.setLayout(new GridLayout(3,3));
		 
		 f.setBounds(250, 40, 700,800);
		 p1.setBounds(10, 2, 400,20);
		 puzzlePad.setBounds(50, 40, 600, 600);
		
//		 p1.add(b1);
//		 p1.add(b2);
//		 p1.add(b3);
		 
		
	     

		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);

		 f.setVisible(true);
		 validate();
		  
	}
	

	
public void actionPerformed(ActionEvent e) { //创建按钮的监听器
	
	if(e.getSource()==b1){

//		puzzlePad.start();
//		puzzlePad.repaint();

       }
	else if(e.getSource()==b2){
		
		
						
				
	}
	else
	if(e.getSource()==b3){
		
				f.setVisible(false);//隐藏
		
			
	}
	
	
}

public static void main(String[] args) {

	
}
}
