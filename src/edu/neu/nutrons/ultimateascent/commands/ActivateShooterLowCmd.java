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
 * ACTIVATE SHOOTER LOW
 * Step 1: Start shooter
 * Step 2: Set elevator to low position just in case
 */
public class ActivateShooterLowCmd extends CommandGroup {

    public ActivateShooterLowCmd() {
        addSequential(new ActivateShooterCmd());
        addSequential(new OOSetOffCmd(CommandBase.elevator));
    }
}
