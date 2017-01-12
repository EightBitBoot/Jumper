package jumper.menus;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jumper.listiners.MainMenuListener;
import jumper.listiners.ResumeListener;

public class PauseMenu extends JPanel {
	public PauseMenu() {
		JLabel paused_label = new JLabel("PAUSED");
		Font pause_font = new Font("Jokerman", 1, 110);
		JButton resume_button = new JButton("RESUME");
		JButton menu_button = new JButton("Main Menu");

		setLayout(new BoxLayout(this, 1));
		setOpaque(true);
		setFocusable(true);
		setBackground(Color.white);

		paused_label.setFont(pause_font);
		paused_label.setAlignmentX(0.5F);

		resume_button.addActionListener(new ResumeListener());
		resume_button.setForeground(Color.green);
		resume_button.setRolloverEnabled(false);
		resume_button.setBorderPainted(false);
		resume_button.setContentAreaFilled(false);
		resume_button.setFont(new Font("Monospaced", 0, 50));
		resume_button.setAlignmentX(0.5F);

		menu_button.addActionListener(new MainMenuListener());
		menu_button.setForeground(Color.green);
		menu_button.setRolloverEnabled(false);
		menu_button.setBorderPainted(false);
		menu_button.setContentAreaFilled(false);
		menu_button.setFont(new Font("Monospaced", 0, 50));
		menu_button.setAlignmentX(0.5F);

		add(paused_label);
		add(resume_button);
		add(menu_button);
	}
}