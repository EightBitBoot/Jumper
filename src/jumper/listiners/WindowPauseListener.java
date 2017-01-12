package jumper.listiners;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import jumper.game.Game;
import jumper.game.GameField;

public class WindowPauseListener implements WindowListener {
	public void windowDeactivated(WindowEvent e) {
		if (e.getOppositeWindow() == null) {
			Game.GameAnimator.suspend();
			GameField.Player.speed_x = 0;
		}
	}

	public void windowActivated(WindowEvent e) {
		Game.GameAnimator.resume();
	}

	public void windowIconified(WindowEvent e) {
		Game.GameAnimator.suspend();
		GameField.Player.speed_x = 0;
	}

	public void windowDeiconified(WindowEvent e) {
		Game.GameAnimator.resume();
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
	}
}