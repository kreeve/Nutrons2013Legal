
package edu.neu.nutrons.ultimateascent.commands.drivetrain;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;

/**
 *
 * @author NUTRONs
 */
public class DTManualCmd extends CommandBase {

    public DTManualCmd() {
        requires(dt);
    }

    protected void initialize() {
    }

    protected void execute() {
        // TODO: make the drive train go!
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
        end();
    }
}
