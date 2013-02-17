/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands.intake;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOCompleteActionCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOFFCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetONCmd;
import edu.neu.nutrons.ultimateascent.subsystems.OnOffSubsystem;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author NUTRONs
 */
public class DDIntakeCmd extends CommandGroup{
    private OOCompleteActionCmd mag = new OOCompleteActionCmd(CommandBase.barrel, true);

    public DDIntakeCmd()
    {
        // addSequential(new OOCompleteActionCmd(CommandBase.elevator, false));
        addSequential(new OOSetOFFCmd(CommandBase.shooter));
        addSequential(new OOSetONCmd(CommandBase.barrel));
        addSequential(new OOSetOFFCmd(CommandBase.elevator));
        addSequential(new WaitCommand(0.5));
        addSequential(new OOSetONCmd(CommandBase.magazine));
        addSequential(new OOSetONCmd(CommandBase.dropdown));
        addSequential(new OOSetONCmd(CommandBase.intake));
        addSequential(new OOSetONCmd(CommandBase.ddRoller));
    }
}
