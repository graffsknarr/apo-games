package net.apogames.apohybrid.game;

import android.content.SharedPreferences;

import net.apogames.apohybrid.ApoHybrid;
import net.apogames.apohybrid.ApoHybridButtons;
import net.apogames.apohybrid.ApoHybridComponent;
import net.apogames.apohybrid.ApoHybridConstants;
import net.apogames.apohybrid.editor.ApoHybridUserlevels;

//#if MonoGameLogic
//@import net.apogames.apohybrid.ApoHybridMusicPlayer;
//@import net.apogames.apohybrid.ApoHybridSoundPlayer;
//@import net.apogames.apohybrid.entity.ApoLevelChooserButton;
//@import net.apogames.apohybrid.level.ApoHybridLevel;
//@import net.apogames.apohybrid.editor.ApoHybridSave;
//@import net.gliblybits.bitsengine.graphics.BitsFont;
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLFactory;
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLFont;
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//@import net.gliblybits.bitsengine.sound.BitsSound;
//#elif TreasureGameLogic
import java.util.HashMap;
import java.util.Map.Entry;

import net.gliblybits.bitsengine.graphics.bitmap.BitsBitmap;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLFactory;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLFont;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLImage;
import net.gliblybits.bitsengine.sound.BitsSound;
import com.apogames.mytreasure.MyTreasureMusicPlayer;
import com.apogames.mytreasure.MyTreasureSoundPlayer;
import com.apogames.mytreasure.R;
import com.apogames.mytreasure.entity.MyTreasureSolve;
import com.apogames.mytreasure.userlevels.MyTreasureLevels;
import com.apogames.mytreasure.userlevels.MyTreasureUserLevels;

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
import net.gliblybits.bitsengine.core.BitsFont;
import net.gliblybits.bitsengine.core.BitsGame;
import net.gliblybits.bitsengine.render.BitsGraphics;
//#endif


public class ApoHybridPanel extends ApoHybridComponent {

	private ApoHybridMenu menu;

	private ApoHybridLevelChooser levelChooser;

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
//@	public static BitsGLFont font;
//@	public static BitsGLFont game_font;
//@	public static BitsGLFont title_font;
//@
//@	private ApoHybridCredits credits;
//@	private ApoHybridOptions options;
//@	private ApoHybridSave solvedLevels;
//@
//@	private boolean bSound, bMusic;
//@
//@	private ApoHybridMusicPlayer musicPlayer;
//@
//@	private ApoHybridSoundPlayer soundPlayer;

	//#elif TreasureGameLogic
	private MyTreasureMap map;
	
	private MyTreasureCredits credits;
	
	private MyTreasureOptions options;
	
	private MyTreasureUserLevels userlevels;
	
	private int curSkulls, think;
	
	private HashMap<String, Integer> solvedLevel;

	private MyTreasureSolve solver;
	
	private MyTreasureSoundPlayer soundPlayer;
	
	private MyTreasureMusicPlayer musicPlayer;
	
	private long oldTime;

	//#endif

	public ApoHybridPanel(int id) {
		super(id);
	}

	public void init() {
		super.init();

		//#if ClockGameLogic
//@		BitsGLGraphics.setClearColor(192f/255f, 192f/255f, 192f/255f, 1f);
		//#elif MonoGameLogic
//@		BitsGLGraphics.setClearColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
		//#elif TreasureGameLogic
		BitsGLGraphics.setClearColor(45f/255f, 50f/255f, 38f/255f, 1f);		
		//#elif SnakeGameLogic || DiceGameLogic
		BitsGame.getIt().setClearColor(192f/255f, 192f/255f, 192f/255f, 1f);
		//#endif
		
		//#if TreasureGameLogic
		MyTreasureConstants.font = BitsGLFactory.getInstance().getFont("font/pixel.TTF", 40, +6, BitsGLFont.FILTER_NEAREST, true);
		
		MyTreasureConstants.FONT_FPS = BitsGLFactory.getInstance().getFont("font/pixel.TTF", 10, +1, BitsGLFont.FILTER_NEAREST, true);
		MyTreasureConstants.FONT_STATISTICS = BitsGLFactory.getInstance().getFont("font/pixel.TTF", 19, +4, BitsGLFont.FILTER_NEAREST, true);
		MyTreasureConstants.FONT_LEVELCHOOSER = BitsGLFactory.getInstance().getFont("font/pixel.TTF", 30, +5, BitsGLFont.FILTER_NEAREST, true);
		
		MyTreasureConstants.fontBig = BitsGLFactory.getInstance().getFont("font/pixel.TTF", 33, +6, BitsGLFont.FILTER_NEAREST, true);
		MyTreasureConstants.fontMedium = BitsGLFactory.getInstance().getFont("font/pixel.TTF", 25, +4, BitsGLFont.FILTER_NEAREST, true);
		MyTreasureConstants.fontSmall = BitsGLFactory.getInstance().getFont("font/pixel.TTF", 17, +3, BitsGLFont.FILTER_NEAREST, true);
		MyTreasureConstants.fontVerySmall = BitsGLFactory.getInstance().getFont("font/pixel.TTF", 14, +2, BitsGLFont.FILTER_NEAREST, true);
		
		BitsBitmap bitmap = BitsGLFactory.getInstance().getBitmap(R.drawable.treasure_sheet);
		MyTreasureConstants.iSheet = BitsGLFactory.getInstance().getImage(bitmap, BitsGLImage.FILTER_NEAREST, true, true);

		MyTreasureConstants.iWays = BitsGLFactory.getInstance().getImage(R.drawable.ways, BitsGLImage.FILTER_NEAREST, true);
		//#endif

		ApoHybridButtons buttons = new ApoHybridButtons(this);
		buttons.init();

		this.think = 0;

		if (this.menu == null) {
			this.menu = new ApoHybridMenu(this);
		}
		if (this.levelChooser == null) {
			this.levelChooser = new ApoHybridLevelChooser(this);
		}
		if (this.game == null) {
			this.game = new ApoHybridGame(this);
		}
		if (this.editor == null) {
			//#if Editor
			this.editor = new ApoHybridEditor(this);
			//#endif
		}
		if (this.userlevels == null) {
			this.userlevels = new ApoHybridUserlevels(this);
			this.loadUserlevels();
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
		//#elif MonoGameLogic || TreasureGameLogic
//@		if (this.credits == null) {
//@			this.credits = new ApoHybridCredits(this);
//@		}
//@
//@		if (this.options == null) {
//@			this.options = new ApoHybridOptions(this);
//@		}
//@
//@		if (this.solvedLevels == null) {
//@			this.solvedLevels = new ApoHybridSave();
//@		}
//@		if (this.musicPlayer == null) {
//@			this.musicPlayer = new ApoHybridMusicPlayer(this);
//@		}
//@		if (this.soundPlayer == null) {
//@			this.soundPlayer = new ApoHybridSoundPlayer();
//@		}
//@		//#if !TreasureGameLogic
//@		this.loadFonts();
		//#else 
		if (this.map == null) {
			this.map = new MyTreasureMap(this);
		}
		
		if (this.solver == null) {
			this.solver = new MyTreasureSolve(this.editor);
		}

		this.curSkulls = 0;
		this.loadProperties();
		this.playMusic();
		//#endif


		//#if !MonoGameLogic && !TreasureGameLogic
		this.levelChooser.init();
		//#endif

		//#if ClockGameLogic || MonoGameLogic
//@		this.loadPreferences();
		//#elif SnakeGameLogic || DiceGameLogic
		this.loadPreferences(ApoHybrid.settings);
		//#endif

		this.setMenu();

	}

	//#if ClockGameLogic
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
//@
//@
//@	protected final void loadPreferences() {
//@		SharedPreferences settings = ApoHybrid.settings;
//@		boolean english = settings.getBoolean("language", true);
//@		boolean colorGreen = settings.getBoolean("color", true);
//@		boolean bSound = settings.getBoolean("sound", true);
//@		boolean bMusic = settings.getBoolean("music", true);
//@		this.loadOptions(english, colorGreen, bSound, bMusic);
//@
//@		String solvedLevels = settings.getString("solvedLevels", "");
//@		this.solvedLevels.createArrayFromString(solvedLevels);
//@
//@//		ApoHybridConstants.FREE_VERSION = !settings.getBoolean("premium", false);
//@	}
//@
//@	private void loadOptions(boolean bEnglish, boolean bColorGreen, boolean bSound, boolean bMusic) {
//@		((ApoLevelChooserButton) (this.getButtons()[12])).setSelected(!bEnglish);
//@		((ApoLevelChooserButton) (this.getButtons()[13])).setSelected(bEnglish);
//@		((ApoLevelChooserButton) (this.getButtons()[14])).setSelected(!bColorGreen);
//@		((ApoLevelChooserButton) (this.getButtons()[15])).setSelected(bColorGreen);
//@
//@		if (bEnglish) {
//@			ApoHybridConstants.changeLanguageToEnglish();
//@		} else {
//@			ApoHybridConstants.changeLanguageToGerman();
//@		}
//@
//@		if (bColorGreen) {
//@			ApoHybridConstants.changeToGreenColor();
//@		} else {
//@			ApoHybridConstants.changeToWhiteColor();
//@		}
//@
//@
//@		((ApoLevelChooserButton) (this.getButtons()[21])).setSelected(bSound);
//@		((ApoLevelChooserButton) (this.getButtons()[22])).setSelected(bMusic);
//@		this.setSound(bSound);
//@		this.setMusic(bMusic);
//@	}
//@
//@	public boolean isMusicOn() {
//@		return bMusic;
//@	}
//@
//@	public void setSound(boolean bSound) {
//@		this.bSound = bSound;
//@	}
//@
//@	public void playSound(BitsSound sound) {
//@		if (this.bSound) {
//@			this.soundPlayer.playSound(sound);
//@		}
//@	}
//@
//@	public void setMusic(boolean bMusic) {
//@		this.bMusic = bMusic;
//@
//@		if (this.bMusic) {
//@			this.musicPlayer.load();
//@		} else {
//@			this.musicPlayer.stop();
//@		}
//@	}
//@
//@	protected final void savePreferences() {
//@		SharedPreferences settings = ApoHybrid.settings;
//@		SharedPreferences.Editor editor = settings.edit();
//@		boolean bEnglish = true;
//@		if (((ApoLevelChooserButton) (this.getButtons()[12])).isSelected()) {
//@			bEnglish = false;
//@		}
//@		editor.putBoolean("language", bEnglish);
//@		boolean bColorGreen = true;
//@		if (((ApoLevelChooserButton) (this.getButtons()[14])).isSelected()) {
//@			bColorGreen = false;
//@		}
//@		editor.putBoolean("color", bColorGreen);
//@
//@		boolean bSound = true;
//@		if (!((ApoLevelChooserButton) (this.getButtons()[21])).isSelected()) {
//@			bSound = false;
//@		}
//@		editor.putBoolean("sound", bSound);
//@
//@		boolean bMusic = true;
//@		if (!((ApoLevelChooserButton) (this.getButtons()[22])).isSelected()) {
//@			bMusic = false;
//@		}
//@		editor.putBoolean("music", bMusic);
//@
//@		editor.putString("solvedLevels", this.solvedLevels.getSaveString());
//@
//@		editor.putBoolean("premium", !ApoHybridConstants.FREE_VERSION);
//@
//@		editor.commit();
//@	}
//@
//@	@Override
//@	public void onFinishScreen() {
//@		this.savePreferences();
//@	}
//@
//@	protected final void setCredits() {
//@		if (super.getModel() != null) {
//@			super.getModel().close();
//@		}
//@
//@		super.setModel(this.credits);
//@
//@		this.setButtonVisible(ApoHybridConstants.BUTTON_CREDITS);
//@
//@		super.getModel().init();
//@
//@		this.musicPlayer.setMenu(true);
//@	}
//@
//@	protected final void setLevelChooser() {
//@		if (super.getModel() != null) {
//@			super.getModel().close();
//@		}
//@
//@		super.setModel(this.levelChooser);
//@
//@		this.setButtonVisible(ApoHybridConstants.BUTTON_LEVELCHOOSER);
//@
//@		super.getModel().init();
//@
//@		this.musicPlayer.setMenu(true);
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
//@		this.musicPlayer.setMenu(true);
//@	}
//@
//@	public ApoHybridSave getSolvedLevels() {
//@		return this.solvedLevels;
//@	}
//@
//@	public void setUserlevelsVisible() {
//@		if (this.getModel() instanceof ApoHybridMenu) {
//@			this.getButtons()[8].setVisible(true);
//@		}
//@	}
//@
//@	protected void solveLevel(int level) {
//@		this.solvedLevels.setLevelToSolved(level);
//@
//@		this.savePreferences();
//@
//@		this.levelChooser.solveLevel(level);
//@	}
//@
//@	@Override
//@	public void onPauseScreen() {
//@		if (this.musicPlayer != null) {
//@			this.musicPlayer.stop();
//@			this.musicPlayer.release();
//@		}
//@	}
//@
//@
	//#elif SnakeGameLogic || DiceGameLogic
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

		


		//#if MonoGameLogic
//@		if ((ApoHybridLevel.editorLevels != null) && (ApoHybridLevel.editorLevels.length > 0)) {
//@			this.getButtons()[8].setVisible(true);
//@		}
//@
//@		this.musicPlayer.setMenu(true);

		//#elif TreasureGameLogic
		this.setUserlevelsVisible();
		this.getModel().init();
//@
//@
		//#elif ClockGameLogic
//@		this.textfield.setVisible(false);
		//#endif

	}

	//#if MonoGameLogic
//@	protected final void setEditor(boolean bUpload) {
	//#elif TreasureGameLogic	
	public final void setEditor(boolean bSolved, int steps) {
	//#else
	protected final void setEditor(boolean bSolvedLevel) {
	//#endif
		if (super.getModel() != null) {
			super.getModel().close();
		}

		super.setModel(this.editor);

		this.setButtonVisible(ApoHybridConstants.BUTTON_EDITOR);

		this.getModel().init();
		

		//#if MonoGameLogic
//@		this.editor.setUploadVisible(bUpload);
//@		this.musicPlayer.setMenu(true);
//@
		//#elif ClockGameLogic
//@		this.textfield.setVisible(false);
		
		//#elif TreasureGameLogic
		this.editor.setSteps(steps);
		this.editor.setVisibleUpload(bSolved);
		//#else
			this.editor.setLevelSolved(bSolvedLevel);
		//#endif

		//#endif

		
		super.getModel().init();

	}
	//#if ClockGameLogic
//@		protected final void setPuzzle() {
//@			if (super.getModel() != null) {
//@				super.getModel().close();
//@			}
//@
//@			super.setModel(this.puzzleFirst);
//@
//@			this.setButtonVisible(ApoHybridConstants.BUTTON_PUZZLE_FIRST);
//@
//@			super.getModel().init();
//@
//@			this.textfield.setVisible(false);
//@		}
//@
//@		protected final void setOptions() {
//@			if (super.getModel() != null) {
//@				super.getModel().close();
//@			}
//@
//@			super.setModel(this.options);
//@
//@			this.setButtonVisible(ApoHybridConstants.BUTTON_OPTIONS);
//@
//@			super.getModel().init();
//@
//@			this.textfield.setVisible(true);
//@		}
//@
//@		protected final void setAracardeHelp(final int points, final int clocks) {
//@			if (super.getModel() != null) {
//@				super.getModel().close();
//@			}
//@
//@			super.setModel(this.arcarde);
//@
//@			this.setButtonVisible(ApoHybridConstants.BUTTON_ARCARDE);
//@
//@			this.arcarde.setPoints(points, clocks);
//@			super.getModel().init();
//@
//@			this.textfield.setVisible(true);
//@		}
//@
//@		protected final void setAracardeGame() {
//@			if (super.getModel() != null) {
//@				super.getModel().close();
//@			}
//@
//@			super.setModel(this.arcardeGame);
//@
//@			this.setButtonVisible(ApoHybridConstants.BUTTON_ARCARDE_GAME);
//@
//@			super.getModel().init();
//@
//@			this.textfield.setVisible(false);
//@		}
//@
//@		public boolean onKeyDown(final int key, final BitsKeyEvent event) {
//@			if (super.getModel() != null) {
//@				super.getModel().onKeyDown(key, event);
//@			}
//@
//@			return true;
//@		}
//@
//@		public boolean onKeyUp(final int key, final BitsKeyEvent event) {
//@			if (super.getModel() != null) {
//@				if ((this.textfield.isVisible()) && (this.textfield.isSelect())) {
//@					if( event.isNumber() || event.isLetter() || key == BitsKeyEvent.KEY_SPACE ) {
//@						this.textfield.addValue(String.valueOf(event.mUnicodeChar));
//@					}
//@
//@					if (key == BitsKeyEvent.KEY_DEL) {
//@						this.textfield.deleteValue();
//@					}
//@					if(key == BitsKeyEvent.KEY_ENTER) {
//@						if (this.textfield.isSelect()) {
//@							BitsInput.getInstance().setVirtualKeyboardVisible(false);
//@						}
//@						this.textfield.setSelect(false);
//@						this.savePreferences();
//@					}
//@				} else {
//@					super.getModel().onKeyUp(key, event);
//@				}
//@			}
//@
//@			return true;
//@		}
//@
//@		public ApoTextfield getTextfield() {
//@			return this.textfield;
//@		}
//@
//@		public ApoHybridHighscore getHighscore() {
//@			return this.arcarde.getHighscore();
//@		}
//@
//@		public void drawBackgroundCircle(final BitsGLGraphics g, final int x, final int y, final int height, final int clockRotate) {
//@			g.setLineSize(3.0f);
//@			g.setColor(48, 48, 48);
//@			g.drawCircle(x, y + height/2, height/2, 120);
//@
//@			g.setLineSize(5.0f);
//@			for (int j = 0; j < 12; j++) {
//@				g.drawLine(x + (int)((height/2 - 5) * Math.sin(Math.toRadians(j * 30))), y + height/2 + (int)(-(height/2 - 5) * Math.cos(Math.toRadians(j * 30))), x + (int)((height/2) * Math.sin(Math.toRadians(j * 30))), y + height/2 + (int)(-(height/2) * Math.cos(Math.toRadians(j * 30))));
//@			}
//@
//@			int angle = (int)(clockRotate + x) + y;
//@			while (angle > 360) {
//@				angle -= 360;
//@			}
//@			g.drawLine(x, y + height/2, x + (int)((height/2 - 5) * Math.sin(Math.toRadians(angle))), y + height/2 + (int)(-(height/2 - 5) * Math.cos(Math.toRadians(angle))));
//@
//@			g.setLineSize(1.0f);
//@		}
	//#endif

	//#if !MonoGameLogic && !TreasureGameLogic
		protected final void setPuzzleChooser() {
			if (super.getModel() != null) {
				super.getModel().close();
			}

			super.setModel(this.levelChooser);

			this.setButtonVisible(ApoHybridConstants.BUTTON_PUZZLE);

			super.getModel().init();

			//TODO
			//this.musicPlayer.setMenu(true);

	//#if ClockGameLogic
//@			this.textfield.setVisible(false);
	//#endif
		}
	//#endif
	
	//#if !TreasureGameLogic
	protected final void setGame(final int level, final String levelString, final boolean bUserlevel) {
		if (super.getModel() != null) {
			super.getModel().close();
		}

		super.setModel(this.game);

		this.setButtonVisible(ApoHybridConstants.BUTTON_GAME);

		super.getModel().init();

		//#if MonoGameLogic
//@		this.game.loadLevel(level, bUserlevel, levelString);
//@		this.musicPlayer.setMenu(false);
//@
//@
		//#elif ClockGameLogic
//@			if (levelString != null) {
//@				this.game.loadLevelWithString(levelString, true);
//@			} else {
//@				this.game.loadLevel(level, bUserlevel);
//@			}
//@
//@			this.textfield.setVisible(false);
		//#elif SnakeGameLogic || DiceGameLogic
		this.game.loadLevel(level, bUserlevel, levelString);
		//#endif
	}
	//#else
	public void stopGame() {
		this.stopMusic();
		this.saveProperties();
	}
	
	public final void loadProperties() {
		SharedPreferences settings = MyTreasureActivity.settings;
		MyTreasureConstants.FIRST_MAP = settings.getBoolean("first", true);
		MyTreasureConstants.FIRST_LEVELCHOOSER = settings.getBoolean("levelchooser_first", true);
		MyTreasureConstants.FIRST_LEVELCHOOSER_DRAG = settings.getBoolean("levelchooser_drag", true);
		MyTreasureConstants.FIRST_GAME = settings.getBoolean("first_game", true);
		MyTreasureConstants.SOUND_GAME = settings.getBoolean("sound_game", true);
		MyTreasureConstants.MUSIC_GAME = settings.getBoolean("music_game", true);
		MyTreasureConstants.LEVELCHOOSER_STEP = settings.getInt("levelchooser_step", 0);
		this.curSkulls = settings.getInt("skulls", 0);
		this.map.setOldLevel(this.curSkulls);
		this.map.setPlayerPosition(MyTreasureConstants.LEVELCHOOSER_STEP);
		int size = settings.getInt("size", 0);
		for (int i = 0; i < size; i++) {
			int skulls = settings.getInt(String.valueOf(i)+"skulls", 1);
			String level = settings.getString(String.valueOf(i)+"level", "");
			this.solvedLevel.put(level, skulls);
		}
		this.setMusic(MyTreasureConstants.MUSIC_GAME);
		this.setSound(MyTreasureConstants.SOUND_GAME);
	}
	
	public final void saveProperties() {
		SharedPreferences settings = MyTreasureActivity.settings;
		SharedPreferences.Editor editor = settings.edit();
		
		editor.putBoolean("first", MyTreasureConstants.FIRST_MAP);
		editor.putBoolean("levelchooser_first", MyTreasureConstants.FIRST_LEVELCHOOSER);
		editor.putBoolean("levelchooser_drag", MyTreasureConstants.FIRST_LEVELCHOOSER_DRAG);
		editor.putBoolean("first_game", MyTreasureConstants.FIRST_GAME);
		editor.putBoolean("sound_game", MyTreasureConstants.SOUND_GAME);
		editor.putBoolean("music_game", MyTreasureConstants.MUSIC_GAME);
		editor.putInt("levelchooser_step", MyTreasureConstants.LEVELCHOOSER_STEP);
		editor.putInt("skulls", this.curSkulls);
		int size = this.solvedLevel.size();
		editor.putInt("size", size);
		int i = 0;
		for (final Entry<String, Integer> entry : this.solvedLevel.entrySet()) {
			editor.putInt(String.valueOf(i)+"skulls", entry.getValue());
			editor.putString(String.valueOf(i)+"level", entry.getKey());
			i += 1;
		}
		
		editor.commit();
	}

	@Override
	public void onFinishScreen() {
		this.stopMusic();
		this.saveProperties();
	}

	public int getCurSkulls() {
		return this.curSkulls;
	}

	public void setCurSkulls(final int curSkulls) {
		this.curSkulls = curSkulls;
	}

	public HashMap<String, Integer> getSolvedLevel() {
		return this.solvedLevel;
	}
	
	public int getDifficulty() {
		return this.levelChooser.getDifficulty();
	}

	public final void setMap() {
		if (this.getModel() != null) {
			this.getModel().close();
		}
		this.setModel(this.map);
		
		this.setButtonVisible(MyTreasureConstants.BUTTON_MAP);
		this.getModel().init();
	}

	public final void setLevelChooser(final int difficulty, final int level, final boolean bMap, final boolean bUserlevels) {
		if (this.getModel() != null) {
			this.getModel().close();
		}
		this.setModel(this.levelChooser);
		
		this.setButtonVisible(MyTreasureConstants.BUTTON_LEVELCHOOSER);
		this.getModel().init();
		
		if (!bUserlevels) {
			this.levelChooser.setDifficulty(difficulty, level, bMap);
		} else {
			this.levelChooser.setUserlevels();
		}
	}
	
	public final void setGame(final boolean bUserlevel, final boolean bEditor, final int levelInt, final String levelString) {
		if (this.getModel() != null) {
			this.getModel().close();
		}
		
		this.setModel(this.game);
		
		this.setButtonVisible(MyTreasureConstants.BUTTON_GAME);

		this.game.setUserLevel(bUserlevel);
		this.getModel().init();
		
		this.game.loadLevel(bEditor, levelInt, levelString);
	}
	
	public final void setCredits() {
		if (this.getModel() != null) {
			this.getModel().close();
		}
		
		this.setModel(this.credits);
		
		this.setButtonVisible(MyTreasureConstants.BUTTON_CREDITS);
		
		this.getModel().init();
	}
	
	public final void setOptions() {
		if (this.getModel() != null) {
			this.getModel().close();
		}
		
		this.setModel(this.options);
		
		this.setButtonVisible(MyTreasureConstants.BUTTON_OPTIONS);
		
		this.getModel().init();
	}
	
	public final void setMusic(final boolean bMusic) {
		this.getButtons()[25].setSelected(!bMusic);
		this.getButtons()[24].setSelected(bMusic);
		
		MyTreasureConstants.MUSIC_GAME = bMusic;
		this.playMusic();
	}
	
	public void playMusic() {
		if (MyTreasureConstants.MUSIC_GAME) {
			this.musicPlayer.load();
		} else {
			this.musicPlayer.stop();
		}
	}
	
	public void stopMusic() {
		this.musicPlayer.stop();
	}
	
	public final void setSound(final boolean bSound) {
		this.getButtons()[26].setSelected(!bSound);
		this.getButtons()[23].setSelected(bSound);
		
		MyTreasureConstants.SOUND_GAME = bSound;
		this.playSound(MyTreasureSoundPlayer.SOUND_CLICK);
	}
	
	public void playSound(BitsSound sound) {
		if (MyTreasureConstants.SOUND_GAME) {
			this.soundPlayer.playSound(sound);
		}
	}
	
	public boolean isMusicOn() {
		return false;
	}
	
	public int getCurStart() {
		return this.levelChooser.getCurI();
	}
	
	public int getCurMax() {
		return this.levelChooser.getCurMax();
	}

	public final void setUserlevelsVisible() {
		if (this.getModel().equals(this.menu)) {
			if (MyTreasureLevels.editorLevels != null) {
				super.getButtons()[2].setVisible(true);
			} else {
				super.getButtons()[2].setVisible(false);
			}
		}
	}
	
	public final void doSolveLevel(final String level) {
		String solution = this.solver.solveLevel(level);
		if (this.getModel().equals(this.editor)) {
			this.editor.setSolutionString(solution);
		}
	}

	public void renderBackgroundInfo(BitsGLGraphics g) {
		
	}



	//#endif
	


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
	public void onResume() {
	//#elif ClockGameLogic || MonoGameLogic || TreasureGameLogic
//@	public void onResumeScreen() {
		//#endif
		if (super.getModel() != null) {
			super.getModel().onResume();
			//#if TreasureGameLogic
			this.playMusic();
			//#endif
		}

		//#if MonoGameLogic
//@		if (this.musicPlayer != null) {
//@			this.setMusic(this.bMusic);
//@		}
		//#endif

	}

	public void onBackButtonPressed() {
		if (super.getModel() != null) {
			super.getModel().onBackButtonPressed();
		}
	}

	public int getMaxCanChoosen() {
		//#if MonoGameLogic
//@		int value = this.solvedLevels.solvedCout + 2;
//@		if (value >= ApoHybridLevel.MAX_LEVELS) {
//@			value = ApoHybridLevel.MAX_LEVELS - 1;
//@		}
//@		return value;
		//#else
			return this.levelChooser.getSolved();
		//#endif
	}

	//#if !MonoGameLogic
		public void solvedLevel(int level) {
			this.levelChooser.setSolved(level);
		}
	//#endif

	public void onUpdate(float delta) {
		super.onUpdate(delta);

		//#if ClockGameLogic || MonoGameLogic || TreasureGameLogic
//@		this.think += delta;
		//#elif SnakeGameLogic || DiceGameLogic
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
				super.getModel().think((int) 10);
				//#if ClockGameLogic
//@					this.textfield.think(10);
				//#endif

			}
		}
	}

	@Override
	//#if ClockGameLogic || MonoGameLogic || TreasureGameLogic
//@	public void onDrawFrame(BitsGLGraphics g) {
	//#elif SnakeGameLogic || DiceGameLogic
	public void onDrawFrame(BitsGraphics g) {
	//#endif
		if (super.getModel() != null) {
			super.getModel().render(g);
		}

		//#if TreasureGameLogic
		g.setColor(1f, 1f, 1f, 1f);
		//#endif		
		
		super.renderButtons(g);
		if (super.getModel() != null) {
			super.getModel().drawOverlay(g);
		}
		//#if MonoGameLogic
//@		if (ApoHybridConstants.FPS) {
//@			g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
//@			g.setFont(ApoHybridPanel.game_font);
//@			g.drawFPS(5, ApoHybridGame.changeY);
//@		}
		//#elif TreasureGameLogic
		if (MyTreasureConstants.FPS) {
			g.setColor(MyTreasureConstants.COLOR_LIGHT[0], MyTreasureConstants.COLOR_LIGHT[1], MyTreasureConstants.COLOR_LIGHT[2], 1f);
			g.setFont(MyTreasureConstants.FONT_STATISTICS);
			g.drawFPS(5, 40);
		}
		//#endif
	}


	//#if MonoGameLogic
//@	public void drawString(final BitsGLGraphics g, final String s, final int x, final int y, final BitsFont font) {
//@		this.drawString(g, s, x, y, font, ApoHybridConstants.DARK, false);
//@	}
//@
//@	public void drawString(final BitsGLGraphics g, final String s, final int x, final int y, final BitsFont font, boolean bShadow) {
//@		this.drawString(g, s, x, y, font, ApoHybridConstants.DARK, bShadow);
//@	}
//@
//@	public void drawString(final BitsGLGraphics g, final String s, final int x, final int y, final BitsFont font, float[] colorFront) {
//@		this.drawString(g, s, x, y, font, colorFront, false);
//@	}
//@
//@	public void drawString(final BitsGLGraphics g, final String s, final int x, final int y, final BitsFont font, float[] colorFront, boolean bShadow) {
//@		int w = 0;
//@		if (super.getModel().getStringWidth().containsKey(s)) {
//@			w = super.getModel().getStringWidth().get(s);
//@		}
//@
//@		float alpha = 1;
//@		if (colorFront.length > 3) {
//@			alpha = colorFront[3];
//@		}
//@		g.setFont(font);
//@		if (bShadow) {
//@			g.setColor(colorFront[0], colorFront[1], colorFront[2], alpha);
//@			if (colorFront[0] > 0.5f) {
//@				ApoHybridGame.setDarkerColor(g);
//@				ApoHybridGame.setDarkerColor(g);
//@			} else {
//@				ApoHybridGame.setBrighterColor(g);
//@			}
//@			g.drawText(s, x - w / 2 + 1, y + 1);
//@		}
//@		g.setColor(colorFront[0], colorFront[1], colorFront[2], alpha);
//@		g.drawText(s, x - w / 2 + 0, y + 0);
//@	}
	//#endif

	//#if ClockGameLogic
//@		public void drawString(BitsGLGraphics g, final String s, final int x, final int y, final BitsGLFont font) {
//@			this.drawString(g, s, x, y, font, new float[] {0, 0, 0, 1}, new float[] {1, 1, 1, 1});
//@		}
	//#elif SnakeGameLogic || DiceGameLogic
		protected void drawString(BitsGraphics g, final String s, final int x, final int y, final BitsFont font) {
			this.drawString(g, s, x, y, font, new float[] {0, 0, 0, 1}, new float[] {1, 1, 1, 1});
		}
	//#endif


	//#if ClockGameLogic
//@		protected void drawString(BitsGLGraphics g, final String s, final int x, final int y, final BitsGLFont font, float[] colorBack, float[] colorFront) {
//@			int w = 0;
//@			if (super.getModel().getStringWidth().containsKey(s)) {
//@				w = super.getModel().getStringWidth().get(s);
//@			}
//@			g.setColor(colorBack[0], colorBack[1], colorBack[2], colorBack[3]);
//@
	//#elif SnakeGameLogic || DiceGameLogic
		protected void drawString(BitsGraphics g, final String s, final int x, final int y, final BitsFont font, float[] colorBack, float[] colorFront) {
			int w = 0;
			if (super.getModel().getStringWidth().containsKey(s)) {
				w = super.getModel().getStringWidth().get(s);
			}
			g.setColor(colorBack[0], colorBack[1], colorBack[2], colorBack[3]);

	//#endif

	//#if ClockGameLogic
//@			g.setFont(font);
//@			g.drawText(s, x - w / 2 + 1, y + 2 - font.mCharCellHeight / 6);
//@			g.setColor(colorFront[0], colorFront[1], colorFront[2], colorFront[3]);
//@			g.drawText(s, x - w / 2 + 0, y + 0 - font.mCharCellHeight / 6);
	//#elif SnakeGameLogic || DiceGameLogic
		g.drawText(s, font, x - w/2 + 1, y + 2);
		g.setColor(colorFront[0], colorFront[1], colorFront[2], colorFront[3]);
		g.drawText(s, font, x - w/2 + 0, y + 0);

}
	//#endif

		//#if ClockGameLogic
//@		public void renderButtons(final BitsGLGraphics g) {
//@			this.renderButtons(g, ApoHybridPanel.font);
//@		}
//@
//@		public void renderButtons(final BitsGLGraphics g, final BitsGLFont font) {
//@			if (this.getButtons() != null) {
//@				for (int i = 0; i < this.getButtons().length; i++) {
//@					if (this.getButtons()[i].isVisible()) {
//@						int x = (int)(this.getButtons()[i].getX());
//@						int y = (int)(this.getButtons()[i].getY());
//@						int width = (int)(this.getButtons()[i].getWidth());
//@						int height = (int)(this.getButtons()[i].getHeight());
//@
//@						g.setColor(160, 160, 160, 255);
//@						g.fillRect(x, y, width, height);
//@						g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
//@						g.drawRect(x, y, width, height);
//@
//@						this.drawString(g, this.getButtons()[i].getFunction(), x + width/2, y + height/2 - font.mCharCellHeight/2, font);
//@					}
//@				}
//@			}
//@		}
//@
		//#elif MonoGameLogic
//@		protected void drawButtons(final BitsGLGraphics g, final BitsGLFont font, final int valueDif) {
//@			if (this.getButtons() != null) {
//@				for (int i = 0; i < this.getButtons().length; i++) {
//@					this.drawButtons(g, font, i, valueDif);
//@				}
//@			}
//@		}
//@
//@		protected void drawButtons(final BitsGLGraphics g, final BitsGLFont font, final int i, final int valueDif) {
//@			if (this.getButtons()[i].isBVisible()) {
//@				int x = (int)(this.getButtons()[i].getX());
//@				int y = (int)(this.getButtons()[i].getY());
//@				int width = (int)(this.getButtons()[i].getWidth());
//@				int height = (int)(this.getButtons()[i].getHeight());
//@
//@				g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
//@				g.fillRect(x + 2, y + 2, width - 4, height - 4);
//@				ApoHybridGame.setDarkerColor(g);
//@				g.fillRect(x + 2, y, width - 4, 2);
//@				g.fillRect(x + 2, y + height - 2, width - 4, 2);
//@				g.fillRect(x, y + 2, 2, height - 4);
//@				g.fillRect(x + width - 2, y + 2, 2, height - 4);
//@				ApoHybridGame.setBrighterColor(g);
//@				g.fillRect(x + 4, y + height, width - 4, 2);
//@				g.fillRect(x + width, y + 4, 2, height - 4);
//@				g.fillRect(x + width - 2, y + height - 2, 2, 2);
//@
//@				String s = this.getButtons()[i].getFunction();
//@				this.drawString(g, s, (int)(x + width/2 - font.getLength(s)/2), y + height/2 - font.mCharCellHeight/2 - valueDif, font, ApoHybridConstants.BRIGHT);
//@			}
//@		}
//@
		//#elif SnakeGameLogic || DiceGameLogic
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

	//#if MonoGameLogic || ClockGameLogic
	//#if MonoFont
	//@	private void loadFonts() {
//@		ApoHybridPanel.font = BitsGLFactory.getInstance().getFont("res/font/font.ttf", 24, +4, BitsGLFont.FILTER_NEAREST, true);
//@//		ApoHybridPanel.font.mFilterMode = BitsGLFont.FILTER_NEAREST;
//@//		BitsGLFactory.getInstance().markForLoading(font);
//@
//@		ApoHybridPanel.title_font = BitsGLFactory.getInstance().getFont("res/font/font.ttf", 36, +6, BitsGLFont.FILTER_NEAREST, true);
//@//		ApoHybridPanel.title_font.mFilterMode = BitsGLFont.FILTER_NEAREST;
//@//		BitsGLFactory.getInstance().markForLoading(title_font);
//@
//@		ApoHybridPanel.game_font = BitsGLFactory.getInstance().getFont("res/font/font.ttf", 18, +3, BitsGLFont.FILTER_NEAREST, true);
//@//		ApoHybridPanel.game_font.mFilterMode = BitsGLFont.FILTER_NEAREST;
//@//		BitsGLFactory.getInstance().markForLoading(game_font);
//@
//@		BitsGLFactory.getInstance().loadAllMarked();
//@	}
	//#elif ApoFont
//@		private void loadFonts() {
//@		ApoHybridPanel.font = BitsGLFactory.getInstance().getFont("reprise.ttf", 30, 4, true);
//@		BitsGLFactory.getInstance().markForLoading(ApoHybridPanel.font);
//@		ApoHybridPanel.title_font = BitsGLFactory.getInstance().getFont("reprise.ttf", 38, 2, true);
//@		BitsGLFactory.getInstance().markForLoading(ApoHybridPanel.title_font);
//@		ApoHybridPanel.game_font = BitsGLFactory.getInstance().getFont("reprise.ttf", 26, 2, true);
//@		BitsGLFactory.getInstance().markForLoading(ApoHybridPanel.game_font);
//@
//@		BitsGLFactory.getInstance().loadAllMarked();
//@	}
	//#endif
	//#endif
}
