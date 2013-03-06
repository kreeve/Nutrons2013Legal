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
 * ACTIVATES SHOOTER
 * Step 1: Deactivate intake
 * Step 2: Turn off centerer so we can move magazine
 * Step 3: Start shooter motor
 * Step 4: Retract motor into barrel before moving
 */
public class ActivateShooterCmd extends CommandGroup {

    public ActivateShooterCmd() {
        addSequential(new DeactivateIntakeCmd());
        addSequential(new OOTurnOnCmd(CommandBase.centerer));
        addSequential(new OOSetOnCmd(CommandBase.shooter));
        addSequential(new OOTurnOnCmd(CommandBase.magazine));
    }
}
