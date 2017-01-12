package jumper.objects;

public class Player extends Sprite {
	public boolean jump_up;
	public boolean jumped;
	public int jump_stage;

	public Player() {
		super(40, 259, 0, 0, "player.png");
		this.jump_stage = 0;
		this.jump_up = false;
	}

	public void jump() {
		this.jump_stage = 1;
		this.jump_up = true;
		this.jumped = true;
	}

	public void move() {
		if ((this.x + this.sprite_image.getWidth(null) == 492) && (this.speed_x > 0)) {
			this.speed_x = 0;
		}
		if ((this.x == 0) && (this.speed_x < 0)) {
			this.speed_x = 0;
		}
		this.x += this.speed_x;
		this.y += this.speed_y;
	}
}