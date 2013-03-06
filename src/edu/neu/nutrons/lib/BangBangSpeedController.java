/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.lib;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author NUTRONs
 */
public class BangBangSpeedController extends Controller {

    private double speed;
    private double time;
    private double lastTime = 0;
    private Timer t = new Timer();

    public BangBangSpeedController() {
        t.start();
    }

    public void feed(double in) {
        lastTime = time;
        time = t.get();
        speed = in / (time - lastTime);
    }

    public double getOutput() {
        if(getTarget() < speed) {
            return 0.0;
        }
        else {
            return 1.0;
        }
    }
}
