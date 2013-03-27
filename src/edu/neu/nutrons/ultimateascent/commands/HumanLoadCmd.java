/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.Constants;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOffCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOffCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOnCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class HumanLoadCmd extends CommandGroup {

    public HumanLoadCmd() {
        addSequential(new OOSetOffCmd(CommandBase.shooter));
        addSequential(new OOTurnOnCmd(CommandBase.magazine));
        addSequential(new OOTurnOffCmd(CommandBase.elevator));
    }

}
