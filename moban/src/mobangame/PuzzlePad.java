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
		Button nullButton;//ָ��һ���յ�С����
		
		private boolean hasAddActionListener =  false; //������ʾ�Ƿ�Ϊ��������˵�������������ֵΪtrue,δ���ֵΪfalse
	
 public PuzzlePad(){
	 

     for(int i=0;i<8;i++)
     {
       Btn[i]=new Button(""+i);
       this.add(Btn[i]);
       Font f = new Font("����",Font.BOLD,70);//����һ����Font
       Btn[i].setForeground(Color.white);
       Btn[i].setBackground(Color.pink);
       Btn[i].setFont(f);
    
     }
       
			//ָ��һ���յ�С����
			 nullButton = new Button("");
			 nullButton.setBounds(400, 400, 200, 200);
			 this.add(nullButton);
			 
}
 
//��С�����������λ�����򣬴���˳��
		public void start(){
			//���û�и�С�����������������Ļ�������Ӽ���
			if ( !hasAddActionListener) {
				//��Ӽ���
				for (int i = 0; i < 8; i++) {
					Btn[i].addMouseListener(this);
				}
				//���������������״̬
				hasAddActionListener = true;
			}
			 ArrayList<Integer> numberList=new ArrayList<Integer>();//������������ֵ
			 for(int k=0;k<8;k++){
		            numberList.add(k);//������Ű�ť
			         }
			 Collections.shuffle(numberList); //��������λ�����򣬴���˳��
				for(int i=0;i<8;i++)
				{
					Btn[i].setLabel(numberList.get(i) +"");
				}
			}
			


	
	public void mousePressed(MouseEvent e) {//��갴��ȥ
		
		if(e.getSource()instanceof Button){
			//��ȡ����ǰ�������С����
			Button button = (Button)e.getSource();
			//��ȡ����������x��y����
			int clickX = button.getX();
			int clickY = button.getY();
			//��ȡ��ǰ�շ����x��y����
			int nullX = nullButton.getX();
			int nullY = nullButton.getY();
//			System.out.print(clickX+":"+clickY+" ");
			//���бȽϣ����������������λ�õĽ���
			if (clickX == nullX && clickY - nullY == 200)
			{//�����Ϊ�շ�������ķ���
				button.setLocation(button.getX(), button.getY() - 200);//������ķ��� �����ƶ�
		    }
			else if (clickX == nullX && clickY - nullY == -200) //�����Ϊ�շ�������ķ���
			{
				button.setLocation(button.getX(),button.getY() + 200);
			}
			else if(clickX - nullX == 200 && clickY == nullY)//�����Ϊ�շ�������ķ���
			{
				button.setLocation(button.getX() - 200, button.getY());//������ķ��� �����ƶ�
				
			} 
			else if(clickX - nullX == -200 && clickY == nullY)//�����Ϊ�շ�������ķ���
			{
				button.setLocation(button.getX() + 200, button.getY());//������ķ��� �����ƶ�
			} 
			 else {
					return ;// �������ƶ��������Ͳ������κεĴ���
				}
			
			nullButton.setLocation(clickX, clickY);//���¿շ����λ��
			//ƴͼ���������»���
			this.repaint();
			
		
		
	
		
		//�жϵ�ǰ��Ϸ�Ƿ���ɣ�����ɣ������һ���Ѻ���ʾ
		if (this.isFinish()) {
			//����������ʾ
			JOptionPane.showMessageDialog(this, "��ϲ�����ƴͼ�����ͣ�");
			//����ÿһ��С�����ϵ����������, �������С��������������
			for (int i = 0; i < 8; i++) {
				Btn[i].removeMouseListener(this);
			}
			//���·���Ķ�����������״̬
			hasAddActionListener = false;
		}
			}
//		
		
	}
	private boolean isFinish() {

		for (int i = 0; i < 8; i++) {
			//��ȡÿһ�������λ��
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
