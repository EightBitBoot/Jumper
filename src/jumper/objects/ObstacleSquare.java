package jumper.objects;

import java.awt.geom.Rectangle2D;

public class ObstacleSquare extends Rectangle2D.Float {
	public int speed;
	private int size;
	public boolean visible;

	public ObstacleSquare(int size, int speed) {
		super(500.0F, 325 - size + 1, size, size);
		this.size = size;
		this.speed = speed;
		this.visible = true;
	}

	public void move() {
		this.x += this.speed;
	}
}