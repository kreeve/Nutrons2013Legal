/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOffCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOnCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 * FIRE FRISBEE
 * Step 1: Extend bolt
 * Step 2: Retract bolt
 */
public class ShooterFireCmd extends CommandGroup {
    
    public ShooterFireCmd() {
        addSequential(new OOTurnOnCmd(CommandBase.bolt));
        addSequential(new OOTurnOffCmd(CommandBase.bolt));
    }

}
