package net.apogames.apohybrid;

//#if MonoGameLogic
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
//#elif TreasureGameLogic
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLFont;
//@import net.gliblybits.bitsengine.graphics.opengl.BitsGLImage;
//#endif

public class ApoHybridConstants {
	//#if !MonoGameLogic && !TreasureGameLogic
	public static final int GAME_WIDTH = 480;
	public static final int GAME_HEIGHT = 640;
	//#endif

	//#if DiceGameLogic
//@	public final static String USERLEVELS_GETPHP = "http://www.apo-games.de/apoDice4k/get_level.php";
//@	public final static String USERLEVELS_SAVEPHP = "http://www.apo-games.de/apoDice4k/save_level.php";
//@
//@	public static final String PREFS_NAME = "ApoDicePref";
//@
//@	public static final boolean[] BUTTON_MENU = new boolean[] {true, true, true, true, false, false, false, false, false, false, false};
//@	public static final boolean[] BUTTON_GAME = new boolean[] {false, false, false, false, false, true, false, false, false, false, false};
//@	public static final boolean[] BUTTON_PUZZLE = new boolean[] {false, false, false, false, true, false, false, false, false, false, false};
//@	public static final boolean[] BUTTON_EDITOR = new boolean[] {false, false, false, false, false, false, true, true, true, true, false};
//@
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
	public final static String USERLEVELS_GETPHP = "http://www.apo-games.de/apoClock4k/get_level.php";
	public final static String USERLEVELS_SAVEPHP = "http://www.apo-games.de/apoClock4k/save_level.php";

	public final static String HIGHSCORE_GETPHP = "http://www.apo-games.de/apoClock4k/get_highscore.php";
	public final static String HIGHSCORE_SAVEPHP = "http://www.apo-games.de/apoClock4k/save_highscore.php";

	public static final String PREFS_NAME = "ApoClockPref";

	public static final boolean[] BUTTON_MENU = new boolean[] {true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true};
	public static final boolean[] BUTTON_GAME = new boolean[] {false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
	public static final boolean[] BUTTON_PUZZLE = new boolean[] {false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
	public static final boolean[] BUTTON_ARCARDE = new boolean[] {false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false};
	public static final boolean[] BUTTON_ARCARDE_GAME = new boolean[] {false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false};
	public static final boolean[] BUTTON_PUZZLE_FIRST = new boolean[] {false, false, false, false, false, false, false, false, true, true, true, true, false, false, false, false, false, false, false, false};
	public static final boolean[] BUTTON_EDITOR = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, true, true, false, false};
	public static final boolean[] BUTTON_OPTIONS = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false};


	//#elif MonoGameLogic
//@	public final static String USERLEVELS_GETPHP = "http://www.apo-games.de/apoMonoMirror4k/get_level.php";
//@	public final static String USERLEVELS_SAVEPHP = "http://www.apo-games.de/apoMonoMirror4k/save_level.php";
//@
//@	public static final int GAME_WIDTH = 480;
//@	public static final int GAME_HEIGHT = 330;
//@
//@	public static float MAX = 1f;
//@
//@	public static final boolean FREE_VERSION = true;
//@
//@	public static final String PREFS_NAME = "ApoHybridPref";
//@
//@	public static final boolean FPS = false;
//@
//@	public static final boolean[] BUTTON_MENU = new boolean[] {true, true, true, false, false, false, false, false, false, true, false, false, false, false, false, false, true, false, false, false, false, false, false};
//@	public static final boolean[] BUTTON_GAME = new boolean[] {false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false};
//@	public static final boolean[] BUTTON_CREDITS = new boolean[] {false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false};
//@	public static final boolean[] BUTTON_EDITOR = new boolean[] {false, false, false, false, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
//@	public static final boolean[] BUTTON_OPTIONS = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, false, true, true};
//@	public static final boolean[] BUTTON_LEVELCHOOSER = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false};
//@
//@	public static final float[] BRIGHT_GREEN = new float[] {155f/256f, 188f/256f, 15f/256f};
//@	public static final float[] BRIGHT_DARK_GREEN = new float[] {130f/256f, 163f/256f, 15f/256f};
//@	public static final float[] DARK_BRIGHT_GREEN = new float[] {30f/256f, 71f/256f, 15f/256f};
//@	public static final float[] DARK_GREEN = new float[] {15f/256f, 56f/256f, 15f/256f};
//@
//@	public static final float[] BRIGHT_WHITE = new float[] {256f/256f, 256f/256f, 256f/256f};
//@	public static final float[] BRIGHT_DARK_WHITE = new float[] {224f/256f, 224f/256f, 224f/256f};
//@	public static final float[] DARK_BRIGHT_WHITE = new float[] {64f/256f, 64f/256f, 64f/256f};
//@	public static final float[] DARK_WHITE = new float[] {32f/256f, 32f/256f, 32f/256f};
//@
//@	public static float[] GREEN = new float[] {60f/256f, 200f/256f, 60f/256f, 1f};
//@	public static float[] BRIGHT = BRIGHT_GREEN;
//@	public static float[] BRIGHT_DARK = BRIGHT_DARK_GREEN;
//@	public static float[] DARK_BRIGHT = DARK_BRIGHT_GREEN;
//@	public static float[] DARK = DARK_GREEN;
//@
//@	public static void changeToWhiteColor() {
//@		BRIGHT = BRIGHT_WHITE;
//@		BRIGHT_DARK = BRIGHT_DARK_WHITE;
//@		DARK_BRIGHT = DARK_BRIGHT_WHITE;
//@		DARK = DARK_WHITE;
//@
//@		BitsGLGraphics.setClearColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
//@	}
//@
//@	public static void changeToGreenColor() {
//@		BRIGHT = BRIGHT_GREEN;
//@		BRIGHT_DARK = BRIGHT_DARK_GREEN;
//@		DARK_BRIGHT = DARK_BRIGHT_GREEN;
//@		DARK = DARK_GREEN;
//@
//@		BitsGLGraphics.setClearColor(ApoHybridConstants.BRIGHT[0], ApoHybridConstants.BRIGHT[1], ApoHybridConstants.BRIGHT[2], 1f);
//@	}
//@
//@	public static final String MENU_PLAY_ENGLISH = "play";
//@	public static final String MENU_EDITOR_ENGLISH = "editor";
//@	public static final String MENU_USERLEVELS_ENGLISH = "userlevels";
//@
//@	public static final String OPTION_TITLE_ENGLISH = "options";
//@	public static final String OPTION_LANGUAGE_ENGLISH = "language";
//@	public static final String OPTION_SOUND_ENGLISH = "sound";
//@	public static final String OPTION_MUSIC_ENGLISH = "music";
//@	public static final String OPTION_COLOR_ENGLISH = "colors";
//@	public static final String OPTION_COLOR_WHITE_ENGLISH = "white";
//@	public static final String OPTION_COLOR_GREEN_ENGLISH = "green";
//@
//@	public static final String LEVELCHOOSER_TITLE_ENGLISH = "Levelchooser";
//@
//@	public static final String GAME_RESTART_ENGLISH = "Please try again!:Touch anywhere:to restart the level.";
//@	public static final String GAME_WIN_ENGLISH = "Congratulation!:Touch anywhere:to start the next level.";
//@
//@	public static final String HELP_STANDARD_ENGLISH = "Touch 'retry' to restart the level";
//@
//@	public static final String[] HELP_ENGLISH = new String[] {
//@			"Move with the cursor keys:and reach the flag.",
//@			"Pick up or drop a block:with the highlighted button: on the down right side.",
//@			"Press the highlighted action button:on the down right side:to open the folding mode.",
//@			"Press the button in the middle down:to remove your last step.",
//@			"In the upper left corner you can see:how often you can use the folding mode",
//@			"",
//@			"",
//@			"",
//@			"The spikes are deadly:and can be folded.",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			"The x doesn't accept:new things after folding.",
//@			" ",
//@			" ",
//@			"The air destroys everything after mirroring.",
//@			" ",
//@			" ",
//@			" ",
//@			"The block with the + can be folded but:will stay on its old position too.",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			"The block with the line is a:one step block. After running:over it, it will explode",
//@			" ",
//@			" ",
//@			"Fold the screen from down to up,:to solve the level.",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			"In some levels you have to change:the gravity to solve the level.",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			"The beamers will beam blocks or you:to the other portal.",
//@	};
//@
//@	public static final String HELP_MIRROR_ENGLISH = "Move the folding line with the cursor keys.:Press the button again to start folding.:Press the x-button to quit the fold mode";
//@
//@	public static final String MENU_PLAY_GERMAN = "Starten";
//@	public static final String MENU_EDITOR_GERMAN = "Editor";
//@	public static final String MENU_USERLEVELS_GERMAN = "Benutzerlevels";
//@
//@	public static final String OPTION_TITLE_GERMAN = "Optionen";
//@	public static final String OPTION_LANGUAGE_GERMAN = "Sprache";
//@	public static final String OPTION_SOUND_GERMAN = "Sound";
//@	public static final String OPTION_MUSIC_GERMAN = "Musik";
//@	public static final String OPTION_COLOR_GERMAN = "Farben";
//@	public static final String OPTION_COLOR_WHITE_GERMAN = "weiss";
//@	public static final String OPTION_COLOR_GREEN_GERMAN = "gruen";
//@
//@	public static final String LEVELCHOOSER_TITLE_GERMAN = "Levelauswahl";
//@
//@	public static final String GAME_RESTART_GERMAN = "Bitte versuche es erneut!:Druecke irgendwo hin,:um das Level neu zu starten.";
//@	public static final String GAME_WIN_GERMAN = "Herzlichen Glueckwunsch!:Druecke irgendwo hin,:um das naechste Level zu starten.";
//@
//@	public static final String HELP_STANDARD_GERMAN = "Zum Neustarten des Levels 'retry' druecken.";
//@
//@	public static final String[] HELP_GERMAN = new String[] {
//@			"Beweg dich mit den Pfeiltasten.:Dein Ziel ist die Flagge.",
//@			"Nimm oder leg einen Block:mit der hervorgehobenen Taste unten rechts.",
//@			"Druecke die hervorgehobene Taste unten:rechts, um den 'Faltmodus' zu oeffnen.:Einfarbige Bloecke koennen gefaltet werden.",
//@			"Mit dem Knopf unten mittig wird dein:letzter Schritt rueckgaengig gemacht.",
//@			"In der linken oberen Ecke ist sichtbar,:wie oft der Faltmodus benutzt werden kann.",
//@			"",
//@			"",
//@			"",
//@			"Die Stacheln sind toedlich und:werden auch mitgefaltet.",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			"Das X zerstoert die gefalteten Bloecke:und kann selber nicht gefaltet werden.",
//@			" ",
//@			" ",
//@			"Die Luft zerstoert alles nach dem Falten.",
//@			" ",
//@			" ",
//@			" ",
//@			"Der Block mit dem + kann gefaltet werden:aber wird auch an:seiner alten Stelle bleiben.",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			"Der Block mit der Linie zerstoert sich:nachdem du einmal drueberlaufen bist.",
//@			" ",
//@			" ",
//@			"Jetzt kannst das Level auch von:unten nach oben falten.",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			"In einigen Levels muss die:Schwerkraft veraendert werden,:um sie zu loesen.",
//@			" ",
//@			" ",
//@			" ",
//@			" ",
//@			"Die Beamer portieren dich:und tragbare Bloecke zum anderen Beamer.",
//@	};
//@
//@	public static final String HELP_MIRROR_GERMAN = "Bewege die Faltlinie mit den Pfeiltasten:Druecke die Taste noch einmal,:um die Teile zu falten.:Druecke die Taste mit dem X,:um den Faltmodus zu beenden.";
//@
//@	public static final String[] TEXT_WIN = new String[] {
//@			"yeah",
//@			"juhu",
//@			"cool",
//@			"jippie",
//@			"grins",
//@			"*gg*",
//@	};
//@
//@	public static final String[] TEXT_IDLE = new String[] {
//@			"come on",
//@			"gogo",
//@			"gaehn",
//@			"zzZZzz",
//@	};
//@
//@	public static String MENU_PLAY = MENU_PLAY_ENGLISH;
//@	public static String MENU_EDITOR = MENU_EDITOR_ENGLISH;
//@	public static String MENU_USERLEVELS = MENU_USERLEVELS_ENGLISH;
//@
//@	public static String OPTION_TITLE = OPTION_TITLE_ENGLISH;
//@	public static String OPTION_LANGUAGE = OPTION_LANGUAGE_ENGLISH;
//@	public static String OPTION_COLOR = OPTION_COLOR_ENGLISH;
//@	public static String OPTION_SOUND = OPTION_SOUND_ENGLISH;
//@	public static String OPTION_MUSIC = OPTION_MUSIC_ENGLISH;
//@	public static String OPTION_COLOR_WHITE = OPTION_COLOR_WHITE_ENGLISH;
//@	public static String OPTION_COLOR_GREEN = OPTION_COLOR_GREEN_ENGLISH;
//@
//@	public static String LEVELCHOOSER_TITLE = LEVELCHOOSER_TITLE_ENGLISH;
//@
//@	public static String GAME_RESTART = GAME_RESTART_ENGLISH;
//@	public static String GAME_WIN = GAME_WIN_ENGLISH;
//@
//@	public static String HELP_STANDARD = HELP_STANDARD_ENGLISH;
//@
//@	public static String[] HELP = HELP_ENGLISH;
//@
//@	public static String HELP_MIRROR = HELP_MIRROR_ENGLISH;
//@
//@	public static void changeLanguageToGerman() {
//@		HELP_STANDARD = HELP_STANDARD_GERMAN;
//@		HELP = HELP_GERMAN;
//@		HELP_MIRROR = HELP_MIRROR_GERMAN;
//@		OPTION_TITLE = OPTION_TITLE_GERMAN;
//@		OPTION_LANGUAGE = OPTION_LANGUAGE_GERMAN;
//@		OPTION_COLOR = OPTION_COLOR_GERMAN;
//@		MENU_PLAY = MENU_PLAY_GERMAN;
//@		MENU_EDITOR = MENU_EDITOR_GERMAN;
//@		MENU_USERLEVELS = MENU_USERLEVELS_GERMAN;
//@		OPTION_COLOR_WHITE = OPTION_COLOR_WHITE_GERMAN;
//@		OPTION_COLOR_GREEN = OPTION_COLOR_GREEN_GERMAN;
//@		OPTION_SOUND = OPTION_SOUND_GERMAN;
//@		OPTION_MUSIC = OPTION_MUSIC_GERMAN;
//@		GAME_RESTART = GAME_RESTART_GERMAN;
//@		GAME_WIN = GAME_WIN_GERMAN;
//@		LEVELCHOOSER_TITLE = LEVELCHOOSER_TITLE_GERMAN;
//@	}
//@
//@	public static void changeLanguageToEnglish() {
//@		HELP_STANDARD = HELP_STANDARD_ENGLISH;
//@		HELP = HELP_ENGLISH;
//@		HELP_MIRROR = HELP_MIRROR_ENGLISH;
//@		OPTION_TITLE = OPTION_TITLE_ENGLISH;
//@		OPTION_LANGUAGE = OPTION_LANGUAGE_ENGLISH;
//@		OPTION_COLOR = OPTION_COLOR_ENGLISH;
//@		MENU_PLAY = MENU_PLAY_ENGLISH;
//@		MENU_EDITOR = MENU_EDITOR_ENGLISH;
//@		MENU_USERLEVELS = MENU_USERLEVELS_ENGLISH;
//@		OPTION_COLOR_WHITE = OPTION_COLOR_WHITE_ENGLISH;
//@		OPTION_COLOR_GREEN = OPTION_COLOR_GREEN_ENGLISH;
//@		GAME_RESTART = GAME_RESTART_ENGLISH;
//@		GAME_WIN = GAME_WIN_ENGLISH;
//@		LEVELCHOOSER_TITLE = LEVELCHOOSER_TITLE_ENGLISH;
//@		OPTION_SOUND = OPTION_SOUND_ENGLISH;
//@		OPTION_MUSIC = OPTION_MUSIC_ENGLISH;
//@	}
//@
	//#elif TreasureGameLogic
//@	public static final int GAME_WIDTH = 320;
//@	public static final int GAME_HEIGHT = 480;
//@	
//@	
//@	public final static String USERLEVELS_GETPHP = "http://www.apo-games.de/myTreasure/get_level.php";
//@	public final static String USERLEVELS_SAVEPHP = "http://www.apo-games.de/myTreasure/save_level.php";
//@	
//@	public static boolean FREE_VERSION = false;
//@	
//@	public static final String PREFS_NAME = "MytreasurePref";
//@	
//@	public static String REGION;
//@	
//@	static {
//@		ApoHybridConstants.REGION = "en";
//@		try {
//@			ApoHybridConstants.REGION = System.getProperty("user.language");
//@		} catch (Exception ex) {
//@			ApoHybridConstants.REGION = "en";
//@		}
//@		ApoHybridConstants.setLanguage(ApoHybridConstants.REGION);
//@	}
//@	
//@	public static final String PROGRAM_NAME = "=== ApoHybrid ===";
//@	public static final double VERSION = 0.01;
//@	
//@	public static boolean FPS = false;
//@	public static boolean FIRST_MAP = true;
//@	public static boolean FIRST_GAME = true;
//@	public static boolean FIRST_LEVELCHOOSER = true;
//@	public static boolean FIRST_LEVELCHOOSER_DRAG = true;
//@	public static boolean SOUND_GAME = true;
//@	public static boolean MUSIC_GAME = true;
//@	
//@	public static int LEVELCHOOSER_STEP = 0;
//@	
//@	public static final int FPS_THINK = 100;
//@	public static final int FPS_RENDER = 100;
//@	
//@	public static final int WAIT_TIME_RENDER = (int)(1000.0 / (double)FPS_RENDER);
//@	public static final int WAIT_TIME_THINK = (int)(1000.0 / (double)FPS_THINK);
//@	
//@	public static final int CHANGE_DRAG = 50;
//@	
//@	public static BitsGLFont font;
//@	public static BitsGLFont FONT_FPS;
//@	public static BitsGLFont FONT_STATISTICS;
//@	public static BitsGLFont FONT_LEVELCHOOSER;
//@	
//@	public static BitsGLFont fontBig;
//@	public static BitsGLFont fontMedium;
//@	public static BitsGLFont fontSmall;
//@	public static BitsGLFont fontVerySmall;
//@	
//@	public static BitsGLImage iSheet;
//@	public static BitsGLImage iWays;
//@	
//@	public static final int[] COLOR_DARK = new int[] {78, 61, 37};
//@	public static final int[] COLOR_LIGHT = new int[] {175, 136, 78};
//@	public static final int[] COLOR_SEPARATOR = new int[] {68, 68, 68};
//@	
//@	public static final int START_IDLE_TEXT_TIME = 5000;
//@	public static final int END_IDLE_TEXT_TIME = 9000;
//@	
//@	public static final String[] TEXT_IDLE = new String[] {
//@		"come on",
//@		"gogo",
//@		"gaehn",
//@		"zzZZzz",
//@	};
//@	
//@	public static final String[] TEXT_WIN = new String[] {
//@		"Juhu",
//@		"Yeah",
//@		"*gg*",
//@	};
//@	
//@	public static final String[] DIFFICULTY_ENG = new String[] {
//@		"camp",
//@		"temple",
//@		"pyramid",
//@		"crypt"
//@	};
//@	
//@	public static final String FIRST_COLLECT_ENG[] = new String[] {
//@		"Your task:",
//@		"Collect all Relics."
//@	};
//@	
//@	public static final String FIRST_MOVE_ENG[] = new String[] {
//@		"To move the player, rotate the level.",
//@		"Touch the screen on the left side",
//@		"to rotate the level clockwise.",
//@		"Touch the screen on the right side",
//@		"to rotate the level counterclockwise.",
//@	};
//@	
//@	public static final String[] DIFFICULTY_DE = new String[] {
//@		"Camp",
//@		"Tempel",
//@		"Pyramide",
//@		"Gruft"
//@	};
//@	
//@	public static final String FIRST_COLLECT_DE[] = new String[] {
//@		"Dein Ziel:",
//@		"Sammle alle Sch?tze"
//@	};
//@	
//@	public static final String FIRST_MOVE_DE[] = new String[] {
//@		"Um den Spieler zu bewegen, rotiere das Level.",
//@		"Ber?hre die linke H?lfte des Bildschirms,",
//@		"um das Level im Uhrzeigersinn zu drehen.",
//@		"Ber?hre die rechte H?lfte des Bildschirms,",
//@		"um das Level gegen im Uhrzeigersinn zu drehen.",
//@	};
//@	
//@	public static String[] DIFFICULTY = ApoHybridConstants.DIFFICULTY_ENG;
//@	public static String[] FIRST_COLLECT = ApoHybridConstants.FIRST_COLLECT_ENG;
//@	public static String[] FIRST_MOVE = ApoHybridConstants.FIRST_MOVE_ENG;
//@	
//@	/** 
//@	 * 0 = menu quit
//@	 * 1 = menu play
//@	 * 2 = menu userlevels
//@	 * 3 = menu editor
//@	 * 4 = menu credits / about
//@	 * 5 = level Chooser back
//@	 * 6 = game back
//@	 * 7 = map back
//@	 * 8 = game ingame restart
//@	 * 9 = game ingame next
//@	 * 10 = game ingame previous
//@	 * 11 = game result back
//@	 * 12 = game result restart
//@	 * 13 = game result next
//@	 * 14 = credits back
//@	 * 15 = editor back
//@	 * 16 = editor size left
//@	 * 17 = editor size right
//@	 * 18 = editor test
//@	 * 19 = editor upload
//@	*/
//@	public static final boolean[] BUTTON_MENU = new boolean[] {true, true, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false};
//@	public static final boolean[] BUTTON_MAP = new boolean[] {false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
//@	public static final boolean[] BUTTON_LEVELCHOOSER = new boolean[] {false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
//@	public static final boolean[] BUTTON_GAME = new boolean[] {false, false, false, false, false, false, true, false, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true};
//@	public static final boolean[] BUTTON_EDITOR = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, false, false, false, false, false, false, false, false};
//@	public static final boolean[] BUTTON_CREDITS = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false};
//@	public static final boolean[] BUTTON_OPTIONS = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, false, false};
//@
//@	public static final void setLanguage(final String region) {
//@		if ((region != null) && (region.equals("de"))) {
//@			ApoHybridConstants.DIFFICULTY = ApoHybridConstants.DIFFICULTY_DE;
//@			ApoHybridConstants.FIRST_COLLECT = ApoHybridConstants.FIRST_COLLECT_DE;
//@			ApoHybridConstants.FIRST_MOVE = ApoHybridConstants.FIRST_MOVE_DE;
//@		} else {
//@			ApoHybridConstants.DIFFICULTY = ApoHybridConstants.DIFFICULTY_ENG;
//@			ApoHybridConstants.FIRST_COLLECT = ApoHybridConstants.FIRST_COLLECT_ENG;
//@			ApoHybridConstants.FIRST_MOVE = ApoHybridConstants.FIRST_MOVE_ENG;
//@		}
//@	}
//@
	//#endif

}
