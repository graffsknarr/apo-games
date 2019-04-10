package net.apogames.apohybrid.entity;

//#if ClockMenu
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLImage;
//#elif MonoMenu
import net.apogames.apohybrid.ApoHybridConstants;
import net.apogames.apohybrid.game.ApoHybridPanel;
import net.apogames.apohybrid.game.ApoHybridGame;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//#else
//@import net.gliblybits.bitsengine.core.BitsImage;
//#endif

public class ApoLevelChooserButton extends ApoButton {
	private boolean bSelected;
	private String text;
	private boolean bSolved;
	//#if ClockMenu
//@	public ApoLevelChooserButton(BitsGLImage iBackground, int x, int y, int width, int height, String function) {
//@		super(iBackground, x, y, width, height, function);
//@		
//@		this.bSolved = false;
	//#elif MonoMenu
	public ApoLevelChooserButton(int x, int y, int width, int height, String function, String text) {
		this(x, y, width, height, function, text, false);
	}
	
	public ApoLevelChooserButton(int x, int y, int width, int height, String function, String text, final boolean bSelected) {
		super(null, x, y, width, height, function);
		
		this.bSelected = bSelected;
		this.text = text;

	//#else
//@	public ApoLevelChooserButton(BitsImage iBackground, int x, int y, int width, int height, String function) {
//@		super(iBackground, x, y, width, height, function);
//@		
//@		this.bSolved = false;
	//#endif

	}

	public boolean isSolved() {
		return this.bSolved;
	}

	public void setSolved(boolean bSolved) {
		this.bSolved = bSolved;
	}

	public boolean isSelected() {
		return this.bSelected;
	}

	public void setSelected(boolean bSelected) {
		this.bSelected = bSelected;
	}




	//#if MonoMenu
	public void render(BitsGLGraphics g, int changeX, int changeY ) {
		if ( this.isBVisible() ) {
			int x = (int)(this.getX());
			int y = (int)(this.getY());
			int width = (int)(this.getWidth());
			int height = (int)(this.getHeight());
			String s = this.text;
			
			ApoLevelChooserButton.drawOneBlock(g, x, y, width, height);
			
			if (this.bSelected) {
				if (s.equals("x")) {
					ApoHybridGame.drawX(g, x + width/2 - 16, y + height/2 - 16, true, ApoHybridConstants.BRIGHT, false, false);
				} else {
					g.setColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
					g.setFont(ApoHybridPanel.game_font);
					g.drawText(s, (int)(x + width/2 - ApoHybridPanel.game_font.getLength(s)/2), y + height/2 - ApoHybridPanel.game_font.mCharCellHeight/2);
				}
			}
		}
	}
	
	public static void drawBlock(final BitsGLGraphics g, final int x, final int y, final int width, final int height) {
		for (int j = 0; j < width/16; j++) {
			ApoLevelChooserButton.drawOneBlock(g, x + j * 16, y, 16, 16);
			if ((j == 0) || (j + 1 == width/16)) {
				for (int k = 1; k < height/16 - 1; k++) {
					ApoLevelChooserButton.drawOneBlock(g, x + j * 16, y + k * 16, 16, 16);
				}
			}
			ApoLevelChooserButton.drawOneBlock(g, x + j * 16, y + height - 16, 16, 16);
		}
	}
	
	public static void drawOneBlock(final BitsGLGraphics g, int x, int y, final int width, final int height) {
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
	//#endif
}
