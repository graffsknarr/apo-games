//#if ClockGameLogic

package net.apogames.apohybrid.game;

import net.apogames.apohybrid.ApoHybridModel;

import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
import net.gliblybits.bitsengine.input.BitsInput;
import net.gliblybits.bitsengine.input.BitsKeyEvent;

public class ApoHybridOptions extends ApoHybridModel {

	public static final String BACK = "back";
	public static final String TITLE = "ApoHybrid - Options";

	private float clockRotate;
	
	private int textX;
	
	public ApoHybridOptions(ApoHybridPanel game) {
		super(game);
	}

	@Override
	public void init() {
		this.getStringWidth().put(ApoHybridOptions.BACK, (int)(ApoHybridPanel.font.getLength(ApoHybridOptions.BACK)));
		this.getStringWidth().put(ApoHybridOptions.TITLE, (int)(ApoHybridPanel.title_font.getLength(ApoHybridOptions.TITLE)));
		
		String s = "Name: ";
		this.textX = (int)(85 + ApoHybridPanel.game_font.getLength(s));
	}

	@Override
	public void touchedPressed(int x, int y, int finger) {
		if ((x > this.textX) && (x < this.textX + this.getGame().getTextfield().getWidth()) &&
			(y > 120) && (y < 120 + this.getGame().getTextfield().getHeight())) {
			if (!this.getGame().getTextfield().isSelect()) {
				this.getGame().getTextfield().setSelect(true);
				BitsInput.getInstance().setVirtualKeyboardVisible(true);
			}
		} else {
			if (this.getGame().getTextfield().isSelect()) {
				BitsInput.getInstance().setVirtualKeyboardVisible(false);
				this.getGame().savePreferences();
			}
			this.getGame().getTextfield().setSelect(false);
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
		if (function.equals(ApoHybridOptions.BACK)) {
			this.onBackButtonPressed();
		}
	}
	
	public void onBackButtonPressed() {
		this.getGame().setMenu();
	}
	
	public void onKeyDown(final int key) {
	}

	public void onKeyUp(final int key, final BitsKeyEvent event) {
		
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
		this.getGame().drawString(g, ApoHybridOptions.TITLE, 240, 2, ApoHybridPanel.title_font, new float[] {1, 1, 1, 1}, new float[] {0, 0, 0, 1});
		
		if (this.getGame().getButtons() != null) {
			for (int i = 0; i < this.getGame().getButtons().length; i++) {
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
		
		g.setColor(0.0f, 0.0f, 0.0f, 1.0f);
		String s = "Name: ";
		g.drawText(s, 85, 123);
		this.getGame().getTextfield().render(g, this.textX, 120);
		
		g.setFont(ApoHybridPanel.game_font);
		s = "ApoHybrid is made by Dirk 'Apo' Aporius";
		g.drawText(s, 240 - ApoHybridPanel.game_font.getLength(s)/2, 500);
		s = "made with the bits-engine by Marc Wiedenhoeft";
		g.drawText(s, 240 - ApoHybridPanel.game_font.getLength(s)/2, 530);
	}

}
//#elif MonoGameLogic
//@
//@package net.apogames.apohybrid.game;
//@
//@import net.apogames.apohybrid.ApoHybridConstants;
//@import net.apogames.apohybrid.ApoHybridModel;
//@import net.apogames.apohybrid.ApoHybridSoundPlayer;
//@import net.apogames.apohybrid.entity.ApoLevelChooserButton;
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//@
//@public class ApoHybridOptions  extends ApoHybridModel {
//@
//@	public static final String BACK = "back";
//@	public static final String LANGUAGE_GERMAN = "german";
//@	public static final String LANGUAGE_ENGLISH = "english";
//@	public static final String COLOR_WHITE = "white";
//@	public static final String COLOR_GREEN = "green";
//@	public static final String SOUND = "sound";
//@	public static final String MUSIC = "music";
//@	
//@	public ApoHybridOptions(ApoHybridPanel game) {
//@		super(game);
//@	}
//@
//@	@Override
//@	public void init() {
//@	}
//@	
//@	public void onResume() {
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
//@		if (function.equals(ApoHybridOptions.BACK)) {
//@			this.onBackButtonPressed();
//@		} else if (function.equals(ApoHybridOptions.LANGUAGE_GERMAN)) {
//@			ApoLevelChooserButton buttonGerman = (ApoLevelChooserButton)(this.getGame().getButtons()[12]);
//@			if (!buttonGerman.isSelected()) {
//@				buttonGerman.setSelected(true);
//@				((ApoLevelChooserButton)(this.getGame().getButtons()[13])).setSelected(false);
//@				ApoHybridConstants.changeLanguageToGerman();
//@			}
//@		} else if (function.equals(ApoHybridOptions.LANGUAGE_ENGLISH)) {
//@			ApoLevelChooserButton buttonEnglish = (ApoLevelChooserButton)(this.getGame().getButtons()[13]);
//@			if (!buttonEnglish.isSelected()) {
//@				buttonEnglish.setSelected(true);
//@				((ApoLevelChooserButton)(this.getGame().getButtons()[12])).setSelected(false);
//@				ApoHybridConstants.changeLanguageToEnglish();
//@			}
//@		} else if (function.equals(ApoHybridOptions.COLOR_WHITE)) {
//@			ApoLevelChooserButton buttonWhite = (ApoLevelChooserButton)(this.getGame().getButtons()[14]);
//@			if (!buttonWhite.isSelected()) {
//@				buttonWhite.setSelected(true);
//@				((ApoLevelChooserButton)(this.getGame().getButtons()[15])).setSelected(false);
//@				ApoHybridConstants.changeToWhiteColor();
//@			}
//@		} else if (function.equals(ApoHybridOptions.COLOR_GREEN)) {
//@			ApoLevelChooserButton buttonGreen = (ApoLevelChooserButton)(this.getGame().getButtons()[15]);
//@			if (!buttonGreen.isSelected()) {
//@				buttonGreen.setSelected(true);
//@				((ApoLevelChooserButton)(this.getGame().getButtons()[14])).setSelected(false);
//@				ApoHybridConstants.changeToGreenColor();
//@			}
//@		} else if (function.equals(ApoHybridOptions.SOUND)) {
//@			ApoLevelChooserButton buttonSound = (ApoLevelChooserButton)(this.getGame().getButtons()[21]);
//@			buttonSound.setSelected(!buttonSound.isSelected());
//@			this.getGame().setSound(buttonSound.isSelected());
//@		} else if (function.equals(ApoHybridOptions.MUSIC)) {
//@			ApoLevelChooserButton buttonMusic = (ApoLevelChooserButton)(this.getGame().getButtons()[22]);
//@			buttonMusic.setSelected(!buttonMusic.isSelected());
//@			this.getGame().setMusic(buttonMusic.isSelected());
//@		}
//@		this.getGame().playSound(ApoHybridSoundPlayer.SOUND_BUTTON_2);
//@	}
//@	
//@	public void onBackButtonPressed() {
//@		this.getGame().setMenu();
//@	}
//@	
//@	@Override
//@	public void think(int delta) {
//@		
//@	}
//@
//@	@Override
//@	public void render(final BitsGLGraphics g) {
//@		int addY = 0;
//@		if (ApoHybridConstants.FREE_VERSION) {
//@			addY += 45;
//@		}
//@		this.getGame().drawString(g, ApoHybridConstants.OPTION_TITLE, (int)(240 - ApoHybridPanel.title_font.getLength(ApoHybridConstants.OPTION_TITLE)/2), 5 + addY, ApoHybridPanel.title_font);
//@
//@		g.setColor(ApoHybridConstants.BRIGHT_DARK[0], ApoHybridConstants.BRIGHT_DARK[1], ApoHybridConstants.BRIGHT_DARK[2]);
//@		g.fillRect(5, 57 + addY, 420, 58);
//@		g.fillRect(5, 117 + addY, 420, 58);
//@		g.fillRect(5, 177 + addY, 420, 58);
//@		
//@		g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2]);
//@		g.drawRect(5, 57 + addY, 420, 58);
//@		g.drawRect(5, 117 + addY, 420, 58);
//@		g.drawRect(5, 177 + addY, 420, 58);
//@		this.getGame().drawString(g, ApoHybridConstants.OPTION_LANGUAGE, (int)(10), 78 + addY, ApoHybridPanel.game_font);
//@		this.getGame().drawString(g, ApoHybridConstants.OPTION_COLOR, (int)(10), 138 + addY, ApoHybridPanel.game_font);
//@		this.getGame().drawString(g, "audio", (int)(10), 198 + addY, ApoHybridPanel.game_font);
//@		
//@		String s = "deutsch";
//@		this.getGame().drawString(g, s, (int)(175), 78 + addY, ApoHybridPanel.game_font);
//@		s = "english";
//@		this.getGame().drawString(g, s, (int)(310), 78 + addY, ApoHybridPanel.game_font);
//@		
//@		s = ApoHybridConstants.OPTION_COLOR_WHITE;
//@		this.getGame().drawString(g, s, (int)(175), 138 + addY, ApoHybridPanel.game_font);
//@		s = ApoHybridConstants.OPTION_COLOR_GREEN;
//@		this.getGame().drawString(g, s, (int)(310), 138 + addY, ApoHybridPanel.game_font);
//@		
//@		s = ApoHybridConstants.OPTION_SOUND;
//@		this.getGame().drawString(g, s, (int)(175), 198 + addY, ApoHybridPanel.game_font);
//@		s = ApoHybridConstants.OPTION_MUSIC;
//@		this.getGame().drawString(g, s, (int)(310), 198 + addY, ApoHybridPanel.game_font);
//@		
//@		this.getGame().renderButtons(g);
//@	}
//@}
//#elif TreasureGameLogic
//@package net.apogames.apohybrid.game;
//@
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//@
//@import net.apogames.apohybrid.ApoHybridConstants;
//@import net.apogames.apohybrid.ApoHybridModel;
//@import net.apogames.apohybrid.ApoHybridSoundPlayer;
//@
//@public class ApoHybridOptions extends ApoHybridModel {
//@
//@	public static final String BACK = "back";
//@	public static final String MUSIC = "music";
//@	public static final String SOUND = "sound";
//@	
//@	public ApoHybridOptions(final ApoHybridPanel game) {
//@		super(game);
//@	}
//@
//@	@Override
//@	public void init() {
//@	}
//@
//@	@Override
//@	public void touchedButton(String function) {
//@		if (function.equals(ApoHybridOptions.BACK)) {
//@			this.getGame().playSound(ApoHybridSoundPlayer.SOUND_CLICK);
//@			this.onBackButtonPressed();
//@		} else if (function.equals(ApoHybridOptions.MUSIC)) {
//@			this.getGame().setMusic(!this.getGame().getButtons()[24].isSelected());
//@		} else if (function.equals(ApoHybridOptions.SOUND)) {
//@			this.getGame().setSound(!this.getGame().getButtons()[23].isSelected());
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
//@	public void onBackButtonPressed() {
//@		this.getGame().setMenu();
//@	}
//@
//@	
//@	@Override
//@	public void think(int delta) {
//@	}
//@
//@
//@	@Override
//@	public void render(BitsGLGraphics g) {
//@		g.cropImage(ApoHybridConstants.iSheet, 0, 0, ApoHybridConstants.GAME_WIDTH, ApoHybridConstants.GAME_HEIGHT, 1024 - ApoHybridConstants.GAME_WIDTH, 0, ApoHybridConstants.GAME_WIDTH, ApoHybridConstants.GAME_HEIGHT);
//@
//@		g.cropImage(ApoHybridConstants.iSheet, 2 * 4, 60, 76 * 4, 8 * 4, 0, 96 * 4, 76 * 4, 8 * 4);
//@		g.cropImage(ApoHybridConstants.iSheet, 2 * 4, 390, 76 * 4, 8 * 4, 0, 96 * 4, 76 * 4, 8 * 4);
//@		
//@		g.setFont(ApoHybridConstants.FONT_LEVELCHOOSER);
//@		int y = ApoHybridConstants.FONT_LEVELCHOOSER.mCharCellHeight;
//@		g.setColor(ApoHybridConstants.COLOR_DARK[0], ApoHybridConstants.COLOR_DARK[1], ApoHybridConstants.COLOR_DARK[2]);
//@		
//@		String s = "options";
//@		float w = ApoHybridConstants.FONT_LEVELCHOOSER.getLength(s);
//@		g.drawText(s, ApoHybridConstants.GAME_WIDTH/2 - w/2 + 4, 54 - y);
//@		
//@		g.setFont(ApoHybridConstants.fontMedium);
//@		y = ApoHybridConstants.fontMedium.mCharCellHeight;
//@		s = "sound";
//@		g.drawText(s, 25, 170 - y);
//@
//@		s = "music";
//@		g.drawText(s, 25, 250 - y);
//@		
//@		g.setColor(1f, 1f, 1f, 1f);
//@	}
//@
//@}
//@
//#endif
