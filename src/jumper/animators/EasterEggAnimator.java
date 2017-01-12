package jumper.animators;

import javax.swing.JFrame;

import jumper.menus.EasterEgg;

public class EasterEggAnimator extends Thread {
	EasterEgg E;
	JFrame J;

	public EasterEggAnimator(EasterEgg E, JFrame J) {
		this.E = E;
		this.J = J;
	}

	public void run() {
		for (;;) {
			this.E.recolor();
			this.J.repaint();
		}
	}
}