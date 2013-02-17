
package edu.neu.nutrons.ultimateascent.commands.drivetrain;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;

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
            //dt.driveTW(oi.getDriveThrottle(), oi.getDriveWheel());
        dt.driveLR(oi.getDriveThrottle(),oi.getDriveWheel());
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
