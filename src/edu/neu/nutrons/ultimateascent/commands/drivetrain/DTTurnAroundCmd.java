package edu.neu.nutrons.ultimateascent.commands.drivetrain;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;

/**
 *
 * @author NUTRONs
 */
public class DTTurnAroundCmd extends CommandBase {

    double initialAngle;
    double targetAngle;

    public DTTurnAroundCmd() {
        requires(dt);
    }

    protected void initialize() {
        initialAngle = dt.getGyroValue();
        targetAngle = initialAngle + 180;
    }

    protected void execute() {
        dt.driveLR(1, -1);
    }

    protected boolean isFinished() {
        return (Math.abs(dt.getGyroValue() - targetAngle) <= 10);
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
