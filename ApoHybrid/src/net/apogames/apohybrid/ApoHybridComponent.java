package net.apogames.apohybrid;

import net.apogames.apohybrid.entity.ApoButton;
import net.gliblybits.bitsengine.gui.BitsButton;
import net.gliblybits.bitsengine.gui.BitsScreen;
import net.gliblybits.bitsengine.render.BitsGraphics;

//#if Dice
//@import net.gliblybits.bitsengine.input.BitsInput;
//@import net.gliblybits.bitsengine.input.BitsKeyEvent;
//@import net.gliblybits.bitsengine.input.BitsKeyListener;
//@import net.gliblybits.bitsengine.input.BitsTouchEvent;
//@import net.gliblybits.bitsengine.input.BitsTouchListener;
//#elif Snake
import net.gliblybits.bitsengine.input.touch.BitsTouchPointer;
import net.gliblybits.bitsengine.input.touch.BitsTouchPointerManager;
//#endif

//#if Dice
//@public abstract class ApoHybridComponent extends BitsScreen implements BitsTouchListener, BitsKeyListener {
//#elif Snake
public abstract class ApoHybridComponent extends BitsScreen {
//#endif

	/** Array der ganzen Buttons im Spiel */
	private ApoButton[] buttons;

	private int oldX, oldY;

	private final boolean[] touched = new boolean[3];


	private ApoHybridModel model;
	
	protected ApoHybridComponent(int id) {
		super(id);
	}

	public void onButtonPressed(BitsButton button) {
		
	}

	public ApoHybridModel getModel() {
		return this.model;
	}

	public void setModel(ApoHybridModel model) {
		this.model = model;
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
	
	
	
	/**
	 * rendert die Buttons
	 * @param g : das Graphics2D Object
	 */
	public void renderButtons(BitsGraphics g) {
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
	
	
	
	public void init() {
		
	}

	@Override
	public void onPause() {
		
	}

	@Override
	public void onResume() {
		
	}

	@Override
	public void onFinish() {
		
	}

	@Override
	public void onBackButtonPressed() {
		
	}

	//#if Dice
//@	public final void onTouchDown( final int pointerId, final float x, final float y, final BitsTouchEvent event ) {
//@		boolean bButton = false;
//@		if (this.getButtons() != null) {
//@			for (int b = 0; b < this.getButtons().length; b++) {
//@				if ((this.getButtons()[b].isBVisible()) && (this.getButtons()[b].intersects(x, y, 1, 1))) {
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
//@	}
//@
//@	public final void onTouchUp( final int pointerId, final float x, final float y, final BitsTouchEvent event ) {
//@		if (this.model != null) {
//@			this.model.touchedReleased((int)x, (int)y, pointerId);
//@		}     	
//@	}
//@
//@	public final void onTouchDragged( final int pointerId, final float x, final float y, final BitsTouchEvent event ) {
//@		if ((this.model != null) && (((int)(x) != this.oldX) || ((int)(y) != this.oldY))) {
//@			this.model.touchedDragged((int)(x), (int)(y), this.oldX, this.oldY, pointerId);
//@		}
//@		
//@		this.oldX = (int)x;
//@		this.oldY = (int)y;
//@	}
//@
//@	@Override
//@	public void onInit() {
//@		BitsInput.getIt().registerTouchListener(this);
//@		init();
//@	}
//@	
//@	public void onKeyDown(final int key, final BitsKeyEvent event) {
//@		if (this.model != null) {
//@			this.model.onKeyDown(key);
//@		}
//@	}
//@
//@	public void onKeyUp(final int key, final BitsKeyEvent event) {
//@		if (this.model != null) {
//@			this.model.onKeyUp(key);
//@		}
//@	}
//@
	//#elif Snake
	@Override
	public void onInit() {
		init();
	}

	public void checkTouchInput() {
		for (int i = 0; i < this.touched.length; i++) {
			final BitsTouchPointer pointer = BitsTouchPointerManager.getIt().get(i);
			boolean newTouched = false;
			if (pointer == null) {
				newTouched = false;
			} else {
				newTouched = pointer.isDown;
			}
			if ((newTouched) && (!this.touched[i])) {
				if (pointer != null) {
					int x = pointer.mX;
					int y = pointer.mY;
					this.oldX = x;
					this.oldY = y;
					
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
							this.model.touchedPressed(x, y, i);
						}
					}
				}
			} else if ((!newTouched) && (this.touched[i])) {
				int x = 0;
				int y = 0;
				if (pointer != null) {
					x = pointer.mX;
					y = pointer.mY;
				}
				if (this.model != null) {
					this.model.touchedReleased(x, y, i);
				}
			} else if ((newTouched) && (this.touched[i])) {
				if (pointer != null) {
					int x = pointer.mX;
					int y = pointer.mY;
					
					if ((this.model != null) && ((this.oldX != x) || (this.oldY != y))) {
						this.model.touchedDragged(x, y, this.oldX, this.oldY, i);
					}
					this.oldX = x;
					this.oldY = y;
				}
			}
			this.touched[i] = newTouched; 
		}
	}

	//#endif

}
