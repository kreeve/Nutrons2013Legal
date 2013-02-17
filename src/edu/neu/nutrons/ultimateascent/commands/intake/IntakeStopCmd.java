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
public class IntakeStopCmd extends CommandGroup {
    public IntakeStopCmd() {
        addSequential(new OOSetOFFCmd(CommandBase.intake));
    }
}
