package mobangame;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Image;


public class Picture extends JPanel{
	public Picture() {
		this.setBorder(new TitledBorder("Ԥ����"));

	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//ָ��ͼƬ��·��
		String filename = "images/1.jpg";
		//ͨ��ͼƬ��·������ȡ��Ӧ��ͼ��
		ImageIcon icon = new ImageIcon(filename);
		 Image image = icon.getImage();
		//��ͼ�������Ԥ������
		g.drawImage(image, 20,20,600,600, this);

	}

}