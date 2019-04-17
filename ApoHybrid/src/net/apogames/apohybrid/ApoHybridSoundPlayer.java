//#if MonoGameLogic || TreasureGameLogic
//@package net.apogames.apohybrid;
//@
//@import net.gliblybits.bitsengine.sound.BitsSound;
//@import net.gliblybits.bitsengine.sound.BitsSoundFactory;
//@
//@public class ApoHybridSoundPlayer {
//@
//#if MonoGameLogic
//@    public static BitsSound SOUND_WIN;
//@    public static BitsSound SOUND_BUTTON;
//@    public static BitsSound SOUND_BUTTON_2;
//@    public static BitsSound SOUND_FOLD;
//@    public static BitsSound SOUND_GRAVITY;
//@    public static BitsSound SOUND_LOSE;
//@    public static BitsSound SOUND_DROP;
//@    public static BitsSound SOUND_PICK;
//#elif TreasureGameLogic
//@	public static BitsSound SOUND_CLICK;
//@	public static BitsSound SOUND_WIN_1;
//@	public static BitsSound SOUND_WIN_2;
//@	public static BitsSound SOUND_WIN_3;
//#endif
//@	
//@
//@    public ApoHybridSoundPlayer() {
	//#if MonoGameLogic
//@        SOUND_WIN = BitsSoundFactory.getInstance().getSound(R.raw.win, BitsSound.TYPE_WAV, true);
//@        SOUND_BUTTON = BitsSoundFactory.getInstance().getSound(R.raw.button, BitsSound.TYPE_WAV, true);
//@        SOUND_BUTTON_2 = BitsSoundFactory.getInstance().getSound(R.raw.button_2, BitsSound.TYPE_WAV, true);
//@        SOUND_FOLD = BitsSoundFactory.getInstance().getSound(R.raw.fold, BitsSound.TYPE_WAV, true);
//@        SOUND_GRAVITY = BitsSoundFactory.getInstance().getSound(R.raw.gravitychange, BitsSound.TYPE_WAV, true);
//@        SOUND_LOSE = BitsSoundFactory.getInstance().getSound(R.raw.loose, BitsSound.TYPE_WAV, true);
//@        SOUND_DROP = BitsSoundFactory.getInstance().getSound(R.raw.drop, BitsSound.TYPE_WAV, true);
//@        SOUND_PICK = BitsSoundFactory.getInstance().getSound(R.raw.pick, BitsSound.TYPE_WAV, true);
	//#elif TreasureGameLogic
//@	SOUND_CLICK = BitsSoundFactory.getInstance().getSound(R.raw.click_1, BitsSound.TYPE_OGG, true);
//@	SOUND_WIN_1 = BitsSoundFactory.getInstance().getSound(R.raw.coin_1, BitsSound.TYPE_OGG, true);
//@	SOUND_WIN_2 = BitsSoundFactory.getInstance().getSound(R.raw.coin_2, BitsSound.TYPE_OGG, true);
//@	SOUND_WIN_3 = BitsSoundFactory.getInstance().getSound(R.raw.coin_3, BitsSound.TYPE_OGG, true);
	//#endif
//@	
//@        BitsSoundFactory.getInstance().loadAll();
//@    }
//@
//@    public void playSound(BitsSound sound) {
//@        sound.play(1f, 1f, false);
//@    }
//@}
//#endif
