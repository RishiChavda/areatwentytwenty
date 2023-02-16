/** @game AreaTwentyTwenty game package by @author Rishi Chavda for IN1007 Programming in Java Coursework */
package areatwentytwenty;

import city.cs.engine.*;
import areatwentytwenty.Character;
import areatwentytwenty.DeadlySolidFixture;

/** @author RishiChavda */

/** CollisionListener between Arrow and Character */
public class ArrowHit implements CollisionListener{
    private Character player; // Character parameter/initialization for ArrowHit creation class.
    
    /** Characters lives (integer) in each level of the game.  */
    public int lives = 10;
    
     /** @param player Creates new instance of ArrowHit (implements CollisionListener) between Arrow and Character. */
    public ArrowHit(Character player){ // Class object creation
        this.player = player;
    }
    
    public void collide(CollisionEvent e){
            if (e.getReportingBody() instanceof Arrow){
            Fixture deadlyFixture = e.getReportingFixture();
            if(deadlyFixture instanceof DeadlySolidFixture){
            setLives(getLives()-1);
            System.out.println("Player got hit by arrow! "+getLives()+" lives left.");
            }
        }
    }

    public int getLives(){ // Returns the number of lives the player has.
        return lives;
    }

    public void setLives(int lives){ // Method to set the number of lives.
        this.lives = lives;
    }
}