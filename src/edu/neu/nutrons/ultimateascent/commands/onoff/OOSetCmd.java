package edu.neu.nutrons.ultimateascent.commands.onoff;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;
import edu.neu.nutrons.ultimateascent.subsystems.OnOffSubsystem;

/**
 *
 * @author NUTRONs
 */
public class OOSetCmd extends CommandBase {

    private OnOffSubsystem sys;
    private boolean on;
    private boolean legal = false;

    public OOSetCmd(OnOffSubsystem sys, boolean on) {
        this.sys = sys;
        this.on = on;
        requires(this.sys);
    }

    protected void initialize() {
        legal = CommandBase.law.legalToSet(sys, on);
        if(legal) {
            sys.init(on);
        }
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        // Intentionally always true; this sets the state, then finishes.
        return true;
    }

    protected void end() {
        // Intentionally empty.
    }

    protected void interrupted() {
        // End normally by default (and end() probably does nothing).
        end();
    }
}
