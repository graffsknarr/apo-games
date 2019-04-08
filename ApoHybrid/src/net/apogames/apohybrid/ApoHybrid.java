package net.apogames.apohybrid;

//#if MonoGameLogic
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import android.content.Context;
import android.content.SharedPreferences;
//#else
//@import android.content.Context;
//@import android.content.SharedPreferences;
//@import android.net.ConnectivityManager;
//@import android.net.NetworkInfo;
//#endif

import net.apogames.apohybrid.game.ApoHybridPanel;

import net.gliblybits.bitsengine.core.BitsApp;
import net.gliblybits.bitsengine.core.BitsGame;
import net.gliblybits.bitsengine.utils.BitsLog;

public class ApoHybrid extends BitsApp {

	public static SharedPreferences settings;
	
	public static NetworkInfo ni;

	//#if MonoGameLogic
	public static AdView adView = null;
	
	public static ApoHybrid activity;
	//#endif
	
	@Override
	//#if ClockGameLogic || MonoGameLogic
	protected void onCreateApp() 
	//#else
//@	protected void onCreate( )
	//#endif 
	{
		//#if MonoGameLogic
		BitsLog.setLogType(BitsLog.TYPE_DEBUG);
		
		ApoHybrid.activity = this;
		
		DisplayMetrics dm = new DisplayMetrics();
		this.getWindowManager().getDefaultDisplay().getMetrics(dm);

		int height = dm.heightPixels;
		int width = dm.widthPixels;
		
		BitsApp.sGameWidth = ApoHybridConstants.GAME_WIDTH;
		BitsApp.sGameHeight = ApoHybridConstants.GAME_HEIGHT;
		
		float originalDisplay = (float)(width) / (float)(height);
		float gameDisplay = (float)(ApoHybridConstants.GAME_WIDTH) / (float)(ApoHybridConstants.GAME_HEIGHT);
		if (originalDisplay >= gameDisplay) {
			ApoHybridConstants.MAX = (float)(height) / (float)(ApoHybridConstants.GAME_HEIGHT);
		} else {
			ApoHybridConstants.MAX = (float)(width) / (float)(ApoHybridConstants.GAME_WIDTH);			
		}
		//BitsApp.sViewportWidth = (int)(ApoHybridConstants.GAME_WIDTH * ApoHybridConstants.MAX);//1280;//1920;//(int)(ApoHybridConstants.GAME_WIDTH * ApoHybridConstants.MAX);
		//BitsApp.sViewportHeight = (int)(ApoHybridConstants.GAME_HEIGHT * ApoHybridConstants.MAX);//800;//1080;//(int)(ApoHybridConstants.GAME_HEIGHT * ApoHybridConstants.MAX);
//		BitsApp.sWantFullscreen = false;
//		BitsApp.sMaxFPS = 60;
		BitsApp.sMaxUpdate = 100;
		BitsApp.sOrientationMode = BitsApp.ORIENTATION_LANDSCAPE;
		BitsApp.sWantTitleBar = false;
		BitsApp.sMaxCirclePoints = 180;
		BitsApp.sMaxTouchPointer = 3;
//		BitsApp.sSleepMode = BitsApp.SLEEP_MODE_OFF;

		BitsGame.getInstance().addScreen(new ApoHybridPanel(1));

		//#else
//@		BitsLog.setLogType(BitsLog.TYPE_NONE);
//@		
		//#if ClockGameLogic
//@		BitsApp.sWantFullscreen = true;
//@		BitsApp.sOrientationMode = BitsApp.ORIENTATION_PORTRAIT;
//@		BitsApp.sGameWidth = 480;
//@		BitsApp.sGameHeight = 640;
//@		BitsApp.sWantTitleBar = false;
//@		BitsApp.sMaxCirclePoints = 180;
//@//		BitsApp.sMaxFPS = 60;
//@		BitsApp.sMaxUpdate = 100;
//@		BitsApp.sMaxTouchPointer = 3;
//@//		BitsApp.sSleepMode = BitsApp.SLEEP_MODE_OFF;
//@
//@		BitsGame.getInstance().addScreen(new ApoHybridPanel(1));	
//@		
		//#else
//@		BitsGame.sWantFullscreen = true;
//@		BitsGame.sOrientationMode = BitsGame.ORIENTATION_PORTRAIT;
//@		BitsGame.sGameWidth = 480;
//@		BitsGame.sGameHeight = 640;
//@		BitsGame.sWantTitleBar = false;
//@		BitsGame.sMaxRenderCommands = 1000;
//@		BitsGame.sMaxImageCount = 10;
//@		BitsGame.sMaxCirclePoints = 180;
//@		BitsGame.sMaxFPS = 60;
//@		BitsGame.sMaxTouchPointer = 3;
//@		BitsGame.sSleepMode = BitsGame.SLEEP_MODE_OFF;
//@		BitsGame.sWantMusic = false;
//@		BitsGame.sWantSound = false;
//@		BitsGame.sMaxFontCount = 3;
//@
//@		BitsGame.getIt().addScreen(new ApoHybridPanel(1));
		//#endif
		//#endif
		
		ConnectivityManager cm = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
		ApoHybrid.ni = cm.getActiveNetworkInfo();
		
		ApoHybrid.settings = this.getSharedPreferences(ApoHybridConstants.PREFS_NAME, 0);
		

	}
	
	public static boolean isOnline() {
		if (ApoHybrid.ni == null) {
			return false;
		}
		return ApoHybrid.ni.isConnected();
	}

	//#if ClockGameLogic || MonoGameLogic
	@Override
	protected void onStopApp( ) {
	}

	@Override
	protected void onAddView() {
		//#if MonoGameLogic
		if (ApoHybridConstants.FREE_VERSION) {
			// Create the adView
		    adView = new AdView(this, AdSize.BANNER, "a1510eb01a099dc"); 
		    AdRequest request = new AdRequest();
			request.addTestDevice(AdRequest.TEST_EMULATOR);
			adView.loadAd(request);
			
			RelativeLayout.LayoutParams adParams =
	                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
	        adParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
	        adParams.addRule(RelativeLayout.CENTER_IN_PARENT);
			this.addView(adView, adParams);
		}
		//#endif
	}

	@Override
	public void onAudioFocusChange(int focusChange) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onInitApp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onPauseApp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onResumeApp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onDestroyApp() {
		// TODO Auto-generated method stub
		
	}
	//#else
//@	@Override
//@	protected void onFinish( ) {
//@	}
	//#endif

	
}
