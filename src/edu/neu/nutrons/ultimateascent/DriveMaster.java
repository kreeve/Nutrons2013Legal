/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent;

import com.sun.squawk.util.MathUtils;
import edu.neu.nutrons.lib.Controller;
import edu.neu.nutrons.lib.PDController;
import edu.neu.nutrons.lib.Tracker;
import edu.neu.nutrons.lib.Utils;

/**
 *
 * @author NUTRONs
 */
public class DriveMaster {

    private double targetX;
    private double targetY;
    private double maxSpeed;
    private Tracker tracker = new Tracker(0,0);
    private Controller throttleController;// = new PDController(0,0);
    private Controller wheelController;// = new PDController(0,0);

    public void feed(double angle, int leftEnc, int rightEnc) {
        tracker.feed(angle, leftEnc, rightEnc);
        double dist = Utils.distance(targetX, targetY, tracker.getX(), tracker.getY());
        // If maxSpeed is negative, go backwards!
        if(maxSpeed < 0) {
            dist *= -1;
        }
        throttleController.feed(dist);
        wheelController.feed(180.0/Math.PI*MathUtils.atan2(targetY - tracker.getY(), targetX - tracker.getX()));
    }

    public void setTarget(double x, double y, double maxSpeed) {
        this.targetX = x;
        this.targetY = y;
        this.maxSpeed = maxSpeed;
    }

    public double getThrottle() {
        return Utils.limit(throttleController.getOutput(), -maxSpeed, maxSpeed);
    }

    public double getWheel() {
        return Utils.limit(wheelController.getOutput(), -1.0, 1.0);
    }
}
