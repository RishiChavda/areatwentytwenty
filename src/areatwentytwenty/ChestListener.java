package areatwentytwenty;

import city.cs.engine.*;
/** @author Rishi */

/** CollisionListener for Chest. */
public class ChestListener implements CollisionListener {
    private Game game;
   /**
    * 
    * @param game Game instance of which the ChestListener will be looking for an event trigger in.
    */
    public ChestListener(Game game){
        this.game = game;
    }
/**
 * 
 * @param e instance of CollisionEvent.
 */
    @Override
    public void collide(CollisionEvent e) {
        Character player = game.getPlayer();
        if (e.getOtherBody() == player && game.isCurrentLevelCompleted()){
            System.out.println("Going to next level...");
            game.goNextLevel();
        }
    }
}