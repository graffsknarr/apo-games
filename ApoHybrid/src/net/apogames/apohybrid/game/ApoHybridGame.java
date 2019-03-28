package net.apogames.apohybrid.game;

import net.apogames.apohybrid.ApoHybridModel;
import net.apogames.apohybrid.level.ApoHybridLevel;
import net.gliblybits.bitsengine.render.BitsGraphics;
import net.apogames.apohybrid.entity.ApoHybridEntityBall;
import net.apogames.apohybrid.entity.ApoHybridEntityClock;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;

public class ApoHybridGame extends ApoHybridModel {

	public static final String BACK = "back";
	//#ifdef DiceGameLogic || SnakeGameLogic
	private boolean bEditor = false;
	private boolean bUserlevel = false;
	
	private String levelString = "";

	public static final byte changeY = 25;

	public void onBackButtonPressed() {
		if (this.bEditor) {
			this.getGame().setEditor(false);
		} else {
			if (this.bUserlevel) {
				this.getGame().setMenu();
			} else {
				this.getGame().setPuzzleChooser();
			}
		}
	}
	//#endif
	
	
	//#ifdef DiceGameLogic


	/**
	 * p[0] == Maus losgelassen
	 * p[1] == aktuelles Level
	 * p[2] == how much dices
	 * p[3] == Level geschafft Klick
	 * p[4] == Maus X-Wert
	 * p[5] == Maus Y-Wert
	 * p[6] == aktuell gedr?ckter W?rfel x-Wert
	 * p[7] == aktuell gedr?ckter W?rfel y-Wert
	 * p[8] == difference gedr?ckter W?rfel x-Wert
	 * p[9] == difference gedr?ckter W?rfel y-Wert
	 * p[10] == cX /pressed and mouse X change
	 * p[11] == cY / pressed and mouse Y change
	 * p[12] == c / hoe much change
	 */
	private final int[] p = new int[13];
	private boolean bBreak = false;
	
	
	private byte[][] level = new byte[16][8];
	

	
	private final String[] HELP = new String[] {
		"The number on the dice shows the count",
		"of possible moves. Move each dice to a",
		"gray spot with no moves remaining.",
		"A dice can push another dice"
	};
	
	public ApoHybridGame(ApoHybridPanel game) {
		super(game);
	}

	@Override
	public void init() {		
		this.getStringWidth().put(ApoHybridGame.BACK, (int)(ApoHybridMenu.font.getLength(ApoHybridGame.BACK)));
		
		String s = "ApoDice";
		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
		s = "Congratulation";
		this.getStringWidth().put(s, (int) ApoHybridMenu.title_font.getLength(s));
		s = "Touch to start the next level";
		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
		s = "Please try again";
		this.getStringWidth().put(s, (int) ApoHybridMenu.title_font.getLength(s));
		s = "restart";
		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
		s = "Touch to restart the level";
		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
		s = HELP[0];
		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
		s = HELP[1];
		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
		s = HELP[2];
		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
		s = HELP[3];
		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
	}
	
	@Override
	public void touchedPressed(int x, int y, int finger) {
		p[2] = 1;
		p[4] = x;
		p[5] = y;
	}

	@Override
	public void touchedReleased(int x, int y, int finger) {
		p[2] = 0;
		p[0] = 1;
	}

	@Override
	public void touchedDragged(int x, int y, int oldX, int oldY, int finger) {
		//#if Drag
//@		p[4] = x;
//@		p[5] = y;
//@		
//@		bBreak = false;
//@		if (p[6] < 0) {
//@			return;
//@		}
//@		p[10] = p[11] = p[12] = 0;
//@		if (Math.abs(p[4] - (p[6] * 60 + p[8])) > Math.abs(p[5] - changeY - (p[7]  *60 + p[9]))) {
//@			if (p[4] - (p[6] * 60 + p[8]) < 0) {
//@				p[10] = -1;
//@			} else {
//@				p[10] = 1;
//@			}
//@		} else if (p[5] - changeY - (p[7] * 60 + p[9]) != 0) {
//@			if (p[5] - changeY - (p[7] * 60 + p[9]) < 0) {
//@				p[11] = -1;
//@			} else {
//@				p[11] = 1;
//@			}
//@		}
//@		p[12] = p[10];
//@		if (p[10] != 0) {
//@			while ((p[6] + p[12] >= 0) && (p[6] + p[12] < 8) && (level[p[7] + 8][p[6] + p[12]] > 0)) {
//@				p[12] += p[10];
//@			}
//@			if ((p[6] + p[12] < 0) || (p[6] + p[12] > 7)) {
//@				bBreak = true;
//@			}
//@		}
//@		if (p[11] != 0) {
//@			p[12] = p[11];
//@			while ((p[7] + p[12] >= 0) && (p[7] + p[12] < 8) && (level[p[7] + p[12] + 8][p[6]] > 0)) {
//@				p[12] += p[11];
//@			}
//@			if ((p[7] + p[12] < 0) || (p[7] + p[12] > 7)) {
//@				bBreak = true;
//@			}
//@		}
//@	
		//#endif
}
	
	@Override
	public void touchedButton(String function) {
		if (function.equals(ApoHybridGame.BACK)) {
			this.onBackButtonPressed();
		}
	}
	
	
	public void loadLevel(int nextLevel, boolean bUserLevel, String levelString) {
		this.bUserlevel = bUserLevel;
		if (ApoHybridLevel.editorLevels == null) {
			this.bUserlevel = false;
		}
		p[1] = nextLevel;
		if (p[1] < 0) {
			if (this.bUserlevel) {
				p[1] = ApoHybridLevel.editorLevels.length - 1;
			} else {
				p[1] = this.getGame().getMaxCanChoosen();
			}
		}
		if (this.bUserlevel) {
			if (p[1] >= ApoHybridLevel.editorLevels.length) {
				p[1] = 0;
			}
		} else if (p[1] >= this.getGame().getMaxCanChoosen() + 1) {
			p[1] = 0;
		}
		this.bEditor = false;
		String l = "";
		if ((levelString != null) && (levelString.length() > 0)) {
			l = levelString;
			this.bEditor = true;
		} else {
			if (this.bUserlevel) {
				l = ApoHybridLevel.editorLevels[p[1]];
			} else {
				l = ApoHybridLevel.getLevel(p[1]);
			}
		}
		this.levelString = levelString;
		
		level = new byte[16][8];
		for (int y = 0; y < 8; y += 1) {
			for (int x = 0; x < level[y].length; x += 1) {
				char c = l.charAt(y * 8 + x);
				if ((c >= 48) && (c <= 57)) {
					byte value = Byte.valueOf(l.substring(y * 8 + x, y * 8 + x + 1));
					if (value <= 1) {
						level[y][x] = value;
					} else {
						level[y + 8][x] = value;
					}
				} else {
					byte value = (byte)((int)c - 95);
					level[y][x] = 1;
					level[y + 8][x] = value;
				}
			}
		}
		
		p[3] = p[2] = p[0] = 0;
		p[6] = -1;
	}

	@Override
	public void think(int delta) {
		if (level[0][0] == -1) {
			this.loadLevel(p[1], this.bUserlevel, this.levelString);
		} else {
			if (p[0] > 0) {
				if ((p[4] > 20) && (p[4] < 60) &&
					(p[5] > 590) && (p[5] < 630) && (!this.bEditor)) {
					p[1] -= 1;
					level[0][0] = -1;
				} else if ((p[4] > 320) && (p[4] < 360) &&
						(p[5] > 590) && (p[5] < 630) && (!this.bEditor)) {
					p[1] += 1;
					level[0][0] = -1;
				} else if ((p[4] > 150) && (p[4] < 230) &&
						(p[5] > 590) && (p[5] < 630)) {
					level[0][0] = -1;
				} else if (p[3] > 0) {
					level[0][0] = -1;
					if (p[3] == 1) {
						if (this.bEditor) {
							this.getGame().setEditor(true);
						} else {
							p[1] += 1;
						}
					}
				} else if (p[6] >= 0) {
					if (((int)(p[4])/60 != p[6]) || ((int)(p[5] - changeY)/60 != p[7])) {
						
						if (!bBreak) {
							level[p[7] + 8][p[6]] -= 1;
							if (p[10] < 0) {
								for (int i = p[6] + p[12]; i <= p[6]; i++) {
									if (i + 1 < 8) {
										level[p[7] + 8][i] = level[p[7] + 8][i + 1];
									} else {
										level[p[7] + 8][i] = 0;
									}
								}
							} else if (p[10] > 0) {
								for (int i = p[6] + p[12] - 1; i >= p[6]; i--) {
									level[p[7] + 8][i + 1] = level[p[7] + 8][i];
								}
							}
							if (p[11] < 0) {
								for (int i = p[7] + p[12]; i <= p[7]; i++) {
									if (i + 1 < 8) {
										level[i + 8][p[6]] = level[i + 8 + 1][p[6]];
									} else {
										level[i + 8][p[6]] = 0;
									}
								}
							} else if (p[11] > 0) {
								for (int i = p[7] + p[12] - 1; i >= p[7]; i--) {
									level[i + 1 + 8][p[6]] = level[i + 8][p[6]];
								}
							}
							level[p[7] + 8][p[6]] = 0;
						}
						
						// is level solved?
						boolean bWin = true;
						boolean bLoose = true;
						for (int y = 0; y < 8; y += 1) {
							for (int x = 0; x < level[y].length; x += 1) {
								if ((level[y][x] == 1) && (level[y+8][x] != 2)) {
									bWin = false;
								}
								if (level[y+8][x] > 2) {
									bLoose = false;
								}
							}
						}
						if (bWin) {
							p[3] = 1;
							if ((!this.bUserlevel) && (!this.bEditor)) {
								this.getGame().solvedLevel(p[1] + 1);
							}
						} else if (bLoose) {
							p[3] = 2;
						}
					}
					
					p[6] = -1;
				}
			} else if (p[2] > 0) {
				if (p[6] < 0) {
					int x = p[4] / 60;
					int y = (p[5] - changeY) / 60;
					if ((x >= 0) && (y >= 0) && (x < 8) && (y < 8) && (level[y+8][x] > 2)) {
						p[6] = x;
						p[7] = y;
						p[2] = 0;
						p[8] = p[4] - p[6] * 60;
						p[9] = p[5] - changeY - p[7] * 60;
					}
				}
			}
		}
		
		p[0] = 0;
	}

	@Override
	public void render(BitsGraphics g) {
		
		g.setColor(128, 128, 128, 255);
		g.drawFilledRect(0,0,480,changeY);
		g.drawFilledRect(0,480 + changeY,480,160 - changeY);
		
		g.setColor(0f/255f, 0f/255f, 0f/255f, 1.0f);
		g.drawRect(0,0,480,changeY);
		g.drawRect(0,480 + changeY,480,160 - changeY);

		String s = "ApoDice";
		this.getGame().drawString(g, s, 240, - 4, ApoHybridMenu.game_font);
		
		if (!this.bEditor) {
			if (this.bUserlevel) {
				s = "Level "+(p[1] + 1)+" / "+(ApoHybridLevel.editorLevels.length);
			} else {
				s = "Level "+(p[1] + 1)+" / "+(this.getGame().getMaxCanChoosen() + 1);
			}
		} else {
			s = "Editorlevel";
		}
		this.getGame().drawString(g, s, 5, - 4, ApoHybridMenu.game_font);

		for (int y = 0; y < 8; y += 1) {
			for (int x = 0; x < level[y].length; x += 1) {
				if (level[y][x] == 1) {
					g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
					g.drawFilledRoundRect(x * 60 + 1, changeY + y * 60 + 1, 58, 58, 6, 10);
				}
				if (level[y+8][x] > 0) {
					g.setColor(255f/255f, 255f/255f, 255f/255f, 1.0f);
					g.drawFilledRoundRect(x * 60 + 5, changeY + y * 60 + 5, 50, 50, 6, 10);
					if ((p[6] == x) && (p[7] == y)) {
						g.setColor(255f/255f, 0f/255f, 0f/255f, 1.0f);
						g.drawRoundRect(x * 60 + 5, changeY + y * 60 + 5, 50, 50, 6, 6);
					}
					g.setColor(0f/255f, 0f/255f, 0f/255f, 1.0f);
					if ((level[y+8][x] == 3) || (level[y+8][x] == 5) || (level[y+8][x] == 7)) {
						g.drawFilledCircle(x * 60 + 30, changeY + y * 60 + 30, 6, 40);
					}
					if ((level[y+8][x] == 4) || (level[y+8][x] == 5) || (level[y+8][x] == 6) || (level[y+8][x] == 7) || (level[y+8][x] == 8)) {
						g.drawFilledCircle(x * 60 + 14, changeY + y * 60 + 14, 6, 40);
						g.drawFilledCircle(x * 60 + 46, changeY + y * 60 + 46, 6, 40);
					}
					if ((level[y+8][x] == 6) || (level[y+8][x] == 7) || (level[y+8][x] == 8)) {
						g.drawFilledCircle(x * 60 + 46, changeY + y * 60 + 14, 6, 40);
						g.drawFilledCircle(x * 60 + 14, changeY + y * 60 + 46, 6, 40);
					}
					if (level[y+8][x] == 8) {
						g.drawFilledCircle(x * 60 + 46, changeY + y * 60 + 30, 6, 40);
						g.drawFilledCircle(x * 60 + 14, changeY + y * 60 + 30, 6, 40);
					}
				}
			}
		}
		
		if (p[6] >= 0) {
			g.setColor(128, 128, 128, 128);
			if (((int)(p[4])/60 != p[6]) || ((int)(p[5] - changeY)/60 != p[7])) {
				if (!bBreak) {
					if (p[10] < 0) {
						for (int i = p[6] + p[12]; i < p[6]; i++) {
							g.drawFilledRoundRect((i) * 60 + 8, changeY + p[7] * 60 + 8, 44, 44, 6, 10);
						}
					} else if (p[10] > 0) {
						for (int i = p[6] + p[12]; i > p[6]; i--) {
							g.drawFilledRoundRect((i) * 60 + 8, changeY + p[7] * 60 + 8, 44, 44, 6, 10);
						}
					}
					if (p[11] < 0) {
						for (int i = p[7] + p[12]; i < p[7]; i++) {
							g.drawFilledRoundRect((p[6]) * 60 + 8, changeY + (i) * 60 + 8, 44, 44, 6, 10);
						}
					} else if (p[11] > 0) {
						for (int i = p[7] + p[12]; i > p[7]; i--) {
							g.drawFilledRoundRect((p[6]) * 60 + 8, changeY + (i) * 60 + 8, 44, 44, 6, 10);
						}
					}
				}
			}
		}
		
		
		if (p[3] > 0) {
			String s2 = "";
			if (p[3] == 1) {
				s2 = "Congratulation";					
				s = "Touch to start the next level";
			} else if (p[3] > 1) {
				s2 = "Please try again";					
				s = "Touch to restart the level";
			}
			if (p[3] > 0) {
				float w = ApoHybridMenu.title_font.getLength(s2);
				g.setColor(128, 128, 128, 255);
				g.drawFilledRect(240 - w/2 - 10, 277, w + 20, 46);
				g.setColor(0, 0, 0, 255);
				g.drawRect(240 - w/2 - 10, 277, w + 20, 46);
				
				this.getGame().drawString(g, s2, 240, 273, ApoHybridMenu.title_font);
				
				this.getGame().drawString(g, s, 190, 595, ApoHybridMenu.game_font);
			}
		} else {
			if ((p[1] == 0) || (this.bUserlevel)) {
				this.getGame().drawString(g, HELP[0], 240, 510, ApoHybridMenu.game_font);
				this.getGame().drawString(g, HELP[1], 240, 530, ApoHybridMenu.game_font);
				this.getGame().drawString(g, HELP[2], 240, 550, ApoHybridMenu.game_font);
			} else if ((p[1] == 1) && (!this.bUserlevel)) {
				this.getGame().drawString(g, HELP[3], 240, 530, ApoHybridMenu.game_font);
			}
			
			g.setColor(160, 160, 160, 255);
			g.drawFilledRoundRect(150, 590, 80, 40, 6, 10);
			if (!this.bEditor) {
				g.drawFilledRoundRect(20, 590, 40, 40, 6, 10);
				g.drawFilledRoundRect(320, 590, 40, 40, 6, 10);
			}
			g.setLineSize(3.0f);
			g.setColor(0, 0, 0, 255);
			g.drawRoundRect(150, 590, 80, 40, 6, 10);
			if (!this.bEditor) {
				g.drawRoundRect(20, 590, 40, 40, 6, 10);
				g.drawRoundRect(320, 590, 40, 40, 6, 10);
			}

			if (!this.bEditor) {
				g.drawLine(30, 610, 50, 600);
				g.drawLine(30, 610, 50, 620);

				g.drawLine(350, 610, 330, 600);
				g.drawLine(350, 610, 330, 620);
			}
			g.setLineSize(1.0f);
			
			this.getGame().drawString(g, "restart", 190, 590, ApoHybridMenu.game_font);
		}
		
		this.getGame().renderButtons(g);
	}


	//#elifdef SnakeGameLogic
//@	
//@	/**
//@	 * p[0] == aktuelles Level
//@	 * p[1] == aktuelle Moveanzahl
//@	 * p[2] == level geloest
//@	 * p[3] == change X Levelsize
//@	 * p[4] == change Y Levelsize
//@	 * p[5] == left key
//@	 * p[6] == down key
//@	 * p[7] == right key
//@	 * p[8] == up key
//@	 * p[9] == some key pressed
//@	 * p[10] == some key pressed ole
//@	 */
//@	private final int[] p = new int[11];
//@	
//@	private int[][] level;
//@	
//@	
//@	
//@	@SuppressWarnings("unchecked")
//@	private ArrayList<ApoHybridEntity>[] players = new ArrayList[3];
//@	
//@	
//@	public ApoHybridGame(ApoHybridPanel game) {
//@		super(game);
//@	}
//@
//@	@Override
//@	public void init() {		
//@		this.getStringWidth().put(ApoHybridGame.BACK, (int)(ApoHybridMenu.font.getLength(ApoHybridGame.BACK)));
//@		
//@		String s = "ApoSnake";
//@		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
//@		s = "Congratulation";
//@		this.getStringWidth().put(s, (int) ApoHybridMenu.title_font.getLength(s));
//@		s = "Touch to start the next level";
//@		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
//@		s = "Please try again";
//@		this.getStringWidth().put(s, (int) ApoHybridMenu.title_font.getLength(s));
//@		s = "restart";
//@		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
//@		s = "Touch to restart the level";
//@		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
//@		s = "controls";
//@		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
//@	}
//@	
//@	@Override
//@	public void touchedPressed(int x, int y, int finger) {
//@		if (((x > 5) && (x < 65) && (y > 575) && (y < 635)) ||
//@			((x > 0) && (x < 60) && (y > ApoHybridGame.changeY) && (y < ApoHybridGame.changeY + 480))) {
//@			p[5] = 1;
//@		} else if (((x > 70) && (x < 130) && (y > 575) && (y < 635)) ||
//@				((x > 420) && (x < 480) && (y > ApoHybridGame.changeY) && (y < ApoHybridGame.changeY + 480)))  {
//@			p[7] = 1;
//@		}
//@		
//@		if (((x > 415) && (x < 475) && (y > 575) && (y < 635)) ||
//@			((x > 60) && (x < 420) && (y > ApoHybridGame.changeY + 420) && (y < ApoHybridGame.changeY + 480))) {
//@			p[6] = 1;
//@		} else if (((x > 350) && (x < 410) && (y > 575) && (y < 635)) ||
//@				((x > 60) && (x < 420) && (y > ApoHybridGame.changeY) && (y < ApoHybridGame.changeY + 60))) {
//@			p[8] = 1;
//@		}
//@		p[9] = 1;
//@		
//@		if ((x > 15) && (x < 55) && (y > 520) && (y < 560)) {
//@			p[0] -= 1;
//@			level[0][0] = -1;
//@		} else if ((x > 310) && (x < 350) && (y > 520) && (y < 560)) {
//@			p[0] += 1;
//@			level[0][0] = -1;
//@		} else if ((x > 142) && (x < 222) && (y > 520) && (y < 560)) {
//@			level[0][0] = -1;
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
//@		if (function.equals(ApoHybridGame.BACK)) {
//@			this.onBackButtonPressed();
//@		}
//@	}
//@	
//@	
//@	
//@	@SuppressWarnings("unchecked")
//@	public void loadLevel(int nextLevel, boolean bUserLevel, String levelString) {
//@		this.bUserlevel = bUserLevel;
//@		if (ApoHybridLevel.editorLevels == null) {
//@			this.bUserlevel = false;
//@		}
//@		p[0] = nextLevel;
//@		if (p[0] < 0) {
//@			if (this.bUserlevel) {
//@				p[0] = ApoHybridLevel.editorLevels.length - 1;
//@			} else {
//@				p[0] = this.getGame().getMaxCanChoosen();
//@			}
//@		}
//@		if (this.bUserlevel) {
//@			if (p[0] >= ApoHybridLevel.editorLevels.length) {
//@				p[0] = 0;
//@			}
//@		} else if (p[0] >= this.getGame().getMaxCanChoosen() + 1) {
//@			p[0] = 0;
//@		}
//@		this.bEditor = false;
//@		String l = "";
//@		if ((levelString != null) && (levelString.length() > 0)) {
//@			l = levelString;
//@			this.bEditor = true;
//@		} else {
//@			if (this.bUserlevel) {
//@				l = ApoHybridLevel.editorLevels[p[0]];
//@			} else {
//@				l = ApoHybridLevel.getLevel(p[0]);
//@			}
//@		}
//@		this.levelString = levelString;
//@		
//@		int width = l.substring(0, 1).charAt(0) - 96;
//@		int height = l.substring(1, 2).charAt(0) - 96;
//@		level = new int[height][width];
//@		
//@		// count the snakes in the level
//@		int count = 0;
//@		for (int y = 0; y < level.length; y++) {
//@			for (int x = 0; x < level[0].length; x++) {
//@				int value = l.charAt(y * level[0].length + x + 2);
//@				if (value < 60) {
//@					value -= 48;
//@				} else {
//@					value -= 87;
//@				}
//@				if ((value >= 1) && (value <= 4)) {
//@				} else if ((value >= 7) && (value <= 10)) {
//@					value -= 6;
//@				} else if ((value >= 13) && (value <= 16)) {
//@					value -= 12;
//@				}
//@				if ((value >= 1) && (value <= 4)) {
//@					count += 1;
//@				}
//@			}
//@		}
//@		// create an array with the countsize of snakes
//@		players = new ArrayList[count];
//@		for (int i = 0; i < players.length; i++) {
//@			players[i] = new ArrayList<ApoHybridEntity>();
//@		}
//@
//@		p[2] = 0;
//@		p[1] = 0;
//@		int schlange = 0;
//@		for (int y = 0; y < level.length; y++) {
//@			for (int x = 0; x < level[0].length; x++) {
//@				int value = l.charAt(y * level[0].length + x + 2);
//@				if (value < 60) {
//@					value -= 48;
//@				} else {
//@					value -= 87;
//@				}
//@				int color = 0;
//@				if ((value >= 1) && (value <= 4)) {
//@				} else if ((value >= 7) && (value <= 10)) {
//@					color = 1;
//@					value -= 6;
//@				} else if ((value >= 13) && (value <= 16)) {
//@					color = 2;
//@					value -= 12;
//@				} else {
//@					level[y][x] = value;
//@				}
//@				if ((value >= 1) && (value <= 4)) {
//@					if (schlange < this.players.length) {
//@						ApoHybridEntity entity = new ApoHybridEntity(x, y, value, color);
//@						players[schlange].add(entity);
//@						schlange += 1;
//@					}
//@				}
//@			}
//@		}
//@		p[3] = (480 - level[0].length * 30)/2;
//@		p[4] = (480 - level.length * 30)/2 + ApoHybridGame.changeY;
//@	}
//@	
//@	private boolean canMoveNextStep() {
//@		boolean bJumpResult = false;
//@		boolean[] bPlayerJump = new boolean[this.players.length];
//@		for (int j = 0; j < 4; j++) {
//@			if (bJumpResult) {
//@				return true;
//@			}
//@			for (int z = 0; z < 2; z++) {
//@				for (int i = 0; i < players.length; i++) {
//@					if (bPlayerJump[i]) {
//@						continue;
//@					}
//@					if (players[i].size() == 0) {
//@						continue;
//@					}
//@					int value = this.players[i].get(0).getDirection();
//@					int color = this.players[i].get(0).getColor();
//@					int x = this.players[i].get(0).getX();
//@					int y = this.players[i].get(0).getY();
//@					int checkX = x;
//@					int checkY = y;
//@					if (j == 0) {
//@						checkX = x - 1;
//@					} else if (j == 1) {
//@						checkX = x + 1;
//@					} else if (j == 2) {
//@						checkY = y + 1;
//@					} else if (j == 3) {
//@						checkY = y - 1;
//@					}
//@					if ((value == 1) && (j == 1)) {
//@						continue;
//@					}
//@					if ((value == 2) && (j == 3)) {
//@						continue;
//@					}
//@					if ((value == 3) && (j == 0)) {
//@						continue;
//@					}
//@					if ((value == 4) && (j == 2)) {
//@						continue;
//@					}
//@					boolean bJump = false;
//@					while ((checkX >= 0) && (checkY >= 0) && (checkX < level[0].length) && (checkY < level.length)) {
//@						boolean bBreak = false;
//@						boolean bIsThere = false;
//@						for (int l = 0; l < players.length; l++) {
//@							if (players[l].size() > 0) {
//@								ApoHybridEntity checkEntity = players[l].get(0);
//@	
//@								int otherX = checkEntity.getX();
//@								int otherY = checkEntity.getY();
//@								
//@								if (l != i) {
//@									if ((otherX == checkX) && (otherY == checkY)) {
//@										bBreak = true;
//@										bJump = false;
//@										break;
//@									}
//@								}
//@								
//@								int otherColor = checkEntity.getColor();
//@								for (int k = 1; k < players[l].size(); k++) {
//@									checkEntity = players[l].get(k);
//@									otherX = checkEntity.getX();
//@									otherY = checkEntity.getY();
//@									if ((otherX == checkX) && (otherY == checkY)) {
//@										if ((i == l) && (k >= players[l].size() - 1)) {
//@										} else if (otherColor == color) {
//@											bBreak = true;
//@											break;
//@										} else {
//@											bIsThere = true;
//@											break;
//@										}
//@									}
//@								}
//@							}
//@						}
//@						if (bBreak) {
//@							break;
//@						}
//@						if (bIsThere) {
//@							
//@						} else if ((level[checkY][checkX] == 0) || (level[checkY][checkX] == 5) || (level[checkY][checkX] == 11) || (level[checkY][checkX] == 17)) {
//@							bJump = true;
//@							bJumpResult = true;
//@							return true;
//@						} else if (color == 0) {
//@							if ((level[checkY][checkX] == 6) || (level[checkY][checkX] == 19)) {
//@								break;
//@							}
//@						} else if (color == 1) {
//@							if ((level[checkY][checkX] == 12) || (level[checkY][checkX] == 20)) {
//@								break;
//@							}
//@						} else if (color == 2) {
//@							if ((level[checkY][checkX] == 18) || (level[checkY][checkX] == 21)) {
//@								break;
//@							}
//@						}
//@						
//@						if (j == 0) {
//@							checkX -= 1;
//@						} else if (j == 1) {
//@							checkX += 1;
//@						} else if (j == 2) {
//@							checkY += 1;
//@						} else if (j == 3) {
//@							checkY -= 1;
//@						}
//@					}
//@					
//@					if (bJump) {
//@						bPlayerJump[i] = true;
//@					}
//@				}
//@			}
//@		}
//@		
//@		return bJumpResult;
//@	}
//@
//@	@Override
//@	public void think(int delta) {
//@		if (level[0][0] == -1) {
//@			this.loadLevel(p[0], this.bUserlevel, this.levelString);
//@		} else {
//@			if ((p[2] > 0) && (p[9] > 0)) {
//@				if (p[2] == 1) {
//@					p[0] += 1;
//@				}
//@				level[0][0] = -1;
//@				if ((this.bEditor) && (p[2] == 1)) {
//@					this.getGame().setEditor(true);
//@				} else {
//@					this.loadLevel(p[0], this.bUserlevel, this.levelString);
//@				}
//@			} else {
//@				int addJump = 0;
//@				boolean[] bPlayerJump = new boolean[this.players.length];
//@				if ((p[5] > 0) || (p[6] > 0) || (p[7] > 0) || (p[8] > 0)) {
//@					for (int z = 0; z < 2; z++) {
//@						for (int i = 0; i < players.length; i++) {
//@							if (bPlayerJump[i]) {
//@								continue;
//@							}
//@							if (players[i].size() == 0) {
//@								continue;
//@							}
//@							int value = this.players[i].get(0).getDirection();
//@							int color = this.players[i].get(0).getColor();
//@							int x = this.players[i].get(0).getX();
//@							int y = this.players[i].get(0).getY();
//@							int checkX = x;
//@							int checkY = y;
//@							if (p[5] > 0) {
//@								checkX = x - 1;
//@							} else if (p[7] > 0) {
//@								checkX = x + 1;
//@							} else if (p[6] > 0) {
//@								checkY = y + 1;
//@							} else if (p[8] > 0) {
//@								checkY = y - 1;
//@							}
//@							if ((value == 1) && (p[7] > 0)) {
//@								continue;
//@							}
//@							if ((value == 2) && (p[8] > 0)) {
//@								continue;
//@							}
//@							if ((value == 3) && (p[5] > 0)) {
//@								continue;
//@							}
//@							if ((value == 4) && (p[6] > 0)) {
//@								continue;
//@							}
//@							boolean bJump = false;
//@							int add = 1;
//@							while ((checkX >= 0) && (checkY >= 0) && (checkX < level[0].length) && (checkY < level.length)) {
//@								boolean bBreak = false;
//@								boolean bIsThere = false;
//@								for (int l = 0; l < players.length; l++) {
//@									if (players[l].size() > 0) {
//@										ApoHybridEntity checkEntity = players[l].get(0);
//@	
//@										int otherX = checkEntity.getX();
//@										int otherY = checkEntity.getY();
//@										
//@										if (l != i) {
//@											if ((otherX == checkX) && (otherY == checkY)) {
//@												bBreak = true;
//@												bJump = false;
//@												break;
//@											}
//@										}
//@										
//@										int otherColor = checkEntity.getColor();
//@										for (int k = 1; k < players[l].size(); k++) {
//@											checkEntity = players[l].get(k);
//@											otherX = checkEntity.getX();
//@											otherY = checkEntity.getY();
//@											if ((otherX == checkX) && (otherY == checkY)) {
//@												if ((i == l) && (k >= players[l].size() - 1)) {
//@												} else if (otherColor == color) {
//@													bBreak = true;
//@													break;
//@												} else {
//@													bIsThere = true;
//@													break;
//@												}
//@											}
//@										}
//@									}
//@								}
//@								if (bBreak) {
//@									break;
//@								}
//@								if (bIsThere) {
//@									
//@								} else if ((level[checkY][checkX] == 0) || (level[checkY][checkX] == 5) || (level[checkY][checkX] == 11) || (level[checkY][checkX] == 17)) {
//@									bJump = true;
//@									if (level[checkY][checkX] == 5) {
//@										color = 0;
//@									} else if (level[checkY][checkX] == 11) {
//@										color = 1;
//@									} else if (level[checkY][checkX] == 17) {
//@										color = 2;
//@									}
//@									if (level[checkY][checkX] == 0) {
//@										add = 0;
//@									}
//@									break;
//@								} else if (color == 0) {
//@									if ((level[checkY][checkX] == 6) || (level[checkY][checkX] == 19)) {
//@										break;
//@									}
//@								} else if (color == 1) {
//@									if ((level[checkY][checkX] == 12) || (level[checkY][checkX] == 20)) {
//@										break;
//@									}
//@								} else if (color == 2) {
//@									if ((level[checkY][checkX] == 18) || (level[checkY][checkX] == 21)) {
//@										break;
//@									}
//@								}
//@								
//@								if (p[5] > 0) {
//@									checkX -= 1;
//@								} else if (p[7] > 0) {
//@									checkX += 1;
//@								} else if (p[6] > 0) {
//@									checkY += 1;
//@								} else if (p[8] > 0) {
//@									checkY -= 1;
//@								}
//@							}
//@							if (bJump) {
//@								bPlayerJump[i] = true;
//@								addJump = 1;
//@								players[i].get(0).setDirection(5);
//@
//@								if (checkX < x) {
//@									for (int k = x - 1; k >= checkX; k--) {
//@										int v = 5;
//@										if (k == checkX) {
//@											v = 1;
//@										}
//@										a(k, y, add, i);
//@										ApoHybridEntity newEntity = new ApoHybridEntity(k, y, v, color);
//@										players[i].add(0, newEntity);
//@									}
//@								} else if (checkX > x) {
//@									for (int k = x + 1; k <= checkX; k++) {
//@										int v = 5;
//@										if (k == checkX) {
//@											v = 3;
//@										}
//@										a(k, y, add, i);
//@										ApoHybridEntity newEntity = new ApoHybridEntity(k, y, v, color);
//@										players[i].add(0, newEntity);
//@									}
//@								} else if (checkY < y) {
//@									for (int k = y - 1; k >= checkY; k--) {
//@										int v = 5;
//@										if (k == checkY) {
//@											v = 4;
//@										}
//@										a(x, k, add, i);
//@										ApoHybridEntity newEntity = new ApoHybridEntity(x, k, v, color);
//@										players[i].add(0, newEntity);
//@									}
//@								} else if (checkY > y) {
//@									for (int k = y + 1; k <= checkY; k++) {
//@										int v = 5;
//@										if (k == checkY) {
//@											v = 2;
//@										}
//@										a(x, k, add, i);
//@										ApoHybridEntity newEntity = new ApoHybridEntity(x, k, v, color);
//@										players[i].add(0, newEntity);
//@									}
//@								}
//@								for (int t = 1; t < players[i].size(); t++) {
//@									players[i].get(t).setColor(color);
//@								}
//@								if (add <= 0) {
//@									players[i].remove(players[i].size() - 1);
//@								}
//@								boolean bWin = true;
//@								for (y = 0; y < level.length; y++) {
//@									for (x = 0; x < level[0].length; x++) {
//@										if ((level[y][x] == 5) || (level[y][x] == 11) || (level[y][x] == 17)) {
//@											bWin = false;
//@											break;
//@										}
//@									}
//@									if (!bWin) {
//@										break;
//@									}
//@								}
//@								if (bWin) {
//@									p[2] = 1;
//@									if ((!this.bUserlevel) && (!this.bEditor)) {
//@										this.getGame().solvedLevel(p[0] + 1);
//@									}
//@								} else if (!this.canMoveNextStep()) {
//@									p[2] = 2;
//@								}
//@							}
//@						}
//@					}
//@				}
//@				p[1] += addJump;
//@			}
//@			for (int i = 5; i < 10; i++) {
//@				p[i] = 0;
//@			}
//@		}
//@	}
//@	
//@	private final void a(int x, int y, int add, int snake) {		
//@		for (int j = 0; j < players.length; j++) {
//@			for (int l = 1; l < players[j].size(); l++) {
//@				ApoHybridEntity entity = this.players[j].get(l);
//@				int otherColor = entity.getColor();
//@				int otherX = entity.getX();
//@				int otherY = entity.getY();
//@				if ((otherX == x) && (otherY == y)) {
//@					int minus = 1;
//@					if (add > 0) {
//@						minus = 0;
//@					}
//@					if (snake != j) {
//@						minus = 0;
//@					}
//@					for (int f = players[j].size() - 1 - minus; f >= l; f--) {
//@						entity = players[j].get(f);
//@						int removeX = entity.getX();
//@						int removeY = entity.getY();
//@						level[removeY][removeX] = 19 + otherColor;
//@						players[j].remove(f);
//@					}
//@					break;
//@				}
//@			}
//@		}
//@
//@		level[y][x] = 0;
//@	}
//@
//@	@Override
//@	public void render(BitsGraphics g) {	
//@		g.setColor(128, 128, 128, 255);
//@		g.drawFilledRect(0,0,480,changeY);
//@		g.drawFilledRect(0,480 + changeY,480,160 - changeY);
//@		
//@		g.setColor(0f/255f, 0f/255f, 0f/255f, 1.0f);
//@		g.drawRect(0,0,480,changeY);
//@		g.drawRect(0,480 + changeY,480,160 - changeY);
//@
//@		String s = "ApoSnake";
//@		this.getGame().drawString(g, s, 240, - 4, ApoHybridMenu.game_font);
//@		
//@		if (!this.bEditor) {
//@			if (this.bUserlevel) {
//@				s = "Level "+(p[0] + 1)+" / "+(ApoHybridLevel.editorLevels.length);
//@			} else {
//@				s = "Level "+(p[0] + 1)+" / "+(this.getGame().getMaxCanChoosen() + 1);
//@			}
//@		} else {
//@			s = "Editorlevel";
//@		}
//@		this.getGame().drawString(g, s, 5, - 4, ApoHybridMenu.game_font);
//@		
//@		s = "Moves: "+p[1];
//@		this.getGame().drawString(g, s, 360, - 4, ApoHybridMenu.game_font);
//@
//@		int changeX = p[3];
//@		int changeY = p[4];
//@		g.setColor(210, 210, 210, 255);
//@		g.drawFilledRect(changeX, changeY, level[0].length * 30, level.length * 30);
//@		g.setColor(0, 0, 0, 255);
//@		g.drawRect(changeX, changeY, level[0].length * 30, level.length * 30);
//@
//@		for (int y = 0; y < level.length; y++) {
//@			for (int x = 0; x < level[0].length; x++) {
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
//@					g.setColor(200, 0, 0);
//@					if (level[y][x] == 12) {
//@						g.setColor(90, 165, 200);
//@					} else if (level[y][x] == 18) {
//@						g.setColor(0, 200, 0);							
//@					}
//@					g.drawFilledRect(changeX + 4 + x * 30, changeY + 4 + y * 30, 22, 22);
//@					g.setColor(150, 0, 0);
//@					if (level[y][x] == 12) {
//@						g.setColor(0, 90, 200);
//@					} else if (level[y][x] == 18) {
//@						g.setColor(0, 150, 0);							
//@					}
//@					g.drawFilledRect(changeX + 8 + x * 30, changeY + 8 + y * 30, 15, 15);
//@					g.setColor(0, 0, 0, 255);
//@					g.drawRect(changeX + 4 + x * 30, changeY + 4 + y * 30, 22, 22);
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
//@			}
//@		}
//@
//@		for (int i = 0; i < players.length; i++) {
//@			for (int p = players[i].size() - 1; p >= 0; p--) {
//@				ApoHybridEntity entity = players[i].get(p);
//@				int w = entity.getColor();
//@				
//@				int x = entity.getX();
//@				int y = entity.getY();
//@				
//@				int nextX = -1;
//@				int nextY = -1;
//@				if (p > 0) {
//@					nextX = players[i].get(p - 1).getX();
//@					nextY = players[i].get(p - 1).getY();
//@				}
//@				
//@				int[] c = new int[] {255, 90, 90};
//@				if (w == 1) {
//@					c = new int[] {90, 165, 255};
//@				}
//@				if (w == 2) {
//@					c = new int[] {90, 255, 90};
//@				}
//@
//@				g.setColor(c[0], c[1], c[2], 255);
//@				if (nextX >= 0) {
//@					if (nextX < x) {
//@						g.drawFilledOval(changeX + nextX * 30 + 30, changeY + nextY * 30 + 15, 9, 9);
//@					} else if (nextX > x) {
//@						g.drawFilledOval(changeX + nextX * 30, changeY + nextY * 30 + 15, 9, 9);
//@					} else if (nextY < y) {
//@						g.drawFilledOval(changeX + nextX * 30 + 15, changeY + nextY * 30 + 30, 9, 9);
//@					} else if (nextY > y) {
//@						g.drawFilledOval(changeX + nextX * 30 + 15, changeY + nextY * 30, 9, 9);
//@					}
//@				}
//@
//@				g.setColor(0, 0, 0, 255);
//@				if (nextX >= 0) {
//@					if (nextX < x) {
//@						g.drawOval(changeX + nextX * 30 + 30, changeY + nextY * 30 + 15, 9, 9);
//@					} else if (nextX > x) {
//@						g.drawOval(changeX + nextX * 30, changeY + nextY * 30 + 15, 9, 9);
//@					} else if (nextY < y) {
//@						g.drawOval(changeX + nextX * 30 + 15, changeY + nextY * 30 + 30, 9, 9);
//@					} else if (nextY > y) {
//@						g.drawOval(changeX + nextX * 30 + 15, changeY + nextY * 30, 9, 9);
//@					}
//@				}
//@			}
//@		}
//@		
//@		for (int i = 0; i < players.length; i++) {
//@			for (int p = players[i].size() - 1; p >= 0; p--) {
//@				int[] c = new int[] {0, 0, 0, 255};
//@				ApoHybridEntity entity = players[i].get(p);
//@				int w = entity.getColor();
//@				int value = entity.getDirection();;				
//@				int x = entity.getX();
//@				int y = entity.getY();
//@				
//@				c = new int[] {255, 0, 0};
//@				if (w == 1) {
//@					c = new int[] {0, 90, 255};
//@				}
//@				if (w == 2) {
//@					c = new int[] {0, 255, 0};
//@				}
//@
//@				g.setColor(c[0], c[1], c[2], 255);
//@				g.drawFilledOval(changeX + x * 30 + 15, changeY + y * 30 + 15, 12, 12);
//@
//@				g.setColor(0, 0, 0, 255);
//@				g.drawOval(changeX + x * 30 + 15, changeY + y * 30 + 15, 12, 12);
//@				
//@				if (value == 1) {
//@					g.drawFilledRect(changeX + x * 30 + 2, changeY + y * 30 + 11, 9, 3);
//@					g.drawFilledRect(changeX + x * 30 + 2, changeY + y * 30 + 16, 9, 3);
//@				} else if (value == 3) {
//@					g.drawFilledRect(changeX + (x + 1) * 30 - 11, changeY + y * 30 + 11, 9, 3);
//@					g.drawFilledRect(changeX + (x + 1) * 30 - 11, changeY + y * 30 + 16, 9, 3);
//@				} else if (value == 2) {
//@					g.drawFilledRect(changeX + (x) * 30 + 11, changeY + (y + 1) * 30 - 11, 3, 9);
//@					g.drawFilledRect(changeX + (x) * 30 + 16, changeY + (y + 1) * 30 - 11, 3, 9);
//@				} else if (value == 4) {
//@					g.drawFilledRect(changeX + (x) * 30 + 11, changeY + (y) * 30 + 2, 3, 9);
//@					g.drawFilledRect(changeX + (x) * 30 + 16, changeY + (y) * 30 + 2, 3, 9);
//@				}
//@			}
//@		}		
//@		
//@		if (p[2] > 0) {
//@			String s2 = "";
//@			s2 = "Congratulation";					
//@			s = "Touch to start the next level";
//@			if (p[2] > 0) {
//@				float w = ApoHybridMenu.title_font.getLength(s2);
//@				g.setColor(128, 128, 128, 255);
//@				g.drawFilledRect(240 - w/2 - 10, 137, w + 20, 46);
//@				g.setColor(0, 0, 0, 255);
//@				g.drawRect(240 - w/2 - 10, 137, w + 20, 46);
//@				
//@				this.getGame().drawString(g, s2, 240, 133, ApoHybridMenu.title_font);
//@				
//@				this.getGame().drawString(g, s, 190, 595, ApoHybridMenu.game_font);
//@			}
//@		} else {
//@			String[] string = null;
//@			if ((this.bEditor) || (this.bUserlevel)) {
//@			} else if (p[0] == 0) {
//@				string = new String[] {
//@					"Guide the snake to the red coin. Move with",
//@					"the cursor buttons or touch on the side of",
//@					"the level screen to move in that direction"
//@				};
//@			} else if (p[0] == 1) {
//@				string = new String[] {
//@					"Eat all coins to solve the level"
//@				};
//@			} else if (p[0] == 2) {
//@				string = new String[] {
//@					"You are what you eat"
//@				};
//@			} else if (p[0] == 3) {
//@				string = new String[] {
//@					"You can eat walls with a different color"
//@				};
//@			} else if (p[0] == 4) {
//@				string = new String[] {
//@					"You can't go backwards with your snake",
//@					"Touch 'restart' to restart a level"
//@				};
//@			} else if (p[0] == 9) {
//@				string = new String[] {
//@					"You control all snakes at once"
//@				};
//@			} else if (p[0] == 20) {
//@				string = new String[] {
//@					"You can eat parts of a snake",
//@					"with a different color"
//@				};
//@			}
//@			if (string != null) {
//@				g.setColor(128, 128, 128, 255);
//@				int w = (int)(ApoHybridMenu.game_font.getLength(string[0]));
//@				for (int i = 1; i < string.length; i++) {
//@					int newW = (int)(ApoHybridMenu.game_font.getLength(string[i]));
//@					if (newW > w) {
//@						w = newW;
//@					}
//@				}
//@				int x = (480 - w) / 2;
//@				g.drawFilledRect(x - 10,410,w + 20,30 * string.length);
//@				for (int i = 0; i < string.length; i++) {
//@					this.getGame().drawString(g, string[i], 240 - w/2, 405 + i*30, ApoHybridMenu.game_font);
//@				}
//@			}
//@			
//@			g.setColor(160, 160, 160, 255);
//@			g.drawFilledRoundRect(142, 520, 80, 40, 6, 10);
//@			if (!this.bEditor) {
//@				g.drawFilledRoundRect(15, 520, 40, 40, 6, 10);
//@				g.drawFilledRoundRect(310, 520, 40, 40, 6, 10);
//@			}
//@			g.setLineSize(2.0f);
//@			g.setColor(0, 0, 0, 255);
//@			g.drawRoundRect(142, 520, 80, 40, 6, 10);
//@			if (!this.bEditor) {
//@				g.drawRoundRect(15, 520, 40, 40, 6, 10);
//@				g.drawRoundRect(310, 520, 40, 40, 6, 10);
//@			}
//@
//@			if (!this.bEditor) {
//@				g.drawLine(25, 540, 45, 530);
//@				g.drawLine(25, 540, 45, 550);
//@
//@				g.drawLine(340, 540, 320, 530);
//@				g.drawLine(340, 540, 320, 550);
//@			}
//@			g.setLineSize(1.0f);
//@			
//@			this.getGame().drawString(g, "restart", 182, 520, ApoHybridMenu.game_font);
//@
//@			this.drawMoveButtons(g);
//@		}
//@		
//@		this.getGame().renderButtons(g);
//@	}
//@
//@	private void drawMoveButtons(BitsGraphics g) {
//@		this.getGame().drawString(g, "controls", 240, 590, ApoHybridMenu.game_font);
//@		
//@		g.setColor(160, 160, 160, 255);
//@		g.drawFilledRoundRect(5, 575, 60, 60, 6, 10);
//@		g.drawFilledRoundRect(70, 575, 60, 60, 6, 10);
//@		g.drawFilledRoundRect(415, 575, 60, 60, 6, 10);
//@		g.drawFilledRoundRect(350, 575, 60, 60, 6, 10);
//@		
//@		g.setLineSize(2.0f);
//@		g.setColor(0, 0, 0, 255);
//@		g.drawRoundRect(5, 575, 60, 60, 6, 10);
//@		g.drawRoundRect(70, 575, 60, 60, 6, 10);
//@		g.drawRoundRect(415, 575, 60, 60, 6, 10);
//@		g.drawRoundRect(350, 575, 60, 60, 6, 10);
//@		
//@		// draw left button ( 5, 575)
//@		g.drawLine(15, 605, 30, 620);
//@		g.drawLine(30, 620, 30, 610);
//@		g.drawLine(30, 610, 55, 610);
//@		g.drawLine(55, 610, 55, 600);
//@		g.drawLine(55, 600, 30, 600);
//@		g.drawLine(30, 600, 30, 590);
//@		g.drawLine(30, 590, 15, 605);
//@		
//@		// draw right button (70, 575)
//@		g.drawLine(120, 605, 105, 620);
//@		g.drawLine(105, 620, 105, 610);
//@		g.drawLine(105, 610, 80, 610);
//@		g.drawLine(80, 610, 80, 600);
//@		g.drawLine(80, 600, 105, 600);
//@		g.drawLine(105, 600, 105, 590);
//@		g.drawLine(105, 590, 120, 605);
//@		
//@		// draw down button (415, 575)
//@		g.drawLine(445, 625, 430, 610);
//@		g.drawLine(430, 610, 440, 610);
//@		g.drawLine(440, 610, 440, 585);
//@		g.drawLine(440, 585, 450, 585);
//@		g.drawLine(450, 585, 450, 610);
//@		g.drawLine(450, 610, 460, 610);
//@		g.drawLine(460, 610, 445, 625);
//@		
//@		// draw up button (350, 575)
//@		g.drawLine(380, 585, 365, 600);
//@		g.drawLine(365, 600, 375, 600);
//@		g.drawLine(375, 600, 375, 625);
//@		g.drawLine(375, 625, 385, 625);
//@		g.drawLine(385, 625, 385, 600);
//@		g.drawLine(385, 600, 395, 600);
//@		g.drawLine(395, 600, 380, 585);
//@
//@		g.setLineSize(1.0f);
//@	}
//@
	//#elifdef ClockGameLogic

	public static final String BACK = "back";
	
	private ApoHybridEntityClock[] clocks = new ApoHybridEntityClock[1];
	
	/**
	 * 0 = X-Wert,
	 * 1 = y-Wert,
	 * 2 = Angle,
	 * 3 = Geschwindigkeit
	 */
	private ApoHybridEntityBall ball;
	
	/**
	 * this.curLevel == aktuelles Level,
	 * this.winInt == Level geschafft Klick,
	 * this.touchX == Maus X-Wert,
	 * this.touchY == Maus Y-Wert
	 */
	private int curLevel, touchX, touchY, winInt;
	
	/**
	 * bPressed == losgelassen,
	 * bStarted == Spiel gestartet
	 */
	private boolean bStarted, bPressed;
	
	private static final String[] HELP = new String[] {
		"Your goal is to reach all the clocks",
		"When the ball hits a clock the countdown starts",
		"Touch to fire the ball with the",
		"current clockwise direction"
	};
	
	private boolean bNewStart = true;
	
	private boolean bEditor = false;
	
	private boolean bUserlevels;
	
	private String levelString;
	
	public ApoHybridPuzzleGame(ApoHybridPanel game) {
		super(game);
	}

	@Override
	public void init() {		
		this.getStringWidth().put(ApoHybridGame.BACK, (int)(ApoHybridPanel.font.getLength(ApoHybridGame.BACK)));
		
		String s = "ApoHybrid";
		this.getStringWidth().put(s, (int) ApoHybridPanel.game_font.getLength(s));
		s = "Congratulation";
		this.getStringWidth().put(s, (int) ApoHybridPanel.title_font.getLength(s));
		s = "Touch to start the next level";
		this.getStringWidth().put(s, (int) ApoHybridPanel.game_font.getLength(s));
		s = "Please try again";
		this.getStringWidth().put(s, (int) ApoHybridPanel.title_font.getLength(s));
		s = "Touch to restart the level";
		this.getStringWidth().put(s, (int) ApoHybridPanel.game_font.getLength(s));
		s = "Touch to start the level";
		this.getStringWidth().put(s, (int) ApoHybridPanel.game_font.getLength(s));
		s = HELP[0];
		this.getStringWidth().put(s, (int) ApoHybridPanel.game_font.getLength(s));
		s = HELP[1];
		this.getStringWidth().put(s, (int) ApoHybridPanel.game_font.getLength(s));
		s = HELP[2];
		this.getStringWidth().put(s, (int) ApoHybridPanel.game_font.getLength(s));
		s = HELP[3];
		this.getStringWidth().put(s, (int) ApoHybridPanel.game_font.getLength(s));
	}
	
	@Override
	public void touchedPressed(int x, int y, int finger) {
		this.bPressed = true;
		this.touchX = x;
		this.touchY = y;
	}

	@Override
	public void touchedReleased(int x, int y, int finger) {
		
	}

	@Override
	public void touchedDragged(int x, int y, int oldX, int oldY, int finger) {
		
	}

	@Override
	public void touchedButton(String function) {
		if (function.equals(ApoHybridGame.BACK)) {
			this.onBackButtonPressed();
		}
	}
	
	public void onBackButtonPressed() {
		if (this.bEditor) {
			this.getGame().setEditor(false);
		} else if (this.bUserlevels) {
			this.getGame().setPuzzle();
		} else {
			this.getGame().setPuzzleChooser();
		}
	}
	
	protected void loadLevel(final int newLevel, final boolean bUserLevels) {
		this.bUserlevels = bUserLevels;
		this.curLevel = newLevel;
		if (this.curLevel < 0) {
			if (this.bUserlevels) {
				this.curLevel = ApoHybridLevel.editorLevels.length - 1;
			} else {
				this.curLevel = this.getGame().getMaxCanChoosen();
			}
		}
		if (this.bUserlevels) {
			if (this.curLevel >= ApoHybridLevel.editorLevels.length) {
				this.curLevel = 0;
			}
		} else if (this.curLevel > this.getGame().getMaxCanChoosen()) {
			this.curLevel = 0;
		}
		
		if (this.bUserlevels) {
			this.loadLevelWithString(ApoHybridLevel.editorLevels[this.curLevel], false);
		} else {
			this.loadLevelWithString(ApoHybridLevel.getLevel(this.curLevel), false);
		}
	}
	
	public void loadLevelWithString(final String level, boolean bEditor) {
		this.levelString = level;
		
		String[] l = level.split(",");
		
		this.clocks = new ApoHybridEntityClock[l.length/5];
		for (int y = 0; y < l.length; y += 5) {
			float clockX = Integer.valueOf(l[y + 0].replaceAll(" ", ""));
			float clockY = Integer.valueOf(l[y + 1].replaceAll(" ", ""));
			float clockRadius = Integer.valueOf(l[y + 2].replaceAll(" ", ""));
			float clockStartAngle = Integer.valueOf(l[y + 3].replaceAll(" ", ""));
			float clockRotationVelocity = Integer.valueOf(l[y + 4].replaceAll(" ", ""));
			this.clocks[y/5] = new ApoHybridEntityClock(clockX, clockY, clockRadius, Math.abs(clockStartAngle), clockRotationVelocity);
			if (clockStartAngle < 0) {
				this.clocks[y/5].setRotateClockwise(false);
			}
		}
		this.ball = new ApoHybridEntityBall(5, 260, 5, 90, 0.2f);
		
		this.bNewStart = false;
		
		this.bPressed = false;
		this.winInt = 0;
		this.bStarted = false;
		this.bEditor = bEditor;
	}

	@Override
	public void think(int delta) {
		if (this.bNewStart) {
			if (this.bEditor) {
				this.loadLevelWithString(this.levelString, this.bEditor);
			} else {
				this.loadLevel(this.curLevel, this.bUserlevels);
			}
		} else {
			if (this.bPressed) {
				if ((this.touchX > 10) && (this.touchX < 70) &&
					(this.touchY > 595) && (this.touchY < 635) && (!this.bEditor)) {
					this.curLevel -= 1;
					this.bNewStart = true;
					this.touchX = -1;
					this.touchY = -1;
					this.loadLevel(this.curLevel, this.bUserlevels);
				} else if ((this.touchX > 310) && (this.touchX < 370) &&
						(this.touchY > 595) && (this.touchY < 635) && (!this.bEditor)) {
					this.curLevel += 1;
					this.bNewStart = true;
					this.touchX = -1;
					this.touchY = -1;
					this.loadLevel(this.curLevel, this.bUserlevels);
				} else if (this.winInt > 0) {
					this.bNewStart = true;
					if (this.winInt == 1) {
						if (this.bEditor) {
							this.getGame().setEditor(true);
						} else {
							this.curLevel += 1;
							if (!this.bUserlevels) {
								this.getGame().solvedLevel(this.curLevel);
							}
							this.think(delta);
						}
					}
				} else if (!this.bStarted) {
					this.bStarted = true;
				} else {
					for (int i = 0; i < this.clocks.length; i++) {
						if ((this.clocks[i].getStartangle() >= 0) && (this.clocks[i].isVisible())) {
							this.ball.setVisible(true);
							this.clocks[i].setVisible(false);
							this.ball.setX(this.clocks[i].getX() + (int)((this.clocks[i].getRadius()) * Math.sin(Math.toRadians(this.clocks[i].getAngle()))));
							this.ball.setY(this.clocks[i].getY() - (int)((this.clocks[i].getRadius()) * Math.cos(Math.toRadians(this.clocks[i].getAngle()))));
							this.ball.setAngle(this.clocks[i].getAngle());
							break;
						}
					}
				}
			}
			if ((this.bStarted) && (this.winInt <= 0)) {
				for (int i = 0; i < this.clocks.length; i++) {
					this.clocks[i].think(delta);
					
					if (this.clocks[i].isVisible()) {
						this.clocks[i].setCurTime(this.clocks[i].getCurTime() + delta);
						while (this.clocks[i].getCurTime() >= this.clocks[i].getRotateVelocity()) {
							int add = 1;
							if (!this.clocks[i].isRotateClockwise()) {
								add = -1;
							}
							this.clocks[i].setAngle(this.clocks[i].getAngle() + add);
							if (this.clocks[i].getAngle() >= 360) {
								this.clocks[i].setAngle(this.clocks[i].getAngle() - 360);
							}
							if (this.clocks[i].getAngle() < 0) {
								this.clocks[i].setAngle(this.clocks[i].getAngle() + 360);
							}
							this.clocks[i].setCurTime(this.clocks[i].getCurTime() - this.clocks[i].getRotateVelocity());
						
							if ((this.clocks[i].getStartangle() >= 0) && ((int)this.clocks[i].getAngle() == (int)(this.clocks[i].getStartangle()))) {
								this.winInt = 2;
								break;
							}
						}
						
					}
					
					
				}
				if (this.ball.isVisible()) {
					this.ball.think(delta);
					
					if ((this.ball.getX() < 0) || (this.ball.getX() > 480)) {
						this.winInt = 2;
					}
					if ((this.ball.getY() < 25) || (this.ball.getY() > 595)) {
						this.winInt = 2;
					}
					
					for (int i = 0; i < this.clocks.length; i++) {
						if (this.clocks[i].isVisible()) {
							if (this.ball.intersects(this.clocks[i].getX(), this.clocks[i].getY(), this.clocks[i].getRadius())) {
								this.ball.setVisible(false);
								this.clocks[i].setStartangle(this.clocks[i].getAngle());
								break;
							}
						}
					}
				}
				boolean bBreak = true;
				for (int i = 0; i < this.clocks.length; i++) {
					if ((this.clocks[i].isVisible()) && (this.clocks[i].getStartangle() < 0)) {
						bBreak = false;
						break;
					}
				}
				if (bBreak) {
					this.winInt = 1;
				}
			}
		}
		
		this.bPressed = false;
	}

	@Override
	public void render(BitsGLGraphics g) {
		for (int i = 0; i < this.clocks.length; i++) {
			this.clocks[i].render(g, 0, 0);
		}
		this.ball.render(g);
		
		g.setColor(128f/255f, 128f/255f, 128f/255f, 1.0f);
		g.fillRect(0,0,480,25);
		g.fillRect(0,590,480,50);
		
		g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
		g.drawRect(0,0,480,25);
		g.drawRect(0,590,480,50);

		String s = "ApoHybrid";
		this.getGame().drawString(g, s, 240, -4, ApoHybridPanel.game_font);
		
		if (this.bEditor) {
			s = "Editorlevel";
		} else if (this.bUserlevels) {
			s = "Level "+(this.curLevel + 1)+" / "+(ApoHybridLevel.editorLevels.length);
		} else {
			s = "Level "+(this.curLevel + 1)+" / "+(this.getGame().getMaxCanChoosen()+1);
		}
		this.getGame().drawString(g, s, 5, -4, ApoHybridPanel.game_font);
		
		if (this.winInt > 0) {
			if (this.winInt == 1) {
				s = "Touch to start the next level";
				this.getGame().drawString(g, s, 190, 598, ApoHybridPanel.game_font);
				
				s = "Congratulation";
			} else if (this.winInt > 1) {
				s = "Touch to restart the level";
				this.getGame().drawString(g, s, 190, 598, ApoHybridPanel.game_font);
				
				s = "Please try again";
			}

			int w = this.getStringWidth().get(s);
			g.setColor(128f/255f, 128f/255f, 128f/255f, 1f);
			g.fillRect(240 - w/2 - 10, 277, w + 20, 10 + ApoHybridPanel.title_font.mCharCellHeight);
			g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
			g.drawRect(240 - w/2 - 10, 277, w + 20, 10 + ApoHybridPanel.title_font.mCharCellHeight);
			
			this.getGame().drawString(g, s, 240, 282, ApoHybridPanel.title_font);
		} else {
			if (!this.bStarted) {
				s = "Touch to start the level";
				this.getGame().drawString(g, s, 190, 598, ApoHybridPanel.game_font);
				
				if ((this.curLevel == 0) && (!this.bEditor) && (!this.bUserlevels)) {
					g.setColor(128f/255f, 128f/255f, 128f/255f, 1f);
					g.fillRect(0, 495, 480, 99);
					g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
					g.drawRect(0, 495, 480, 145);
					
					s = HELP[0];
					this.getGame().drawString(g, s, 240, 500, ApoHybridPanel.game_font);
					
					s = HELP[1];
					this.getGame().drawString(g, s, 240, 520, ApoHybridPanel.game_font);
					
					s = HELP[2];
					this.getGame().drawString(g, s, 240, 540, ApoHybridPanel.game_font);
					
					s = HELP[3];
					this.getGame().drawString(g, s, 240, 560, ApoHybridPanel.game_font);
				}
			}
			if (!this.bEditor) {
				try {
					g.setColor(192f/255f, 192f/255f, 192f/255f, 1.0f);
					g.fillRect(10, 595, 60, 39);
					g.fillRect(310, 595, 60, 39);
					g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
					g.drawRect(10, 595, 60, 39);
					g.drawRect(310, 595, 60, 39);
					
					g.setLineSize(3.0f);
					float[] color = new float [] {64.0f/255f, 64.0f/255f, 64.0f/255f};
					if ((this.touchX > 10) && (this.touchX < 70) &&
						(this.touchY > 595) && (this.touchY < 635)) {
						color = new float [] {255.0f/255f, 255.0f/255f, 72.0f/255f};
					}
					g.setColor(color[0], color[1], color[2], 1.0f);
					g.drawLine(30, 615, 50, 605);
					g.drawLine(30, 615, 50, 625);
					color = new float [] {64.0f/255f, 64.0f/255f, 64.0f/255f};
					if ((this.touchX > 310) && (this.touchX < 370) &&
						(this.touchY > 595) && (this.touchY < 635)) {
						color = new float [] {255.0f/255f, 255.0f/255f, 72.0f/255f};
					}
					g.setColor(color[0], color[1], color[2], 1.0f);
					g.drawLine(350, 615, 330, 605);
					g.drawLine(350, 615, 330, 625);
					g.setLineSize(1.0f);
				} catch (Exception ex) {}
			}
		}
		
		this.getGame().renderButtons(g);
	}

}

