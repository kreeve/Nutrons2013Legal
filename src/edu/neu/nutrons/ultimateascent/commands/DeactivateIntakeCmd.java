/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOffCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOFFCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class DeactivateIntakeCmd extends CommandGroup {

    public DeactivateIntakeCmd() {
        addSequential(new OOSetOffCmd(CommandBase.intake));
        addSequential(new OOSetOffCmd(CommandBase.ddRoller));
        addSequential(new OOTurnOFFCmd(CommandBase.dropdown));
    }
}
