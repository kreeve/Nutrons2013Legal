/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * ACTIVATES THE INTAKE
 * Step 1: Deactivate the shooter so we aren't shooting
 * Step 2: Pull in the centerer to allow frisbees to come in
 * Step 3: Turn on the intake rollers
 */
package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOnCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOffCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOnCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 * ACTIVATES INTAKE
 * Step 1: Deactivates shooter
 * Step 2: Pulls in centerer so we can intake
 * Step 3: Turns on intake
 */
public class ActivateIntakeCmd extends CommandGroup {

    public ActivateIntakeCmd() {
        // This should start intake without having to start shooter.
        addSequential(new DeactivateShooterCmd());
        addSequential(new OOSetOnCmd(CommandBase.intake));
    }
}
