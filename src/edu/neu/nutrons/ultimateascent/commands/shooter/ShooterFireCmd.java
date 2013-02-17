/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands.shooter;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOCompleteActionCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOFFCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetONCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author NUTRONs
 */
public class ShooterFireCmd extends CommandGroup {
    public ShooterFireCmd() {
        addSequential(new OOSetONCmd(CommandBase.bolt));
        addSequential(new WaitCommand(0.25));
        addSequential(new OOSetOFFCmd(CommandBase.bolt));
    }
}
