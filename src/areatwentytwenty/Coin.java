package areatwentytwenty;
import city.cs.engine.*;
import static java.awt.Color.GREEN;
/** @author Rishi */

/** Coin object (to be collected by instance of Character). */
public class Coin extends DynamicBody{
    private static final Shape shape = new CircleShape(0.5f);
   /**
    * 
    * @param world World instance of which a new instance of Coin will be created in.
    */ 
    public Coin(World world) {
        super(world, shape);
        setFillColor(GREEN);
    }
}
