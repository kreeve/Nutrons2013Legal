/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOnCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOffCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOnCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 * ACTIVATE DROPDOWN INTAKE
 * Step 1: Activate Intake
 * Step 2: Run roller motor
 * Step 3: Drop down roller
 */
public class ActivateIntakeDropdownCmd extends CommandGroup {

    public ActivateIntakeDropdownCmd() {
        addSequential(new ActivateIntakeCmd());
        addSequential(new OOSetOnCmd(CommandBase.ddRoller));
        addSequential(new OOTurnOffCmd(CommandBase.dropdown));
    }
}
