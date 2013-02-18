package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.Lawyer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.neu.nutrons.ultimateascent.OI;
import edu.neu.nutrons.ultimateascent.RobotMap;
import edu.neu.nutrons.ultimateascent.subsystems.*;
import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static DriveTrain dt = new DriveTrain();
    public static OnOffSubsystem dropdown;
    public static Intake intake;
    public static OnOffSubsystem magazine;
    public static OnOffSubsystem bolt;
    public static OnOffSubsystem barrel; // whether the shooter is up or down
    public static OnOffSubsystem climber;
    public static OnOffSubsystem elevator;
    public static OnOffSubsystem shooter; // the actual wheels
    public static OnOffSubsystem ddRoller;
    public static Lawyer law;

    private static String stateStr(OnOffSubsystem sys) {
        if(sys.isOn()) {
            return "ON ";
        } else if(sys.isOff()) {
            return "OFF";
        } else {
            return "?  ";
        }
    }

    public static void handleSubsystems() {
        dropdown.exec();
        magazine.exec();
        bolt.exec();
        barrel.exec();
        climber.exec();
        ddRoller.exec();
        elevator.exec();
        shooter.exec();
        intake.exec();
        System.out.println("ele " + stateStr(elevator) + "  mag " + stateStr(magazine)
                + "bar " + stateStr(barrel) + "  dro " + stateStr(dropdown));
    }

    public static void init() {


        // Non-pneumatic subsystems.
        shooter = new Shooter();
        elevator = new Elevator();
        System.out.println("ABOUT TO INSTANTIATE");
        intake = new Intake();
        ddRoller = new DDRoller();

        // PneumaticOnOffSubsystems
        dropdown = new PneumaticOnOffSubsystem(RobotMap.DROPDOWN, true, .5);
        magazine = new PneumaticOnOffSubsystem(RobotMap.MAGAZINE, false, 1, .5);
        barrel = new PneumaticOnOffSubsystem(RobotMap.BARREL, false, .5);
        bolt = new PneumaticOnOffSubsystem(RobotMap.BOLT, true, .25);
        climber = new PneumaticOnOffSubsystem(RobotMap.CLIMBER, true, .5);

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
