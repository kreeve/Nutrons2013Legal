/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands.drivetrain;

/**
 *
 * @author NUTRONs
 */
public class DriveTimeAtSpeedAlignedCmd extends DriveTimeAtSpeedCmd {

    // A hack, but whatever. -Ziv
    private static double KP = 1.0/90.0;
    private double heading = 0;
    public DriveTimeAtSpeedAlignedCmd(double speed, double heading, double time) {
        super(speed, time);
        this.heading = heading;
        requires(dt);
    }

    public void execute() {
        dt.driveTW(speed, KP * (heading - dt.getGyroValue()));
    }
}
