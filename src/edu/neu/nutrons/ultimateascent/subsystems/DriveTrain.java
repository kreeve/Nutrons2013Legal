
package edu.neu.nutrons.ultimateascent.subsystems;

import edu.neu.nutrons.lib.Utils;
import edu.neu.nutrons.ultimateascent.RobotMap;
import edu.neu.nutrons.ultimateascent.commands.drivetrain.DTManualCmd;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Drive train moves around and cool stuff like that.
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Talon leftMotor1 = new Talon(RobotMap.DRIVE_LEFT_MOTOR_1);
    private Talon leftMotor2 = new Talon(RobotMap.DRIVE_LEFT_MOTOR_2);
    private Talon rightMotor1 = new Talon(RobotMap.DRIVE_RIGHT_MOTOR_1);
    private Talon rightMotor2 = new Talon(RobotMap.DRIVE_RIGHT_MOTOR_2);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DTManualCmd());
    }

    public void driveLR(double left, double right) {
        // TODO: write me!
    }

    public void driveTW(double throttle, double wheel) {
        // TODO: write me! But here's what Ziv thinks:
        wheel = Utils.limit(wheel, -1, 1);
        throttle = Utils.limit(throttle, -1+Math.abs(wheel), 1-Math.abs(wheel));
        driveLR(throttle-wheel, throttle+wheel);
    }

    public void driveCheesy(double throttle, double wheel, boolean quickturn) {
        // TODO: write me! Or copy and paste me!
    }
}
