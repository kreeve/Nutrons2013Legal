/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOnCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOnCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *5
 * @author NUTRONs
 */
public class ActivateIntakeDropdownCmd extends CommandGroup {

    public ActivateIntakeDropdownCmd() {
        addSequential(new ActivateIntakeCmd());
        addSequential(new OOSetOnCmd(CommandBase.ddRoller));
        addSequential(new OOTurnOnCmd(CommandBase.dropdown));
    }
}
