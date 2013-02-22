
package edu.neu.nutrons.ultimateascent.commands.onoff;

import edu.neu.nutrons.ultimateascent.subsystems.OnOffSubsystem;

/**
 *
 * @author NUTRONs
 */
public class OOTurnOffCmd extends OOTurnCmd {

    public OOTurnOffCmd(OnOffSubsystem sys) {
        super(sys, false);
    }
}
