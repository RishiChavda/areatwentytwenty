package areatwentytwenty;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

// @author RishiChavda

/** PlayerTracker used to keep centre focus the character around the game screen. */
public class PlayerTracker implements StepListener {
    private WorldView view;
    private Body body;
    /**
     * @param view The view of the world; what portion of the game screen is displayed.
     * @param body The body of which the PlayerTracker is focusing on.
     */
    public PlayerTracker(WorldView view, Body body) {
        this.view = view;
        this.body = body;
    }

    /** @param e Instance of StepEvent (created every step the Character makes). */
    public void preStep(StepEvent e){view.setCentre(new Vec2(body.getPosition()));}

    /** @param e Instance of StepEvent (created every step the Character makes). */
    public void postStep(StepEvent e){view.setCentre(new Vec2(body.getPosition()));}
}