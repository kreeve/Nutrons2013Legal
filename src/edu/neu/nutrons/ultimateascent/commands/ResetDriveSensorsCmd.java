package edu.neu.nutrons.ultimateascent.commands;

/**
 *
 * @author NUTRONs
 * Resets gyro and encoders.
 */
public class ResetDriveSensorsCmd extends CommandBase {

    public ResetDriveSensorsCmd() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        dt.resetGyro();
        dt.resetEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true; // Finish immediately!
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
