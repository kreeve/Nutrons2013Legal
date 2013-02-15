/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands.auto;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;
import edu.neu.nutrons.ultimateascent.commands.drivetrain.DTAutoCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOffCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOnCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class Autonomous extends CommandGroup {
    private double DTSpeed = 0.8;
    public Autonomous() {
        addSequential(new OOSetOnCmd(CommandBase.elevator));
        addSequential(new OOSetOnCmd(CommandBase.shooter));
        addSequential(new OOSetOnCmd(CommandBase.bolt));
        addSequential(new OOSetOffCmd(CommandBase.bolt));
        addSequential(new DTAutoCmd(5000, DTSpeed));
    }

}