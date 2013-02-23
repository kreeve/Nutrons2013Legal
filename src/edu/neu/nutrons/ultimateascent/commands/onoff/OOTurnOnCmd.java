
package edu.neu.nutrons.ultimateascent.commands.onoff;

import edu.neu.nutrons.ultimateascent.subsystems.OnOffSubsystem;

/**
 *
 * @author NUTRONs
 * Turns subsystem on until finished or time runs out.
 */
public class OOTurnOnCmd extends OOTurnCmd {

    public OOTurnOnCmd(OnOffSubsystem sys) {
        super(sys, true);
    }
}
