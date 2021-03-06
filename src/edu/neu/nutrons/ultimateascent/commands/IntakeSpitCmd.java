package edu.neu.nutrons.ultimateascent.commands;

/**
 *
 * @author NUTRONs
 * SPITS INTAKE
 * Reverses intake in case of Frisbee jam.
 */
public class IntakeSpitCmd extends CommandBase {

    public IntakeSpitCmd() {
        requires(intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        intake.spit();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
