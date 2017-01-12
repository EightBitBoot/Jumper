package jumper.main;

import java.awt.Color;

import javax.swing.JFrame;

public class Window extends JFrame {
	public Window(String Title) {
		setSize(500, 400);
		setDefaultCloseOperation(3);
		setTitle(Title);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(Color.white);
	}
}