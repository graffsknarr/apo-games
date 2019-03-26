package net.apogames.apohybrid.game;

import net.apogames.apohybrid.ApoHybridModel;
import net.apogames.apohybrid.level.ApoHybridLevel;
import net.gliblybits.bitsengine.core.BitsFactory;
import net.gliblybits.bitsengine.core.BitsFont;
import net.gliblybits.bitsengine.core.BitsGame;
import net.gliblybits.bitsengine.render.BitsGraphics;

public class ApoHybridMenu extends ApoHybridModel {

	public static final String QUIT = "quit";
	public static final String PUZZLE = "puzzle";
	public static final String USERLEVELS = "userlevels";
	public static final String EDITOR = "editor";
	public static final String TITLE = "ApoHybrid";
	
	public static BitsFont font;
	public static BitsFont game_font;
	public static BitsFont title_font;
	
	private float clockRotate;
	
	public ApoHybridMenu(ApoHybridPanel game) {
		super(game);
	}

	@Override
	public void init() {
		this.loadFonts();
		
		this.getStringWidth().put(ApoHybridMenu.QUIT, (int)(ApoHybridMenu.font.getLength(ApoHybridMenu.QUIT)));
		this.getStringWidth().put(ApoHybridMenu.PUZZLE, (int)(ApoHybridMenu.font.getLength(ApoHybridMenu.PUZZLE)));
		this.getStringWidth().put(ApoHybridMenu.USERLEVELS, (int)(ApoHybridMenu.font.getLength(ApoHybridMenu.USERLEVELS)));
		this.getStringWidth().put(ApoHybridMenu.EDITOR, (int)(ApoHybridMenu.font.getLength(ApoHybridMenu.EDITOR)));
		this.getStringWidth().put(ApoHybridMenu.TITLE, (int)(ApoHybridMenu.title_font.getLength(ApoHybridMenu.TITLE)));
		
		this.setUserlevels();
	}
	
	public void onResume() {
		this.loadFonts();
	}
	
	private void loadFonts() {
		ApoHybridMenu.font = BitsFactory.getIt().getFont("reprise.ttf", 30);
		ApoHybridMenu.title_font = BitsFactory.getIt().getFont("reprise.ttf", 38);
			
		ApoHybridMenu.game_font = BitsFactory.getIt().getFont("reprise.ttf", 26);
	}

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
		} else if (function.equals(ApoHybridMenu.PUZZLE)) {
			this.getGame().setPuzzleChooser();
		} else if (function.equals(ApoHybridMenu.EDITOR)) {
			this.getGame().setEditor(false);
		} else if (function.equals(ApoHybridMenu.USERLEVELS)) {
			//#if Dice
			this.getGame().setPuzzleGame(0, "", true);
			//#elif Snake
//@			this.getGame().setPuzzleGame(-1, "", true);
			//#endif
		}
	}
	
	public void onBackButtonPressed() {
		BitsGame.getIt().finish();
	}
	
	public void setUserlevels() {
		this.getGame().getButtons()[2].setVisible(true);
		if (ApoHybridLevel.editorLevels == null) {
			this.getGame().getButtons()[2].setVisible(false);
		}
	}
	
	@Override
	public void think(int delta) {
		this.clockRotate += delta / 10f;
		if (this.clockRotate >= 360) {
			this.clockRotate -= 360;
		}
	}

	@Override
	public void render(final BitsGraphics g) {
		
		this.getGame().drawString(g, ApoHybridMenu.TITLE, 240, 45, ApoHybridMenu.title_font, new float[] {1, 1, 1, 1}, new float[] {0, 0, 0, 1});
		
		int number = 1;
		if (this.getGame().getButtons() != null) {
			for (int i = 0; i < this.getGame().getButtons().length; i++) {
				if (this.getGame().getButtons()[i].isBVisible()) {
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
						
						//#if DiceTheme
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

						//#elif SnakeTheme
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
