//#if !TreasureGameLogic
package net.apogames.apohybrid.entity;

//#if ClockGameLogic || MonoGameLogic
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//#else
import net.gliblybits.bitsengine.render.BitsGraphics;
//#endif


public class ApoHybridEntity {
    //#if DiceGameLogic
//@
//@	private float velocity;
//@	
//@	private float x, y, radius, angle;
//@	
//@	private boolean bVisible;
//@	
//@	public ApoHybridEntity(float x, float y, float radius, float angle, float velocity) {
//@		this.x = x;
//@		this.y = y;
//@		this.radius = radius;
//@		this.angle = angle;
//@		this.velocity = velocity;
//@		this.bVisible = true;
//@	}
//@
//@	public float getX() {
//@		return x;
//@	}
//@
//@	public void setX(final float x) {
//@		this.x = x;
//@	}
//@
//@	public float getY() {
//@		return y;
//@	}
//@
//@	public void setY(final float y) {
//@		this.y = y;
//@	}
//@
//@	public float getRadius() {
//@		return radius;
//@	}
//@
//@	public void setRadius(final float radius) {
//@		this.radius = radius;
//@	}
//@
//@	public float getAngle() {
//@		return angle;
//@	}
//@
//@	public void setAngle(final float angle) {
//@		this.angle = angle;
//@	}
//@
//@	public float getVelocity() {
//@		return this.velocity;
//@	}
//@
//@	public void setVelocity(final float velocity) {
//@		this.velocity = velocity;
//@	}
//@
//@	public boolean isVisible() {
//@		return bVisible;
//@	}
//@
//@	public void setVisible(final boolean bVisible) {
//@		this.bVisible = bVisible;
//@	}
//@	
//@	public boolean intersects(final float checkX, final float checkY, final float checkRadius) {
//@		float newX = (checkX - this.x) * (checkX - this.x);
//@		float newY = (checkY - this.y) * (checkY - this.y);
//@		float radius = (checkRadius + this.radius) * (checkRadius + this.radius);
//@		if (newX + newY <= radius) {
//@			return true;
//@		}
//@		return false;
//@	}
//@	
//@	public void think(final int delta) {
//@		this.x += (this.velocity * delta) * Math.sin(Math.toRadians(this.angle));
//@		this.y += (-this.velocity * delta) * Math.cos(Math.toRadians(this.angle));
//@	}
//@	
//@	public void render(final BitsGraphics g) {
//@		this.render(g, 0, 0);
//@	}
//@	
//@	public void render(final BitsGraphics g, int changeX, int changeY) {
//@		if (this.isVisible()) {
//@			g.setColor(255f/255f, 120f/255f, 120f/255f, 1.0f);
//@			g.drawFilledCircle((int)(this.x - changeX), (int)(this.y - changeY), (int)(this.radius), 120);
//@			g.setColor(0.0f, 0.0f, 0.0f, 1.0f);
//@			g.drawCircle((int)(this.x - changeX), (int)(this.y - changeY), (int)(this.radius), 120);
//@		}
//@	}
//@
    //#elif SnakeGameLogic
//@
//@    private int x, y, direction, color;
//@
//@    private boolean bVisible;
//@
//@    public ApoHybridEntity(int x, int y, int direction, int color) {
//@        this.x = x;
//@        this.y = y;
//@        this.direction = direction;
//@        this.color = color;
//@        this.bVisible = true;
//@    }
//@
//@    public int getX() {
//@        return this.x;
//@    }
//@
//@    public void setX(int x) {
//@        this.x = x;
//@    }
//@
//@    public int getY() {
//@        return this.y;
//@    }
//@
//@    public void setY(int y) {
//@        this.y = y;
//@    }
//@
//@    public int getDirection() {
//@        return this.direction;
//@    }
//@
//@    public void setDirection(int direction) {
//@        this.direction = direction;
//@    }
//@
//@    public int getColor() {
//@        return this.color;
//@    }
//@
//@    public void setColor(int color) {
//@        this.color = color;
//@    }
//@
//@    public boolean isVisible() {
//@        return bVisible;
//@    }
//@
//@    public void setVisible(final boolean bVisible) {
//@        this.bVisible = bVisible;
//@    }
//@
//@    public void think(final int delta) {
//@    }
//@
//@    public void render(final BitsGraphics g) {
//@        this.render(g, 0, 0);
//@    }
//@
//@    public void render(final BitsGraphics g, int changeX, int changeY) {
//@        if (this.isVisible()) {
//@
//@        }
//@    }
    //#endif

}
//#endif
