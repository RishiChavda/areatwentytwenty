package areatwentytwenty;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.*;

/** @author Rishi */

/** Controller key listener (extends KeyAdapter) used for controlling instances of Character using the arrow keys. */
public class Controller extends KeyAdapter {
    private static float JUMPING_SPEED = 40;
    private static float WALKING_SPEED = 10;
    
    private Walker body;
    private World world;
/**
 * 
 * @param body The Walker instance that will be controlled.
 */
    public Controller(Walker body){
        this.body = body;
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        else if (code == KeyEvent.VK_UP){
            Vec2 v = body.getLinearVelocity();
            shootArrow(this.body.getWorld());
            if (Math.abs(v.y)<0.01f){body.jump(JUMPING_SPEED);}
        }
        else if (code == KeyEvent.VK_LEFT){body.startWalking(- WALKING_SPEED);}
        else if (code == KeyEvent.VK_RIGHT){body.startWalking(WALKING_SPEED);}
    }

    @Override
    public void keyReleased(KeyEvent e){
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT){body.stopWalking();}
        else if (code == KeyEvent.VK_RIGHT){body.stopWalking();}
    }
    /**
     * 
     * @param body Walker instance.
     */
    public void setBody(Walker body){
        this.body = body;
    }
    /**
     * 
     * @param world World instance of which a new Arrow will be created in.
     */
    public void shootArrow(World world){ // Create/Shoot new arrow and add it to the world which the game is running.
        this.world = world;
        Arrow arrow1 = new Arrow(world);
    }
}