package jumper.listiners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import jumper.game.Game;

public class PauseListener implements KeyListener {
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 27) {
			Game.pause();
		}
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}
}