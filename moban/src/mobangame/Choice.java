package mobangame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Choice{
	
	  private Frame f;//������
	  private  JPanel jp1;//���
	  JButton jb1,jb2;//������ť
	  
	 
	
     
     public Choice(){
    	 f = new Frame();
    	 jp1 = new JPanel();
    	 jp1.setBorder(new TitledBorder("��ѡ������Ҫ���淨��"));
    	 jb1 = new JButton("ͼ���淨");
         jb2 = new JButton("�����淨");
         Font o = new Font("���Ĳ���",Font.BOLD,30);//����һ����Font
         jb1.setForeground(Color.white);
         jb1.setBackground(Color.pink);
         jb1.setFont(o);
         jb2.setForeground(Color.white);
         jb2.setBackground(Color.pink);
         jb2.setFont(o);

         //���ò���
         f.setLayout(new GridLayout(1,2));//���񲼾�
         f.add(jp1);
         
         
         jp1.add(jb1);
         jp1.add(jb2);

         f.setVisible(true);
         f.setTitle("��ӭ����ħ��ƴͼ");
         f.setBounds(450, 250, 300, 200);
         
        
         
         f.addWindowListener(
                 new WindowAdapter() {
                     public void windowClosing(WindowEvent e) {
                         System.exit(0);
                     }
                 });//���ô��ڵĵ�����Ͻǵ�x�Ĵ���ʽ���������õ����˳�����
         
         
         jb1.addActionListener(new ActionListener() {//��ͼ���淨��ť��Ӽ����¼�
        	   
 			public void actionPerformed(ActionEvent e) {
 				
 				PictureGame f = new PictureGame();
 				
 				
 			}
 			
 		});
         
         jb2.addActionListener(new ActionListener() {//�������淨��ť��Ӽ����¼�
      	   
  			public void actionPerformed(ActionEvent e) {
  				
  				DigitGame d = new DigitGame();
  				d.puzzlePad.start();
//  				puzzlePad.start();
  				
  				
  				
  			}
  			
  		});
    	 
     }

     public static void main(String[] args) {
//    	 PictureGame.choice = new Choice();
    	 DigitGame.choice = new Choice();
     }
}
