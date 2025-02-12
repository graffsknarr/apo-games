//#if TreasureGameLogic
//@/*
//@ * Copyright (c) 2005-2013 Dirk Aporius <dirk.aporius@gmail.com>
//@ * All rights reserved.
//@ * 
//@ * Redistribution and use in source and binary forms, with or without
//@ * modification, are permitted provided that the following conditions
//@ * are met:
//@ * 1. Redistributions of source code must retain the above copyright
//@ *    notice, this list of conditions and the following disclaimer.
//@ * 2. Redistributions in binary form must reproduce the above copyright
//@ *    notice, this list of conditions and the following disclaimer in the
//@ *    documentation and/or other materials provided with the distribution.
//@ * 3. The name of the author may not be used to endorse or promote products
//@ *    derived from this software without specific prior written permission.
//@ * 
//@ * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
//@ * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
//@ * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
//@ * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
//@ * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
//@ * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
//@ * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
//@ * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
//@ * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
//@ * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
//@ */
//@
//@package net.apogames.apohybrid.game;
//@
//@import java.util.ArrayList;
//@
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//@
//@import net.apogames.apohybrid.ApoHybridConstants;
//@import net.apogames.apohybrid.ApoHybridModel;
//@import net.apogames.apohybrid.ApoHybridSoundPlayer;
//@import net.apogames.apohybrid.entity.ApoHybridMapPlayer;
//@import net.apogames.apohybrid.entity.ApoParticle;
//@import net.apogames.apohybrid.entity.ApoHybridTutorial;
//@import net.apogames.apohybrid.entity.ApoHybridTutorialHelp;
//@
//@public class ApoHybridMap extends ApoHybridModel {
//@
//@	public static final String BACK = "back";
//@	
//@	private final int PARTICLE_SIZE = 50;
//@	
//@	private int[] NEEDED_SKULLS = new int[] {
//@		40,
//@		140,
//@		280
//@	};
//@	
//@	private ApoHybridMapPlayer player;
//@	
//@	private ApoHybridTutorial tutorial;
//@	
//@	private ArrayList<ApoParticle> particles;
//@	
//@	private int oldLevel;
//@	
//@	public ApoHybridMap(final ApoHybridPanel game) {
//@		super(game);
//@		
//@		this.oldLevel = 0;
//@		if (this.player == null) {
//@			this.player = new ApoHybridMapPlayer();
//@		}
//@	}
//@
//@	@Override
//@	public void init() {
//@		if (ApoHybridConstants.FREE_VERSION) {
//@			NEEDED_SKULLS = new int[] {
//@					100,
//@					140,
//@					280
//@				};
//@		}
//@		if (this.tutorial == null) {
//@			ApoHybridTutorialHelp[] points = new ApoHybridTutorialHelp[4];
//@			points[0] = new ApoHybridTutorialHelp(144, 224, 64, 224, 500);
//@			points[1] = new ApoHybridTutorialHelp(40, 390, 64, 224, 0);
//@			points[2] = new ApoHybridTutorialHelp(40, 390, 96, 224, 2000);
//@			points[3] = new ApoHybridTutorialHelp(40, 390, 64, 224, 500);
//@			this.tutorial = new ApoHybridTutorial(points);
//@		}
//@		if (this.particles == null) {
//@			this.particles = new ArrayList<ApoParticle>();
//@		}
//@		for (int i = 0; i < this.NEEDED_SKULLS.length; i++) {
//@			if ((this.oldLevel < this.NEEDED_SKULLS[i]) && (this.getGame().getCurSkulls() > this.NEEDED_SKULLS[i])) {
//@				this.particles.clear();
//@				int x = 178;
//@				int y = 446;
//@				if (i == 1) {
//@					x = 222;
//@					y = 264;
//@				} else if (i == 2) {
//@					x = 216;
//@					y = 148;
//@				}
//@				for (int p = 0; p < this.PARTICLE_SIZE; p++) {
//@					this.particles.add(new ApoParticle(x, y, 4, 4));
//@				}
//@				this.getGame().playSound(ApoHybridSoundPlayer.SOUND_WIN_3);
//@				break;
//@			}
//@		}
//@		
//@		this.oldLevel = this.getGame().getCurSkulls();
//@	}
//@	
//@	public void setPlayerPosition(final int position) {
//@		this.player.setPlayerPosition(position);
//@	}
//@	
//@	public void setOldLevel(final int oldLevel) {
//@		this.oldLevel = oldLevel;
//@	}
//@
//@	@Override
//@	public void touchedButton(String function) {
//@		this.getGame().playSound(ApoHybridSoundPlayer.SOUND_CLICK);
//@		if (function.equals(ApoHybridMap.BACK)) {
//@			this.getGame().setMenu();
//@		}
//@	}
//@	
//@	public void onBackButtonPressed() {
//@		this.getGame().setMenu();
//@	}
//@
//@	@Override
//@	public void touchedPressed(int x, int y, int finger) {
//@		
//@	}
//@
//@	@Override
//@	public void touchedReleased(int x, int y, int finger) {
//@		// easy
//@		if ((x > 16) && (x < 16 + 22 * 4) && (y > 90 * 4) && (y < 115 * 4)) {
//@			if (this.player.getCurPosition() == 0) {
//@				if (!this.player.isRunning()) {
//@					this.getGame().playSound(ApoHybridSoundPlayer.SOUND_CLICK);
//@					if (ApoHybridConstants.FIRST_MAP) {
//@						ApoHybridConstants.FIRST_MAP = false;
//@						this.tutorial.setVisible(false);
//@					}
//@					this.getGame().setLevelChooser(ApoHybridLevelChooser.EASY, 0, true, false);
//@				}
//@			} else {
//@				this.getGame().playSound(ApoHybridSoundPlayer.SOUND_CLICK);
//@				this.player.setNextPosition(0);
//@			}
//@		} else if ((x > 43 * 4) && (x < 75 * 4) && (y > 73 * 4) && (y < 103 * 4)) {
//@			if ((this.getGame().getCurSkulls() >= this.NEEDED_SKULLS[0]) && (!ApoHybridConstants.FREE_VERSION)) {
//@				if (this.player.getCurPosition() == 2) {
//@					if (!this.player.isRunning()) {
//@						this.getGame().playSound(ApoHybridSoundPlayer.SOUND_CLICK);
//@						this.getGame().setLevelChooser(ApoHybridLevelChooser.MEDIUM, 0, true, false);
//@					}
//@				} else {
//@					this.getGame().playSound(ApoHybridSoundPlayer.SOUND_CLICK);
//@//					Log.d("x and y", "x: "+x+" y: "+y+" "+this.player.getCurPosition());
//@					this.player.setNextPosition(2);
//@				}
//@			}
//@		} else if ((x > 14 * 4) && (x < 39 * 4) && (y > 43 * 4) && (y < 66 * 4)) {
//@			if ((this.getGame().getCurSkulls() >= this.NEEDED_SKULLS[1]) && (!ApoHybridConstants.FREE_VERSION)) {
//@				if (this.player.getCurPosition() == 6) {
//@					if (!this.player.isRunning()) {
//@						this.getGame().playSound(ApoHybridSoundPlayer.SOUND_CLICK);
//@						this.getGame().setLevelChooser(ApoHybridLevelChooser.HARD, 0, true, false);
//@					}
//@				} else {
//@					this.getGame().playSound(ApoHybridSoundPlayer.SOUND_CLICK);
//@					this.player.setNextPosition(6);
//@				}
//@			}
//@		} else if ((x > 47 * 4) && (x < 54 * 4) && (y > 16 * 4) && (y < 30 * 4)) {
//@			if ((this.getGame().getCurSkulls() >= this.NEEDED_SKULLS[2]) && (!ApoHybridConstants.FREE_VERSION)) {
//@				if (this.player.getCurPosition() == 12) {
//@					if (!this.player.isRunning()) {
//@						this.getGame().playSound(ApoHybridSoundPlayer.SOUND_CLICK);
//@						this.getGame().setLevelChooser(ApoHybridLevelChooser.VERYHARD, 0, true, false);
//@					}
//@				} else {
//@					this.getGame().playSound(ApoHybridSoundPlayer.SOUND_CLICK);
//@					this.player.setNextPosition(12);
//@				}
//@			}
//@		}
//@	}
//@
//@	@Override
//@	public void touchedDragged(int x, int y, int oldX, int oldY, int finger) {
//@		
//@	}
//@	
//@	@Override
//@	public void think(final int delta) {
//@		this.player.think(delta);
//@		if (this.tutorial.isVisible()) {
//@			this.tutorial.think(delta);
//@			if (!this.tutorial.isVisible()) {
//@				ApoHybridConstants.FIRST_MAP = false;
//@			}
//@		}
//@		for (int i = this.particles.size() - 1; i >= 0; i--) {
//@			if (this.particles.get(i).isVisible()) {
//@				this.particles.get(i).think(delta);
//@				if (!this.particles.get(i).isVisible()) {
//@					this.particles.remove(i);
//@				}
//@			}
//@		}
//@	}
//@
//@	@Override
//@	public void render(BitsGLGraphics g) {
//@		g.cropImage(ApoHybridConstants.iSheet, 0, 0, ApoHybridConstants.GAME_WIDTH, ApoHybridConstants.GAME_HEIGHT, 1024 - 2 * ApoHybridConstants.GAME_WIDTH, 0, ApoHybridConstants.GAME_WIDTH, ApoHybridConstants.GAME_HEIGHT);
//@
//@		g.cropImage(ApoHybridConstants.iSheet, (int)(this.player.getCurX()), (int)(this.player.getCurY()), 32, 32, 0 * 32, 0 * 32, 32, 32);
//@		
//@		g.setColor(ApoHybridConstants.COLOR_DARK);
//@		g.setFont(ApoHybridConstants.fontMedium);
//@		String s = String.valueOf(this.getGame().getCurSkulls());
//@		float w = ApoHybridConstants.fontMedium.getLength(s) + 32;
//@		g.drawText(s, ApoHybridConstants.GAME_WIDTH - 16 - w + 32, 45 - ApoHybridConstants.fontMedium.mCharCellHeight);
//@		
//@		g.setColor(1f, 1f, 1f, 1f);
//@		g.cropImage(ApoHybridConstants.iSheet, (int)(ApoHybridConstants.GAME_WIDTH - 16 - w), (int)(20), 32, 32, 56 * 4, 8 * 4, 32, 32);
//@		
//@		g.setFont(ApoHybridConstants.fontSmall);
//@		if ((this.player.getCurPosition() == 0) && (!this.player.isRunning())) {
//@			g.setColor(ApoHybridConstants.COLOR_LIGHT);
//@			g.fillRect(4 * 4, 81 * 4, 22 * 4, 9 * 4);
//@			g.setColor(ApoHybridConstants.COLOR_DARK);
//@			g.drawRect(4 * 4, 81 * 4, 22 * 4, 9 * 4);
//@			
//@			s = ApoHybridConstants.DIFFICULTY[0];
//@			w = ApoHybridConstants.fontSmall.getLength(s);
//@			g.drawText(s, 15 * 4 - w/2, 88 * 4 - ApoHybridConstants.fontSmall.mCharCellHeight);
//@		}
//@		
//@		g.setFont(ApoHybridConstants.fontSmall);
//@		if ((this.player.getCurPosition() == 6) && (!this.player.isRunning())) {
//@			g.setColor(ApoHybridConstants.COLOR_LIGHT);
//@			g.fillRect(14 * 4, 29 * 4, 29 * 4, 9 * 4);
//@			g.setColor(ApoHybridConstants.COLOR_DARK);
//@			g.drawRect(14 * 4, 29 * 4, 29 * 4, 9 * 4);
//@			
//@			s = ApoHybridConstants.DIFFICULTY[2];
//@			w = ApoHybridConstants.fontSmall.getLength(s);
//@			
//@			if (this.getGame().getCurSkulls() < this.NEEDED_SKULLS[1]) {
//@				if (ApoHybridConstants.FREE_VERSION) {
//@					g.drawText(s, 30 * 4 - w/2, 36 * 4 - ApoHybridConstants.fontSmall.mCharCellHeight);
//@				} else {
//@					g.drawText(s, 30 * 4 - w/2, 34 * 4 - 2 - ApoHybridConstants.fontSmall.mCharCellHeight);
//@					g.setFont(ApoHybridConstants.fontVerySmall);
//@					s = "need "+this.NEEDED_SKULLS[1];
//@					w = ApoHybridConstants.fontVerySmall.getLength(s) + 16;
//@					g.drawText(s, 30 * 4 - w/2, 38 * 4 - 2 - ApoHybridConstants.fontVerySmall.mCharCellHeight);
//@					g.setColor(1f, 1f, 1f, 1f);
//@					g.cropImage(ApoHybridConstants.iSheet, 30 * 4 + w/2 - 12, 35 * 4 - 2, 12, 12, 56 * 4, 8 * 4, 32, 32);
//@				}
//@			} else {
//@				g.drawText(s, 30 * 4 - w/2, 36 * 4 - ApoHybridConstants.fontSmall.mCharCellHeight);
//@			}
//@		} else if ((this.getGame().getCurSkulls() < this.NEEDED_SKULLS[1]) || (ApoHybridConstants.FREE_VERSION)) {
//@			g.setColor(ApoHybridConstants.COLOR_DARK);
//@			s = "need "+this.NEEDED_SKULLS[1];
//@			g.setFont(ApoHybridConstants.fontVerySmall);
//@			w = ApoHybridConstants.fontVerySmall.getLength(s);
//@			g.drawText(s, 29 * 4 - w/2 - 6, 148 - ApoHybridConstants.fontVerySmall.mCharCellHeight);
//@			g.setColor(1f, 1f, 1f, 1f);
//@			g.cropImage(ApoHybridConstants.iSheet, 29 * 4 + w/2 - 6, 148 - ApoHybridConstants.fontVerySmall.mCharCellHeight, 12, 12, 56 * 4, 8 * 4, 32, 32);
//@//			g.cropImage(ApoHybridConstants.iSheet, 29 * 4 - 16, 31 * 4 - ApoHybridConstants.fontVerySmall.mCharCellHeight - 2, 32, 32, 64 * 4, 0, 32, 32);
//@			
//@			g.cropImage(ApoHybridConstants.iWays, 140, 248, 84, 60, 113, 1, 84, 60);
//@		}
//@		
//@		g.setFont(ApoHybridConstants.fontSmall);
//@		if ((this.player.getCurPosition() == 12) && (!this.player.isRunning())) {
//@			g.setColor(ApoHybridConstants.COLOR_LIGHT);
//@			g.fillRect(38 * 4, 5 * 4, 24 * 4, 9 * 4);
//@			g.setColor(ApoHybridConstants.COLOR_DARK);
//@			g.drawRect(38 * 4, 5 * 4, 24 * 4, 9 * 4);
//@			
//@			s = ApoHybridConstants.DIFFICULTY[3];
//@			w = ApoHybridConstants.fontSmall.getLength(s);
//@			
//@			if (this.getGame().getCurSkulls() < this.NEEDED_SKULLS[2]) {
//@				if (ApoHybridConstants.FREE_VERSION) {
//@					g.drawText(s, 50 * 4 - w/2, 12 * 4 - ApoHybridConstants.fontSmall.mCharCellHeight);
//@				} else {
//@					g.drawText(s, 50 * 4 - w/2, 10 * 4 - 2 - ApoHybridConstants.fontSmall.mCharCellHeight);
//@					g.setFont(ApoHybridConstants.fontVerySmall);
//@					s = "need "+this.NEEDED_SKULLS[2];
//@					w = ApoHybridConstants.fontVerySmall.getLength(s) + 16;
//@					g.drawText(s, 50 * 4 - w/2, 14 * 4 - 2 - ApoHybridConstants.fontVerySmall.mCharCellHeight);
//@					g.setColor(1f, 1f, 1f, 1f);
//@					g.cropImage(ApoHybridConstants.iSheet, 50 * 4 + w/2 - 12, 11 * 4 - 2, 12, 12, 56 * 4, 8 * 4, 32, 32);
//@				}
//@			} else {
//@				g.drawText(s, 50 * 4 - w/2, 12 * 4 - ApoHybridConstants.fontSmall.mCharCellHeight);
//@			}
//@		} else if ((this.getGame().getCurSkulls() < this.NEEDED_SKULLS[2]) || (ApoHybridConstants.FREE_VERSION)) {
//@			g.setColor(ApoHybridConstants.COLOR_DARK);
//@			s = "need "+this.NEEDED_SKULLS[2];
//@			g.setFont(ApoHybridConstants.fontVerySmall);
//@			w = ApoHybridConstants.fontVerySmall.getLength(s);
//@			g.drawText(s, 51 * 4 - w/2 - 6, 60 - ApoHybridConstants.fontVerySmall.mCharCellHeight);
//@			g.setColor(1f, 1f, 1f, 1f);
//@			g.cropImage(ApoHybridConstants.iSheet, 51 * 4 + w/2 - 6, 60 - ApoHybridConstants.fontVerySmall.mCharCellHeight, 12, 12, 56 * 4, 8 * 4, 32, 32);
//@//			g.cropImage(ApoHybridConstants.iSheet, 51 * 4 - 16, 9 * 4 - ApoHybridConstants.fontVerySmall.mCharCellHeight - 2, 32, 32, 64 * 4, 0, 32, 32);
//@			
//@			g.cropImage(ApoHybridConstants.iWays, 148, 128, 80, 64, 208, 0, 80, 64);
//@		}
//@		
//@		g.setFont(ApoHybridConstants.fontSmall);
//@		if ((this.player.getCurPosition() == 2) && (!this.player.isRunning())) {
//@			g.setColor(ApoHybridConstants.COLOR_LIGHT);
//@			g.fillRect(43 * 4, 64 * 4, 32 * 4, 9 * 4);
//@			g.setColor(ApoHybridConstants.COLOR_DARK);
//@			g.drawRect(43 * 4, 64 * 4, 32 * 4, 9 * 4);
//@			
//@			s = ApoHybridConstants.DIFFICULTY[1];
//@			w = ApoHybridConstants.fontSmall.getLength(s);
//@			if (this.getGame().getCurSkulls() < this.NEEDED_SKULLS[0]) {
//@				if (ApoHybridConstants.FREE_VERSION) {
//@					g.drawText(s, 59 * 4 - w/2, 71 * 4 - 2 - ApoHybridConstants.fontSmall.mCharCellHeight);
//@				} else {
//@					g.drawText(s, 59 * 4 - w/2, 69 * 4 - 2 - ApoHybridConstants.fontSmall.mCharCellHeight);
//@					g.setFont(ApoHybridConstants.fontVerySmall);
//@					s = "need "+this.NEEDED_SKULLS[0];
//@					w = ApoHybridConstants.fontVerySmall.getLength(s) + 16;
//@					g.drawText(s, 59 * 4 - w/2, 73 * 4 - 2 - ApoHybridConstants.fontVerySmall.mCharCellHeight);
//@					g.setColor(1f, 1f, 1f, 1f);
//@					g.cropImage(ApoHybridConstants.iSheet, 59 * 4 + w/2 - 12, 70 * 4 - 2, 12, 12, 56 * 4, 8 * 4, 32, 32);
//@				}
//@			} else {
//@				g.drawText(s, 59 * 4 - w/2, 71 * 4 - ApoHybridConstants.fontSmall.mCharCellHeight);
//@			}
//@		} else if ((this.getGame().getCurSkulls() < this.NEEDED_SKULLS[0]) || (ApoHybridConstants.FREE_VERSION)) {
//@			g.setColor(ApoHybridConstants.COLOR_DARK);
//@			s = "need "+this.NEEDED_SKULLS[0];
//@			g.setFont(ApoHybridConstants.fontVerySmall);
//@			w = ApoHybridConstants.fontVerySmall.getLength(s);
//@			g.drawText(s, 59 * 4 - w/2 - 6, 292 - ApoHybridConstants.fontVerySmall.mCharCellHeight);
//@			g.setColor(1f, 1f, 1f, 1f);
//@			g.cropImage(ApoHybridConstants.iSheet, 59 * 4 + w/2 - 6, 292 - ApoHybridConstants.fontVerySmall.mCharCellHeight, 12, 12, 56 * 4, 8 * 4, 32, 32);
//@
//@			g.cropImage(ApoHybridConstants.iWays, 108, 400, 100, 60, 0, 2, 100, 60);
//@		}
//@		
//@		for (int i = this.particles.size() - 1; i >= 0; i--) {
//@			if (this.particles.get(i).isVisible()) {
//@				this.particles.get(i).render(g);
//@			}
//@		}
//@		
//@		if (ApoHybridConstants.FIRST_MAP) {
//@			this.tutorial.render(g);
//@		}
//@	}
//@
//@}
//#endif
