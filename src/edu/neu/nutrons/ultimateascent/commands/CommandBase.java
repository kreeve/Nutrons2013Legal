package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.Lawyer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.neu.nutrons.ultimateascent.OI;
import edu.neu.nutrons.ultimateascent.RobotMap;
import edu.neu.nutrons.ultimateascent.controllers.DriveController;
import edu.neu.nutrons.ultimateascent.subsystems.*;
import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author NUTRONs
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Declaration of subsystems
    public static final DriveTrain dt = new DriveTrain(); // drive train
    public static DriveController driveController = new DriveController(dt);
    public static OnOffSubsystem dropdown; // drop down roller
    public static Intake intake; // regular intake
    public static OnOffSubsystem magazine; // carries frisbees must be retracted to move barrel
    public static OnOffSubsystem bolt; // pushes frisbee into shooter
    public static OnOffSubsystem climber; // hooks that extend to climb to first level
    public static Elevator elevator; // elevates the shooter with its related subsystems
    public static Shooter shooter; // the actual wheels
    public static OnOffSubsystem ddRoller; // motor of the drop down roller
    //public static OnOffSubsystem centerer; // centers the frisbees must be retracted to use other subsystems

    public static Lawyer law;

    // Returns the state of the subsystem passed in
    private static String stateStr(OnOffSubsystem sys) {
        if(sys.isOn()) {
            return "ON ";
        } else if(sys.isOff()) {
            return "OFF";
        } else {
            return "?  ";
        }
    }

    // Executes all subsystems
    public static void handleSubsystems() {
        dropdown.exec();
        magazine.exec();
        bolt.exec();
        climber.exec();
        ddRoller.exec();

        elevator.exec();
        elevator.updateControlLoop(); // Makes sure to update elevator control
                                      // if we're trying to control its position.
        shooter.exec();
        intake.exec();
       // System.out.println("ele " + stateStr(elevator) + "  mag " + stateStr(magazine)
         //       + "  dro " + stateStr(dropdown) + " enc rate: " + shooter.getRate());
    }

    public static void init() {
        // Non-pneumatic subsystems.
        shooter = new Shooter();
        elevator = new Elevator();
        System.out.println("ABOUT TO INSTANTIATE");
        intake = new Intake();
        ddRoller = new DDRoller();

        // PneumaticOnOffSubsystems (subsystem, default position, delay)
        dropdown = new PneumaticOnOffSubsystem(RobotMap.DROPDOWN, true, .25);
        magazine = new PneumaticOnOffSubsystem(RobotMap.MAGAZINE, false, 1.25, 1.25);
        bolt = new PneumaticOnOffSubsystem(RobotMap.BOLT, true, .25);
        climber = new PneumaticOnOffSubsystem(RobotMap.CLIMBER, true, .5);
        //centerer = new PneumaticOnOffSubsystem(RobotMap.CENTERER, RobotMap.CENTERER_RETRACTED, 0.5);

        law = new Lawyer();

        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(dt);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
