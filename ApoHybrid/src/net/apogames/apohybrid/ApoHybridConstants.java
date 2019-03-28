package net.apogames.apohybrid;

public class ApoHybridConstants {

	//#if DiceGameLogic
	public final static String USERLEVELS_GETPHP = "http://www.apo-games.de/apoDice4k/get_level.php";
	public final static String USERLEVELS_SAVEPHP = "http://www.apo-games.de/apoDice4k/save_level.php";
		
	public static final String PREFS_NAME = "ApoDicePref";
	
	public static final boolean[] BUTTON_MENU = new boolean[] {true, true, true, true, false, false, false, false, false, false, false};
	public static final boolean[] BUTTON_GAME = new boolean[] {false, false, false, false, false, true, false, false, false, false, false};
	public static final boolean[] BUTTON_PUZZLE = new boolean[] {false, false, false, false, true, false, false, false, false, false, false};
	public static final boolean[] BUTTON_EDITOR = new boolean[] {false, false, false, false, false, false, true, true, true, true, false};
	
	//#elif SnakeGameLogic
//@	public final static String USERLEVELS_GETPHP = "http://www.apo-games.de/apoSn4ke/get_level.php";
//@	public final static String USERLEVELS_SAVEPHP = "http://www.apo-games.de/apoSn4ke/save_level.php";
//@	
//@	public static final String PREFS_NAME = "ApoSnakePref";
//@	
//@	public static final boolean[] BUTTON_MENU = new boolean[] {true, true, true, true, false, false, false, false, false, false, false, false, false};
//@	public static final boolean[] BUTTON_GAME = new boolean[] {false, false, false, false, false, true, false, false, false, false, false, false, false};
//@	public static final boolean[] BUTTON_PUZZLE = new boolean[] {false, false, false, false, true, false, false, false, false, false, false, false, false};
//@	public static final boolean[] BUTTON_EDITOR = new boolean[] {false, false, false, false, false, false, true, true, true, true, true, true, true};
//@	
//@
	//#elif ClockGameLogic
//@	public final static String USERLEVELS_GETPHP = "http://www.apo-games.de/apoClock4k/get_level.php";
//@	public final static String USERLEVELS_SAVEPHP = "http://www.apo-games.de/apoClock4k/save_level.php";
//@	
//@	public final static String HIGHSCORE_GETPHP = "http://www.apo-games.de/apoClock4k/get_highscore.php";
//@	public final static String HIGHSCORE_SAVEPHP = "http://www.apo-games.de/apoClock4k/save_highscore.php";
//@	
//@	public static final String PREFS_NAME = "ApoClockPref";
//@	
//@	public static final boolean[] BUTTON_MENU = new boolean[] {true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true};
//@	public static final boolean[] BUTTON_GAME = new boolean[] {false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
//@	public static final boolean[] BUTTON_PUZZLE = new boolean[] {false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
//@	public static final boolean[] BUTTON_ARCARDE = new boolean[] {false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false};
//@	public static final boolean[] BUTTON_ARCARDE_GAME = new boolean[] {false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false};
//@	public static final boolean[] BUTTON_PUZZLE_FIRST = new boolean[] {false, false, false, false, false, false, false, false, true, true, true, true, false, false, false, false, false, false, false, false};
//@	public static final boolean[] BUTTON_EDITOR = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, true, true, false, false};
//@	public static final boolean[] BUTTON_OPTIONS = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false};
//@
	//#endif

	public static final int GAME_WIDTH = 480;
	public static final int GAME_HEIGHT = 640;
	
}
