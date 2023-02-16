package areatwentytwenty;

import city.cs.engine.*;
/**
 * 
 * @author Rishi
 */

/** Chest object (the game's aim is to reach this after collecting all of the coins). */
public class Chest extends DynamicBody {
    /**
     * 
     * @param world World instance of which a new Chest instance will be created in.
     */
    public Chest(World world) {
        super(world, new BoxShape(2.5f, 2.3f));
        addImage(new BodyImage("data/chest.png",5));
    }
}