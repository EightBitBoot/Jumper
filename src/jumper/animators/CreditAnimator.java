package jumper.animators;

import javax.swing.JFrame;

import jumper.menus.Credits;

public class CreditAnimator extends Thread {
	JFrame F;
	Credits C;

	public CreditAnimator(JFrame F, Credits C) {
		this.C = C;
		this.F = F;
	}

	public void run() {
		for (;;) {
			this.C.moveText();
			this.F.repaint();
			try {
				Thread.sleep(20L);
			} catch (InterruptedException localInterruptedException) {}
		}
	}
}