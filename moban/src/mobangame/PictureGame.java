package mobangame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class PictureGame extends JFrame{
	public static Choice choice;//静态变量直接类名调用
	public JFrame f = new JFrame("图像玩法");
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();		
	private JButton b1 = new JButton("开始");
	private JButton b2 = new JButton("结束");
	static JLabel nowStep = new JLabel("0");
	

	private Picture pi;
	private PicturePlay dis;
	
	public  PictureGame() {
		addComponent();//添加组件
		addPreviewImage();//添加预览图片与拼图图片
		addActionListener();//为组件添加事件监听
	}
	//为组件添加事件监听
	private void addActionListener() {
		//开始按钮
				b1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//对小方格进行重新位置排序，打乱顺序
						dis.start();
						dis.repaint();
					}
				});
				b2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						f.setVisible(false);//隐藏
//						System.exit(0);
					}
				});
	}



	//添加预览图片与拼图图片
	private void addPreviewImage() {
		
		p2.setLayout(new GridLayout(1,2));
		pi = new Picture();
		dis = new PicturePlay();
		p2.add(pi);
		p2.add(dis);
		f.add(p2,BorderLayout.CENTER);
		
	}
	
	//添加组件
	private void addComponent() {
		p1.add(b1);
		p1.add(b2);
		p1.add(new JLabel("当前步数："));
		p1.add(nowStep);

		f.add(p1,BorderLayout.NORTH);
		f.setSize(1000, 600);
		//设置窗口的显示位置
		f.setLocation(150, 10);
		//设置窗口的大小为固定大小
//		f.setResizable(false);
		//设置窗口的默认关闭操作
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	
	public static void main(String[] args) {


		

	}
}
           
		
