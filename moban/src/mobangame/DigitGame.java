package mobangame;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.awt.*;

public class DigitGame extends JFrame implements ActionListener{
	private Frame f;//����
	private JPanel p1;//�ϱ�
	private JButton b1;//3*3��ť
	private JButton b2;//4*4��ť
	private JButton b3;//������ť
	public static Choice choice;//��̬����ֱ����������
	PuzzlePad puzzlePad;
	
	
	
	
	public DigitGame(){
		 f = new JFrame("�����淨");
		 p1 = new JPanel();
		 b1 = new JButton("3X3");
		 b2 = new JButton("4X4");
		 b3 = new JButton("����");
		
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
	

	
public void actionPerformed(ActionEvent e) { //������ť�ļ�����
	
	if(e.getSource()==b1){

//		puzzlePad.start();
//		puzzlePad.repaint();

       }
	else if(e.getSource()==b2){
		
		
						
				
	}
	else
	if(e.getSource()==b3){
		
				f.setVisible(false);//����
		
			
	}
	
	
}

public static void main(String[] args) {

	
}
}
