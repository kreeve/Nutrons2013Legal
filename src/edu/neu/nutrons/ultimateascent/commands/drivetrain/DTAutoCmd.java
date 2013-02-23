/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands.drivetrain;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;

/**
 *
 * @author NUTRONs
 * AUTO DRIVE
 * Drives the robot forwards for a certain amount of time with a certain throttle
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
        dt.driveLR(throttle, throttle); //Drive both sides at same speed
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
