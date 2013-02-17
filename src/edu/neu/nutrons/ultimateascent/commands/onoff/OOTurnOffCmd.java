
package edu.neu.nutrons.ultimateascent.commands.onoff;

import edu.neu.nutrons.ultimateascent.subsystems.OnOffSubsystem;

/**
 *
 * @author NUTRONs
 */
public class OOTurnOFFCmd extends OOCompleteActionCmd {

    public OOTurnOFFCmd(OnOffSubsystem sys) {
        super(sys, false);
    }
}
