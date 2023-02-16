package areatwentytwenty;
import city.cs.engine.*;
import org.jbox2d.common.*;
/**
 * 
 * @author Rishi
 */

/** Player object in game (extends Walker class) */
public class Character extends Walker{
    private static int points;
    private static final Shape character = new CircleShape(1);
    private static final BodyImage characterImage = new BodyImage("data/character.png", 2);
    /**
     * 
     * @param world World instance of which a new Character instance will be created in.
     */
    public Character(World world) {
        super(world, character);
        addImage(characterImage);
        setPosition(new Vec2(20, 0));
        points=0;
    }
    /**
     * 
     * @return instance of Character's points.
     */
    public int getPoints(){
        return points;
    }

    /**
     * Increments the points of the Character instance by 1.
     */
    public void pointsIncrement(){
        points++;
    }   
}