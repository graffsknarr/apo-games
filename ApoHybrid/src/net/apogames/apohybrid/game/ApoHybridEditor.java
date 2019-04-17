package net.apogames.apohybrid.game;

//#if DiceGameLogic
//@import net.apogames.apohybrid.ApoHybrid;
//@import net.apogames.apohybrid.ApoHybridModel;
//@import net.apogames.apohybrid.ApoHybridConstants;
//@import net.apogames.apohybrid.entity.ApoHybridString;
//@
//@import net.gliblybits.bitsengine.render.BitsGraphics;
//@import net.gliblybits.bitsengine.utils.BitsLog;
//@
//@public class ApoHybridEditor extends ApoHybridModel {
//@
//@	private final int EMPTY = 0;
//@	private final int GOAL = 1;
//@	private final int DICE_EMPTY = 2;
//@	private final int DICE_ONE = 3;
//@	private final int DICE_TWO = 4;
//@	private final int DICE_THREE = 5;
//@	private final int DICE_FOUR = 6;
//@	private final int DICE_FIVE = 7;
//@	private final int DICE_SIX = 8;
//@	
//@	public static final String BACK = "back";
//@	public static final String UPLOAD = "upload";
//@	public static final String TEST = "test";
//@	public static final String NEW = "new";
//@	public static final String SOLVE = "solve";
//@
//@	private ApoHybridString uploadString;
//@	
//@	private int[][] level = new int[16][8];
//@	
//@	private int curSelect;
//@	
//@	private Thread t;
//@	
//@	public ApoHybridEditor(ApoHybridPanel game) {
//@		super(game);
//@	}
//@
//@	@Override
//@	public void init() {
//@		this.getStringWidth().put(ApoHybridEditor.BACK, (int)(ApoHybridMenu.game_font.getLength(ApoHybridEditor.BACK)));
//@		this.getStringWidth().put(ApoHybridEditor.NEW, (int)(ApoHybridMenu.game_font.getLength(ApoHybridEditor.NEW)));
//@		this.getStringWidth().put(ApoHybridEditor.TEST, (int)(ApoHybridMenu.game_font.getLength(ApoHybridEditor.TEST)));
//@		this.getStringWidth().put(ApoHybridEditor.UPLOAD, (int)(ApoHybridMenu.game_font.getLength(ApoHybridEditor.UPLOAD)));
//@		this.getStringWidth().put(ApoHybridEditor.SOLVE, (int)(ApoHybridMenu.game_font.getLength(ApoHybridEditor.SOLVE)));
//@		
//@		String s = "Hybrid - Editor";
//@		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
//@		
//@		this.checkTestLevel();
//@	}
//@	
//@	public void setLevelSolved(boolean bSolved) {
//@		if ((!bSolved) || (!ApoHybrid.isOnline())) {
//@			this.getGame().getButtons()[9].setVisible(false);
//@		} else {
//@			this.getGame().getButtons()[9].setVisible(true);
//@		}
//@	}
//@	
//@	private void checkTestLevel() {
//@		int goals = 0;
//@		int dices = 0;
//@		for (int y = 0; y < 8; y += 1) {
//@			for (int x = 0; x < level[y].length; x += 1) {
//@				if (level[y][x] == 1) {
//@					goals += 1;
//@				}
//@				if (level[y+8][x] >= 2) {
//@					dices += 1;
//@				}
//@			}
//@		}
//@		if ((goals > 0) && (dices == goals)) {
//@			this.getGame().getButtons()[8].setVisible(true);
//@//			this.getGame().getButtons()[10].setVisible(true);
//@		} else {
//@			this.getGame().getButtons()[8].setVisible(false);
//@			this.getGame().getButtons()[9].setVisible(false);
//@			this.getGame().getButtons()[10].setVisible(false);
//@		}
//@	}
//@
//@	@Override
//@	public void touchedPressed(int x, int y, int finger) {
//@		if (y > 505) {
//@			for (int i = 0; i < 7; i++) {
//@				if ((x >= 5 + i*65) && (x < 65 + i * 65) && (y >= 510) && (y < 570)) {
//@					this.curSelect = i + 2;
//@				}
//@			}
//@			if ((x >= 5) && (x < 65) && (y >= 575) && (y < 635)) {
//@				this.curSelect = this.EMPTY;
//@			}
//@			if ((x >= 70) && (x < 130) && (y >= 575) && (y < 635)) {
//@				this.curSelect = this.GOAL;
//@			}
//@		} else {
//@			if ((y >= ApoHybridGame.changeY) && (y < 480 + ApoHybridGame.changeY)) {
//@				int newY = (y - ApoHybridGame.changeY)/60;
//@				if (this.curSelect == this.EMPTY) {
//@					level[newY][x/60] = level[newY + 8][x/60] = 0;
//@				} else if (this.curSelect == this.GOAL) {
//@					level[newY][x/60] = 1;
//@				} else if (this.curSelect == this.DICE_EMPTY) {
//@					level[newY + 8][x/60] = 2;
//@				} else if (this.curSelect == this.DICE_ONE) {
//@					level[newY + 8][x/60] = 3;
//@				} else if (this.curSelect == this.DICE_TWO) {
//@					level[newY + 8][x/60] = 4;
//@				} else if (this.curSelect == this.DICE_THREE) {
//@					level[newY + 8][x/60] = 5;
//@				} else if (this.curSelect == this.DICE_FOUR) {
//@					level[newY + 8][x/60] = 6;
//@				} else if (this.curSelect == this.DICE_FIVE) {
//@					level[newY + 8][x/60] = 7;
//@				} else if (this.curSelect == this.DICE_SIX) {
//@					level[newY + 8][x/60] = 8;
//@				}
//@				this.checkTestLevel();
//@			}
//@		}
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
//@		if (function.equals(ApoHybridEditor.BACK)) {
//@			this.onBackButtonPressed();
//@		} else if (function.equals(ApoHybridEditor.NEW)) {
//@			this.level = new int[16][8];
//@			this.checkTestLevel();
//@		} else if (function.equals(ApoHybridEditor.TEST)) {
//@			String levelString = this.getLevelString();
//@			BitsLog.d("levelString", levelString);
//@			this.getGame().setGame(-1, levelString, false);
//@		} else if (function.equals(ApoHybridEditor.UPLOAD)) {
//@			this.setLevelSolved(false);
//@			this.uploadString = new ApoHybridString(240, 470, 20, "Uploading ...", true, 200, true);
//@			
//@			Thread t = new Thread(new Runnable() {
//@				@Override
//@				public void run() {
//@					ApoHybridEditor.this.uploadString();
//@				}
//@	 		});
//@	 		t.start();
//@		} else if (function.equals(ApoHybridEditor.SOLVE)) {
//@			this.uploadString = new ApoHybridString(240, 30, 20, "Try to solve ...", true, 20000, true);
//@			this.t = new Thread(new Runnable() {
//@				@Override
//@				public void run() {
//@					solveLevel();
//@				}
//@	 		});
//@	 		this.t.start();
//@		}
//@	}
//@	
//@	private void solveLevel() {
//@		this.solve = new ApoHybridSolve();
//@		if (solve.canBeSolved(ApoHybridEditor.this.level)) {
//@			ApoHybridEditor.this.uploadString = new ApoHybridString(240, 30, 20, "Can be solved", true, 20, true);
//@			setLevelSolved(true);
//@		} else {
//@			ApoHybridEditor.this.uploadString = new ApoHybridString(240, 30, 20, "Can't be solved", true, 20, true);
//@			setLevelSolved(false);
//@		}
//@		this.solve = null;
//@	}
//@	
//@	private ApoHybridSolve solve = null;
//@	
//@	private void uploadString() {
//@		if (this.getGame().getUserlevels().addLevel(this.getLevelString())) {
//@			this.uploadString = new ApoHybridString(240, 470, 20, "Uploading successfully", true, 20, true);
//@			this.getGame().loadUserlevels();
//@		} else {
//@			this.uploadString = new ApoHybridString(240, 470, 20, "Uploading failed", true, 20, true);
//@		}
//@	}
//@	
//@	public void onBackButtonPressed() {
//@		try {
//@			if (this.solve != null) {
//@				this.solve.setBreak(true);
//@				this.solve = null;
//@			}
//@		} catch (Exception ex) {
//@		}
//@		this.getGame().setMenu();
//@	}
//@	
//@	private String getLevelString() {
//@		String level = "";
//@		for (int y = 0; y < 8; y++) {
//@			for (int x = 0; x < 8; x++) {
//@				if (this.level[y+8][x] > 1) {
//@					if (this.level[y][x] <= 0) {
//@						level += String.valueOf(this.level[y+8][x]);
//@					} else {
//@						char c = (char)(95 + this.level[y+8][x]);
//@						level += String.valueOf(c);
//@					}
//@				} else {
//@					level += String.valueOf(this.level[y][x]);
//@				}
//@			}
//@		}
//@		return level;
//@	}
//@
//@	@Override
//@	public void think(int delta) {
//@
//@		if (this.uploadString != null) {
//@			this.uploadString.think(delta);
//@			
//@			if (!this.uploadString.isVisible()) {
//@				this.uploadString = null;
//@			}
//@		}
//@	}
//@
//@	@Override
//@	public void render(BitsGraphics g) {
//@		g.setColor(128, 128, 128, 255);
//@		g.drawFilledRect(0,0,480,ApoHybridGame.changeY);
//@		g.drawFilledRect(0,480 + ApoHybridGame.changeY,480,160 - ApoHybridGame.changeY);
//@		
//@		g.setColor(0f/255f, 0f/255f, 0f/255f, 1.0f);
//@		g.drawRect(0,0,480,ApoHybridGame.changeY);
//@		g.drawRect(0,480 + ApoHybridGame.changeY,480,160 - ApoHybridGame.changeY);
//@		
//@		g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
//@		for (int y = 0; y < 8; y += 1) {
//@			g.drawLine(0, ApoHybridGame.changeY + y * 60, ApoHybridConstants.GAME_WIDTH, ApoHybridGame.changeY + y * 60);
//@			g.drawLine((y + 1) * 60, ApoHybridGame.changeY, (y + 1) * 60, ApoHybridGame.changeY + 8 * 60);
//@		}
//@		
//@		String s = "ApoHybrid - Editor";
//@		this.getGame().drawString(g, s, 240, -4, ApoHybridMenu.game_font);
//@		
//@		this.getGame().renderButtons(g, ApoHybridMenu.game_font);
//@		
//@		for (int y = 0; y < 8; y += 1) {
//@			for (int x = 0; x < level[y].length; x += 1) {
//@				if (level[y][x] == 1) {
//@					g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
//@					g.drawFilledRoundRect(x * 60 + 1, ApoHybridGame.changeY + y * 60 + 1, 58, 58, 6, 10);
//@				}
//@				if (level[y+8][x] > 0) {
//@					g.setColor(255f/255f, 255f/255f, 255f/255f, 1.0f);
//@					g.drawFilledRoundRect(x * 60 + 5, ApoHybridGame.changeY + y * 60 + 5, 50, 50, 6, 10);
//@					g.setColor(0f/255f, 0f/255f, 0f/255f, 1.0f);
//@					if ((level[y+8][x] == 3) || (level[y+8][x] == 5) || (level[y+8][x] == 7)) {
//@						g.drawFilledCircle(x * 60 + 30, ApoHybridGame.changeY + y * 60 + 30, 6, 40);
//@					}
//@					if ((level[y+8][x] == 4) || (level[y+8][x] == 5) || (level[y+8][x] == 6) || (level[y+8][x] == 7) || (level[y+8][x] == 8)) {
//@						g.drawFilledCircle(x * 60 + 14, ApoHybridGame.changeY + y * 60 + 14, 6, 40);
//@						g.drawFilledCircle(x * 60 + 46, ApoHybridGame.changeY + y * 60 + 46, 6, 40);
//@					}
//@					if ((level[y+8][x] == 6) || (level[y+8][x] == 7) || (level[y+8][x] == 8)) {
//@						g.drawFilledCircle(x * 60 + 46, ApoHybridGame.changeY + y * 60 + 14, 6, 40);
//@						g.drawFilledCircle(x * 60 + 14, ApoHybridGame.changeY + y * 60 + 46, 6, 40);
//@					}
//@					if (level[y+8][x] == 8) {
//@						g.drawFilledCircle(x * 60 + 14, ApoHybridGame.changeY + y * 60 + 30, 6, 40);
//@						g.drawFilledCircle(x * 60 + 46, ApoHybridGame.changeY + y * 60 + 30, 6, 40);
//@					}
//@				}
//@			}
//@		}
//@		
//@		if (this.uploadString != null) {
//@			this.uploadString.render(g, 0, 0);
//@		}
//@		
//@		//draw empty
//@		g.setColor(192, 192, 192, 255);
//@		g.drawFilledRoundRect(5, 575, 60, 60, 6, 10);
//@		if (this.curSelect == 0) {
//@			g.setLineSize(3f);
//@			g.setColor(255, 0, 0, 255);
//@			g.drawRoundRect(5, 575, 60, 60, 6, 10);
//@			g.setLineSize(1f);
//@		}
//@		
//@		// draw goal
//@		g.setColor(48, 48, 48, 255);
//@		g.drawFilledRoundRect(70, 575, 60, 60, 6, 10);
//@		if (this.curSelect == 1) {
//@			g.setLineSize(3f);
//@			g.setColor(255, 0, 0, 255);
//@			g.drawRoundRect(70, 575, 60, 60, 6, 10);
//@			g.setLineSize(1f);
//@		}
//@		
//@		for (int i = 0; i < 7; i++) {
//@			g.setColor(255, 255, 255, 255);
//@			g.drawFilledRoundRect(5 + i * 65, 510, 60, 60, 6, 10);
//@			if (this.curSelect == i + 2) {
//@				g.setLineSize(3f);
//@				g.setColor(255, 0, 0, 255);
//@				g.drawRoundRect(5 + i * 65, 510, 60, 60, 6, 10);
//@				g.setLineSize(1f);
//@			}
//@			g.setColor(0, 0, 0, 255);
//@			if ((i == 1) || (i == 3) || (i == 5)) {
//@				g.drawFilledCircle(5 + i * 65 + 30, 510 + 30, 6, 40);
//@			}
//@			if ((i == 2) || (i == 3) || (i == 4) || (i == 5) || (i == 6)) {
//@				g.drawFilledCircle(5 + i * 65 + 14, 510 + 14, 6, 40);
//@				g.drawFilledCircle(5 + i * 65 + 46, 510 + 46, 6, 40);
//@			}
//@			if ((i == 4) || (i == 5) || (i == 6)) {
//@				g.drawFilledCircle(5 + i * 65 + 46, 510 + 14, 6, 40);
//@				g.drawFilledCircle(5 + i * 65 + 14, 510 + 46, 6, 40);
//@			}
//@			if (i == 6) {
//@				g.drawFilledCircle(5 + i * 65 + 46, 510 + 30, 6, 40);
//@				g.drawFilledCircle(5 + i * 65 + 14, 510 + 30, 6, 40);
//@			}
//@		}
//@	}
//@
//@}
//@
//#elif SnakeGameLogic
//@
//@import net.apogames.apohybrid.ApoHybrid;
//@import net.apogames.apohybrid.ApoHybridModel;
//@import net.apogames.apohybrid.entity.ApoHybridString;
//@
//@import net.gliblybits.bitsengine.render.BitsGraphics;
//@import net.gliblybits.bitsengine.utils.BitsLog;
//@
//@public class ApoHybridEditor extends ApoHybridModel {
//@
//@	private final int EMPTY = 0;
//@	private final int RED_SNAKE = 1;
//@	private final int RED_WALL = 2;
//@	private final int RED_COIN = 3;
//@	private final int BLUE_SNAKE = 4;
//@	private final int BLUE_WALL = 5;
//@	private final int BLUE_COIN = 6;
//@	private final int GREEN_SNAKE = 7;
//@	private final int GREEN_WALL = 8;
//@	private final int GREEN_COIN = 9;
//@	
//@	public static final String BACK = "back";
//@	public static final String UPLOAD = "upload";
//@	public static final String TEST = "test";
//@	public static final String XPLUS = "+";
//@	public static final String XMINUS = "-";
//@	public static final String YPLUS = " + ";
//@	public static final String YMINUS = " - ";
//@
//@	private ApoHybridString uploadString;
//@	
//@	private int[][] level = null;
//@	
//@	private int curSelect;
//@	
//@	public ApoHybridEditor(ApoHybridPanel game) {
//@		super(game);
//@	}
//@
//@	@Override
//@	public void init() {
//@		this.getStringWidth().put(ApoHybridEditor.BACK, (int)(ApoHybridMenu.game_font.getLength(ApoHybridEditor.BACK)));
//@		this.getStringWidth().put(ApoHybridEditor.TEST, (int)(ApoHybridMenu.game_font.getLength(ApoHybridEditor.TEST)));
//@		this.getStringWidth().put(ApoHybridEditor.UPLOAD, (int)(ApoHybridMenu.game_font.getLength(ApoHybridEditor.UPLOAD)));
//@		this.getStringWidth().put(ApoHybridEditor.XMINUS, (int)(ApoHybridMenu.game_font.getLength(ApoHybridEditor.XMINUS)));
//@		this.getStringWidth().put(ApoHybridEditor.XPLUS, (int)(ApoHybridMenu.game_font.getLength(ApoHybridEditor.XPLUS)));
//@		this.getStringWidth().put(ApoHybridEditor.YMINUS, (int)(ApoHybridMenu.game_font.getLength(ApoHybridEditor.YMINUS)));
//@		this.getStringWidth().put(ApoHybridEditor.YPLUS, (int)(ApoHybridMenu.game_font.getLength(ApoHybridEditor.YPLUS)));
//@		
//@		String s = "ApoHybrid - Editor";
//@		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
//@		
//@		if (this.level == null) {
//@			this.makeLevel();
//@		}
//@		
//@		this.checkTestLevel();
//@	}
//@	
//@	private void makeLevel() {
//@		this.level = new int[][] {
//@				{6,6,6,5,0},
//@				{6,3,6,6,0},
//@				{6,0,0,6,0},
//@				{6,6,0,0,0}
//@		};
//@	}
//@	
//@	public void setLevelSolved(boolean bSolved) {
//@		if ((!bSolved) || (!ApoHybrid.isOnline())) {
//@			this.getGame().getButtons()[8].setVisible(false);
//@		} else {
//@			this.getGame().getButtons()[8].setVisible(true);
//@		}
//@	}
//@	
//@	private void checkTestLevel() {
//@		int snakes = 0;
//@		int coins = 0;
//@		for (int y = 0; y < this.level.length; y += 1) {
//@			for (int x = 0; x < this.level[y].length; x += 1) {
//@				if ((this.level[y][x] >= 1) && (this.level[y][x] <= 4)) {
//@					snakes += 1;
//@				}
//@				if ((this.level[y][x] >= 7) && (this.level[y][x] <= 10)) {
//@					snakes += 1;
//@				}
//@				if ((this.level[y][x] >= 13) && (this.level[y][x] <= 16)) {
//@					snakes += 1;
//@				}
//@				if ((this.level[y][x] == 5) || (this.level[y][x] == 11) || (this.level[y][x] == 17)) {
//@					coins += 1;
//@				}
//@			}
//@		}
//@		if ((snakes > 0) && (coins > 0)) {
//@			this.getGame().getButtons()[7].setVisible(true);
//@		} else {
//@			this.getGame().getButtons()[7].setVisible(false);
//@			this.getGame().getButtons()[8].setVisible(false);
//@		}
//@	}
//@
//@	@Override
//@	public void touchedPressed(int x, int y, int finger) {
//@		if (y > 505) {
//@			for (int i = 0; i <= this.GREEN_COIN; i++) {
//@				if ((x >= 5 + i * 47) && (x < 45 + i * 47) && (y >= 520) && (y < 560)) {
//@					this.curSelect = i;
//@				}
//@			}
//@		} else {
//@			int changeX = (480 - level[0].length * 30)/2;
//@			int changeY = (480 - level.length * 30)/2 + ApoHybridGame.changeY;
//@			
//@			if ((y >= changeY) && (y < changeY + level.length * 30) &&
//@				(x >= changeX) && (x < changeX + level[0].length * 30)) {
//@				int newY = (y - changeY)/30;
//@				int newX = (x - changeX)/30;
//@				if (this.curSelect == this.EMPTY) {
//@					level[newY][newX] = 0;
//@				} else if (this.curSelect == this.RED_SNAKE) {
//@					if ((level[newY][newX] >= 1) && (level[newY][newX] <= 4)) {
//@						level[newY][newX] += 1;
//@						if (level[newY][newX] > 4) {
//@							level[newY][newX] = 1;
//@						}
//@					} else {
//@						level[newY][newX] = 1;
//@					}
//@				} else if (this.curSelect == this.RED_COIN) {
//@					level[newY][newX] = 5;
//@				} else if (this.curSelect == this.RED_WALL) {
//@					level[newY][newX] = 6;
//@				} else if (this.curSelect == this.BLUE_SNAKE) {
//@					if ((level[newY][newX] >= 7) && (level[newY][newX] <= 10)) {
//@						level[newY][newX] += 1;
//@						if (level[newY][newX] > 10) {
//@							level[newY][newX] = 7;
//@						}
//@					} else {
//@						level[newY][newX] = 7;
//@					}
//@				} else if (this.curSelect == this.BLUE_COIN) {
//@					level[newY][newX] = 11;
//@				} else if (this.curSelect == this.BLUE_WALL) {
//@					level[newY][newX] = 12;
//@				} else if (this.curSelect == this.GREEN_SNAKE) {
//@					if ((level[newY][newX] >= 13) && (level[newY][newX] <= 16)) {
//@						level[newY][newX] += 1;
//@						if (level[newY][newX] > 16) {
//@							level[newY][newX] = 13;
//@						}
//@					} else {
//@						level[newY][newX] = 13;
//@					}
//@				} else if (this.curSelect == this.GREEN_COIN) {
//@					level[newY][newX] = 17;
//@				} else if (this.curSelect == this.GREEN_WALL) {
//@					level[newY][newX] = 18;
//@				}
//@				this.checkTestLevel();
//@			}
//@		}
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
//@		if (function.equals(ApoHybridEditor.BACK)) {
//@			this.onBackButtonPressed();
//@		} else if (function.equals(ApoHybridEditor.TEST)) {
//@			String levelString = this.getLevelString();
//@			BitsLog.d("levelString", levelString);
//@			this.getGame().setGame(-1, levelString, false);
//@		} else if (function.equals(ApoHybridEditor.UPLOAD)) {
//@			this.setLevelSolved(false);
//@			this.uploadString = new ApoHybridString(240, 470, 20, "Uploading ...", true, 200, true);
//@			
//@			Thread t = new Thread(new Runnable() {
//@
//@				public void run() {
//@					ApoHybridEditor.this.uploadString();
//@				}
//@	 		});
//@	 		t.start();
//@		} else if (function.equals(ApoHybridEditor.XMINUS)) {
//@			if (this.level[0].length - 1 >= 3) {
//@				this.newLevelSize(this.level[0].length - 1, this.level.length);
//@			}
//@		} else if (function.equals(ApoHybridEditor.XPLUS)) {
//@			if (this.level[0].length + 1 <= 14) {
//@				this.newLevelSize(this.level[0].length + 1, this.level.length);
//@			}
//@		} else if (function.equals(ApoHybridEditor.YMINUS)) {
//@			if (this.level.length - 1 >= 3) {
//@				this.newLevelSize(this.level[0].length, this.level.length - 1);
//@			}
//@		} else if (function.equals(ApoHybridEditor.YPLUS)) {
//@			if (this.level.length + 1 <= 14) {
//@				this.newLevelSize(this.level[0].length, this.level.length + 1);
//@			}
//@		}
//@	}
//@	
//@	private void newLevelSize(int newWidth, int newHeight) {
//@		int[][] newLevel = new int[newHeight][newWidth];
//@		for (int y = 0; y < newHeight && y < level.length; y++) {
//@			for (int x = 0; x < newWidth && x < level[y].length; x++) {
//@				newLevel[y][x] = this.level[y][x];
//@			}
//@		}
//@		this.level = newLevel;
//@		this.checkTestLevel();
//@	}
//@	
//@	private void uploadString() {
//@		if (this.getGame().getUserlevels().addLevel(this.getLevelString())) {
//@			this.uploadString = new ApoHybridString(240, 470, 20, "Uploading successfully", true, 20, true);
//@			this.getGame().loadUserlevels();
//@		} else {
//@			this.uploadString = new ApoHybridString(240, 470, 20, "Uploading failed", true, 20, true);
//@		}
//@	}
//@	
//@	public void onBackButtonPressed() {
//@		this.getGame().setMenu();
//@	}
//@	
//@	private String getLevelString() {
//@		String level = "";
//@		char c = (char)(this.level[0].length + 96);
//@		level += String.valueOf(c);
//@		c = (char)(this.level.length + 96);
//@		level += String.valueOf(c);
//@		for (int y = 0; y < this.level.length; y++) {
//@			for (int x = 0; x < this.level[0].length; x++) {
//@				if (this.level[y][x] >= 10) {
//@					c = (char)(87 + this.level[y][x]);
//@					level += String.valueOf(c);
//@				} else {
//@					level += String.valueOf(this.level[y][x]);
//@				}
//@			}
//@		}
//@		return level;
//@	}
//@
//@	@Override
//@	public void think(int delta) {
//@
//@		if (this.uploadString != null) {
//@			this.uploadString.think(delta);
//@			
//@			if (!this.uploadString.isVisible()) {
//@				this.uploadString = null;
//@			}
//@		}
//@	}
//@
//@	@Override
//@	public void render(BitsGraphics g) {
//@		g.setColor(128, 128, 128, 255);
//@		g.drawFilledRect(0,0,480,ApoHybridGame.changeY);
//@		g.drawFilledRect(0,480 + ApoHybridGame.changeY,480,160 - ApoHybridGame.changeY);
//@		
//@		g.setColor(0f/255f, 0f/255f, 0f/255f, 1.0f);
//@		g.drawRect(0,0,480,ApoHybridGame.changeY);
//@		g.drawRect(0,480 + ApoHybridGame.changeY,480,160 - ApoHybridGame.changeY);
//@		
//@		String s = "ApoHybrid - Editor";
//@		this.getGame().drawString(g, s, 240, -4, ApoHybridMenu.game_font);
//@		
//@		this.getGame().renderButtons(g, ApoHybridMenu.game_font);
//@		
//@		int changeX = (480 - level[0].length * 30)/2;
//@		int changeY = (480 - level.length * 30)/2 + ApoHybridGame.changeY;
//@		g.setColor(0, 0, 0, 255);
//@		g.drawRect(changeX, changeY, level[0].length * 30, level.length * 30);
//@
//@		for (int y = 0; y < level.length; y++) {
//@			for (int x = 0; x < level[0].length; x++) {
//@				g.setColor(0, 0, 0, 255);
//@				g.drawRect(changeX + x * 30, changeY + y * 30, 30, 30);
//@				if ((level[y][x] == 5) || (level[y][x] == 11) || (level[y][x] == 17)) {
//@					g.setColor(255, 0, 0);
//@					if (level[y][x] == 11) {
//@						g.setColor(0, 120, 255);							
//@					} else if (level[y][x] == 17) {
//@						g.setColor(0, 255, 0);							
//@					}
//@					g.drawFilledOval(changeX + 15 + x * 30, changeY + 15 + y * 30, 5, 5);
//@					g.setColor(0, 0, 0, 255);
//@					g.drawOval(changeX + 15 + x * 30, changeY + 15 + y * 30, 5, 5);
//@				}
//@				if ((level[y][x] == 6) || (level[y][x] == 12) || (level[y][x] == 18)) {
//@					if (level[y][x] == 6) {
//@						this.drawWall(g, x, y, changeX, changeY, 0);
//@					} else if (level[y][x] == 12) {
//@						this.drawWall(g, x, y, changeX, changeY, 1);
//@					} else {
//@						this.drawWall(g, x, y, changeX, changeY, 2);
//@					}
//@				}
//@				if ((level[y][x] == 19) || (level[y][x] == 20) || (level[y][x] == 21)) {
//@					int[] c = new int[] {255, 45, 45};
//@					if (level[y][x] == 20) {
//@						c = new int[] {45, 165, 255};
//@					}
//@					if (level[y][x] == 21) {
//@						c = new int[] {45, 255, 45};
//@					}
//@					g.setColor(c[0], c[1], c[2], 255);
//@					g.drawFilledOval(changeX + x * 30 + 15, changeY + y * 30 + 15, 12, 12);
//@					g.setColor(0, 0, 0, 255);
//@					g.drawOval(changeX + x * 30 + 15, changeY + y * 30 + 15, 12, 12);
//@				}
//@				if ((level[y][x] >= 1) && (level[y][x] <= 4)) {
//@					g.setColor(255, 0, 0);
//@					this.drawSnakeEyes(g, x, y, changeX, changeY, level[y][x]);
//@				} else if ((level[y][x] >= 7) && (level[y][x] <= 10)) {
//@					g.setColor(0, 90, 255);
//@					this.drawSnakeEyes(g, x, y, changeX, changeY, level[y][x] - 6);
//@				} else if ((level[y][x] >= 13) && (level[y][x] <= 16)) {
//@					g.setColor(0, 255, 0);
//@					this.drawSnakeEyes(g, x, y, changeX, changeY, level[y][x] - 12);
//@				}
//@			}
//@		}
//@		
//@		if (this.uploadString != null) {
//@			this.uploadString.render(g, 0, 0);
//@		}
//@		
//@		this.getGame().drawString(g, String.valueOf(this.level[0].length), 46, 595, ApoHybridMenu.game_font);
//@		this.getGame().drawString(g, String.valueOf(this.level.length), 161, 595, ApoHybridMenu.game_font);
//@		
//@		g.setLineSize(3f);
//@		g.setColor(255, 0, 0, 255);
//@		g.drawRoundRect(5 + this.curSelect * 47, 520, 40, 40, 6, 10);
//@		g.setLineSize(1f);
//@		
//@		//draw empty
//@		g.setColor(192, 192, 192, 255);
//@		g.drawFilledRoundRect(10, 525, 30, 30, 6, 10);
//@		
//@		for (int i = 1; i <= this.GREEN_COIN; i++) {
//@			if (i == this.RED_SNAKE) {
//@				g.setColor(255, 0, 0, 255);
//@				this.drawSnakeEyes(g, 0, 0, 10 + i * 47, 525, 2);
//@			} else if (i == this.BLUE_SNAKE) {
//@				g.setColor(0, 90, 255, 255);
//@				this.drawSnakeEyes(g, 0, 0, 10 + i * 47, 525, 2);
//@			} else if (i == this.GREEN_SNAKE) {
//@				g.setColor(0, 255, 0, 255);
//@				this.drawSnakeEyes(g, 0, 0, 10 + i * 47, 525, 2);
//@			}
//@			if (i == this.RED_COIN) {
//@				g.setColor(255, 0, 0, 255);
//@				g.drawFilledOval(10 + i * 47 + 15, 525 + 15, 5, 5);
//@				g.setColor(0, 0, 0, 255);
//@				g.drawOval(10 + i * 47 + 15, 525 + 15, 5, 5);
//@			} else if (i == this.BLUE_COIN) {
//@				g.setColor(0, 90, 255, 255);
//@				g.drawFilledOval(10 + i * 47 + 15, 525 + 15, 5, 5);
//@				g.setColor(0, 0, 0, 255);
//@				g.drawOval(10 + i * 47 + 15, 525 + 15, 5, 5);
//@			} else if (i == this.GREEN_COIN) {
//@				g.setColor(0, 255, 0, 255);
//@				g.drawFilledOval(10 + i * 47 + 15, 525 + 15, 5, 5);
//@				g.setColor(0, 0, 0, 255);
//@				g.drawOval(10 + i * 47 + 15, 525 + 15, 5, 5);
//@			}
//@			if (i == this.RED_WALL) {
//@				this.drawWall(g, 0, 0, 10 + i * 47, 525, 0);
//@			} else if (i == this.BLUE_WALL) {
//@				this.drawWall(g, 0, 0, 10 + i * 47, 525, 1);
//@			} else if (i == this.GREEN_WALL) {
//@				this.drawWall(g, 0, 0, 10 + i * 47, 525, 2);
//@			}
//@		}
//@
//@	}
//@	
//@	private void drawWall(BitsGraphics g, int x, int y, int changeX, int changeY, int value) {
//@		g.setColor(200, 0, 0);
//@		if (value == 1) {
//@			g.setColor(90, 165, 200);
//@		} else if (value == 2) {
//@			g.setColor(0, 200, 0);							
//@		}
//@		g.drawFilledRect(changeX + 4 + x * 30, changeY + 4 + y * 30, 22, 22);
//@		g.setColor(150, 0, 0);
//@		if (value == 1) {
//@			g.setColor(0, 90, 200);
//@		} else if (value == 2) {
//@			g.setColor(0, 150, 0);							
//@		}
//@		g.drawFilledRect(changeX + 8 + x * 30, changeY + 8 + y * 30, 15, 15);
//@		g.setColor(0, 0, 0, 255);
//@		g.drawRect(changeX + 4 + x * 30, changeY + 4 + y * 30, 22, 22);
//@	}
//@	
//@	private void drawSnakeEyes(BitsGraphics g, int x, int y, int changeX, int changeY, int value) {
//@		g.drawFilledOval(changeX + x * 30 + 15, changeY + y * 30 + 15, 12, 12);
//@
//@		g.setColor(0, 0, 0, 255);
//@		g.drawOval(changeX + x * 30 + 15, changeY + y * 30 + 15, 12, 12);
//@		
//@		if (value == 1) {
//@			g.drawFilledRect(changeX + x * 30 + 2, changeY + y * 30 + 11, 9, 3);
//@			g.drawFilledRect(changeX + x * 30 + 2, changeY + y * 30 + 16, 9, 3);
//@		} else if (value == 3) {
//@			g.drawFilledRect(changeX + (x + 1) * 30 - 11, changeY + y * 30 + 11, 9, 3);
//@			g.drawFilledRect(changeX + (x + 1) * 30 - 11, changeY + y * 30 + 16, 9, 3);
//@		} else if (value == 2) {
//@			g.drawFilledRect(changeX + (x) * 30 + 11, changeY + (y + 1) * 30 - 11, 3, 9);
//@			g.drawFilledRect(changeX + (x) * 30 + 16, changeY + (y + 1) * 30 - 11, 3, 9);
//@		} else if (value == 4) {
//@			g.drawFilledRect(changeX + (x) * 30 + 11, changeY + (y) * 30 + 2, 3, 9);
//@			g.drawFilledRect(changeX + (x) * 30 + 16, changeY + (y) * 30 + 2, 3, 9);
//@		}
//@	}
//@
//@}
//@
//#elif ClockGameLogic
//@
//@import java.util.ArrayList;
//@
//@import net.apogames.apohybrid.ApoHybrid;
//@import net.apogames.apohybrid.ApoHybridConstants;
//@import net.apogames.apohybrid.ApoHybridModel;
//@import net.apogames.apohybrid.editor.ApoHybridEditorClockStats;
//@import net.apogames.apohybrid.entity.ApoHybridEntityBall;
//@import net.apogames.apohybrid.entity.ApoHybridEntityClock;
//@import net.apogames.apohybrid.entity.ApoHybridString;
//@
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//@import net.gliblybits.bitsengine.utils.BitsLog;
//@
//@public class ApoHybridEditor extends ApoHybridModel {
//@
//@	public static final String BACK = "back";
//@	public static final String ADD = "add";
//@	public static final String REMOVE = "remove";
//@	public static final String NEW = "new";
//@	public static final String UPLOAD = "upload";
//@	public static final String TEST = "test";
//@	
//@	private ArrayList<ApoHybridEntityClock> clocks;
//@	
//@	private ApoHybridEditorClockStats clockStats;
//@	
//@	private ApoHybridString uploadString;
//@	
//@	private final ApoHybridEntityBall ball = new ApoHybridEntityBall(5, 260, 5, 90, 0.2f);
//@	
//@	private boolean bCanDragged;
//@	
//@	public ApoHybridEditor(ApoHybridPanel game) {
//@		super(game);
//@	}
//@
//@	@Override
//@	public void init() {
//@		if (this.clocks == null) {
//@			this.clocks = new ArrayList<ApoHybridEntityClock>();
//@		}
//@		
//@		this.getStringWidth().put(ApoHybridEditor.BACK, (int)(ApoHybridPanel.game_font.getLength(ApoHybridEditor.BACK)));
//@		this.getStringWidth().put(ApoHybridEditor.ADD, (int)(ApoHybridPanel.game_font.getLength(ApoHybridEditor.ADD)));
//@		this.getStringWidth().put(ApoHybridEditor.REMOVE, (int)(ApoHybridPanel.game_font.getLength(ApoHybridEditor.REMOVE)));
//@		this.getStringWidth().put(ApoHybridEditor.NEW, (int)(ApoHybridPanel.game_font.getLength(ApoHybridEditor.NEW)));
//@		this.getStringWidth().put(ApoHybridEditor.UPLOAD, (int)(ApoHybridPanel.game_font.getLength(ApoHybridEditor.UPLOAD)));
//@		this.getStringWidth().put(ApoHybridEditor.TEST, (int)(ApoHybridPanel.game_font.getLength(ApoHybridEditor.TEST)));
//@		
//@		String s = "ApoHybrid - Editor";
//@		this.getStringWidth().put(s, (int) ApoHybridPanel.game_font.getLength(s));
//@		
//@		this.checkTestLevel();
//@	}
//@	
//@	public void setLevelSolved(boolean bSolved) {
//@		if ((!bSolved) || (!ApoHybrid.isOnline())) {
//@			this.getGame().getButtons()[13].setVisible(false);
//@		}
//@	}
//@	
//@	private void checkTestLevel() {
//@		if (this.clocks.size() < 2) {
//@			this.getGame().getButtons()[14].setVisible(false);
//@		} else {
//@			this.getGame().getButtons()[14].setVisible(true);
//@		}
//@	}
//@
//@	@Override
//@	public void touchedPressed(int x, int y, int finger) {
//@		this.bCanDragged = false;
//@		if (this.clockStats != null) {
//@			if (this.clockStats.contains(x, y)) {
//@				if (this.clockStats.touchedPressed(x, y, finger)) {
//@					this.setLevelSolved(false);
//@				}
//@				return;
//@			}
//@		}
//@		boolean bBreak = false;
//@		for (int i = 0; i < this.clocks.size(); i++) {
//@			if (this.clocks.get(i).intersects(x, y, 1)) {
//@				if (this.clockStats != null) {
//@					this.clockStats.getClock().setSelected(false);
//@				}
//@				this.bCanDragged = true;
//@				this.clockStats = new ApoHybridEditorClockStats(this.clocks.get(i));
//@				bBreak = true;
//@				break;
//@			}
//@		}
//@		if (!bBreak) {
//@			if (this.clockStats != null) {
//@				this.clockStats.getClock().setSelected(false);
//@			}
//@			this.clockStats = null;
//@		}
//@	}
//@
//@	@Override
//@	public void touchedReleased(int x, int y, int finger) {
//@		this.bCanDragged = false;
//@	}
//@
//@	@Override
//@	public void touchedDragged(int x, int y, int oldX, int oldY, int finger) {
//@		if ((this.clockStats != null) && (this.bCanDragged)) {
//@			int changeX = x - oldX;
//@			int changeY = y - oldY;
//@			int newX = (int)(this.clockStats.getClock().getX() + changeX);
//@			if (newX - this.clockStats.getClock().getRadius() < 0) {
//@				newX = (int)(this.clockStats.getClock().getRadius());
//@			} else if (newX + this.clockStats.getClock().getRadius() >= ApoHybridConstants.GAME_WIDTH) {
//@				newX = ApoHybridConstants.GAME_WIDTH - (int)(this.clockStats.getClock().getRadius());
//@			}
//@			
//@			int newY = (int)(this.clockStats.getClock().getY() + changeY);
//@			if (newY - this.clockStats.getClock().getRadius() < 25) {
//@				newY = (int)(this.clockStats.getClock().getRadius()) + 25;
//@			} else if (newY + this.clockStats.getClock().getRadius() >= 590) {
//@				newY = 590 - (int)(this.clockStats.getClock().getRadius());
//@			}
//@			this.clockStats.getClock().setX(newX);
//@			this.clockStats.getClock().setY(newY);
//@		}
//@	}
//@	
//@	@Override
//@	public void touchedButton(String function) {
//@		if (function.equals(ApoHybridEditor.ADD)) {
//@			if (this.clockStats != null) {
//@				this.clockStats.getClock().setSelected(false);
//@			}
//@			this.setLevelSolved(false);
//@			this.clockStats = null;
//@			ApoHybridEntityClock clock = new ApoHybridEntityClock(240, 260, 40, (int)(Math.random() * 360), (int)(Math.random() * 10 + 4));
//@			if (Math.random() * 100 > 50) {
//@				clock.setRotateClockwise(false);
//@			}
//@			this.clocks.add(clock);
//@			this.checkTestLevel();
//@		} else if (function.equals(ApoHybridEditor.BACK)) {
//@			this.onBackButtonPressed();
//@		} else if (function.equals(ApoHybridEditor.NEW)) {
//@			if (this.clockStats != null) {
//@				this.clockStats.getClock().setSelected(false);
//@			}
//@			this.setLevelSolved(false);
//@			this.clockStats = null;
//@			this.clocks.clear();
//@			this.checkTestLevel();
//@		} else if (function.equals(ApoHybridEditor.REMOVE)) {
//@			if (this.clockStats != null) {
//@				this.clocks.remove(this.clockStats.getClock());
//@				this.clockStats = null;
//@			}
//@			this.setLevelSolved(false);
//@			this.checkTestLevel();
//@		} else if (function.equals(ApoHybridEditor.TEST)) {
//@			String levelString = this.getLevelString();
//@			BitsLog.d("levelString", levelString);
//@			this.getGame().setGame(-1, levelString, false);
//@		} else if (function.equals(ApoHybridEditor.UPLOAD)) {
//@			this.setLevelSolved(false);
//@			this.uploadString = new ApoHybridString(240, 550, 20, "Uploading ...", true, 200, true);
//@			
//@			Thread t = new Thread(new Runnable() {
//@				@Override
//@				public void run() {
//@					ApoHybridEditor.this.uploadString();
//@				}
//@	 		});
//@	 		t.start();
//@		}
//@	}
//@	
//@	private void uploadString() {
//@		if (this.getGame().getUserlevels().addLevel(this.getLevelString())) {
//@			this.uploadString = new ApoHybridString(240, 550, 20, "Uploading successfully", true, 20, true);
//@			this.getGame().loadUserlevels();
//@		} else {
//@			this.uploadString = new ApoHybridString(240, 550, 20, "Uploading failed", true, 20, true);
//@		}
//@	}
//@	
//@	public void onBackButtonPressed() {
//@		this.getGame().setPuzzle();
//@	}
//@	
//@	private String getLevelString() {
//@		String level = "";
//@		for (int i = 0; i < this.clocks.size(); i++) {
//@			level += this.clocks.get(i).getStringForLevel();
//@			if (i + 1 < this.clocks.size()) {
//@				level += ",";
//@			}
//@		}
//@		return level;
//@	}
//@
//@	@Override
//@	public void think(int delta) {
//@		if (this.clockStats != null) {
//@			this.clockStats.think(delta);
//@		}
//@		if (this.uploadString != null) {
//@			this.uploadString.think(delta);
//@			
//@			if (!this.uploadString.isVisible()) {
//@				this.uploadString = null;
//@			}
//@		}
//@	}
//@
//@	@Override
//@	public void render(BitsGLGraphics g) {
//@		g.setColor(128f/255f, 128f/255f, 128f/255f, 1.0f);
//@		g.fillRect(0,0,480,25);
//@		g.fillRect(0,590,480,50);
//@		
//@		g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
//@		g.drawRect(0,0,480,25);
//@		g.drawRect(0,590,480,50);
//@		
//@		String s = "ApoHybrid - Editor";
//@		this.getGame().drawString(g, s, 240, -4, ApoHybridPanel.game_font);
//@		
//@		for (int i = 0; i < this.clocks.size(); i++) {
//@			this.clocks.get(i).render(g);
//@		}
//@		this.ball.render(g);
//@		
//@		this.getGame().renderButtons(g, ApoHybridPanel.game_font);
//@		
//@		if (this.clockStats != null) {
//@			this.clockStats.render(g);
//@		}
//@		
//@		if (this.uploadString != null) {
//@			this.uploadString.render(g, 0, 0);
//@		}
//@	}
//@
//@}
//#elif MonoGameLogic
//@
//@import net.apogames.apohybrid.ApoHybridConstants;
//@import net.apogames.apohybrid.ApoHybridModel;
//@import net.apogames.apohybrid.ApoHybridSoundPlayer;
//@import net.apogames.apohybrid.entity.ApoHybridString;
//@import net.gliblybits.bitsengine.graphics.BitsGraphics;
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//@
//@public class ApoHybridEditor extends ApoHybridModel {
//@
//@	public static final String BACK = "back";
//@	public static final String UPLOAD = "upload";
//@	public static final String TEST = "test";
//@	public static final String NEW = "new";
//@	
//@	/*
//@	 * p[0] == aktuelles Level
//@	 * p[1] == mirrorcount horizontal
//@	 * p[2] == aktuelles Level geschafft klick
//@	 * p[3] == mirrortime
//@	 * p[4] == time
//@	 * p[5] == x Wert touch
//@	 * p[6] == y Wert touch
//@	 * p[7] == mirrorcount vertical
//@	 * p[8] == gravitychangecount
//@	 */
//@	private final int[] p = new int[9];
//@	
//@	private int[][] level = new int[1][1];
//@	
//@	private int curSelected;
//@	
//@	private ApoHybridString monoString;
//@
//@	private int frameGoal, frameTimeGoal;
//@	private float frameGravity, frameGravityAdd, frameGravityTime;
//@	
//@	private boolean bMenu;
//@	
//@	private int beamerFrame, beamerFrameTime;
//@	
//@	public ApoHybridEditor(ApoHybridPanel game) {
//@		super(game);
//@	}
//@
//@	@Override
//@	public void init() {
//@		if (level.length <= 1) {
//@			this.newLevel();
//@			this.curSelected = 0;
//@			this.frameGravityAdd = 1;
//@		}
//@		this.canBeTested();
//@		this.bMenu = false;
//@	}
//@	
//@	public void setUploadVisible(final boolean bVisible) {
//@		this.getGame().getButtons()[7].setVisible(bVisible);
//@	}
//@	
//@	@Override
//@	public void touchedPressed(int x, int y, int finger) {
//@		p[5] = x;
//@		p[6] = y;
//@	}
//@
//@	@Override
//@	public void touchedReleased(int x, int y, int finger) {
//@		p[5] = -1;
//@		p[6] = -1;
//@	}
//@
//@	@Override
//@	public void touchedDragged(int x, int y, int oldX, int oldY, int finger) {
//@		if (p[5] > 0) {
//@			p[5] = x;
//@			p[6] = y;
//@		}
//@	}
//@
//@	@Override
//@	public void touchedButton(String function) {
//@		if (function.equals(ApoHybridEditor.BACK)) {
//@			this.onBackButtonPressed();
//@		} else if (function.equals(ApoHybridEditor.NEW)) {
//@			this.newLevel();
//@		} else if (function.equals(ApoHybridEditor.TEST)) {
//@			this.testLevel();
//@		} else if (function.equals(ApoHybridEditor.UPLOAD)) {
//@			this.uploadLevel();
//@		}
//@		this.getGame().playSound(ApoHybridSoundPlayer.SOUND_BUTTON);
//@	}
//@	
//@	private boolean canBeTested() {
//@		int goal = 0;
//@		int player = 0;
//@		int beamer = 0;
//@		for (int y = 0; y < this.level.length; y++) {
//@			for (int x = 0; x < this.level[0].length; x++) {
//@				if (this.level[y][x] == 2) {
//@					player += 1;
//@				}
//@				if (this.level[y][x] == 3) {
//@					goal += 1;
//@				}
//@				if (this.level[y][x] == 11) {
//@					beamer += 1;
//@				}
//@			}
//@		}
//@		if ((player == 1) && (goal == 1) && ((beamer == 0) || (beamer == 2))) {
//@			this.getGame().getButtons()[5].setVisible(true);
//@			return true;
//@		}
//@		this.getGame().getButtons()[5].setVisible(false);
//@		this.setUploadVisible(false);
//@		return false;
//@	}
//@	
//@	public String getLevelString() {
//@		String levelString = String.valueOf(p[1]) + String.valueOf(p[7]) + String.valueOf(p[8]);
//@		for (int y = 0; y < this.level.length; y++) {
//@			for (int x = 1; x < this.level[y].length - 1; x++) {
//@				if (this.level[y][x] > 9) {
//@					levelString += "" + (char)(this.level[y][x] + 87);
//@				} else {
//@					levelString += "" + this.level[y][x];
//@				}
//@			}
//@		}
//@		return levelString;
//@	}
//@	
//@	private void testLevel() {
//@		this.getGame().setGame(0, this.getLevelString(), false);
//@	}
//@	
//@	private void uploadLevel() {
//@		this.setUploadVisible(false);
//@		this.monoString = new ApoHybridString(240, ApoHybridGame.changeY + 200, 20, "Uploading ...", true, 200, true);
//@		
//@		Thread t = new Thread(new Runnable() {
//@
//@			public void run() {
//@				ApoHybridEditor.this.uploadString();
//@			}
//@ 		});
//@ 		t.start();
//@	}
//@	
//@	private void uploadString() {
//@		String s = this.getLevelString();
//@		if (this.getGame().getUserlevels().addLevel(s)) {
//@			this.monoString = new ApoHybridString(240, ApoHybridGame.changeY + 200, 20, "Upload successful", true, 20, true);
//@			this.getGame().loadUserlevels();
//@		} else {
//@			this.monoString = new ApoHybridString(240, ApoHybridGame.changeY + 200, 20, "Upload failed", true, 20, true);
//@		}
//@	}
//@	
//@	public void onKeyDown(final int key) {
//@		
//@	}
//@
//@	public void onKeyUp(final int key) {
//@		
//@	}
//@	
//@	public void onBackButtonPressed() {
//@		this.getGame().setMenu();
//@	}
//@	
//@	private void newLevel() {
//@		level = new int[15][30];
//@		p[1] = p[5] = p[6] = p[7] = p[8] = 0;
//@		for (int y = 0; y < level.length; y++) {
//@			level[y][0] = 0;
//@			level[y][level[0].length - 1] = 0;
//@			if (y == 14) {
//@				for (int x = 1; x < level[0].length - 1; x++) {
//@					level[y][x] = 1;
//@				}
//@			}
//@		}
//@		level[13][2] = 2;
//@		level[13][27] = 3;
//@		this.canBeTested();
//@		this.setUploadVisible(false);
//@	}
//@
//@	@Override
//@	public void think(int delta) {
//@		this.beamerFrameTime += delta;
//@		if (this.beamerFrameTime >= ApoHybridGame.BEAMER_CHANGE_TIME) {
//@			this.beamerFrameTime -= ApoHybridGame.BEAMER_CHANGE_TIME;
//@			this.beamerFrame += 1;
//@			if (this.beamerFrame > 3) {
//@				this.beamerFrame = 0;
//@			}
//@		}
//@		if (this.frameGravityTime > 0) {
//@			this.frameGravityTime -= delta;
//@		} else {
//@			this.frameGravity += 0.1f * this.frameGravityAdd;
//@			if ((this.frameGravity > 16) || (this.frameGravity < 0)) {
//@				this.frameGravityAdd = -this.frameGravityAdd;
//@				this.frameGravityTime = ApoHybridGame.FRAME_GRAVITY_TIME;
//@			}
//@		}
//@		
//@		this.frameTimeGoal += delta;
//@		if (this.frameTimeGoal > ApoHybridGame.FRAME_TIME) {
//@			this.frameTimeGoal -= ApoHybridGame.FRAME_TIME;
//@			this.frameGoal += 1;
//@			if (this.frameGoal > 3) {
//@				this.frameGoal = 0;
//@			}
//@		}
//@		
//@		if (this.monoString != null) {
//@			this.monoString.think(delta);
//@			
//@			if (!this.monoString.isVisible()) {
//@				this.monoString = null;
//@			}
//@		}
//@		
//@		if (level[0][0] == -1) {
//@			this.newLevel();
//@		} else if (p[5] > 0) {
//@			if (this.bMenu) {
//@				if ((p[5] < 170) || (p[5] > 310) ||
//@					(p[6] < 45) || (p[6] > 235)) {
//@					this.bMenu = !this.bMenu;
//@					p[5] = -1;
//@				}
//@				
//@				if ((p[5] > 190) && (p[5] < 230) &&
//@					(p[6] > 70) && (p[6] < 100)) {
//@					p[1] -= 1;
//@					if (p[1] < 0) {
//@						p[1] = 9;
//@					}
//@					this.setUploadVisible(false);
//@					p[5] = -1;
//@					this.getGame().playSound(ApoHybridSoundPlayer.SOUND_BUTTON);
//@				}
//@				if ((p[5] > 255) && (p[5] < 285) &&
//@					(p[6] > 70) && (p[6] < 100)) {
//@					p[1] += 1;
//@					if (p[1] > 9) {
//@						p[1] = 0;
//@					}
//@					this.setUploadVisible(false);
//@					p[5] = -1;
//@					this.getGame().playSound(ApoHybridSoundPlayer.SOUND_BUTTON);
//@				}
//@				
//@				if ((p[5] > 190) && (p[5] < 220) &&
//@					(p[6] > 140) && (p[6] < 170)) {
//@					p[7] -= 1;
//@					if (p[7] < 0) {
//@						p[7] = 9;
//@					}
//@					this.setUploadVisible(false);
//@					p[5] = -1;
//@					this.getGame().playSound(ApoHybridSoundPlayer.SOUND_BUTTON);
//@				}
//@				if ((p[5] > 255) && (p[5] < 285) &&
//@					(p[6] > 140) && (p[6] < 170)) {
//@					p[7] += 1;
//@					if (p[7] > 9) {
//@						p[7] = 0;
//@					}
//@					this.setUploadVisible(false);
//@					p[5] = -1;
//@					this.getGame().playSound(ApoHybridSoundPlayer.SOUND_BUTTON);
//@				}
//@				if ((p[5] > 190) && (p[5] < 220) &&
//@					(p[6] > 210) && (p[6] < 240)) {
//@					p[8] -= 1;
//@					if (p[8] < 0) {
//@						p[8] = 9;
//@					}
//@					this.setUploadVisible(false);
//@					p[5] = -1;
//@					this.getGame().playSound(ApoHybridSoundPlayer.SOUND_BUTTON);
//@				}
//@				if ((p[5] > 255) && (p[5] < 285) &&
//@					(p[6] > 210) && (p[6] < 240)) {
//@					p[8] += 1;
//@					if (p[8] > 9) {
//@						p[8] = 0;
//@					}
//@					this.setUploadVisible(false);
//@					p[5] = -1;
//@					this.getGame().playSound(ApoHybridSoundPlayer.SOUND_BUTTON);
//@				}
//@			} else {
//@				if (p[6] < ApoHybridGame.changeY) {
//@					if (!this.bMenu) {
//@						if ((p[5] >= 0) && (p[5] <= 130)) {
//@							this.bMenu = !this.bMenu;
//@							this.getGame().playSound(ApoHybridSoundPlayer.SOUND_BUTTON);
//@						}
//@					}
//@					p[5] = -1;
//@				} else if (p[6] > ApoHybridGame.changeY + 240) {
//@					boolean sound = true;
//@					if ((p[5] > 5) && (p[5] < 40)) {
//@						this.curSelected = 0;
//@					} else if ((p[5] > 45) && (p[5] < 80)) {
//@						this.curSelected = 1;
//@					} else if ((p[5] > 85) && (p[5] < 120)) {
//@						this.curSelected = 2;
//@					} else if ((p[5] > 125) && (p[5] < 160)) {
//@						this.curSelected = 3;
//@					} else if ((p[5] > 165) && (p[5] < 200)) {
//@						this.curSelected = 4;
//@					} else if ((p[5] > 205) && (p[5] < 240)) {
//@						this.curSelected = 5;
//@					} else if ((p[5] > 245) && (p[5] < 280)) {
//@						this.curSelected = 6;
//@					} else if ((p[5] > 285) && (p[5] < 320)) {
//@						this.curSelected = 7;
//@					} else if ((p[5] > 325) && (p[5] < 360)) {
//@						this.curSelected = 8;
//@					} else if ((p[5] > 365) && (p[5] < 400)) {
//@						this.curSelected = 10;
//@					} else if ((p[5] > 405) && (p[5] < 440)) {
//@						this.curSelected = 11;
//@					} else if ((p[5] > 445) && (p[5] < 480)) {
//@						this.curSelected = 12;
//@					} else {
//@						sound = false;
//@					}
//@					if (sound) {
//@						this.getGame().playSound(ApoHybridSoundPlayer.SOUND_BUTTON);
//@					}
//@					p[5] = -1;
//@				} else if ((p[6] > ApoHybridGame.changeY) && (p[6] < ApoHybridGame.changeY + 240)) {
//@					int myX = p[5] / 16;
//@					int myY = (p[6] - ApoHybridGame.changeY) / 16;
//@					int beamer = 0;
//@					if ((myX > 0) && (myX < level[0].length - 1) && (myY >= 0) && (myY < level.length) && (this.level[myY][myX] != this.curSelected)) {
//@						if ((this.curSelected == 2) || (this.curSelected == 3) || (this.curSelected == 11)) {
//@							for (int y = 0; y < level.length; y++) {
//@								for (int x = 0; x < level[0].length; x++) {
//@									if (this.curSelected != 11) {
//@										if (level[y][x] == this.curSelected) {
//@											this.level[y][x] = 0;
//@										}
//@									} else {
//@										if (level[y][x] == this.curSelected) {
//@											beamer += 1;
//@											if (beamer >= 2) {
//@												level[y][x] = 0;
//@											}
//@										}
//@									}
//@								}
//@							}
//@						}
//@						this.level[myY][myX] = this.curSelected;
//@						
//@						this.canBeTested();
//@						this.setUploadVisible(false);
//@					}
//@				}
//@			}
//@		}
//@	}
//@	
//@	private void renderMenuBox(final BitsGraphics g, final int width, final int height) {
//@		g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
//@		g.fillRect(3, 3, width - 4, height - 4);
//@		ApoHybridGame.setDarkerColor(g);
//@		g.fillRect(1, 3, 2, height - 4);
//@		g.fillRect(3 + width - 4, 3, 2, height - 4);
//@		g.fillRect(3, 1, width - 4, 2);
//@		g.fillRect(3, 3 + height - 4, width - 4, 2);
//@		ApoHybridGame.setBrighterColor(g);
//@		g.fillRect(3 + width - 2, 5, 2, height - 4);
//@		g.fillRect(3 + width - 4, 3 + height - 4, 2, 2);
//@		g.fillRect(5, 3 + height - 2, width - 4, 2);
//@	}
//@
//@	@Override
//@	public void render(BitsGLGraphics g) {
//@		g.setColor(ApoHybridConstants.BRIGHT_DARK[0], ApoHybridConstants.BRIGHT_DARK[1], ApoHybridConstants.BRIGHT_DARK[2], 1f);
//@		for (int x = 1; x < this.level[0].length; x++) {
//@			g.drawLine(x * 16, ApoHybridGame.changeY, x * 16, ApoHybridGame.changeY + 240);
//@		}
//@		for (int y = 0; y < this.level.length + 1; y++) {
//@			g.drawLine(16, ApoHybridGame.changeY + y * 16, (level[0].length - 1) * 16, ApoHybridGame.changeY + y * 16);
//@		}
//@
//@		this.renderMenuBox(g, 130, ApoHybridGame.changeY - 5);
//@		ApoHybridGame.drawMenu(g, this.getGame(), ApoHybridConstants.BRIGHT_DARK, ApoHybridConstants.BRIGHT, p[1], p[7], p[8], this.frameGravity);
//@		
//@		int addPX = 0;
//@		int addPY = 0 + ApoHybridGame.changeY;		
//@		
//@		for (int y = 0; y < level.length; y++) {
//@			for (int x = 0; x < level[0].length; x++) {
//@				if (level[y][x] != 0) {
//@					g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
//@
//@					addPX = x * 16;
//@					addPY = y * 16 + ApoHybridGame.changeY;
//@					if (level[y][x] == 2) {
//@						ApoHybridGame.renderPlayer(g, addPX, addPY, 0, 1, 0);
//@					}
//@					
//@					if (level[y][x] == 3) {
//@						/* Render das Ziel */
//@						ApoHybridGame.drawFinish(g, addPX, addPY, this.frameGoal);
//@					}
//@					if ((level[y][x] == 1) || (level[y][x] == 4) || (level[y][x] == 5) || (level[y][x] == 8)) {
//@						if (level[y][x] == 1) {
//@							ApoHybridGame.drawBlock(g, addPX, addPY);
//@						} else if (level[y][x] == 4) {
//@							ApoHybridGame.drawMoveableBox(g, addPX, addPY);
//@						} else if (level[y][x] == 5) {
//@							ApoHybridGame.drawBox(g, addPX, addPY, false);
//@						} else if (level[y][x] == 8) {
//@							ApoHybridGame.drawBlockPlusMirror(g, addPX, addPY);
//@						}
//@					}
//@					if (level[y][x] == 6) {
//@						ApoHybridGame.drawAir(g, addPX, addPY);
//@					}
//@					if (level[y][x] == 7) {
//@						ApoHybridGame.drawX(g, addPX, addPY);
//@					}
//@					if (level[y][x] == 10) {
//@						ApoHybridGame.drawSpikes(g, addPX, addPY);
//@					}
//@					if (level[y][x] == 11) {
//@						ApoHybridGame.drawBeamer(g, addPX, addPY, this.beamerFrame);
//@					}
//@					if (level[y][x] == 12) {
//@						ApoHybridGame.drawOnStepBlock(g, addPX, addPY);
//@					}
//@				}
//@			}
//@		}
//@
//@		
//@		g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
//@		boolean bSelect = false;
//@		if (this.curSelected == 0) {
//@			bSelect = true;
//@		}
//@		this.drawInputEmptyBox(g, bSelect);
//@		
//@		bSelect = false;
//@		if (this.curSelected == 1) {
//@			bSelect = true;
//@		}
//@		this.drawInputWallBox(g, bSelect);
//@		
//@		bSelect = false;
//@		if (this.curSelected == 2) {
//@			bSelect = true;
//@		}
//@		this.drawInputPlayerBox(g, bSelect);
//@		
//@		bSelect = false;
//@		if (this.curSelected == 3) {
//@			bSelect = true;
//@		}
//@		this.drawInputGoalBox(g, bSelect);
//@		
//@		bSelect = false;
//@		if (this.curSelected == 4) {
//@			bSelect = true;
//@		}
//@		this.drawInputPickBox(g, bSelect);
//@		
//@		bSelect = false;
//@		if (this.curSelected == 5) {
//@			bSelect = true;
//@		}
//@		this.drawInputMirrorBox(g, bSelect);
//@		
//@		bSelect = false;
//@		if (this.curSelected == 6) {
//@			bSelect = true;
//@		}
//@		this.drawInputAirBox(g, bSelect);
//@		
//@		bSelect = false;
//@		if (this.curSelected == 7) {
//@			bSelect = true;
//@		}
//@		this.drawInputXBox(g, bSelect);
//@		
//@		bSelect = false;
//@		if (this.curSelected == 8) {
//@			bSelect = true;
//@		}
//@		this.drawInputMirrorStayBox(g, bSelect);
//@		
//@		bSelect = false;
//@		if (this.curSelected == 10) {
//@			bSelect = true;
//@		}
//@		this.drawInputSpikes(g, bSelect);
//@		
//@		bSelect = false;
//@		if (this.curSelected == 11) {
//@			bSelect = true;
//@		}
//@		this.drawInputBeamer(g, bSelect);
//@		
//@		bSelect = false;
//@		if (this.curSelected == 12) {
//@			bSelect = true;
//@		}
//@		this.drawInputOneStep(g, bSelect);
//@		
//@		if (this.bMenu) {
//@			g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
//@			g.fillRect(170, 45, 140, 200);
//@			ApoHybridGame.setDarkerColor(g);
//@			g.fillRect(168, 45, 2, 200);
//@			g.fillRect(310, 45, 2, 200);
//@			g.fillRect(170, 43, 140, 2);
//@			g.fillRect(170, 245, 140, 2);
//@			ApoHybridGame.setBrighterColor(g);
//@			g.fillRect(312, 47, 2, 200);
//@			g.fillRect(310, 245, 2, 2);
//@			g.fillRect(172, 247, 140, 2);
//@			
//@			g.setColor(ApoHybridConstants.BRIGHT_DARK[0], ApoHybridConstants.BRIGHT_DARK[1], ApoHybridConstants.BRIGHT_DARK[2], 0.5f);
//@			g.fillRect(231, 55, 6, 8);
//@			g.fillRect(230, 56, 8, 6);
//@			
//@			g.fillRect(237, 120, 6, 8);
//@			g.fillRect(236, 121, 8, 6);
//@			g.setColor(ApoHybridConstants.BRIGHT_DARK[0], ApoHybridConstants.BRIGHT_DARK[1], ApoHybridConstants.BRIGHT_DARK[2], 1f);
//@			g.fillRect(242, 55, 6, 8);
//@			g.fillRect(241, 56, 8, 6);
//@			
//@			g.fillRect(237, 131, 6, 8);
//@			g.fillRect(236, 132, 8, 6);
//@			for (int i = 0; i < 10; i+= 2) {
//@				g.fillRect(239, 55 + i, 1, 1);
//@				g.fillRect(235 + i, 129, 1, 1);
//@			}
//@			g.fillRect(237, 190 + frameGravity/2, 6, 8);
//@			g.fillRect(236, 190 + frameGravity/2 + 1, 8, 6);
//@
//@			this.drawInputLeftBoxForMirror(g, 190, 70);
//@			this.drawInputRightBoxForMirror(g, 255, 70);
//@			
//@			String s = String.valueOf(p[1]);
//@			this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 80, ApoHybridPanel.game_font, ApoHybridConstants.BRIGHT);			
//@			
//@			this.drawInputLeftBoxForMirror(g, 190, 140);
//@			this.drawInputRightBoxForMirror(g, 255, 140);
//@
//@			s = String.valueOf(p[7]);
//@			this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 150, ApoHybridPanel.game_font, ApoHybridConstants.BRIGHT);			
//@
//@			this.drawInputLeftBoxForMirror(g, 190, 210);
//@			this.drawInputRightBoxForMirror(g, 255, 210);
//@			
//@			s = String.valueOf(p[8]);
//@			this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 220, ApoHybridPanel.game_font, ApoHybridConstants.BRIGHT);			
//@		}
//@		this.getGame().drawButtons(g, ApoHybridPanel.game_font, 2);
//@		
//@		if (this.monoString != null) {
//@			this.monoString.render(g, 0, 0);
//@		}
//@	}
//@
//@	private void drawInputEmptyBox(final BitsGLGraphics g, final boolean bSelect) {
//@		int x = 5;
//@		int y = ApoHybridGame.changeY + 245;
//@		this.drawInputBox(g, x, y, bSelect);
//@	}
//@	
//@	private void drawInputWallBox(final BitsGLGraphics g, final boolean bSelect) {
//@		int x = 45;
//@		int y = ApoHybridGame.changeY + 245;
//@		this.drawInputBox(g, x, y, bSelect);
//@		
//@		int addPX = x + 9;
//@		int addPY = y + 9;
//@		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
//@		g.fillRect(addPX, addPY + 2, 16, 12);
//@		g.fillRect(addPX + 2, addPY, 12, 16);
//@		g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
//@		g.fillRect(addPX + 6, addPY + 6, 4, 4);
//@	}
//@	
//@	private void drawInputPlayerBox(final BitsGLGraphics g, final boolean bSelect) {
//@		int x = 85;
//@		int y = ApoHybridGame.changeY + 245;
//@		this.drawInputBox(g, x, y, bSelect);
//@		
//@		int addPX = x + 9;
//@		int addPY = y + 9;
//@		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
//@		g.fillRect(addPX + 5, addPY + 1, 6, 11);
//@		g.fillRect(addPX + 3, addPY + 2, 10, 2);
//@		g.fillRect(addPX + 11, addPY + 5, 2, 2);
//@		g.fillRect(addPX + 5, addPY + 12, 2, 5);
//@		g.fillRect(addPX + 9, addPY + 12, 2, 5);
//@	}
//@	
//@	private void drawInputGoalBox(final BitsGLGraphics g, final boolean bSelect) {
//@		int x = 125;
//@		int y = ApoHybridGame.changeY + 245;
//@		this.drawInputBox(g, x, y, bSelect);
//@		
//@		int addPX = x + 9;
//@		int addPY = y + 9;
//@		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
//@		ApoHybridGame.drawFinish(g, addPX, addPY, this.frameGoal);
//@	}
//@	
//@	private void drawInputPickBox(final BitsGLGraphics g, final boolean bSelect) {
//@		int x = 165;
//@		int y = ApoHybridGame.changeY + 245;
//@		this.drawInputBox(g, x, y, bSelect);
//@		
//@		int addPX = x + 9;
//@		int addPY = y + 9;
//@		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
//@		g.fillRect(addPX, addPY + 2, 16, 12);
//@		g.fillRect(addPX + 2, addPY, 12, 16);
//@		g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
//@		g.fillRect(addPX + 3, addPY + 3, 10, 10);
//@		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
//@		g.fillRect(addPX + 5, addPY + 5, 6, 6);
//@	}
//@	
//@	private void drawInputMirrorBox(final BitsGLGraphics g, final boolean bSelect) {
//@		int x = 205;
//@		int y = ApoHybridGame.changeY + 245;
//@		this.drawInputBox(g, x, y, bSelect);
//@		
//@		int addPX = x + 9;
//@		int addPY = y + 9;
//@		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
//@		g.fillRect(addPX, addPY + 2, 16, 12);
//@		g.fillRect(addPX + 2, addPY, 12, 16);
//@	}
//@	
//@	private void drawInputAirBox(final BitsGLGraphics g, final boolean bSelect) {
//@		int x = 245;
//@		int y = ApoHybridGame.changeY + 245;
//@		this.drawInputBox(g, x, y, bSelect);
//@		
//@		int addPX = x + 9;
//@		int addPY = y + 9;
//@		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
//@		g.fillRect(addPX + 6, addPY + 6, 4, 4);
//@	}
//@	
//@	private void drawInputXBox(final BitsGLGraphics g, final boolean bSelect) {
//@		int x = 285;
//@		int y = ApoHybridGame.changeY + 245;
//@		this.drawInputBox(g, x, y, bSelect);
//@		
//@		int addPX = x + 9;
//@		int addPY = y + 9;
//@		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
//@		g.drawLine(addPX + 4, addPY + 4, addPX + 12, addPY + 12);
//@		g.drawLine(addPX + 12, addPY + 4, addPX + 4, addPY + 12);
//@	}
//@	
//@	private void drawInputMirrorStayBox(final BitsGLGraphics g, final boolean bSelect) {
//@		int x = 325;
//@		int y = ApoHybridGame.changeY + 245;
//@		this.drawInputBox(g, x, y, bSelect);
//@		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
//@		int addPX = x + 9;
//@		int addPY = y + 9;
//@		
//@		g.fillRect(addPX, addPY + 2, 16, 12);
//@		g.fillRect(addPX + 2, addPY, 12, 16);
//@		g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
//@		g.fillRect(addPX + 3, addPY + 6, 10, 4);
//@		g.fillRect(addPX + 6, addPY + 3, 4, 10);
//@	}
//@	
//@	private void drawInputSpikes(final BitsGLGraphics g, final boolean bSelect) {
//@		int x = 365;
//@		int y = ApoHybridGame.changeY + 245;
//@		this.drawInputBox(g, x, y, bSelect);
//@		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
//@		int addPX = x + 9;
//@		int addPY = y + 9;
//@		
//@		ApoHybridGame.drawSpikes(g, addPX, addPY);
//@	}
//@	
//@	private void drawInputBeamer(final BitsGLGraphics g, final boolean bSelect) {
//@		int x = 405;
//@		int y = ApoHybridGame.changeY + 245;
//@		this.drawInputBox(g, x, y, bSelect);
//@		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
//@		int addPX = x + 9;
//@		int addPY = y + 9;
//@		
//@		ApoHybridGame.drawBeamer(g, addPX, addPY, this.beamerFrame, false, ApoHybridConstants.BRIGHT_DARK);
//@	}
//@	
//@	private void drawInputOneStep(final BitsGLGraphics g, final boolean bSelect) {
//@		int x = 445;
//@		int y = ApoHybridGame.changeY + 245;
//@		this.drawInputBox(g, x, y, bSelect);
//@		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
//@		int addPX = x + 9;
//@		int addPY = y + 9;
//@		
//@		ApoHybridGame.drawOnStepBlock(g, addPX, addPY);
//@	}
//@	
//@	private void drawInputBox(final BitsGraphics g, int x, int y, final boolean bActive) {
//@		this.drawInputBox(g, x, y, 34, 34, bActive);
//@	}
//@	
//@	private void drawInputBox(final BitsGraphics g, int x, int y, final int width, final int height, final boolean bActive) {
//@		g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
//@		g.fillRect(x + 2, y + 2, width - 4, height - 4);
//@		ApoHybridGame.setDarkerColor(g);
//@		if ((p[5] > x) && (p[5] < x + width) && (p[6] > y) && (p[6] < y + height)) {
//@			g.setColor(ApoHybridConstants.BRIGHT_DARK[0], ApoHybridConstants.BRIGHT_DARK[1], ApoHybridConstants.BRIGHT_DARK[2], 1f);			
//@		}
//@		g.fillRect(x + 2, y, width - 4, 2);
//@		g.fillRect(x + 2, y + height - 2, width - 4, 2);
//@		g.fillRect(x, y + 2, 2, height - 4);
//@		g.fillRect(x + width - 2, y + 2, 2, height - 4);
//@		ApoHybridGame.setBrighterColor(g);
//@		g.fillRect(x + 4, y + height, width - 4, 2);
//@		g.fillRect(x + width, y + 4, 2, height - 4);
//@		g.fillRect(x + width - 2, y + height - 2, 2, 2);
//@		if (bActive) {
//@			g.setColor(1f, 0f, 0f, 1f);
//@			g.setLineSize(1.5f * ApoHybridConstants.MAX);
//@			g.drawRect(x, y, width, height);
//@			g.setLineSize(1);
//@		}
//@	}
//@	
//@	private void drawInputLeftBoxForMirror(final BitsGLGraphics g, int x, int y) {
//@		this.drawInputBoxForLevelchooser(g, x, y, 30, 30);
//@		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
//@		for (int i = 0; i < 10; i++) {
//@			g.fillRect(x + 18 - i * 1, y + 9 + i * 0.5f, 2, 10 - i * 1);
//@		}
//@	}
//@	
//@	private void drawInputRightBoxForMirror(final BitsGLGraphics g, final int x, final int y) {
//@		this.drawInputBoxForLevelchooser(g, x, y, 30, 30);
//@		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
//@		for (int i = 0; i < 10; i++) {
//@			g.fillRect(x + 10 + i * 1, y + 9 + i * 0.5f, 2, 10 - i * 1);
//@		}
//@	}
//@	
//@	private void drawInputBoxForLevelchooser(final BitsGLGraphics g, int x, int y, final int width, final int height) {
//@		g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
//@		g.fillRect(x + 2, y + 2, width - 4, height - 4);
//@		ApoHybridGame.setDarkerColor(g);
//@		g.fillRect(x + 2, y, width - 4, 2);
//@		g.fillRect(x + 2, y + height - 2, width - 4, 2);
//@		g.fillRect(x, y + 2, 2, height - 4);
//@		g.fillRect(x + width - 2, y + 2, 2, height - 4);
//@		ApoHybridGame.setBrighterColor(g);
//@		g.fillRect(x + 4, y + height, width - 4, 2);
//@		g.fillRect(x + width, y + 4, 2, height - 4);
//@		g.fillRect(x + width - 2, y + height - 2, 2, 2);
//@	}
//@}
//#elif TreasureGameLogic
//@
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//@
//@import net.apogames.apohybrid.ApoHybridConstants;
//@import net.apogames.apohybrid.ApoHybridModel;
//@import net.apogames.apohybrid.ApoHybridSoundPlayer;
//@
//@public class ApoHybridEditor extends ApoHybridModel {
//@
//@	public static final int ENTITY_WALL = 0;
//@	public static final int ENTITY_FREE = 1;
//@	public static final int ENTITY_PLAYER = 2;
//@	public static final int ENTITY_SKULL = 3;
//@	public static final int ENTITY_BLOCK = 4;
//@	
//@	public static final String BACK = "back";
//@	public static final String SIZE_LEFT = "left";
//@	public static final String SIZE_RIGHT = "right";
//@	public static final String TEST = "test";
//@	public static final String UPLOAD = "upload";
//@	public static final String SOLVE = "solve";
//@	
//@	private int[][] level;
//@	
//@	private int size = 6;
//@	
//@	private int curChoose;
//@	
//@	private int steps;
//@	
//@	private int startX, startY;
//@	
//@	private int time;
//@	private String uploadString;
//@	
//@	private Thread t;
//@	
//@	private int[][] levelRandom;
//@	
//@	public ApoHybridEditor(final ApoHybridPanel game) {
//@		super(game);
//@	}
//@
//@	@Override
//@	public void init() {
//@		if (this.level == null) {
//@			this.level = new int[6][6];
//@			this.makeStandardLevel();
//@			
//@			this.curChoose = ApoHybridEditor.ENTITY_BLOCK;
//@		}
//@		this.time = 0;
//@		this.makeBackground();
//@		this.setCanBeTest();
//@	}
//@	
//@	public void makeBackground() {
//@		this.levelRandom = new int[16][11];
//@		
//@		for (int y = 0; y < 16; y += 1) {
//@			for (int x = 0; x < 11; x += 1) {
//@				this.levelRandom[y][x] = (int)(Math.random() * 4);
//@			}
//@		}
//@	}
//@	
//@	public void setSteps(int steps) {
//@		if (this.steps > steps) {
//@			this.steps = steps;
//@		}
//@//		System.out.println(this.getLevelString());
//@	}
//@	
//@	public void setVisibleUpload(final boolean visible) {
//@		this.getGame().getButtons()[19].setVisible(visible);
//@		if (!visible) {
//@			this.time = 0;
//@		}
//@	}	
//@	
//@	public void makeStandardLevel() {
//@		for (int y = 1; y < this.level.length - 1; y++) {
//@			for (int x = 1; x < this.level[0].length - 1; x++) {
//@				this.level[y][x] = 1;
//@			}
//@		}
//@		this.level[this.level.length - 2][2] = 2;
//@		this.level[this.level.length - 2][1] = 4;
//@		this.level[1][this.level[0].length - 3] = 3;
//@		
//@		this.startX = ApoHybridConstants.GAME_WIDTH/2 - this.level[0].length * 16;
//@		this.startY = ApoHybridConstants.GAME_HEIGHT/2 - this.level.length * 16 - 32;
//@	}
//@	
//@	public void setCanBeTest() {
//@		int player = 0;
//@		int skull = 0;
//@		
//@		for (int y = 0; y < this.level.length; y += 1) {
//@			for (int x = 0; x < this.level[0].length; x += 1) {
//@				if (this.level[y][x] == 2) player += 1;
//@				if (this.level[y][x] == 3) skull += 1;
//@			}
//@		}
//@		
//@		if ((player == 1) && (skull == 1)) {
//@			this.getGame().getButtons()[18].setVisible(true);
//@			this.getGame().getButtons()[20].setVisible(true);	
//@		} else {
//@			this.getGame().getButtons()[18].setVisible(false);
//@			this.getGame().getButtons()[20].setVisible(false);
//@		}
//@	}
//@	
//@	public String getLevelString() {
//@		String levelString = "";
//@		String width = String.valueOf(this.level[0].length);
//@		if (width.length() < 2) {
//@			width = "0" + width;
//@		}
//@		String height = String.valueOf(this.level.length);
//@		if (height.length() < 2) {
//@			height = "0" + height;
//@		}
//@		levelString = width + height;
//@		for (int y = 0; y < this.level.length; y += 1) {
//@			for (int x = 0; x < this.level[0].length; x += 1) {
//@				levelString += String.valueOf(this.level[y][x]);
//@			}
//@		}
//@		String stepsString = String.valueOf(this.steps);
//@		
//@		if (stepsString.length() < 2) {
//@			stepsString = "0" + stepsString;
//@		}
//@		
//@		levelString += stepsString;
//@		
//@		stepsString = String.valueOf(this.steps + 4);
//@		if (stepsString.length() < 2) {
//@			stepsString = "0" + stepsString;
//@		}
//@		
//@		levelString += stepsString;
//@		
//@		return levelString;
//@	}
//@
//@	@Override
//@	public void touchedButton(String function) {
//@		this.getGame().playSound(ApoHybridSoundPlayer.SOUND_CLICK);
//@		if (function.equals(ApoHybridEditor.BACK)) {
//@			this.onBackButtonPressed();
//@		} else if (function.equals(ApoHybridEditor.SIZE_LEFT)) {
//@			if (this.size > 5) {
//@				this.size -= 1;
//@				this.level = new int[this.size][this.size];
//@				this.makeStandardLevel();
//@				this.steps = 95;
//@			}
//@		} else if (function.equals(ApoHybridEditor.SIZE_RIGHT)) {
//@			if (this.size < 10) {
//@				this.size += 1;
//@				this.level = new int[this.size][this.size];
//@				this.makeStandardLevel();
//@				this.steps = 95;
//@			}
//@		} else if (function.equals(ApoHybridEditor.TEST)) {
//@			this.getGame().setGame(false, true, 0, this.getLevelString());
//@		} else if (function.equals(ApoHybridEditor.UPLOAD)) {
//@			this.upload();
//@		} else if (function.equals(ApoHybridEditor.SOLVE)) {
//@			this.setSolutionString("");
//@			this.solveLevel(this.getLevelString());
//@		}
//@	}
//@
//@	public void setTestString(final String solution) {
//@		this.time = 10000;
//@		this.uploadString = solution;
//@	}
//@	
//@	public void setSolutionString(final String solution) {
//@		this.time = 10000;
//@		if (solution.length() == 0) {
//@			this.uploadString = "try to solve the level";
//@		} else if (solution.startsWith("no solution")) {
//@			this.uploadString = solution;
//@		} else {
//@			this.uploadString = "level solved in "+solution.length()+" steps";
//@			this.steps = solution.length();
//@			this.setVisibleUpload(true);
//@		}
//@	}
//@	
//@	public final void solveLevel(final String level) {
//@		this.t = new Thread(new Runnable() {
//@
//@			public void run() {
//@				ApoHybridEditor.this.getGame().doSolveLevel(level);
//@			}
//@ 		});
//@ 		this.t.start();
//@	}
//@	
//@	public void onBackButtonPressed() {
//@		this.getGame().setMenu();
//@	}
//@	
//@	public void upload() {
//@		this.time = 5000;
//@		this.uploadString = "uploading ...";
//@		this.setVisibleUpload(false);
//@		this.t = new Thread(new Runnable() {
//@			public void run() {
//@				ApoHybridEditor.this.uploadString();
//@			}
//@ 		});
//@		this.t.start();
//@	}
//@	
//@	public void uploadString() {
//@		boolean bUpload = this.getGame().getUserlevels().addLevel(this.getLevelString());
//@		if (bUpload) {
//@			this.uploadString = "upload successfully";
//@			this.getGame().loadUserlevels();
//@			this.time = 2000;
//@		} else {
//@			this.uploadString = "upload failed";
//@			this.time = 2000;
//@		}
//@	}
//@	
//@
//@	@Override
//@	public void touchedPressed(int x, int y, int finger) {
//@		this.touchedReleased(x, y, finger);
//@	}
//@
//@	@Override
//@	public void touchedReleased(int x, int y, int finger) {
//@		if ((y >= ApoHybridConstants.GAME_HEIGHT - 64) && (y <= ApoHybridConstants.GAME_HEIGHT - 32) &&
//@				(x >= 128)) {
//@				for (int i = 0; i < 5; i++) {
//@					if ((x >= 128 + i * 40) && (x <= 160 + i * 40)) {
//@						this.curChoose = i;
//@						this.getGame().playSound(ApoHybridSoundPlayer.SOUND_CLICK);
//@						break;
//@					}
//@				}
//@			}
//@			if ((y >= this.startY) && (y < this.startY + this.size * 32) &&
//@				(x >= this.startX) && (x < this.startX + this.size * 32)) {
//@				int curX = (x - this.startX) / 32;
//@				int curY = (y - this.startY) / 32;
//@				if ((this.curChoose == 2) || (this.curChoose == 3)) {
//@					if ((curX < 1) || (curY < 1) || (curX >= this.level[0].length - 1) || (curY >= this.level.length - 1)) {
//@						return;
//@					}
//@				}
//@				if (this.level[curY][curX] != this.curChoose) {
//@					if ((this.curChoose == ApoHybridEditor.ENTITY_SKULL) || (this.curChoose == ApoHybridEditor.ENTITY_PLAYER)) {
//@						for (int lY = 0; lY < this.level.length; lY += 1) {
//@							for (int lX = 0; lX < this.level[0].length; lX += 1) {
//@								if (this.level[lY][lX] == this.curChoose) {
//@									this.level[lY][lX] = ApoHybridEditor.ENTITY_FREE;
//@								}
//@							}
//@						}
//@					}
//@					this.level[curY][curX] = this.curChoose;
//@					this.steps = 95;
//@					this.setCanBeTest();
//@					this.setVisibleUpload(false);
//@				}
//@			}
//@	}
//@
//@	@Override
//@	public void touchedDragged(int x, int y, int oldX, int oldY, int finger) {
//@		if ((y >= this.startY) && (y < this.startY + this.size * 32) &&
//@				(x >= this.startX) && (x < this.startX + this.size * 32)) {
//@				this.touchedReleased(x, y, finger);
//@			}
//@	}
//@	
//@	@SuppressWarnings("deprecation")
//@	@Override
//@	public void think(int delta) {
//@		if (this.time > 0) {
//@			this.time -= delta;
//@			if (this.time <= 0) {
//@				if (this.uploadString.equals("uploading ...")) {
//@					if (this.t != null) {
//@						try {
//@							this.t.stop();
//@						} catch (Exception ex) {}
//@					}
//@				} else if (this.uploadString.equals("try to solve the level")) {
//@					if (this.t != null) {
//@						try {
//@							this.t.stop();
//@						} catch (Exception ex) {}
//@					}
//@					this.time = 3000;
//@					this.uploadString = "Can't find a solution in 10 sec";
//@				}
//@			}
//@		}
//@	}
//@
//@	@Override
//@	public void render(BitsGLGraphics g) {
//@//		g.cropImage(this.iBackground, 0, 0, ApoHybridConstants.GAME_WIDTH, ApoHybridConstants.GAME_HEIGHT, 0, 0, ApoHybridConstants.GAME_WIDTH, ApoHybridConstants.GAME_HEIGHT);
//@		
//@		for (int y = 1; y < 16; y += 1) {
//@			for (int x = 0; x < 11; x += 1) {
//@				g.cropImage(ApoHybridConstants.iSheet, (x-1) * 32, (y) * 32, 32, 32, this.levelRandom[y][x] * 32, 3 * 32, 32, 32);
//@			}
//@		}
//@		for (int i = 0; i < 3; i++) {
//@			g.cropImage(ApoHybridConstants.iSheet, 0, 448 - i * 32, 320, 32, 384, 480, 320, 32);
//@		}
//@		g.cropImage(ApoHybridConstants.iSheet, 0, 0, 320, 32, 384, 480, 320, 32);
//@		
//@		
//@		for (int y = 0; y < this.level.length; y += 1) {
//@			for (int x = 0; x < this.level[0].length; x += 1) {
//@				g.setColor(1f, 1f, 1f, 1f);
//@				if (this.level[y][x] == 3) {
//@					g.cropImage(ApoHybridConstants.iSheet, this.startX + (x) * 32 - 16, this.startY +(y) * 32 - 16, 64, 64, 8 * 32, 32, 64, 64);
//@					g.cropImage(ApoHybridConstants.iSheet, this.startX + (x) * 32, this.startY + (y) * 32, 32, 32, 0 * 32, 1 * 32, 32, 32);
//@				}
//@				if (this.level[y][x] == 4) {
//@					g.cropImage(ApoHybridConstants.iSheet, this.startX + (x) * 32, this.startY + (y) * 32, 32, 32, 2 * 32, 0 * 32, 32, 32);
//@				}
//@				if (this.level[y][x] == 0) {
//@					g.cropImage(ApoHybridConstants.iSheet, this.startX + (x) * 32, this.startY + (y) * 32, 32, 32, 0 * 32, 2 * 32, 32, 32);
//@				}
//@				if (this.level[y][x] == 2) {
//@					int curX = 0;
//@					int curY = 0;
//@					g.cropImage(ApoHybridConstants.iSheet, this.startX + (x) * 32, this.startY + (y) * 32, 32, 32, curX * 32, curY * 32, 32, 32);
//@				}
//@				if (this.level[y][x] == 1) {
//@					g.setColor(ApoHybridConstants.COLOR_LIGHT);
//@					g.drawRect(this.startX + (x) * 32, this.startY + (y) * 32, 32, 32);
//@				}
//@			}
//@		}
//@		
//@		g.setColor(ApoHybridConstants.COLOR_SEPARATOR);
//@		g.setFont(ApoHybridConstants.FONT_STATISTICS);
//@		
//@		String s = "size";
//@		float w = ApoHybridConstants.FONT_STATISTICS.getLength(s);
//@		g.drawText(s, 60 - w/2, ApoHybridConstants.GAME_HEIGHT - 72 - ApoHybridConstants.FONT_STATISTICS.mCharCellHeight);
//@		
//@		s = String.valueOf(this.size);
//@		w = ApoHybridConstants.FONT_STATISTICS.getLength(s);
//@		g.drawText(s, 60 - w/2, ApoHybridConstants.GAME_HEIGHT - 38 - ApoHybridConstants.FONT_STATISTICS.mCharCellHeight);
//@		
//@		s = "level objects";
//@		w = ApoHybridConstants.FONT_STATISTICS.getLength(s);
//@		g.drawText(s, 220 - w/2, ApoHybridConstants.GAME_HEIGHT - 72 - ApoHybridConstants.FONT_STATISTICS.mCharCellHeight);
//@		
//@		g.setColor(ApoHybridConstants.COLOR_SEPARATOR);
//@		g.fillRect(120, ApoHybridConstants.GAME_HEIGHT - 94, 2, 92);
//@		
//@		g.setColor(1f, 1f, 1f, 1f);
//@		// block
//@		g.cropImage(ApoHybridConstants.iSheet, 128, ApoHybridConstants.GAME_HEIGHT - 64, 32, 32, 0 * 32, 2 * 32, 32, 32);
//@		// free
//@		g.cropImage(ApoHybridConstants.iSheet, 168, ApoHybridConstants.GAME_HEIGHT - 64, 32, 32, 0 * 32, 3 * 32, 32, 32);
//@		// player
//@		g.cropImage(ApoHybridConstants.iSheet, 208, ApoHybridConstants.GAME_HEIGHT - 64, 32, 32, 0 * 32, 0 * 32, 32, 32);
//@		// skull
//@		g.cropImage(ApoHybridConstants.iSheet, 248, ApoHybridConstants.GAME_HEIGHT - 64, 32, 32, 0 * 32, 1 * 32, 32, 32);
//@		// block
//@		g.cropImage(ApoHybridConstants.iSheet, 288, ApoHybridConstants.GAME_HEIGHT - 64, 32, 32, 2 * 32, 0 * 32, 32, 32);
//@		
//@		float lineSize = g.getLineSize();
//@		g.setLineSize(5f);
//@		g.setColor(new int[] {255, 0, 0});
//@		g.drawRect(128 + 40 * this.curChoose, ApoHybridConstants.GAME_HEIGHT - 64, 31, 32);
//@		g.setLineSize(lineSize);
//@		
//@		if (this.time > 0) {
//@			g.setColor(new int[] {255, 255, 255});
//@			w = ApoHybridConstants.FONT_STATISTICS.getLength(this.uploadString);
//@			float x = 128 - w/2 - 5;
//@			if (x < 0) {
//@				x = 0;
//@			}
//@			g.fillRect(x + 1, 32, w + 8, 24);
//@			g.setColor(new int[] {0, 0, 0});
//@			g.drawRect(x + 1, 32, w + 8, 24);
//@			g.drawText(this.uploadString, x + 5, 51 - ApoHybridConstants.FONT_STATISTICS.mCharCellHeight);
//@		}
//@	}
//@
//@}
//#endif
