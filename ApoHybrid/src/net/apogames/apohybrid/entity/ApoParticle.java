package net.apogames.apohybrid.entity;

import net.apogames.apohybrid.ApoHybridConstants;
import net.apogames.apohybrid.game.ApoHybridGame;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;

public class ApoParticle {

	private float x, y, vecX, vecY;
	
	private boolean bVisible;
	
	public ApoParticle(final float x, final float y, final float vecX, final float vecY) {
		this.x = x;
		this.y = y;
		this.vecX = vecX;
		this.vecY = vecY;
		this.bVisible = true;
	}

	public float getX() {
		return x;
	}

	public void setX(final float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(final float y) {
		this.y = y;
	}

	public float getVecX() {
		return vecX;
	}

	public void setVecX(final float vecX) {
		this.vecX = vecX;
	}

	public float getVecY() {
		return vecY;
	}

	public void setVecY(final float vecY) {
		this.vecY = vecY;
	}
	
	public boolean isVisible() {
		return this.bVisible;
	}

	public void setVisible(final boolean bVisible) {
		this.bVisible = bVisible;
	}

	public void think(final int delta) {
		if (this.bVisible) {
			this.x = this.x + this.vecX * delta;
			this.y = this.y + this.vecY * delta;
			this.vecY += 0.0007f;
			this.vecX *= 0.9995f;
			
			if ((this.x < 0) || (this.x > ApoHybridConstants.GAME_WIDTH) || (this.y > 240 + ApoHybridGame.changeY)) {
				this.bVisible = false;
			}
		}
	}
	
	public void render(final BitsGLGraphics g, int changeX, int changeY) {
		g.fillRect(this.x + changeX - 1, this.y + changeY - 1, 3, 3);
	}
}
