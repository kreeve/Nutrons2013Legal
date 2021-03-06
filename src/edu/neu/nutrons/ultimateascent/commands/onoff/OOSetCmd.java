package edu.neu.nutrons.ultimateascent.commands.onoff;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;
import edu.neu.nutrons.ultimateascent.subsystems.OnOffSubsystem;

/**
 *
 * @author NUTRONs
 * Sets subsystem to either on or off depending on what is passed in for state.
 */
public class OOSetCmd extends CommandBase {

    private OnOffSubsystem sys;
    private boolean state;

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
        sys.disableControlLoop();
        sys.init(state);
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
