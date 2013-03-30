package edu.neu.nutrons.ultimateascent.commands.auto;

import edu.neu.nutrons.ultimateascent.commands.*;
import edu.neu.nutrons.ultimateascent.commands.drivetrain.*;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOffCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOnCmd;
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
    public static int THREE_BACK = 4;
    public static int SHOOT_FROM_PYRAMID = 6;
    private static double DTSpeed = 0.8;
    private static double DIST_X_FIVE_DISC = 4;
    private static double DIST_X_SEVEN_DISC = 10;
    private static double DISTANCE_TO_WALL = 1; // Subject to change
    private static double THREE_BACK_DISTANCE = 1; // Subject to change

    public Autonomous(int mode) {
        double timeBetweenShots = 0.75;
        if(mode == NONE)
            return;
        //Changed fron SetOn to TurnON because there was no delay
        addSequential(new ShiftCmd(false));
        addSequential(new OOSetOnCmd(CommandBase.magazine));
        if(mode == SHOOT_FROM_PYRAMID) {
            addSequential(new OOTurnOnCmd(CommandBase.elevator));
        }
        addSequential(new OOSetOnCmd(CommandBase.shooter));
        addSequential(new WaitCommand(2.5));
        addSequential(new ShooterFireCmd());
        addSequential(new WaitCommand(timeBetweenShots));
        addSequential(new ShooterFireCmd());
        addSequential(new WaitCommand(timeBetweenShots));
        addSequential(new ShooterFireCmd());
        if(mode == THREE_DISC) {
            // Just in case.
            addSequential(new WaitCommand(timeBetweenShots));
            addSequential(new ShooterFireCmd());
            addSequential(new WaitCommand(timeBetweenShots));
            addSequential(new ShooterFireCmd());
        }

        if(mode == THREE_BACK) {
            addSequential(new DTProfilePIDCmd(-THREE_BACK_DISTANCE));
            addSequential(new DTTurnAroundCmd());
        }

        if(mode == FIVE_DISC || mode == SEVEN_DISC) {
            /* Old. -ziv
            addSequential(new OOSetOffCmd(CommandBase.magazine));
            addSequential(new OOSetOnCmd(CommandBase.dropdown));
            addSequential(new OOSetOnCmd(CommandBase.ddRoller));
            addSequential(new OOSetOnCmd(CommandBase.intake));
            */
            // addSequential(new WaitCommand(1) ,m);
            // drive to frisbees under the pyramid
            // Lower intake (and drive a bit?)

            addSequential(new ActivateIntakeDropdownCmd());
            addSequential(new ResetDriveSensorsCmd());
            if(mode == FIVE_DISC) {
                // 5-disc auto here.
                // Drive forward a bit, back up against pyramid, shoot
                /*
                 * Old driving:
                addSequential(new DriveTimeTWCmd(.45,0,1.2));
                addSequential(new WaitCommand(1.25));
                addSequential(new DriveTimeTWCmd(.45,0,1.2));
                 */
                addSequential(new DriveTimeTWCmd(.45,0,1.0));
                addSequential(new DriveTimeTWCmd(.35,.25,0.2));
                addSequential(new DriveTimeTWCmd(.45,0,0.25));
                addSequential(new OOSetOnCmd(CommandBase.shooter));
                addSequential(new WaitCommand(0.5));
                addSequential(new DriveTimeAtSpeedAlignedCmd(-.45,0,1.2));
                //If we ever get it working: addSequential(new DTDriveMasterCmd(DIST_X_FIVE_DISC, 0, DTSpeed));

                addSequential(new ActivateShooterCmd());
                //If needed:
                addSequential(new WaitCommand(2.5));
                addSequential(new ShooterFireCmd());
                addSequential(new WaitCommand(timeBetweenShots));
                addSequential(new ShooterFireCmd());
                // Just in case.
                addSequential(new WaitCommand(timeBetweenShots));
                addSequential(new ShooterFireCmd());
                addSequential(new DeactivateShooterCmd());


            } else if (mode == SEVEN_DISC) {
                // 7-disc auto here.
                // Drive forward a lot, back up against pyramid, shoot.
                //addSequential(new DTDriveMasterCmd(DIST_X_SEVEN_DISC, 0,DTSpeed)); // drive to the frisbees closest to alience station
                //addSequential(new DTDriveMasterCmd(-DIST_X_SEVEN_DISC, 0, DTSpeed));
                addSequential(new OOSetOnCmd(CommandBase.ddRoller));
                addSequential(new DTProfilePIDCmd(DISTANCE_TO_WALL));
                addSequential(new DTProfilePIDCmd(-DISTANCE_TO_WALL));
                addSequential(new OOSetOffCmd(CommandBase.ddRoller));
                addSequential(new ActivateShooterHighCmd());
                addSequential(new ShooterFireCmd());
                addSequential(new WaitCommand(timeBetweenShots));
                addSequential(new ShooterFireCmd());
                addSequential(new WaitCommand(timeBetweenShots));
                addSequential(new ShooterFireCmd());
                addSequential(new WaitCommand(timeBetweenShots));
                addSequential(new ShooterFireCmd());
                addSequential(new DeactivateShooterCmd());
            }
        }
    }


}
