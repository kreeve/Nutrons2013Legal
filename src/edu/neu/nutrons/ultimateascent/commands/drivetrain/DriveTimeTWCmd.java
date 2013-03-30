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
        requires(dt);
    }

    public void execute() {
        dt.driveTW(speed, wheel);
    }
}
