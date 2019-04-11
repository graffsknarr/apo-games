package net.apogames.apohybrid.game;

//#if ClockGameLogic
//@import net.apogames.apohybrid.ApoHybridModel;
//@import net.apogames.apohybrid.entity.ApoLevelChooserButton;
//@import net.apogames.apohybrid.level.ApoHybridLevel;
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//#elif SnakeGameLogic || DiceGameLogic
import net.apogames.apohybrid.ApoHybrid;
import net.apogames.apohybrid.ApoHybridModel;
import net.apogames.apohybrid.entity.ApoLevelChooserButton;
import net.apogames.apohybrid.level.ApoHybridLevel;
import net.gliblybits.bitsengine.render.BitsGraphics;
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
		this.getStringWidth().put(ApoHybridLevelChooser.BACK, (int)(ApoHybridMenu.font.getLength(ApoHybridLevelChooser.BACK)));
		this.getStringWidth().put(ApoHybridLevelChooser.LEVEL_CHOOSER, (int)(ApoHybridMenu.title_font.getLength(ApoHybridLevelChooser.LEVEL_CHOOSER)));
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
			this.getGame().savePreferences(ApoHybrid.settings);
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
		this.getGame().setMenu();
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
	public void render(BitsGraphics g) {
		this.getGame().drawString(g, ApoHybridLevelChooser.LEVEL_CHOOSER, 240, 2, ApoHybridMenu.title_font, new float[] {1, 1, 1, 1}, new float[] {0, 0, 0, 1});
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
				//#if DiceMenu
				g.drawFilledRoundRect(x, y, radius, radius, 6, 10);

				g.setLineSize(2.5f);
				g.setColor(48, 48, 48);
				g.drawRoundRect(x, y, radius, radius, 6, 10);
				
				if (this.solved == i) {
					this.getGame().drawString(g, this.levels[i].getFunction(), x + radius/2 - (int)ApoHybridMenu.font.getLength(this.levels[i].getFunction())/2, y + radius/2 - ApoHybridMenu.font.mCharCellHeight/2, ApoHybridMenu.font, new float[] {1, 1, 1, 1}, new float[] {0, 0, 0, 1});
				} else {
					this.getGame().drawString(g, this.levels[i].getFunction(), x + radius/2 - (int)ApoHybridMenu.font.getLength(this.levels[i].getFunction())/2, y + radius/2 - ApoHybridMenu.font.mCharCellHeight/2, ApoHybridMenu.font);
				}

				//#elif SnakeMenu
//@				g.drawFilledCircle(x + radius/2, y + radius/2, radius/2, 120);
//@
//@				g.setLineSize(2.5f);
//@				g.setColor(48, 48, 48);
//@				g.drawCircle(x + radius/2, y + radius/2, radius/2, 120);
//@				g.drawFilledRect(x + radius/2 - 4, y + 10, 3, 6);
//@				g.drawFilledRect(x + radius/2 + 1, y + 10, 3, 6);
//@				
//@				if (this.solved == i) {
//@					this.getGame().drawString(g, this.levels[i].getFunction(), x + radius/2 - (int)ApoHybridMenu.font.getLength(this.levels[i].getFunction())/2, y + radius/2 - ApoHybridMenu.font.mCharCellHeight/2, ApoHybridMenu.font, new float[] {1, 1, 1, 1}, new float[] {0, 0, 0, 1});
//@				} else {
//@					this.getGame().drawString(g, this.levels[i].getFunction(), x + radius/2 - (int)ApoHybridMenu.font.getLength(this.levels[i].getFunction())/2, y + radius/2 - ApoHybridMenu.font.mCharCellHeight/2, ApoHybridMenu.font);
//@				}
//@
				//#elif ClockMenu
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
