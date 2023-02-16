package areatwentytwenty;
import city.cs.engine.*;
import static java.awt.Color.GREEN;
import java.util.Random;
import org.jbox2d.common.Vec2;
/** @author Rishi */

/** Static Platform objects which the user can jump/land on. */
public class Platform extends StaticBody{
private static final Shape platform = new BoxShape(2,0.5f);

/** @param world Gives the World object that the Platform will be created/displayed in. */
    public Platform(World world) {
        super(world, platform);
        addImage(new BodyImage("data/platform.png"));
        Random posX = new Random();
        int newPosX = posX.nextInt(20 - -21);
        Random posY = new Random();
        int newPosY = posY.nextInt(100);
        this.setPosition(new Vec2(newPosX,newPosY));
    }
}