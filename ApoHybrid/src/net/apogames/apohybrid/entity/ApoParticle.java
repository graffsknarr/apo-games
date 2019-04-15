//#if MonoGameLogic
//@package net.apogames.apohybrid.entity;
//@
//@import net.apogames.apohybrid.ApoHybridConstants;
//@import net.apogames.apohybrid.game.ApoHybridGame;
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//@
//@public class ApoParticle {
//@
//@    private float x, y, vecX, vecY;
//@
//@    private boolean bVisible;
//@
//@    public ApoParticle(final float x, final float y, final float vecX, final float vecY) {
//@        this.x = x;
//@        this.y = y;
//@        this.vecX = vecX;
//@        this.vecY = vecY;
//@        this.bVisible = true;
//@    }
//@
//@    public float getX() {
//@        return x;
//@    }
//@
//@    public void setX(final float x) {
//@        this.x = x;
//@    }
//@
//@    public float getY() {
//@        return y;
//@    }
//@
//@    public void setY(final float y) {
//@        this.y = y;
//@    }
//@
//@    public float getVecX() {
//@        return vecX;
//@    }
//@
//@    public void setVecX(final float vecX) {
//@        this.vecX = vecX;
//@    }
//@
//@    public float getVecY() {
//@        return vecY;
//@    }
//@
//@    public void setVecY(final float vecY) {
//@        this.vecY = vecY;
//@    }
//@
//@    public boolean isVisible() {
//@        return this.bVisible;
//@    }
//@
//@    public void setVisible(final boolean bVisible) {
//@        this.bVisible = bVisible;
//@    }
//@
//@    public void think(final int delta) {
//@        if (this.bVisible) {
//@            this.x = this.x + this.vecX * delta;
//@            this.y = this.y + this.vecY * delta;
//@            this.vecY += 0.0007f;
//@            this.vecX *= 0.9995f;
//@
//@            if ((this.x < 0) || (this.x > ApoHybridConstants.GAME_WIDTH) || (this.y > 240 + ApoHybridGame.changeY)) {
//@                this.bVisible = false;
//@            }
//@        }
//@    }
//@
//@    public void render(final BitsGLGraphics g, int changeX, int changeY) {
//@        g.fillRect(this.x + changeX - 1, this.y + changeY - 1, 3, 3);
//@    }
//@}
//#elif TreasureGameLogic
package com.apogames.apohybrid.entity;

import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;

import com.apogames.apohybrid.ApoHybridConstants;

public class ApoParticle {

	private float x, y, width, height;
	private float vecX, vecY;
	
	private boolean bVisible;
	
	public ApoParticle(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.vecY = (float)(Math.random() * 0.11) - 0.09f;
		this.vecX = (float)(Math.random() * 0.1) - 0.05f;
		
		this.bVisible = true;
	}
	
	public boolean isVisible() {
		return this.bVisible;
	}
	
	public void setVisible(boolean bVisible) {
		this.bVisible = bVisible;
	}

	public void think(final int delta) {
		if (this.bVisible) {
			this.x += this.vecX * delta;
			this.y += this.vecY * delta;
			if ((this.y > ApoHybridConstants.GAME_HEIGHT) || (this.x + this.width < 0) || (this.x > ApoHybridConstants.GAME_WIDTH)) {
				this.bVisible = false;
			}
			this.vecY += 0.0005f;
			if (this.vecX < 0) {
				this.vecX += 0.00005f;
				if (this.vecX >= 0) {
					this.vecX = 0;
				}
			}
			if (this.vecX > 0) {
				this.vecX -= 0.00005f;
				if (this.vecX <= 0) {
					this.vecX = 0;
				}
			}
		}
	}


	/**
	 * malt das Objekt
	 * @param g = Graphics2D Objekt
	 */
	public void render(BitsGLGraphics g) {
		this.render(g, 0, 0);
	}
	
	/**
	 * malt das Objekt
	 * @param g = Graphics2D Objekt
	 */
	public void render(BitsGLGraphics g, final int changeX, final int changeY) {
		g.setColor(ApoHybridConstants.COLOR_DARK);
		g.fillRect(this.x + changeX, this.y + changeY, this.width, this.height);
	}
	
}
//#endif
