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
//#endif

public class ApoHybridPuzzleChooser extends ApoHybridModel {

	public static final String BACK = "back";
	public static final String LEVEL_CHOOSER = "ApoHybrid - Levelchooser";
	
	private ApoLevelChooserButton[] levels;
	
	private int solved = 0;
	
	private int curShow = 0;
	
	public ApoHybridPuzzleChooser(ApoHybridPanel game) {
		super(game);
	}

	@Override
	public void init() {
		//#if ClockGameLogic
//@		this.getStringWidth().put(ApoHybridPuzzleChooser.BACK, (int)(ApoHybridPanel.font.getLength(ApoHybridPuzzleChooser.BACK)));
//@		this.getStringWidth().put(ApoHybridPuzzleChooser.LEVEL_CHOOSER, (int)(ApoHybridPanel.title_font.getLength(ApoHybridPuzzleChooser.LEVEL_CHOOSER)));
		//#elif SnakeGameLogic || DiceGameLogic		
		this.getStringWidth().put(ApoHybridPuzzleChooser.BACK, (int)(ApoHybridMenu.font.getLength(ApoHybridPuzzleChooser.BACK)));
		this.getStringWidth().put(ApoHybridPuzzleChooser.LEVEL_CHOOSER, (int)(ApoHybridMenu.title_font.getLength(ApoHybridPuzzleChooser.LEVEL_CHOOSER)));
		//#endif

		
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
	}
	
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
					this.getGame().setPuzzleGame(i, null, false);
				}
			}
		}
	}

	@Override
	public void touchedReleased(int x, int y, int finger) {
		
	}

	@Override
	public void touchedDragged(int x, int y, int oldX, int oldY, int finger) {
		
	}

	@Override
	public void touchedButton(String function) {
		if (function.equals(ApoHybridPuzzleChooser.BACK)) {
			this.onBackButtonPressed();
		}
	}
	
	public void onBackButtonPressed() {
		//#if ClockGameLogic
//@		this.getGame().setPuzzle();
		//#elif SnakeGameLogic || DiceGameLogic
		this.getGame().setMenu();
		//#endif

	}

	@Override
	public void think(int delta) {
		
	}

	@Override
	//#if ClockGameLogic
//@	public void render(BitsGLGraphics g) {
//@		this.getGame().drawString(g, ApoHybridPuzzleChooser.LEVEL_CHOOSER, 240, 2, ApoHybridPanel.title_font, new float[] {1, 1, 1, 1}, new float[] {0, 0, 0, 1});
//@	
	//#elif SnakeGameLogic || DiceGameLogic
	public void render(BitsGraphics g) {
		this.getGame().drawString(g, ApoHybridPuzzleChooser.LEVEL_CHOOSER, 240, 2, ApoHybridMenu.title_font, new float[] {1, 1, 1, 1}, new float[] {0, 0, 0, 1});
	//#endif

		
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

}
