package jumper.menus;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jumper.game.Game;
import jumper.listiners.MainMenuListener;
import jumper.listiners.NewGameListener;

public class LostMenu extends JPanel {
	public LostMenu() {
		JLabel looser_label = new JLabel("YOU LOST");
		JLabel score = new JLabel("Score" + Integer.toString(Game.GameField.points));

		JButton new_game = new JButton("New Game");
		JButton main_menu = new JButton("Main Menu");

		setLayout(new BoxLayout(this, 1));
		setOpaque(true);
		setBackground(Color.white);

		looser_label.setFont(new Font("Jokerman", 1, 80));
		looser_label.setForeground(Color.red);
		looser_label.setAlignmentX(0.5F);

		score.setFont(new Font("Jokerman", 1, 30));
		score.setAlignmentX(0.5F);

		new_game.setAlignmentX(0.5F);
		new_game.setContentAreaFilled(false);
		new_game.setBorderPainted(false);
		new_game.setRolloverEnabled(false);
		new_game.setForeground(Color.green);
		new_game.setFont(new Font("Monospaced", 0, 50));
		new_game.addActionListener(new NewGameListener());

		main_menu.setAlignmentX(0.5F);
		main_menu.setContentAreaFilled(false);
		main_menu.setBorderPainted(false);
		main_menu.setRolloverEnabled(false);
		main_menu.setForeground(Color.green);
		main_menu.setFont(new Font("Monospaced", 0, 50));
		main_menu.addActionListener(new MainMenuListener());

		add(looser_label);
		add(score);
		add(new_game);
		add(main_menu);
	}
}