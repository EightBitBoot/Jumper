package jumper.listiners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jumper.game.Game;

public class ResumeListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Game.resume();
	}
}