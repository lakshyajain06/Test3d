import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.Timer;

public class Test3DListener implements MouseListener, KeyListener, MouseMotionListener, ActionListener{

	Test3dPanel panel;
	point position;
	ArrayList<coordinate> selected = new ArrayList<coordinate>();
	double eyeStartX, eyeStartY, startX, startY;
	Timer myTimer = new Timer(10, this);
	int time = 0;

	public Test3DListener(Test3dPanel panel) {
		this.panel = panel;
		panel.addMouseListener(this);
		panel.addKeyListener(this);
		panel.addMouseMotionListener(this);
		eyeStartX = panel.getEye().getY();
		eyeStartY = panel.getEye().getZ();
		startX = 0;
		startY = 0;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		position = new point(e.getX(), e.getY());
		if(!e.isShiftDown()) {
			for(int i = 0; i < panel.getTest().getVertices().length; i++) {
				panel.getTest().getVertices()[i].setSelected(false);
			}
			selected.clear();
		}
		for(int i = 0; i < panel.getTest().getVertices().length; i++) {
			if(panel.getTest().getVertices()[i].getHitbox().contains(position.getX(), position.getY())) {
				panel.getTest().getVertices()[i].setSelected(true);
				selected.add(panel.getTest().getVertices()[i]);
			}
		}
		panel.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		startX = e.getX();
		startY = e.getY();
		eyeStartX = panel.getEye().getY();
		eyeStartY = panel.getEye().getZ();
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char key = e.getKeyChar();
		if(key == 'f') {
			for(int i = 0; i < selected.size(); i++) {
				for(int j = 0; j < selected.size(); j++) {
					if(i != j) {
						selected.get(i).setConnected(selected.get(j));
					}
				}
			}
		}
		panel.repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_SPACE) {
			myTimer.start();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_SPACE) {
			myTimer.stop();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.isMetaDown()) {
			panel.getEye().setY(eyeStartX - (e.getX()-startX));
			panel.getEye().setZ(eyeStartY - (e.getY()-startY));
			panel.getTest().updateEye(panel.getEye());
			panel.repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		time++;
		panel.getTest().rotateAnim(time);
		panel.repaint();
		
	}

}
