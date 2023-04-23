import javax.swing.JPanel;
import java.awt.*;

public class Test3dPanel extends JPanel{
	private cube test;
	private coordinate eye = new coordinate(1000,500,350);
	
	public Test3dPanel() {
		//test = new cube(new coordinate[] {new coordinate(-600,450,300),new coordinate(-600,550,300),new coordinate(-600,450,400),new coordinate(-600,550,400), new coordinate(-500,450,300),new coordinate(-500,550,300),new coordinate(-500,450,400),new coordinate(-500,550,400)}, eye);
		test = new cube(new coordinate(-550, 500, 350), eye, 100);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		test.draw(g2d);

		g.setColor(Color.RED);
		g.fillOval((int)eye.getY(), (int)eye.getZ(), 3, 3);
	}
	public cube getTest() {
		return test;
	}
	public void setTest(cube test) {
		this.test = test;
	}
	public coordinate getEye() {
		return eye;
	}
	public void setEye(coordinate eye) {
		this.eye = eye;
	}
	
}
