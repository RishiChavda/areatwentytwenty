package areatwentytwenty;

import city.cs.engine.*;

/** @author Rishi */

/** Type of SolidFixture which is harmful to instances of Character. */
public class DeadlySolidFixture extends SolidFixture {
    /**
     * 
     * @param body Complete body of which the DeadlySolidFixture instance will be bound to.
     * @param shape Shape of which the DeadlySolidFixture instance will be.
     */
    public DeadlySolidFixture(Body body, Shape shape) {
        super(body, shape);
    }
}