/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands.auto;

import edu.neu.nutrons.ultimateascent.commands.*;
import edu.neu.nutrons.ultimateascent.commands.drivetrain.*;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOffCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOnCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOffCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOnCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author NUTRONs
 * AUTONOMOUS
 * Shoots either 0, 3, 5, or 7 based on input during disabled period
 */
public class Autonomous extends CommandGroup {

    public static int NONE = 0;
    public static int THREE_DISC = 3;
    public static int FIVE_DISC = 5;
    public static int SEVEN_DISC = 7;
    private static double DTSpeed = 0.8;
    private static double DIST_X_FIVE_DISC = 4;
    private static double DIST_X_SEVEN_DISC = 10;
    public Autonomous(int mode) {
        if (mode == NONE)
            return;
        //Changed fron SetOn to TurnON because there was no delay
        addSequential(new ShiftCmd(false));
        addSequential(new OOSetOnCmd(CommandBase.magazine));
        addSequential(new OOSetOnCmd(CommandBase.shooter));
        addSequential(new WaitCommand(2.5));
        addSequential(new ShooterFireCmd());
        addSequential(new WaitCommand(.75));
        addSequential(new ShooterFireCmd());
        addSequential(new WaitCommand(.75));
        addSequential(new ShooterFireCmd());
        addSequential(new WaitCommand(.75));
        addSequential(new ShooterFireCmd());
        addSequential(new WaitCommand(.75));
        addSequential(new ShooterFireCmd());
        if(mode == FIVE_DISC || mode == SEVEN_DISC) {
            addSequential(new OOSetOffCmd(CommandBase.magazine));
            addSequential(new OOSetOnCmd(CommandBase.dropdown));
            addSequential(new OOSetOnCmd(CommandBase.ddRoller));
            addSequential(new OOSetOnCmd(CommandBase.intake));
            addSequential(new WaitCommand(1));
             //drive to frisbees under the pyramid
            // Lower intake (and drive a bit?)
            if(mode == FIVE_DISC) {
                // 5-disc auto here.
                // Drive forward a bit, back up against pyramid, shoot
                addSequential(new DriveTimeAtSpeedCmd(.45,1.2));
                addSequential(new WaitCommand(1.25));
                addSequential(new DriveTimeAtSpeedCmd(-.45, 1.2));
                addSequential(new ActivateShooterCmd(1, true));
                //addSequential(new DTDriveMasterCmd(DIST_X_FIVE_DISC, 0, DTSpeed));
                addSequential(new ShooterFireCmd());
                addSequential(new WaitCommand(.75));
                addSequential(new ShooterFireCmd());
                addSequential(new DeactivateShooterCmd());


            } else if (mode == SEVEN_DISC && false) {
                // 7-disc auto here.
                // Drive forward a lot, back up against pyramid, shoot.
                addSequential(new DTDriveMasterCmd(DIST_X_SEVEN_DISC,0,DTSpeed)); // drive to the frisbees closest to alience station
                addSequential(new DTDriveMasterCmd(-DIST_X_SEVEN_DISC, 0, DTSpeed));
                addSequential(new ActivateShooterLowCmd());
                addSequential(new DeactivateShooterCmd());
            }
        }
    }
}
