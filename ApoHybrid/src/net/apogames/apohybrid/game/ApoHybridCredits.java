//#if MonoGameLogic
package net.apogames.apohybrid.game;

import net.apogames.apohybrid.ApoHybridConstants;
import net.apogames.apohybrid.ApoHybridModel;
import net.apogames.apohybrid.ApoHybridSoundPlayer;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLFactory;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLGraphics;
import net.gliblybits.bitsengine.graphics.opengl.BitsGLImage;

public class ApoHybridCredits  extends ApoHybridModel {

    public static final String BACK = "back";
    public static final String TITLE = "Credits";
    public static final String SUB = "ApoHybrid is made by Dirk 'Apo' Aporius";
    public static final String SUB_2 = "made with the bits-engine by Marc Wiedenhoeft";

    public BitsGLImage credits;

    public ApoHybridCredits(ApoHybridPanel game) {
        super(game);
    }

    @Override
    public void init() {
        this.getStringWidth().put(ApoHybridCredits.TITLE, (int)(ApoHybridPanel.title_font.getLength(ApoHybridCredits.TITLE)));
        this.getStringWidth().put(ApoHybridCredits.SUB, (int)(ApoHybridPanel.game_font.getLength(ApoHybridCredits.SUB)));
        this.getStringWidth().put(ApoHybridCredits.SUB_2, (int)(ApoHybridPanel.game_font.getLength(ApoHybridCredits.SUB_2)));

        if (this.credits == null) {
            this.credits = BitsGLFactory.getInstance().getImage( "?net/gliblybits/bitsengine/BitsEngineLogo.png", BitsGLImage.FILTER_NEAREST, true );
//			BitsGLFactory.getInstance().markForLoading(this.credits);
            BitsGLFactory.getInstance().loadAllMarked();
        }
    }

    public void onResume() {
    }

    @Override
    public void touchedPressed(int x, int y, int finger) {

    }

    @Override
    public void touchedReleased(int x, int y, int finger) {

    }

    @Override
    public void touchedDragged(int x, int y, int oldX, int oldY, int finger) {

    }

    @Override
    public void touchedButton(String function) {
        if (function.equals(ApoHybridCredits.BACK)) {
            this.onBackButtonPressed();
        }
        this.getGame().playSound(ApoHybridSoundPlayer.SOUND_BUTTON_2);
    }

    public void onBackButtonPressed() {
        this.getGame().setMenu();
    }

    @Override
    public void think(int delta) {

    }

    @Override
    public void render(final BitsGLGraphics g) {
        int addY = 0;
        if (ApoHybridConstants.FREE_VERSION) {
            addY += 50;
        }
        this.getGame().drawString(g, ApoHybridCredits.TITLE, 240, 5 + addY, ApoHybridPanel.title_font);
        this.getGame().drawString(g, ApoHybridCredits.SUB, 240, 50 + addY, ApoHybridPanel.game_font);
        this.getGame().drawString(g, ApoHybridCredits.SUB_2, 240, 65 + addY, ApoHybridPanel.game_font);

        String s = "gameplay is based on";
        this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 100 + addY, ApoHybridPanel.game_font);
        s = "F.O.L.D. by Cosine";
        this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 115 + addY, ApoHybridPanel.game_font);
        s = "and";
        this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 130 + addY, ApoHybridPanel.game_font);
        s = "Blockdude by Brandon Sterner";
        this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 145 + addY, ApoHybridPanel.game_font);

        s = "music by";
        this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 175 + addY, ApoHybridPanel.game_font);
        s = "Eric Skiff, http://ericskiff.com/";
        this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 190 + addY, ApoHybridPanel.game_font);

        s = "thanks to";
        this.getGame().drawString(g, s, (int)(240 - ApoHybridPanel.game_font.getLength(s)/2), 220 + addY, ApoHybridPanel.game_font);
        s = "Florian, Network, Thecoolestnerdguy";
        this.getGame().drawString(g, s, (int)(5), 235 + addY, ApoHybridPanel.game_font);
        s = "Sparky83, Marc, Basti, Clemens";
        this.getGame().drawString(g, s, (int)(5), 250 + addY, ApoHybridPanel.game_font);

//		g.setColor(1f, 1f, 1f, 1f);
//		g.drawImage(this.credits, 200, 220, 80, 80);

        this.getGame().renderButtons(g);
    }
}
//#endif
