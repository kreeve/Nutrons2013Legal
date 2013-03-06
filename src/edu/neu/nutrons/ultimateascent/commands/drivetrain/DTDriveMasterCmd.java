/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands.drivetrain;

import edu.neu.nutrons.ultimateascent.DriveMaster;
import edu.neu.nutrons.ultimateascent.commands.CommandBase;

/**
 *
 * @author NUTRONs
 */
public class DTDriveMasterCmd extends CommandBase {

    private DriveMaster driveMaster = new DriveMaster();

    public DTDriveMasterCmd(double x, double y, double maxSpeed) {
        requires(dt);
        driveMaster.setTarget(x, y, maxSpeed);
    }

    protected void initialize() {
    }

    protected void execute() {
        // Uses one encoder for left and right.
        driveMaster.feed(dt.getGyroValue(), dt.getEncoderValue(), dt.getEncoderValue());
        dt.driveTW(driveMaster.getThrottle(), driveMaster.getWheel());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
