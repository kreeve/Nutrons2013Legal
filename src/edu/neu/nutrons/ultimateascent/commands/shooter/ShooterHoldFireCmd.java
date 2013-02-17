/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands.shooter;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOFFCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOFFCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class ShooterHoldFireCmd extends CommandGroup {
    public ShooterHoldFireCmd() {
        addSequential(new OOSetOFFCmd(CommandBase.shooter));
        addSequential(new OOTurnOFFCmd(CommandBase.barrel));
        addSequential(new OOTurnOFFCmd(CommandBase.magazine));
    }
}
