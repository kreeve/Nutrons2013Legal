
package edu.neu.nutrons.ultimateascent.commands.onoff;

import edu.neu.nutrons.ultimateascent.subsystems.OnOffSubsystem;

/**
 *
 * @author NUTRONs
 */
public class OOTurnOnCmd extends OOTurnCmd {

    public OOTurnOnCmd(OnOffSubsystem sys) {
        super(sys, true);
    }
}
