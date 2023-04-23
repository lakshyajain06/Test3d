import java.awt.*;

public class cube {
	private coordinate[] vertices = new coordinate[8];
	private double r;
	private coordinate center;
	
	public cube(coordinate[] corners, coordinate eye){
		for(int i = 0; i < corners.length; i++) {
			vertices[i] = corners[i];
			vertices[i].setEyePos(eye);
		}
	}
	public cube(coordinate center, coordinate eye, int width) {
		for(int i = 0; i < vertices.length; i++) {
			vertices[i] = new coordinate(0, 0, 0);
			vertices[i].setEyePos(eye);
		}
		this.center = center;
		r = Math.sqrt(Math.pow(width/2, 2)+Math.pow(width/2, 2));
		rotateAnim(0);
	}

	public coordinate[] getVertices() {
		return vertices;
	}
	
	public void updateEye(coordinate eye) {
		for(int i = 0; i < vertices.length; i++) {
			vertices[i] = vertices[i];
			vertices[i].setEyePos(eye);
		}
	}
	
	public void rotateAnim(int t) {
		t += 45;
		vertices[0].setX(center.getX() + r * Math.sin(Math.toRadians(t)));
		vertices[0].setY(center.getY() + r * Math.cos(Math.toRadians(t)));
		vertices[0].setZ(300);
		
		vertices[1].setX(center.getX() + r * Math.sin(Math.toRadians(t+90)));
		vertices[1].setY(center.getY() + r * Math.cos(Math.toRadians(t+90)));		
		vertices[1].setZ(300);
		
		vertices[2].setX(center.getX() + r * Math.sin(Math.toRadians(t+180)));
		vertices[2].setY(center.getY() + r * Math.cos(Math.toRadians(t+180)));
		vertices[2].setZ(300);

		vertices[3].setX(center.getX() + r * Math.sin(Math.toRadians(t+270)));
		vertices[3].setY(center.getY() + r * Math.cos(Math.toRadians(t+270)));
		vertices[3].setZ(300);

		vertices[4].setX(center.getX() + r * Math.sin(Math.toRadians(t)));
		vertices[4].setY(center.getY() + r * Math.cos(Math.toRadians(t)));
		vertices[4].setZ(400);

		vertices[5].setX(center.getX() + r * Math.sin(Math.toRadians(t+90)));
		vertices[5].setY(center.getY() + r * Math.cos(Math.toRadians(t+90)));
		vertices[5].setZ(400);

		vertices[6].setX(center.getX() + r * Math.sin(Math.toRadians(t+180)));
		vertices[6].setY(center.getY() + r * Math.cos(Math.toRadians(t+180)));
		vertices[6].setZ(400);

		vertices[7].setX(center.getX() + r * Math.sin(Math.toRadians(t+270)));
		vertices[7].setY(center.getY() + r * Math.cos(Math.toRadians(t+270)));
		vertices[7].setZ(400);
//		for(coordinate p: vertices) {
//			p.project();
//		}
			
		
	}
	public void changeVertice(int x, coordinate newCoord) {
//		if(x < 0 || x >= vertices.length) {
//			return;
//		}
		vertices[x] = newCoord;
		
	}
	
	public void setVertices(coordinate[] vertices) {
		this.vertices = vertices;
	}
	
	public void draw(Graphics2D g) {
		for(coordinate p: vertices) {
			p.project();
			if(p.isSelected()) {
				g.setColor(Color.ORANGE);
			}
			g.fill(p.getHitbox());
			g.setColor(Color.BLACK);
			for(int i = 0; i < p.getConnected().size(); i++) {
				g.drawLine((int)p.getProjected().getX(), (int)p.getProjected().getY(), (int)p.getConnected().get(i).getProjected().getX(), (int)p.getConnected().get(i).getProjected().getY());
			}
		}
	}
	
}
