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
    private Rectangle nullCell;//指定一个空的小方格
	private boolean hasAddActionListener =  false; //用来表示是否为方格添加了点击监听，添加了值为true,未添加值为false
	int step = 0;//存储当前步数

	public PicturePlay() {
		this.setBorder(new TitledBorder("拼图区"));
		//设置拼图区布局
		this.setLayout(null);
		
		//创建9个图片小方格，添加到拼图区
		
		for (int i = 0; i < 3; i++) {//代表的是行数
			for (int j = 0; j < 3; j++) {//代表的是列数
				ImageIcon icon = new ImageIcon("images/1_"+(i*3+j+1)+".jpg");
				//创建图片小方格
				cell[i*3+j] = new Cells(icon);
				//指定图片小方格显示的位置
			     cell[i*3+j].setLocation(j*200+20, i*200+20);
				//把图片小方格添加到拼图区显示
				this.add(cell[i*3+j]);
			}
	}
		        //删除第9个图片小方格
				this.remove(cell[8]);	
				//指定一个空的小方格
				 nullCell = new Rectangle(400+20, 400+20, 200, 200);
	
   }
	
	//对小方格进行重新位置排序，打乱顺序
		public void start(){
				//如果没有给小方格添加鼠标点击监听的话，则添加监听
				if ( !hasAddActionListener) {
					//添加监听
					for (int i = 0; i < 9; i++) {
						cell[i].addMouseListener(this);
					}
					//更新鼠标点击监听的状态
					hasAddActionListener = true;
				}
				
				//判断当前第一个小方格距离左上角的较近时，进行方格与空方格互换
				//如果第一个小方格在左上角的四个方格位置内，就不断的循环，进行方法与空方格位置的互换
				while(cell[0].getBounds().x <=220&& cell[0].getBounds().y <=220 ){
					//获取到空方格的位置
					int nullX = nullCell.getBounds().x;
					int nullY = nullCell.getBounds().y;
					
					//随机产生一个方向，进行空方格与小方法的互换
					//产生0-3之间的随机数，对应空方格的上下左右移动
					int direction = (int)(Math.random()*4);//0,1,2,3
					switch (direction) {
						case 0://空方格向左移动，与左边的方格进行互换位置，左侧方格要向右移动
							//nullX = nullX - 150;
							nullX -= 200;
							cellMove(nullX, nullY, "RIGHT");
							break;
						case 1://空方格向右移动，与右边的方格进行互换位置，右侧方格要向左移动
							nullX += 200;
							cellMove(nullX, nullY, "LEFT");
							break;
						case 2://空方格向上移动，与上边的方格进行互换位置，上侧方格要向下移动
							nullY -= 200;
							cellMove(nullX, nullY, "DOWN");
							break;
						case 3://空方格向下移动，与下边的方格进行互换位置，下侧方格要向上移动
							nullY += 200;
							cellMove(nullX, nullY, "UP");
							break;
					}
				}
				
			}

		/**
		 * 方格与空方格位置互换
		 * @param nullX 空方格的x轴坐标
		 * @param nullY 空方格的y轴坐标
		 * @param direction 方格要移动的方向
		 */
	private void cellMove(int nullX, int nullY, String string) {
		for (int i = 0; i < 9; i++) {
			//获取到与空方格位置相同的小方格
			if (cell[i].getBounds().x == nullX && cell[i].getBounds().y == nullY) {
				//当前方格的移动
				cell[i].move(string);
				//空方格的移动
				nullCell.setLocation(nullX, nullY);
				//交换位置后，结束循环
				break;
			}
		}
			
		}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {//鼠标按下去
		//获取到当前所点击的小方格
		Cells button = (Cells)e.getSource();
		//获取所点击方格的x，y坐标
		int clickX = button.getBounds().x;
		int clickY = button.getBounds().y;
//		System.out.print(clickX+":"+clickY+" ");		
		//获取当前空方格的x，y坐标
		int nullX = nullCell.getBounds().x;
		int nullY = nullCell.getBounds().y;
		
		//进行比较，如果满足条件进行位置的交换
		if (clickX == nullX && clickY - nullY == 200) {//点击的为空方格下面的方格
			button.move("UP");//所点击的方格 向上移动
		} else if (clickX == nullX && clickY - nullY == -200) {//点击的为空方格上面的方格
			button.move("DOWN");//所点击的方格 向下移动
		} else if(clickX - nullX == 200 && clickY == nullY){//点击的为空方格右面的方格
			button.move("LEFT");//所点击的方格 向左移动
		} else if(clickX - nullX == -200 && clickY == nullY){//点击的为空方格左面的方格
			button.move("RIGHT");//所点击的方格 向右移动
		} else {
			return ;// 不满足移动条件，就不进行任何的处理
		}
		//更新空方格的位置
		nullCell.setLocation(clickX, clickY);
		//拼图区界面重新绘制
		this.repaint();
		step++;
		PictureGame.nowStep.setText(""+step);

		
		//判断当前游戏是否完成，若完成，给玩家一个友好提示
		if (this.isFinish()) {
			//弹出窗口提示
			JOptionPane.showMessageDialog(this, "恭喜你完成拼图，加油！");
			//撤销每一个小方格上的鼠标点击监听, 让鼠标点击小方格步再起作用了
			for (int i = 0; i < 9; i++) {
				cell[i].removeMouseListener(this);
			}
			//更新方格的动作监听器的状态
			hasAddActionListener = false;
		}
		
	
		
		
	}

	private boolean isFinish() {

		for (int i = 0; i < 9; i++) {
			//获取每一个方格的位置
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