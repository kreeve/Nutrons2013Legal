/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands.drivetrain;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author NUTRONs
 */
public class DriveTimeAtSpeedWiggleCmd extends DriveTimeAtSpeedCmd {
    Timer t = new Timer();
    double frequency = 0;

    public DriveTimeAtSpeedWiggleCmd(double speed, double time, double frequency) {
        super(speed, time);
        this.frequency = frequency;
    }

    public void initialize() {
        super.initialize();
        t.stop();
        t.reset();
        t.start();
    }

    public void execute() {
        dt.driveTW(speed, Math.cos(2*Math.PI*frequency * t.get()));
    }
}
