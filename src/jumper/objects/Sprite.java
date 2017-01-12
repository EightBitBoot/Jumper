package jumper.objects;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class Sprite {
	protected int x;
	protected int y;
	public int speed_x;
	public int speed_y;
	public int init_y;
	public int init_x;
	String image_name;
	Image sprite_image;
	URL image_url;

	public Sprite(int init_x, int init_y, int init_speed_x, int init_speed_y, String image_name) {
		this.x = init_x;
		this.y = init_y;
		this.speed_x = init_speed_x;
		this.speed_y = init_speed_y;
		this.image_name = image_name;
		this.init_x = init_x;
		this.init_y = init_y;

		this.image_url = Sprite.class.getResource(image_name);
		this.sprite_image = Toolkit.getDefaultToolkit().getImage(this.image_url);
	}

	public Image getImage() {
		return this.sprite_image;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void move() {
		this.x += this.speed_x;
		this.y += this.speed_y;
	}
}