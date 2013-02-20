/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOnCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOnCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class ActivateShooterCmd extends CommandGroup {

    public ActivateShooterCmd() {
        // TODO: Add deactivate intake command. -- ADDED 2/17 9:45pm
        addSequential(new DeactivateIntakeCmd());
        addSequential(new OOTurnOnCmd(CommandBase.centerer));
        addSequential(new OOSetOnCmd(CommandBase.shooter));
        addSequential(new OOTurnOnCmd(CommandBase.magazine));
        addSequential(new OOTurnOnCmd(CommandBase.barrel));
    }
}
