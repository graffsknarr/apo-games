package net.apogames.apohybrid;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import net.apogames.apohybrid.game.ApoHybridPanel;

import net.gliblybits.bitsengine.core.BitsApp;
import net.gliblybits.bitsengine.core.BitsGame;
import net.gliblybits.bitsengine.utils.BitsLog;

public class ApoHybrid extends BitsApp {

	public static SharedPreferences settings;
	
	public static NetworkInfo ni;
	
	@Override
	//#ifdef ClockGameLogic
	protected void onCreateApp( ) 
	//#else
	protected void onCreate( )
	//#endif 
	{
		BitsLog.setLogType(BitsLog.TYPE_NONE);
		
		//#ifdef ClockGameLogic
		BitsApp.sWantFullscreen = true;
		BitsApp.sOrientationMode = BitsApp.ORIENTATION_PORTRAIT;
		BitsApp.sGameWidth = 480;
		BitsApp.sGameHeight = 640;
		BitsApp.sWantTitleBar = false;
		BitsApp.sMaxCirclePoints = 180;
//		BitsApp.sMaxFPS = 60;
		BitsApp.sMaxUpdate = 100;
		BitsApp.sMaxTouchPointer = 3;
//		BitsApp.sSleepMode = BitsApp.SLEEP_MODE_OFF;

		BitsGame.getInstance().addScreen(new ApoClockPanel(1));	
		
		//#else
		BitsGame.sWantFullscreen = true;
		BitsGame.sOrientationMode = BitsGame.ORIENTATION_PORTRAIT;
		BitsGame.sGameWidth = 480;
		BitsGame.sGameHeight = 640;
		BitsGame.sWantTitleBar = false;
		BitsGame.sMaxRenderCommands = 1000;
		BitsGame.sMaxImageCount = 10;
		BitsGame.sMaxCirclePoints = 180;
		BitsGame.sMaxFPS = 60;
		BitsGame.sMaxTouchPointer = 3;
		BitsGame.sSleepMode = BitsGame.SLEEP_MODE_OFF;
		BitsGame.sWantMusic = false;
		BitsGame.sWantSound = false;
		BitsGame.sMaxFontCount = 3;

		BitsGame.getIt().addScreen(new ApoHybridPanel(1));
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

	//#ifdef ClockGameLogic
	@Override
	protected void onStopApp( ) {
	}

	@Override
	protected void onAddView() {
		
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
	@Override
	protected void onFinish( ) {
	}
	//#endif

	
}
