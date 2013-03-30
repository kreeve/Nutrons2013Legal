package edu.neu.nutrons.ultimateascent.commands.drivetrain;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;
import edu.wpi.first.wpilibj.DriverStation;

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
        if (DriverStation.getInstance().isAutonomous())
            return;
        dt.driveLR(oi.getDriveLeft(),oi.getDriveRight());
        dt.setHighGear(oi.getHighGearButton());
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
