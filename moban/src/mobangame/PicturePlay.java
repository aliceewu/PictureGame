package mobangame;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;



//import javafx.scene.control.Cell;


public class PicturePlay extends JPanel implements MouseListener{
    Cells[] cell = new Cells[9];
    private Rectangle nullCell;//ָ��һ���յ�С����
	private boolean hasAddActionListener =  false; //������ʾ�Ƿ�Ϊ��������˵�������������ֵΪtrue,δ���ֵΪfalse
	int step = 0;//�洢��ǰ����

	public PicturePlay() {
		this.setBorder(new TitledBorder("ƴͼ��"));
		//����ƴͼ������
		this.setLayout(null);
		
		//����9��ͼƬС������ӵ�ƴͼ��
		
		for (int i = 0; i < 3; i++) {//�����������
			for (int j = 0; j < 3; j++) {//�����������
				ImageIcon icon = new ImageIcon("images/1_"+(i*3+j+1)+".jpg");
				//����ͼƬС����
				cell[i*3+j] = new Cells(icon);
				//ָ��ͼƬС������ʾ��λ��
			     cell[i*3+j].setLocation(j*200+20, i*200+20);
				//��ͼƬС������ӵ�ƴͼ����ʾ
				this.add(cell[i*3+j]);
			}
	}
		        //ɾ����9��ͼƬС����
				this.remove(cell[8]);	
				//ָ��һ���յ�С����
				 nullCell = new Rectangle(400+20, 400+20, 200, 200);
	
   }
	
	//��С�����������λ�����򣬴���˳��
		public void start(){
				//���û�и�С�����������������Ļ�������Ӽ���
				if ( !hasAddActionListener) {
					//��Ӽ���
					for (int i = 0; i < 9; i++) {
						cell[i].addMouseListener(this);
					}
					//���������������״̬
					hasAddActionListener = true;
				}
				
				//�жϵ�ǰ��һ��С����������ϽǵĽϽ�ʱ�����з�����շ��񻥻�
				//�����һ��С���������Ͻǵ��ĸ�����λ���ڣ��Ͳ��ϵ�ѭ�������з�����շ���λ�õĻ���
				while(cell[0].getBounds().x <=220&& cell[0].getBounds().y <=220 ){
					//��ȡ���շ����λ��
					int nullX = nullCell.getBounds().x;
					int nullY = nullCell.getBounds().y;
					
					//�������һ�����򣬽��пշ�����С�����Ļ���
					//����0-3֮������������Ӧ�շ�������������ƶ�
					int direction = (int)(Math.random()*4);//0,1,2,3
					switch (direction) {
						case 0://�շ��������ƶ�������ߵķ�����л���λ�ã���෽��Ҫ�����ƶ�
							//nullX = nullX - 150;
							nullX -= 200;
							cellMove(nullX, nullY, "RIGHT");
							break;
						case 1://�շ��������ƶ������ұߵķ�����л���λ�ã��Ҳ෽��Ҫ�����ƶ�
							nullX += 200;
							cellMove(nullX, nullY, "LEFT");
							break;
						case 2://�շ��������ƶ������ϱߵķ�����л���λ�ã��ϲ෽��Ҫ�����ƶ�
							nullY -= 200;
							cellMove(nullX, nullY, "DOWN");
							break;
						case 3://�շ��������ƶ������±ߵķ�����л���λ�ã��²෽��Ҫ�����ƶ�
							nullY += 200;
							cellMove(nullX, nullY, "UP");
							break;
					}
				}
				
			}

		/**
		 * ������շ���λ�û���
		 * @param nullX �շ����x������
		 * @param nullY �շ����y������
		 * @param direction ����Ҫ�ƶ��ķ���
		 */
	private void cellMove(int nullX, int nullY, String string) {
		for (int i = 0; i < 9; i++) {
			//��ȡ����շ���λ����ͬ��С����
			if (cell[i].getBounds().x == nullX && cell[i].getBounds().y == nullY) {
				//��ǰ������ƶ�
				cell[i].move(string);
				//�շ�����ƶ�
				nullCell.setLocation(nullX, nullY);
				//����λ�ú󣬽���ѭ��
				break;
			}
		}
			
		}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {//��갴��ȥ
		//��ȡ����ǰ�������С����
		Cells button = (Cells)e.getSource();
		//��ȡ����������x��y����
		int clickX = button.getBounds().x;
		int clickY = button.getBounds().y;
//		System.out.print(clickX+":"+clickY+" ");		
		//��ȡ��ǰ�շ����x��y����
		int nullX = nullCell.getBounds().x;
		int nullY = nullCell.getBounds().y;
		
		//���бȽϣ����������������λ�õĽ���
		if (clickX == nullX && clickY - nullY == 200) {//�����Ϊ�շ�������ķ���
			button.move("UP");//������ķ��� �����ƶ�
		} else if (clickX == nullX && clickY - nullY == -200) {//�����Ϊ�շ�������ķ���
			button.move("DOWN");//������ķ��� �����ƶ�
		} else if(clickX - nullX == 200 && clickY == nullY){//�����Ϊ�շ�������ķ���
			button.move("LEFT");//������ķ��� �����ƶ�
		} else if(clickX - nullX == -200 && clickY == nullY){//�����Ϊ�շ�������ķ���
			button.move("RIGHT");//������ķ��� �����ƶ�
		} else {
			return ;// �������ƶ��������Ͳ������κεĴ���
		}
		//���¿շ����λ��
		nullCell.setLocation(clickX, clickY);
		//ƴͼ���������»���
		this.repaint();
		step++;
		PictureGame.nowStep.setText(""+step);

		
		//�жϵ�ǰ��Ϸ�Ƿ���ɣ�����ɣ������һ���Ѻ���ʾ
		if (this.isFinish()) {
			//����������ʾ
			JOptionPane.showMessageDialog(this, "��ϲ�����ƴͼ�����ͣ�");
			//����ÿһ��С�����ϵ����������, �������С��������������
			for (int i = 0; i < 9; i++) {
				cell[i].removeMouseListener(this);
			}
			//���·���Ķ�����������״̬
			hasAddActionListener = false;
		}
		
	
		
		
	}

	private boolean isFinish() {

		for (int i = 0; i < 9; i++) {
			//��ȡÿһ�������λ��
			int x = cell[i].getBounds().x;
			int y = cell[i].getBounds().y;
			if ( ((y-20)/150*3 + (x-20)/150) != i ) {
				//i=0,  (20-20)/150*3 + (20-20)/150) = 0
				//i=1,  (20-20)/150*3 + (170-20)/150) = 1
				//....
				//i=5,  (170-20)/150*3 + (320-20)/150)= 5 
				return false;
			}
		}
		
		return true;
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}