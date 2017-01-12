package jumper.menus;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jumper.listiners.MainMenuListener;

public class Credits extends JPanel {
	int maker_x;
	int made_x;
	int back_x;
	int nothing_more_x;
	int i_mean_it_x;
	int your_way_x;
	JLabel maker;
	JLabel made;
	JLabel nothing_more;
	JLabel i_mean_it;
	JLabel your_way;
	JButton back;

	public Credits() {
		this.maker_x = 500;
		this.made_x = 1000;
		this.nothing_more_x = 2000;
		this.i_mean_it_x = 2500;
		this.your_way_x = 3000;

		this.back_x = 1070;

		this.maker = new JLabel("Made, Coded, and Desgined by: Adin");
		this.made = new JLabel("I MADE THIS FOR YOU!");
		this.back = new JButton("Back");
		this.nothing_more = new JLabel("Seriously There Is Nothing More Go Back");
		this.i_mean_it = new JLabel("I Mean It Go Back");
		this.your_way = new JLabel("Fine Have It Your Way, But There Is Nothing Else");

		setLayout(null);
		setOpaque(true);
		setBackground(Color.white);

		this.i_mean_it.setFont(new Font("Jokerman", 0, 50));
		this.i_mean_it.setForeground(Color.red);

		this.your_way.setFont(new Font("Jokerman", 0, 20));
		this.your_way.setForeground(Color.red);

		this.nothing_more.setFont(new Font("Jokerman", 0, 22));
		this.nothing_more.setForeground(Color.red);

		this.maker.setFont(new Font("Jokerman", 0, 25));
		this.maker.setForeground(Color.red);

		this.made.setFont(new Font("Jokerman", 1, 39));
		this.made.setForeground(Color.red);

		this.back.addActionListener(new MainMenuListener());
		this.back.setForeground(Color.green);
		this.back.setRolloverEnabled(false);
		this.back.setBorderPainted(false);
		this.back.setContentAreaFilled(false);
		this.back.setFont(new Font("Monospaced", 0, 50));

		add(this.maker);
		add(this.made);
		add(this.back);
		add(this.nothing_more);
		add(this.i_mean_it);
		add(this.your_way);
	}

	public void moveText() {
		this.maker.setBounds(7, this.maker_x, 500, 37);
		this.made.setBounds(7, this.made_x, 500, 65);
		this.nothing_more.setBounds(7, this.nothing_more_x, 500, 65);
		this.i_mean_it.setBounds(7, this.i_mean_it_x, 500, 65);
		this.your_way.setBounds(7, this.your_way_x, 500, 65);

		this.back.setBounds(150, this.back_x, 200, 100);

		this.nothing_more_x -= 1;
		this.maker_x -= 1;
		this.made_x -= 1;
		this.i_mean_it_x -= 1;
		this.your_way_x -= 1;
		if (this.back_x != 280) {
			this.back_x -= 1;
		}
	}
}