package net.apogames.apohybrid;

import java.util.HashMap;
import java.util.Map;

import net.apogames.apohybrid.game.ApoHybridPanel;
import net.gliblybits.bitsengine.render.BitsGraphics;

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
	
	//#if DiceGameLogic
	public void onKeyDown(final int key) {
	}

	public void onKeyUp(final int key) {
	}
	//#endif
	
	public void onBackButtonPressed() {	
	}
	
	public void onPause() {
	}

	public void onResume() {		
	}
	
	public abstract void think(int delta);
	
	public abstract void render(BitsGraphics g);
	
	public void drawOverlay(BitsGraphics g) {
	}
	
}
