package net.apogames.apohybrid;

//#ifdef ClockGameLogic
//@import net.apogames.apohybrid.ApoHybridConstants;
//@import net.apogames.apohybrid.game.ApoHybridArcarde;
//@import net.apogames.apohybrid.game.ApoHybridPuzzle;
//#endif
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
			//#ifdef ClockGameLogic
			this.game.setButtons(new ApoButton[20]);

			String function = ApoClockMenu.QUIT;
			int width = 200;
			int height = 70;
			int x = ApoClockConstants.GAME_WIDTH/2 - width/2;
			int y = ApoClockConstants.GAME_HEIGHT - 1 * height - 5;
			this.game.getButtons()[0] = new ApoButton(null, x, y, width, height, function);

			function = ApoClockMenu.PUZZLE;
			width = 300;
			height = 100;
			x = ApoClockConstants.GAME_WIDTH/2 - width/2;
			y = 150;
			this.game.getButtons()[1] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoClockMenu.ARCADE;
			width = 300;
			height = 100;
			x = ApoClockConstants.GAME_WIDTH/2 - width/2;
			y = 150 + height * 1 + 20;
			this.game.getButtons()[2] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoClockPuzzleChooser.BACK;
			width = 70;
			height = 40;
			x = ApoClockConstants.GAME_WIDTH - width - 5;
			y = ApoClockConstants.GAME_HEIGHT - 1 * height - 5;
			this.game.getButtons()[3] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoClockPuzzleGame.BACK;
			width = 70;
			height = 40;
			x = ApoClockConstants.GAME_WIDTH - width - 5;
			y = ApoClockConstants.GAME_HEIGHT - 1 * height - 5;
			this.game.getButtons()[4] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoClockArcarde.BACK;
			width = 70;
			height = 40;
			x = ApoClockConstants.GAME_WIDTH - width - 5;
			y = ApoClockConstants.GAME_HEIGHT - 1 * height - 5;
			this.game.getButtons()[5] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoClockArcarde.START;
			width = 70;
			height = 40;
			x = 5;
			y = ApoClockConstants.GAME_HEIGHT - 1 * height - 5;
			this.game.getButtons()[6] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoClockArcarde.BACK;
			width = 70;
			height = 40;
			x = ApoClockConstants.GAME_WIDTH - width - 5;
			y = ApoClockConstants.GAME_HEIGHT - 1 * height - 5;
			this.game.getButtons()[7] = new ApoButton(null, x, y, width, height, function);

			
			function = ApoClockPuzzle.BACK;
			width = 200;
			height = 70;
			x = ApoClockConstants.GAME_WIDTH/2 - width/2;
			y = ApoClockConstants.GAME_HEIGHT - 1 * height - 5;
			this.game.getButtons()[8] = new ApoButton(null, x, y, width, height, function);

			function = ApoClockPuzzle.PUZZLE;
			width = 300;
			height = 70;
			x = ApoClockConstants.GAME_WIDTH/2 - width/2;
			y = 100;
			this.game.getButtons()[9] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoClockPuzzle.USERLEVELS;
			width = 300;
			height = 70;
			x = ApoClockConstants.GAME_WIDTH/2 - width/2;
			y = 100 + height * 1 + 20;
			this.game.getButtons()[10] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoClockPuzzle.EDITOR;
			width = 300;
			height = 70;
			x = ApoClockConstants.GAME_WIDTH/2 - width/2;
			y = 100 + height * 2 + 20 * 2;
			this.game.getButtons()[11] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoClockEditor.BACK;
			width = 75;
			height = 40;
			x = ApoClockConstants.GAME_WIDTH - width - 5;
			y = ApoClockConstants.GAME_HEIGHT - 1 * height - 5;
			this.game.getButtons()[12] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoClockEditor.UPLOAD;
			width = 75;
			height = 40;
			x = ApoClockConstants.GAME_WIDTH - width * 2 - 5 * 2;
			y = ApoClockConstants.GAME_HEIGHT - 1 * height - 5;
			this.game.getButtons()[13] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoClockEditor.TEST;
			width = 75;
			height = 40;
			x = ApoClockConstants.GAME_WIDTH - width * 3 - 5 * 3;
			y = ApoClockConstants.GAME_HEIGHT - 1 * height - 5;
			this.game.getButtons()[14] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoClockEditor.REMOVE;
			width = 75;
			height = 40;
			x = ApoClockConstants.GAME_WIDTH - width * 4 - 5 * 4;
			y = ApoClockConstants.GAME_HEIGHT - 1 * height - 5;
			this.game.getButtons()[15] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoClockEditor.ADD;
			width = 75;
			height = 40;
			x = ApoClockConstants.GAME_WIDTH - width * 5 - 5 * 5;
			y = ApoClockConstants.GAME_HEIGHT - 1 * height - 5;
			this.game.getButtons()[16] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoClockEditor.NEW;
			width = 75;
			height = 40;
			x = ApoClockConstants.GAME_WIDTH - width * 6 - 5 * 6;
			y = ApoClockConstants.GAME_HEIGHT - 1 * height - 5;
			this.game.getButtons()[17] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoClockOptions.BACK;
			width = 200;
			height = 70;
			x = ApoClockConstants.GAME_WIDTH/2 - width/2;
			y = ApoClockConstants.GAME_HEIGHT - 1 * height - 5;
			this.game.getButtons()[18] = new ApoButton(null, x, y, width, height, function);
			
			function = ApoClockMenu.OPTIONS;
			width = 300;
			height = 100;
			x = ApoClockConstants.GAME_WIDTH/2 - width/2;
			y = 150 + height * 2 + 2 * 20;
			this.game.getButtons()[19] = new ApoButton(null, x, y, width, height, function);
			//#else

				//#ifdef DiceGameLogic
				this.game.setButtons(new ApoButton[11]);

				//#elifdef SnakeGameLogic
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
				//#ifdef DiceGameLogic
				y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
				//#elifdef SnakeGameLogic
	//@			y = ApoHybridConstants.GAME_HEIGHT - 60 - 1 * height - 20;
				//#endif			
				this.game.getButtons()[5] = new ApoButton(null, x, y, width, height, function);
				
				function = ApoHybridEditor.BACK;
				width = 70;
				height = 40;
				x = ApoHybridConstants.GAME_WIDTH - width - 5;
				y = ApoHybridConstants.GAME_HEIGHT - 1 * height - 10;
				this.game.getButtons()[6] = new ApoButton(null, x, y, width, height, function);
				
				//#ifdef DiceGameLogic
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
				
				//#elifdef SnakeGameLogic
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
			//#endif
			for (int i = 0; i < this.game.getButtons().length; i++) {
				this.game.getButtons()[i].setBOpaque(true);
			}
		}
	}
}
