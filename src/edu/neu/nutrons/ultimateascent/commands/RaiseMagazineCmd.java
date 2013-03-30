package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOnCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 * Raises the magazine.
 */
public class RaiseMagazineCmd extends CommandGroup {

    public RaiseMagazineCmd() {
        addSequential(new OOTurnOnCmd(CommandBase.magazine));
    }

}
