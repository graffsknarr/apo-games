package net.apogames.apohybrid.entity;

//#ifdef ClockMenu
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLImage;
//#else
import net.gliblybits.bitsengine.core.BitsImage;
//#endif

public class ApoLevelChooserButton extends ApoButton {

	private boolean bSolved;
	//#ifdef ClockMenu
//@	public ApoLevelChooserButton(BitsGLImage iBackground, int x, int y, int width, int height, String function) {
	//#else
	public ApoLevelChooserButton(BitsImage iBackground, int x, int y, int width, int height, String function) {
	//#endif

		super(iBackground, x, y, width, height, function);
		
		this.bSolved = false;
	}

	public boolean isSolved() {
		return this.bSolved;
	}

	public void setSolved(boolean bSolved) {
		this.bSolved = bSolved;
	}

}
