package mobangame;
import java.awt.Button;

import javax.swing.Icon;
import javax.swing.JButton;

public class Cells extends JButton{

	public Cells(Icon icon) {
		 super(icon);
		//����С�����С
		this.setSize(200,200);
	}
	public Cells(int icon) {
		 super(icon+"");
		//����С�����С
		this.setSize(200,200);
	}


		//��ǰ������ƶ�
		public void move(String direction){//�ϣ��£�����
			switch (direction) {
			case "UP":
				this.setLocation(this.getBounds().x, this.getBounds().y - 200);
				break;
			case "DOWN":
				this.setLocation(this.getBounds().x, this.getBounds().y + 200);
				break;
			case "LEFT":
				this.setLocation(this.getBounds().x - 200, this.getBounds().y);
				break;
			case "RIGHT":
				this.setLocation(this.getBounds().x + 200, this.getBounds().y);
				break;
			default://��������������ƶ�����
				break;
			}
		}

}
