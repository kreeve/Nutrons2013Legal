/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOnCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class ActivateShooterHighCmd extends CommandGroup {

    public ActivateShooterHighCmd() {
        addSequential(new ActivateShooterCmd());
        addSequential(new OOTurnOnCmd(CommandBase.elevator));
    }
}
