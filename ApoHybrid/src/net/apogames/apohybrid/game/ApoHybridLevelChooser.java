package net.apogames.apohybrid.game;

//#if !TreasureGameLogic
//#if ClockGameLogic
//@import net.apogames.apohybrid.ApoHybridModel;
//@import net.apogames.apohybrid.entity.ApoLevelChooserButton;
//@import net.apogames.apohybrid.level.ApoHybridLevel;
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//#elif SnakeGameLogic || DiceGameLogic
//@import net.apogames.apohybrid.ApoHybrid;
//@import net.apogames.apohybrid.ApoHybridModel;
//@import net.apogames.apohybrid.entity.ApoLevelChooserButton;
//@import net.apogames.apohybrid.level.ApoHybridLevel;
//@import net.gliblybits.bitsengine.render.BitsGraphics;
//#elif MonoGameLogic
//@import net.apogames.apohybrid.ApoHybridConstants;
//@import net.apogames.apohybrid.ApoHybridModel;
//@import net.apogames.apohybrid.ApoHybridSoundPlayer;
//@import net.apogames.apohybrid.entity.ApoLevelChooserButton;
//@import net.apogames.apohybrid.level.ApoHybridLevel;
//@import net.gliblybits.bitsengine.graphics.BitsGraphics;
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//#endif

public class ApoHybridLevelChooser extends ApoHybridModel {

	public static final String BACK = "back";
	public static final String LEVEL_CHOOSER = "ApoHybrid - LevelChooser";
	public static final int COUNT = 40;
	public static final String LEFT = "left";
	public static final String RIGHT = "right";
	
	private ApoLevelChooserButton[] levels;
	
	private int solved = 0;
	
	private int curShow = 0;

	private int curStart = 0;
	
	public int canStart = 1;
	
	public ApoHybridLevelChooser(ApoHybridPanel game) {
		super(game);
	}

	@Override
	public void init() {
		//#if ClockGameLogic
//@		this.getStringWidth().put(ApoHybridLevelChooser.BACK, (int)(ApoHybridPanel.font.getLength(ApoHybridLevelChooser.BACK)));
//@		this.getStringWidth().put(ApoHybridLevelChooser.LEVEL_CHOOSER, (int)(ApoHybridPanel.title_font.getLength(ApoHybridLevelChooser.LEVEL_CHOOSER)));
		//#elif SnakeGameLogic || DiceGameLogic		
//@		this.getStringWidth().put(ApoHybridLevelChooser.BACK, (int)(ApoHybridMenu.font.getLength(ApoHybridLevelChooser.BACK)));
//@		this.getStringWidth().put(ApoHybridLevelChooser.LEVEL_CHOOSER, (int)(ApoHybridMenu.title_font.getLength(ApoHybridLevelChooser.LEVEL_CHOOSER)));
		//#endif

		//#if MonoGameLogic
//@		this.changeCurStart(0);
//@		
//@		if (this.levels == null) {
//@			this.levels = new ApoLevelChooserButton[ApoHybridLevel.MAX_LEVELS];
//@			
//@			int xPos = 60;
//@			int yPos = ApoHybridGame.changeY + 45;
//@			int radius = 40;
//@			int add = 5;
//@			int curLevel = 0;
//@			for (int y = 0; y < 100; y++) {
//@				for (int x = 0; x < 8; x++) {
//@					this.levels[curLevel] = new ApoLevelChooserButton(xPos, yPos, radius, radius, String.valueOf(curLevel + 1), "");
//@					
//@					if (this.getGame().getSolvedLevels().isLevelSolved(curLevel)) {
//@						this.levels[curLevel].setSelected(true);
//@					}
//@					
//@					xPos += radius + add;
//@					curLevel += 1;
//@					if (curLevel >= this.levels.length) {
//@						break;
//@					}
//@				}
//@				xPos = 60;
//@				yPos += radius + add;
//@				if (curLevel >= this.levels.length) {
//@					break;
//@				}
//@				if (curLevel % ApoHybridLevelChooser.COUNT == 0) {
//@					yPos = ApoHybridGame.changeY + 45;
//@				}
//@			}
//@			this.canStart = this.getGame().getMaxCanChoosen();
//@		}
//@
		//#else
		this.curShow = 0;
		
		if (this.levels == null) {
			this.levels = new ApoLevelChooserButton[ApoHybridLevel.MAX_LEVELS];
			
			int xPos = 20;
			int yPos = 50;
			int radius = 70;
			int add = 20;
			int curLevel = 0;
			for (int y = 0; y < 6; y++) {
				for (int x = 0; x < 5; x++) {
					this.levels[curLevel] = new ApoLevelChooserButton(null, xPos, yPos, radius, radius, String.valueOf(curLevel + 1));
					
					xPos += radius + add;
					curLevel += 1;
					if (curLevel >= this.levels.length) {
						break;
					}
				}
				xPos = 20;
				yPos += radius + add;
				if (curLevel >= this.levels.length) {
					break;
				}
				if (curLevel % 30 == 0) {
					yPos = 70;
				}
			}
			this.setSolved(0);
		}
		//#endif
	}
	//#if MonoGameLogic
//@	public void solveLevel(int level) {
//@		if ((level >= 0) && (level < ApoHybridLevel.MAX_LEVELS)) {
//@			this.levels[level].setSelected(true);
//@		}
//@		
//@		this.canStart = this.getGame().getMaxCanChoosen();
//@	}
//@	
//@	public void onResume() {
//@	}
//@
//@	@Override
//@	public void touchedPressed(int x, int y, int finger) {
//@		if (this.levels != null) {
//@			for (int i = this.curStart; i < this.curStart + ApoHybridLevelChooser.COUNT && i < this.levels.length; i++) {
//@				if ((this.levels[i].intersects(x, y)) && (i <= this.canStart)) {
//@					this.getGame().setGame(i, "", false);
//@				}
//@			}
//@		}
//@	}
//@
	//#else

	public final int getSolved() {
		return this.solved;
	}

	public final void setSolved(int solved) {
		if (this.solved < solved) {
			this.solved = solved;
			if (this.solved > ApoHybridLevel.MAX_LEVELS - 1) {
				this.solved = ApoHybridLevel.MAX_LEVELS - 1;
			}
			if (this.solved < this.levels.length) {
				for (int i = 0; i < this.solved && i < this.levels.length; i++) {
					this.levels[i].setSolved(true);
				}
			}
			//#if ClockGameLogic
//@			this.getGame().savePreferences();
			//#elif SnakeGameLogic || DiceGameLogic
//@			this.getGame().savePreferences(ApoHybrid.settings);
			//#endif
		}
	}
	

	@Override
	public void touchedPressed(int x, int y, int finger) {
		if (this.levels != null) {
			for (int i = this.curShow; i < this.curShow + 64 && i < this.levels.length && i <= this.solved; i++) {
				if (this.levels[i].intersects(x, y)) {
					this.getGame().setGame(i, null, false);
				}
			}
		}
	}
	//#endif

	@Override
	public void touchedReleased(int x, int y, int finger) {
		
	}

	@Override
	public void touchedDragged(int x, int y, int oldX, int oldY, int finger) {
		
	}

	@Override
	public void touchedButton(String function) {
		if (function.equals(ApoHybridLevelChooser.BACK)) {
			this.onBackButtonPressed();
		//#if MonoGameLogic
//@		} else if (function.equals(ApoHybridLevelChooser.LEFT)) {
//@			this.changeCurStart(-ApoHybridLevelChooser.COUNT);
//@		} else if (function.equals(ApoHybridLevelChooser.RIGHT)) {
//@			this.changeCurStart(ApoHybridLevelChooser.COUNT);
//@		}
//@		this.getGame().playSound(ApoHybridSoundPlayer.SOUND_BUTTON_2);
		//#endif
	}
	
	//#if MonoGameLogic
//@	private void changeCurStart(int add) {
//@		this.curStart += add;
//@		if (this.curStart < 0) {
//@			this.curStart = 0;
//@		} else if (this.curStart >= ApoHybridLevel.MAX_LEVELS) {
//@			this.curStart -= add;
//@		}
//@		this.getGame().getButtons()[19].setVisible(true);
//@		if (this.curStart <= 0) {
//@			this.getGame().getButtons()[19].setVisible(false);
//@		}
//@		
//@		this.getGame().getButtons()[20].setVisible(true);
//@		if (this.curStart + ApoHybridLevelChooser.COUNT >= ApoHybridLevel.MAX_LEVELS) {
//@			this.getGame().getButtons()[20].setVisible(false);
//@		}
		//#endif
	}


	public void onBackButtonPressed() {
		//#if ClockGameLogic
//@		this.getGame().setPuzzle();
		//#elif SnakeGameLogic || DiceGameLogic || MonoGameLogic
//@		this.getGame().setMenu();
		//#endif

	}

	@Override
	public void think(int delta) {
		
	}

	@Override
	//#if ClockGameLogic
//@	public void render(BitsGLGraphics g) {
//@		this.getGame().drawString(g, ApoHybridLevelChooser.LEVEL_CHOOSER, 240, 2, ApoHybridPanel.title_font, new float[] {1, 1, 1, 1}, new float[] {0, 0, 0, 1});
//@	
	//#elif SnakeGameLogic || DiceGameLogic
//@	public void render(BitsGraphics g) {
//@		this.getGame().drawString(g, ApoHybridLevelChooser.LEVEL_CHOOSER, 240, 2, ApoHybridMenu.title_font, new float[] {1, 1, 1, 1}, new float[] {0, 0, 0, 1});
	//#endif


		//#if !MonoGameLogic

		this.getGame().renderButtons(g);
		if (this.levels != null) {
			for (int i = this.curShow; i < this.curShow + 64 && i < this.levels.length; i++) {
				int x = (int)(this.levels[i].getX());
				int y = (int)(this.levels[i].getY());
				int radius = (int)(this.levels[i].getWidth());
				
				g.setColor(255, 255, 255, 255);
				if (this.levels[i].isSolved()) {
					g.setColor(102, 135, 89, 255);
				} else if (this.solved < i) {
					g.setColor(128, 128, 128, 255);
				}

				//#if ApoMenu
				//#if DiceGameLogic
//@				g.drawFilledRoundRect(x, y, radius, radius, 6, 10);
//@
//@				g.setLineSize(2.5f);
//@				g.setColor(48, 48, 48);
//@				g.drawRoundRect(x, y, radius, radius, 6, 10);
//@
//@				if (this.solved == i) {
//@					this.getGame().drawString(g, this.levels[i].getFunction(), x + radius/2 - (int)ApoHybridMenu.font.getLength(this.levels[i].getFunction())/2, y + radius/2 - ApoHybridMenu.font.mCharCellHeight/2, ApoHybridMenu.font, new float[] {1, 1, 1, 1}, new float[] {0, 0, 0, 1});
//@				} else {
//@					this.getGame().drawString(g, this.levels[i].getFunction(), x + radius/2 - (int)ApoHybridMenu.font.getLength(this.levels[i].getFunction())/2, y + radius/2 - ApoHybridMenu.font.mCharCellHeight/2, ApoHybridMenu.font);
//@				}
				//#else
//@				g.fillCircle(x + radius/2, y + radius/2, radius/2, 120);
//@
//@				g.setLineSize(2.5f);
//@				g.setColor(48, 48, 48);
//@				g.drawCircle(x + radius/2, y + radius/2, radius/2, 120);
//@
//@				for (int j = 0; j < 12; j++) {
//@					g.drawLine(x + radius/2 + (int)((radius/2 - 5) * Math.sin(Math.toRadians(j * 30))), y + radius/2 + (int)(-(radius/2 - 5) * Math.cos(Math.toRadians(j * 30))), x + radius/2 + (int)((radius/2) * Math.sin(Math.toRadians(j * 30))), y + radius/2 + (int)(-(radius/2) * Math.cos(Math.toRadians(j * 30))));
//@				}
//@
//@				if (this.solved == i) {
//@					this.getGame().drawString(g, this.levels[i].getFunction(), x + radius/2 - (int)ApoHybridPanel.font.getLength(this.levels[i].getFunction())/2, y + radius/2 - ApoHybridPanel.font.mCharCellHeight/2, ApoHybridPanel.font, new float[] {1, 1, 1, 1}, new float[] {0, 0, 0, 1});
//@				} else {
//@					this.getGame().drawString(g, this.levels[i].getFunction(), x + radius/2 - (int)ApoHybridPanel.font.getLength(this.levels[i].getFunction())/2, y + radius/2 - ApoHybridPanel.font.mCharCellHeight/2, ApoHybridPanel.font);
//@				}
				//#endif
//@
				//#endif
				
				
				g.setLineSize(1.0f);
			}
		}
	}
	//#else
//@	public void render(final BitsGLGraphics g) {
//@		int addY = 15;
//@		if (ApoHybridConstants.FREE_VERSION) {
//@			addY += 36;
//@		}
//@		this.getGame().drawString(g, ApoHybridConstants.LEVELCHOOSER_TITLE, (int)(240 - ApoHybridPanel.title_font.getLength(ApoHybridConstants.LEVELCHOOSER_TITLE)/2), 5 + addY, ApoHybridPanel.title_font);
//@		
//@		if (this.levels != null) {
//@			for (int i = this.curStart; i < this.curStart + ApoHybridLevelChooser.COUNT && i < this.levels.length; i++) {
//@				int x = (int)(this.levels[i].getX());
//@				int y = (int)(this.levels[i].getY());
//@				int width = (int)(this.levels[i].getWidth());
//@				int height = (int)(this.levels[i].getHeight());
//@				String s = this.levels[i].getFunction();
//@				
//@				this.drawInputBox(g, x, y, width, height, this.levels[i].isSelected());
//@				
//@				if (i < this.canStart + 1) {
//@					if (this.levels[i].isSelected()) {
//@						this.getGame().drawString(g, s, (int)(x + width/2 - ApoHybridPanel.game_font.getLength(s)/2), y + height/2 - 1 - ApoHybridPanel.game_font.mCharCellHeight/2, ApoHybridPanel.game_font, ApoHybridConstants.GREEN);
//@					} else {
//@						this.getGame().drawString(g, s, (int)(x + width/2 - ApoHybridPanel.game_font.getLength(s)/2), y + height/2 - 1 - ApoHybridPanel.game_font.mCharCellHeight/2, ApoHybridPanel.game_font, ApoHybridConstants.BRIGHT_DARK);
//@					}
//@				} else {
//@					this.getGame().drawString(g, s, (int)(x + width/2 - ApoHybridPanel.game_font.getLength(s)/2), y + height/2 - 1 - ApoHybridPanel.game_font.mCharCellHeight/2, ApoHybridPanel.game_font, ApoHybridConstants.DARK_BRIGHT);
//@				}
//@			}
//@		}
//@		
//@		if (this.getGame().getButtons() != null) {
//@			for (int i = 0; i < this.getGame().getButtons().length; i++) {
//@				if (this.getGame().getButtons()[i].isBVisible()) {
//@					int x = (int)(this.getGame().getButtons()[i].getX());
//@					int y = (int)(this.getGame().getButtons()[i].getY());
//@					int width = (int)(this.getGame().getButtons()[i].getWidth());
//@					int height = (int)(this.getGame().getButtons()[i].getHeight());
//@					String s = this.getGame().getButtons()[i].getFunction();
//@					
//@					this.drawInputBox(g, x, y, width, height, false);
//@					if (s.equals(ApoHybridLevelChooser.LEFT)) {
//@						this.drawInputLeftBox(g, x, y);
//@					} else if (s.equals(ApoHybridLevelChooser.RIGHT)) {
//@						this.drawInputRightBox(g, x, y);
//@					} else if (s.equals(ApoHybridLevelChooser.BACK)) {
//@						this.getGame().drawString(g, s, (int)(x + width/2 - ApoHybridPanel.game_font.getLength(s)/2), y + height/2 - ApoHybridPanel.game_font.mCharCellHeight/2 - 1, ApoHybridPanel.game_font, ApoHybridConstants.BRIGHT);
//@					}
//@				}
//@			}
//@		}
//@		
//@	}
//@	
//@	private void drawInputBox(final BitsGraphics g, int x, int y, final int width, final int height, boolean bSolved) {
//@		g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
//@		g.fillRect(x + 2, y + 2, width - 4, height - 4);
//@		if (bSolved) {
//@			ApoHybridGame.setBrighterColor(g);
//@		} else {
//@			ApoHybridGame.setDarkerColor(g);
//@		}
//@		g.fillRect(x + 2, y,  width - 4, 2);
//@		g.fillRect(x + 2, y + height - 2, width - 4, 2);
//@		g.fillRect(x, y + 2, 2, height - 4);
//@		g.fillRect(x + width - 2, y + 2, 2, height - 4);
//@		ApoHybridGame.setBrighterColor(g);
//@		g.fillRect(x + 4, y + height, width - 4, 2);
//@		g.fillRect(x + width, y + 4, 2, height - 4);
//@		g.fillRect(x + width - 2, y + height - 2, 2, 2);
//@	}
//@	
//@	private void drawInputRightBox(final BitsGraphics g, final int x, final int y) {
//@		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
//@		for (int i = 0; i < 10; i++) {
//@			g.fillRect(x + 10 + i * 2, y + 10 + i * 1, 2, 20 - i * 2);
//@		}
//@	}
//@	
//@	private void drawInputLeftBox(final BitsGraphics g, final int x, final int y) {
//@		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
//@		for (int i = 0; i < 10; i++) {
//@			g.fillRect(x + 30 - i * 2, y + 10 + i * 1, 2, 20 - i * 2);
//@		}
//@	}
	//#endif
}
//#else
//@/*
//@ * Copyright (c) 2005-2013 Dirk Aporius <dirk.aporius@gmail.com>
//@ * All rights reserved.
//@ * 
//@ * Redistribution and use in source and binary forms, with or without
//@ * modification, are permitted provided that the following conditions
//@ * are met:
//@ * 1. Redistributions of source code must retain the above copyright
//@ *    notice, this list of conditions and the following disclaimer.
//@ * 2. Redistributions in binary form must reproduce the above copyright
//@ *    notice, this list of conditions and the following disclaimer in the
//@ *    documentation and/or other materials provided with the distribution.
//@ * 3. The name of the author may not be used to endorse or promote products
//@ *    derived from this software without specific prior written permission.
//@ * 
//@ * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
//@ * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
//@ * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
//@ * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
//@ * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
//@ * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
//@ * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
//@ * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
//@ * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
//@ * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
//@ */
//@
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//@
//@import net.apogames.apohybrid.ApoHybridConstants;
//@import net.apogames.apohybrid.ApoHybridModel;
//@import net.apogames.apohybrid.ApoHybridSoundPlayer;
//@import net.apogames.apohybrid.entity.ApoEntity;
//@import net.apogames.apohybrid.entity.ApoHybridTutorial;
//@import net.apogames.apohybrid.entity.ApoHybridTutorialHelp;
//@import net.apogames.apohybrid.level.ApoHybridLevel;
//@
//@public class ApoHybridLevelChooser extends ApoHybridModel {
//@
//@	public static final String BACK = "back";
//@	
//@	public static final int EASY = 0;
//@	public static final int MEDIUM = 1;
//@	public static final int HARD = 2;
//@	public static final int VERYHARD = 3;
//@	
//@	public static int FREE = 5;
//@	
//@	private int difficulty;
//@	
//@	private ApoEntity[] levels;
//@	
//@	private float curChange = 0;
//@	private int curStart = 0;
//@	private int curI = 0;
//@	private int min = 0;
//@	private int max = 20;
//@	
//@	private int mousePressedX, mousePressedY;
//@	
//@	private int curTouchX;
//@	
//@	private ApoHybridTutorial tutorial;
//@	
//@	private boolean bUserlevels;
//@	
//@	public ApoHybridLevelChooser(final ApoHybridPanel game) {
//@		super(game);
//@		
//@		this.difficulty = ApoHybridLevelChooser.EASY;
//@	}
//@
//@	@Override
//@	public void init() {
//@		if (this.levels == null) {
//@			this.levels = new ApoEntity[5000];
//@			int curX = 6 * 4;
//@			int curY = 24 * 4;
//@			for (int i = 0; i < 20; i++) {
//@				for (int j = 0; j < this.levels.length/20; j++) {
//@					this.levels[i + j * 20] = new ApoEntity(null, curX + 17 * 16 * j, curY, 16 * 4, 16 * 4);
//@				}
//@				
//@				curX += 17 * 4;
//@				if (curX > 280) {
//@					curX = 6 * 4;
//@					curY += 18 * 4;
//@				}
//@			}
//@		}
//@		this.curTouchX = 0;
//@		
//@		if (ApoHybridConstants.FIRST_LEVELCHOOSER) {
//@			ApoHybridTutorialHelp[] points = new ApoHybridTutorialHelp[4];
//@			points[0] = new ApoHybridTutorialHelp(144, 224, 64, 224, 500);
//@			points[1] = new ApoHybridTutorialHelp(48, 113, 64, 224, 100);
//@			points[2] = new ApoHybridTutorialHelp(48, 113, 96, 224, 1000);
//@			points[3] = new ApoHybridTutorialHelp(48, 113, 64, 224, 600);
//@			this.tutorial = new ApoHybridTutorial(points);
//@		} else {
//@			this.tutorial = null;
//@		}
//@	}
//@	
//@	public int getCurMax() {
//@		int free = ApoHybridLevelChooser.FREE;
//@		for (int i = 0; i < this.levels.length && i < this.max - this.min; i++) {
//@			boolean bSolved = this.getGame().getSolvedLevel().containsKey(ApoHybridLevel.getLevel(this.curI + i));
//@			if (!bSolved) {
//@				free -= 1;
//@				if (free <= 0) {
//@					return i;
//@				}
//@			}
//@		}
//@		return this.max - this.min;
//@	}
//@
//@	public int getMin() {
//@		return this.min;
//@	}
//@
//@	public int getCurI() {
//@		return this.curI;
//@	}
//@
//@	public int getDifficulty() {
//@		return this.difficulty;
//@	}
//@
//@	public void setDifficulty(final int difficulty, final int level, final boolean bMap) {
//@		this.difficulty = difficulty;
//@		this.curChange = 0;
//@		this.curStart = level / 20;
//@		
//@		if (this.difficulty == ApoHybridLevelChooser.EASY) {
//@			this.min = 0;
//@			this.max = 40;
//@			if (ApoHybridConstants.FREE_VERSION) {
//@				this.max = 20;
//@			}
//@			this.curI = 0; 
//@		}
//@		if (this.difficulty == ApoHybridLevelChooser.MEDIUM) {
//@			this.min = 40;
//@			this.max = 80;
//@			this.curI = 40; 
//@		}
//@		
//@		if (this.difficulty == ApoHybridLevelChooser.HARD) {
//@			this.min = 80;
//@			this.max = 120;
//@			this.curI = 80; 
//@		}
//@		if (this.difficulty == ApoHybridLevelChooser.VERYHARD) {
//@			this.min = 120;
//@			this.max = 150;
//@			this.curI = 120; 
//@		}
//@		if ((!ApoHybridConstants.FIRST_LEVELCHOOSER) && (level < 20) && (level + ApoHybridLevelChooser.FREE >= 20) && (ApoHybridConstants.FIRST_LEVELCHOOSER_DRAG)) {
//@			ApoHybridTutorialHelp[] points = new ApoHybridTutorialHelp[5];
//@			points[0] = new ApoHybridTutorialHelp(144, 224, 64, 224, 0);
//@			points[1] = new ApoHybridTutorialHelp(289, 65, 64, 224, 0);
//@			points[2] = new ApoHybridTutorialHelp(289, 65, 96, 224, 200);
//@			points[3] = new ApoHybridTutorialHelp( 40, 65, 96, 224, 50);
//@			points[4] = new ApoHybridTutorialHelp( 40, 65, 64, 224, 500);
//@			this.tutorial = new ApoHybridTutorial(points);
//@		} else if ((!ApoHybridConstants.FIRST_LEVELCHOOSER) && (level >= 20) && (ApoHybridConstants.FIRST_LEVELCHOOSER_DRAG)) {
//@			ApoHybridTutorialHelp[] points = new ApoHybridTutorialHelp[5];
//@			points[0] = new ApoHybridTutorialHelp(144, 224, 64, 224, 0);
//@			points[1] = new ApoHybridTutorialHelp( 40, 65, 64, 224, 0);
//@			points[2] = new ApoHybridTutorialHelp( 40, 65, 96, 224, 200);
//@			points[3] = new ApoHybridTutorialHelp(289, 65, 96, 224, 50);
//@			points[4] = new ApoHybridTutorialHelp(289, 65, 64, 224, 500);
//@			this.tutorial = new ApoHybridTutorial(points);
//@		}
//@		
//@		if (bMap) {
//@			for (int i = 0; i < this.levels.length && i < this.max - this.min; i++) {
//@				boolean bSolved = this.getGame().getSolvedLevel().containsKey(ApoHybridLevel.getLevel(this.curI + i));
//@				if (!bSolved) {
//@					this.curStart = i / 20;
//@					break;
//@				}
//@			}
//@		}
//@		this.bUserlevels = false;
//@	}
//@
//@	public void setUserlevels() {
//@		this.bUserlevels = true;
//@		this.curChange = this.curI = this.min = 0;
//@		this.max = ApoHybridLevel.editorLevels.length;
//@		
//@		for (int i = 0; i < this.levels.length && i < this.max - this.min; i++) {
//@			boolean bSolved = this.getGame().getSolvedLevel().containsKey(ApoHybridLevel.editorLevels[this.curI + i]);
//@			if (!bSolved) {
//@				this.curStart = i / 20;
//@				break;
//@			}
//@		}
//@	}
//@
//@	@Override
//@	public void touchedPressed(int x, int y, int finger) {
//@		this.mousePressedX = x;
//@		this.mousePressedY = y;
//@		this.curTouchX = x;
//@	}
//@
//@	@Override
//@	public void touchedReleased(int x, int y, int finger) {
//@		if (Math.abs(x - this.mousePressedX) > ApoHybridConstants.CHANGE_DRAG) {
//@			if (this.mousePressedX > x) {
//@				if (this.curStart * 20 + 20 + this.min < this.max) {
//@					this.curChange = 17 * 16 + (this.curTouchX - this.mousePressedX);
//@					this.curStart += 1;
//@				}
//@			}
//@			if (this.mousePressedX < x) {
//@				if (this.curStart * 20 - 20 + this.min >= this.min) {
//@					this.curChange = -17 * 16 + (this.curTouchX - this.mousePressedX);;
//@					this.curStart -= 1;
//@				}
//@			}
//@		} else if (Math.abs(x - this.mousePressedX) <= 2) {
//@			int free = ApoHybridLevelChooser.FREE;
//@			for (int i = 0; i < this.levels.length && i < this.max - this.min; i++) {
//@				boolean bSolved = this.getGame().getSolvedLevel().containsKey(ApoHybridLevel.getLevel(this.curI + i));
//@				if (!bSolved) {
//@					free -= 1;
//@				}
//@				if ((this.levels[i].getX() <= x + this.curStart * 272) && (this.levels[i].getX() + 64 >= x + this.curStart * 272) &&
//@					(this.levels[i].getY() <= y) && (this.levels[i].getY() + 64 >= y)) {
//@					if (this.bUserlevels) {
//@						this.getGame().playSound(ApoHybridSoundPlayer.SOUND_CLICK);
//@						this.getGame().setGame(true, false, i, "");
//@					} else if ((free > 0) || (bSolved)) {
//@						if (ApoHybridConstants.FIRST_LEVELCHOOSER) {
//@							ApoHybridConstants.FIRST_LEVELCHOOSER = false;
//@							if (this.tutorial != null) {
//@								this.tutorial.setVisible(false);
//@							}
//@						}
//@						this.getGame().playSound(ApoHybridSoundPlayer.SOUND_CLICK);
//@						this.getGame().setGame(false, false, i, "");
//@					}
//@					return;
//@				}
//@			}
//@		} else if (this.curTouchX != 0){
//@			this.curChange = (this.curTouchX - this.mousePressedX);
//@		}
//@		this.curTouchX = 0;
//@		this.mousePressedX = 0;
//@	}
//@
//@	@Override
//@	public void touchedDragged(int x, int y, int oldX, int oldY, int finger) {
//@		if (this.mousePressedX > x) {
//@			if (this.curStart * 20 + 20 + this.min < this.max) {
//@				this.curTouchX = x;
//@			}
//@		}
//@		if (this.mousePressedX < x) {
//@			if (this.curStart * 20 - 20 + this.min >= this.min) {
//@				this.curTouchX = x;
//@			}
//@		}
//@	}
//@
//@	@Override
//@	public void touchedButton(String function) {
//@		this.getGame().playSound(ApoHybridSoundPlayer.SOUND_CLICK);
//@		if (function.equals(ApoHybridMap.BACK)) {
//@			this.onBackButtonPressed();
//@		}
//@	}
//@	
//@	public void onBackButtonPressed() {
//@		if (this.bUserlevels) {
//@			this.getGame().setMenu();
//@		} else {
//@			this.getGame().setMap();
//@		}
//@	}
//@	
//@	@Override
//@	public void think(int delta) {
//@		if (this.curChange > 0) {
//@			this.curChange -= 4;
//@		}
//@		
//@		if (this.curChange < 0) {
//@			this.curChange += 4;
//@		}
//@		
//@		if (this.tutorial != null) {
//@			if (this.tutorial.isVisible()) {
//@				this.tutorial.think(delta);
//@				if (!this.tutorial.isVisible()) {
//@					if (ApoHybridConstants.FIRST_LEVELCHOOSER) {
//@						ApoHybridConstants.FIRST_LEVELCHOOSER = false;
//@					} else {
//@						ApoHybridConstants.FIRST_LEVELCHOOSER_DRAG = false;
//@					}
//@				}
//@			}
//@		}
//@	}
//@
//@	@Override
//@	public void render(BitsGLGraphics g) {
//@		g.cropImage(ApoHybridConstants.iSheet, 0, 0, ApoHybridConstants.GAME_WIDTH, ApoHybridConstants.GAME_HEIGHT, 1024 - ApoHybridConstants.GAME_WIDTH, 0, ApoHybridConstants.GAME_WIDTH, ApoHybridConstants.GAME_HEIGHT);
//@
//@		g.cropImage(ApoHybridConstants.iSheet, 2 * 4, 58, 76 * 4, 8 * 4, 0, 96 * 4, 76 * 4, 8 * 4);
//@		
//@		g.setFont(ApoHybridConstants.FONT_LEVELCHOOSER);
//@		int y = ApoHybridConstants.FONT_LEVELCHOOSER.mCharCellHeight;
//@		g.setColor(ApoHybridConstants.COLOR_DARK);
//@		String s = ApoHybridConstants.DIFFICULTY[this.difficulty];
//@		if (this.bUserlevels) {
//@			s = "Userlevels";
//@		}
//@		float w = ApoHybridConstants.FONT_LEVELCHOOSER.getLength(s);
//@		g.drawText(s, ApoHybridConstants.GAME_WIDTH*1/2 - w/2, 48 - y);
//@		
//@		if ((this.max - this.min - 1) / 20 > 0) {
//@			g.setFont(ApoHybridConstants.fontSmall);
//@			y = ApoHybridConstants.fontSmall.mCharCellHeight;
//@			s = " ("+(this.curStart + 1) + " / " + ((this.max - this.min - 1)/20 + 1)+")";
//@			g.drawText(s, ApoHybridConstants.GAME_WIDTH*1/2 + w/2, 46 - y);
//@		}
//@		
//@		int free = ApoHybridLevelChooser.FREE;
//@		g.setClip(16, 96, 288, 360);
//@		for (int i = 0; i < this.levels.length && i < this.max - this.min; i++) {
//@			boolean bSolved = this.getGame().getSolvedLevel().containsKey(ApoHybridLevel.getLevel(this.curI + i));
//@			if (this.bUserlevels) {
//@				bSolved = this.getGame().getSolvedLevel().containsKey(ApoHybridLevel.editorLevels[this.curI + i]);
//@			}
//@			if ((!bSolved) && (!this.bUserlevels)) {
//@				free -= 1;
//@			}
//@			int change = 0;
//@			if (this.curTouchX > 0) {
//@				change = -(this.curTouchX - this.mousePressedX);
//@			}
//@			if ((this.levels[i].getX() + 64 > 20 - this.curChange + this.curStart * 272 + change) && (this.levels[i].getX() < 20 - this.curChange + (this.curStart + 1) * 272 + change)) {
//@				int add = 0;
//@				if ((Math.abs(this.curTouchX - this.mousePressedX) <= 2) && (this.levels[i].intersects(this.mousePressedX - this.curChange + this.curStart * 272 + change, this.mousePressedY))) {
//@					add = 2;
//@				}
//@				g.setColor(1f, 1f, 1f, 1f);
//@				if ((free > 0) || (bSolved)) {
//@					g.cropImage(ApoHybridConstants.iSheet, (int)(this.levels[i].getX() - change + this.curChange - this.curStart * 272), (int)(this.levels[i].getY() + add), 64, 64, 16 * 4, 80 * 4, 64, 64);
//@				} else {
//@					g.cropImage(ApoHybridConstants.iSheet, (int)(this.levels[i].getX() - change + this.curChange - this.curStart * 272), (int)(this.levels[i].getY() + add), 64, 64, 0, 80 * 4, 64, 64);
//@				}
//@				g.setColor(ApoHybridConstants.COLOR_LIGHT);
//@				g.setFont(ApoHybridConstants.fontBig);
//@				y = ApoHybridConstants.fontBig.mCharCellHeight;
//@				s = String.valueOf(i + 1);
//@				w = ApoHybridConstants.fontBig.getLength(s);
//@				g.drawText(s, (int)(this.levels[i].getX() + this.curChange - change - this.curStart * 272 + 32) - w/2, (int)(this.levels[i].getY() + 38 - y + add));
//@				
//@				if (bSolved) {
//@					g.setColor(1f, 1f, 1f, 1f);
//@					int skulls = 0;
//@					if (!this.bUserlevels) {
//@						skulls = this.getGame().getSolvedLevel().get(ApoHybridLevel.getLevel(this.curI + i));
//@					} else {
//@						skulls = this.getGame().getSolvedLevel().get(ApoHybridLevel.editorLevels[this.curI + i]);
//@					}
//@					g.cropImage(ApoHybridConstants.iSheet, (int)(this.levels[i].getX() - change + this.curChange - this.curStart * 272 + 2 * 4), (int)(this.levels[i].getY() + 10 * 4 + add), 12, 12, 8 * 4, 120 * 4, 12, 12);
//@					if (skulls > 1) {
//@						g.cropImage(ApoHybridConstants.iSheet, (int)(this.levels[i].getX() - change + this.curChange - this.curStart * 272 + 6 * 4), (int)(this.levels[i].getY() + 10 * 4 + add), 12, 12, 12 * 4, 120 * 4, 12, 12);
//@						if (skulls > 2) {
//@							g.cropImage(ApoHybridConstants.iSheet, (int)(this.levels[i].getX() - change + this.curChange - this.curStart * 272 + 10 * 4), (int)(this.levels[i].getY() + 10 * 4 + add), 12, 12, 16 * 4, 120 * 4, 12, 12);
//@						}
//@					}
//@				}
//@			}
//@		}
//@		g.setClip(0, 0, ApoHybridConstants.GAME_WIDTH, ApoHybridConstants.GAME_HEIGHT);
//@		
//@		g.setColor(1f, 1f, 1f, 1f);
//@		if (this.tutorial != null) {
//@			if (this.tutorial.isVisible()) {
//@				this.tutorial.render(g);
//@			}
//@		}
//@	}
//@
//@}
//#endif
