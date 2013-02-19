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
public class DeactivateShooterCmd extends CommandGroup {

    public DeactivateShooterCmd() {
        addSequential(new OOSetOffCmd(CommandBase.shooter));
        addSequential(new OOTurnOFFCmd(CommandBase.barrel));
        addSequential(new OOTurnOFFCmd(CommandBase.magazine));
        addSequential(new OOTurnOFFCmd(CommandBase.elevator));
    }
}
