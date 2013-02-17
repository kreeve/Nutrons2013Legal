
package edu.neu.nutrons.ultimateascent.commands.onoff;

import edu.neu.nutrons.ultimateascent.subsystems.OnOffSubsystem;

/**
 *
 * @author NUTRONs
 */
public class OOTurnONCmd extends OOCompleteActionCmd {

    public OOTurnONCmd(OnOffSubsystem sys) {
        super(sys, true);
    }
}
