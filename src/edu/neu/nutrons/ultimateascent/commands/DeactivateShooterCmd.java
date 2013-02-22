/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOffCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOffCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class DeactivateShooterCmd extends CommandGroup {

    public DeactivateShooterCmd() {
        addSequential(new OOSetOffCmd(CommandBase.shooter));
        addSequential(new OOTurnOffCmd(CommandBase.barrel));
        addSequential(new OOTurnOffCmd(CommandBase.magazine));
        addSequential(new OOTurnOffCmd(CommandBase.elevator));
    }
}
