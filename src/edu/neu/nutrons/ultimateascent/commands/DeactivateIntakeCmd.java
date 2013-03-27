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
 * DEACTIVATES INTAKE
 * Step 1: Turn off intake motor
 * Step 2: Lifts drop down
 * Step 3: Turn off drop down motor
 */
public class DeactivateIntakeCmd extends CommandGroup {

    public DeactivateIntakeCmd() {
        addSequential(new OOSetOffCmd(CommandBase.intake));
        addSequential(new OOSetOffCmd(CommandBase.ddRoller));
        addSequential(new OOTurnOffCmd(CommandBase.dropdown));
    }
}
