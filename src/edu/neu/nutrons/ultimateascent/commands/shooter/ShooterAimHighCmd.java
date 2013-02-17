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
public class ShooterAimHighCmd extends CommandGroup {
    public ShooterAimHighCmd()
    {
        addSequential(new OOSetONCmd(CommandBase.shooter));
        addSequential(new OOSetOFFCmd(CommandBase.magazine));
        addSequential(new WaitCommand(3.5));
        addSequential(new OOSetOFFCmd(CommandBase.barrel));
        addSequential(new OOSetONCmd(CommandBase.elevator));

    }
}
