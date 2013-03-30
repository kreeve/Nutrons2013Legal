package edu.neu.nutrons.ultimateascent.commands.drivetrain;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;


/**
 *
 * @author NUTRONs
 */
public class ShiftCmd extends CommandBase {
    boolean high = false;

    public ShiftCmd(boolean high) {
        this.high = high;
        requires(dt);
    }

    protected void initialize() {
        dt.setHighGear(high);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }
    protected void end() {
    }

    protected void interrupted() {
    }

}
