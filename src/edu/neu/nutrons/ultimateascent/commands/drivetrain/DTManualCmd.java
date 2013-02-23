
package edu.neu.nutrons.ultimateascent.commands.drivetrain;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;

/**
 *
 * @author NUTRONs
 * MANUAL DRIVE
 * Control the drive train using driver station joysticks
 * Currently uses tank drive
 */
public class DTManualCmd extends CommandBase {

    public DTManualCmd() {
        requires(dt);
    }

    protected void initialize() {
    }

    protected void execute() {
        dt.driveLR(oi.getDriveLeft(),oi.getDriveRight());
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
