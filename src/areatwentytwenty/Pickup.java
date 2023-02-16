package areatwentytwenty;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/** CollisionListener for Coin objects and instances of Character in the game. */
public class Pickup implements CollisionListener {
    private Character player;
    private static SoundClip coinCollect;
    
    static {
      try {
         coinCollect = new SoundClip("data/coincollect.wav");
         System.out.println("Loading orange sound");
       } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
         System.out.println(e);
       }       
    }
    
    /**
     * 
     * @param player gives the Character instance a CollisionListener to allow Characters to pickup coins.
     */
    public Pickup(Character player) {
        this.player = player;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == player) {
            player.pointsIncrement();
            coinCollect.play();
            e.getReportingBody().destroy();
            System.out.println(this.player.getPoints()+" points");
        }
    }
    
}
