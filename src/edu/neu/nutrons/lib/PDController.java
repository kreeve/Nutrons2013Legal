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
public class PDController extends Controller {

    private double kP;
    private double kD;
    private double error;
    private double lastError = 0;
    private double time;
    private double lastTime = 0;
    private Timer t = new Timer();

    public PDController(double kP, double kD) {
        this.kP = kP;
        this.kD = kD;
        t.start();
    }

    public void feed(double in) {
        lastError = error;
        error = getTarget() - in;
        lastTime = time;
        time = t.get();
    }

    public double getOutput() {
        return kP * error - kD * ((error-lastError) / (time-lastTime));
    }
}
