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
 * DEACTIVATE SHOOTER
 * Step 1: Turn off shooter
 * Step 2: Lower barrel
 * Step 3: Lower magazine
 * Step 4: Lower elevator (just in case)
 */
public class DeactivateShooterCmd extends CommandGroup {

    public DeactivateShooterCmd() {
        addSequential(new OOSetOffCmd(CommandBase.shooter));
        addSequential(new OOTurnOffCmd(CommandBase.magazine));
        addSequential(new OOTurnOffCmd(CommandBase.elevator));
    }
}
