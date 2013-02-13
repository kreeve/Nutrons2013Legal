
package edu.neu.nutrons.ultimateascent.subsystems;

import edu.neu.nutrons.lib.Utils;
import edu.neu.nutrons.ultimateascent.commands.drivetrain.DTManualCmd;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Drive train moves around and cool stuff like that.
 */
public abstract class OnOffSubsystem extends Subsystem {

    protected boolean on;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // Intentional no default. No command should finish.
    }

    // Call this when turning a subsystem on for the first time.
    protected abstract void initOn();

    // Call this when turning a subsystem off for the first time.
    protected abstract void initOff();

    // Call this periodically when subsystem is on. (Exec is short for execute.)
    protected abstract void execOn();

    // Call this periodically when subsystem is off.
    protected abstract void execOff();

    // Make this say when the subsystem is SAFELY on.
    // (For example, when elevator is at the top, not just when it's going up.)
    public abstract boolean isOn();

    // Make this say when the subsystem is SAFELY off.
    public abstract boolean isOff();

    // If you implement isOn() and isOff() correctly, this should return true
    // when the subsystem is transitioning between two states ("in limbo").
    public boolean isLimbo() {
        return !(isOn() || isOff());
    }

    // Some default implementation for use by commands.
    // YOU PROBABLY SHOULDN'T OVERRIDE THESE.

    public void init(boolean on) {
        // Switch the interal on variable immediately.

        this.on = on;
        if(on) {
            initOn();
        } else {
            initOff();
        }
    }

    // Call exec() somewhere periodically. I put an example in.
    public void exec() {
        // Exec gets internal on variable, which switches as soon as the action
        // of turning on or off has started.
        // isOn() and isOff() should represent when the action has finished.
        if(on) {
            execOn();
        } else {
            execOff();
        }
    }

    public boolean is(boolean on) {
        if(on) {
            return isOn();
        } else {
            return isOff();
        }
    }
}
