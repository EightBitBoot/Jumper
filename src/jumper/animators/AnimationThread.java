package jumper.animators;

import javax.swing.JFrame;

public class AnimationThread extends Thread {
	JFrame J;

	public AnimationThread(JFrame J) {
		this.J = J;
	}

	public void run() {
		for (;;) {
			this.J.repaint();
			try {
				Thread.sleep(20L);
			} catch (InterruptedException localInterruptedException) {}
		}
	}
}