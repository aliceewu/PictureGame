package mobangame;

import javax.swing.*;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.*;

 public class PuzzlePad extends JPanel implements MouseListener{
	
	   
		Button[] Btn = new Button[9]; 
		Button nullButton;//指定一个空的小方格
		
		private boolean hasAddActionListener =  false; //用来表示是否为方格添加了点击监听，添加了值为true,未添加值为false
	
 public PuzzlePad(){
	 

     for(int i=0;i<8;i++)
     {
       Btn[i]=new Button(""+i);
       this.add(Btn[i]);
       Font f = new Font("黑体",Font.BOLD,70);//创建一个新Font
       Btn[i].setForeground(Color.white);
       Btn[i].setBackground(Color.pink);
       Btn[i].setFont(f);
    
     }
       
			//指定一个空的小方格
			 nullButton = new Button("");
			 nullButton.setBounds(400, 400, 200, 200);
			 this.add(nullButton);
			 
}
 
//对小方格进行重新位置排序，打乱顺序
		public void start(){
			//如果没有给小方格添加鼠标点击监听的话，则添加监听
			if ( !hasAddActionListener) {
				//添加监听
				for (int i = 0; i < 8; i++) {
					Btn[i].addMouseListener(this);
				}
				//更新鼠标点击监听的状态
				hasAddActionListener = true;
			}
			 ArrayList<Integer> numberList=new ArrayList<Integer>();//用来存放数组的值
			 for(int k=0;k<8;k++){
		            numberList.add(k);//用来存放按钮
			         }
			 Collections.shuffle(numberList); //进行重新位置排序，打乱顺序
				for(int i=0;i<8;i++)
				{
					Btn[i].setLabel(numberList.get(i) +"");
				}
			}
			


	
	public void mousePressed(MouseEvent e) {//鼠标按下去
		
		if(e.getSource()instanceof Button){
			//获取到当前所点击的小方格
			Button button = (Button)e.getSource();
			//获取所点击方格的x，y坐标
			int clickX = button.getX();
			int clickY = button.getY();
			//获取当前空方格的x，y坐标
			int nullX = nullButton.getX();
			int nullY = nullButton.getY();
//			System.out.print(clickX+":"+clickY+" ");
			//进行比较，如果满足条件进行位置的交换
			if (clickX == nullX && clickY - nullY == 200)
			{//点击的为空方格下面的方格
				button.setLocation(button.getX(), button.getY() - 200);//所点击的方格 向上移动
		    }
			else if (clickX == nullX && clickY - nullY == -200) //点击的为空方格上面的方格
			{
				button.setLocation(button.getX(),button.getY() + 200);
			}
			else if(clickX - nullX == 200 && clickY == nullY)//点击的为空方格右面的方格
			{
				button.setLocation(button.getX() - 200, button.getY());//所点击的方格 向左移动
				
			} 
			else if(clickX - nullX == -200 && clickY == nullY)//点击的为空方格左面的方格
			{
				button.setLocation(button.getX() + 200, button.getY());//所点击的方格 向右移动
			} 
			 else {
					return ;// 不满足移动条件，就不进行任何的处理
				}
			
			nullButton.setLocation(clickX, clickY);//更新空方格的位置
			//拼图区界面重新绘制
			this.repaint();
			
		
		
	
		
		//判断当前游戏是否完成，若完成，给玩家一个友好提示
		if (this.isFinish()) {
			//弹出窗口提示
			JOptionPane.showMessageDialog(this, "恭喜你完成拼图，加油！");
			//撤销每一个小方格上的鼠标点击监听, 让鼠标点击小方格步再起作用了
			for (int i = 0; i < 8; i++) {
				Btn[i].removeMouseListener(this);
			}
			//更新方格的动作监听器的状态
			hasAddActionListener = false;
		}
			}
//		
		
	}
	private boolean isFinish() {

		for (int i = 0; i < 8; i++) {
			//获取每一个方格的位置
			int x = Btn[i].getX();
			int y = Btn[i].getY();
			
			if (((y-20)/150*3 + (x-20)/150) != i) {
				
				
				return false;
			}
		}
		return true;
	
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
//	public void mousePressed(MouseEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}

	
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
