/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOffCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOnCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class HumanLoadCmd extends CommandGroup {

    public HumanLoadCmd() {
        //Added set off for shooter because it wasn't there before
        // >_<
        addSequential(new OOSetOffCmd(CommandBase.shooter));
        addSequential(new OOTurnOnCmd(CommandBase.magazine));
    }

}
