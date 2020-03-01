package mobangame;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Image;


public class Picture extends JPanel{
	public Picture() {
		this.setBorder(new TitledBorder("预览区"));

	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//指定图片的路径
		String filename = "images/1.jpg";
		//通过图片的路径，获取对应的图像
		ImageIcon icon = new ImageIcon(filename);
		 Image image = icon.getImage();
		//把图像绘制在预览区中
		g.drawImage(image, 20,20,600,600, this);

	}

}