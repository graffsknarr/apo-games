package net.apogames.apohybrid.entity;

import net.apogames.apohybrid.game.ApoHybridMenu;
import net.apogames.apoclock.game.ApoHybridPanel;
//#ifdef ClockGameLogic
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//@
//@public class ApoClockString {
//#else
import net.gliblybits.bitsengine.render.BitsGraphics;

public class ApoHybridString extends ApoHybridEntity {
//#endif


	public static final int TIME_DECREASE = 10;
	//#ifdef ClockGameLogic
//@	private final String drawString;
//@	private final float direction;
//@	private final float x, y;
	//#else
	private String drawString;
	//#endif
	
	
	private int invisible;
	
	private int curTime;
	
	private boolean bWithBackground;
	
	private int timeDecrease;
	//#ifdef ClockGameLogic
//@	private boolean bFade, bVisible;
//@	
//@	public ApoClockString(final float x, final float y, final float direction, String s, final boolean bWithBackground, final int timeDecrease, final boolean bFade) {
//@		this.x = x;
//@		this.y = y;
//@		this.direction = direction;
//@		this.bVisible = true;
//@
	//#elif DiceGameLogic
	private boolean bFade;
	public ApoHybridString(float x, float y, float width, String s, boolean bWithBackground, int timeDecrease, boolean bFade) {		
		super(x, y, width, 0, 0);

	//#elif SnakeGameLogic
//@	private boolean bFade;
//@	public ApoHybridString(float x, float y, float width, String s, boolean bWithBackground, int timeDecrease, boolean bFade) {		
//@		super((int)x, (int)y, (int)width, 0);
	//#endif	


		
		this.bWithBackground = bWithBackground;
		this.drawString = s;
		this.invisible = 255;
		this.curTime = 0;
		this.timeDecrease = timeDecrease;
		this.curTime = this.timeDecrease;
		this.bFade = bFade;
	}
	
	//#ifdef ClockGameLogic
//@		public boolean isVisible() {
//@		return bVisible;
//@	}
//@
//@	public void setVisible(boolean bVisible) {
//@		this.bVisible = bVisible;
//@	}
	//#endif

	public void think(int delta) {
		this.curTime -= delta;
		if (this.curTime <= 0) {
			if (this.bFade) {
				this.curTime = this.timeDecrease;
				this.invisible -= 1;
				if (this.invisible <= 50) {
					this.invisible = 0;
					//#ifdef ClockGameLogic
//@					this.bVisible = false;
					//#else
					super.setVisible(false);
					//#endif

				}
			} else {
				//#ifdef ClockGameLogic
//@				this.bVisible = false;
				//#else
				super.setVisible(false);
				//#endif

			}
		}
	}
	//#ifdef ClockGameLogic
//@	public void render(final BitsGLGraphics g, int changeX, int changeY) {
	//#else
	public void render(final BitsGraphics g, int changeX, int changeY) {
	//#endif	

		if (this.isVisible()) {
			
			String s = this.drawString;
			int w = (int)(ApoHybridMenu.font.getLength(s) + 10);
			int h = ApoHybridMenu.font.mCharCellHeight;
			//#if DiceGameLogic
			int x = (int)(this.getX() + this.getRadius()/2 - w/2) - changeX;
			int change = 10;
			int y = (int)(this.getY() + this.getRadius()/2 + h/2) - changeY;
			//#elif SnakeGameLogic
//@			int x = (int)(this.getX() + this.getDirection()/2 - w/2) - changeX;
//@			int change = 10;
//@			int y = (int)(this.getY() + this.getDirection()/2 + h/2) - changeY;
			//#endif
			
			
			if (this.bWithBackground) {
				g.setColor(255, 255, 255, this.invisible);
				//#ifdef ClockGameLogic
//@				g.fillRect((int)(x - change), (int)(y - h - change), (int)(w + 2 * change), (int)(h + 2 * change));
				//#else
				g.drawFilledRect((int)(x - change), (int)(y - h - change), (int)(w + 2 * change), (int)(h + 2 * change));
				//#endif

				g.setColor(0, 0, 0, this.invisible);
				g.setLineSize(3);
				g.drawRect((int)(x - change), (int)(y - h - change), (int)(w + 2 * change), (int)(h + 2 * change));
				g.setLineSize(1);
			}
			g.setColor(0, 0, 0, this.invisible);
			//#ifdef ClockGameLogic
//@			g.setFont(ApoClockPanel.game_font);
			//#else
			g.drawText(s, ApoHybridMenu.font, x, y - h);
			//#endif

		}
	}

}
