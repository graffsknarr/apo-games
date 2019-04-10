package net.apogames.apohybrid.game;

import net.apogames.apohybrid.ApoHybridModel;
import net.apogames.apohybrid.level.ApoHybridLevel;

//#if ClockGameLogic
//@import net.apogames.apohybrid.entity.ApoHybridEntityBall;
//@import net.apogames.apohybrid.entity.ApoHybridEntityClock;
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//#elif SnakeGameLogic || DiceGameLogic
//@import net.gliblybits.bitsengine.render.BitsGraphics;
//#elif MonoGameLogic
import java.util.ArrayList;

import net.apogames.apohybrid.ApoHybridConstants;
import net.apogames.apohybrid.ApoHybridSoundPlayer;
import net.apogames.apohybrid.entity.ApoHybridSpeech;
import net.apogames.apohybrid.entity.ApoParticle;
import net.gliblybits.bitsengine.graphics.BitsGraphics;
import net.gliblybits.bitsengine.graphics.bitmap.BitsBitmap;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLFactory;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLImage;
import net.gliblybits.bitsengine.input.BitsKeyEvent;
//#endif

//#if SnakeGameLogic || DiceGameLogic
//@public class ApoHybridGame extends ApoHybridModel {
//@
//@	public static final String BACK = "back";
//@
//@	private boolean bEditor = false;
//@	private boolean bUserlevel = false;
//@	
//@	private String levelString = "";
//@
//@	public static final byte changeY = 25;
//@
//@	public void onBackButtonPressed() {
//@		if (this.bEditor) {
//@			this.getGame().setEditor(false);
//@		} else {
//@			if (this.bUserlevel) {
//@				this.getGame().setMenu();
//@			} else {
//@				this.getGame().setPuzzleChooser();
//@			}
//@		}
//@	}
	//#endif
	
	
	//#if DiceGameLogic
//@
//@
//@	/*
//@	 * p[0] == Maus losgelassen
//@	 * p[1] == aktuelles Level
//@	 * p[2] == how much dices
//@	 * p[3] == Level geschafft Klick
//@	 * p[4] == Maus X-Wert
//@	 * p[5] == Maus Y-Wert
//@	 * p[6] == aktuell gedr?ckter W?rfel x-Wert
//@	 * p[7] == aktuell gedr?ckter W?rfel y-Wert
//@	 * p[8] == difference gedr?ckter W?rfel x-Wert
//@	 * p[9] == difference gedr?ckter W?rfel y-Wert
//@	 * p[10] == cX /pressed and mouse X change
//@	 * p[11] == cY / pressed and mouse Y change
//@	 * p[12] == c / hoe much change
//@	 */
//@	private final int[] p = new int[13];
//@	private boolean bBreak = false;
//@	
//@	
//@	private byte[][] level = new byte[16][8];
//@	
//@
//@	
//@	private final String[] HELP = new String[] {
//@		"The number on the dice shows the count",
//@		"of possible moves. Move each dice to a",
//@		"gray spot with no moves remaining.",
//@		"A dice can push another dice"
//@	};
//@	
//@	public ApoHybridGame(ApoHybridPanel game) {
//@		super(game);
//@	}
//@
//@	@Override
//@	public void init() {		
//@		this.getStringWidth().put(ApoHybridGame.BACK, (int)(ApoHybridMenu.font.getLength(ApoHybridGame.BACK)));
//@		
//@		String s = "ApoDice";
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
//@		s = HELP[0];
//@		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
//@		s = HELP[1];
//@		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
//@		s = HELP[2];
//@		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
//@		s = HELP[3];
//@		this.getStringWidth().put(s, (int) ApoHybridMenu.game_font.getLength(s));
//@	}
//@	
//@	@Override
//@	public void touchedPressed(int x, int y, int finger) {
//@		p[2] = 1;
//@		p[4] = x;
//@		p[5] = y;
//@	}
//@
//@	@Override
//@	public void touchedReleased(int x, int y, int finger) {
//@		p[2] = 0;
//@		p[0] = 1;
//@	}
//@
//@	@Override
//@	public void touchedDragged(int x, int y, int oldX, int oldY, int finger) {
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
//@}
//@	
//@	@Override
//@	public void touchedButton(String function) {
//@		if (function.equals(ApoHybridGame.BACK)) {
//@			this.onBackButtonPressed();
//@		}
//@	}
//@	
//@	
//@	public void loadLevel(int nextLevel, boolean bUserLevel, String levelString) {
//@		this.bUserlevel = bUserLevel;
//@		if (ApoHybridLevel.editorLevels == null) {
//@			this.bUserlevel = false;
//@		}
//@		p[1] = nextLevel;
//@		if (p[1] < 0) {
//@			if (this.bUserlevel) {
//@				p[1] = ApoHybridLevel.editorLevels.length - 1;
//@			} else {
//@				p[1] = this.getGame().getMaxCanChoosen();
//@			}
//@		}
//@		if (this.bUserlevel) {
//@			if (p[1] >= ApoHybridLevel.editorLevels.length) {
//@				p[1] = 0;
//@			}
//@		} else if (p[1] >= this.getGame().getMaxCanChoosen() + 1) {
//@			p[1] = 0;
//@		}
//@		this.bEditor = false;
//@		String l = "";
//@		if ((levelString != null) && (levelString.length() > 0)) {
//@			l = levelString;
//@			this.bEditor = true;
//@		} else {
//@			if (this.bUserlevel) {
//@				l = ApoHybridLevel.editorLevels[p[1]];
//@			} else {
//@				l = ApoHybridLevel.getLevel(p[1]);
//@			}
//@		}
//@		this.levelString = levelString;
//@		
//@		level = new byte[16][8];
//@		for (int y = 0; y < 8; y += 1) {
//@			for (int x = 0; x < level[y].length; x += 1) {
//@				char c = l.charAt(y * 8 + x);
//@				if ((c >= 48) && (c <= 57)) {
//@					byte value = Byte.valueOf(l.substring(y * 8 + x, y * 8 + x + 1));
//@					if (value <= 1) {
//@						level[y][x] = value;
//@					} else {
//@						level[y + 8][x] = value;
//@					}
//@				} else {
//@					byte value = (byte)((int)c - 95);
//@					level[y][x] = 1;
//@					level[y + 8][x] = value;
//@				}
//@			}
//@		}
//@		
//@		p[3] = p[2] = p[0] = 0;
//@		p[6] = -1;
//@	}
//@
//@	@Override
//@	public void think(int delta) {
//@		if (level[0][0] == -1) {
//@			this.loadLevel(p[1], this.bUserlevel, this.levelString);
//@		} else {
//@			if (p[0] > 0) {
//@				if ((p[4] > 20) && (p[4] < 60) &&
//@					(p[5] > 590) && (p[5] < 630) && (!this.bEditor)) {
//@					p[1] -= 1;
//@					level[0][0] = -1;
//@				} else if ((p[4] > 320) && (p[4] < 360) &&
//@						(p[5] > 590) && (p[5] < 630) && (!this.bEditor)) {
//@					p[1] += 1;
//@					level[0][0] = -1;
//@				} else if ((p[4] > 150) && (p[4] < 230) &&
//@						(p[5] > 590) && (p[5] < 630)) {
//@					level[0][0] = -1;
//@				} else if (p[3] > 0) {
//@					level[0][0] = -1;
//@					if (p[3] == 1) {
//@						if (this.bEditor) {
//@							this.getGame().setEditor(true);
//@						} else {
//@							p[1] += 1;
//@						}
//@					}
//@				} else if (p[6] >= 0) {
//@					if (((int)(p[4])/60 != p[6]) || ((int)(p[5] - changeY)/60 != p[7])) {
//@						
//@						if (!bBreak) {
//@							level[p[7] + 8][p[6]] -= 1;
//@							if (p[10] < 0) {
//@								for (int i = p[6] + p[12]; i <= p[6]; i++) {
//@									if (i + 1 < 8) {
//@										level[p[7] + 8][i] = level[p[7] + 8][i + 1];
//@									} else {
//@										level[p[7] + 8][i] = 0;
//@									}
//@								}
//@							} else if (p[10] > 0) {
//@								for (int i = p[6] + p[12] - 1; i >= p[6]; i--) {
//@									level[p[7] + 8][i + 1] = level[p[7] + 8][i];
//@								}
//@							}
//@							if (p[11] < 0) {
//@								for (int i = p[7] + p[12]; i <= p[7]; i++) {
//@									if (i + 1 < 8) {
//@										level[i + 8][p[6]] = level[i + 8 + 1][p[6]];
//@									} else {
//@										level[i + 8][p[6]] = 0;
//@									}
//@								}
//@							} else if (p[11] > 0) {
//@								for (int i = p[7] + p[12] - 1; i >= p[7]; i--) {
//@									level[i + 1 + 8][p[6]] = level[i + 8][p[6]];
//@								}
//@							}
//@							level[p[7] + 8][p[6]] = 0;
//@						}
//@						
//@						// is level solved?
//@						boolean bWin = true;
//@						boolean bLoose = true;
//@						for (int y = 0; y < 8; y += 1) {
//@							for (int x = 0; x < level[y].length; x += 1) {
//@								if ((level[y][x] == 1) && (level[y+8][x] != 2)) {
//@									bWin = false;
//@								}
//@								if (level[y+8][x] > 2) {
//@									bLoose = false;
//@								}
//@							}
//@						}
//@						if (bWin) {
//@							p[3] = 1;
//@							if ((!this.bUserlevel) && (!this.bEditor)) {
//@								this.getGame().solvedLevel(p[1] + 1);
//@							}
//@						} else if (bLoose) {
//@							p[3] = 2;
//@						}
//@					}
//@					
//@					p[6] = -1;
//@				}
//@			} else if (p[2] > 0) {
//@				if (p[6] < 0) {
//@					int x = p[4] / 60;
//@					int y = (p[5] - changeY) / 60;
//@					if ((x >= 0) && (y >= 0) && (x < 8) && (y < 8) && (level[y+8][x] > 2)) {
//@						p[6] = x;
//@						p[7] = y;
//@						p[2] = 0;
//@						p[8] = p[4] - p[6] * 60;
//@						p[9] = p[5] - changeY - p[7] * 60;
//@					}
//@				}
//@			}
//@		}
//@		
//@		p[0] = 0;
//@	}
//@
//@	@Override
//@	public void render(BitsGraphics g) {
//@		
//@		g.setColor(128, 128, 128, 255);
//@		g.drawFilledRect(0,0,480,changeY);
//@		g.drawFilledRect(0,480 + changeY,480,160 - changeY);
//@		
//@		g.setColor(0f/255f, 0f/255f, 0f/255f, 1.0f);
//@		g.drawRect(0,0,480,changeY);
//@		g.drawRect(0,480 + changeY,480,160 - changeY);
//@
//@		String s = "ApoDice";
//@		this.getGame().drawString(g, s, 240, - 4, ApoHybridMenu.game_font);
//@		
//@		if (!this.bEditor) {
//@			if (this.bUserlevel) {
//@				s = "Level "+(p[1] + 1)+" / "+(ApoHybridLevel.editorLevels.length);
//@			} else {
//@				s = "Level "+(p[1] + 1)+" / "+(this.getGame().getMaxCanChoosen() + 1);
//@			}
//@		} else {
//@			s = "Editorlevel";
//@		}
//@		this.getGame().drawString(g, s, 5, - 4, ApoHybridMenu.game_font);
//@
//@		for (int y = 0; y < 8; y += 1) {
//@			for (int x = 0; x < level[y].length; x += 1) {
//@				if (level[y][x] == 1) {
//@					g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
//@					g.drawFilledRoundRect(x * 60 + 1, changeY + y * 60 + 1, 58, 58, 6, 10);
//@				}
//@				if (level[y+8][x] > 0) {
//@					g.setColor(255f/255f, 255f/255f, 255f/255f, 1.0f);
//@					g.drawFilledRoundRect(x * 60 + 5, changeY + y * 60 + 5, 50, 50, 6, 10);
//@					if ((p[6] == x) && (p[7] == y)) {
//@						g.setColor(255f/255f, 0f/255f, 0f/255f, 1.0f);
//@						g.drawRoundRect(x * 60 + 5, changeY + y * 60 + 5, 50, 50, 6, 6);
//@					}
//@					g.setColor(0f/255f, 0f/255f, 0f/255f, 1.0f);
//@					if ((level[y+8][x] == 3) || (level[y+8][x] == 5) || (level[y+8][x] == 7)) {
//@						g.drawFilledCircle(x * 60 + 30, changeY + y * 60 + 30, 6, 40);
//@					}
//@					if ((level[y+8][x] == 4) || (level[y+8][x] == 5) || (level[y+8][x] == 6) || (level[y+8][x] == 7) || (level[y+8][x] == 8)) {
//@						g.drawFilledCircle(x * 60 + 14, changeY + y * 60 + 14, 6, 40);
//@						g.drawFilledCircle(x * 60 + 46, changeY + y * 60 + 46, 6, 40);
//@					}
//@					if ((level[y+8][x] == 6) || (level[y+8][x] == 7) || (level[y+8][x] == 8)) {
//@						g.drawFilledCircle(x * 60 + 46, changeY + y * 60 + 14, 6, 40);
//@						g.drawFilledCircle(x * 60 + 14, changeY + y * 60 + 46, 6, 40);
//@					}
//@					if (level[y+8][x] == 8) {
//@						g.drawFilledCircle(x * 60 + 46, changeY + y * 60 + 30, 6, 40);
//@						g.drawFilledCircle(x * 60 + 14, changeY + y * 60 + 30, 6, 40);
//@					}
//@				}
//@			}
//@		}
//@		
//@		if (p[6] >= 0) {
//@			g.setColor(128, 128, 128, 128);
//@			if (((int)(p[4])/60 != p[6]) || ((int)(p[5] - changeY)/60 != p[7])) {
//@				if (!bBreak) {
//@					if (p[10] < 0) {
//@						for (int i = p[6] + p[12]; i < p[6]; i++) {
//@							g.drawFilledRoundRect((i) * 60 + 8, changeY + p[7] * 60 + 8, 44, 44, 6, 10);
//@						}
//@					} else if (p[10] > 0) {
//@						for (int i = p[6] + p[12]; i > p[6]; i--) {
//@							g.drawFilledRoundRect((i) * 60 + 8, changeY + p[7] * 60 + 8, 44, 44, 6, 10);
//@						}
//@					}
//@					if (p[11] < 0) {
//@						for (int i = p[7] + p[12]; i < p[7]; i++) {
//@							g.drawFilledRoundRect((p[6]) * 60 + 8, changeY + (i) * 60 + 8, 44, 44, 6, 10);
//@						}
//@					} else if (p[11] > 0) {
//@						for (int i = p[7] + p[12]; i > p[7]; i--) {
//@							g.drawFilledRoundRect((p[6]) * 60 + 8, changeY + (i) * 60 + 8, 44, 44, 6, 10);
//@						}
//@					}
//@				}
//@			}
//@		}
//@		
//@		
//@		if (p[3] > 0) {
//@			String s2 = "";
//@			if (p[3] == 1) {
//@				s2 = "Congratulation";					
//@				s = "Touch to start the next level";
//@			} else if (p[3] > 1) {
//@				s2 = "Please try again";					
//@				s = "Touch to restart the level";
//@			}
//@			if (p[3] > 0) {
//@				float w = ApoHybridMenu.title_font.getLength(s2);
//@				g.setColor(128, 128, 128, 255);
//@				g.drawFilledRect(240 - w/2 - 10, 277, w + 20, 46);
//@				g.setColor(0, 0, 0, 255);
//@				g.drawRect(240 - w/2 - 10, 277, w + 20, 46);
//@				
//@				this.getGame().drawString(g, s2, 240, 273, ApoHybridMenu.title_font);
//@				
//@				this.getGame().drawString(g, s, 190, 595, ApoHybridMenu.game_font);
//@			}
//@		} else {
//@			if ((p[1] == 0) || (this.bUserlevel)) {
//@				this.getGame().drawString(g, HELP[0], 240, 510, ApoHybridMenu.game_font);
//@				this.getGame().drawString(g, HELP[1], 240, 530, ApoHybridMenu.game_font);
//@				this.getGame().drawString(g, HELP[2], 240, 550, ApoHybridMenu.game_font);
//@			} else if ((p[1] == 1) && (!this.bUserlevel)) {
//@				this.getGame().drawString(g, HELP[3], 240, 530, ApoHybridMenu.game_font);
//@			}
//@			
//@			g.setColor(160, 160, 160, 255);
//@			g.drawFilledRoundRect(150, 590, 80, 40, 6, 10);
//@			if (!this.bEditor) {
//@				g.drawFilledRoundRect(20, 590, 40, 40, 6, 10);
//@				g.drawFilledRoundRect(320, 590, 40, 40, 6, 10);
//@			}
//@			g.setLineSize(3.0f);
//@			g.setColor(0, 0, 0, 255);
//@			g.drawRoundRect(150, 590, 80, 40, 6, 10);
//@			if (!this.bEditor) {
//@				g.drawRoundRect(20, 590, 40, 40, 6, 10);
//@				g.drawRoundRect(320, 590, 40, 40, 6, 10);
//@			}
//@
//@			if (!this.bEditor) {
//@				g.drawLine(30, 610, 50, 600);
//@				g.drawLine(30, 610, 50, 620);
//@
//@				g.drawLine(350, 610, 330, 600);
//@				g.drawLine(350, 610, 330, 620);
//@			}
//@			g.setLineSize(1.0f);
//@			
//@			this.getGame().drawString(g, "restart", 190, 590, ApoHybridMenu.game_font);
//@		}
//@		
//@		this.getGame().renderButtons(g);
//@	}
//@
//@
	//#elif SnakeGameLogic
//@	
//@	/*
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
	//#elif ClockGameLogic
//@
//@
//@public class ApoHybridGame extends ApoHybridModel {
//@
//@	public static final String BACK = "back";
//@
//@	private ApoHybridEntityClock[] clocks = new ApoHybridEntityClock[1];
//@
//@	/*
//@	 * 0 = X-Wert,
//@	 * 1 = y-Wert,
//@	 * 2 = Angle,
//@	 * 3 = Geschwindigkeit
//@	 */
//@	private ApoHybridEntityBall ball;
//@
//@	/*
//@	 * this.curLevel == aktuelles Level,
//@	 * this.winInt == Level geschafft Klick,
//@	 * this.touchX == Maus X-Wert,
//@	 * this.touchY == Maus Y-Wert
//@	 */
//@	private int curLevel, touchX, touchY, winInt;
//@
//@	/*
//@	 * bPressed == losgelassen,
//@	 * bStarted == Spiel gestartet
//@	 */
//@	private boolean bStarted, bPressed;
//@
//@	private static final String[] HELP = new String[] {
//@			"Your goal is to reach all the clocks",
//@			"When the ball hits a clock the countdown starts",
//@			"Touch to fire the ball with the",
//@			"current clockwise direction"
//@	};
//@
//@	private boolean bNewStart = true;
//@
//@	private boolean bEditor = false;
//@
//@	private boolean bUserlevels;
//@
//@	private String levelString;
//@
//@	public ApoHybridGame(ApoHybridPanel game) {
//@		super(game);
//@	}
//@
//@	@Override
//@	public void init() {
//@		this.getStringWidth().put(ApoHybridGame.BACK, (int)(ApoHybridPanel.font.getLength(ApoHybridGame.BACK)));
//@
//@		String s = "ApoHybrid";
//@		this.getStringWidth().put(s, (int) ApoHybridPanel.game_font.getLength(s));
//@		s = "Congratulation";
//@		this.getStringWidth().put(s, (int) ApoHybridPanel.title_font.getLength(s));
//@		s = "Touch to start the next level";
//@		this.getStringWidth().put(s, (int) ApoHybridPanel.game_font.getLength(s));
//@		s = "Please try again";
//@		this.getStringWidth().put(s, (int) ApoHybridPanel.title_font.getLength(s));
//@		s = "Touch to restart the level";
//@		this.getStringWidth().put(s, (int) ApoHybridPanel.game_font.getLength(s));
//@		s = "Touch to start the level";
//@		this.getStringWidth().put(s, (int) ApoHybridPanel.game_font.getLength(s));
//@		s = HELP[0];
//@		this.getStringWidth().put(s, (int) ApoHybridPanel.game_font.getLength(s));
//@		s = HELP[1];
//@		this.getStringWidth().put(s, (int) ApoHybridPanel.game_font.getLength(s));
//@		s = HELP[2];
//@		this.getStringWidth().put(s, (int) ApoHybridPanel.game_font.getLength(s));
//@		s = HELP[3];
//@		this.getStringWidth().put(s, (int) ApoHybridPanel.game_font.getLength(s));
//@	}
//@
//@	@Override
//@	public void touchedPressed(int x, int y, int finger) {
		//#if Press
//@		this.bPressed = true;
//@		this.touchX = x;
//@		this.touchY = y;
		//#endif
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
//@	public void onBackButtonPressed() {
//@		if (this.bEditor) {
//@			this.getGame().setEditor(false);
//@		} else if (this.bUserlevels) {
//@			this.getGame().setPuzzle();
//@		} else {
//@			this.getGame().setPuzzleChooser();
//@		}
//@	}
//@
//@	protected void loadLevel(final int newLevel, final boolean bUserLevels) {
//@		this.bUserlevels = bUserLevels;
//@		this.curLevel = newLevel;
//@		if (this.curLevel < 0) {
//@			if (this.bUserlevels) {
//@				this.curLevel = ApoHybridLevel.editorLevels.length - 1;
//@			} else {
//@				this.curLevel = this.getGame().getMaxCanChoosen();
//@			}
//@		}
//@		if (this.bUserlevels) {
//@			if (this.curLevel >= ApoHybridLevel.editorLevels.length) {
//@				this.curLevel = 0;
//@			}
//@		} else if (this.curLevel > this.getGame().getMaxCanChoosen()) {
//@			this.curLevel = 0;
//@		}
//@
//@		if (this.bUserlevels) {
//@			this.loadLevelWithString(ApoHybridLevel.editorLevels[this.curLevel], false);
//@		} else {
//@			this.loadLevelWithString(ApoHybridLevel.getLevel(this.curLevel), false);
//@		}
//@	}
//@
//@	public void loadLevelWithString(final String level, boolean bEditor) {
//@		this.levelString = level;
//@
//@		String[] l = level.split(",");
//@
//@		this.clocks = new ApoHybridEntityClock[l.length/5];
//@		for (int y = 0; y < l.length; y += 5) {
//@			float clockX = Integer.valueOf(l[y + 0].replaceAll(" ", ""));
//@			float clockY = Integer.valueOf(l[y + 1].replaceAll(" ", ""));
//@			float clockRadius = Integer.valueOf(l[y + 2].replaceAll(" ", ""));
//@			float clockStartAngle = Integer.valueOf(l[y + 3].replaceAll(" ", ""));
//@			float clockRotationVelocity = Integer.valueOf(l[y + 4].replaceAll(" ", ""));
//@			this.clocks[y/5] = new ApoHybridEntityClock(clockX, clockY, clockRadius, Math.abs(clockStartAngle), clockRotationVelocity);
//@			if (clockStartAngle < 0) {
//@				this.clocks[y/5].setRotateClockwise(false);
//@			}
//@		}
//@		this.ball = new ApoHybridEntityBall(5, 260, 5, 90, 0.2f);
//@
//@		this.bNewStart = false;
//@
//@		this.bPressed = false;
//@		this.winInt = 0;
//@		this.bStarted = false;
//@		this.bEditor = bEditor;
//@	}
//@
//@	@Override
//@	public void think(int delta) {
//@		if (this.bNewStart) {
//@			if (this.bEditor) {
//@				this.loadLevelWithString(this.levelString, this.bEditor);
//@			} else {
//@				this.loadLevel(this.curLevel, this.bUserlevels);
//@			}
//@		} else {
//@			if (this.bPressed) {
//@				if ((this.touchX > 10) && (this.touchX < 70) &&
//@						(this.touchY > 595) && (this.touchY < 635) && (!this.bEditor)) {
//@					this.curLevel -= 1;
//@					this.bNewStart = true;
//@					this.touchX = -1;
//@					this.touchY = -1;
//@					this.loadLevel(this.curLevel, this.bUserlevels);
//@				} else if ((this.touchX > 310) && (this.touchX < 370) &&
//@						(this.touchY > 595) && (this.touchY < 635) && (!this.bEditor)) {
//@					this.curLevel += 1;
//@					this.bNewStart = true;
//@					this.touchX = -1;
//@					this.touchY = -1;
//@					this.loadLevel(this.curLevel, this.bUserlevels);
//@				} else if (this.winInt > 0) {
//@					this.bNewStart = true;
//@					if (this.winInt == 1) {
//@						if (this.bEditor) {
//@							this.getGame().setEditor(true);
//@						} else {
//@							this.curLevel += 1;
//@							if (!this.bUserlevels) {
//@								this.getGame().solvedLevel(this.curLevel);
//@							}
//@							this.think(delta);
//@						}
//@					}
//@				} else if (!this.bStarted) {
//@					this.bStarted = true;
//@				} else {
//@					for (int i = 0; i < this.clocks.length; i++) {
//@						if ((this.clocks[i].getStartangle() >= 0) && (this.clocks[i].isVisible())) {
//@							this.ball.setVisible(true);
//@							this.clocks[i].setVisible(false);
//@							this.ball.setX(this.clocks[i].getX() + (int)((this.clocks[i].getRadius()) * Math.sin(Math.toRadians(this.clocks[i].getAngle()))));
//@							this.ball.setY(this.clocks[i].getY() - (int)((this.clocks[i].getRadius()) * Math.cos(Math.toRadians(this.clocks[i].getAngle()))));
//@							this.ball.setAngle(this.clocks[i].getAngle());
//@							break;
//@						}
//@					}
//@				}
//@			}
//@			if ((this.bStarted) && (this.winInt <= 0)) {
//@				for (int i = 0; i < this.clocks.length; i++) {
//@					this.clocks[i].think(delta);
//@
//@					if (this.clocks[i].isVisible()) {
//@						this.clocks[i].setCurTime(this.clocks[i].getCurTime() + delta);
//@						while (this.clocks[i].getCurTime() >= this.clocks[i].getRotateVelocity()) {
//@							int add = 1;
//@							if (!this.clocks[i].isRotateClockwise()) {
//@								add = -1;
//@							}
//@							this.clocks[i].setAngle(this.clocks[i].getAngle() + add);
//@							if (this.clocks[i].getAngle() >= 360) {
//@								this.clocks[i].setAngle(this.clocks[i].getAngle() - 360);
//@							}
//@							if (this.clocks[i].getAngle() < 0) {
//@								this.clocks[i].setAngle(this.clocks[i].getAngle() + 360);
//@							}
//@							this.clocks[i].setCurTime(this.clocks[i].getCurTime() - this.clocks[i].getRotateVelocity());
//@
//@							if ((this.clocks[i].getStartangle() >= 0) && ((int)this.clocks[i].getAngle() == (int)(this.clocks[i].getStartangle()))) {
//@								this.winInt = 2;
//@								break;
//@							}
//@						}
//@
//@					}
//@
//@
//@				}
//@				if (this.ball.isVisible()) {
//@					this.ball.think(delta);
//@
//@					if ((this.ball.getX() < 0) || (this.ball.getX() > 480)) {
//@						this.winInt = 2;
//@					}
//@					if ((this.ball.getY() < 25) || (this.ball.getY() > 595)) {
//@						this.winInt = 2;
//@					}
//@
//@					for (int i = 0; i < this.clocks.length; i++) {
//@						if (this.clocks[i].isVisible()) {
//@							if (this.ball.intersects(this.clocks[i].getX(), this.clocks[i].getY(), this.clocks[i].getRadius())) {
//@								this.ball.setVisible(false);
//@								this.clocks[i].setStartangle(this.clocks[i].getAngle());
//@								break;
//@							}
//@						}
//@					}
//@				}
//@				boolean bBreak = true;
//@				for (int i = 0; i < this.clocks.length; i++) {
//@					if ((this.clocks[i].isVisible()) && (this.clocks[i].getStartangle() < 0)) {
//@						bBreak = false;
//@						break;
//@					}
//@				}
//@				if (bBreak) {
//@					this.winInt = 1;
//@				}
//@			}
//@		}
//@
//@		this.bPressed = false;
//@	}
//@
//@	@Override
//@	public void render(BitsGLGraphics g) {
//@		for (int i = 0; i < this.clocks.length; i++) {
//@			this.clocks[i].render(g, 0, 0);
//@		}
//@		this.ball.render(g);
//@
//@		g.setColor(128f/255f, 128f/255f, 128f/255f, 1.0f);
//@		g.fillRect(0,0,480,25);
//@		g.fillRect(0,590,480,50);
//@
//@		g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
//@		g.drawRect(0,0,480,25);
//@		g.drawRect(0,590,480,50);
//@
//@		String s = "ApoHybrid";
//@		this.getGame().drawString(g, s, 240, -4, ApoHybridPanel.game_font);
//@
//@		if (this.bEditor) {
//@			s = "Editorlevel";
//@		} else if (this.bUserlevels) {
//@			s = "Level "+(this.curLevel + 1)+" / "+(ApoHybridLevel.editorLevels.length);
//@		} else {
//@			s = "Level "+(this.curLevel + 1)+" / "+(this.getGame().getMaxCanChoosen()+1);
//@		}
//@		this.getGame().drawString(g, s, 5, -4, ApoHybridPanel.game_font);
//@
//@		if (this.winInt > 0) {
//@			if (this.winInt == 1) {
//@				s = "Touch to start the next level";
//@				this.getGame().drawString(g, s, 190, 598, ApoHybridPanel.game_font);
//@
//@				s = "Congratulation";
//@			} else if (this.winInt > 1) {
//@				s = "Touch to restart the level";
//@				this.getGame().drawString(g, s, 190, 598, ApoHybridPanel.game_font);
//@
//@				s = "Please try again";
//@			}
//@
//@			int w = this.getStringWidth().get(s);
//@			g.setColor(128f/255f, 128f/255f, 128f/255f, 1f);
//@			g.fillRect(240 - w/2 - 10, 277, w + 20, 10 + ApoHybridPanel.title_font.mCharCellHeight);
//@			g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
//@			g.drawRect(240 - w/2 - 10, 277, w + 20, 10 + ApoHybridPanel.title_font.mCharCellHeight);
//@
//@			this.getGame().drawString(g, s, 240, 282, ApoHybridPanel.title_font);
//@		} else {
//@			if (!this.bStarted) {
//@				s = "Touch to start the level";
//@				this.getGame().drawString(g, s, 190, 598, ApoHybridPanel.game_font);
//@
//@				if ((this.curLevel == 0) && (!this.bEditor) && (!this.bUserlevels)) {
//@					g.setColor(128f/255f, 128f/255f, 128f/255f, 1f);
//@					g.fillRect(0, 495, 480, 99);
//@					g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
//@					g.drawRect(0, 495, 480, 145);
//@
//@					s = HELP[0];
//@					this.getGame().drawString(g, s, 240, 500, ApoHybridPanel.game_font);
//@
//@					s = HELP[1];
//@					this.getGame().drawString(g, s, 240, 520, ApoHybridPanel.game_font);
//@
//@					s = HELP[2];
//@					this.getGame().drawString(g, s, 240, 540, ApoHybridPanel.game_font);
//@
//@					s = HELP[3];
//@					this.getGame().drawString(g, s, 240, 560, ApoHybridPanel.game_font);
//@				}
//@			}
//@			if (!this.bEditor) {
//@				try {
//@					g.setColor(192f/255f, 192f/255f, 192f/255f, 1.0f);
//@					g.fillRect(10, 595, 60, 39);
//@					g.fillRect(310, 595, 60, 39);
//@					g.setColor(48f/255f, 48f/255f, 48f/255f, 1.0f);
//@					g.drawRect(10, 595, 60, 39);
//@					g.drawRect(310, 595, 60, 39);
//@
//@					g.setLineSize(3.0f);
//@					float[] color = new float [] {64.0f/255f, 64.0f/255f, 64.0f/255f};
//@					if ((this.touchX > 10) && (this.touchX < 70) &&
//@							(this.touchY > 595) && (this.touchY < 635)) {
//@						color = new float [] {255.0f/255f, 255.0f/255f, 72.0f/255f};
//@					}
//@					g.setColor(color[0], color[1], color[2], 1.0f);
//@					g.drawLine(30, 615, 50, 605);
//@					g.drawLine(30, 615, 50, 625);
//@					color = new float [] {64.0f/255f, 64.0f/255f, 64.0f/255f};
//@					if ((this.touchX > 310) && (this.touchX < 370) &&
//@							(this.touchY > 595) && (this.touchY < 635)) {
//@						color = new float [] {255.0f/255f, 255.0f/255f, 72.0f/255f};
//@					}
//@					g.setColor(color[0], color[1], color[2], 1.0f);
//@					g.drawLine(350, 615, 330, 605);
//@					g.drawLine(350, 615, 330, 625);
//@					g.setLineSize(1.0f);
//@				} catch (Exception ex) {}
//@			}
//@		}
//@
//@		this.getGame().renderButtons(g);
//@	}
//@
//@
//#elif MonoGameLogic
public class ApoHybridGame extends ApoHybridModel {

	public static final String BACK = "back";
	public static final String RETRY = "retry";

	public static final int SPEECH_MAX_TIME = 4000;
	public static final int SPEECH_NOMOVE_TIME = 10000;
	public static final int BEAMER_CHANGE_TIME = 400;
	public static final int MIRROR_CHANGE_TIME = 200;
	public static final int FRAME_TIME = 400;
	public static final int FRAME_GRAVITY_TIME = 1000;

	/**
	 * p[0] == aktuelles Level
	 * p[1] == mirrorcount horizontal
	 * p[2] == aktuelles Level geschafft klick
	 * p[3] == mirrortime
	 * p[4] == time
	 * p[5] == x Wert touch
	 * p[6] == y Wert touch
	 * p[7] == Zeit f�r Drehung
	 * p[8] == mirrorcount vertical
	 * p[9] == gravitychangecount
	 */
	private final int[] p = new int[10];

	private boolean bEditor = false;
	private boolean bUserlevel = false;

	private String levelString = "";

	private int[][] level = new int[1][1];
	private int[][] falla = new int[1][1];
	private int[][] boxes = new int[1][1];

	public static final int changeY = 40;

	private int add, x, y, i, playerX, playerY, addLeft, fall, addX, addY, mirrorX, mirrorY, withBox, playerStartX, playerStartY;

	private BitsGLImage iMirror, iBackground;

	private int gravity = 1;

	private ArrayList<ApoParticle> particles;

	private int frameGoal, frameTimeGoal, mirrorChange, speechShowTime, noMoveTime, noMoveTimeNext, beamerFrame, beamerFrameTime;
	private float frameGravity, frameGravityAdd, frameGravityTime;

	private ApoHybridSpeech speech;

	private ArrayList<int[][]> backsteps;

	private int backgroundWait = 0;

	private boolean bCanExplodeSound;

	public ApoHybridGame(ApoHybridPanel game) {
		super(game);
	}

	@Override
	public void init() {
		if (level.length < 10) {
			this.level[0][0] = -1;
			this.frameGoal = 0;
			this.frameGravity = 0;
			this.frameGravityAdd = 1;
			this.frameGravityTime= 0;
		}
		if (this.particles == null) {
			this.particles = new ArrayList<ApoParticle>();
		} else {
			this.particles.clear();
		}
		if (this.backsteps == null) {
			this.backsteps = new ArrayList<int[][]>();
		} else {
			this.backsteps.clear();
		}
		if (this.speech == null) {
			this.speech = new ApoHybridSpeech(this.getGame(), 0, 0, false, true, "");
			this.speech.setVisible(false);
		}
	}

	@Override
	public void touchedPressed(int x, int y, int finger) {
		p[5] = x;
		p[6] = y;
	}

	@Override
	public void touchedReleased(int x, int y, int finger) {
		p[5] = -1;
		p[6] = -1;
	}

	@Override
	public void touchedDragged(int x, int y, int oldX, int oldY, int finger) {
	}

	@Override
	public void touchedButton(String function) {
		if (function.equals(ApoHybridGame.BACK)) {
			this.onBackButtonPressed();
		} else if (function.equals(ApoHybridGame.RETRY)) {
			this.loadLevel(p[0], this.bUserlevel, this.levelString);
		}
		this.getGame().playSound(ApoHybridSoundPlayer.SOUND_BUTTON);
	}

	public void onKeyDown(final int key) {
		if (key == BitsKeyEvent.KEY_LEFT) {
			p[5] = 25;
			p[6] = changeY + 250;
		} else if (key == BitsKeyEvent.KEY_RIGHT) {
			p[5] = 75;
			p[6] = changeY + 250;
		} else if (key == BitsKeyEvent.KEY_L) {
			p[5] = 125;
			p[6] = changeY + 250;
		} else if ((key == BitsKeyEvent.KEY_UP) || (key == BitsKeyEvent.KEY_DOWN)) {
			p[5] = ApoHybridConstants.GAME_WIDTH - 30;
			p[6] = changeY + 250;
			if (this.mirrorY >= 0) {
				if (key == BitsKeyEvent.KEY_UP) {
					p[5] = 25;
				} else if (key == BitsKeyEvent.KEY_DOWN) {
					p[5] = 75;
				}
			}
		} else if (((key == BitsKeyEvent.KEY_SPACE) || (key == BitsKeyEvent.KEY_SHIFT_RIGHT)) && (p[1] > 0)) {
			p[5] = ApoHybridConstants.GAME_WIDTH - 80;
			p[6] = changeY + 250;
		} else if ((key == BitsKeyEvent.KEY_ENTER) && (p[8] > 0)) {
			p[5] = ApoHybridConstants.GAME_WIDTH - 130;
			p[6] = changeY + 250;
		} else if ((key == BitsKeyEvent.KEY_ESCAPE) ||  (key == BitsKeyEvent.KEY_CTRL_RIGHT)) {
			if ((this.mirrorX >= 0) || (this.mirrorY >= 0)) {
				p[5] = ApoHybridConstants.GAME_WIDTH - 180;
				p[6] = changeY + 250;
			} else {
				this.onBackButtonPressed();
			}
		} else if (key == BitsKeyEvent.KEY_B) {
			p[5] = ApoHybridConstants.GAME_WIDTH/2;
			p[6] = changeY + 250;
		} else if (key == BitsKeyEvent.KEY_R) {
			this.touchedButton(ApoHybridGame.RETRY);
		} else if (key == BitsKeyEvent.KEY_P) {
			p[5] = ApoHybridConstants.GAME_WIDTH/2 - 95;
			p[6] = 10;
		} else if (key == BitsKeyEvent.KEY_N) {
			p[5] = ApoHybridConstants.GAME_WIDTH/2 + 95;
			p[6] = 10;
		}
	}

	public void onKeyUp(final int key) {
		if ((key == BitsKeyEvent.KEY_LEFT) || (key == BitsKeyEvent.KEY_RIGHT) ||
				(key == BitsKeyEvent.KEY_UP) || (key == BitsKeyEvent.KEY_DOWN) ||
				(key == BitsKeyEvent.KEY_SPACE) || (key == BitsKeyEvent.KEY_R) ||
				(key == BitsKeyEvent.KEY_P) || (key == BitsKeyEvent.KEY_N) ||
				(key == BitsKeyEvent.KEY_ESCAPE) || (key == BitsKeyEvent.KEY_SHIFT_RIGHT) ||
				(key == BitsKeyEvent.KEY_CTRL_RIGHT)) {
			if ((key == BitsKeyEvent.KEY_LEFT) || (key == BitsKeyEvent.KEY_RIGHT)) {
				this.mirrorChange = ApoHybridGame.MIRROR_CHANGE_TIME + 1;
			}
			p[5] = -1;
			p[6] = -1;
		}
	}

	public void onBackButtonPressed() {
		if (this.bEditor) {
			this.getGame().setEditor(false);
		} else {
			if (this.bUserlevel) {
				this.getGame().setMenu();
			} else {
				this.getGame().setLevelChooser();
			}
		}
	}

	public void loadLevel(final int nextLevel, final boolean bUserLevel, final String levelString) {
		this.bUserlevel = bUserLevel;
		if (ApoHybridLevel.editorLevels == null) {
			this.bUserlevel = false;
		}
		p[0] = nextLevel;
		if (p[0] < 0) {
			if (this.bUserlevel) {
				p[0] = ApoHybridLevel.editorLevels.length - 1;
			} else {
				p[0] = this.getGame().getMaxCanChoosen();
			}
		}
		if (this.bUserlevel) {
			if (p[0] >= ApoHybridLevel.editorLevels.length) {
				p[0] = 0;
			}
		} else if (p[0] >= this.getGame().getMaxCanChoosen() + 1) {
			p[0] = 0;
		}
		this.bEditor = false;
		String l = "";
		if ((levelString != null) && (levelString.length() > 0)) {
			l = levelString;
			this.bEditor = true;
		} else {
			if (this.bUserlevel) {
				l = ApoHybridLevel.editorLevels[p[0]];
			} else {
				l = ApoHybridLevel.getLevel(p[0]);
			}
		}
		this.levelString = levelString;

		boxes = new int[15][30];
		falla = new int[15][30];
		level = new int[15][30];
		p[1] = Integer.valueOf(l.substring(0, 1));
		p[8] = Integer.valueOf(l.substring(1, 2));
		p[9] = Integer.valueOf(l.substring(2, 3));
		int cur = 3;
		for (y = 0; y < level.length; y++) {
			level[y][0] = 0;
			level[y][level[0].length - 1] = 0;
			for (x = 0; x < level[0].length - 2; x++) {
				char c = l.charAt(cur);
				if (c >= 97) {
					level[y][x+1] = Integer.valueOf(c) - 87;
				} else {
					level[y][x+1] = Integer.valueOf(c) - 48;
				}
				cur += 1;
				if (level[y][x+1] == 2) {
					playerX = x + 1;
					playerY = y;
					this.playerStartX = playerX;
					this.playerStartY = playerY;
					level[y][x+1] = 0;
				}
				if (level[y][x+1] == 9) {
					for (x = 0; x < level[0].length - 2; x++) {
						level[y][x+1] = 0;
					}
					break;
				}
				if (level[y][x+1] == 7) {
					boxes[y][x+1] = 7;
				} else if (level[y][x+1] == 6) {
					boxes[y][x+1] = 6;
				} else if (level[y][x+1] == 11) {
					boxes[y][x+1] = 11;
					level[y][x+1] = 0;
				}
			}
		}
		this.speechShowTime = this.noMoveTime = withBox = addLeft = addX = addY = fall = add = p[2] = p[3] = p[4] = p[5] = p[6] = 0;
		this.mirrorX = this.mirrorY = -1;
		this.gravity = 1;
		this.backgroundWait = 0;
		this.speech.setVisible(false);
		this.setNoMoveTimeNext();
		this.backsteps.clear();
		this.makeBackground();
		this.saveNextBackstep();
	}

	private void setPreviousStep() {
		if (this.backsteps.size() > 0) {
			int[][] backLevel = this.backsteps.get(this.backsteps.size() - 1);

			int[][] previousLevel = new int[backLevel.length][backLevel[0].length];
			for (int y = 0; y < backLevel.length; y++) {
				for (int x = 0; x < backLevel[0].length; x++) {
					previousLevel[y][x] = backLevel[y][x];
				}
			}

			String val = String.valueOf(previousLevel[0][0]);
			this.p[1] = Integer.valueOf(val.substring(1, 2));
			this.p[8] = Integer.valueOf(val.substring(2, 3));
			this.p[9] = Integer.valueOf(val.substring(3, 4));
			int grav = Integer.valueOf(val.substring(4, 5));
			if (grav == 2) {
				grav = -1;
			}

			this.gravity = grav;
			previousLevel[0][0] = Integer.valueOf(val.substring(5));

			for (int y = 0; y < this.level.length; y++) {
				for (int x = 0; x < this.level[0].length; x++) {
					if (previousLevel[y][x] < 50) {
						level[y][x] = previousLevel[y][x];
					} else {
						level[y][x] = 0;
						this.playerY = y;
						this.playerX = x;
						if (previousLevel[y][x] >= 55) {
							this.withBox = 1;
						} else {
							this.withBox = 0;
						}
						this.add = 0;
						if ((previousLevel[y][x] == 51) || (previousLevel[y][x] == 56)) {
							this.add = 1;
						}
					}
				}
			}
			for (int y = 0; y < this.boxes.length; y++) {
				for (int x = 0; x < this.boxes[0].length; x++) {
					this.boxes[y][x] = previousLevel[y + this.boxes.length][x];
				}
			}

			if (this.backsteps.size() > 1) {
				this.backsteps.remove(this.backsteps.size() - 1);
			}
			this.mirrorX = this.mirrorY = -1;
			this.makeBackground();
		}
	}

	private void saveNextBackstep() {
		int grav = 1;
		if (this.gravity < 0) {
			grav = 2;
		}
		String firstValue = "1" + this.p[1] + "" + p[8] + "" + p[9] + "" + grav + "" + level[0][0];
		int first = Integer.valueOf(firstValue);
		int[][] backLevel = new int[level.length * 2][level[0].length];
		backLevel[0][0] = first;
		for (int y = 0; y < this.level.length; y++) {
			for (int x = 0; x < this.level[0].length; x++) {
				if ((y != 0) || (x != 0)) {
					backLevel[y][x] = level[y][x];
				}
			}
		}
		for (int y = 0; y < this.level.length; y++) {
			for (int x = 0; x < this.level[0].length; x++) {
				backLevel[y + this.level.length][x] = this.boxes[y][x];
			}
		}
		int value = 50 + this.add;
		if (this.withBox != 0) {
			value += 5;
		}
		backLevel[this.playerY][this.playerX] = value;

		this.hideSpeech();
		this.backsteps.add(backLevel);
	}

	private void setNoMoveTimeNext() {
		this.noMoveTime = 0;
		this.noMoveTimeNext = ApoHybridGame.SPEECH_NOMOVE_TIME + (int)(Math.random() * 10000);
	}

	private void makeBackground() {
		ApoHybridGame.this.loadAndMakeBackground();
		backgroundWait = 200;
	}

	public void onResume() {
		if (this.iBackground == null) {
			this.makeBackground();
			if ((this.mirrorX >= 0) || (this.mirrorY >= 0)) {
				this.makeMirrrorImage();
			}
		}
	}

	private void loadAndMakeBackground() {
		int scale = 1;
		boolean bScale = false;
		if (ApoHybridConstants.MAX >= 10) {
			scale = 2;
			bScale = true;
		}
		BitsBitmap bitmap = new BitsBitmap(512 * scale, 256 * scale, BitsBitmap.TYPE_ARGB);
		BitsGraphics g = bitmap.createGraphics();

		g.setColor(0f,0f,0f, 1f);
		for (int y = 0; y < level.length; y++) {
			for (int x = 0; x < level[0].length; x++) {
				int addPX = x * 16 * scale;
				int addPY = y * 16 * scale;

				if ((level[y][x] != 0) && (level[y][x] != 4) && (level[y][x] != 3)) {
					if (level[y][x] == 1) {
						g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
						ApoHybridGame.drawBlock(g, addPX, addPY, bScale);
					} else {
						g.setColor(ApoHybridConstants.DARK_BRIGHT[0], ApoHybridConstants.DARK_BRIGHT[1], ApoHybridConstants.DARK_BRIGHT[2], 1f);
						if (level[y][x] == 8) {
							ApoHybridGame.drawBlockPlusMirror(g, addPX, addPY, bScale);
						}
						if (level[y][x] == 7) {
							ApoHybridGame.drawX(g, addPX, addPY, bScale);
						}
						if (p[3] > 0) {
							if (this.mirrorX >= 0) {
								if (x >= this.mirrorX) {
									continue;
								}
							} else if (this.mirrorY >= 0) {
								if (y >= this.mirrorY) {
									continue;
								}
							}
						}
						g.setColor(ApoHybridConstants.DARK_BRIGHT[0], ApoHybridConstants.DARK_BRIGHT[1], ApoHybridConstants.DARK_BRIGHT[2], 1f);
						if (level[y][x] == 5) {
							ApoHybridGame.drawBox(g, addPX, addPY, false, bScale);
						}
						if (level[y][x] == 6) {
							ApoHybridGame.drawAir(g, addPX, addPY, bScale);
						}
						if (level[y][x] == 10) {
							ApoHybridGame.drawSpikes(g, addPX, addPY, bScale);
						}
					}
				}
			}
		}
		g.release();

		//release old image
		if (this.iBackground != null) {
			BitsGLFactory.getInstance().markForReleasing(this.iBackground);
			BitsGLFactory.getInstance().releaseAllMarked();
		}

		//get new image
		this.iBackground = BitsGLFactory.getInstance().getImage(bitmap, BitsGLImage.FILTER_NEAREST, true);
//		BitsGLFactory.getInstance().markForLoading(this.iBackground);
		BitsGLFactory.getInstance().loadAllMarked();
	}

	private void makeMirrrorImage() {
		int width = this.level[0].length * 16;
		BitsBitmap bitmap = new BitsBitmap(512, 256, BitsBitmap.TYPE_ARGB);
		BitsGraphics g = bitmap.createGraphics();

		g.setColor(1f,1f,1f, 1f);
		for (y = 0; y < level.length; y++) {
			for (x = 0; x < level[0].length; x++) {
				int addPX = width - (x + 1) * 16;
				int addPY = y * 16;

				g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
				if ((y == playerY) && (x == playerX)) {
					ApoHybridGame.renderPlayer(g, addPX, addPY, this.add, this.gravity, this.withBox);
				}

				if (level[y][x] != 0) {
					g.setColor(ApoHybridConstants.DARK_BRIGHT[0], ApoHybridConstants.DARK_BRIGHT[1], ApoHybridConstants.DARK_BRIGHT[2]);
					if ((level[y][x] == 4) || (level[y][x] == 5) || (level[y][x] == 8)) {
						if (level[y][x] == 4) {
							ApoHybridGame.drawMoveableBox(g, addPX, addPY);
						}
						if (level[y][x] == 5) {
							ApoHybridGame.drawBox(g, addPX, addPY, false);
						}
						if (level[y][x] == 8) {
							ApoHybridGame.drawBlockPlusMirror(g, addPX, addPY);
						}
					}
					g.setColor(ApoHybridConstants.DARK_BRIGHT[0], ApoHybridConstants.DARK_BRIGHT[1], ApoHybridConstants.DARK_BRIGHT[2]);
					if (level[y][x] == 6) {
						ApoHybridGame.drawAir(g, addPX, addPY);
					}
					if (level[y][x] == 10) {
						g.setColor(ApoHybridConstants.BRIGHT_DARK[0], ApoHybridConstants.BRIGHT_DARK[1], ApoHybridConstants.BRIGHT_DARK[2]);
						ApoHybridGame.drawSpikes(g, addPX, addPY);
					}
				}
			}
		}
		g.release();

		//release old image
		this.releaseImage();

		//get new image
		this.iMirror = BitsGLFactory.getInstance().getImage(bitmap, BitsGLImage.FILTER_NEAREST, true);
//		BitsGLFactory.getInstance().markForLoading(this.iMirror);
		BitsGLFactory.getInstance().loadAllMarked();
	}

	private void addParticle(int x, int y) {
		this.particles.add(new ApoParticle(x, y, (float)(-0.05f + Math.random() * 0.03f), -0.05f));
		this.particles.add(new ApoParticle(x, y, (float)(-0.05f + Math.random() * 0.03f), -0.03f));
		this.particles.add(new ApoParticle(x, y, (float)(0.02f + Math.random() * 0.03f), -0.05f));
		this.particles.add(new ApoParticle(x, y, (float)(0.02f + Math.random() * 0.03f), -0.03f));

		if (this.bCanExplodeSound) {
			this.getGame().playSound(ApoHybridSoundPlayer.SOUND_LOSE);
			this.bCanExplodeSound = false;
		}
	}

	private void releaseImage() {
		if ((this.iMirror != null) && (this.iMirror.isLoaded)) {
			BitsGLFactory.getInstance().markForReleasing(this.iMirror);
			BitsGLFactory.getInstance().releaseAllMarked();
		}
	}

	@Override
	public void think(int delta) {
		this.bCanExplodeSound = true;
		this.beamerFrameTime += delta;
		if (this.beamerFrameTime >= ApoHybridGame.BEAMER_CHANGE_TIME) {
			this.beamerFrameTime -= ApoHybridGame.BEAMER_CHANGE_TIME;
			this.beamerFrame += 1;
			if (this.beamerFrame > 3) {
				this.beamerFrame = 0;
			}
		}

		if (this.speech == null) {
			this.speech = new ApoHybridSpeech(this.getGame(), 0, 0, false, true, "");
			this.speech.setVisible(false);
		}

		if (this.backgroundWait > 0) {
			this.backgroundWait -= delta;
		}

		if (this.p[2] == 0) {
			this.noMoveTime += delta;
			if (noMoveTime >= this.noMoveTimeNext) {
				int text = (int)(Math.random() * ApoHybridConstants.TEXT_IDLE.length);
				this.showSpeech(ApoHybridConstants.TEXT_IDLE[text]);
				this.setNoMoveTimeNext();
			}
		}
		if (this.speechShowTime > 0) {
			this.speechShowTime -= delta;
			if ((this.speechShowTime <= 0) && (this.speech != null) && (this.speech.isVisible())) {
				this.speech.setVisible(false);
			}
		}
		if (this.mirrorChange <= ApoHybridGame.MIRROR_CHANGE_TIME) {
			this.mirrorChange += delta;
		}
		if (this.frameGravityTime > 0) {
			this.frameGravityTime -= delta;
		} else {
			this.frameGravity += 0.1f * this.frameGravityAdd;
			if ((this.frameGravity > 16) || (this.frameGravity < 0)) {
				this.frameGravityAdd = -this.frameGravityAdd;
				this.frameGravityTime = FRAME_GRAVITY_TIME;
			}
		}

		this.frameTimeGoal += delta;
		if (this.frameTimeGoal > ApoHybridGame.FRAME_TIME) {
			this.frameTimeGoal -= ApoHybridGame.FRAME_TIME;
			this.frameGoal += 1;
			if (this.frameGoal > 3) {
				this.frameGoal = 0;
			}
		}

		for (int k = this.particles.size() - 1; k >= 0; k--) {
			this.particles.get(k).think(delta);
			if (!this.particles.get(k).isVisible()) {
				this.particles.remove(k);
			}
		}
		p[4] += 10;
		if (p[7] > 0) {
			p[7] -= 10;
		}
		if (level[0][0] == -1) {
			this.loadLevel(p[0], this.bUserlevel, this.levelString);
		} else if (p[2] >= 1) {
			if (p[4] < 256) {
				return;
			}
			boolean bSolved = false;
			if (p[5] > 0) {
				bSolved = true;
				p[5] = -1;
			}
			if (bSolved) {
				if (p[2] == 1) {
					p[0] += 1;
					if (bEditor) {
						this.getGame().setEditor(true);
						return;
					}
				}
				this.loadLevel(p[0], this.bUserlevel, this.levelString);
				return;
			}
		} else {
			if (p[3] > 0) {
				p[3] -= 10;
				if (p[3] == 0) {
					if (this.mirrorX >= 0) {
						for (y = 0; y < level.length; y++) {
							for (x = this.mirrorX; x < level[0].length; x++) {
								if (this.boxes[y][x] == 6) {
									this.boxes[y][x] = 0;
								}
							}
						}
						for (y = 0; y < level.length; y++) {
							for (x = 0; x < level[0].length; x++) {
								if ((mirrorX + x < level[0].length) && (level[y][mirrorX + x] >= 4) && (level[y][mirrorX + x] != 12) && (level[y][mirrorX + x] < 20)) {
									if ((mirrorX - x - 1 >= 0) && (mirrorX + x < level[0].length)) {
										if ((level[y][mirrorX - 1 - x] != level[y][mirrorX + x]) && ((level[y][mirrorX - 1 - x] > 0) || (boxes[y][mirrorX - 1 - x] == 11))) {
											this.addParticle((mirrorX - 1 - x) * 16 + 8, y * 16 + changeY + 8);
										}
										if ((level[y][mirrorX - 1 - x] != 7) && (level[y][mirrorX - 1 - x] != 3)) {
											if (boxes[y][mirrorX - 1 - x] == 11) {
												if (level[y][mirrorX + x] == 4) {
													level[y][mirrorX + x] = 0;
													level[y][mirrorX - 1 - x] = 4;
													this.beamValue(mirrorX - 1 - x, y);
												}
												/** TODO BEAMER */
											} else if ((level[y][mirrorX + x] != 7) && (level[y][mirrorX + x] != 11)) {
												level[y][mirrorX - 1 - x] = level[y][mirrorX + x];
												if ((boxes[y][mirrorX + x] == 6) || (level[y][mirrorX - 1 - x] == 6)) {
													boxes[y][mirrorX - 1 - x] = 6;
												} else if ((level[y][mirrorX - 1 - x] == 10) && (withBox != 0) && (playerY - this.gravity == y) && (playerX == mirrorX - 1 - x)) {
													withBox = 0;
													this.addParticle((mirrorX - 1 - x) * 16 + 8, y * 16 + changeY + 8);
												}
											}
										}
										if (level[y][mirrorX - 1 - x] != 8) {
											level[y][mirrorX + x] = boxes[y][mirrorX + x];
										}

									} else if ((mirrorX - x - 1 < 0) && (mirrorX + x < level[0].length) && (level[y][mirrorX + x] != 8)) {
										level[y][mirrorX + x] = boxes[y][mirrorX + x];
									}
									if (level[y][mirrorX + x] == 7) {
										boxes[y][mirrorX + x] = level[y][mirrorX + x] = 7;
									}
								}
								if ((y == playerY) && (mirrorX + x == playerX)) {
									playerX = mirrorX - 1 - x;
									if ((playerX < 0) || (playerX >= level[0].length)) {
										this.lostLevel();
										playerX = 0;
									}
									if (mirrorX - 1 - x >= 0) {
										if ((level[y][mirrorX - 1 - x] == 7) || (level[y][mirrorX - 1 - x] == 10)) {
											this.lostLevel();
										}
										if (level[y][mirrorX - 1 - x] == 3) {
											this.winLevel();
										}
										if ((boxes[y][mirrorX - 1 - x] == 11) && (p[2] <= 0)) {
											/** TODO Beamer */
											this.beamValue(mirrorX - 1 - x, y);
										}
									}
								}
							}
						}
						p[1] -= 1;
					} else if (this.mirrorY >= 0) {
						for (y = this.mirrorY; y < level.length; y++) {
							for (x = 0; x < level[0].length; x++) {
								if (this.boxes[y][x] == 6) {
									this.boxes[y][x] = 0;
								}
							}
						}
						for (y = 0; y < level.length; y++) {
							for (x = 0; x < level[0].length; x++) {
								if ((mirrorY + y < level.length) && (level[mirrorY + y][x] >= 4) && (level[mirrorY + y][x] != 12) && (level[mirrorY + y][x] < 20)) {
									if ((mirrorY - y - 1 >= 0) && (mirrorY + y < level.length)) {
										if ((level[mirrorY - 1 - y][x] != level[mirrorY + y][x]) && ((level[mirrorY - 1 - y][x] > 0) || (boxes[mirrorY - 1 - y][x] == 11))) {
											this.addParticle((x) * 16 + 8, (mirrorY - 1 - y) * 16 + changeY + 8);
										}
										if ((level[mirrorY - 1 - y][x] != 7) && (level[mirrorY - 1 - y][x] != 3)) {
											if (boxes[mirrorY - 1 - y][x] == 11) {
												if (level[mirrorY + y][x] == 4) {
													level[mirrorY + y][x] = 0;
													level[mirrorY - 1 - y][x] = 4;
													this.beamValue(x, mirrorY - 1 - y);
												}
												/** TODO BEAMER */
											} else if ((level[mirrorY + y][x] != 7) && (level[mirrorY + y][x] != 11)) {
												level[mirrorY - 1 - y][x] = level[mirrorY + y][x];
												if (level[mirrorY - 1 - y][x] == 6) {
													boxes[mirrorY - 1 - y][x] = 6;
												} else if ((level[mirrorY - 1 - y][x] == 10) && (withBox != 0) && (mirrorY - 1 - y - this.gravity == y) && (playerX == x)) {
													withBox = 0;
													this.addParticle((x) * 16 + 8, (mirrorY - 1 - y) * 16 + changeY + 8);
												}
											}
										}
										if (level[mirrorY - 1 - y][x] != 8) {
											level[mirrorY + y][x] = boxes[mirrorY + y][x];
										}

									} else if ((mirrorY - y - 1 < 0) && (mirrorY + y < level.length) && (level[mirrorY + y][x] != 8)) {
										level[mirrorY + y][x] = boxes[mirrorY + y][x];
									}
									if (level[mirrorY + y][x] == 7) {
										level[mirrorY + y][x] = 7;
									}
								}
								if ((x == playerX) && (mirrorY + y == playerY)) {
									playerY = mirrorY - 1 - y;
									if ((playerY < 0) || (playerY >= level.length)) {
										this.lostLevel();
										playerY = 0;
									}
									if (mirrorY - 1 - y >= 0) {
										if ((level[mirrorY - 1 - y][x] == 7) || (level[mirrorY - 1 - y][x] == 10)) {
											this.lostLevel();
										}
										if (level[mirrorY - 1 - y][x] == 3) {
											this.winLevel();
										}
										if ((p[2] <= 0) && (this.withBox > 0)) {
											if ((playerY + this.withBox * this.gravity >= 0) && (playerY + this.withBox * this.gravity < level.length)) {
												level[playerY + this.withBox * this.gravity][playerX] = 4;
												this.withBox = 0;
											}
										}
										if ((boxes[mirrorY - 1 - y][x] == 11) && (p[2] <= 0)) {
											/** TODO Beamer */
											this.beamValue(x, mirrorY - 1 - y);
										}
									}
								}
							}
						}
						p[8] -= 1;
					}
					if (p[2] <= 0) {
						if ((level[playerY][playerX] == 1) || (level[playerY][playerX] == 12) || (level[playerY][playerX] == 8) || (level[playerY][playerX] == 4) || (level[playerY][playerX] == 5) || (level[playerY][playerX] == 10)) {
							this.lostLevel();
						}
					}

					mirrorX = -1;
					mirrorY = -1;
					this.makeBackground();
					if ((p[1] > 0) || (p[8] > 0)) {
						this.makeMirrrorImage();
					}
				}
			}

			int move = 0;
			int up = 0;
			int mirrorMode = 0;
			if (p[6] < changeY) {
				if ((p[5] > ApoHybridConstants.GAME_WIDTH/2 - 95) && (p[5] < ApoHybridConstants.GAME_WIDTH/2 - 55)) {
					this.loadLevel(p[0] - 1, this.bUserlevel, this.levelString);
					return;
				}
				if ((p[5] > ApoHybridConstants.GAME_WIDTH/2 + 55) && (p[5] < ApoHybridConstants.GAME_WIDTH/2 + 95)) {
					this.loadLevel(p[0] + 1, this.bUserlevel, this.levelString);
					return;
				}
			} else if (p[6] > changeY + 240) {
				if ((p[6] > changeY + 245) && (p[6] < changeY + 285)) {
					if ((p[5] > ApoHybridConstants.GAME_WIDTH/2 - 20) && (p[5] < ApoHybridConstants.GAME_WIDTH/2 + 20)) {
						if (p[3] <= 0) {
							if ((this.backsteps.size() > 1) || ((playerX != playerStartX) || (playerY != playerStartY))) {
								this.setPreviousStep();
							}
						}
						p[5] = -1;
						return;
					}
					if ((p[5] > 5) && (p[5] < 45) && (p[7] <= 0)) {
						move = -1;
						if ((mirrorX >= 0) || (mirrorY >= 0)) {
							if (this.mirrorChange < ApoHybridGame.MIRROR_CHANGE_TIME) {
								move = 0;
							} else {
								this.mirrorChange -= ApoHybridGame.MIRROR_CHANGE_TIME;
							}
						}
					} else if ((p[5] > ApoHybridConstants.GAME_WIDTH - 45) && (p[5] < ApoHybridConstants.GAME_WIDTH - 5)) {
						up = 1;
						p[5] = -1;
					} else if ((p[5] > 55) && (p[5] < 95) && (p[7] <= 0)) {
						move = +1;
						if ((mirrorX >= 0) || (mirrorY >= 0)) {
							if (this.mirrorChange < ApoHybridGame.MIRROR_CHANGE_TIME) {
								move = 0;
							} else {
								this.mirrorChange -= ApoHybridGame.MIRROR_CHANGE_TIME;
							}
						}
					} else if ((p[5] > ApoHybridConstants.GAME_WIDTH - 95) && (p[5] < ApoHybridConstants.GAME_WIDTH - 55)) {
						mirrorMode = 1;
						p[5] = -1;
					} else if ((p[5] > ApoHybridConstants.GAME_WIDTH - 195) && (p[5] < ApoHybridConstants.GAME_WIDTH - 155)) {
						mirrorMode = 2;
						p[5] = -1;
					} else if ((p[5] > ApoHybridConstants.GAME_WIDTH - 145) && (p[5] < ApoHybridConstants.GAME_WIDTH - 105)) {
						mirrorMode = 3;
						p[5] = -1;
					} else if ((p[5] > 105) && (p[5] < 145) && (p[9] > 0) && (fall == 0) && (this.mirrorX < 0) && (this.mirrorY < 0)) {
						p[9] -= 1;
						this.gravity = -this.gravity;
						if (this.withBox > 0) {
							withBox = 0;
							level[playerY + this.gravity][playerX] = 4;
						}
						p[5] = -1;
						this.getGame().playSound(ApoHybridSoundPlayer.SOUND_GRAVITY);
					}
				}
			}
			if ((mirrorX >= 0) && (p[3] <= 0)) {
				if ((mirrorMode == 2) && (mirrorX >= 0)) {
					mirrorX = -1;
					mirrorY = -1;
				}
				if ((mirrorMode == 1) && (p[1] > 0)) {
					p[3] = 960;

					this.makeBackground();
					this.saveNextBackstep();
					this.getGame().playSound(ApoHybridSoundPlayer.SOUND_FOLD);
				}
				if (move == -1) {
					if (mirrorX > 1) {
						mirrorX -= 1;
						i = 1;
					}
				}
				if (move == 1) {
					if (mirrorX < 28) {
						mirrorX += 1;
						i = 1;
					}
				}
				if ((mirrorX >= 0) && (i != 0)) {
					i = 0;
				}
			} else if ((mirrorY >= 0) && (p[3] <= 0)) {
				if ((mirrorMode == 2) && (mirrorY >= 0)) {
					mirrorX = -1;
					mirrorY = -1;
				}
				if ((mirrorMode == 3) && (p[8] > 0)) {
					p[3] = 960;

					this.makeBackground();
					this.saveNextBackstep();
					this.getGame().playSound(ApoHybridSoundPlayer.SOUND_FOLD);
				}
				if (move == -1) {
					if (mirrorY > 1) {
						mirrorY -= 1;
						i = 1;
					}
				}
				if (move == 1) {
					if (mirrorY < 14) {
						mirrorY += 1;
						i = 1;
					}
				}
				if ((mirrorY >= 0) && (i != 0)) {
					i = 0;
				}
			} else if ((addX == 0) && (addY == 0) && (fall == 0)) {
				/** FALL */
				this.fall();

				if (fall != 0) {
				} else if (p[3] <= 0) {
					addLeft = 0;
					if ((mirrorMode == 1) && (p[1] > 0)) {
						if (mirrorX < 0) {
							mirrorX = 15;
							this.mirrorChange = ApoHybridGame.MIRROR_CHANGE_TIME;
							this.makeMirrrorImage();
							return;
						}
					}
					if ((mirrorMode == 3) && (p[8] > 0)) {
						if (mirrorY < 0) {
							mirrorY = 7;
							this.mirrorChange = ApoHybridGame.MIRROR_CHANGE_TIME;
							this.makeMirrrorImage();
							return;
						}
					}
					if (move == -1) {
						addLeft = -1;
						if (add == 0) {
							this.saveNextBackstep();
							add = 1;
							p[7] = 250;
							return;
						}
						add = 1;
					}
					if (move == 1) {
						addLeft = 1;
						if (add == 1) {
							this.saveNextBackstep();
							add = 0;
							p[7] = 250;
							return;
						}
						add = 0;
					}
					if ((up == 1) && (withBox == 0)) {
						this.hideSpeech();
						addLeft = 1;
						if (add == 1) {
							addLeft = -1;
						}
						if ((playerX + addLeft >= 0) && (playerX + addLeft < level[playerY].length)) {
							if ((playerY - this.gravity >= 0) && (((level[playerY - this.gravity][playerX] == 0) || ((level[playerY - this.gravity][playerX] > 5) && (level[playerY - this.gravity][playerX] != 8) && (level[playerY - this.gravity][playerX] != 12)) || (level[playerY - this.gravity][playerX] == 3)))) {
								if (level[playerY][playerX + addLeft] == 4) {
									if ((playerY - this.gravity >= 0) && (playerY - this.gravity < level.length) && (((level[playerY - this.gravity][playerX + addLeft] == 0) || ((level[playerY - this.gravity][playerX + addLeft] > 5) && (level[playerY - this.gravity][playerX + addLeft] < 8)) || (level[playerY - this.gravity][playerX + addLeft] == 3)))) {
										this.saveNextBackstep();
										withBox = 1;
										level[playerY][playerX + addLeft] = boxes[playerY][playerX + addLeft];
										this.getGame().playSound(ApoHybridSoundPlayer.SOUND_PICK);
									}
								}
							}
						}
						return;
					}
					if ((up == 1) && (withBox != 0)) {
						this.hideSpeech();
						addLeft = 1;
						if (add == 1) {
							addLeft = -1;
						}
						if ((playerX + addLeft >= 0) && (playerX + addLeft < level[playerY].length)) {
							if (((level[playerY][playerX + addLeft] == 0) || (level[playerY][playerX + addLeft] == 11) || ((level[playerY][playerX + addLeft] > 5) && (level[playerY][playerX + addLeft] < 8))) && ((level[playerY - this.gravity][playerX + addLeft] == 0) || (level[playerY - this.gravity][playerX + addLeft] == 11) || ((level[playerY - this.gravity][playerX + addLeft] > 5) && (level[playerY - this.gravity][playerX + addLeft] < 8)))) {
								this.saveNextBackstep();
								level[playerY][playerX + addLeft] = 4;
								if (boxes[playerY][playerX + addLeft] == 11) {
									this.beamValue(playerX + addLeft, playerY);
								}
								withBox = 0;
								this.getGame().playSound(ApoHybridSoundPlayer.SOUND_DROP);
							} else if ((level[playerY - this.gravity][playerX + addLeft] == 0) || (level[playerY - this.gravity][playerX + addLeft] == 11) || ((level[playerY - this.gravity][playerX + addLeft] > 5) && (level[playerY - this.gravity][playerX + addLeft] < 8))) {
								this.saveNextBackstep();
								level[playerY - this.gravity][playerX + addLeft] = 4;
								if (boxes[playerY - this.gravity][playerX + addLeft] == 11) {
									this.beamValue(playerX + addLeft, playerY - this.gravity);
								}
								withBox = 0;
								this.getGame().playSound(ApoHybridSoundPlayer.SOUND_DROP);
							}
						}
						return;
					}
					if (addLeft != 0) {
						if ((playerX + addLeft >= 0) && (playerX + addLeft < level[playerY].length)) {
							if ((withBox == 0) || (level[playerY-withBox*this.gravity][playerX + addLeft] == 0) || ((level[playerY-withBox*this.gravity][playerX + addLeft] > 5) && (level[playerY-withBox*this.gravity][playerX + addLeft] != 8) && (level[playerY-withBox*this.gravity][playerX + addLeft] != 12) && (level[playerY-withBox*this.gravity][playerX + addLeft] != 10)) || (level[playerY-withBox*this.gravity][playerX + addLeft] == 3)) {
								if ((level[playerY][playerX + addLeft] == 0) || ((level[playerY][playerX + addLeft] > 5) && (level[playerY][playerX + addLeft] != 8) && (level[playerY][playerX + addLeft] != 12)) || (level[playerY][playerX + addLeft] == 3)) {
									if ((playerY + this.gravity < this.level.length) && (this.level[playerY + this.gravity][playerX] == 12)) {
										this.level[playerY + this.gravity][playerX] = 0;
										this.addParticle((playerX) * 16 + 8, (playerY + this.gravity) * 16 + changeY + 8);
									}
									playerX += addLeft;
									addX = -addLeft * 16;
									addY = 0;
									this.hideSpeech();
								} else if ((playerY - this.gravity >= 0) && (((level[playerY - this.gravity][playerX + addLeft] == 0) || ((level[playerY - this.gravity][playerX + addLeft] > 5) && (level[playerY - this.gravity][playerX + addLeft] != 8) && (level[playerY - this.gravity][playerX + addLeft] != 10) && (level[playerY - this.gravity][playerX + addLeft] != 12)) || (level[playerY - this.gravity][playerX + addLeft] == 3)))) {
									if ((playerY - this.gravity >= 0) && (((level[playerY - this.gravity][playerX] == 0) || ((level[playerY - this.gravity][playerX] > 5) && (level[playerY - this.gravity][playerX] != 8) && (level[playerY - this.gravity][playerX] != 10) && (level[playerY - this.gravity][playerX] != 12)) || (level[playerY - this.gravity][playerX] == 3)))) {
										if ((withBox == 0) || (playerY-withBox*this.gravity - this.gravity < 0) || (playerY-withBox*this.gravity - this.gravity >= this.level.length) || (level[playerY-withBox*this.gravity - this.gravity][playerX] == 0) || ((level[playerY-withBox*this.gravity - this.gravity][playerX] > 5) && (level[playerY-withBox*this.gravity - this.gravity][playerX] != 8) && (level[playerY-withBox*this.gravity - this.gravity][playerX] != 12) && (level[playerY-withBox*this.gravity - this.gravity][playerX] != 10)) || (level[playerY-withBox*this.gravity - this.gravity][playerX] == 3)) {
											if ((withBox == 0) || (playerY-withBox*this.gravity - this.gravity < 0) || (playerY-withBox*this.gravity - this.gravity >= this.level.length) || (level[playerY-withBox*this.gravity - this.gravity][playerX + addLeft] == 0) || ((level[playerY-withBox*this.gravity - this.gravity][playerX + addLeft] > 5) && (level[playerY-withBox*this.gravity - this.gravity][playerX + addLeft] != 8) && (level[playerY-withBox*this.gravity - this.gravity][playerX + addLeft] != 10) && (level[playerY-withBox*this.gravity - this.gravity][playerX + addLeft] != 12)) || (level[playerY-withBox*this.gravity - this.gravity][playerX + addLeft] == 3)) {
												if (playerY - withBox * this.gravity - this.gravity < 0) {
													this.addParticle((playerX) * 16 + 8, (playerY - this.gravity) * 16 + changeY + 8);
													this.withBox = 0;
												}
												if (playerY - withBox * this.gravity - this.gravity >= level.length) {
													this.addParticle((playerX) * 16 + 8, (playerY - this.gravity) * 16 + changeY + 8);
													this.withBox = 0;
												}

												if ((playerY + this.gravity < this.level.length) && (this.level[playerY + this.gravity][playerX] == 12)) {
													this.level[playerY + this.gravity][playerX] = 0;
													this.addParticle((playerX) * 16 + 8, (playerY + this.gravity) * 16 + changeY + 8);
												}

												playerX += addLeft;
												playerY -= 1 * this.gravity;
												addX = -addLeft * 16;
												addY = 16 * this.gravity;
												this.hideSpeech();
											}
										}
									}
								}
							}
						}
					}
				}
			} else if (fall != 0) {
				fall = 0;
				boolean bPlayer = true;
				int start = level.length - 1;
				if (this.gravity < 0) {
					start = 0;
				}
				for (int y = start; y >= 0 && y < level.length; y += -this.gravity) {
					for (int x = 0; x < level[0].length; x++) {
						if (falla[y][x] > 0) {
							falla[y][x] -= 1;
							fall = 1;
							if ((x != playerX) || (y != playerY)) {
								bPlayer = false;
							}
							if (falla[y][x] == 0) {
								if ((boxes[y][x] == 11) && (((x == playerX) && (y == playerY)) || (level[y][x] == 4))) {
									/** TODO Beamer */
									this.beamValue(x, y);
								} else if ((x == playerX) && (y + this.gravity == playerY)) {
									this.lostLevel();
								} else if (level[playerY][playerX] == 10) {
									this.lostLevel();
								}
							}
						}
					}
				}
				if (fall == 0) {
					for (x = 0; x < level[0].length; x++) {
						if ((level[level.length - 1][x] == 4) && (this.gravity > 0)) {
							level[level.length - 1][x] = 0;
							this.addParticle(x * 16, (level.length - 1) * 16);
						}
						if ((level[0][x] == 4) && (this.gravity < 0)) {
							level[0][x] = 0;
							this.addParticle(x * 16, 0);
						}
						if (((playerY == 0) && (this.gravity < 0)) || (this.playerY < 0)) {
							this.lostLevel();
							break;
						}
						if (((playerY == level.length - 1) && (this.gravity > 0)) || (this.playerY >= level.length)) {
							this.lostLevel();
							break;
						}
					}
					if (level[playerY][playerX] == 3) {
						this.winLevel();
					}
					if ((p[2] <= 0) && (!bPlayer)) {
						this.saveNextBackstep();
					}
				}
			} else {
				if (this.gravity > 0) {
					if (addY > 0) {
						addY -= 4;
					} else if (addX > 0) {
						addX -= 1;
					} else if (addX < 0) {
						addX += 1;
					} else if (addY < 0) {
						addY += 4;
					}
				} else {
					if (addY < 0) {
						addY += 4;
					} else if (addX > 0) {
						addX -= 1;
					} else if (addX < 0) {
						addX += 1;
					} else if (addY > 0) {
						addY -= 4;
					}
				}
				if ((addY == 0) && (addX == 0)) {
					if (level[playerY][playerX] == 3) {
						this.winLevel();
					} else if (level[playerY][playerX] == 10) {
						this.lostLevel();
					} else if (boxes[playerY][playerX] == 11) {
						/** TODO Beamer */
						this.beamValue(playerX, playerY);
					}
					this.think(delta);
				}
			}
		}
	}

	private void fallNew(final int x, final int startY) {
		int start = 0;
		int end = startY;
		if (gravity < 0) {
			start = level.length - 1;
			end = startY;
		}
		for (int y = start; y != end; y += this.gravity) {
			if (this.falla[y][x] != 0) {
				if ((x == playerX) && (y == playerY)) {
					playerY -= this.falla[y][x]/16 * this.gravity;
				} else {
					this.level[y - this.falla[y][x]/16 * this.gravity][x] = this.level[y][x];
				}
				this.level[y][x] = this.boxes[y][x];
				if (level[y][x] == 11) {
					level[y][x] = 0;
				}
				this.falla[y][x] = 0;
			}
		}
	}

	private void fall() {
		for (int x = 0; x < level[0].length; x++) {
			if (p[2] > 0) {
				break;
			}
			int addFall = 0;
			int addFallPlayer = 0;
			int start = 0;
			if (gravity > 0) {
				start = level.length - 1;
			}

			for (int y = start; y >= 0 && y < level.length; y += -this.gravity) {
				if ((level[y][x] == 1) || (level[y][x] == 12) || (level[y][x] == 5) || (level[y][x] == 8) || (level[y][x] == 10)) {
					addFallPlayer = addFall = 0;
				} else if (((level[y][x] == 0) || (level[y][x] > 5)) && (level[y][x] < 8) && ((playerX != x) || (playerY != y))) {
					addFall += 1;
					addFallPlayer += 1;
				}

				if ((x == playerX) && (y == playerY)) {
					if ((y + addFallPlayer*this.gravity + this.gravity >= 0) && (y + addFallPlayer*this.gravity + this.gravity < this.level.length)) {
						if (level[y+addFallPlayer*this.gravity+this.gravity][x] == 3) {
							addFallPlayer += 1;
						}
					}
				}

				if (boxes[y][x] == 11) {
					/** TODO Beamer */
					if ((y + addFall + this.gravity >= 0) && (y + addFall + this.gravity < this.level.length) && (addFall == 0) && ((level[y+this.gravity][x] == 12) || (level[y+this.gravity][x] == 1) || (level[y+this.gravity][x] == 4) || (level[y+this.gravity][x] == 5) || (level[y+this.gravity][x] == 8))) {
						addFallPlayer = addFall = 0;
					} else {
						addFallPlayer = addFall = 1;
					}
				}
				if ((x == playerX) && (y == playerY - withBox * this.gravity) && (withBox > 0)) {
					addFallPlayer = addFall = 0;
				}
				if ((level[y][x] == 4) && (x == playerX) && (y + this.gravity == playerY)) {
					this.lostLevel();
					break;
				}

				if ((level[y][x] == 3) || (level[y][x] == 10)) {
					if ((x == playerX) && (y == playerY + (addFallPlayer + 1) * this.gravity)) {
						addFallPlayer = 1;
						addFall = 0;
					} else {
						addFallPlayer = addFall = 0;
					}
				}
				if (((level[y][x] == 4) || ((x == playerX) && (y == playerY))) && (addFallPlayer > 0)) {
					if ((boxes[y][x] == 11) && (addFallPlayer == 1)) {
						if ((y + this.gravity >= 0) && (y + this.gravity < level.length)) {
							if ((level[y + this.gravity][x] == 1) || (level[y + this.gravity][x] == 4) || (level[y + this.gravity][x] == 5) || (level[y + this.gravity][x] == 8)) {
								addFallPlayer = addFall = 0;
								addFallPlayer = 0;
								continue;
							}
						}
					}
					if ((x == playerX) && (y == playerY)) {
						if ((y + addFallPlayer*this.gravity + this.gravity >= 0) && (y + addFallPlayer*this.gravity + this.gravity < this.level.length)) {
							if (level[y+addFallPlayer*this.gravity+this.gravity][x] == 3) {
								addFallPlayer += 1;
							}
						}
					}
					if (this.gravity < 0) {
						addFall = -addFall;
						addFallPlayer = -addFallPlayer;
					}
					if ((x == playerX) && (y == playerY)) {
						addFall = addFallPlayer;
						playerY += addFall;
					} else {
						level[y + addFall][x] = level[y][x];
						level[y][x] = boxes[y][x];
					}
					falla[y + addFall][x] = addFall * 16 * this.gravity;
					fall = 1;
					if ((x == playerX) && (y == playerY - addFall)) {
						y -= withBox;
					}
					if (this.gravity < 0) {
						addFall = -addFall;
						addFallPlayer = -addFallPlayer;
					}
				}

			}
		}
	}

	private boolean beamValue(final int startX, final int startY) {
		int value = this.level[startY][startX];
		if (value != 4) {
			value = 2;
		}
		for (int y = 0; y < level.length; y++) {
			for (int x = 0; x < level[0].length; x++) {
				if (((x != startX) || (y != startY)) && (boxes[y][x] == 11)) {
					if ((level[y][x] == 0) || (level[y][x] == 11)) {
						if ((x == playerX) && (y == playerY) && (falla[y][x] == 0)) {
							return false;
						}

						this.fallNew(x, y);
						this.level[startY][startX] = 0;
						this.level[y][x] = value;
						if (this.level[y][x] != 4) {
							this.level[y][x] = 0;
							this.playerX = x;
							this.playerY = y;
							if (this.withBox > 0) {
								if (this.level[startY - this.gravity][startX] != 1) {
									this.level[startY - this.gravity][startX] = 4;
								}
								this.withBox = 0;
							}
						}
						this.fall();
						return true;
					}
				}
			}
		}
		return false;
	}

	private void lostLevel() {
		this.addParticle((playerX) * 16 + 8, playerY * 16 + changeY + 8);
		p[4] = 0;
		p[2] = 2;
	}

	private void winLevel() {
		p[4] = 0;
		p[2] = 1;
		int text = (int)(Math.random() * ApoHybridConstants.TEXT_WIN.length);
		this.showSpeech(ApoHybridConstants.TEXT_WIN[text]);
		if ((!this.bUserlevel) && (!this.bEditor)) {
			this.getGame().solveLevel(p[0]);
		}
		this.getGame().playSound(ApoHybridSoundPlayer.SOUND_WIN);
	}

	private void showSpeech(String text) {
		this.speech.setX(this.playerX * 16 + 8);
		this.speech.setY(this.playerY * 16 + ApoHybridGame.changeY - 20);
		this.speech.setText(text);
		if (this.add != 0) {
			this.speech.setLeft(true);
		} else {
			this.speech.setLeft(false);
		}
		if (this.gravity > 0) {
			this.speech.setUp(true);
		} else {
			this.speech.setUp(false);
		}
		this.speech.setVisible(true);
		this.speechShowTime = ApoHybridGame.SPEECH_MAX_TIME;
	}

	private void hideSpeech() {
		this.speech.setVisible(false);
		this.noMoveTime = 0;
	}

	@Override
	public void render(BitsGLGraphics g) {
		g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);

		String s = "Level";
		this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 10 - ApoHybridPanel.game_font.mCharCellHeight/2, ApoHybridPanel.game_font);

		if (!this.bEditor) {
			if (this.bUserlevel) {
				s = (p[0] + 1)+" / "+(ApoHybridLevel.editorLevels.length);
			} else {
				if (this.getGame().getSolvedLevels().isLevelSolved(p[0])) {
					g.setColor(0f, 1f, 0f, 1f);

					g.setLineSize(4f);
					g.drawLine(240 - ApoHybridPanel.game_font.getLength(s)/2, 30, 245 - ApoHybridPanel.game_font.getLength(s)/2, 35);
					g.drawLine(245 - ApoHybridPanel.game_font.getLength(s)/2, 35, 255 - ApoHybridPanel.game_font.getLength(s)/2, 25);
					g.setLineSize(1f);

					g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
				}
				s = (p[0] + 1)+" / "+(this.getGame().getMaxCanChoosen() + 1);
			}
		} else {
			s = "Editor";
		}
		this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 30 - ApoHybridPanel.game_font.mCharCellHeight/2, ApoHybridPanel.game_font);

		ApoHybridGame.drawMenu(g, this.getGame(), ApoHybridConstants.DARK_BRIGHT, ApoHybridConstants.DARK, p[1], p[8], p[9], this.frameGravity);

		this.getGame().drawButtons(g, ApoHybridPanel.game_font, 2);

		g.setColor(1f,1f,1f,1f);
		if ((this.iBackground != null) && (this.iBackground.isLoaded) && (this.backgroundWait <= 0)) {
			int scale = 1;
			if (this.iBackground.mWidth > 512) {
				scale = 2;
			}
			g.cropImage(this.iBackground, 0, changeY, ApoHybridConstants.GAME_WIDTH, 242, 0, 0, ApoHybridConstants.GAME_WIDTH * scale, 242 * scale);
		}

		for (y = 0; y < level.length; y++) {
			for (x = 0; x < level[0].length; x++) {
				int addPX = x * 16;
				int addPY = y * 16 + changeY - falla[y][x] * this.gravity;
				if (level[y][x] != 0) {
					g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);

					if (level[y][x] == 3) {
						addPY += falla[y][x] * this.gravity;
						/** Render das Ziel */
						if (p[2] == 1) {
							g.fillRect(addPX + 11, addPY + 8, 4, 2);
							addPY -= 8;
						}
						ApoHybridGame.drawFinish(g, addPX, addPY, this.frameGoal);
					}
					if ((level[y][x] == 1) || (level[y][x] == 4) || (level[y][x] == 5) || (level[y][x] == 8)) {
						if ((level[y][x] > 1) && (level[y][x] < 8) && (p[3] > 0) && (mirrorX - 1 < x) && (mirrorX >= 0)) continue;
						if ((level[y][x] > 1) && (level[y][x] < 8) && (p[3] > 0) && (mirrorY - 1 < y) && (mirrorY >= 0)) continue;
						if (level[y][x] != 1) {
							g.setColor(ApoHybridConstants.DARK_BRIGHT[0], ApoHybridConstants.DARK_BRIGHT[1], ApoHybridConstants.DARK_BRIGHT[2], 1f);
						}
						if (level[y][x] == 4) {
							g.setColor(ApoHybridConstants.DARK_BRIGHT[0], ApoHybridConstants.DARK_BRIGHT[1], ApoHybridConstants.DARK_BRIGHT[2], 1f);
							ApoHybridGame.drawMoveableBox(g, addPX, addPY);
						} else if ((!this.iBackground.isLoaded) || (this.backgroundWait > 0)) {
							if (level[y][x] == 1) {
								ApoHybridGame.drawBlock(g, addPX, addPY);
							} else {
								if (level[y][x] == 8) {
									ApoHybridGame.drawBlockPlusMirror(g, addPX, addPY);
								} else {
									ApoHybridGame.drawBox(g, addPX, addPY, false);
								}
							}
						}
					}
					if ((!this.iBackground.isLoaded) || (this.backgroundWait > 0)) {
						if (level[y][x] == 6) {
							if ((p[3] > 0) && (((x >= this.mirrorX) && (this.mirrorX > 0)) || ((y >= this.mirrorY) && (this.mirrorY > 0)))) {
							} else {
								ApoHybridGame.drawAir(g, addPX, addPY);
							}
						}
						if (level[y][x] == 7) {
							ApoHybridGame.drawX(g, addPX, addPY);
						}
						if (level[y][x] == 10) {
							if ((p[3] > 0) && (x >= this.mirrorX)) {
							} else {
								g.setColor(ApoHybridConstants.DARK_BRIGHT[0], ApoHybridConstants.DARK_BRIGHT[1], ApoHybridConstants.DARK_BRIGHT[2], 1f);
								addPY += falla[y][x] * this.gravity;
								ApoHybridGame.drawSpikes(g, addPX, addPY);
							}
						}
					}
				}
				if (level[y][x] == 12) {
					ApoHybridGame.drawOnStepBlock(g, addPX, addPY);
				}
				if ((level[y][x] == 11) || (boxes[y][x] == 11)) {
					addPY += falla[y][x] * this.gravity;
					g.setColor(ApoHybridConstants.DARK_BRIGHT[0], ApoHybridConstants.DARK_BRIGHT[1], ApoHybridConstants.DARK_BRIGHT[2], 1f);
					ApoHybridGame.drawBeamer(g, addPX, addPY, this.beamerFrame);
				}
			}
		}

		g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
		if (p[2] <= 1) {
			if ((p[3] > 0) && (((this.mirrorX <= playerX) && (this.mirrorX > 0)) || ((this.mirrorY <= playerY) && (this.mirrorY > 0)))) {

			} else {
				ApoHybridGame.renderPlayer(g, playerX * 16 + addX, playerY * 16 + changeY + addY - falla[playerY][playerX] * this.gravity, add, this.gravity, withBox);
			}
		}

		if (p[1] <= 1) {
			if ((this.speech != null) && (this.speech.isVisible())) {
				this.speech.render(g);
			}
		}

		if (mirrorX >= 0) {
			g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
			for (y = 0; y < 240; y += 4) {
				g.fillRect(mirrorX * 16 - 1, y + changeY, 2, 2);
			}
			g.setColor(1f,1f,1f,0.5f);

			if (this.iMirror != null) {
				if (this.iMirror.isLoaded) {
					int width = ApoHybridConstants.GAME_WIDTH - mirrorX * 16;
					g.cropImage(this.iMirror, mirrorX * 16 - width, changeY, width, 240, 0, 0, width, 240);
				}
			}
		}
		if (mirrorY >= 0) {
			g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
			for (x = 0; x < ApoHybridConstants.GAME_WIDTH; x += 4) {
				g.fillRect(x, mirrorY * 16 - 1 + changeY, 2, 2);
			}
			g.setColor(1f,1f,1f,0.5f);

			if (this.iMirror != null) {
				if( this.iMirror.isLoaded == true ) {
					int height = 240 - mirrorY * 16;
					g.cropImage(this.iMirror, ApoHybridConstants.GAME_WIDTH, changeY + mirrorY * 16, -ApoHybridConstants.GAME_WIDTH, -height, 0, 240 - height, ApoHybridConstants.GAME_WIDTH, height);
				}
			}
		}
		g.setColor(1f, 1f, 1f, 1f);
		if ((p[3] > 0) && (this.iMirror != null)) {
			if( this.iMirror.isLoaded == true ) {
				if (this.mirrorX >= 0) {
					float percent = ((p[3]) - 480f) / 480f;
					int realWidth = 480 - mirrorX * 16;
					int width = (int)((float)(realWidth) * percent);
					g.cropImage(this.iMirror, mirrorX * 16 + width, changeY, -width, 240, 0, 0, realWidth, 240);
				} else {
					float percent = ((p[3]) - 480f) / 480f;
					int realHeight = 240 - mirrorY * 16;
					int height = (int)((float)(realHeight) * percent);
					g.cropImage(this.iMirror, 480, changeY + mirrorY * 16, -480, height, 0, 240 - realHeight, 480, realHeight);
				}
			}
		}

		boolean bActive = false;
		if (((p[0] == 0) || ((this.mirrorX >= 0) && (p[0] == 2))) && (!bUserlevel) && (!bEditor)) {
			bActive = true;
		}
		if (this.mirrorY > 0) {
			this.drawInputUpBox(g, bActive);
			this.drawInputDownBox(g, bActive);
		} else {
			this.drawInputLeftBox(g, bActive);
			this.drawInputRightBox(g, bActive);
		}

		if ((this.p[9] > 0) && (this.mirrorX < 0) && (this.mirrorY < 0)) {
			bActive = false;
			this.drawInputGravityBox(g, bActive);
		}

		if ((this.backsteps.size() > 1) || ((playerX != playerStartX) || (playerY != playerStartY))) {
			bActive = false;
			if ((p[0] == 3) && (!this.bUserlevel) && (!this.bEditor)) {
				bActive = true;
			}
			this.drawInputBackBox(g, bActive);
		}

		this.drawInputLeftBoxForLevelchooser(g);
		this.drawInputRightBoxForLevelchooser(g);

		bActive = false;
		if ((p[0] == 1) && (!bUserlevel) && (!bEditor)) {
			bActive = true;
		}
		if ((this.mirrorX < 0) && (this.mirrorY < 0)) {
			this.drawInputWithBox(g, bActive);
		}
		if ((this.p[1] > 0) && (this.mirrorY < 0)) {
			bActive = false;
			if ((p[0] == 2) && (!bUserlevel) && (!bEditor)) {
				bActive = true;
			}
			if (this.mirrorX < 0) {
				this.drawInputMirrorHorizontalBox(g, bActive);
			} else {
				this.drawInputMirrorHorizontalBox(g, bActive);
				this.drawInputMirrorExitBox(g, bActive);
			}
		}
		if ((this.p[8] > 0) && (this.mirrorX < 0)) {
			bActive = false;
			if ((p[0] == 2) && (!bUserlevel) && (!bEditor)) {
				bActive = true;
			}
			if (this.mirrorY < 0) {
				this.drawInputMirrorVerticalBox(g, bActive);
			} else {
				this.drawInputMirrorVerticalBox(g, bActive);
				this.drawInputMirrorExitBox(g, bActive);
			}
		}

		g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
		for (int i = this.particles.size() - 1; i >= 0; i--) {
			this.particles.get(i).render(g, 0, 0);
		}

		if (p[2] > 0) {
			String[] array = ApoHybridConstants.GAME_WIN.split(":");
			if (p[2] > 1) {
				array = ApoHybridConstants.GAME_RESTART.split(":");
			}
			g.setColor(ApoHybridConstants.BRIGHT_DARK[0], ApoHybridConstants.BRIGHT_DARK[1], ApoHybridConstants.BRIGHT_DARK[2], 1f);
			g.fillRect(50, changeY + 115, 380, array.length * 15 + 10);
			g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
			g.drawRect(50, changeY + 115, 380, array.length * 15 + 10);
			for (int i = 0; i < array.length; i++) {
				this.getGame().drawString(g, array[i], (int)(240 - ApoHybridPanel.game_font.getLength(array[i])/2), changeY + i * 15 + 120, ApoHybridPanel.game_font);
			}
		} else {
			if ((!bUserlevel) && (!bEditor)) {
				if (mirrorX >= 0) {
					if (p[0] == 2) {
						String[] array = ApoHybridConstants.HELP_MIRROR.split(":");
						for (int i = 0; i < array.length; i++) {
							this.getGame().drawString(g, array[i], (int)(240 - ApoHybridPanel.game_font.getLength(array[i])/2), changeY + 5 + i * 18, ApoHybridPanel.game_font);
						}
					}
				} else {
					String curString = ApoHybridConstants.HELP_STANDARD;
					if ((p[0] < ApoHybridConstants.HELP.length) && (ApoHybridConstants.HELP[p[0]].length() > 0)) {
						curString = ApoHybridConstants.HELP[p[0]];
					} else if (p[0] >= ApoHybridConstants.HELP.length) {
						curString = "";
					}

					if (curString.length() > 0) {
						String[] array = curString.split(":");
						for (int i = 0; i < array.length; i++) {
							this.getGame().drawString(g, array[i], (int)(240 - ApoHybridPanel.game_font.getLength(array[i])/2), changeY + 5 + i * 18, ApoHybridPanel.game_font);
						}
					}
				}
			}
		}
	}

	public static void renderPlayer(final BitsGraphics g, final int addPX, int addPY, final int add, final int gravity, final int withBox) {
		g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
		int addGravity = 0;
		if (gravity < 0) {
			addGravity = 16;
		}
		g.fillRect(addPX + 5, addPY + 1 * gravity + addGravity, 6, 11 * gravity);
		g.fillRect(addPX + 3, addPY + 2 * gravity + addGravity, 10, 2 * gravity);
		g.fillRect(addPX + 11 - add * 8, addPY + 5 * gravity + addGravity, 2, 2 * gravity);

		g.fillRect(addPX + 5, addPY + 12 * gravity + addGravity, 2, 5 * gravity);
		g.fillRect(addPX + 9, addPY + 12 * gravity + addGravity, 2, 5 * gravity);
		if (withBox > 0) {
			addPY -= 16 * gravity;
			ApoHybridGame.drawMoveableBox(g, addPX, addPY);
			g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
			g.fillRect(addPX + 5, addPY + 16 * gravity + addGravity, 2, 2 * gravity);
			g.fillRect(addPX + 9, addPY + 16 * gravity + addGravity, 2, 2 * gravity);
			g.fillRect(addPX + 5, addPY + 17 * gravity + addGravity, 6, 1 * gravity);
		}
	}

	public static void drawMenu(final BitsGLGraphics g, final ApoHybridPanel panel, final float[] color, final float[] colorText, final int horizontal, final int vertical, final int gravity, final float frameGravity) {
		int addY = 10;
		g.setColor(color[0], color[1], color[2], 0.5f);
		g.fillRect(2, 6 + addY, 6, 8);
		g.fillRect(1, 7 + addY, 8, 6);

		g.fillRect(51, 1 + addY, 6, 8);
		g.fillRect(50, 2 + addY, 8, 6);
		g.setColor(color[0], color[1], color[2], 1f);
		g.fillRect(14, 6 + addY, 6, 8);
		g.fillRect(13, 7 + addY, 8, 6);

		g.fillRect(51, 12 + addY, 6, 8);
		g.fillRect(50, 13 + addY, 8, 6);
		for (int i = 0; i < 8; i+= 2) {
			g.fillRect(10, 6 + i + addY, 1, 1);
			g.fillRect(50 + i, 10 + addY, 1, 1);
		}
		String s = ":"+String.valueOf(horizontal);
		panel.drawString(g, s, (int)(23), 2 + addY, ApoHybridPanel.game_font, colorText);

		s = ":"+String.valueOf(vertical);
		panel.drawString(g, s, (int)(60), 2 + addY, ApoHybridPanel.game_font, colorText);

		g.fillRect(87, 13 + frameGravity/2, 6, 8);
		g.fillRect(86, 13 + frameGravity/2 + 1, 8, 6);
		s = ":"+String.valueOf(gravity);
		panel.drawString(g, s, (int)(100), 2 + addY, ApoHybridPanel.game_font, colorText);
	}

	public static void drawX(final BitsGraphics g, final int addPX, final int addPY) {
		ApoHybridGame.drawX(g, addPX, addPY, false, ApoHybridConstants.DARK_BRIGHT, true, true);
	}

	public static void drawX(final BitsGraphics g, final int addPX, final int addPY, final boolean bDouble) {
		ApoHybridGame.drawX(g, addPX, addPY, bDouble, ApoHybridConstants.DARK_BRIGHT, true, true);
	}

	public static void drawX(final BitsGraphics g, final int addPX, final int addPY, final boolean bDouble, final float[] backColor, final boolean bBrighter, final boolean bShadow) {
		int scale = 1;
		if (bDouble) {
			scale = 2;
		}
		for (int i = 0; i < 5; i++) {
			if (bShadow) {
				g.setColor(backColor[0], backColor[1], backColor[2], 1f);
				if (bBrighter) {
					ApoHybridGame.setBrighterColor(g);
				} else {
					ApoHybridGame.setDarkerColor(g);
				}
				g.fillRect(addPX + 4 * scale + i*2 * scale, addPY +  4 * scale + i*2 * scale, 2 * scale, 2 * scale);
				g.fillRect(addPX + 12 * scale - i*2 * scale, addPY + 4 * scale + i*2 * scale, 2 * scale, 2 * scale);
			}
			g.setColor(backColor[0], backColor[1], backColor[2], 1f);
			g.fillRect(addPX + 3 * scale + i*2 * scale, addPY + 3 * scale + i*2 * scale, 2 * scale, 2 * scale);
			g.fillRect(addPX + 11 * scale - i*2 * scale, addPY + 3 * scale + i*2 * scale, 2 * scale, 2 * scale);
		}
	}

	public static void drawAir(final BitsGraphics g, final int addPX, final int addPY) {
		ApoHybridGame.drawAir(g, addPX, addPY, false);
	}

	public static void drawAir(final BitsGraphics g, final int addPX, final int addPY, final boolean bDouble) {
		int scale = 1;
		if (bDouble) {
			scale = 2;
		}
		g.setColor(ApoHybridConstants.DARK_BRIGHT[0], ApoHybridConstants.DARK_BRIGHT[1], ApoHybridConstants.DARK_BRIGHT[2], 1f);
		g.fillRect(addPX + 6 * scale, addPY + 6 * scale, 4 * scale, 4 * scale);
	}

	public static void drawSpikes(final BitsGraphics g, final int addPX, final int addPY) {
		ApoHybridGame.drawSpikes(g, addPX, addPY, false);
	}

	public static void drawSpikes(final BitsGraphics g, final int addPX, final int addPY, final boolean bDouble) {
		int scale = 1;
		if (bDouble) {
			scale = 2;
		}
		g.fillRect(addPX, addPY + 14 * scale, 16 * scale, 3 * scale);
		g.fillRect(addPX + 1 * scale, addPY + 11 * scale, 6 * scale, 3 * scale);
		g.fillRect(addPX + 9 * scale, addPY + 11 * scale, 6 * scale, 3 * scale);
		g.fillRect(addPX + 2 * scale, addPY + 8 * scale, 4 * scale, 3 * scale);
		g.fillRect(addPX + 10 * scale, addPY + 8 * scale, 4 * scale, 3 * scale);
		g.fillRect(addPX + 3 * scale, addPY + 5 * scale, 2 * scale, 3 * scale);
		g.fillRect(addPX + 11 * scale, addPY + 5 * scale, 2 * scale, 3 * scale);
		g.fillRect(addPX + 4 * scale, addPY + 2 * scale, 1 * scale, 3 * scale);
		g.fillRect(addPX + 12 * scale, addPY + 2 * scale, 1 * scale, 3 * scale);
	}

	public static void drawBeamer(final BitsGraphics g, final int addPX, final int addPY, final int frame) {
		ApoHybridGame.drawBeamer(g, addPX, addPY, frame, false, ApoHybridConstants.DARK_BRIGHT);
	}

	public static void drawBeamer(final BitsGraphics g, final int addPX, final int addPY, final int frame, final boolean bDouble, float[] color) {
		int scale = 1;
		if (bDouble) {
			scale = 2;
		}
		g.setColor(color[0], color[1], color[2], 1f);
		if (frame < 3) {
			g.fillRect(addPX + 2 * scale + 2 * frame * scale, addPY + 2 * frame * scale, (12 - 4 * frame) * scale, 2 * scale);
			g.fillRect(addPX + 14 * scale - 2 * frame * scale, addPY + 2 * scale + 2 * frame * scale, 2 * scale, (12 - 4 * frame) * scale);
			g.fillRect(addPX + 0 * scale + 2 * frame * scale, addPY + 2 * scale + 2 * frame * scale, 2 * scale, (12 - 4 * frame) * scale);
			g.fillRect(addPX + 2 * scale + 2 * frame * scale, addPY + 14 * scale - 2 * frame * scale, (12 - 4 * frame) * scale, 2 * scale);
		} else {
			g.fillRect(addPX + 6 * scale, addPY + 6 * scale, 4 * scale, 4 * scale);
		}
	}

	public static void drawBox(final BitsGraphics g, final int addPX, final int addPY, final boolean bWithShadow) {
		ApoHybridGame.drawBox(g, addPX, addPY, bWithShadow, false);
	}

	public static void drawBox(final BitsGraphics g, final int addPX, final int addPY, final boolean bWithShadow, final boolean bDouble) {
		int scale = 1;
		if (bDouble) {
			scale = 2;
		}
		g.fillRect(addPX, addPY + 2 * scale, 14 * scale, 12 * scale);
		g.fillRect(addPX + 2 * scale, addPY, 12 * scale, 2 * scale);
		ApoHybridGame.setDarkerColor(g);
		g.fillRect(addPX + 2 * scale, addPY + 14 * scale, 12 * scale, 2 * scale);
		g.fillRect(addPX + 14 * scale, addPY + 2 * scale, 2 * scale, 12 * scale);
		if (bWithShadow) {
			ApoHybridGame.setBrighterColor(g);
			g.fillRect(addPX + 4 * scale, addPY + 16 * scale, 12 * scale, 2 * scale);
			g.fillRect(addPX + 16 * scale, addPY + 4 * scale, 2 * scale, 12 * scale);
			g.fillRect(addPX + 14 * scale, addPY + 14 * scale, 2 * scale, 2 * scale);
		}
	}

	public static void drawBlockPlusMirror(final BitsGraphics g, final int addPX, final int addPY) {
		ApoHybridGame.drawBlockPlusMirror(g, addPX, addPY, false);
	}

	public static void drawBlockPlusMirror(final BitsGraphics g, final int addPX, final int addPY, final boolean bDouble) {
		int scale = 1;
		if (bDouble) {
			scale = 2;
		}
		ApoHybridGame.drawBox(g, addPX, addPY, false, bDouble);
		g.setColor(ApoHybridConstants.BRIGHT_DARK[0], ApoHybridConstants.BRIGHT_DARK[1], ApoHybridConstants.BRIGHT_DARK[2], 1f);
		g.fillRect(addPX + 3 * scale, addPY + 6 * scale, 10 * scale, 4 * scale);
		g.fillRect(addPX + 6 * scale, addPY + 3 * scale, 4 * scale, 10 * scale);
	}

	public static void drawBlock(final BitsGraphics g, final int addPX, final int addPY) {
		ApoHybridGame.drawBlock(g, addPX, addPY, false);
	}

	public static void drawBlock(final BitsGraphics g, final int addPX, final int addPY, final boolean bDouble) {
		int scale = 1;
		if (bDouble) {
			scale = 2;
		}
		ApoHybridGame.drawBox(g, addPX, addPY, true, bDouble);
		g.setColor(ApoHybridConstants.BRIGHT_DARK[0], ApoHybridConstants.BRIGHT_DARK[1], ApoHybridConstants.BRIGHT_DARK[2], 1f);
		g.fillRect(addPX + 6 * scale, addPY + 6 * scale, 4 * scale, 4 * scale);
	}

	public static void drawOnStepBlock(final BitsGraphics g, final int addPX, final int addPY) {
		ApoHybridGame.drawOnStepBlock(g, addPX, addPY, false);
	}

	public static void drawOnStepBlock(final BitsGraphics g, final int addPX, final int addPY, final boolean bDouble) {
		int scale = 1;
		if (bDouble) {
			scale = 2;
		}
		ApoHybridGame.drawBox(g, addPX, addPY, true, bDouble);
		g.setColor(ApoHybridConstants.BRIGHT_DARK[0], ApoHybridConstants.BRIGHT_DARK[1], ApoHybridConstants.BRIGHT_DARK[2], 1f);
		g.setLineSize(2f * ApoHybridConstants.MAX);
		g.drawLine(addPX + 7 * scale, addPY + 1 * scale, addPX + 1 * scale, addPY + 7 * scale);
		g.drawLine(addPX + 13 * scale, addPY + 1 * scale, addPX + 1 * scale, addPY + 13 * scale);
		g.drawLine(addPX + 13 * scale, addPY + 7 * scale, addPX + 7 * scale, addPY + 13 * scale);
		g.setLineSize(1);
	}

	public static void drawMoveableBox(final BitsGraphics g, final int addPX, final int addPY) {
		ApoHybridGame.drawMoveableBox(g, addPX, addPY, false);
	}

	public static void drawMoveableBox(final BitsGraphics g, final int addPX, final int addPY, final boolean bDouble) {
		int scale = 1;
		if (bDouble) {
			scale = 2;
		}
		g.setColor(ApoHybridConstants.DARK_BRIGHT[0], ApoHybridConstants.DARK_BRIGHT[1], ApoHybridConstants.DARK_BRIGHT[2], 1f);
		ApoHybridGame.drawBox(g, addPX, addPY, false);
		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
		g.fillRect(addPX + 3 * scale, addPY + 3 * scale, 10 * scale, 10 * scale);
		g.setColor(ApoHybridConstants.DARK_BRIGHT[0], ApoHybridConstants.DARK_BRIGHT[1], ApoHybridConstants.DARK_BRIGHT[2], 1f);
		g.fillRect(addPX + 5 * scale, addPY + 5 * scale, 6 * scale, 6 * scale);
	}

	public static void setDarkerColor(final BitsGraphics g) {
		ApoHybridGame.setChangeColor(g, -25, -25, -25);
	}

	public static void setBrighterColor(final BitsGraphics g) {
		if (ApoHybridConstants.BRIGHT[0] == ApoHybridConstants.BRIGHT_GREEN[0]) {
			ApoHybridGame.setChangeColor(g, 70, 70, -5);
		} else {
			ApoHybridGame.setChangeColor(g, +70, +70, +70);
		}
	}

	public static void setChangeColor(final BitsGraphics g, final int valueRed, final int valueGreen, final int valuesBlue) {
		float[] values = g.getColor();
		float red = values[0] + valueRed/256f;
		float green = values[1] + valueGreen/256f;
		float blue = values[2] + valuesBlue/256f;
		float alpha = 1f;
		if (values.length > 3) {
			alpha = values[3];
		}
		if (red < 0) {
			red = 0;
		}
		if (red > 1) {
			red = 1f;
		}
		if (green < 0) {
			green = 0;
		}
		if (green > 1) {
			green = 1f;
		}
		if (blue < 0) {
			blue = 0;
		}
		if (blue > 1) {
			blue = 1f;
		}
		if (alpha < 0) {
			alpha = 0;
		}
		if (alpha > 1) {
			alpha = 1f;
		}
		g.setColor(red, green, blue, alpha);
	}

	public static void drawFinish(final BitsGraphics g, final int addPX, final int addPY, final int frame) {
		g.fillRect(addPX + 7 * 2, addPY + 0 * 2, 1 * 2, 9 * 2);
		ApoHybridGame.setBrighterColor(g);
		g.fillRect(addPX + 8 * 2, addPY + 1 * 2 - 1, 1 * 1, 9 * 2);

		g.setColor(ApoHybridConstants.DARK_BRIGHT[0], ApoHybridConstants.DARK_BRIGHT[1], ApoHybridConstants.DARK_BRIGHT[2], 1f);
		ApoHybridGame.setBrighterColor(g);
		if (frame == 0) {
			g.fillRect(addPX + 6 * 2, addPY + 1 * 2, 1 * 2, 3 * 2);
			g.fillRect(addPX + 5 * 2, addPY + 1 * 2, 1 * 2, 4 * 2);
			g.fillRect(addPX + 4 * 2, addPY + 2 * 2, 1 * 2, 3 * 2);
			g.fillRect(addPX + 3 * 2, addPY + 3 * 2, 1 * 2, 3 * 2);
			g.fillRect(addPX + 2 * 2, addPY + 4 * 2, 1 * 2, 2 * 2);
			g.fillRect(addPX + 1 * 2, addPY + 5 * 2, 1 * 2, 1 * 2);
		} else if (frame == 2) {
			g.fillRect(addPX + 6 * 2, addPY + 1 * 2, 1 * 2, 4 * 2);
			g.fillRect(addPX + 5 * 2, addPY + 2 * 2, 1 * 2, 4 * 2);
			g.fillRect(addPX + 4 * 2, addPY + 4 * 2, 1 * 2, 3 * 2);
		} else {
			g.fillRect(addPX + 6 * 2, addPY + 1 * 2, 1 * 2, 3 * 2);
			g.fillRect(addPX + 5 * 2, addPY + 1 * 2, 1 * 2, 4 * 2);
			g.fillRect(addPX + 4 * 2, addPY + 2 * 2, 1 * 2, 4 * 2);
			g.fillRect(addPX + 3 * 2, addPY + 4 * 2, 1 * 2, 3 * 2);
		}
	}

	private void drawInputRightBox(final BitsGraphics g, final boolean bActive) {
		int x = 55;
		int y = ApoHybridGame.changeY + 245;
		this.drawInputBox(g, x, y, bActive);
		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
		for (int i = 0; i < 10; i++) {
			g.fillRect(x + 10 + i * 2, y + 10 + i * 1, 2, 20 - i * 2);
		}
	}

	private void drawInputLeftBox(final BitsGraphics g, final boolean bActive) {
		int x = 5;
		int y = ApoHybridGame.changeY + 245;
		this.drawInputBox(g, x, y, bActive);
		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
		for (int i = 0; i < 10; i++) {
			g.fillRect(x + 30 - i * 2, y + 10 + i * 1, 2, 20 - i * 2);
		}
	}

	private void drawInputUpBox(final BitsGraphics g, final boolean bActive) {
		int x = 5;
		int y = ApoHybridGame.changeY + 245;
		this.drawInputBox(g, x, y, bActive);
		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
		for (int i = 0; i < 10; i++) {
			g.fillRect(x + 10 + i * 1, y +  + 30 - i * 2, 20 - i * 2, 2);
		}
	}

	private void drawInputDownBox(final BitsGraphics g, final boolean bActive) {
		int x = 55;
		int y = ApoHybridGame.changeY + 245;
		this.drawInputBox(g, x, y, bActive);
		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
		for (int i = 0; i < 10; i++) {
			g.fillRect(x + 10 + i * 1, y + 10 + i * 2, 20 - i * 2, 2);
		}
	}

	private void drawInputGravityBox(final BitsGraphics g, final boolean bActive) {
		int x = 105;
		int y = ApoHybridGame.changeY + 245;
		this.drawInputBox(g, x, y, bActive);
		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
		x += 16;
		y += 8 + (int)(this.frameGravity);
		g.fillRect(x + 1 - 9, y, 6, 8);
		g.fillRect(x - 9, y + 1, 8, 6);

		g.fillRect(x + 1 + 9, y, 6, 8);
		g.fillRect(x + 9, y + 1, 8, 6);

		g.fillRect(x + 1, y, 6, 8);
		g.fillRect(x, y + 1, 8, 6);
		g.setColor(ApoHybridConstants.DARK_BRIGHT[0], ApoHybridConstants.DARK_BRIGHT[1], ApoHybridConstants.DARK_BRIGHT[2], 1f);
		g.fillRect(x + 2, y + 3, 4, 2);
		g.fillRect(x + 3, y + 2, 2, 4);
	}

	private void drawInputWithBox(final BitsGraphics g, final boolean bActive) {
		int x = ApoHybridConstants.GAME_WIDTH - 45;
		int y = ApoHybridGame.changeY + 245;
		this.drawInputBox(g, x, y, bActive);
		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);

		x += 12;
		g.fillRect(x + 5, y + 20 - 1, 2, 2);
		g.fillRect(x + 9, y + 20 - 1, 2, 2);
		g.fillRect(x + 5, y + 20 + 1, 6, 11);
		g.fillRect(x + 3, y + 20 + 2, 10, 2);
		g.fillRect(x + 11 - add * 8, y + 20 + 5, 2, 2);
		g.fillRect(x + 5, y + 20 + 12, 2, 5);
		g.fillRect(x + 9, y + 20 + 12, 2, 5);

		g.fillRect(x, y + 4 + 2, 16, 12);
		g.fillRect(x + 2, y + 4, 12, 16);
		g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
		g.fillRect(x + 3, y + 4 + 3, 10, 10);
		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
		g.fillRect(x + 5, y + 4 + 5, 6, 6);
	}

	private void drawInputMirrorHorizontalBox(final BitsGraphics g, final boolean bActive) {
		int x = ApoHybridConstants.GAME_WIDTH - 95;
		int y = ApoHybridGame.changeY + 245;
		this.drawInputBox(g, x, y, bActive);
		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);

		for (int i = 0; i < 9; i++) {
			g.fillRect(x + 19, y + 4 + i * 4, 2, 2);
		}
		x += 22;
		y += 12;
		g.fillRect(x, y + 2, 16, 12);
		g.fillRect(x + 2, y, 12, 16);
		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 0.5f);
		x = x - 20;
		g.fillRect(x, y + 2, 16, 12);
		g.fillRect(x + 2, y, 12, 2);
		g.fillRect(x + 2, y + 14, 12, 2);

		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
	}

	private void drawInputMirrorVerticalBox(final BitsGraphics g, final boolean bActive) {
		int x = ApoHybridConstants.GAME_WIDTH - 145;
		int y = ApoHybridGame.changeY + 245;
		this.drawInputBox(g, x, y, bActive);
		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);

		for (int i = 0; i < 9; i++) {
			g.fillRect(x + 4 + i * 4, y + 19, 2, 2);
		}
		x += 12;
		y += 2;
		g.fillRect(x, y + 2, 16, 12);
		g.fillRect(x + 2, y, 12, 16);
		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 0.5f);
		y = y + 20;
		g.fillRect(x, y + 2, 16, 12);
		g.fillRect(x + 2, y, 12, 2);
		g.fillRect(x + 2, y + 14, 12, 2);

		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
	}


	private void drawInputMirrorExitBox(final BitsGraphics g, final boolean bActive) {
		int x = ApoHybridConstants.GAME_WIDTH - 195;
		int y = ApoHybridGame.changeY + 245;
		this.drawInputBox(g, x, y, bActive);
		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
		for (int i = 0; i < 11; i++) {
			g.fillRect(x + 10 + i * 2, y + 9 + i * 2, 2, 2);
			g.fillRect(x + 30 - i * 2, y + 9 + i * 2, 2, 2);
		}
	}

	private void drawInputBackBox(final BitsGLGraphics g, final boolean bActive) {
		int x = ApoHybridConstants.GAME_WIDTH/2 - 20;
		int y = ApoHybridGame.changeY + 245;
		this.drawInputBox(g, x, y, bActive);
		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
		y -= 3;
		g.fillRect(x + 10, y + 30, 18, 2);
		g.fillRect(x + 10, y + 16, 18, 2);
		g.fillRect(x + 28, y + 28, 2, 2);
		g.fillRect(x + 30, y + 20, 2, 8);
		g.fillRect(x + 28, y + 18, 2, 2);
		for (int i = 1; i < 4; i++) {
			g.fillRect(x + 10 + i * 2, y + 16 - i * 2, 2, 2 + i * 4);
		}
	}

	private void drawInputBox(final BitsGraphics g, int x, int y, final boolean bActive) {
		g.setColor(ApoHybridConstants.DARK[0], ApoHybridConstants.DARK[1], ApoHybridConstants.DARK[2], 1f);
		g.fillRect(x + 2, y + 2, 36, 36);
		ApoHybridGame.setDarkerColor(g);
		if ((p[5] > x) && (p[5] < x + 40) && (p[6] > y) && (p[6] < y + 40)) {
			g.setColor(ApoHybridConstants.BRIGHT_DARK[0], ApoHybridConstants.BRIGHT_DARK[1], ApoHybridConstants.BRIGHT_DARK[2], 1f);
		}
		g.fillRect(x + 2, y, 36, 2);
		g.fillRect(x + 2, y + 38, 36, 2);
		g.fillRect(x, y + 2, 2, 36);
		g.fillRect(x + 38, y + 2, 2, 36);
		ApoHybridGame.setBrighterColor(g);
		g.fillRect(x + 4, y + 40, 36, 2);
		g.fillRect(x + 40, y + 4, 2, 36);
		g.fillRect(x + 38, y + 38, 2, 2);
		if (bActive) {
			g.setColor(1f, 0f, 0f, 1f);
//			g.setColor(ApoHybridConstants.DARK_BRIGHT[0], ApoHybridConstants.DARK_BRIGHT[1], ApoHybridConstants.DARK_BRIGHT[2], 1f);
			g.setLineSize(3.5f * ApoHybridConstants.MAX);
			g.drawRect(x, y, 40, 40);
			g.setLineSize(1);
		}
	}

	private void drawInputLeftBoxForLevelchooser(final BitsGraphics g) {
		int x = ApoHybridConstants.GAME_WIDTH/2 - 95;
		int y = 1;
		this.drawInputBoxForLevelchooser(g, x, y, 38, 38);
		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
		for (int i = 0; i < 10; i++) {
			g.fillRect(x + 26 - i * 2, y + 10 + i * 1, 2, 20 - i * 2);
		}
	}

	private void drawInputRightBoxForLevelchooser(final BitsGraphics g) {
		int x = ApoHybridConstants.GAME_WIDTH/2 + 55;
		int y = 1;
		this.drawInputBoxForLevelchooser(g, x, y, 38, 38);
		g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
		for (int i = 0; i < 10; i++) {
			g.fillRect(x + 10 + i * 2, y + 10 + i * 1, 2, 20 - i * 2);
		}
	}

	private void drawInputBoxForLevelchooser(final BitsGraphics g, int x, int y, final int width, final int height) {
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
	}
}

//#endif

