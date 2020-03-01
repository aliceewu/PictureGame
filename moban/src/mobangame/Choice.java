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
	
	  private Frame f;//整体大块
	  private  JPanel jp1;//面板
	  JButton jb1,jb2;//创建按钮
	  
	 
	
     
     public Choice(){
    	 f = new Frame();
    	 jp1 = new JPanel();
    	 jp1.setBorder(new TitledBorder("请选择你想要的玩法！"));
    	 jb1 = new JButton("图像玩法");
         jb2 = new JButton("数字玩法");
         Font o = new Font("华文彩云",Font.BOLD,30);//创建一个新Font
         jb1.setForeground(Color.white);
         jb1.setBackground(Color.pink);
         jb1.setFont(o);
         jb2.setForeground(Color.white);
         jb2.setBackground(Color.pink);
         jb2.setFont(o);

         //设置布局
         f.setLayout(new GridLayout(1,2));//网格布局
         f.add(jp1);
         
         
         jp1.add(jb1);
         jp1.add(jb2);

         f.setVisible(true);
         f.setTitle("欢迎来到魔板拼图");
         f.setBounds(450, 250, 300, 200);
         
        
         
         f.addWindowListener(
                 new WindowAdapter() {
                     public void windowClosing(WindowEvent e) {
                         System.exit(0);
                     }
                 });//设置窗口的点击右上角的x的处理方式，这里设置的是退出程序
         
         
         jb1.addActionListener(new ActionListener() {//对图像玩法按钮添加监听事件
        	   
 			public void actionPerformed(ActionEvent e) {
 				
 				PictureGame f = new PictureGame();
 				
 				
 			}
 			
 		});
         
         jb2.addActionListener(new ActionListener() {//对数字玩法按钮添加监听事件
      	   
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
