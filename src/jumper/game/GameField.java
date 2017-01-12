package jumper.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;

import jumper.listiners.PauseListener;
import jumper.listiners.PlayerListener;
import jumper.objects.ObstacleSquare;
import jumper.objects.Player;

public class GameField extends JComponent {
	private ArrayList<ObstacleSquare> SquareObstacles;
	public static Player Player;
	private int timing;
	private int timing_check_square;
	private int timing_check_immunity;
	private int delay;
	int hearts;
	public int points;
	int immunity_counter;
	int timing_check_score;
	boolean immunity;
	Random random_number_generator;

	public GameField() {
		setOpaque(true);
		setBackground(Color.white);
		addKeyListener(new PlayerListener());
		addKeyListener(new PauseListener());
		setFocusable(true);

		Player = new Player();
		this.random_number_generator = new Random();
		this.SquareObstacles = new ArrayList();
		this.timing = 0;
		this.timing_check_square = 0;
		this.delay = 40;
		this.hearts = 4;
		this.immunity = false;
		this.immunity_counter = 250;
		this.timing_check_score = 0;
		this.points = 0;
	}

	public void paint(Graphics g) {
		requestFocusInWindow();

		this.timing += 1;

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Shape ground = new Line2D.Float(0.0F, 325.0F, 500.0F, 325.0F);
		g2.setColor(Color.BLACK);
		g2.draw(ground);
		if ((Player.getY() == 174) && (Player.jump_up)) {
			Player.jump_stage = 2;
		}
		if ((Player.getY() == 172) && (Player.jump_up)) {
			Player.jump_stage = 3;
		}
		if (Player.getY() == 170) {
			Player.jump_stage = 4;
			Player.jump_up = false;
		}
		if (Player.getY() == 172) {
			Player.jump_stage = 5;
		}
		if (Player.getY() == 174) {
			Player.jump_stage = 6;
		}
		if (Player.jump_stage == 1) {
			Player.speed_y = -5;
		}
		if (Player.jump_stage == 2) {
			Player.speed_y = -2;
		}
		if (Player.jump_stage == 3) {
			Player.speed_y = -1;
		}
		if (Player.jump_stage == 4) {
			Player.speed_y = 1;
		}
		if (Player.jump_stage == 5) {
			Player.speed_y = 2;
		}
		if (Player.jump_stage == 6) {
			Player.speed_y = 5;
		}
		Player.move();
		if (Player.getY() == 259) {
			Player.jump_stage = 0;
			Player.speed_y = 0;
			Player.jumped = false;
		}
		Shape player_hit_box = new Rectangle2D.Float(Player.getX() + 3, Player.getY() + 3, Player.getImage().getWidth(null) - 6, Player.getImage().getHeight(null) - 6);

		g.drawImage(Player.getImage(), Player.getX(), Player.getY(), this);
		if (this.timing_check_square + this.delay == this.timing) {
			int new_square = this.random_number_generator.nextInt(2);
			this.timing_check_square = this.timing;
			if (new_square == 1) {
				this.SquareObstacles.add(new ObstacleSquare(30, -3));
			}
		}
		for (int i = 0; i < this.SquareObstacles.size(); i++) {
			ObstacleSquare current = (ObstacleSquare) this.SquareObstacles.get(i);
			current.move();
			if ((!this.immunity) && (player_hit_box.intersects(current))) {
				if ((this.points > 0) && (this.hearts != 1)) {
					this.points -= 10;
				}
				this.hearts -= 1;
				if (this.hearts == 0) {
					Game.loose();
				}
				this.immunity = true;
				this.timing_check_immunity = this.timing;
			}
			if (this.timing_check_immunity + 250 == this.timing) {
				this.immunity = false;
				this.immunity_counter = 250;
			}
			if (this.immunity) {
				g2.setColor(Color.BLACK);
				g2.drawString("Invincibility:", 10, 65);

				g2.setColor(Color.BLUE);
				g2.fill(new Rectangle2D.Float(10.0F, 70.0F, this.timing_check_immunity + 250 - this.timing, 25.0F));
			}
			g2.setColor(Color.BLACK);
			g2.fill(current);
		}
		switch (this.hearts) {
		case 1:
			g.drawImage(Toolkit.getDefaultToolkit().getImage(GameField.class.getResource("8-bit-heart.png")), 20, 10, this);
			break;
		case 2:
			g.drawImage(Toolkit.getDefaultToolkit().getImage(GameField.class.getResource("8-bit-heart.png")), 20, 10, this);
			g.drawImage(Toolkit.getDefaultToolkit().getImage(GameField.class.getResource("8-bit-heart.png")), 60, 10, this);
			break;
		case 3:
			g.drawImage(Toolkit.getDefaultToolkit().getImage(GameField.class.getResource("8-bit-heart.png")), 20, 10, this);
			g.drawImage(Toolkit.getDefaultToolkit().getImage(GameField.class.getResource("8-bit-heart.png")), 60, 10, this);
			g.drawImage(Toolkit.getDefaultToolkit().getImage(GameField.class.getResource("8-bit-heart.png")), 100, 10, this);
			break;
		case 4:
			g.drawImage(Toolkit.getDefaultToolkit().getImage(GameField.class.getResource("8-bit-heart.png")), 20, 10, this);
			g.drawImage(Toolkit.getDefaultToolkit().getImage(GameField.class.getResource("8-bit-heart.png")), 60, 10, this);
			g.drawImage(Toolkit.getDefaultToolkit().getImage(GameField.class.getResource("8-bit-heart.png")), 100, 10, this);
			g.drawImage(Toolkit.getDefaultToolkit().getImage(GameField.class.getResource("8-bit-heart.png")), 140, 10, this);
		}
		if (this.timing_check_score + 50 == this.timing) {
			this.timing_check_score = this.timing;
			this.points += 1;
		}
		if (this.points < 0) {
			this.points = 0;
		}
		g2.drawString("Points: " + Integer.toString(this.points), 400, 30);
	}
}