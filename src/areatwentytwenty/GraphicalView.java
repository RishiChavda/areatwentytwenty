package areatwentytwenty;

import city.cs.engine.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
/** @author Rishi */

/** UserView subclass with background image and score display. */
public class GraphicalView extends UserView{
    private Image gameBG;
    private Character player;
    /**
     * @param world World instance which all objects are added to/displayed in.
     * @param player Character instance which allows a single Character to carry a score throughout a level.
     * @param width Width of the window/panel in view.
     * @param height Height of the window/panel in view.
     */
    public GraphicalView(World world, Character player, int width, int height) {
        super(world, width, height);
        this.player=player;
    }
    /**
    * 
    * @param g instance of Graphics2D object.
    */  
    @Override
    protected void paintBackground(Graphics2D g){
        gameBG = new ImageIcon("data/paper.png").getImage();
        g.drawImage(gameBG, 0, 0, this);
    }
    /**
    * 
    * @param g instance of Graphics2D object.
    */
    @Override
    protected void paintForeground(Graphics2D g) {
        g.setColor(Color.red);
        g.drawString("Score: "+player.getPoints(),100,20);
    }
}