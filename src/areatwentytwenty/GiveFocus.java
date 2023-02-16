package areatwentytwenty;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/** A mouse listener (extends MouseAdapter) gives the focus of keystrokes to a specified component of the game window. */
public class GiveFocus extends MouseAdapter {
    private Component target;
    
    /** @param target the component to be given the focus when the mouse is clicked). */
    public GiveFocus(Component target) {
        this.target = target;
    }
    
    /** @param e name of the mouse event. */
    @Override
    public void mouseEntered(MouseEvent e) {
        target.requestFocus();
    }
}
