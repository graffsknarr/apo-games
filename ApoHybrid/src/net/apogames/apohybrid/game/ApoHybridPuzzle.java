//#if ClockGameLogic
//@package net.apogames.apohybrid.game;
//@
//@import net.apogames.apohybrid.ApoHybridModel;
//@import net.apogames.apohybrid.level.ApoHybridLevel;
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//@
//@public class ApoHybridPuzzle extends ApoHybridModel {
//@
//@	public static final String BACK = "back";
//@	public static final String PUZZLE = "puzzle";
//@	public static final String USERLEVELS = "userlevels";
//@	public static final String EDITOR = "editor";
//@	public static final String TITLE = "ApoHybrid - Play";
//@	
//@	private float clockRotate;
//@	
//@	public ApoHybridPuzzle(ApoHybridPanel game) {
//@		super(game);
//@	}
//@
//@	@Override
//@	public void init() {
//@		this.getStringWidth().put(ApoHybridPuzzle.BACK, (int)(ApoHybridPanel.font.getLength(ApoHybridPuzzle.BACK)));
//@		this.getStringWidth().put(ApoHybridPuzzle.PUZZLE, (int)(ApoHybridPanel.font.getLength(ApoHybridPuzzle.PUZZLE)));
//@		this.getStringWidth().put(ApoHybridPuzzle.TITLE, (int)(ApoHybridPanel.title_font.getLength(ApoHybridPuzzle.TITLE)));
//@		this.getStringWidth().put(ApoHybridMenu.ARCADE, (int)(ApoHybridPanel.font.getLength(ApoHybridMenu.ARCADE)));
//@
//@
//@		this.setUserlevelsVisible();
//@	}
//@	
//@	public void setUserlevelsVisible() {
//@		if ((ApoHybridLevel.editorLevels == null) || (ApoHybridLevel.editorLevels.length <= 0)) {
//@			this.getGame().getButtons()[10].setVisible(false);
//@		} else {
//@			this.getGame().getButtons()[10].setVisible(true);
//@		}
//@	}
//@
//@	@Override
//@	public void touchedPressed(int x, int y, int finger) {
//@		
//@	}
//@
//@	@Override
//@	public void touchedReleased(int x, int y, int finger) {
//@		
//@	}
//@
//@	@Override
//@	public void touchedDragged(int x, int y, int oldX, int oldY, int finger) {
//@		
//@	}
//@
//@	@Override
//@	public void touchedButton(String function) {
//@		if (function.equals(ApoHybridPuzzle.BACK)) {
//@			this.onBackButtonPressed();
//@		} else if (function.equals(ApoHybridPuzzle.PUZZLE)) {
//@			this.getGame().setPuzzleChooser();
//@		} else if (function.equals(ApoHybridMenu.ARCADE)) {
//@			this.getGame().setAracardeHelp(-1, -1);
//@		}
//@	}
//@	
//@	public void onBackButtonPressed() {
//@		this.getGame().setMenu();
//@	}
//@
//@	@Override
//@	public void think(int delta) {
//@		this.clockRotate += delta / 10f;
//@		if (this.clockRotate >= 360) {
//@			this.clockRotate -= 360;
//@		}
//@	}
//@
//@	@Override
//@	public void render(BitsGLGraphics g) {
//@		this.getGame().drawString(g, ApoHybridPuzzle.TITLE, 240, 1, ApoHybridPanel.title_font, new float[] {1, 1, 1, 1}, new float[] {0, 0, 0, 1});
//@		
//@		if (this.getGame().getButtons() != null) {
//@			for (int i = 0; i < this.getGame().getButtons().length; i++) {
//@				if (this.getGame().getButtons()[i].isVisible()) {
//@					int x = (int) (this.getGame().getButtons()[i].getX());
//@					int y = (int) (this.getGame().getButtons()[i].getY());
//@					int width = (int) (this.getGame().getButtons()[i].getWidth());
//@					int height = (int) (this.getGame().getButtons()[i].getHeight());
//@					String text = this.getGame().getButtons()[i].getFunction();
//@
//@					g.setColor(128, 128, 128, 255);
//@					g.fillRect(x, y, width, height);
//@					g.setColor(48f / 255f, 48f / 255f, 48f / 255f, 1.0f);
//@					g.drawRect(x, y, width, height);
//@
//@					this.getGame().drawString(g, this.getGame().getButtons()[i].getFunction(), x + width / 2, y + height / 2 - ApoHybridPanel.font.mCharCellHeight / 2, ApoHybridPanel.font);
//@
//@				}
//@			}
//@		}
//@		
//@//		this.getGame().renderButtons(g, ApoHybridMenu.font);
//@	}
//@
//@}
//#endif
