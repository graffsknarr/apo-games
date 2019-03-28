package net.apogames.apohybrid.highscore;

import java.util.ArrayList;

import net.apogames.apohybrid.game.ApoHybridPanel;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
import net.gliblybits.bitsengine.utils.BitsLog;

public class ApoHybridHighscore {
	
	private ArrayList<Integer> sortByHighscore;
	
	private ApoHybridHighscoreLoad userlevels;
	
	protected final ApoHybridPanel game;
	
	private boolean bReturn = false;
	
	public ApoHybridHighscore(final ApoHybridPanel game) {
		this.game = game;
		this.sortByHighscore = new ArrayList<Integer>();
	}
	
	public void loadHighscore() {
		try {
			this.userlevels = ApoHybridHighscoreLoad.getInstance();
			this.userlevels.load();
			
			if (this.userlevels.getPoints().size() > 0) {
				this.sortByPoints();
				
				this.game.setUserlevelsVisible();
			}
		} catch (Exception ex) {
			this.sortByHighscore = new ArrayList<Integer>();
			BitsLog.d("editor", "Exception ex: "+ex.getMessage());
		}
	}
	
	private void sortByPoints() {
		this.sortByHighscore.clear();
		this.sortByHighscore.add(0);
		for (int i = 1; i < this.userlevels.getPoints().size(); i++) {
			float points = this.userlevels.getPoints().get(i);
			boolean bAdd = false;
			for (int k = 0; k < this.sortByHighscore.size(); k++) {
				float sortPoints = this.userlevels.getPoints().get(this.sortByHighscore.get(k));
				if (points > sortPoints) {
					this.sortByHighscore.add(k, i);
					bAdd = true;
					break;
				}
			}
			if (!bAdd) {
				this.sortByHighscore.add(i);
			}
		}
	}

	public ArrayList<Integer> getSortByUpload() {
		return this.sortByHighscore;
	}
	
	public boolean saveHighscore(final String name, final int points, final int clocks) {
		if ((this.userlevels.getPoints().size() <= 5) || (this.userlevels.getPoints().get(this.sortByHighscore.get(4)) < points)) {
			this.userlevels.getPoints().add(points);
			this.userlevels.getClocks().add(clocks);
			this.userlevels.getNames().add(name);
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					ApoHybridHighscore.this.bReturn = ApoHybridHighscoreLoad.getInstance().save(name, points, clocks);
				}
	 		});
	 		t.start();
	 		this.sortByPoints();
		}
		return this.bReturn;
	}
	
	public void drawHighscore(final BitsGLGraphics g) {
		if ((this.userlevels != null) && (this.userlevels.getPoints().size() > 0)) {
			g.setColor(128f/255f, 128f/255f, 128f/255f, 1.0f);
			g.fillRect(10, 190, 220, 240);
			
			g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
			g.drawRect(10, 190, 220, 240);
			
			String s = "online";
			this.game.drawString(g, s, (int)(120 - ApoHybridPanel.font.getLength(s)/2), 195, ApoHybridPanel.font);
			this.game.drawString(g, "name", 20, 225, ApoHybridPanel.font);
			this.game.drawString(g, "points", 160, 225, ApoHybridPanel.font);
			for (int i = 0; i < 5 && i < this.userlevels.getPoints().size() && i < this.sortByHighscore.size(); i++) {
				this.game.drawString(g, (i+1) + " " + this.userlevels.getNames().get(this.sortByHighscore.get(i)), 15, 270 + 30 * i, ApoHybridPanel.game_font);
				s = String.valueOf(this.userlevels.getPoints().get(this.sortByHighscore.get(i)));
				this.game.drawString(g, s, (int)(220 - ApoHybridPanel.font.getLength(s)), 270 + 30 * i, ApoHybridPanel.font);
			}
		}
	}
}
