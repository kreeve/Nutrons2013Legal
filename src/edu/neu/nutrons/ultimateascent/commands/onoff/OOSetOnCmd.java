package edu.neu.nutrons.ultimateascent.commands.onoff;

import edu.neu.nutrons.ultimateascent.subsystems.OnOffSubsystem;

/**
 *
 * @author NUTRONs
 * Sets subsystem to on
 */
public class OOSetOnCmd extends OOSetCmd {

    public OOSetOnCmd(OnOffSubsystem sys) {
        super(sys, true);
    }
}
