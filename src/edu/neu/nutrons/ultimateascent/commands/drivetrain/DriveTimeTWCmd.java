/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands.drivetrain;

/**
 *
 * @author NUTRONs
 */
public class DriveTimeTWCmd extends DriveTimeAtSpeedCmd {

    // A hack, but whatever. -Ziv
    private static double KP = 1.0/90.0;
    private double wheel = 0;
    public DriveTimeTWCmd(double throttle, double wheel, double time) {
        super(throttle, time);
        this.wheel = wheel;
    }

    public void execute() {
        dt.driveTW(speed, wheel);
    }
}
