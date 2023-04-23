import java.util.ArrayList;
import java.awt.geom.Ellipse2D;

public class coordinate {
	private double x, y, z;
	private coordinate eyePos;
	private point projected;
	private ArrayList<coordinate> connected = new ArrayList<coordinate>();
	private boolean isSelected = false;
	private Ellipse2D hitbox;
	
	public coordinate(int x, int y, int z, coordinate eyePos) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.eyePos = eyePos;
		project();
		hitbox = new Ellipse2D.Double(this.x, this.y, 3, 3);
	}
	
	public coordinate(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void project() {
		point projCoord = new point(0,0);
		double t = 0;
		t = -eyePos.getX()/(x-eyePos.getX());
		projCoord.setX((500+ (y-eyePos.getY())*t));
		projCoord.setY((350+ (z-eyePos.getZ())*t));
		projected = projCoord;
		hitbox = new Ellipse2D.Double(projected.getX()-3, projected.getY()-3, 6, 6);
	}
	
	public void addCoord(coordinate c) {
		this.x += c.getX();
		this.y += c.getY();
		this.z += c.getZ();
	}
	
	public void setConnected(coordinate c) {
		c.project();
		connected.add(c);
	}
	
	public void removeConnected(coordinate c) {
		connected.remove(c);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public void setPos(coordinate pos) {
		this.x = pos.getX();
		this.y = pos.getY();
		this.z = pos.getZ();
	}
	
	public coordinate getEyePos() {
		return eyePos;
	}

	public void setEyePos(coordinate eyePos) {
		this.eyePos = eyePos;
	}

	public point getProjected() {
		return projected;
	}

	public ArrayList<coordinate> getConnected() {
		return connected;
	}

	public void setConnected(ArrayList<coordinate> connected) {
		this.connected = connected;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public Ellipse2D getHitbox() {
		return hitbox;
	}

	public void setHitbox(Ellipse2D hitbox) {
		this.hitbox = hitbox;
	}
	
	
}
