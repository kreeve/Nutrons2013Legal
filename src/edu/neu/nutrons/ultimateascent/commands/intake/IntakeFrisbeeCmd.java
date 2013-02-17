/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands.intake;

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
public class IntakeFrisbeeCmd extends CommandGroup {
    public IntakeFrisbeeCmd() {
        addSequential(new OOSetOFFCmd(CommandBase.shooter));
        addSequential(new OOSetONCmd(CommandBase.barrel));
        addSequential(new WaitCommand(0.5));
        addSequential(new OOSetONCmd(CommandBase.magazine));

        addSequential(new OOSetOFFCmd(CommandBase.elevator));

        addSequential(new OOSetONCmd(CommandBase.intake));
    }
}
