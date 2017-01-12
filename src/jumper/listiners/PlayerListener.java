package jumper.listiners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import jumper.game.GameField;

public class PlayerListener implements KeyListener {
	public void keyPressed(KeyEvent e) {
		if ((e.getKeyCode() == 32) && (!GameField.Player.jumped)) {
			GameField.Player.jump();
		}
		if (e.getKeyCode() == 37) {
			GameField.Player.speed_x = -4;
		}
		if (e.getKeyCode() == 39) {
			GameField.Player.speed_x = 4;
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 37) {
			GameField.Player.speed_x = 0;
		}
		if (e.getKeyCode() == 39) {
			GameField.Player.speed_x = 0;
		}
	}

	public void keyTyped(KeyEvent arg0) {
	}
}