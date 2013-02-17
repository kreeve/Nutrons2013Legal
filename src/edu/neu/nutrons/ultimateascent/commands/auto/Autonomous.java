/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.commands.auto;

import edu.neu.nutrons.ultimateascent.commands.CommandBase;
import edu.neu.nutrons.ultimateascent.commands.drivetrain.DTAutoCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetOFFCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOSetONCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnOFFCmd;
import edu.neu.nutrons.ultimateascent.commands.onoff.OOTurnONCmd;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author NUTRONs
 */
public class Autonomous extends CommandGroup {

    public static int NONE = 0;
    public static int THREE_DISC = 3;
    public static int FIVE_DISC = 5;
    public static int SEVEN_DISC = 7;
    private double DTSpeed = 0.8;
    public Autonomous(int mode) {
        addSequential(new OOTurnONCmd(CommandBase.barrel));
        addSequential(new OOSetONCmd(CommandBase.shooter));
        addSequential(new OOTurnONCmd(CommandBase.bolt));
        addSequential(new OOTurnOFFCmd(CommandBase.bolt));
        addSequential(new OOTurnONCmd(CommandBase.bolt));
        addSequential(new OOTurnOFFCmd(CommandBase.bolt));
        addSequential(new OOTurnONCmd(CommandBase.bolt));
        addSequential(new OOTurnOFFCmd(CommandBase.bolt));
        if(mode == FIVE_DISC || mode == SEVEN_DISC) {
            // Move stuff down
            if(mode == FIVE_DISC) {
                // Drive forward a bit, back up against pyramid, shoot.
            } else {
                // Drive forward a lot, back up against pyramid, shoot.
            }
        }

        /* These aren't the right auto commands, so you should probably delete them. -ziv
            addSequential(new OOSetOFFCmd(CommandBase.elevator));
            addSequential(new OOSetONCmd(CommandBase.dropdown));
            addSequential(new OOSetONCmd(CommandBase.intake));
            addSequential(new DTAutoCmd(5000, DTSpeed));
            addSequential(new OOSetONCmd(CommandBase.elevator));
            addSequential(new OOSetONCmd(CommandBase.bolt));
            addSequential(new OOSetOFFCmd(CommandBase.bolt));
            addSequential(new OOSetONCmd(CommandBase.bolt));
            addSequential(new OOSetOFFCmd(CommandBase.bolt));
            addSequential(new OOSetONCmd(CommandBase.bolt));
            addSequential(new OOSetOFFCmd(CommandBase.bolt));
            addSequential(new OOSetONCmd(CommandBase.bolt));
            addSequential(new OOSetOFFCmd(CommandBase.bolt));
         */
    }
}
