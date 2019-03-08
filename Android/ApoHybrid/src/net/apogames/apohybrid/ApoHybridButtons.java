package net.apogames.apohybrid;

import net.apogames.apohybrid.entity.ApoButton;
import net.apogames.apohybrid.game.ApoHybridEditor;
import net.apogames.apohybrid.game.ApoHybridMenu;
import net.apogames.apohybrid.game.ApoHybridPanel;
import net.apogames.apohybrid.game.ApoHybridPuzzleChooser;
import net.apogames.apohybrid.game.ApoHybridGame;

public class ApoHybridButtons {
	
	private final ApoHybridPanel game;
	
	public ApoHybridButtons(final ApoHybridPanel game) {
		this.game = game;
	}

	public void init() {
		if (this.game.getButtons() == null) {
			//#if Dice
			this.game.setButtons(new ApoButton[11]);

			//#elif Snake
//@			this.game.setButtons(new ApoButton[13]);
//@			
			//#endif

			String function = ApoHybridMenu.QUIT;
			int width = 200;
			int height = 60;
			int x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
			int y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 5;
			this.game.getButtons()[0] = new ApoButton(null, x, y, width, height, function);

			function = ApoHybridMenu.PUZZLE;
			width = 300;
			height = 60;
			x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
			y = 150;
			this.game.getButtons()[1] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoHybridMenu.USERLEVELS;
			width = 300;
			height = 60;
			x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
			y = 150 + height * 1 + 20 * 1;
			this.game.getButtons()[2] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoHybridMenu.EDITOR;
			width = 300;
			height = 60;
			x = ApoHybridConstants.GAME_WIDTH/2 - width/2;
			y = 150 + height * 2 + 20 * 2;
			this.game.getButtons()[3] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoHybridPuzzleChooser.BACK;
			width = 70;
			height = 40;
			x = ApoHybridConstants.GAME_WIDTH - width - 5;
			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
			this.game.getButtons()[4] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoHybridGame.BACK;
			width = 70;
			height = 40;
			x = ApoHybridConstants.GAME_WIDTH - width - 5;
			//#if Dice
			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
			//#elif Snake
//@			y = ApoHybridConstants.GAME_HEIGHT - 60 - 1 * height - 20;
			//#endif			
			this.game.getButtons()[5] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoHybridEditor.BACK;
			width = 70;
			height = 40;
			x = ApoHybridConstants.GAME_WIDTH - width - 5;
			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
			this.game.getButtons()[6] = new ApoButton(null, x, y, width, height, function);
			
			//#if Dice
			function = ApoHybridEditor.NEW;
			width = 70;
			height = 40;
			x = ApoHybridConstants.GAME_WIDTH - 4 * width - 10 * 4;
			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
			this.game.getButtons()[7] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoHybridEditor.TEST;
			width = 70;
			height = 40;
			x = ApoHybridConstants.GAME_WIDTH - 3 * width - 10 * 3;
			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
			this.game.getButtons()[8] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoHybridEditor.UPLOAD;
			width = 70;
			height = 40;
			x = ApoHybridConstants.GAME_WIDTH - 2 * width - 10 * 2;
			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
			this.game.getButtons()[9] = new ApoButton(null, x, y, width, height, function);

			function = ApoHybridEditor.SOLVE;
			width = 70;
			height = 20;
			x = ApoHybridConstants.GAME_WIDTH - width - 10;
			y = 2;
			this.game.getButtons()[10] = new ApoButton(null, x, y, width, height, function);
			
			//#elif Snake
//@			function = ApoHybridEditor.TEST;
//@			width = 70;
//@			height = 40;
//@			x = ApoHybridConstants.GAME_WIDTH - 3 * width - 10 * 3;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
//@			this.game.getButtons()[7] = new ApoButton(null, x, y, width, height, function);
//@			
//@			function = ApoHybridEditor.UPLOAD;
//@			width = 70;
//@			height = 40;
//@			x = ApoHybridConstants.GAME_WIDTH - 2 * width - 10 * 2;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
//@			this.game.getButtons()[8] = new ApoButton(null, x, y, width, height, function);
//@			
//@			function = ApoHybridEditor.XMINUS;
//@			width = 40;
//@			height = 40;
//@			x = 5;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
//@			this.game.getButtons()[9] = new ApoButton(null, x, y, width, height, function);
//@			
//@			function = ApoHybridEditor.XPLUS;
//@			width = 40;
//@			height = 40;
//@			x = 5 + 70;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
//@			this.game.getButtons()[10] = new ApoButton(null, x, y, width, height, function);
//@			
//@			function = ApoHybridEditor.YMINUS;
//@			width = 40;
//@			height = 40;
//@			x = 120;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
//@			this.game.getButtons()[11] = new ApoButton(null, x, y, width, height, function);
//@			
//@			function = ApoHybridEditor.YPLUS;
//@			width = 40;
//@			height = 40;
//@			x = 120 + 70;
//@			y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
//@			this.game.getButtons()[12] = new ApoButton(null, x, y, width, height, function);
//@			
			//#endif

			for (int i = 0; i < this.game.getButtons().length; i++) {
				this.game.getButtons()[i].setBOpaque(true);
			}
		}
	}
}
