//#if MonoGameLogic
//@package net.apogames.apohybrid.game;
//@
//@import net.apogames.apohybrid.ApoHybridConstants;
//@import net.apogames.apohybrid.ApoHybridModel;
//@import net.apogames.apohybrid.ApoHybridSoundPlayer;
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLFactory;
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLImage;
//@
//@public class ApoHybridCredits  extends ApoHybridModel {
//@
//@    public static final String BACK = "back";
//@    public static final String TITLE = "Credits";
//@    public static final String SUB = "ApoHybrid is made by Dirk 'Apo' Aporius";
//@    public static final String SUB_2 = "made with the bits-engine by Marc Wiedenhoeft";
//@
//@    public BitsGLImage credits;
//@
//@    public ApoHybridCredits(ApoHybridPanel game) {
//@        super(game);
//@    }
//@
//@    @Override
//@    public void init() {
//@        this.getStringWidth().put(ApoHybridCredits.TITLE, (int)(ApoHybridPanel.title_font.getLength(ApoHybridCredits.TITLE)));
//@        this.getStringWidth().put(ApoHybridCredits.SUB, (int)(ApoHybridPanel.game_font.getLength(ApoHybridCredits.SUB)));
//@        this.getStringWidth().put(ApoHybridCredits.SUB_2, (int)(ApoHybridPanel.game_font.getLength(ApoHybridCredits.SUB_2)));
//@
//@        if (this.credits == null) {
//@            this.credits = BitsGLFactory.getInstance().getImage( "?net/gliblybits/bitsengine/BitsEngineLogo.png", BitsGLImage.FILTER_NEAREST, true );
//@//			BitsGLFactory.getInstance().markForLoading(this.credits);
//@            BitsGLFactory.getInstance().loadAllMarked();
//@        }
//@    }
//@
//@    public void onResume() {
//@    }
//@
//@    @Override
//@    public void touchedPressed(int x, int y, int finger) {
//@
//@    }
//@
//@    @Override
//@    public void touchedReleased(int x, int y, int finger) {
//@
//@    }
//@
//@    @Override
//@    public void touchedDragged(int x, int y, int oldX, int oldY, int finger) {
//@
//@    }
//@
//@    @Override
//@    public void touchedButton(String function) {
//@        if (function.equals(ApoHybridCredits.BACK)) {
//@            this.onBackButtonPressed();
//@        }
//@        this.getGame().playSound(ApoHybridSoundPlayer.SOUND_BUTTON_2);
//@    }
//@
//@    public void onBackButtonPressed() {
//@        this.getGame().setMenu();
//@    }
//@
//@    @Override
//@    public void think(int delta) {
//@
//@    }
//@
//@    @Override
//@    public void render(final BitsGLGraphics g) {
//@        int addY = 0;
//@        if (ApoHybridConstants.FREE_VERSION) {
//@            addY += 50;
//@        }
//@        this.getGame().drawString(g, ApoHybridCredits.TITLE, 240, 5 + addY, ApoHybridPanel.title_font);
//@        this.getGame().drawString(g, ApoHybridCredits.SUB, 240, 50 + addY, ApoHybridPanel.game_font);
//@        this.getGame().drawString(g, ApoHybridCredits.SUB_2, 240, 65 + addY, ApoHybridPanel.game_font);
//@
//@        String s = "gameplay is based on";
//@        this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 100 + addY, ApoHybridPanel.game_font);
//@        s = "F.O.L.D. by Cosine";
//@        this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 115 + addY, ApoHybridPanel.game_font);
//@        s = "and";
//@        this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 130 + addY, ApoHybridPanel.game_font);
//@        s = "Blockdude by Brandon Sterner";
//@        this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 145 + addY, ApoHybridPanel.game_font);
//@
//@        s = "music by";
//@        this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 175 + addY, ApoHybridPanel.game_font);
//@        s = "Eric Skiff, http://ericskiff.com/";
//@        this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 190 + addY, ApoHybridPanel.game_font);
//@
//@        s = "thanks to";
//@        this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 220 + addY, ApoHybridPanel.game_font);
//@        s = "Florian, Network, Thecoolestnerdguy";
//@        this.getGame().drawString(g, s, (int)(5), 235 + addY, ApoHybridPanel.game_font);
//@        s = "Sparky83, Marc, Basti, Clemens";
//@        this.getGame().drawString(g, s, (int)(5), 250 + addY, ApoHybridPanel.game_font);
//@
//@//		g.setColor(1f, 1f, 1f, 1f);
//@//		g.drawImage(this.credits, 200, 220, 80, 80);
//@
//@        this.getGame().renderButtons(g);
//@    }
//@}
//#elif TreasureGameLogic
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
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//@
//@import net.apogames.apohybrid.ApoHybridConstants;
//@import net.apogames.apohybrid.ApoHybridModel;
//@import net.apogames.apohybrid.ApoHybridSoundPlayer;
//@
//@public class ApoHybridCredits extends ApoHybridModel {
//@
//@	public static final String BACK = "back";
//@	
//@	public ApoHybridCredits(final ApoHybridPanel game) {
//@		super(game);
//@	}
//@
//@	@Override
//@	public void init() {
//@	}
//@
//@	@Override
//@	public void touchedButton(String function) {
//@		this.getGame().playSound(ApoHybridSoundPlayer.SOUND_CLICK);
//@		if (function.equals(ApoHybridCredits.BACK)) {
//@			this.onBackButtonPressed();
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
//@		String s = "credits";
//@		float w = ApoHybridConstants.FONT_LEVELCHOOSER.getLength(s);
//@		g.drawText(s, ApoHybridConstants.GAME_WIDTH/2 - w/2 + 4, 54 - y);
//@		
//@		g.setFont(ApoHybridConstants.fontMedium);
//@		y = ApoHybridConstants.fontMedium.mCharCellHeight;
//@		s = "art design by";
//@		w = ApoHybridConstants.fontMedium.getLength(s);
//@		g.drawText(s, ApoHybridConstants.GAME_WIDTH/2 - w/2, 125 - y);
//@
//@		s = "engine by";
//@		w = ApoHybridConstants.fontMedium.getLength(s);
//@		g.drawText(s, ApoHybridConstants.GAME_WIDTH/2 - w/2, 220 - y);
//@		
//@		s = "everything else by";
//@		w = ApoHybridConstants.fontMedium.getLength(s);
//@		g.drawText(s, ApoHybridConstants.GAME_WIDTH/2 - w/2, 350 - y);
//@
//@		s = "music by";
//@		w = ApoHybridConstants.fontMedium.getLength(s);
//@		g.drawText(s, ApoHybridConstants.GAME_WIDTH/2 - w/2, 285 - y);
//@		
//@		g.setFont(ApoHybridConstants.FONT_STATISTICS);
//@		y = ApoHybridConstants.FONT_STATISTICS.mCharCellHeight;
//@		s = "tinytouchtales.com";
//@		w = ApoHybridConstants.FONT_STATISTICS.getLength(s);
//@		g.drawText(s, ApoHybridConstants.GAME_WIDTH/2 - w/2, 150 - y);
//@		
//@		s = "and";
//@		w = ApoHybridConstants.FONT_STATISTICS.getLength(s);
//@		g.drawText(s, ApoHybridConstants.GAME_WIDTH/2 - w/2, 170 - y);
//@		
//@		s = "apo-games.de";
//@		w = ApoHybridConstants.FONT_STATISTICS.getLength(s);
//@		g.drawText(s, ApoHybridConstants.GAME_WIDTH/2 - w/2, 190 - y);
//@		
//@		s = "apo-games.de";
//@		w = ApoHybridConstants.FONT_STATISTICS.getLength(s);
//@		g.drawText(s, ApoHybridConstants.GAME_WIDTH/2 - w/2, 375 - y);
//@
//@		s = "Marc Wiedenhoeft";
//@		w = ApoHybridConstants.FONT_STATISTICS.getLength(s);
//@		g.drawText(s, ApoHybridConstants.GAME_WIDTH/2 - w/2, 245 - y);
//@		
//@		s = "Max Josef Ender";
//@		w = ApoHybridConstants.FONT_STATISTICS.getLength(s);
//@		g.drawText(s, ApoHybridConstants.GAME_WIDTH/2 - w/2, 310 - y);
//@		
//@		g.setColor(1f, 1f, 1f, 1f);
//@	}
//@
//@}
//#endif
