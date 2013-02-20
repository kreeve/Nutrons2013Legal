/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOnCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOffCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOnCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class ActivateIntakeCmd extends CommandGroup {

    public ActivateIntakeCmd() {
        // This should start intake without having to start shooter.
        addSequential(new DeactivateShooterCmd());
        addSequential(new OOTurnOnCmd(CommandBase.centerer));
        addSequential(new OOSetOnCmd(CommandBase.intake));
    }
}
