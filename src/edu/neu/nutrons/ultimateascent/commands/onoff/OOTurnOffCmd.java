
package edu.neu.nutrons.ultimateascent.commands.onoff;

import edu.neu.nutrons.ultimateascent.subsystems.OnOffSubsystem;

/**
 *
 * @author NUTRONs
 * Turns subsystem off until finished or time runs out.
 */
public class OOTurnOffCmd extends OOTurnCmd {

    public OOTurnOffCmd(OnOffSubsystem sys) {
        super(sys, false);
    }
}
