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
public class OOTurnCmd extends OOSetCmd {
    public OOTurnCmd(OnOffSubsystem sys, boolean state) {
        super(sys, state);
    }

    protected boolean isFinished() {
        return getSys().is(getState());
    }
}
