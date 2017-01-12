package jumper.listiners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jumper.game.Game;

public class MainMenuListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Game.quit();
	}
}