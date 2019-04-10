package net.apogames.apohybrid;

import java.util.HashMap;
import java.util.Map;

import net.apogames.apohybrid.game.ApoHybridPanel;

//#if ClockGameLogic
import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
import net.gliblybits.bitsengine.input.BitsKeyEvent;
//#elif MonoGameLogic
import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//#else
//@import net.gliblybits.bitsengine.render.BitsGraphics;
//#endif

public abstract class ApoHybridModel {

	private ApoHybridPanel game;

	private final Map<String, Integer> stringWidth = new HashMap<String, Integer>();

	public ApoHybridModel(ApoHybridPanel game) {
		this.game = game;
	}

	public Map<String, Integer> getStringWidth() {
		return this.stringWidth;
	}

	public ApoHybridPanel getGame() {
		return this.game;
	}

	public abstract void init();

	public void close() {}

	public abstract void touchedPressed(int x, int y, int finger);

	public abstract void touchedReleased(int x, int y, int finger);

	public abstract void touchedDragged(int x, int y, int oldX, int oldY, int finger);

	public abstract void touchedButton(String function);

	//#if DiceGameLogic || MonoGameLogic
//@	public void onKeyDown(final int key) {
//@	}
//@
//@	public void onKeyUp(final int key) {
//@	}
	//#elif ClockGameLogic
	public void onKeyDown(final int key, final BitsKeyEvent event) {
	}

	public void onKeyUp(final int key, final BitsKeyEvent event) {
	}
	//#endif

	public void onBackButtonPressed() {
	}

	public void onPause() {
	}

	public void onResume() {
	}

	public abstract void think(int delta);

	//#if ClockGameLogic || MonoGameLogic
	public abstract void render(BitsGLGraphics g);

	public void drawOverlay(BitsGLGraphics g) {
	}

	//#else
//@	public abstract void render(BitsGraphics g);
//@
//@	public void drawOverlay(BitsGraphics g) {
//@	}
	//#endif

}