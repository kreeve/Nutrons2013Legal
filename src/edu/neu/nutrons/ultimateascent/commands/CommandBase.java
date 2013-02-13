package edu.neu.nutrons.ultimateascent.commands;

import edu.neu.nutrons.ultimateascent.Lawyer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.neu.nutrons.ultimateascent.OI;
import edu.neu.nutrons.ultimateascent.subsystems.DriveTrain;
import edu.neu.nutrons.ultimateascent.subsystems.OnOffSubsystem;

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
    public static OnOffSubsystem intake;
    public static OnOffSubsystem centerer;
    public static OnOffSubsystem magazine;
    public static OnOffSubsystem bolt;
    public static OnOffSubsystem barrel; // whether the shooter is up or down
    public static OnOffSubsystem elevator;
    public static OnOffSubsystem shooter; // the actual wheels
    public static Lawyer law;

    public static void handleSubsystems() {
        dropdown.exec();
        intake.exec();
        centerer.exec();
        magazine.exec();
        bolt.exec();
        barrel.exec();
        elevator.exec();
        shooter.exec();
    }

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        law = new Lawyer();
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
