package net.apogames.apohybrid.game;

import android.content.SharedPreferences;

import net.apogames.apohybrid.ApoHybrid;
import net.apogames.apohybrid.ApoHybridButtons;
import net.apogames.apohybrid.ApoHybridComponent;
import net.apogames.apohybrid.ApoHybridConstants;
import net.apogames.apohybrid.editor.ApoHybridUserlevels;

//#ifdef ClockGameLogic
import net.apogames.apoclock.editor.ApoClockUserlevels;
import net.apogames.apoclock.entity.ApoTextfield;
import net.apogames.apoclock.highscore.ApoClockHighscore;
import net.apogames.apoclock.highscore.ApoClockHighscoreLocal;

import net.gliblybits.bitsengine.graphics.opengl.BitsGLFactory;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLFont;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
import net.gliblybits.bitsengine.input.BitsInput;
import net.gliblybits.bitsengine.input.BitsKeyEvent;
//#elifdef SnakeGameLogic || DiceGameLogic
import net.gliblybits.bitsengine.core.BitsFont;
import net.gliblybits.bitsengine.core.BitsGame;
import net.gliblybits.bitsengine.render.BitsGraphics;
//#endif

public class ApoHybridPanel extends ApoHybridComponent {
	
	private ApoHybridMenu menu;
	
	private ApoHybridPuzzleChooser puzzle;

	private ApoHybridGame game;
	
	private ApoHybridEditor editor;

	private int think;

	//#ifdef ClockGameLogic	
	private ApoHybridUserlevels userlevels;

	private ApoHybridArcarde arcarde;

	private ApoHybridArcardeGame arcardeGame;
	
	private ApoHybridPuzzle puzzleFirst;

	private ApoHybridOptions options;
	
	private ApoHybridHighscoreLocal local;
	
	private ApoTextfield textfield;
	
	public static BitsGLFont font;
	public static BitsGLFont game_font;
	public static BitsGLFont title_font;
	//#endif

	public ApoHybridPanel(int id) {
		super(id);
	}
	
	public void init() {
		super.init();
		
		//#ifdef ClockGameLogic
		BitsGLGraphics.setClearColor(192f/255f, 192f/255f, 192f/255f, 1f);
		//#elifdef SnakeGameLogic || DiceGameLogic
		BitsGame.getIt().setClearColor(192f/255f, 192f/255f, 192f/255f, 1f);
		//#endif
		
		ApoHybridButtons buttons = new ApoHybridButtons(this);
		buttons.init();
		
		this.think = 0;
		
		if (this.menu == null) {
			this.menu = new ApoHybridMenu(this);
		}
		if (this.puzzle == null) {
			this.puzzle = new ApoHybridPuzzleChooser(this);
		}
		if (this.game == null) {
			this.game = new ApoHybridGame(this);
		}
		if (this.editor == null) {
			this.editor = new ApoHybridEditor(this);
		}
		
		//#ifdef ClockGameLogic
		if (this.arcarde == null) {
			this.arcarde = new ApoClockArcarde(this);
		}
		if (this.arcardeGame == null) {
			this.arcardeGame = new ApoClockArcardeGame(this);
		}
		if (this.puzzleFirst == null) {
			this.puzzleFirst = new ApoClockPuzzle(this);
		}
		if (this.options == null) {
			this.options = new ApoClockOptions(this);
		}
		if (this.local == null) {
			this.local = new ApoClockHighscoreLocal(this);
		}
		if (this.textfield == null) {
			this.textfield = new ApoTextfield(0, 0, 250, 40);
		}

		this.loadFonts();
		//#endif


		
		
		if (this.userlevels == null) {
			this.userlevels = new ApoHybridUserlevels(this);
			this.loadUserlevels();
		}
		this.setMenu();
		this.puzzle.init();
		
		//#ifdef ClockGameLogic
		this.loadPreferences();
		//#elifdef SnakeGameLogic || DiceGameLogic
		this.loadPreferences(ApoHybrid.settings);
		//#endif

	}
	
	//#ifdef ClockGameLogic
	private void loadFonts() {
		ApoClockPanel.font = BitsGLFactory.getInstance().getFont("reprise.ttf", 30, 4, true);
		BitsGLFactory.getInstance().markForLoading(ApoClockPanel.font);
		ApoClockPanel.title_font = BitsGLFactory.getInstance().getFont("reprise.ttf", 38, 2, true);
		BitsGLFactory.getInstance().markForLoading(ApoClockPanel.title_font);	
		ApoClockPanel.game_font = BitsGLFactory.getInstance().getFont("reprise.ttf", 26, 2, true);
		BitsGLFactory.getInstance().markForLoading(ApoClockPanel.game_font);
		
		BitsGLFactory.getInstance().loadAllMarked();
	}
	
	protected final void loadPreferences() {
		int solved = ApoClock.settings.getInt("solved", 0);
		
		String highscoreLocal = ApoClock.settings.getString("highscore", "");
		this.local.setHighscoreFromString(highscoreLocal);
		
		String name = ApoClock.settings.getString("name", "you");
		this.textfield.setCurString(name);
		this.solvedLevel(solved);
	}
	
	protected final void savePreferences() {
		SharedPreferences.Editor editor = ApoClock.settings.edit();
		editor.putInt("solved", this.getMaxCanChoosen());
		
		editor.putString("highscore", this.local.getString());
		editor.putString("name", this.textfield.getCurString());
		
		editor.commit();
	}

	public void setUserlevelsVisible() {
		if ((this.puzzleFirst != null) && (this.getModel().equals(this.puzzleFirst))) {
			this.puzzleFirst.setUserlevelsVisible();
		}
	}

	public final ApoClockHighscoreLocal getLocal() {
		return this.local;
	}

	
	//#elifdef SnakeGameLogic || DiceGameLogic
	protected final void loadPreferences(SharedPreferences settings) {
		int solved = settings.getInt("solved", 0);
		this.solvedLevel(solved);
	}
	
	protected final void savePreferences(SharedPreferences settings) {
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt("solved", this.getMaxCanChoosen());
		
		editor.commit();
	}

	public void setUserlevelsVisible() {
		if (this.getModel().equals(this.menu)) {
			this.menu.setUserlevels();
		}
	}
	//#endif

	
	
	public final void loadUserlevels() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				ApoHybridPanel.this.userlevels.loadUserlevels();
			}
 		});
 		t.start();
	}
	
	
	
	public final ApoHybridUserlevels getUserlevels() {
		return this.userlevels;
	}

	protected final void setMenu() {
		if (super.getModel() != null) {
			super.getModel().close();
		}
		
		super.setModel(this.menu);
		
		this.setButtonVisible(ApoHybridConstants.BUTTON_MENU);
		
		super.getModel().init();

		//#ifdef ClockGameLogic
		this.textfield.setVisible(false);
		//#endif

	}
	
	protected final void setEditor(boolean bSolvedLevel) {
		if (super.getModel() != null) {
			super.getModel().close();
		}
		
		super.setModel(this.editor);
		
		this.setButtonVisible(ApoHybridConstants.BUTTON_EDITOR);
		
		this.editor.setLevelSolved(bSolvedLevel);
		super.getModel().init();
		
		//#ifdef ClockGameLogic
		this.textfield.setVisible(false);
		//#endif
	}
	//#ifdef ClockGameLogic
	protected final void setPuzzle() {
		if (super.getModel() != null) {
			super.getModel().close();
		}
		
		super.setModel(this.puzzleFirst);
		
		this.setButtonVisible(ApoHybridConstants.BUTTON_PUZZLE_FIRST);
		
		super.getModel().init();
		
		this.textfield.setVisible(false);
	}
	
	protected final void setOptions() {
		if (super.getModel() != null) {
			super.getModel().close();
		}
		
		super.setModel(this.options);
		
		this.setButtonVisible(ApoHybridConstants.BUTTON_OPTIONS);
		
		super.getModel().init();
		
		this.textfield.setVisible(true);
	}

	protected final void setAracardeHelp(final int points, final int clocks) {
		if (super.getModel() != null) {
			super.getModel().close();
		}
		
		super.setModel(this.arcarde);
		
		this.setButtonVisible(ApoHybridConstants.BUTTON_ARCARDE);
		
		this.arcarde.setPoints(points, clocks);
		super.getModel().init();
		
		this.textfield.setVisible(true);
	}
	
	protected final void setAracardeGame() {
		if (super.getModel() != null) {
			super.getModel().close();
		}
		
		super.setModel(this.arcardeGame);
		
		this.setButtonVisible(ApoHybridConstants.BUTTON_ARCARDE_GAME);
		
		super.getModel().init();
		
		this.textfield.setVisible(false);
	}

	public boolean onKeyDown(final int key, final BitsKeyEvent event) {
		if (super.getModel() != null) {
			super.getModel().onKeyDown(key, event);
		}
		
		return true;
	}

	public boolean onKeyUp(final int key, final BitsKeyEvent event) {
		if (super.getModel() != null) {
			if ((this.textfield.isVisible()) && (this.textfield.isSelect())) {
				if( event.isNumber() || event.isLetter() || key == BitsKeyEvent.KEY_SPACE ) {
					this.textfield.addValue(String.valueOf(event.mUnicodeChar));
				}
				
				if (key == BitsKeyEvent.KEY_DEL) {
					this.textfield.deleteValue();
				}
				if(key == BitsKeyEvent.KEY_ENTER) {
					if (this.textfield.isSelect()) {
						BitsInput.getInstance().setVirtualKeyboardVisible(false);
					}
					this.textfield.setSelect(false);
					this.savePreferences();
				}
			} else {
				super.getModel().onKeyUp(key, event);
			}
		}
		
		return true;
	}
	
	public ApoTextfield getTextfield() {
		return this.textfield;
	}

	public ApoHybridHighscore getHighscore() {
		return this.arcarde.getHighscore();
	}

	public void drawBackgroundCircle(final BitsGLGraphics g, final int x, final int y, final int height, final int clockRotate) {
		g.setLineSize(3.0f);
		g.setColor(48, 48, 48);
		g.drawCircle(x, y + height/2, height/2, 120);
		
		g.setLineSize(5.0f);
		for (int j = 0; j < 12; j++) {
			g.drawLine(x + (int)((height/2 - 5) * Math.sin(Math.toRadians(j * 30))), y + height/2 + (int)(-(height/2 - 5) * Math.cos(Math.toRadians(j * 30))), x + (int)((height/2) * Math.sin(Math.toRadians(j * 30))), y + height/2 + (int)(-(height/2) * Math.cos(Math.toRadians(j * 30))));
		}
		
		int angle = (int)(clockRotate + x) + y;
		while (angle > 360) {
			angle -= 360;
		}
		g.drawLine(x, y + height/2, x + (int)((height/2 - 5) * Math.sin(Math.toRadians(angle))), y + height/2 + (int)(-(height/2 - 5) * Math.cos(Math.toRadians(angle))));

		g.setLineSize(1.0f);
	}
	//#endif
	protected final void setPuzzleChooser() {
		if (super.getModel() != null) {
			super.getModel().close();
		}
		
		super.setModel(this.puzzle);
		
		this.setButtonVisible(ApoHybridConstants.BUTTON_PUZZLE);
		
		super.getModel().init();

		//#ifdef ClockGameLogic
		this.textfield.setVisible(false);
		//#endif
	}
	
	protected final void setPuzzleGame(final int level, final String levelString, final boolean bUserLevel) {
		if (super.getModel() != null) {
			super.getModel().close();
		}
		
		super.setModel(this.game);
		
		this.setButtonVisible(ApoHybridConstants.BUTTON_GAME);
		
		super.getModel().init();
		
		//#ifdef ClockGameLogic
		if (levelString != null) {
			this.game.loadLevelWithString(levelString, true);
		} else {
			this.game.loadLevel(level, bUserLevel);
		}
		
		this.textfield.setVisible(false);
		//#elifdef SnakeGameLogic || DiceGameLogic
		this.game.loadLevel(level, bUserLevel, levelString);
		//#endif
	}

	
	public final void setButtonVisible(boolean[] bVisibile) {
		for (int i = 0; i < this.getButtons().length && i < bVisibile.length; i++) {
			this.getButtons()[i].setVisible(bVisibile[i]);
		}
	}
	
	@Override
	public void setButtonFunction(final String function) {
		if (super.getModel() != null) {
			super.getModel().touchedButton(function);
		}
	}
	
	@Override
	//#ifdef ClockGameLogic
	public void onResumeScreen() {
	//#elifdef SnakeGameLogic || DiceGameLogic
	public void onResume() {
	//#endif
		if (super.getModel() != null) {
			super.getModel().onResume();
		}
	}
	
	public void onBackButtonPressed() {
		if (super.getModel() != null) {
			super.getModel().onBackButtonPressed();
		}
	}
	
	public int getMaxCanChoosen() {
		return this.puzzle.getSolved();
	}
	
	public void solvedLevel(int level) {
		this.puzzle.setSolved(level);
	}
	
	public void onUpdate(float delta) {
		super.onUpdate(delta);
		
		//#ifdef ClockGameLogic
		this.think += delta;
		//#elifdef SnakeGameLogic || DiceGameLogic
		this.think += delta * 1000;
		//#endif

		//#if SnakeGameLogic
//@		this.checkTouchInput();
		//#endif

		// Update / think
		// Wenn 10 ms vergangen sind, dann denke nach
		while (this.think >= 10) {
			this.think -= 10;
			if (super.getModel() != null) {
				super.getModel().think((int)10);
				//#ifdef ClockGameLogic
				this.textfield.think(10);
				//#endif

			}	
		}
	}

	@Override
	//#ifdef ClockGameLogic
	public void onDrawFrame(BitsGLGraphics g) {
	//#elifdef SnakeGameLogic || DiceGameLogic
	public void onDrawFrame(BitsGraphics g) {	
	//#endif
		if (super.getModel() != null) {
			super.getModel().render(g);
		}
		super.renderButtons(g);
		if (super.getModel() != null) {
			super.getModel().drawOverlay(g);
		}
	}
	
	//#ifdef ClockGameLogic
	public void drawString(BitsGLGraphics g, final String s, final int x, final int y, final BitsGLFont font) {
	//#elifdef SnakeGameLogic || DiceGameLogic
	protected void drawString(BitsGraphics g, final String s, final int x, final int y, final BitsFont font) {		
	//#endif
		this.drawString(g, s, x, y, font, new float[] {0, 0, 0, 1}, new float[] {1, 1, 1, 1});
	}
	
	//#ifdef ClockGameLogic
	protected void drawString(BitsGLGraphics g, final String s, final int x, final int y, final BitsGLFont font, float[] colorBack, float[] colorFront) {
	//#elifdef SnakeGameLogic || DiceGameLogic
	protected void drawString(BitsGraphics g, final String s, final int x, final int y, final BitsFont font, float[] colorBack, float[] colorFront) {
	//#endif
		int w = 0;
		if (super.getModel().getStringWidth().containsKey(s)) {
			w = super.getModel().getStringWidth().get(s);
		}
		
		g.setColor(colorBack[0], colorBack[1], colorBack[2], colorBack[3]);
		//#ifdef ClockGameLogic
		g.setFont(font);
		g.drawText(s, x - w/2 + 1, y + 2 - font.mCharCellHeight/6);
		g.setColor(colorFront[0], colorFront[1], colorFront[2], colorFront[3]);
		g.drawText(s, x - w/2 + 0, y + 0 - font.mCharCellHeight/6);
		//#elifdef SnakeGameLogic || DiceGameLogic
		g.drawText(s, font, x - w/2 + 1, y + 2);
		g.setColor(colorFront[0], colorFront[1], colorFront[2], colorFront[3]);
		g.drawText(s, font, x - w/2 + 0, y + 0);
		//#endif
	}
	
	//#ifdef ClockGameLogic
	public void renderButtons(final BitsGLGraphics g) {
		this.renderButtons(g, ApoHybridPanel.font);
	}

	public void renderButtons(final BitsGLGraphics g, final BitsGLFont font) {
		if (this.getButtons() != null) {
			for (int i = 0; i < this.getButtons().length; i++) {
				if (this.getButtons()[i].isVisible()) {
					int x = (int)(this.getButtons()[i].getX());
					int y = (int)(this.getButtons()[i].getY());
					int width = (int)(this.getButtons()[i].getWidth());
					int height = (int)(this.getButtons()[i].getHeight());
					
					g.setColor(160, 160, 160, 255);
					g.fillRect(x, y, width, height);
					g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
					g.drawRect(x, y, width, height);
					
					this.drawString(g, this.getButtons()[i].getFunction(), x + width/2, y + height/2 - font.mCharCellHeight/2, font);
				}
			}
		}
	}
	//#elifdef SnakeGameLogic || DiceGameLogic
	public void renderButtons(BitsGraphics g) {
		this.renderButtons(g, ApoHybridMenu.font);
	}

	public void renderButtons(BitsGraphics g, final BitsFont font) {
		if (this.getButtons() != null) {
			for (int i = 0; i < this.getButtons().length; i++) {
				if (this.getButtons()[i].isBVisible()) {
					int x = (int)(this.getButtons()[i].getX());
					int y = (int)(this.getButtons()[i].getY());
					int width = (int)(this.getButtons()[i].getWidth());
					int height = (int)(this.getButtons()[i].getHeight());
					
					g.setColor(160, 160, 160, 255);
					g.drawFilledRoundRect(x, y, width, height, 6, 10);
					g.setLineSize(2.0f);
					g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
					g.drawRoundRect(x, y, width, height, 6, 10);
					g.setLineSize(1.0f);
					
					this.drawString(g, this.getButtons()[i].getFunction(), x + width/2, y + height/2 - font.mCharCellHeight/2 - 3, font);
				}
			}
		}
	}
	//#endif

	
	

	public void renderButtons(BitsGraphics g, final BitsFont font) {
		if (this.getButtons() != null) {
			for (int i = 0; i < this.getButtons().length; i++) {
				if (this.getButtons()[i].isBVisible()) {
					int x = (int)(this.getButtons()[i].getX());
					int y = (int)(this.getButtons()[i].getY());
					int width = (int)(this.getButtons()[i].getWidth());
					int height = (int)(this.getButtons()[i].getHeight());
					
					g.setColor(160, 160, 160, 255);
					g.drawFilledRoundRect(x, y, width, height, 6, 10);
					g.setLineSize(2.0f);
					g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
					g.drawRoundRect(x, y, width, height, 6, 10);
					g.setLineSize(1.0f);
					
					this.drawString(g, this.getButtons()[i].getFunction(), x + width/2, y + height/2 - font.mCharCellHeight/2 - 3, font);
				}
			}
		}
	}
}
