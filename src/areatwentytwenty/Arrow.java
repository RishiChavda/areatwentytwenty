package areatwentytwenty;

import city.cs.engine.*;
import java.util.*;
import org.jbox2d.common.*;

/**
 * 
 * @author Rishi
 */

/** Arrow extends DynamicBody which creates a Arrow object in the game. */
public class Arrow extends DynamicBody{
    /**
    @param player Character for adding a CollisionListener connecting Arrow and Character
    */
    private Character player; // Character type for adding a CollisionListener.
    
    
    private Random posX; // Random number generator for X position of new arrow.
    private Random posY; // Random number generator for Y position of new arrow.
    private int newPosX; // Random positions for new arrow object.
    private int newPosY; // Random positions for new arrow object.
    
    /**
     * 
     * @param w Creates new instance of Arrow in the selected World (w).
     */
    public Arrow(World w){
        super(w); // Declaring the super class for the new object (when created). 
        Shape deadlyShape = new PolygonShape(-0.148f,-0.059f, 0.152f,-0.057f, 0.011f,-0.498f, -0.148f,-0.077f); // PolygonShape parameters for Arrow (deadly part).
        Fixture deadlyFixture = new DeadlySolidFixture(this, deadlyShape); // Fixture parameters for Arrow (deadly part).
        
        Shape safeShape = new PolygonShape(-0.148f,-0.062f, -0.104f,0.5f, 0.108f,0.496f, 0.143f,-0.064f); // PolygonShape parameters for arrow head (safe part).
        Fixture safeFixture = new SolidFixture(this, safeShape); // Fixture parameters for Arrow (safe part).
        
        addImage(new BodyImage("data/arrow.png",1.5f)); // Adding an image overlay for arrow.
        
        posX = new Random(); // Creating a new random number for X position.
        int newPosX = posX.nextInt(20 - -21); // Setting limits for the next integer returned from the random number class
        
        posY = new Random(); // Creating a new random number for Y position
        int newPosY = posY.nextInt(150); // Setting limits for the next integer returned from the random number class
        
        this.setPosition(new Vec2(newPosX,newPosY)); // Set position for new arrow shape class.
        
        this.addCollisionListener(new ArrowHit(player)); // CollisionListener to sense collisions between arrowhead (DeadlySolidFixture side) and player.

    }
}