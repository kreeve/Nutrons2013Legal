/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOffCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class ActivateShooterLowCmd extends CommandGroup {

    public ActivateShooterLowCmd() {
        addSequential(new ActivateShooterCmd());
        addSequential(new OOTurnOffCmd(CommandBase.elevator));
    }
}
