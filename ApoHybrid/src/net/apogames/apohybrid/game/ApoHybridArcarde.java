package net.apogames.apohybrid.game;

import net.apogames.apohybrid.ApoHybridConstants;
import net.apogames.apohybrid.ApoHybridModel;
import net.apogames.apohybrid.highscore.ApoHybridHighscore;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
import net.gliblybits.bitsengine.input.BitsInput;
import net.gliblybits.bitsengine.input.BitsKeyEvent;

public class ApoHybridArcarde extends ApoHybridModel {

	public static final String BACK = "back";
	public static final String START = "start";
	public static final String TITLE = "ApoHybrid - Aracarde";
	public static final String POINTS = "Points";
	
	private int points = -1;
	
	private ApoHybridHighscore highscore;
	
	private int textX = 0;
	
	public ApoHybridArcarde(ApoHybridPanel game) {
		super(game);
	}

	@Override
	public void init() {
		this.getStringWidth().put(ApoHybridArcarde.BACK, (int)(ApoHybridPanel.font.getLength(ApoHybridArcarde.BACK)));
		this.getStringWidth().put(ApoHybridArcarde.START, (int)(ApoHybridPanel.font.getLength(ApoHybridArcarde.START)));
		this.getStringWidth().put(ApoHybridArcarde.TITLE, (int)(ApoHybridPanel.title_font.getLength(ApoHybridArcarde.TITLE)));
		this.getStringWidth().put(ApoHybridArcarde.POINTS, (int)(ApoHybridPanel.title_font.getLength(ApoHybridArcarde.POINTS)));
		
		String s = "Name: ";
		this.textX = (int)(85 + ApoHybridPanel.game_font.getLength(s));
		
		if (this.highscore == null) {
			this.highscore = new ApoHybridHighscore(this.getGame());
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					ApoHybridArcarde.this.highscore.loadHighscore();
				}
	 		});
	 		t.start();
		}
	}

	public ApoHybridHighscore getHighscore() {
		return this.highscore;
	}

	@Override
	public void touchedPressed(int x, int y, int finger) {
		if ((x > this.textX) && (x < this.textX + this.getGame().getTextfield().getWidth()) &&
			(y > ApoHybridConstants.GAME_HEIGHT - 45) && (y < ApoHybridConstants.GAME_HEIGHT - 45 + this.getGame().getTextfield().getHeight())) {
			if (!this.getGame().getTextfield().isSelect()) {
				this.getGame().getTextfield().setSelect(true);
				BitsInput.getInstance().setVirtualKeyboardVisible(true);
			}
		} else {
			if (this.getGame().getTextfield().isSelect()) {
				BitsInput.getInstance().setVirtualKeyboardVisible(false);
				this.getGame().savePreferences();
			}
			this.getGame().getTextfield().setSelect(false);
		}
	}

	@Override
	public void touchedReleased(int x, int y, int finger) {
		
	}

	@Override
	public void touchedDragged(int x, int y, int oldX, int oldY, int finger) {
		
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(final int points, final int clocks) {
		if (points > 0) {
			this.highscore.saveHighscore(this.getGame().getTextfield().getCurString(), points, clocks);
			this.getGame().getLocal().addNextValues(points, clocks);
			this.getGame().savePreferences();
		}
		this.points = points;
	}

	@Override
	public void touchedButton(String function) {
		if (function.equals(ApoHybridArcarde.BACK)) {
			this.onBackButtonPressed();
		} else if (function.equals(ApoHybridArcarde.START)) {
			this.getGame().setAracardeGame();
		}
	}
	
	public void onKeyDown(final int key) {
	}

	public void onKeyUp(final int key, final BitsKeyEvent event) {
	}
	
	public void onBackButtonPressed() {
		this.getGame().setMenu();
	}

	@Override
	public void think(int delta) {
		
	}

	@Override
	public void render(BitsGLGraphics g) {
		this.getGame().drawString(g, ApoHybridArcarde.TITLE, 240, 2, ApoHybridPanel.title_font, new float[] {1, 1, 1, 1}, new float[] {0, 0, 0, 1});
		
		if (this.points >= 0) {
			g.setColor(128f/255f, 128f/255f, 128f/255f, 1.0f);
			g.fillRect(50, 70, 380, 100);
			
			g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
			g.drawRect(50, 70, 380, 100);
			
			this.getGame().drawString(g, "Points", 240, 70, ApoHybridPanel.title_font);
			String s = String.valueOf(this.points);
			this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.title_font.getLength(s)/2), 120, ApoHybridPanel.title_font);
		}
		
		g.setColor(128f/255f, 128f/255f, 128f/255f, 1.0f);
		g.fillRect(10, 450, 460, 105);
		
		g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
		g.drawRect(10, 450, 460, 105);
		
		this.getGame().drawString(g, "In the arcarde mode a new clock will", 20, 455, ApoHybridPanel.font);
		this.getGame().drawString(g, "appear after starting from another.", 20, 485, ApoHybridPanel.font);
		this.getGame().drawString(g, "Reach the highscore and be the best.", 20, 515, ApoHybridPanel.font);
		
		if (this.highscore != null) {
			this.highscore.drawHighscore(g);
		}
		if (this.getGame().getLocal() != null) {
			this.getGame().getLocal().drawHighscore(g);
		}
		
		this.getGame().renderButtons(g);
		
		g.setColor(0.0f, 0.0f, 0.0f, 1.0f);
		String s = "Name: ";
		g.drawText(s, 85, ApoHybridConstants.GAME_HEIGHT - 42);
		this.getGame().getTextfield().render(g, this.textX, ApoHybridConstants.GAME_HEIGHT - 45);
	}

}
