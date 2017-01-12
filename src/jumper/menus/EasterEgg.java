package jumper.menus;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jumper.listiners.MainMenuListener;

public class EasterEgg extends JPanel {
	int color_number;
	JLabel thx;
	boolean increasing;

	public EasterEgg() {
		this.color_number = 0;
		this.increasing = true;

		ImageIcon ii = new ImageIcon(EasterEgg.class.getResource("EasterEggPicture.jpg"));
		JLabel picture = new JLabel(ii);
		this.thx = new JLabel("THIS ONE'S FOR YOU MATT");
		JButton back = new JButton("Back");

		setLayout(new BoxLayout(this, 1));
		setOpaque(true);
		setBackground(Color.white);

		picture.setAlignmentX(0.5F);

		this.thx.setAlignmentX(0.5F);
		this.thx.setFont(new Font("Jokerman", 1, 30));
		this.thx.setForeground(Color.orange);

		back.setAlignmentX(0.5F);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setRolloverEnabled(false);
		back.setForeground(Color.green);
		back.setFont(new Font("Monospaced", 0, 50));
		back.addActionListener(new MainMenuListener());

		add(picture);
		add(this.thx);
		add(back);
	}

	public void recolor() {
		if (this.increasing) {
			if (this.color_number == 16777215) {
				this.increasing = false;
			}
			Color c = new Color(this.color_number);
			this.thx.setForeground(c);
			this.color_number += 1;
		}
		if (!this.increasing) {
			if (this.color_number == 0) {
				this.increasing = true;
			}
			Color c = new Color(this.color_number);
			this.thx.setForeground(c);
			this.color_number -= 1;
		}
	}
}