package jumper.menus;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jumper.listiners.CreditsListener;
import jumper.listiners.EasterEggListener;
import jumper.listiners.NewGameListener;

public class MainMenu extends JPanel {
	public MainMenu() {
		JLabel name = new JLabel("Jumper");
		JButton new_game = new JButton("New Game");
		JButton credits = new JButton("Credits");
		JButton easter_egg = new JButton();

		setLayout(new BoxLayout(this, 1));
		setOpaque(true);
		setBackground(Color.white);

		name.setAlignmentX(0.5F);
		name.setFont(new Font("Jokerman", 1, 110));
		name.setAlignmentX(0.5F);
		name.setForeground(Color.magenta);

		new_game.setAlignmentX(0.5F);
		new_game.setBorderPainted(false);
		new_game.setContentAreaFilled(false);
		new_game.setRolloverEnabled(false);
		new_game.setFocusable(false);
		new_game.addActionListener(new NewGameListener());
		new_game.setFont(new Font("Monospaced", 0, 50));
		new_game.setForeground(Color.green);

		credits.setAlignmentX(0.5F);
		credits.setBorderPainted(false);
		credits.setContentAreaFilled(false);
		credits.setRolloverEnabled(false);
		credits.setFocusable(false);
		credits.addActionListener(new CreditsListener());
		credits.setFont(new Font("Monospaced", 0, 50));
		credits.setForeground(Color.green);

		easter_egg.setAlignmentX(0.5F);
		easter_egg.setBorderPainted(false);
		easter_egg.setContentAreaFilled(false);
		easter_egg.setRolloverEnabled(false);
		easter_egg.setFocusable(false);
		easter_egg.addActionListener(new EasterEggListener());

		add(name);
		add(new_game);
		add(credits);
		add(easter_egg);
	}
}