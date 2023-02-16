package areatwentytwenty;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.*;

/** @author Rishi */

/** CollisionListener for timed Meteor objects. */
public class MeteorHit implements CollisionListener{
    private Character player;
    private static SoundClip meteorHit;
    static {
      try{
          meteorHit = new SoundClip("data/meteorhit.wav");
       } catch(UnsupportedAudioFileException|IOException|LineUnavailableException e){
           System.out.println(e);
       }       
    }
    /**
     * 
     * @param player gives a Character instance for the CollisionListener to play a SoundClip when Characters touch a meteor object.
     */
    public MeteorHit(Character player){
        this.player = player;
    }

    /** @param e CollisionEvent which can be checked */
    public void collide(CollisionEvent e){
        if (e.getOtherBody() == player) {
        System.out.println("Meteor hit player");
        meteorHit.play();
        }
    }
}