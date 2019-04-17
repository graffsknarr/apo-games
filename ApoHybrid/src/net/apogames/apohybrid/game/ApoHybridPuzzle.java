//#if ClockGameLogic
package net.apogames.apohybrid.game;

import net.apogames.apohybrid.ApoHybridModel;
import net.apogames.apohybrid.level.ApoHybridLevel;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;

public class ApoHybridPuzzle extends ApoHybridModel {

	public static final String BACK = "back";
	public static final String PUZZLE = "puzzle";
	public static final String USERLEVELS = "userlevels";
	public static final String EDITOR = "editor";
	public static final String TITLE = "ApoHybrid - Puzzlemode";
	
	private float clockRotate;
	
	public ApoHybridPuzzle(ApoHybridPanel game) {
		super(game);
	}

	@Override
	public void init() {
		this.getStringWidth().put(ApoHybridPuzzle.BACK, (int)(ApoHybridPanel.font.getLength(ApoHybridPuzzle.BACK)));
		this.getStringWidth().put(ApoHybridPuzzle.PUZZLE, (int)(ApoHybridPanel.font.getLength(ApoHybridPuzzle.PUZZLE)));
		this.getStringWidth().put(ApoHybridPuzzle.USERLEVELS, (int)(ApoHybridPanel.font.getLength(ApoHybridPuzzle.USERLEVELS)));
		this.getStringWidth().put(ApoHybridPuzzle.EDITOR, (int)(ApoHybridPanel.font.getLength(ApoHybridPuzzle.EDITOR)));
		this.getStringWidth().put(ApoHybridPuzzle.TITLE, (int)(ApoHybridPanel.title_font.getLength(ApoHybridPuzzle.TITLE)));
		
		this.setUserlevelsVisible();
	}
	
	public void setUserlevelsVisible() {
		if ((ApoHybridLevel.editorLevels == null) || (ApoHybridLevel.editorLevels.length <= 0)) {
			this.getGame().getButtons()[10].setVisible(false);
		} else {
			this.getGame().getButtons()[10].setVisible(true);
		}
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
		if (function.equals(ApoHybridPuzzle.BACK)) {
			this.onBackButtonPressed();
		} else if (function.equals(ApoHybridPuzzle.PUZZLE)) {
			this.getGame().setPuzzleChooser();
		} else if (function.equals(ApoHybridPuzzle.EDITOR)) {
			//#if Editor
			this.getGame().setEditor(false);
			//#endif
		} else if (function.equals(ApoHybridPuzzle.USERLEVELS)) {
			if ((ApoHybridLevel.editorLevels != null) && (ApoHybridLevel.editorLevels.length > 0)) {
				this.getGame().setGame(0, null, true);
			}
		}
	}
	
	public void onBackButtonPressed() {
		this.getGame().setMenu();
	}

	@Override
	public void think(int delta) {
		this.clockRotate += delta / 10f;
		if (this.clockRotate >= 360) {
			this.clockRotate -= 360;
		}
	}

	@Override
	public void render(BitsGLGraphics g) {
		this.getGame().drawBackgroundCircle(g, 90, 400, 140, (int)this.clockRotate);
		this.getGame().drawBackgroundCircle(g, 350, 390, 160, (int)this.clockRotate);
		
		this.getGame().drawString(g, ApoHybridPuzzle.TITLE, 240, 1, ApoHybridPanel.title_font, new float[] {1, 1, 1, 1}, new float[] {0, 0, 0, 1});
		
		if (this.getGame().getButtons() != null) {
			for (int i = 0; i < this.getGame().getButtons().length; i++) {
				//#if !Editor
//@				if (this.getGame().getButtons()[i].getFunction().equals(EDITOR)) i++;
				//#endif
				if (this.getGame().getButtons()[i].isVisible()) {
					int x = (int)(this.getGame().getButtons()[i].getX());
					int y = (int)(this.getGame().getButtons()[i].getY());
					int width = (int)(this.getGame().getButtons()[i].getWidth());
					int height = (int)(this.getGame().getButtons()[i].getHeight());
					
					g.setColor(128, 128, 128, 255);
					g.fillRect(x, y, width, height);
					g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
					g.drawRect(x, y, width, height);
					
					this.getGame().drawString(g, this.getGame().getButtons()[i].getFunction(), x + width/2, y + height/2 - ApoHybridPanel.font.mCharCellHeight/2, ApoHybridPanel.font);
					
					for (int circle = 0; circle < 2; circle++) {
						x += circle * width;
						
						g.setColor(255, 255, 255, 255);
						g.fillCircle(x, y + height/2, height/2, 120);

						g.setLineSize(3.0f);
						g.setColor(48, 48, 48);
						g.drawCircle(x, y + height/2, height/2, 120);
						
						g.setLineSize(5.0f);
						for (int j = 0; j < 12; j++) {
							g.drawLine(x + (int)((height/2 - 5) * Math.sin(Math.toRadians(j * 30))), y + height/2 + (int)(-(height/2 - 5) * Math.cos(Math.toRadians(j * 30))), x + (int)((height/2) * Math.sin(Math.toRadians(j * 30))), y + height/2 + (int)(-(height/2) * Math.cos(Math.toRadians(j * 30))));
						}
						
						int angle = (int)(this.clockRotate + circle * 180) + i * 100;
						while (angle > 360) {
							angle -= 360;
						}
						g.drawLine(x, y + height/2, x + (int)((height/2 - 5) * Math.sin(Math.toRadians(angle))), y + height/2 + (int)(-(height/2 - 5) * Math.cos(Math.toRadians(angle))));

						g.setLineSize(1.0f);
					}
				}
			}
		}
		
//		this.getGame().renderButtons(g, ApoHybridMenu.font);
	}

}
//#endif
