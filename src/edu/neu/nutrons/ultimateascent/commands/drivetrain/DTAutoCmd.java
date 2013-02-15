/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands.drivetrain;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;

/**
 *
 * @author NUTRONs
 */
public class DTAutoCmd extends CommandBase {

    private double throttle;

    public DTAutoCmd(double time, double throttle) {
        this.throttle = throttle;
        setTimeout(time);
        requires(dt);
    }

    protected void initialize() {
    }

    protected void execute() {
        dt.driveTW(throttle, 0);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        dt.stop();
    }

    protected void interrupted() {
        end();
    }

}
