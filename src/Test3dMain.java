import javax.swing.JFrame;

public class Test3dMain {
	public static void main(String[] args) {
		JFrame window = new JFrame("3D Screed");
		window.setSize(1000, 700);
		window.setLocation(100, 200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Test3dPanel panel3d = new Test3dPanel();
		new Test3DListener(panel3d);
		
	
		window.setContentPane(panel3d);
		window.setVisible(true);

		panel3d.requestFocusInWindow();
	}
}
