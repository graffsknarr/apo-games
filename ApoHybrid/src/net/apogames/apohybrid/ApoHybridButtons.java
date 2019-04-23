package net.apogames.apohybrid;

import net.apogames.apohybrid.entity.ApoButton;
import net.apogames.apohybrid.game.ApoHybridEditor;
import net.apogames.apohybrid.game.ApoHybridLevelChooser;
import net.apogames.apohybrid.game.ApoHybridMenu;
import net.apogames.apohybrid.game.ApoHybridPanel;
import net.apogames.apohybrid.game.ApoHybridGame;

//#if ClockGameLogic
//@import net.apogames.apohybrid.game.ApoHybridArcarde;
//@import net.apogames.apohybrid.game.ApoHybridOptions;
//@import net.apogames.apohybrid.game.ApoHybridPuzzle;
//#elif MonoGameLogic
//@import net.apogames.apohybrid.entity.ApoLevelChooserButton;
//@import net.apogames.apohybrid.game.ApoHybridCredits;
//@import net.apogames.apohybrid.game.ApoHybridOptions;
//#elif TreasureGameLogic
//@import net.apogames.apohybrid.game.ApoHybridCredits;
//@import net.apogames.apohybrid.game.ApoHybridMap;
//@import net.apogames.apohybrid.game.ApoHybridOptions;
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLFont;
//#endif

public class ApoHybridButtons {

	private final ApoHybridPanel game;

	//#if TreasureGameLogic
//@	public ApoHybridButtons(ApoHybridPanel game) {
//@		this.game = game;
//@	}
	//#else
	public ApoHybridButtons(final ApoHybridPanel game) {
		this.game = game;
	}
	//#endif

	public void init() {
		if (this.game.getButtons() == null) {
		    //#if ApoMenu
//@
            //#if ClockGameLogic
//@            this.game.setButtons(new ApoButton[20]);
//@
            //#elif MonoGameLogic
//@            this.game.setButtons(new ApoButton[23]);
//@
            //#elif TreasureGameLogic
//@            this.game.setButtons(new ApoButton[27]);
//@
            //#elif DiceGameLogic
//@            this.game.setButtons(new ApoButton[12]);
//@
            //#endif
//@			String function = ApoHybridMenu.QUIT;
//@			int width = 200;
//@			int height = 60;
//@			int x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
//@			int y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 5;
//@			this.game.getButtons()[0] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridMenu.PLAY;
//@			width = 300;
//@			height = 60;
//@			x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
//@			y = 150;
//@			this.game.getButtons()[1] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridMenu.USERLEVELS;
//@			width = 300;
//@			height = 60;
//@			x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
//@			y = 150 + height * 1 + 20 * 1;
//@			this.game.getButtons()[2] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridMenu.EDITOR;
//@			width = 300;
//@			height = 60;
//@			x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
//@			y = 150 + height * 2 + 20 * 2;
//@			this.game.getButtons()[3] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridMenu.OPTIONS;
//@			width = 300;
//@			height = 60;
//@			x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
//@			y = 150 + height * 3 + 20 * 3;
//@			this.game.getButtons()[4] = new ApoButton(null, x, y, width, height, function);
//@
//@
			//#endif

			//#if ClockGameLogic
//@			function = ApoHybridMenu.ARCADE;
//@			width = 300;
//@			height = 70;
//@			x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
//@			y = 150 + height * 1 + 20;
//@			this.game.getButtons()[5] = new ApoButton(null, x, y, width, height, function);
//@
//@
//@			function = ApoHybridLevelChooser.BACK;
//@			width = 70;
//@			height = 40;
//@			x = ApoHybridConstants.GAME_WIDTH - width - 5;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 5;
//@			this.game.getButtons()[6] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridGame.BACK;
//@			width = 70;
//@			height = 40;
//@			x = ApoHybridConstants.GAME_WIDTH - width - 5;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 5;
//@			this.game.getButtons()[7] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridArcarde.BACK;
//@			width = 70;
//@			height = 40;
//@			x = ApoHybridConstants.GAME_WIDTH - width - 5;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 5;
//@			this.game.getButtons()[8] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridArcarde.START;
//@			width = 70;
//@			height = 40;
//@			x = 5;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 5;
//@			this.game.getButtons()[9] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridArcarde.BACK;
//@			width = 70;
//@			height = 40;
//@			x = ApoHybridConstants.GAME_WIDTH - width - 5;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 5;
//@			this.game.getButtons()[10] = new ApoButton(null, x, y, width, height, function);
//@
//@
//@			function = ApoHybridPuzzle.BACK;
//@			width = 200;
//@			height = 70;
//@			x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 5;
//@			this.game.getButtons()[11] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridPuzzle.PUZZLE;
//@			width = 300;
//@			height = 70;
//@			x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
//@			y = 150;
//@			this.game.getButtons()[12] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridEditor.BACK;
//@			width = 75;
//@			height = 40;
//@			x = ApoHybridConstants.GAME_WIDTH - width - 5;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 5;
//@			this.game.getButtons()[13] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridEditor.UPLOAD;
//@			width = 75;
//@			height = 40;
//@			x = ApoHybridConstants.GAME_WIDTH - width * 2 - 5 * 2;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 5;
//@			this.game.getButtons()[14] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridEditor.TEST;
//@			width = 75;
//@			height = 40;
//@			x = ApoHybridConstants.GAME_WIDTH - width * 3 - 5 * 3;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 5;
//@			this.game.getButtons()[15] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridEditor.REMOVE;
//@			width = 75;
//@			height = 40;
//@			x = ApoHybridConstants.GAME_WIDTH - width * 4 - 5 * 4;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 5;
//@			this.game.getButtons()[16] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridEditor.ADD;
//@			width = 75;
//@			height = 40;
//@			x = ApoHybridConstants.GAME_WIDTH - width * 5 - 5 * 5;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 5;
//@			this.game.getButtons()[17] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridEditor.NEW;
//@			width = 75;
//@			height = 40;
//@			x = ApoHybridConstants.GAME_WIDTH - width * 6 - 5 * 6;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 5;
//@			this.game.getButtons()[18] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridOptions.BACK;
//@			width = 200;
//@			height = 70;
//@			x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 5;
//@			this.game.getButtons()[19] = new ApoButton(null, x, y, width, height, function);
//@
			//#elif MonoGameLogic
//@			this.game.setButtons(new ApoButton[23]);
//@
//@			int addY = 0;
//@			if (ApoHybridConstants.FREE_VERSION) {
//@				addY = 45;
//@			}
//@
//@			String function = ApoHybridMenu.QUIT;
//@			int width = 48;
//@			int height = 48;
//@			int x = ApoHybridConstants.GAME_WIDTH - width - 5;
//@			int y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 5;
//@			this.game.getButtons()[0] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridMenu.PLAY;
//@			width = 320;
//@			height = 64;
//@			x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
//@			y = 100;
//@			this.game.getButtons()[1] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridMenu.EDITOR;
//@			width = 320;
//@			height = 64;
//@			x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
//@			y = 100 + height * 1 + 6;
//@			this.game.getButtons()[2] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridGame.BACK;
//@			width = 60;
//@			height = 38;
//@			x = ApoHybridConstants.GAME_WIDTH - width - 5;
//@			y = 1;
//@			this.game.getButtons()[3] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridEditor.BACK;
//@			width = 60;
//@			height = 38;
//@			x = ApoHybridConstants.GAME_WIDTH - width - 5;
//@			y = 1;
//@			this.game.getButtons()[4] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridEditor.TEST;
//@			width = 60;
//@			height = 38;
//@			x = ApoHybridConstants.GAME_WIDTH - 3 * width - 3 * 5;
//@			y = 1;
//@			this.game.getButtons()[5] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridEditor.NEW;
//@			width = 60;
//@			height = 38;
//@			x = ApoHybridConstants.GAME_WIDTH - 4 * width - 4 * 5;
//@			y = 1;
//@			this.game.getButtons()[6] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridEditor.UPLOAD;
//@			width = 60;
//@			height = 38;
//@			x = ApoHybridConstants.GAME_WIDTH - 2 * width - 2 * 5;
//@			y = 1;
//@			this.game.getButtons()[7] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridMenu.USERLEVELS;
//@			width = 320;
//@			height = 64;
//@			x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
//@			y = 100 + height * 2 + 12;
//@			this.game.getButtons()[8] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridMenu.CREDITS;
//@			width = 48;
//@			height = 48;
//@			x = 5;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 5;
//@			this.game.getButtons()[9] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridCredits.BACK;
//@			width = 80;
//@			height = 40;
//@			x = ApoHybridConstants.GAME_WIDTH - width - 5;
//@			y = ApoHybridConstants.GAME_HEIGHT- height - 5;
//@			this.game.getButtons()[10] = new ApoLevelChooserButton(x, y, width, height, function, function, true);
//@
//@			function = ApoHybridOptions.BACK;
//@			width = 80;
//@			height = 40;
//@			x = ApoHybridConstants.GAME_WIDTH - width - 5;
//@			y = ApoHybridConstants.GAME_HEIGHT- height - 5;
//@			this.game.getButtons()[11] = new ApoLevelChooserButton(x, y, width, height, function, function, true);
//@
//@			function = ApoHybridOptions.LANGUAGE_GERMAN;
//@			width = 48;
//@			height = 48;
//@			x = 120;
//@			y = 60 + addY;
//@			this.game.getButtons()[12] = new ApoLevelChooserButton(x, y, width, height, function, "x");
//@
//@			function = ApoHybridOptions.LANGUAGE_ENGLISH;
//@			width = 48;
//@			height = 48;
//@			x = 255;
//@			y = 60 + addY;
//@			this.game.getButtons()[13] = new ApoLevelChooserButton(x, y, width, height, function, "x", true);
//@
//@			function = ApoHybridOptions.COLOR_WHITE;
//@			width = 48;
//@			height = 48;
//@			x = 120;
//@			y = 120 + addY;
//@			this.game.getButtons()[14] = new ApoLevelChooserButton(x, y, width, height, function, "x");
//@
//@			function = ApoHybridOptions.COLOR_GREEN;
//@			width = 48;
//@			height = 48;
//@			x = 255;
//@			y = 120 + addY;
//@			this.game.getButtons()[15] = new ApoLevelChooserButton(x, y, width, height, function, "x", true);
//@
//@			function = ApoHybridMenu.OPTIONS;
//@			width = 48;
//@			height = 48;
//@			x = 5;
//@			y = 100;
//@			this.game.getButtons()[16] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridGame.RETRY;
//@			width = 65;
//@			height = 38;
//@			x = ApoHybridConstants.GAME_WIDTH - 2 * width - 1 * 5;
//@			y = 1;
//@			this.game.getButtons()[17] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridLevelChooser.BACK;
//@			width = 50;
//@			height = 40;
//@			x = ApoHybridConstants.GAME_WIDTH - width - 5;
//@			y = ApoHybridConstants.GAME_HEIGHT- height - 5;
//@			this.game.getButtons()[18] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridLevelChooser.LEFT;
//@			width = 40;
//@			height = 40;
//@			x = 5;
//@			y = ApoHybridGame.changeY + 135;
//@			this.game.getButtons()[19] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridLevelChooser.RIGHT;
//@			width = 40;
//@			height = 40;
//@			x = ApoHybridConstants.GAME_WIDTH - width - 5;
//@			y = ApoHybridGame.changeY + 135;
//@			this.game.getButtons()[20] = new ApoButton(null, x, y, width, height, function);
//@
//@			function = ApoHybridOptions.SOUND;
//@			width = 48;
//@			height = 48;
//@			x = 120;
//@			y = 180 + addY;
//@			this.game.getButtons()[21] = new ApoLevelChooserButton(x, y, width, height, function, "x");
//@
//@			function = ApoHybridOptions.MUSIC;
//@			width = 48;
//@			height = 48;
//@			x = 255;
//@			y = 180 + addY;
//@			this.game.getButtons()[22] = new ApoLevelChooserButton(x, y, width, height, function, "x");
//@
//@
			//#elif TreasureGameLogic			
//@			this.game.setButtons(new ApoButton[27]);
//@			
//@			BitsGLFont fontVerySmall = ApoHybridConstants.fontSmall;
//@			BitsGLFont fontSmall = ApoHybridConstants.fontMedium;
//@			BitsGLFont font = ApoHybridConstants.FONT_LEVELCHOOSER;
//@			String text = ApoHybridMenu.QUIT;
//@			String function = ApoHybridMenu.QUIT;
//@			int width = 32;
//@			int height = 32;
//@			int x = ApoHybridConstants.GAME_WIDTH - width - 10;
//@			int y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 20;
//@			this.game.getButtons()[0] = new ApoButton(x, y, width, height, 56 * 4, 0, function, text, fontSmall, ApoHybridConstants.COLOR_LIGHT);
//@
//@			text = ApoHybridMenu.PLAY;
//@			function = ApoHybridMenu.PLAY;
//@			width = 192;
//@			height = 64;
//@			x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
//@			y = ApoHybridConstants.GAME_HEIGHT/2 - 80;
//@			this.game.getButtons()[1] = new ApoButton(x, y, width, height, 128, 320, function, text, font, ApoHybridConstants.COLOR_LIGHT);
//@
//@			text = ApoHybridMenu.USERLEVELS;
//@			function = ApoHybridMenu.USERLEVELS;
//@			width = 192;
//@			height = 64;
//@			x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
//@			y = ApoHybridConstants.GAME_HEIGHT/2 - 80 + (height + 5) * 1;
//@			if (ApoHybridConstants.FREE_VERSION) {
//@				this.game.getButtons()[2] = new ApoButton(x, y, width, height, 32 * 4, 64 * 4, function, text, font, ApoHybridConstants.COLOR_LIGHT);
//@			} else {
//@				this.game.getButtons()[2] = new ApoButton(x, y, width, height, 32 * 4, 80 * 4, function, text, font, ApoHybridConstants.COLOR_LIGHT);
//@			}
//@
//@			text = ApoHybridMenu.EDITOR;
//@			function = ApoHybridMenu.EDITOR;
//@			width = 192;
//@			height = 64;
//@			x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
//@			y = ApoHybridConstants.GAME_HEIGHT/2 - 80 + (height + 5) * 2;
//@			if (ApoHybridConstants.FREE_VERSION) {
//@				this.game.getButtons()[3] = new ApoButton(x, y, width, height, 32 * 4, 64 * 4, function, text, font, ApoHybridConstants.COLOR_LIGHT);
//@			} else {
//@				this.game.getButtons()[3] = new ApoButton(x, y, width, height, 32 * 4, 80 * 4, function, text, font, ApoHybridConstants.COLOR_LIGHT);
//@			}
//@
//@			text = ApoHybridMenu.CREDITS;
//@			function = ApoHybridMenu.CREDITS;
//@			width = 32;
//@			height = 32;
//@			x = 14;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 24;
//@			this.game.getButtons()[4] = new ApoButton(x, y, width, height, 56 * 4, 0 * 4, function, text, fontSmall, ApoHybridConstants.COLOR_LIGHT);
//@			
//@			text = ApoHybridLevelChooser.BACK;
//@			function = ApoHybridLevelChooser.BACK;
//@			width = 32;
//@			height = 32;
//@			x = 7 * 4;
//@			y = 5 * 4;
//@			this.game.getButtons()[5] = new ApoButton(x, y, width, height, 0 * 4, 120 * 4, function, "", fontSmall, ApoHybridConstants.COLOR_LIGHT);
//@			
//@			text = ApoHybridGame.BACK;
//@			function = ApoHybridGame.BACK;
//@			width = 32;
//@			height = 32;
//@			x = ApoHybridConstants.GAME_WIDTH - width - 8;
//@			y = 0;
//@			this.game.getButtons()[6] = new ApoButton(x, y, width, height, 56 * 4, 16 * 4, function, "", fontSmall, ApoHybridConstants.COLOR_LIGHT);
//@			
//@			text = ApoHybridMap.BACK;
//@			function = ApoHybridMap.BACK;
//@			width = 32;
//@			height = 32;
//@			x = 7 * 4;
//@			y = 5 * 4;
//@			this.game.getButtons()[7] = new ApoButton(x, y, width, height, 0 * 4, 120 * 4, function, "", fontSmall, ApoHybridConstants.COLOR_LIGHT);
//@			
//@			text = ApoHybridGame.INGAME_RESTART;
//@			function = ApoHybridGame.INGAME_RESTART;
//@			width = 32;
//@			height = 32;
//@			x = ApoHybridConstants.GAME_WIDTH - 2 * width - 16;
//@			y = 0;
//@			this.game.getButtons()[8] = new ApoButton(x, y, width, height, 48 * 4, 16 * 4, function, "", font, ApoHybridConstants.COLOR_LIGHT);
//@			
//@			text = ApoHybridGame.INGAME_NEXT;
//@			function = ApoHybridGame.INGAME_NEXT;
//@			width = 32;
//@			height = 32;
//@			x = ApoHybridConstants.GAME_WIDTH - width - 48;
//@			y = ApoHybridConstants.GAME_HEIGHT - height;
//@			this.game.getButtons()[9] = new ApoButton(x, y, width, height, 48 * 4, 32 * 4, function, "", font, ApoHybridConstants.COLOR_LIGHT);
//@
//@			
//@			text = ApoHybridGame.INGAME_PREVIOUS;
//@			function = ApoHybridGame.INGAME_PREVIOUS;
//@			width = 32;
//@			height = 32;
//@			x = 48;
//@			y = ApoHybridConstants.GAME_HEIGHT - height;
//@			this.game.getButtons()[10] = new ApoButton(x, y, width, height, 48 * 4, 24 * 4, function, "", font, ApoHybridConstants.COLOR_LIGHT);
//@			
//@			text = ApoHybridGame.RESULT_MENU;
//@			function = ApoHybridGame.RESULT_MENU;
//@			width = 64;
//@			height = 64;
//@			x = 48;
//@			y = 380;
//@			this.game.getButtons()[11] = new ApoButton(x, y, width, height, 16 * 4, 40 * 4, function, "", font, ApoHybridConstants.COLOR_LIGHT);
//@
//@			
//@			text = ApoHybridGame.RESULT_RESTART;
//@			function = ApoHybridGame.RESULT_RESTART;
//@			width = 64;
//@			height = 64;
//@			x = 128;
//@			y = 380;
//@			this.game.getButtons()[12] = new ApoButton(x, y, width, height, 0 * 4, 40 * 4, function, "", font, ApoHybridConstants.COLOR_LIGHT);
//@			
//@			text = ApoHybridGame.RESULT_NEXT;
//@			function = ApoHybridGame.RESULT_NEXT;
//@			width = 64;
//@			height = 64;
//@			x = 208;
//@			y = 380;
//@			this.game.getButtons()[13] = new ApoButton(x, y, width, height, 0 * 4, 56 * 4, function, "", font, ApoHybridConstants.COLOR_LIGHT);
//@			
//@			text = ApoHybridCredits.BACK;
//@			function = ApoHybridCredits.BACK;
//@			width = 32;
//@			height = 32;
//@			x = 7 * 4;
//@			y = 5 * 4;
//@			this.game.getButtons()[14] = new ApoButton(x, y, width, height, 0 * 4, 120 * 4, function, "", font, ApoHybridConstants.COLOR_LIGHT);
//@
//@			text = ApoHybridEditor.BACK;
//@			function = ApoHybridEditor.BACK;
//@			width = 32;
//@			height = 32;
//@			x = ApoHybridConstants.GAME_WIDTH - width - 8;
//@			y = 0;
//@			this.game.getButtons()[15] = new ApoButton(x, y, width, height, 56 * 4, 16 * 4, function, "", font, ApoHybridConstants.COLOR_LIGHT);
//@			
//@			text = ApoHybridEditor.SIZE_LEFT;
//@			function = ApoHybridEditor.SIZE_LEFT;
//@			width = 32;
//@			height = 32;
//@			x = 8;
//@			y = ApoHybridConstants.GAME_HEIGHT - height * 2;
//@			this.game.getButtons()[16] = new ApoButton(x, y, width, height, 48 * 4, 24 * 4, function, "", font, ApoHybridConstants.COLOR_LIGHT);
//@			
//@			text = ApoHybridEditor.SIZE_RIGHT;
//@			function = ApoHybridEditor.SIZE_RIGHT;
//@			width = 32;
//@			height = 32;
//@			x = 80;
//@			y = ApoHybridConstants.GAME_HEIGHT - height * 2;
//@			this.game.getButtons()[17] = new ApoButton(x, y, width, height, 48 * 4, 32 * 4, function, "", font, ApoHybridConstants.COLOR_LIGHT);
//@
//@			text = ApoHybridEditor.TEST;
//@			function = ApoHybridEditor.TEST;
//@			width = 64;
//@			height = 32;
//@			x = 8;
//@			y = 0;
//@			this.game.getButtons()[18] = new ApoButton(x, y, width, height, 32 * 4, 40 * 4, function, text, fontVerySmall, ApoHybridConstants.COLOR_SEPARATOR);
//@			
//@			text = ApoHybridEditor.UPLOAD;
//@			function = ApoHybridEditor.UPLOAD;
//@			width = 64;
//@			height = 32;
//@			x = 96;
//@			y = 0;
//@			this.game.getButtons()[19] = new ApoButton(x, y, width, height, 32 * 4, 40 * 4, function, text, fontVerySmall, ApoHybridConstants.COLOR_SEPARATOR);
//@
//@			text = ApoHybridEditor.SOLVE;
//@			function = ApoHybridEditor.SOLVE;
//@			width = 64;
//@			height = 32;
//@			x = 184;
//@			y = 0;
//@			this.game.getButtons()[20] = new ApoButton(x, y, width, height, 32 * 4, 40 * 4, function, text, fontVerySmall, ApoHybridConstants.COLOR_SEPARATOR);
//@
//@			text = ApoHybridMenu.OPTIONS;
//@			function = ApoHybridMenu.OPTIONS;
//@			width = 32;
//@			height = 32;
//@			x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 24;
//@			this.game.getButtons()[21] = new ApoButton(x, y, width, height, 56 * 4, 0 * 4, function, text, fontSmall, ApoHybridConstants.COLOR_LIGHT);
//@
//@			text = ApoHybridOptions.BACK;
//@			function = ApoHybridOptions.BACK;
//@			width = 32;
//@			height = 32;
//@			x = 7 * 4;
//@			y = 5 * 4;
//@			this.game.getButtons()[22] = new ApoButton(x, y, width, height, 0 * 4, 120 * 4, function, "", font, ApoHybridConstants.COLOR_LIGHT);
//@
//@			text = "";
//@			function = ApoHybridOptions.SOUND;
//@			width = 32;
//@			height = 32;
//@			x = ApoHybridConstants.GAME_WIDTH*3/4 - width/2;
//@			y = 160 - height/2;
//@			this.game.getButtons()[23] = new ApoButton(x, y, width, height, 56 * 4, 0 * 4, function, text, fontSmall, ApoHybridConstants.COLOR_LIGHT);
//@			this.game.getButtons()[23].setSelected(true);
//@			
//@			text = "";
//@			function = ApoHybridOptions.MUSIC;
//@			width = 32;
//@			height = 32;
//@			x = ApoHybridConstants.GAME_WIDTH*3/4 - width/2;
//@			y = 240 - height/2;
//@			this.game.getButtons()[24] = new ApoButton(x, y, width, height, 56 * 4, 0 * 4, function, text, fontSmall, ApoHybridConstants.COLOR_LIGHT);
//@			this.game.getButtons()[24].setSelected(true);
//@			
//@			text = ApoHybridGame.INGAME_MUSIC;
//@			function = ApoHybridGame.INGAME_MUSIC;
//@			width = 32;
//@			height = 32;
//@			x = ApoHybridConstants.GAME_WIDTH - width - 8;
//@			y = ApoHybridConstants.GAME_HEIGHT - height;
//@			this.game.getButtons()[25] = new ApoButton(x, y, width, height, 48 * 4, 48 * 4, function, "", font, ApoHybridConstants.COLOR_SEPARATOR);
//@
//@			text = ApoHybridGame.INGAME_SOUND;
//@			function = ApoHybridGame.INGAME_SOUND;
//@			width = 32;
//@			height = 32;
//@			x = 8;
//@			y = ApoHybridConstants.GAME_HEIGHT - height;
//@			this.game.getButtons()[26] = new ApoButton(x, y, width, height, 48 * 4, 40 * 4, function, "", font, ApoHybridConstants.COLOR_SEPARATOR);
//@			
//@
//@
			//#elif SnakeGameLogic || DiceGameLogic
//@
//@				function = ApoHybridLevelChooser.BACK;
//@				width = 70;
//@				height = 40;
//@				x = ApoHybridConstants.GAME_WIDTH - width - 5;
//@				y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
//@				this.game.getButtons()[5] = new ApoButton(null, x, y, width, height, function);
//@
//@				function = ApoHybridGame.BACK;
//@				width = 70;
//@				height = 40;
//@				x = ApoHybridConstants.GAME_WIDTH - width - 5;
			//#if DiceGameLogic
//@				y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
			//#elif SnakeGameLogic
//@				y = ApoHybridConstants.GAME_HEIGHT - 60 - 1 * height - 20;
			//#endif
//@				this.game.getButtons()[6] = new ApoButton(null, x, y, width, height, function);
//@
//@				function = ApoHybridEditor.BACK;
//@				width = 70;
//@				height = 40;
//@				x = ApoHybridConstants.GAME_WIDTH - width - 5;
//@				y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
//@				this.game.getButtons()[7] = new ApoButton(null, x, y, width, height, function);
//@
			//#if DiceGameLogic
//@				function = ApoHybridEditor.NEW;
//@				width = 70;
//@				height = 40;
//@				x = ApoHybridConstants.GAME_WIDTH - 4 * width - 10 * 4;
//@				y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
//@				this.game.getButtons()[8] = new ApoButton(null, x, y, width, height, function);
//@
//@				function = ApoHybridEditor.TEST;
//@				width = 70;
//@				height = 40;
//@				x = ApoHybridConstants.GAME_WIDTH - 3 * width - 10 * 3;
//@				y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
//@				this.game.getButtons()[9] = new ApoButton(null, x, y, width, height, function);
//@
//@				function = ApoHybridEditor.UPLOAD;
//@				width = 70;
//@				height = 40;
//@				x = ApoHybridConstants.GAME_WIDTH - 2 * width - 10 * 2;
//@				y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
//@				this.game.getButtons()[10] = new ApoButton(null, x, y, width, height, function);
//@
//@				function = ApoHybridEditor.SOLVE;
//@				width = 70;
//@				height = 20;
//@				x = ApoHybridConstants.GAME_WIDTH - width - 10;
//@				y = 2;
//@				this.game.getButtons()[11] = new ApoButton(null, x, y, width, height, function);
//@
			//#elif SnakeGameLogic
//@				function = ApoHybridEditor.TEST;
//@				width = 70;
//@				height = 40;
//@				x = ApoHybridConstants.GAME_WIDTH - 3 * width - 10 * 3;
//@				y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
//@				this.game.getButtons()[7] = new ApoButton(null, x, y, width, height, function);
//@
//@				function = ApoHybridEditor.UPLOAD;
//@				width = 70;
//@				height = 40;
//@				x = ApoHybridConstants.GAME_WIDTH - 2 * width - 10 * 2;
//@				y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
//@				this.game.getButtons()[8] = new ApoButton(null, x, y, width, height, function);
//@
//@				function = ApoHybridEditor.XMINUS;
//@				width = 40;
//@				height = 40;
//@				x = 5;
//@				y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
//@				this.game.getButtons()[9] = new ApoButton(null, x, y, width, height, function);
//@
//@				function = ApoHybridEditor.XPLUS;
//@				width = 40;
//@				height = 40;
//@				x = 5 + 70;
//@				y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
//@				this.game.getButtons()[10] = new ApoButton(null, x, y, width, height, function);
//@
//@				function = ApoHybridEditor.YMINUS;
//@				width = 40;
//@				height = 40;
//@				x = 120;
//@				y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
//@				this.game.getButtons()[11] = new ApoButton(null, x, y, width, height, function);
//@
//@				function = ApoHybridEditor.YPLUS;
//@				width = 40;
//@				height = 40;
//@				x = 120 + 70;
//@				y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
//@				this.game.getButtons()[12] = new ApoButton(null, x, y, width, height, function);
//@
			//#endif
			//#endif

			for (int i = 0; i < this.game.getButtons().length; i++) {
				this.game.getButtons()[i].setBOpaque(true);
			}
		}
	}
}
