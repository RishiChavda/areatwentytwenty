package areatwentytwenty;

import city.cs.engine.DebugViewer;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/** @author Rishi */

/** Game process with all subcomponent initialisation. */
public class Game {
    private GLevel world;
    private GraphicalView gView;
    private int levelNum;
    private Controller controller;
    //private Character player;
    /**
     * Game creation method
     */
    public Game() {
        levelNum = 1;
        world = new Level1();
        world.populate(this);
        world.setGravity(30);
        Character tempCharacter = world.getPlayer();
        
        gView = new GraphicalView(world, world.getPlayer(), 800, 600);
        JFrame frame = new JFrame("AreaTwentyTwenty");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.add(gView);

        MenuPanel menu1 = new MenuPanel(world);
        frame.add(menu1, BorderLayout.SOUTH);

        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.requestFocus();
        gView.addMouseListener(new GiveFocus(frame));
        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);
        world.addStepListener(new PlayerTracker(gView, world.getPlayer()));
        world.start();
        gView.setGridResolution(0);
        JFrame dView = new DebugViewer(world, 800, 600);
        dView.setResizable(true);
    }
/**
 * 
 * @return Character instance in World instance.
 */
    public Character getPlayer() {
        return world.getPlayer();
    }

    /**
     * 
     * @return if the current level has been completed (true/false)
     */

    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /**
     * Empty method to stop the current level/world and advance the player on to the next level in world.
     */
    public void goNextLevel() {
        world.stop();
        if(levelNum==4){
            System.out.println("GAME COMPLETED!");
            System.exit(0);
        }
        else{
            levelNum++;
            if(levelNum==2){world = new Level2();}
            else if(levelNum==3){world = new Level3();}
            else if(levelNum==4){world = new Level4();} 
            world.populate(this);
            world.setGravity(30);
            controller.setBody(world.getPlayer());
            gView.setWorld(world);
            JFrame frame = new JFrame("AreaTwentyTwenty");
            frame.addKeyListener(controller);
            world.addStepListener(new PlayerTracker(gView, world.getPlayer()));
            world.start();
        }
    }
/**
 * 
 * @param args All instructions passed in to the game world.
 */
    public static void main(String[] args) {
        new Game();
    }
}
