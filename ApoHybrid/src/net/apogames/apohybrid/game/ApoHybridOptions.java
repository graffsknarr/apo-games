//#if ClockGameLogic
package net.apogames.apohybrid.game;

import net.apogames.apohybrid.ApoHybridModel;
import net.apogames.apohybrid.ApoHybridConstants;

import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
import net.gliblybits.bitsengine.input.BitsInput;
import net.gliblybits.bitsengine.input.BitsKeyEvent;

public class ApoHybridOptions extends ApoHybridModel {

	public static final String BACK = "back";
	public static final String TITLE = "ApoHybrid - Options";
	public static final String LANGUAGE_GERMAN = "german";
	public static final String LANGUAGE_ENGLISH = "english";
	public static final String MUSIC = "music";
	public static final String COLOR_WHITE = "white";
	public static final String COLOR_GREEN = "green";
	public static final String SOUND = "sound";


	public ApoHybridOptions(ApoHybridPanel game) {
		super(game);
	}

	public void init() { }

	@Override
	public void touchedButton(String function) {
		if (function.equals(ApoHybridOptions.BACK)) {
			this.onBackButtonPressed();
		}
		else if (function.equals(ApoHybridOptions.LANGUAGE_ENGLISH)) {

		}
		else if (function.equals(ApoHybridOptions.LANGUAGE_GERMAN)) {

		}
		else if (function.equals(ApoHybridOptions.MUSIC)) {

		}

	}

	public void think(int i) {}

	@Override
	public void touchedPressed(int x, int y, int finger) {}

	@Override
	public void touchedReleased(int x, int y, int finger) { }

	@Override
	public void touchedDragged(int x, int y, int oldX, int oldY, int finger) { }

	public void onBackButtonPressed() {
		this.getGame().setMenu();
	}

	public void render(BitsGLGraphics g) {
		this.getGame().drawString(g, ApoHybridOptions.TITLE, 240, 2, ApoHybridPanel.title_font, new float[]{1, 1, 1, 1}, new float[]{0, 0, 0, 1});
		//this.getGame().drawString(g, ApoHybridConstants.OPTION_TITLE, (int)(240 - ApoHybridPanel.title_font.getLength(ApoHybridConstants.OPTION_TITLE)/2), 5 + 0, ApoHybridPanel.title_font);
	}

}