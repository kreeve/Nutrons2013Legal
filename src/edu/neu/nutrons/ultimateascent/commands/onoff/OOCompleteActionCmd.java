/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands.onoff;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;
import edu.neu.nutrons.ultimateascent.subsystems.OnOffSubsystem;

/**
 *
 * @author NUTRONs
 */
public class OOCompleteActionCmd extends CommandBase {
    private OnOffSubsystem sys;
    private boolean state;
    public OOCompleteActionCmd(OnOffSubsystem sys, boolean state) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.sys = sys;
        this.state = state;
        requires(sys);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        sys.init(state);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return sys.is(state);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
