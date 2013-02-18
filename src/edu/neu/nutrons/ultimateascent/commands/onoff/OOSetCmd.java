package edu.neu.nutrons.ultimateascent.commands.onoff;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;
import edu.neu.nutrons.ultimateascent.subsystems.OnOffSubsystem;

/**
 *
 * @author NUTRONs
 */
public class OOSetCmd extends CommandBase {

    private OnOffSubsystem sys;
    private boolean state;
    private boolean legal = false;

    public OOSetCmd(OnOffSubsystem sys, boolean state) {
        this.sys = sys;
        this.state = state;
        requires(sys);
    }

    protected OnOffSubsystem getSys() {
        return sys;
    }

    protected boolean getState() {
        return state;
    }

    protected void initialize() {
        legal = CommandBase.law.legalToSet(sys, state);
        if(legal) {
            sys.init(state);
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
