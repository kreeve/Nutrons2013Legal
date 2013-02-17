/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands.intake;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOFFCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class DDIntakeStopCmd extends CommandGroup {
    public DDIntakeStopCmd() {
        addSequential(new OOSetOFFCmd(CommandBase.ddRoller));
        addSequential(new OOSetOFFCmd(CommandBase.intake));
        addSequential(new OOSetOFFCmd(CommandBase.dropdown));
    }
}
