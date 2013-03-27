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
 * ACTIVATES SHOOTER
 * Step 1: Deactivate intake
 * Step 2: Turn off centerer so we can move magazine
 * Step 3: Start shooter motor
 * Step 4: Retract motor into barrel before moving
 */
public class ActivateShooterCmd extends CommandGroup {
    boolean doIntake = false;

    public void doInit(int centererRuns) {
        addSequential(new OOSetOnCmd(CommandBase.magazine));
        addSequential(new OOSetOnCmd(CommandBase.shooter));
    }

    public ActivateShooterCmd()
    {
        doInit(2);
    }

    public ActivateShooterCmd(int n, boolean doIntake)
    {
        doInit(n);
        this.doIntake = doIntake;
    }
}
