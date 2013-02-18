/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;
import edu.neu.nutrons.ultimateascent.commands.onoff.*;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author NUTRONs
 */
public class ShooterFireCmd extends CommandGroup {
    public ShooterFireCmd() {
        addSequential(new OOTurnONCmd(CommandBase.bolt));
        addSequential(new OOTurnOFFCmd(CommandBase.bolt));
    }
}
