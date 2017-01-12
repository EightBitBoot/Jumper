package jumper.game;

import jumper.animators.AnimationThread;
import jumper.animators.CreditAnimator;
import jumper.animators.EasterEggAnimator;
import jumper.listiners.WindowPauseListener;
import jumper.main.Window;
import jumper.menus.Credits;
import jumper.menus.EasterEgg;
import jumper.menus.LostMenu;
import jumper.menus.MainMenu;
import jumper.menus.PauseMenu;

public class Game {
	public static GameField GameField;
	static Window GameWindow;
	public static Thread GameAnimator;
	public static Thread EasterEggAnimator;
	public static Thread CreditAnimator;
	public static WindowPauseListener WindowPauseListener;
	static MainMenu MainMenu;
	static EasterEgg EasterEgg;
	static Credits Credits;

	public Game() {
		MainMenu = new MainMenu();
		WindowPauseListener = new WindowPauseListener();

		GameWindow = new Window("Jumper");
		GameWindow.getContentPane().add(MainMenu);
	}

	public static void start() {
		GameField = new GameField();

		GameWindow.addWindowListener(WindowPauseListener);

		GameWindow.getContentPane().removeAll();
		GameWindow.getContentPane().add(GameField);

		GameAnimator = new AnimationThread(GameWindow);
		GameAnimator.start();

		GameWindow.revalidate();
		GameWindow.repaint();
	}

	public static void pause() {
		GameAnimator.suspend();

		GameWindow.getContentPane().removeAll();
		GameWindow.getContentPane().add(new PauseMenu());

		GameWindow.revalidate();
		GameWindow.repaint();
	}

	public static void loose() {
		GameAnimator.suspend();

		GameWindow.getContentPane().removeAll();
		GameWindow.getContentPane().add(new LostMenu());

		GameWindow.revalidate();
		GameWindow.repaint();
	}

	public static void resume() {
		GameField.Player.speed_x = 0;

		GameWindow.getContentPane().removeAll();
		GameWindow.getContentPane().add(GameField);

		GameAnimator.resume();

		GameWindow.revalidate();
		GameWindow.repaint();
	}

	public static void quit() {
		MainMenu = new MainMenu();
		if (GameAnimator != null) {
			GameAnimator.suspend();
		}
		if (EasterEggAnimator != null) {
			EasterEggAnimator.stop();
		}
		if (CreditAnimator != null) {
			CreditAnimator.suspend();
		}
		GameWindow.getContentPane().removeAll();
		GameWindow.getContentPane().add(new MainMenu());

		GameWindow.revalidate();
		GameWindow.repaint();
	}

	public static void showCredits() {
		Credits = new Credits();
		CreditAnimator = new CreditAnimator(GameWindow, Credits);

		CreditAnimator.start();

		GameWindow.getContentPane().removeAll();
		GameWindow.getContentPane().add(Credits);

		GameWindow.revalidate();
		GameWindow.repaint();
	}

	public static void easterEggEnable() {
		EasterEgg = new EasterEgg();

		EasterEggAnimator = new EasterEggAnimator(EasterEgg, GameWindow);
		EasterEggAnimator.start();

		GameWindow.getContentPane().removeAll();
		GameWindow.getContentPane().add(EasterEgg);

		GameWindow.revalidate();
		GameWindow.repaint();
	}
}