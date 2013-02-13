
package edu.neu.nutrons.ultimateascent.subsystems;

import edu.neu.nutrons.lib.Utils;
import edu.neu.nutrons.ultimateascent.commands.drivetrain.DTManualCmd;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Drive train moves around and cool stuff like that.
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

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
