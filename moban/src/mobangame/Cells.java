package mobangame;
import java.awt.Button;

import javax.swing.Icon;
import javax.swing.JButton;

public class Cells extends JButton{

	public Cells(Icon icon) {
		 super(icon);
		//设置小方格大小
		this.setSize(200,200);
	}
	public Cells(int icon) {
		 super(icon+"");
		//设置小方格大小
		this.setSize(200,200);
	}


		//当前方格的移动
		public void move(String direction){//上，下，左，右
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
			default://其他情况，不做移动处理
				break;
			}
		}

}
