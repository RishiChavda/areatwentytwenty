package areatwentytwenty;

import city.cs.engine.*;
import static java.awt.Color.BLACK;
import org.jbox2d.common.Vec2;
import city.cs.engine.*;
import java.util.Random;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jbox2d.common.Vec2;

/** @author Rishi */

/** Class for the third level extends GLevel attributes/methods and implements ActionListener class (from Timer library). */
public class Level3 extends GLevel implements ActionListener{
    private int totalCoins = 5;
    private int ni=0;
    private int newHeight;
    private Timer metTimer;
    private int numOfMeteors=5;
    private int metCount=0;

/**
 * 
 * @param game gives Game instance to add objects to.
 */
    @Override
    public void populate(Game game) {
        super.populate(game);

        { // Created a black coloured static-body box shape for the ground/bottom level of which all DynamicBody objects fall on to.
            Shape shape = new BoxShape(20,45);
            Body ground = new StaticBody(this, shape);
            ground.setPosition(new Vec2(20,-50));
            ground.setFillColor(BLACK);
            ground.setLineColor(BLACK);
        }

        { // Created a static body box shape for the left barrier/wall to prevent players from falling off of the edge.
            Shape barrier1 = new BoxShape(20,1000);
            Body leftBarrier = new StaticBody(this, barrier1);
            leftBarrier.setPosition(new Vec2(-20,-14));
            leftBarrier.setFillColor(BLACK);
            leftBarrier.setLineColor(BLACK);
        }
        { // Created a static body box shape for the right barrier/wall to prevent players from falling off of the edge.
            Shape barrier2 = new BoxShape(20,1000);
            Body rightBarrier = new StaticBody(this, barrier2);
            rightBarrier.setPosition(new Vec2(60,-14));
            rightBarrier.setFillColor(BLACK);
            rightBarrier.setLineColor(BLACK);
        }
        newHeight=5;
        while(ni<10){
            Platform platform1 = new Platform(this.getPlayer().getWorld());
            platform1.setPosition(new Vec2(10,newHeight));
            Platform platform2 = new Platform(this.getPlayer().getWorld());
            platform2.setPosition(new Vec2(30,newHeight));
            ni++;
            newHeight=newHeight+10;
        }
        {
            Shape finalStage = new BoxShape(10,2);
            Body finalLevel = new StaticBody(this, finalStage);
            //finalLevel.addImage();
            finalLevel.setPosition(new Vec2(21,120));
        }

        {
        for(int i=0; i<totalCoins; i++){
            Body coin1 = new Coin(this);
            coin1.setPosition(new Vec2(2,120));
            coin1.setAngleDegrees(50);
            coin1.addCollisionListener(new Pickup(getPlayer()));
        }
        }

        
        metTimer = new Timer(1000, this);
        metTimer.setInitialDelay(3000);
        metTimer.start();
    }
    
        public void actionPerformed(ActionEvent ae){
        if(metCount<numOfMeteors){
        {
        Shape ballShape = new CircleShape(2);    
        Body ballBody = new DynamicBody(this,ballShape);
        ballBody.setFillColor(BLACK);
        Random posX = new Random();
        int newPosX = posX.nextInt(20 - -21);
        Random posY = new Random();
        int newPosY = posY.nextInt(150);
        ballBody.setPosition(new Vec2(newPosX,newPosY));
        ballBody.addImage(new BodyImage("data/meteor.png", 4.5f));
        ballBody.addCollisionListener(new MeteorHit(getPlayer()));
        }
        System.out.println("Created meteor");
        metCount++;
        }
    }

    /**
     * 
     * @return true if player (instance of Character) has collected the total number of coins (int totalCoins).
     */
    @Override
    public boolean isCompleted() {
        return getPlayer().getPoints()==totalCoins;
    }

    /**
     * 
     * @return designates the start position for instance of Character.
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(2,-10);
    }    
/**
 * 
 * @return designates the position of Chest instance.
 */
    @Override
    public Vec2 chestPosition() {
       return new Vec2(21,130);
    }
}