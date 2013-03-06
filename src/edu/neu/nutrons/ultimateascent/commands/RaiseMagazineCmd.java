/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOffCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOnCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author NUTRONs
 */
public class RaiseMagazineCmd extends CommandGroup {

    public RaiseMagazineCmd() {
        addSequential(new OOTurnOnCmd(CommandBase.centerer));
        addSequential(new OOTurnOnCmd(CommandBase.magazine));
    }

}
