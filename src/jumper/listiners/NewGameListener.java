package jumper.listiners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jumper.game.Game;

public class NewGameListener implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		Game.start();
	}
}