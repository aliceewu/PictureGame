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
	public static Choice choice;//��̬����ֱ����������
	public JFrame f = new JFrame("ͼ���淨");
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();		
	private JButton b1 = new JButton("��ʼ");
	private JButton b2 = new JButton("����");
	static JLabel nowStep = new JLabel("0");
	

	private Picture pi;
	private PicturePlay dis;
	
	public  PictureGame() {
		addComponent();//������
		addPreviewImage();//���Ԥ��ͼƬ��ƴͼͼƬ
		addActionListener();//Ϊ�������¼�����
	}
	//Ϊ�������¼�����
	private void addActionListener() {
		//��ʼ��ť
				b1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//��С�����������λ�����򣬴���˳��
						dis.start();
						dis.repaint();
					}
				});
				b2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						f.setVisible(false);//����
//						System.exit(0);
					}
				});
	}



	//���Ԥ��ͼƬ��ƴͼͼƬ
	private void addPreviewImage() {
		
		p2.setLayout(new GridLayout(1,2));
		pi = new Picture();
		dis = new PicturePlay();
		p2.add(pi);
		p2.add(dis);
		f.add(p2,BorderLayout.CENTER);
		
	}
	
	//������
	private void addComponent() {
		p1.add(b1);
		p1.add(b2);
		p1.add(new JLabel("��ǰ������"));
		p1.add(nowStep);

		f.add(p1,BorderLayout.NORTH);
		f.setSize(1000, 600);
		//���ô��ڵ���ʾλ��
		f.setLocation(150, 10);
		//���ô��ڵĴ�СΪ�̶���С
//		f.setResizable(false);
		//���ô��ڵ�Ĭ�Ϲرղ���
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	
	public static void main(String[] args) {


		

	}
}
           
		
