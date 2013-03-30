package edu.neu.nutrons.ultimateascent.commands.onoff;

import edu.neu.nutrons.ultimateascent.subsystems.OnOffSubsystem;

/**
 *
 * @author NUTRONs
 * Sets subsystem to on or off and doesn't finish until the subsystem
 * reports it is in the desired state or time runs out.
 */
public class OOTurnCmd extends OOSetCmd {
    public OOTurnCmd(OnOffSubsystem sys, boolean state) {
        super(sys, state);
    }

    protected boolean isFinished() {
        return getSys().is(getState());
    }
}
