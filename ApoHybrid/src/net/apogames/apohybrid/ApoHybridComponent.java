package net.apogames.apohybrid;

import net.apogames.apohybrid.entity.ApoButton;
import net.gliblybits.bitsengine.gui.BitsScreen;

//#if ClockGameLogic
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//@import net.gliblybits.bitsengine.input.BitsInput;
//@import net.gliblybits.bitsengine.input.BitsKeyEvent;
//@import net.gliblybits.bitsengine.input.BitsPointerEvent;
//@import net.gliblybits.bitsengine.input.listener.BitsKeyListener;
//@import net.gliblybits.bitsengine.input.listener.BitsPointerListener;
//@
//#elif DiceGameLogic
import net.gliblybits.bitsengine.gui.BitsButton;
import net.gliblybits.bitsengine.render.BitsGraphics;
import net.gliblybits.bitsengine.input.BitsInput;
import net.gliblybits.bitsengine.input.BitsKeyEvent;
import net.gliblybits.bitsengine.input.BitsKeyListener;
import net.gliblybits.bitsengine.input.BitsTouchEvent;
import net.gliblybits.bitsengine.input.BitsTouchListener;
//#elif SnakeGameLogic
//@import net.gliblybits.bitsengine.gui.BitsButton;
//@import net.gliblybits.bitsengine.render.BitsGraphics;
//@import net.gliblybits.bitsengine.input.touch.BitsTouchPointer;
//@import net.gliblybits.bitsengine.input.touch.BitsTouchPointerManager;
//#endif

//#if DiceGameLogic
public abstract class ApoHybridComponent extends BitsScreen implements BitsTouchListener, BitsKeyListener {
//#elif SnakeGameLogic
//@public abstract class ApoHybridComponent extends BitsScreen {
//#elif ClockGameLogic
//@public abstract class ApoClockComponent extends BitsScreen implements BitsPointerListener, BitsKeyListener {
//#endif

	/** Array der ganzen Buttons im Spiel */
	private ApoButton[] buttons;

	private int oldX, oldY;

	//#if DiceGameLogic || SnakeGameLogic
	private final boolean[] touched = new boolean[3];
	
	public void onButtonPressed(BitsButton button) {		

	}
	
	public void setModel(ApoHybridModel model) {
		this.model = model;
	}
	
	//#elif ClockGameLogic
//@	public void setModel(final ApoClockModel model) {
//@		this.model = model;
//@	}
//@	
	//#endif

	private ApoHybridModel model;
	
	protected ApoHybridComponent(int id) {
		super(id);
	}


	public ApoHybridModel getModel() {
		return this.model;
	}

	

	/**
	 * gibt das Array mit den Buttons zur?ck
	 * @return gibt das Array mit den Buttons zur?ck
	 */
	public final ApoButton[] getButtons() {
		return this.buttons;
	}

	/**
	 * setzt das Array mit den Buttons auf den ?bergebenen Wert
	 * @param buttons : neues Array mit Buttons
	 */
	public void setButtons(ApoButton[] buttons) {
		this.buttons = buttons;
	}
	
	//#if ClockGameLogic
//@	public final boolean onPointerDown( final int pointerId, final float x, final float y, final BitsPointerEvent event ) {
//@		boolean bButton = false;
//@		if (this.getButtons() != null) {
//@			for (int b = 0; b < this.getButtons().length; b++) {
//@				if ((this.getButtons()[b].isVisible()) && (this.getButtons()[b].intersects(x, y, 1, 1))) {
//@					String function = this.getButtons()[b].getFunction();
//@					this.setButtonFunction(function);
//@					bButton = true;
//@					break;
//@				}
//@			}
//@		}
//@		if (!bButton) {
//@			if (this.model != null) {
//@				this.model.touchedPressed((int)x, (int)y, pointerId);
//@			}
//@		}
//@		this.oldX = (int)x;
//@		this.oldY = (int)y;
//@		
//@		return true;
//@	}
//@
//@	public final boolean onPointerUp( final int pointerId, final float x, final float y, final BitsPointerEvent event ) {
//@		if (this.model != null) {
//@			this.model.touchedReleased((int)x, (int)y, pointerId);
//@		}
//@		
//@		return true;
//@	}
//@
//@	public final boolean onPointerDragged( final int pointerId, final float x, final float y, final float deltaX, final float deltaY, final BitsPointerEvent event ) {
//@		if ((this.model != null) && (((int)(x) != this.oldX) || ((int)(y) != this.oldY))) {
//@			this.model.touchedDragged((int)(x), (int)(y), this.oldX, this.oldY, pointerId);
//@		}
//@		
//@		this.oldX = (int)x;
//@		this.oldY = (int)y;
//@		
//@		return true;
//@	}
	//#endif
	
	/**
	 * rendert die Buttons
	 * @param g : das Graphics2D Object
	 */
	
	//#if ClockGameLogic
//@	public void renderButtons(BitsGLGraphics g) {
	//#else
	public void renderButtons(BitsGraphics g) {
	//#endif	
		if (this.buttons != null) {
				for (int i = 0; i < this.buttons.length; i++) {
					this.buttons[i].render(g, 0, 0);
				}
			}
		}
	

	/**
	 * wird aufgerufen, wenn ein Button gedr?ckt wurde
	 * @param function : Funktion, die der Button ausf?hren soll und ihn einzigartig macht
	 */
	public abstract void setButtonFunction(String function);
	
	//#if ClockGameLogic
//@	@Override
//@	public void onInitScreen() {
//@		BitsInput.getInstance().registerPointerListener(this);
//@		BitsInput.getInstance().registerKeyListener(this);
//@		init();
//@	}
//@
//@	@Override
//@	public void onPauseScreen() {
//@		
//@	}
//@
//@	@Override
//@	public void onResumeScreen() {
//@		
//@	}
//@
//@	@Override
//@	public void onFinishScreen() {
//@		
//@	}
//@
//@	
	//#else

	@Override
	public void onPause() {
		
	}

	@Override
	public void onResume() {
		
	}

	@Override
	public void onFinish() {
		
	}

	//#endif
	
	public void init() {
		
	}

	@Override
	public void onBackButtonPressed() {
		
	}

	//#if DiceGameLogic
	public final void onTouchDown( final int pointerId, final float x, final float y, final BitsTouchEvent event ) {
		boolean bButton = false;
		if (this.getButtons() != null) {
			for (int b = 0; b < this.getButtons().length; b++) {
				if ((this.getButtons()[b].isBVisible()) && (this.getButtons()[b].intersects(x, y, 1, 1))) {
					String function = this.getButtons()[b].getFunction();
					this.setButtonFunction(function);
					bButton = true;
					break;
				}
			}
		}
		if (!bButton) {
			if (this.model != null) {
				this.model.touchedPressed((int)x, (int)y, pointerId);
			}
		}
		this.oldX = (int)x;
		this.oldY = (int)y;
	}

	public final void onTouchUp( final int pointerId, final float x, final float y, final BitsTouchEvent event ) {
		if (this.model != null) {
			this.model.touchedReleased((int)x, (int)y, pointerId);
		}     	
	}

	public final void onTouchDragged( final int pointerId, final float x, final float y, final BitsTouchEvent event ) {
		if ((this.model != null) && (((int)(x) != this.oldX) || ((int)(y) != this.oldY))) {
			this.model.touchedDragged((int)(x), (int)(y), this.oldX, this.oldY, pointerId);
		}
		
		this.oldX = (int)x;
		this.oldY = (int)y;
	}

	@Override
	public void onInit() {
		BitsInput.getIt().registerTouchListener(this);
		init();
	}
	
	public void onKeyDown(final int key, final BitsKeyEvent event) {
		if (this.model != null) {
			this.model.onKeyDown(key);
		}
	}

	public void onKeyUp(final int key, final BitsKeyEvent event) {
		if (this.model != null) {
			this.model.onKeyUp(key);
		}
	}

	//#elif SnakeGameLogic
//@	@Override
//@	public void onInit() {
//@		init();
//@	}
//@
//@	public void checkTouchInput() {
//@		for (int i = 0; i < this.touched.length; i++) {
//@			final BitsTouchPointer pointer = BitsTouchPointerManager.getIt().get(i);
//@			boolean newTouched = false;
//@			if (pointer == null) {
//@				newTouched = false;
//@			} else {
//@				newTouched = pointer.isDown;
//@			}
//@			if ((newTouched) && (!this.touched[i])) {
//@				if (pointer != null) {
//@					int x = pointer.mX;
//@					int y = pointer.mY;
//@					this.oldX = x;
//@					this.oldY = y;
//@					
//@					boolean bButton = false;
//@					if (this.getButtons() != null) {
//@						for (int b = 0; b < this.getButtons().length; b++) {
//@							if ((this.getButtons()[b].isBVisible()) && (this.getButtons()[b].intersects(x, y, 1, 1))) {
//@								String function = this.getButtons()[b].getFunction();
//@								this.setButtonFunction(function);
//@								bButton = true;
//@								break;
//@							}
//@						}
//@					}
//@					if (!bButton) {
//@						if (this.model != null) {
//@							this.model.touchedPressed(x, y, i);
//@						}
//@					}
//@				}
//@			} else if ((!newTouched) && (this.touched[i])) {
//@				int x = 0;
//@				int y = 0;
//@				if (pointer != null) {
//@					x = pointer.mX;
//@					y = pointer.mY;
//@				}
//@				if (this.model != null) {
//@					this.model.touchedReleased(x, y, i);
//@				}
//@			} else if ((newTouched) && (this.touched[i])) {
//@				if (pointer != null) {
//@					int x = pointer.mX;
//@					int y = pointer.mY;
//@					
//@					if ((this.model != null) && ((this.oldX != x) || (this.oldY != y))) {
//@						this.model.touchedDragged(x, y, this.oldX, this.oldY, i);
//@					}
//@					this.oldX = x;
//@					this.oldY = y;
//@				}
//@			}
//@			this.touched[i] = newTouched; 
//@		}
//@	}
//@
	//#elif ClockGameLogic
//@	public boolean onKeyDown(final int key, final BitsKeyEvent event) {
//@		if (this.model != null) {
//@			this.model.onKeyDown(key, event);
//@		}
//@		
//@		return true;
//@	}
//@
//@	public boolean onKeyUp(final int key, final BitsKeyEvent event) {
//@		if (this.model != null) {
//@			this.model.onKeyUp(key, event);
//@		}
//@		
//@		return true;
//@	}	
//@	
	//#endif

}
