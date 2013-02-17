/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOFFCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOFFCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class DectivateShooterCmd extends CommandGroup {

    public DectivateShooterCmd() {
        addSequential(new OOSetOFFCmd(CommandBase.shooter));
        addSequential(new OOTurnOFFCmd(CommandBase.barrel));
        addSequential(new OOTurnOFFCmd(CommandBase.magazine));
    }
}
