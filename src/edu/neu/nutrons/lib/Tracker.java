/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.lib;

/**
 *
 * @author NUTRONs
 */
public class Tracker {

    private double x;
    private double y;
    private int previousLeftEnc;
    private int previousRightEnc;
    private final double FEET_PER_TICK = 1.0/256.0; //TODO: measure/calculate this for real!!!!

    public Tracker(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void feed(double angle, int leftEnc, int rightEnc) {
        double speed = FEET_PER_TICK * 0.5 * ((leftEnc - previousLeftEnc) + (rightEnc - previousRightEnc));
        x += Math.cos(angle) * speed;
        y += Math.sin(angle) * speed;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
