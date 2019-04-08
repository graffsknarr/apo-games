package net.apogames.apohybrid.game;

import android.content.SharedPreferences;

import net.apogames.apohybrid.ApoHybrid;
import net.apogames.apohybrid.ApoHybridButtons;
import net.apogames.apohybrid.ApoHybridComponent;
import net.apogames.apohybrid.ApoHybridConstants;
import net.apogames.apohybrid.editor.ApoHybridUserlevels;

//#if MonoGameLogic
import net.apogames.apohybrid.ApoHybridMusicPlayer;
import net.apogames.apohybrid.ApoHybridSoundPlayer;
import net.apogames.apohybrid.entity.ApoLevelChooserButton;
import net.apogames.apohybrid.level.ApoHybridLevel;
import net.apogames.apohybrid.userlevels.ApoHybridSave;
import net.gliblybits.bitsengine.graphics.BitsFont;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLFactory;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLFont;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
import net.gliblybits.bitsengine.sound.BitsSound;


//#elif ClockGameLogic
//@import net.apogames.apohybrid.entity.ApoTextfield;
//@import net.apogames.apohybrid.highscore.ApoHybridHighscore;
//@import net.apogames.apohybrid.highscore.ApoHybridHighscoreLocal;
//@import net.apogames.apohybrid.editor.ApoHybridUserlevels;
//@import net.apogames.apohybrid.entity.ApoTextfield;
//@import net.apogames.apohybrid.highscore.ApoHybridHighscore;
//@import net.apogames.apohybrid.highscore.ApoHybridHighscoreLocal;
//@
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLFactory;
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLFont;
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//@import net.gliblybits.bitsengine.input.BitsInput;
//@import net.gliblybits.bitsengine.input.BitsKeyEvent;
//#elif SnakeGameLogic || DiceGameLogic
//@import net.gliblybits.bitsengine.core.BitsFont;
//@import net.gliblybits.bitsengine.core.BitsGame;
//@import net.gliblybits.bitsengine.render.BitsGraphics;
//#endif


public class ApoHybridPanel extends ApoHybridComponent {
	
	private ApoHybridMenu menu;
	
	private ApoHybridPuzzleChooser puzzle;

	private ApoHybridGame game;
	
	private ApoHybridEditor editor;

	private int think;

	private ApoHybridUserlevels userlevels;


	//#if ClockGameLogic	
//@
//@	private ApoHybridArcarde arcarde;
//@
//@	private ApoHybridArcardeGame arcardeGame;
//@	
//@	private ApoHybridPuzzle puzzleFirst;
//@
//@	private ApoHybridOptions options;
//@
//@	private ApoHybridHighscoreLocal local;
//@	
//@	private ApoTextfield textfield;
//@	
//@	public static BitsGLFont font;
//@	public static BitsGLFont game_font;
//@	public static BitsGLFont title_font;
//@
	//#elif MonoGameLogic
	public static BitsGLFont font;
	public static BitsGLFont game_font;
	public static BitsGLFont title_font;

	private ApoHybridCredits credits;
	private ApoHybridOptions options;
	private ApoHybridSave solvedLevels;


	private boolean bSound, bMusic;
	
	private ApoHybridMusicPlayer musicPlayer;
	
	private ApoHybridSoundPlayer soundPlayer;
	//#endif

	public ApoHybridPanel(int id) {
		super(id);
	}
	
	public void init() {
		super.init();
		
		//#if ClockGameLogic
//@		BitsGLGraphics.setClearColor(192f/255f, 192f/255f, 192f/255f, 1f);
		//#elif MonoGameLogic
		BitsGLGraphics.setClearColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
		//#elif SnakeGameLogic || DiceGameLogic
//@		BitsGame.getIt().setClearColor(192f/255f, 192f/255f, 192f/255f, 1f);
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
			//#if Editor
//@			this.editor = new ApoHybridEditor(this);
			//#endif
		}
		
		//#if ClockGameLogic
//@		if (this.arcarde == null) {
//@			this.arcarde = new ApoHybridArcarde(this);
//@		}
//@		if (this.arcardeGame == null) {
//@			this.arcardeGame = new ApoHybridArcardeGame(this);
//@		}
//@		if (this.puzzleFirst == null) {
//@			this.puzzleFirst = new ApoHybridPuzzle(this);
//@		}
//@		if (this.options == null) {
//@			this.options = new ApoHybridOptions(this);
//@		}
//@		if (this.local == null) {
//@			this.local = new ApoHybridHighscoreLocal(this);
//@		}
//@		if (this.textfield == null) {
//@			this.textfield = new ApoTextfield(0, 0, 250, 40);
//@		}
//@
//@		this.loadFonts();
//@		
		//#elif MonoGameLogic
		if (this.credits == null) {
			this.credits = new ApoHybridCredits(this);
		}

		if (this.options == null) {
			this.options = new ApoHybridOptions(this);
		}

		if (this.solvedLevels == null) {
			this.solvedLevels = new ApoHybridSave();
		}
		if (this.musicPlayer == null) {
			this.musicPlayer = new ApoHybridMusicPlayer(this);
		}
		if (this.soundPlayer == null) {
			this.soundPlayer = new ApoHybridSoundPlayer();
		}
		
		this.loadFonts();

		
		//#endif


		
		
		if (this.userlevels == null) {
			this.userlevels = new ApoHybridUserlevels(this);
			this.loadUserlevels();
		}
		this.setMenu();
		//#if !MonoGameLogic
//@		this.puzzle.init();
		//#endif
		
		//#if ClockGameLogic || MonoGameLogic
		this.loadPreferences();
		//#elif SnakeGameLogic || DiceGameLogic
//@		this.loadPreferences(ApoHybrid.settings);
		//#endif

	}
	
	//#if ClockGameLogic
//@	private void loadFonts() {
//@		ApoHybridPanel.font = BitsGLFactory.getInstance().getFont("reprise.ttf", 30, 4, true);
//@		BitsGLFactory.getInstance().markForLoading(ApoHybridPanel.font);
//@		ApoHybridPanel.title_font = BitsGLFactory.getInstance().getFont("reprise.ttf", 38, 2, true);
//@		BitsGLFactory.getInstance().markForLoading(ApoHybridPanel.title_font);	
//@		ApoHybridPanel.game_font = BitsGLFactory.getInstance().getFont("reprise.ttf", 26, 2, true);
//@		BitsGLFactory.getInstance().markForLoading(ApoHybridPanel.game_font);
//@		
//@		BitsGLFactory.getInstance().loadAllMarked();
//@	}
//@	
//@	protected final void loadPreferences() {
//@		int solved = ApoHybrid.settings.getInt("solved", 0);
//@		
//@		String highscoreLocal = ApoHybrid.settings.getString("highscore", "");
//@		this.local.setHighscoreFromString(highscoreLocal);
//@		
//@		String name = ApoHybrid.settings.getString("name", "you");
//@		this.textfield.setCurString(name);
//@		this.solvedLevel(solved);
//@	}
//@	
//@	protected final void savePreferences() {
//@		SharedPreferences.Editor editor = ApoHybrid.settings.edit();
//@		editor.putInt("solved", this.getMaxCanChoosen());
//@		
//@		editor.putString("highscore", this.local.getString());
//@		editor.putString("name", this.textfield.getCurString());
//@		
//@		editor.commit();
//@	}
//@
//@	public void setUserlevelsVisible() {
//@		if ((this.puzzleFirst != null) && (this.getModel().equals(this.puzzleFirst))) {
//@			this.puzzleFirst.setUserlevelsVisible();
//@		}
//@	}
//@
//@	public final ApoHybridHighscoreLocal getLocal() {
//@		return this.local;
//@	}
//@
	//#elif MonoGameLogic
	private void loadFonts() {
		ApoHybridPanel.font = BitsGLFactory.getInstance().getFont("res/font/font.ttf", 24, +4, BitsGLFont.FILTER_NEAREST, true);
//		ApoHybridPanel.font.mFilterMode = BitsGLFont.FILTER_NEAREST;
//		BitsGLFactory.getInstance().markForLoading(font);
		
		ApoHybridPanel.title_font = BitsGLFactory.getInstance().getFont("res/font/font.ttf", 36, +6, BitsGLFont.FILTER_NEAREST, true);
//		ApoHybridPanel.title_font.mFilterMode = BitsGLFont.FILTER_NEAREST;
//		BitsGLFactory.getInstance().markForLoading(title_font);
			
		ApoHybridPanel.game_font = BitsGLFactory.getInstance().getFont("res/font/font.ttf", 18, +3, BitsGLFont.FILTER_NEAREST, true);
//		ApoHybridPanel.game_font.mFilterMode = BitsGLFont.FILTER_NEAREST;
//		BitsGLFactory.getInstance().markForLoading(game_font);
		
		BitsGLFactory.getInstance().loadAllMarked();
	}

	
	protected final void loadPreferences() {
		SharedPreferences settings = ApoHybrid.settings;
		boolean english = settings.getBoolean("language", true);
		boolean colorGreen = settings.getBoolean("color", true);
		boolean bSound = settings.getBoolean("sound", true);
		boolean bMusic = settings.getBoolean("music", true);
		this.loadOptions(english, colorGreen, bSound, bMusic);
		
		String solvedLevels = settings.getString("solvedLevels", "");
		this.solvedLevels.createArrayFromString(solvedLevels);

//		ApoHybridConstants.FREE_VERSION = !settings.getBoolean("premium", false);
	}
	
	private void loadOptions(boolean bEnglish, boolean bColorGreen, boolean bSound, boolean bMusic) {
		((ApoLevelChooserButton)(this.getButtons()[12])).setSelected(!bEnglish);
		((ApoLevelChooserButton)(this.getButtons()[13])).setSelected(bEnglish);
		((ApoLevelChooserButton)(this.getButtons()[14])).setSelected(!bColorGreen);
		((ApoLevelChooserButton)(this.getButtons()[15])).setSelected(bColorGreen);
		
		if (bEnglish) {
			ApoHybridConstants.changeLanguageToEnglish();
		} else {
			ApoHybridConstants.changeLanguageToGerman();			
		}
		
		if (bColorGreen) {
			ApoHybridConstants.changeToGreenColor();
		} else {
			ApoHybridConstants.changeToWhiteColor();			
		}
		

		((ApoLevelChooserButton)(this.getButtons()[21])).setSelected(bSound);
		((ApoLevelChooserButton)(this.getButtons()[22])).setSelected(bMusic);
		this.setSound(bSound);
		this.setMusic(bMusic);
	}
	
	public boolean isMusicOn() {
		return bMusic;
	}

	public void setSound(boolean bSound) {
		this.bSound = bSound;
	}
	
	public void playSound(BitsSound sound) {
		if (this.bSound) {
			this.soundPlayer.playSound(sound);
		}
	}
	
	public void setMusic(boolean bMusic) {
		this.bMusic = bMusic;
		
		if (this.bMusic) {
			this.musicPlayer.load();
		} else {
			this.musicPlayer.stop();
		}
	}

	protected final void savePreferences() {
		SharedPreferences settings = ApoHybrid.settings;
		SharedPreferences.Editor editor = settings.edit();
		boolean bEnglish = true;
		if (((ApoLevelChooserButton)(this.getButtons()[12])).isSelected()) {
			bEnglish = false;
		}
		editor.putBoolean("language", bEnglish);
		boolean bColorGreen = true;
		if (((ApoLevelChooserButton)(this.getButtons()[14])).isSelected()) {
			bColorGreen = false;
		}
		editor.putBoolean("color", bColorGreen);
		
		boolean bSound = true;
		if (!((ApoLevelChooserButton)(this.getButtons()[21])).isSelected()) {
			bSound = false;
		}
		editor.putBoolean("sound", bSound);
		
		boolean bMusic = true;
		if (!((ApoLevelChooserButton)(this.getButtons()[22])).isSelected()) {
			bMusic = false;
		}
		editor.putBoolean("music", bMusic);
		
		editor.putString("solvedLevels", this.solvedLevels.getSaveString());

		editor.putBoolean("premium", !ApoHybridConstants.FREE_VERSION);
		
		editor.commit();
	}

	@Override
	public void onFinishScreen() {
		this.savePreferences();
	}
	
	protected final void setCredits() {
		if (super.getModel() != null) {
			super.getModel().close();
		}
		
		super.setModel(this.credits);
		
		this.setButtonVisible(ApoHybridConstants.BUTTON_CREDITS);
		
		super.getModel().init();

		this.musicPlayer.setMenu(true);
	}	

	protected final void setOptions() {
		if (super.getModel() != null) {
			super.getModel().close();
		}
		
		super.setModel(this.options);
		
		this.setButtonVisible(ApoHybridConstants.BUTTON_OPTIONS);
		
		super.getModel().init();

		this.musicPlayer.setMenu(true);
	}

	public ApoHybridSave getSolvedLevels() {
		return this.solvedLevels;
	}

	public void setUserlevelsVisible() {
		if (this.getModel() instanceof ApoHybridMenu) {
			this.getButtons()[8].setVisible(true);
		}
	}

	protected void solveLevel(int level) {
		this.solvedLevels.setLevelToSolved(level);
				
		this.savePreferences();
		
		this.levelChooser.solveLevel(level);
	}

	@Override
	public void onPauseScreen() {
		if (this.musicPlayer != null) {
			this.musicPlayer.stop();
			this.musicPlayer.release();
		}
	}
	

	//#elif SnakeGameLogic || DiceGameLogic
//@	protected final void loadPreferences(SharedPreferences settings) {
//@		int solved = settings.getInt("solved", 0);
//@		this.solvedLevel(solved);
//@	}
//@	
//@	protected final void savePreferences(SharedPreferences settings) {
//@		SharedPreferences.Editor editor = settings.edit();
//@		editor.putInt("solved", this.getMaxCanChoosen());
//@		
//@		editor.commit();
//@	}
//@
//@	public void setUserlevelsVisible() {
//@		if (this.getModel().equals(this.menu)) {
//@			this.menu.setUserlevels();
//@		}
//@	}
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

		//#if MonoGameLogic
		if ((ApoHybridLevel.editorLevels != null) && (ApoHybridLevel.editorLevels.length > 0)) {
			this.getButtons()[8].setVisible(true);
		}

		
		this.musicPlayer.setMenu(true);
	

		//#elif ClockGameLogic
//@		this.textfield.setVisible(false);
		//#endif

	}
	
	//#if MonoGameLogic
	protected final void setEditor(boolean bUpload) {
	//#else	
//@	protected final void setEditor(boolean bSolvedLevel) {
	//#endif		
		if (super.getModel() != null) {
			super.getModel().close();
		}
		
		super.setModel(this.editor);
		
		this.setButtonVisible(ApoHybridConstants.BUTTON_EDITOR);

		super.getModel().init();

		//#if MonoGameLogic
		this.editor.setUploadVisible(bUpload);
		this.musicPlayer.setMenu(true);

		//#else
//@		this.editor.setLevelSolved(bSolvedLevel);
		//#endif
		
		//#if ClockGameLogic
//@		this.textfield.setVisible(false);
		//#endif
	}
	//#if ClockGameLogic
//@	protected final void setPuzzle() {
//@		if (super.getModel() != null) {
//@			super.getModel().close();
//@		}
//@		
//@		super.setModel(this.puzzleFirst);
//@		
//@		this.setButtonVisible(ApoHybridConstants.BUTTON_PUZZLE_FIRST);
//@		
//@		super.getModel().init();
//@		
//@		this.textfield.setVisible(false);
//@	}
//@	
//@	protected final void setOptions() {
//@		if (super.getModel() != null) {
//@			super.getModel().close();
//@		}
//@		
//@		super.setModel(this.options);
//@		
//@		this.setButtonVisible(ApoHybridConstants.BUTTON_OPTIONS);
//@		
//@		super.getModel().init();
//@		
//@		this.textfield.setVisible(true);
//@	}
//@
//@	protected final void setAracardeHelp(final int points, final int clocks) {
//@		if (super.getModel() != null) {
//@			super.getModel().close();
//@		}
//@		
//@		super.setModel(this.arcarde);
//@		
//@		this.setButtonVisible(ApoHybridConstants.BUTTON_ARCARDE);
//@		
//@		this.arcarde.setPoints(points, clocks);
//@		super.getModel().init();
//@		
//@		this.textfield.setVisible(true);
//@	}
//@	
//@	protected final void setAracardeGame() {
//@		if (super.getModel() != null) {
//@			super.getModel().close();
//@		}
//@		
//@		super.setModel(this.arcardeGame);
//@		
//@		this.setButtonVisible(ApoHybridConstants.BUTTON_ARCARDE_GAME);
//@		
//@		super.getModel().init();
//@		
//@		this.textfield.setVisible(false);
//@	}
//@
//@	public boolean onKeyDown(final int key, final BitsKeyEvent event) {
//@		if (super.getModel() != null) {
//@			super.getModel().onKeyDown(key, event);
//@		}
//@		
//@		return true;
//@	}
//@
//@	public boolean onKeyUp(final int key, final BitsKeyEvent event) {
//@		if (super.getModel() != null) {
//@			if ((this.textfield.isVisible()) && (this.textfield.isSelect())) {
//@				if( event.isNumber() || event.isLetter() || key == BitsKeyEvent.KEY_SPACE ) {
//@					this.textfield.addValue(String.valueOf(event.mUnicodeChar));
//@				}
//@				
//@				if (key == BitsKeyEvent.KEY_DEL) {
//@					this.textfield.deleteValue();
//@				}
//@				if(key == BitsKeyEvent.KEY_ENTER) {
//@					if (this.textfield.isSelect()) {
//@						BitsInput.getInstance().setVirtualKeyboardVisible(false);
//@					}
//@					this.textfield.setSelect(false);
//@					this.savePreferences();
//@				}
//@			} else {
//@				super.getModel().onKeyUp(key, event);
//@			}
//@		}
//@		
//@		return true;
//@	}
//@	
//@	public ApoTextfield getTextfield() {
//@		return this.textfield;
//@	}
//@
//@	public ApoHybridHighscore getHighscore() {
//@		return this.arcarde.getHighscore();
//@	}
//@
//@	public void drawBackgroundCircle(final BitsGLGraphics g, final int x, final int y, final int height, final int clockRotate) {
//@		g.setLineSize(3.0f);
//@		g.setColor(48, 48, 48);
//@		g.drawCircle(x, y + height/2, height/2, 120);
//@		
//@		g.setLineSize(5.0f);
//@		for (int j = 0; j < 12; j++) {
//@			g.drawLine(x + (int)((height/2 - 5) * Math.sin(Math.toRadians(j * 30))), y + height/2 + (int)(-(height/2 - 5) * Math.cos(Math.toRadians(j * 30))), x + (int)((height/2) * Math.sin(Math.toRadians(j * 30))), y + height/2 + (int)(-(height/2) * Math.cos(Math.toRadians(j * 30))));
//@		}
//@		
//@		int angle = (int)(clockRotate + x) + y;
//@		while (angle > 360) {
//@			angle -= 360;
//@		}
//@		g.drawLine(x, y + height/2, x + (int)((height/2 - 5) * Math.sin(Math.toRadians(angle))), y + height/2 + (int)(-(height/2 - 5) * Math.cos(Math.toRadians(angle))));
//@
//@		g.setLineSize(1.0f);
//@	}
	//#endif
	protected final void setPuzzleChooser() {
		if (super.getModel() != null) {
			super.getModel().close();
		}
		
		super.setModel(this.puzzle);
		
		this.setButtonVisible(ApoHybridConstants.BUTTON_LEVELCHOOSER);
		
		super.getModel().init();

		//#if MonoGameLogic

		this.musicPlayer.setMenu(true);
		//#elif ClockGameLogic
//@		this.textfield.setVisible(false);
		//#endif
	}
	
	protected final void setPuzzleGame(final int level, final String levelString, final boolean bUserlevel) {
		if (super.getModel() != null) {
			super.getModel().close();
		}
		
		super.setModel(this.game);
		
		this.setButtonVisible(ApoHybridConstants.BUTTON_GAME);
		
		super.getModel().init();
		
		//#if MonoGameLogic
		this.game.loadLevel(level, bUserlevel, levelString);
		this.musicPlayer.setMenu(false);

	
		//#elif ClockGameLogic
//@		if (levelString != null) {
//@			this.game.loadLevelWithString(levelString, true);
//@		} else {
//@			this.game.loadLevel(level, bUserLevel);
//@		}
//@		
//@		this.textfield.setVisible(false);
		//#elif SnakeGameLogic || DiceGameLogic
//@		this.game.loadLevel(level, bUserLevel, levelString);
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
	//#if SnakeGameLogic || DiceGameLogic
//@	public void onResume() {
	//#elif ClockGameLogic || MonoGameLogic
	public void onResumeScreen() {
	//#endif
		if (super.getModel() != null) {
			super.getModel().onResume();
		}

		//#if MonoGameLogic
		if (this.musicPlayer != null) {
			this.setMusic(this.bMusic);
		}
		//#endif
		
	}
	
	public void onBackButtonPressed() {
		if (super.getModel() != null) {
			super.getModel().onBackButtonPressed();
		}
	}
	
	public int getMaxCanChoosen() {
		//#if MonoGameLogic
		int value = this.solvedLevels.solvedCout + 2;
		if (value >= ApoHybridLevel.MAX_LEVELS) {
			value = ApoHybridLevel.MAX_LEVELS -1;
		}
		return value;
		//#else
//@		return this.puzzle.getSolved();
		//#endif	
	}
	
	public void solvedLevel(int level) {
		this.puzzle.setSolved(level);
	}
	
	public void onUpdate(float delta) {
		super.onUpdate(delta);
		
		//#if ClockGameLogic || MonoGameLogic
		this.think += delta;
		//#elif SnakeGameLogic || DiceGameLogic
//@		this.think += delta * 1000;
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
				//#if ClockGameLogic
//@				this.textfield.think(10);
				//#endif

			}	
		}
	}

	@Override
	//#if ClockGameLogic || MonoGameLogic
	public void onDrawFrame(BitsGLGraphics g) {
	//#elif SnakeGameLogic || DiceGameLogic
//@	public void onDrawFrame(BitsGraphics g) {	
	//#endif
		if (super.getModel() != null) {
			super.getModel().render(g);
		}
		super.renderButtons(g);
		if (super.getModel() != null) {
			super.getModel().drawOverlay(g);
		}
		//#if MonoGameLogic
		if (ApoHybridConstants.FPS) {
			g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
			g.setFont(ApoHybridPanel.game_font);
			g.drawFPS(5, ApoHybridGame.changeY);
		}
		//#endif
	}
	

	//#if MonoGameLogic
	public void drawString(final BitsGLGraphics g, final String s, final int x, final int y, final BitsFont font) {
		this.drawString(g, s, x, y, font, ApoHybridConstants.DARK, false);
	}
	
	public void drawString(final BitsGLGraphics g, final String s, final int x, final int y, final BitsFont font, boolean bShadow) {
		this.drawString(g, s, x, y, font, ApoHybridConstants.DARK, bShadow);
	}

	public void drawString(final BitsGLGraphics g, final String s, final int x, final int y, final BitsFont font, float[] colorFront) {
		this.drawString(g, s, x, y, font, colorFront, false);
	}
	
	public void drawString(final BitsGLGraphics g, final String s, final int x, final int y, final BitsFont font, float[] colorFront, boolean bShadow) {
		int w = 0;
		if (super.getModel().getStringWidth().containsKey(s)) {
			w = super.getModel().getStringWidth().get(s);
		}
		
		float alpha = 1;
		if (colorFront.length > 3) {
			alpha = colorFront[3];
		}
		g.setFont(font);
		if (bShadow) {
			g.setColor(colorFront[0], colorFront[1], colorFront[2], alpha);
			if (colorFront[0] > 0.5f) {
				ApoHybridGame.setDarkerColor(g);
				ApoHybridGame.setDarkerColor(g);
			} else {
				ApoHybridGame.setBrighterColor(g);
			}
			g.drawText(s, x - w/2 + 1, y + 1);
		}
		g.setColor(colorFront[0], colorFront[1], colorFront[2], alpha);
		g.drawText(s, x - w/2 + 0, y + 0);
	}
	//#else
//@	
	//#if ClockGameLogic
//@	public void drawString(BitsGLGraphics g, final String s, final int x, final int y, final BitsGLFont font) {
	//#elif SnakeGameLogic || DiceGameLogic
//@	protected void drawString(BitsGraphics g, final String s, final int x, final int y, final BitsFont font) {		
	//#endif
//@		this.drawString(g, s, x, y, font, new float[] {0, 0, 0, 1}, new float[] {1, 1, 1, 1});
//@	}
//@	
	//#if ClockGameLogic
//@	protected void drawString(BitsGLGraphics g, final String s, final int x, final int y, final BitsGLFont font, float[] colorBack, float[] colorFront) {
	//#elif SnakeGameLogic || DiceGameLogic
//@	protected void drawString(BitsGraphics g, final String s, final int x, final int y, final BitsFont font, float[] colorBack, float[] colorFront) {
	//#endif
//@		int w = 0;
//@		if (super.getModel().getStringWidth().containsKey(s)) {
//@			w = super.getModel().getStringWidth().get(s);
//@		}
//@		
//@		g.setColor(colorBack[0], colorBack[1], colorBack[2], colorBack[3]);
		//#if ClockGameLogic
//@		g.setFont(font);
//@		g.drawText(s, x - w/2 + 1, y + 2 - font.mCharCellHeight/6);
//@		g.setColor(colorFront[0], colorFront[1], colorFront[2], colorFront[3]);
//@		g.drawText(s, x - w/2 + 0, y + 0 - font.mCharCellHeight/6);
		//#elif SnakeGameLogic || DiceGameLogic
//@		g.drawText(s, font, x - w/2 + 1, y + 2);
//@		g.setColor(colorFront[0], colorFront[1], colorFront[2], colorFront[3]);
//@		g.drawText(s, font, x - w/2 + 0, y + 0);
		//#endif
//@	}
//@
	//#endif
	
	//#if ClockGameLogic
//@	public void renderButtons(final BitsGLGraphics g) {
//@		this.renderButtons(g, ApoHybridPanel.font);
//@	}
//@
//@	public void renderButtons(final BitsGLGraphics g, final BitsGLFont font) {
//@		if (this.getButtons() != null) {
//@			for (int i = 0; i < this.getButtons().length; i++) {
//@				if (this.getButtons()[i].isVisible()) {
//@					int x = (int)(this.getButtons()[i].getX());
//@					int y = (int)(this.getButtons()[i].getY());
//@					int width = (int)(this.getButtons()[i].getWidth());
//@					int height = (int)(this.getButtons()[i].getHeight());
//@					
//@					g.setColor(160, 160, 160, 255);
//@					g.fillRect(x, y, width, height);
//@					g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
//@					g.drawRect(x, y, width, height);
//@					
//@					this.drawString(g, this.getButtons()[i].getFunction(), x + width/2, y + height/2 - font.mCharCellHeight/2, font);
//@				}
//@			}
//@		}
//@	}
//@
	//#elif MonoGameLogic
	protected void drawButtons(final BitsGLGraphics g, final BitsGLFont font, final int valueDif) {
		if (this.getButtons() != null) {
			for (int i = 0; i < this.getButtons().length; i++) {
				this.drawButtons(g, font, i, valueDif);
			}
		}
	}
	
	protected void drawButtons(final BitsGLGraphics g, final BitsGLFont font, final int i, final int valueDif) {
		if (this.getButtons()[i].isBVisible()) {
			int x = (int)(this.getButtons()[i].getX());
			int y = (int)(this.getButtons()[i].getY());
			int width = (int)(this.getButtons()[i].getWidth());
			int height = (int)(this.getButtons()[i].getHeight());
			
			g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
			g.fillRect(x + 2, y + 2, width - 4, height - 4);
			ApoHybridGame.setDarkerColor(g);
			g.fillRect(x + 2, y, width - 4, 2);
			g.fillRect(x + 2, y + height - 2, width - 4, 2);
			g.fillRect(x, y + 2, 2, height - 4);
			g.fillRect(x + width - 2, y + 2, 2, height - 4);
			ApoHybridGame.setBrighterColor(g);
			g.fillRect(x + 4, y + height, width - 4, 2);
			g.fillRect(x + width, y + 4, 2, height - 4);
			g.fillRect(x + width - 2, y + height - 2, 2, 2);
			
			String s = this.getButtons()[i].getFunction();
			this.drawString(g, s, (int)(x + width/2 - font.getLength(s)/2), y + height/2 - font.mCharCellHeight/2 - valueDif, font, ApoHybridConstants.BRIGHT);
		}
	}

	//#elif SnakeGameLogic || DiceGameLogic
//@	public void renderButtons(BitsGraphics g) {
//@		this.renderButtons(g, ApoHybridMenu.font);
//@	}
//@
//@	public void renderButtons(BitsGraphics g, final BitsFont font) {
//@		if (this.getButtons() != null) {
//@			for (int i = 0; i < this.getButtons().length; i++) {
//@				if (this.getButtons()[i].isBVisible()) {
//@					int x = (int)(this.getButtons()[i].getX());
//@					int y = (int)(this.getButtons()[i].getY());
//@					int width = (int)(this.getButtons()[i].getWidth());
//@					int height = (int)(this.getButtons()[i].getHeight());
//@					
//@					g.setColor(160, 160, 160, 255);
//@					g.drawFilledRoundRect(x, y, width, height, 6, 10);
//@					g.setLineSize(2.0f);
//@					g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
//@					g.drawRoundRect(x, y, width, height, 6, 10);
//@					g.setLineSize(1.0f);
//@					
//@					this.drawString(g, this.getButtons()[i].getFunction(), x + width/2, y + height/2 - font.mCharCellHeight/2 - 3, font);
//@				}
//@			}
//@		}
//@	}
	//#endif
}
