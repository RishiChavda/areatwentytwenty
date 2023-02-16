package areatwentytwenty;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/** @author Rishi */

/** Abstract class for creation of game levels. */
public abstract class GLevel extends World {
    private Character player;
    /**
     * 
     * @return instance of Character.
     */
    public Character getPlayer() {
        return player;
    }
    /**
     * 
     * @param game instance of Game to populate.
     */
    public void populate(Game game) {
        player = new Character(this);
        player.setPosition(new Vec2(20,0));
        
        Chest chest = new Chest(this);
        chest.setPosition(chestPosition());
        chest.addCollisionListener(new ChestListener(game));
    }

    /**
    * 
    * @return true if player (instance of Character) has collected the total number of coins (int totalCoins).
    */
    public abstract Vec2 startPosition();
    
    /**
    * 
    * @return designates the start position for instance of Character.
    */    
    public abstract Vec2 chestPosition();


    /**
    * 
    * @return designates the position of Chest instance.
    */    
    public abstract boolean isCompleted();

}