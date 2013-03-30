package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOffCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 * Lowers the magazine.
 */
public class LowerMagazineCmd extends CommandGroup {

    public LowerMagazineCmd() {
        addSequential(new OOTurnOffCmd(CommandBase.magazine));
    }

}
