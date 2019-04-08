package net.apogames.apohybrid.game;

import net.gliblybits.bitsengine.core.BitsGame;
import net.apogames.apohybrid.ApoHybridConstants;
import net.apogames.apohybrid.ApoHybridModel;
import net.apogames.apohybrid.ApoHybridSoundPlayer;
import net.apogames.apohybrid.entity.ApoLevelChooserButton;

//#if ClockGameLogic ||MonoGameLogic
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//#elif SnakeGameLogic || DiceGameLogic
import net.gliblybits.bitsengine.render.BitsGraphics;
import net.apogames.apohybrid.level.ApoHybridLevel;
import net.gliblybits.bitsengine.core.BitsFactory;
import net.gliblybits.bitsengine.core.BitsFont;
//#endif


public class ApoHybridMenu extends ApoHybridModel {

	public static final String QUIT = "quit";
	public static final String PUZZLE = "puzzle";
	public static final String PLAY = "play";
	public static final String USERLEVELS = "userlevels";
	public static final String EDITOR = "editor";
	public static final String TITLE = "ApoHybrid";
	public static final String ARCADE = "arcade";
	public static final String OPTIONS = "options";
	public static final String SUB = "a game made by Dirk Aporius";
	public static final String SUB_2 = "made with the bits-engine by Marc Wiedenhoeft";
	public static final String CREDITS = "credits";
	
	private float clockRotate;

	//#if SnakeGameLogic || DiceGameLogic
	public static BitsFont font;
	public static BitsFont game_font;
	public static BitsFont title_font;
	//#endif
	
	public ApoHybridMenu(ApoHybridPanel game) {
		super(game);
	}

	@Override
	public void init() {
		//#if ClockMenu
//@		this.getStringWidth().put(ApoHybridMenu.QUIT, (int)(ApoHybridPanel.font.getLength(ApoHybridMenu.QUIT)));
//@		this.getStringWidth().put(ApoHybridMenu.PUZZLE, (int)(ApoHybridPanel.font.getLength(ApoHybridMenu.PUZZLE)));
//@		this.getStringWidth().put(ApoHybridMenu.ARCADE, (int)(ApoHybridPanel.font.getLength(ApoHybridMenu.ARCADE)));
//@		this.getStringWidth().put(ApoHybridMenu.OPTIONS, (int)(ApoHybridPanel.font.getLength(ApoHybridMenu.OPTIONS)));
//@		this.getStringWidth().put(ApoHybridMenu.TITLE, (int)(ApoHybridPanel.title_font.getLength(ApoHybridMenu.TITLE)));
//@
		//#elif MonoMenu
		this.getStringWidth().put(ApoMonoMenu.TITLE, (int)(ApoMonoPanel.title_font.getLength(ApoMonoMenu.TITLE)));
		this.getStringWidth().put(ApoMonoMenu.SUB, (int)(ApoMonoPanel.game_font.getLength(ApoMonoMenu.SUB)));
		this.getStringWidth().put(ApoMonoMenu.SUB_2, (int)(ApoMonoPanel.game_font.getLength(ApoMonoMenu.SUB_2)));

		//#else
		this.loadFonts();

		this.getStringWidth().put(ApoHybridMenu.USERLEVELS, (int)(ApoHybridMenu.font.getLength(ApoHybridMenu.USERLEVELS)));
		this.getStringWidth().put(ApoHybridMenu.EDITOR, (int)(ApoHybridMenu.font.getLength(ApoHybridMenu.EDITOR)));
		this.getStringWidth().put(ApoHybridMenu.TITLE, (int)(ApoHybridMenu.title_font.getLength(ApoHybridMenu.TITLE)));
		this.getStringWidth().put(ApoHybridMenu.QUIT, (int)(ApoHybridMenu.font.getLength(ApoHybridMenu.QUIT)));
		this.getStringWidth().put(ApoHybridMenu.PUZZLE, (int)(ApoHybridMenu.font.getLength(ApoHybridMenu.PUZZLE)));

		this.setUserlevels();
		//#endif

	}
	
	public void onResume() {
		//#if !ClockGameLogic
		this.loadFonts();
		//#endif
	}

	//#if DiceGameLogic || SnakeGameLogic
	private void loadFonts() {
		ApoHybridMenu.font = BitsFactory.getIt().getFont("reprise.ttf", 30);
		ApoHybridMenu.title_font = BitsFactory.getIt().getFont("reprise.ttf", 38);
			
		ApoHybridMenu.game_font = BitsFactory.getIt().getFont("reprise.ttf", 26);
	}
	//#endif
	
	@Override
	public void touchedPressed(int x, int y, int finger) {
		
	}

	@Override
	public void touchedReleased(int x, int y, int finger) {
		
	}

	@Override
	public void touchedDragged(int x, int y, int oldX, int oldY, int finger) {
		
	}

	@Override
	public void touchedButton(String function) {
		if (function.equals(ApoHybridMenu.QUIT)) {
			this.onBackButtonPressed();
		//#if ClockMenu
//@		} else if (function.equals(ApoHybridMenu.PUZZLE)) {
//@			this.getGame().setPuzzle();
//@		} else if (function.equals(ApoHybridMenu.ARCADE)) {
//@			this.getGame().setAracardeHelp(-1, -1);
//@		} else if (function.equals(ApoHybridMenu.OPTIONS)) {
//@			this.getGame().setOptions();
//@		}
		//#elif MonoMenu
		} else if (function.equals(ApoHybridMenu.PLAY)) {
			this.getGame().setLevelChooser();
		} else if (function.equals(ApoHybridMenu.EDITOR)) {
			this.getGame().setEditor(false);
		} else if (function.equals(ApoHybridMenu.USERLEVELS)) {
			this.getGame().setGame(0, null, true);
		} else if (function.equals(ApoHybridMenu.CREDITS)) {
			this.getGame().setCredits();
		} else if (function.equals(ApoHybridMenu.OPTIONS)) {
			this.getGame().setOptions();
		}
		this.getGame().playSound(ApoHybridSoundPlayer.SOUND_BUTTON);
		//#else
		} else if (function.equals(ApoHybridMenu.PUZZLE)) {
			this.getGame().setPuzzleChooser();
		} else if (function.equals(ApoHybridMenu.EDITOR)) {
			this.getGame().setEditor(false);
		} else if (function.equals(ApoHybridMenu.USERLEVELS)) {
			//#if DiceGameLogic
			this.getGame().setPuzzleGame(0, "", true);
			//#elif SnakeGameLogic
//@			this.getGame().setPuzzleGame(-1, "", true);
			//#elif MonoGameLogic
			this.getGame().setGame(0, null, true);
			//#endif
		}
		//#endif
	}
	//#if ClockMenu || MonoMenu
//@	public void onBackButtonPressed() {
//@		BitsGame.getInstance().finishApp();
//@	}
	//#else
	public void onBackButtonPressed() {
		BitsGame.getIt().finish();
	}
	
	public void setUserlevels() {
		this.getGame().getButtons()[2].setVisible(true);
		if (ApoHybridLevel.editorLevels == null) {
			this.getGame().getButtons()[2].setVisible(false);
		}
	}
	//#endif

	
	@Override
	public void think(int delta) {
		this.clockRotate += delta / 10f;
		if (this.clockRotate >= 360) {
			this.clockRotate -= 360;
		}
	}

	@Override
	//#if ClockMenu
//@	public void render(final BitsGLGraphics g) {
//@		this.getGame().drawBackgroundCircle(g, 100, 20, 100, (int)this.clockRotate);
//@		this.getGame().drawBackgroundCircle(g, 380, 20, 100, (int)this.clockRotate);
//@		
//@		this.getGame().drawString(g, ApoHybridMenu.TITLE, 240, 45, ApoHybridPanel.title_font, new float[] {1, 1, 1, 1}, new float[] {0, 0, 0, 1});
//@		
//@		if (this.getGame().getButtons() != null) {
//@			for (int i = 0; i < this.getGame().getButtons().length; i++) {
				//#if !LevelGrid
//@				if (this.getGame().getButtons()[i].getFunction() == ApoHybridMenu.PUZZLE) i++;
				//#endif
				//#if !Options
//@				if (this.getGame().getButtons()[i].getFunction() == ApoHybridMenu.OPTIONS) i++;
				//#endif
//@				if (this.getGame().getButtons()[i].isVisible()) {
//@					int x = (int)(this.getGame().getButtons()[i].getX());
//@					int y = (int)(this.getGame().getButtons()[i].getY());
//@					int width = (int)(this.getGame().getButtons()[i].getWidth());
//@					int height = (int)(this.getGame().getButtons()[i].getHeight());
//@					
//@					g.setColor(128, 128, 128, 255);
//@					g.fillRect(x, y, width, height);
//@					g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
//@					g.drawRect(x, y, width, height);
//@					
//@					this.getGame().drawString(g, this.getGame().getButtons()[i].getFunction(), x + width/2, y + height/2 - ApoHybridPanel.font.mCharCellHeight/2, ApoHybridPanel.font);
//@					
//@					for (int circle = 0; circle < 2; circle++) {
//@						x += circle * width;
//@						
//@						g.setColor(255, 255, 255, 255);
//@						g.fillCircle(x, y + height/2, height/2, 120);
//@
//@						g.setLineSize(3.0f);
//@						g.setColor(48, 48, 48);
//@						g.drawCircle(x, y + height/2, height/2, 120);
//@						
//@						g.setLineSize(5.0f);
//@						for (int j = 0; j < 12; j++) {
//@							g.drawLine(x + (int)((height/2 - 5) * Math.sin(Math.toRadians(j * 30))), y + height/2 + (int)(-(height/2 - 5) * Math.cos(Math.toRadians(j * 30))), x + (int)((height/2) * Math.sin(Math.toRadians(j * 30))), y + height/2 + (int)(-(height/2) * Math.cos(Math.toRadians(j * 30))));
//@						}
//@						
//@						int angle = (int)(this.clockRotate + circle * 180) + i * 100;
//@						while (angle > 360) {
//@							angle -= 360;
//@						}
//@						g.drawLine(x, y + height/2, x + (int)((height/2 - 5) * Math.sin(Math.toRadians(angle))), y + height/2 + (int)(-(height/2 - 5) * Math.cos(Math.toRadians(angle))));
//@
//@						g.setLineSize(1.0f);
//@					}
//@				}
//@			}
//@		}
//@	}
//@
//@}
	//#elif MonoMenu
	public void render(final BitsGLGraphics g) {
		if (ApoMonoConstants.FREE_VERSION) {
			this.getGame().drawString(g, ApoMonoMenu.TITLE, 240, 55, ApoMonoPanel.title_font);			
		} else {
			this.getGame().drawString(g, ApoMonoMenu.TITLE, 240, 5, ApoMonoPanel.title_font);
			this.getGame().drawString(g, ApoMonoMenu.SUB, 240, 50, ApoMonoPanel.game_font);
			this.getGame().drawString(g, ApoMonoMenu.SUB_2, 240, 65, ApoMonoPanel.game_font);
		}
		
		if (this.getGame().getButtons() != null) {
			for (int i = 0; i < this.getGame().getButtons().length; i++) {
				if (this.getGame().getButtons()[i].isBVisible()) {
					int x = (int)(this.getGame().getButtons()[i].getX());
					int y = (int)(this.getGame().getButtons()[i].getY());
					int width = (int)(this.getGame().getButtons()[i].getWidth());
					int height = (int)(this.getGame().getButtons()[i].getHeight());
					String s = this.getGame().getButtons()[i].getFunction();
					
					ApoLevelChooserButton.drawOneBlock(g, x, y, width, height);
					
					if (s.equals(ApoMonoMenu.CREDITS)) {
						s = "c";
						this.getGame().drawString(g, s,(int)(x + width/2 - ApoMonoPanel.font.getLength(s)/2), y + height/2 - ApoMonoPanel.font.mCharCellHeight/2, ApoMonoPanel.font, ApoMonoConstants.BRIGHT);
					} else if (s.equals(ApoMonoMenu.QUIT)) {
//						s = "x";
//						this.getGame().drawString(g, s,(int)(x + width/2 - ApoMonoMenu.game_font.getLength(s)/2), y + height/2 - ApoMonoMenu.game_font.mCharCellHeight/2, ApoMonoMenu.game_font, ApoMonoConstants.BRIGHT);
						ApoMonoPuzzleGame.drawX(g, x + width/2 - 16, y + height/2 - 16, true, ApoMonoConstants.BRIGHT, false, false);
					} else if (s.equals(ApoMonoMenu.PLAY)) {
						s = ApoMonoConstants.MENU_PLAY;
						this.getGame().drawString(g, s,(int)(x + width/2 - ApoMonoPanel.font.getLength(s)/2), y + height/2 - ApoMonoPanel.font.mCharCellHeight/2, ApoMonoPanel.font, ApoMonoConstants.BRIGHT);
					} else if (s.equals(ApoMonoMenu.OPTIONS)) {
//						s = "o";
//						this.getGame().drawString(g, s,(int)(x + width/2 - ApoMonoMenu.game_font.getLength(s)/2), y + height/2 - ApoMonoMenu.game_font.mCharCellHeight/2, ApoMonoMenu.game_font, ApoMonoConstants.BRIGHT);
						this.drawOptions(g, x, y, width, height);
					} else if (s.equals(ApoMonoMenu.EDITOR)) {
						s = ApoMonoConstants.MENU_EDITOR;
						this.getGame().drawString(g, s,(int)(x + width/2 - ApoMonoPanel.font.getLength(s)/2), y + height/2 - ApoMonoPanel.font.mCharCellHeight/2, ApoMonoPanel.font, ApoMonoConstants.BRIGHT);
					} else if (s.equals(ApoMonoMenu.USERLEVELS)) {
						s = ApoMonoConstants.MENU_USERLEVELS;
						this.getGame().drawString(g, s,(int)(x + width/2 - ApoMonoPanel.font.getLength(s)/2), y + height/2 - ApoMonoPanel.font.mCharCellHeight/2, ApoMonoPanel.font, ApoMonoConstants.BRIGHT);
					}
				}
			}
		}
	}
	
	private final void drawOptions(final BitsGLGraphics g, final int x, final int y, final int width, final int height) {
		g.setColor(ApoMonoConstants.BRIGHT[0], ApoMonoConstants.BRIGHT[1], ApoMonoConstants.BRIGHT[2], 1f);
		g.setLineSize(1 * ApoMonoConstants.MAX);
		g.fillCircle(x + width/2 + 1, y + height/2, 12);
		g.setColor(ApoMonoConstants.DARK[0], ApoMonoConstants.DARK[1], ApoMonoConstants.DARK[2], 1f);
		g.fillCircle(x + width/2 + 1, y + height/2, 8);
		g.setLineSize(1 * ApoMonoConstants.MAX);
		g.setColor(ApoMonoConstants.BRIGHT[0], ApoMonoConstants.BRIGHT[1], ApoMonoConstants.BRIGHT[2], 1f);
		for (int i = 0; i < 360; i+= 45) {
			if (i == 0) {
				g.setRotation(0.01f);				
			} else {
				g.setRotation(i);
			}
			float posX = x + width/2 + 13 * (float)Math.sin(Math.toRadians(i));
			float posY = y + 5f + height/2 - 13 * (float)Math.cos(Math.toRadians(i));
			g.fillRect(posX - 2, posY - 10, 5, 10);
		}
		g.setRotation(0);
	}

}
	//#else
	public void render(final BitsGraphics g) {
		
		this.getGame().drawString(g, ApoHybridMenu.TITLE, 240, 45, ApoHybridMenu.title_font, new float[] {1, 1, 1, 1}, new float[] {0, 0, 0, 1});
		
		int number = 1;
		if (this.getGame().getButtons() != null) {
			for (int i = 0; i < this.getGame().getButtons().length; i++) {
				if (this.getGame().getButtons()[i].isBVisible()) {
					//#if !LevelGrid
//@					if (this.getGame().getButtons()[i].getFunction() == ApoHybridMenu.PUZZLE) i++;
					//#endif

					//#if !Editor
//@					if (this.getGame().getButtons()[i].getFunction().equals(ApoHybridMenu.EDITOR)) i++;
					//#endif
					
					int x = (int)(this.getGame().getButtons()[i].getX());
					int y = (int)(this.getGame().getButtons()[i].getY());
					int width = (int)(this.getGame().getButtons()[i].getWidth());
					int height = (int)(this.getGame().getButtons()[i].getHeight());
					
					g.setColor(128, 128, 128, 255);
					g.drawFilledRect(x, y, width, height);
					g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
					g.drawRect(x, y, width, height);
					
					this.getGame().drawString(g, this.getGame().getButtons()[i].getFunction(), x + width/2, y + height/2 - ApoHybridMenu.font.mCharCellHeight/2, ApoHybridMenu.font);
					
					for (int hybrid = 0; hybrid < 2; hybrid++) {
						x += hybrid * width;
						
						//#if DiceMenu
						g.setColor(255, 255, 255, 255);
						g.drawFilledRoundRect(x - height/2, y, height, height, 6, 10);

						g.setLineSize(3.0f);
						g.setColor(48, 48, 48);
						g.drawRoundRect(x - height/2, y, height, height, 6, 10);
						
						g.setLineSize(1.0f);
						
						if ((number == 1) || (number == 3) || (number == 5)) {
							g.drawFilledCircle(x - height/2 + 30, y + 30, 6, 40);
						}
						if ((number == 2) || (number == 3) || (number == 4) || (number == 5)) {
							g.drawFilledCircle(x - height/2 + 14, y + 14, 6, 40);
							g.drawFilledCircle(x - height/2 + 46, y + 46, 6, 40);
						}
						if ((number == 4) || (number == 5)) {
							g.drawFilledCircle(x - height/2 + 46, y + 14, 6, 40);
							g.drawFilledCircle(x - height/2 + 14, y + 46, 6, 40);
						}

						//#elif SnakeMenu
//@						g.setColor(255, 0, 0, 255);
//@						if (number == 2) {
//@							g.setColor(0, 255, 0);
//@						} else if (number == 3) {
//@							g.setColor(0, 90, 200);
//@						} else if (number == 4) {
//@							g.setColor(255, 255, 0);
//@						}
//@						g.drawFilledCircle(x, y + height/2, height/2, height/2);
//@
//@						g.setLineSize(3.0f);
//@						g.setColor(48, 48, 48);
//@						g.drawCircle(x, y + height/2, height/2, height/2);
//@						
//@						g.drawFilledRect(x - 5, y + 5, 4, 15);
//@						g.drawFilledRect(x + 1, y + 5, 4, 15);
//@						
//@						g.setLineSize(1.0f);
						//#endif
					}
					number += 1;
							

				}
			}
		}
	}

}
//#endif
