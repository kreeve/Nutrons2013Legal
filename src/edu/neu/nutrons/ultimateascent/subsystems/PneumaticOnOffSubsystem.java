/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.subsystems;

import edu.neu.nutrons.lib.DebouncedBoolean;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author NUTRONs
 */
public class PneumaticOnOffSubsystem extends OnOffSubsystem {

    double limboTime;
    boolean onState;
    protected Solenoid piston;
    protected DebouncedBoolean delayOn;
    protected DebouncedBoolean delayOff;
    // boolean on is inherited from OnOffSubsystem.
    public PneumaticOnOffSubsystem(int port, boolean onState, double limboTime) {
        // Make the solenoid.
        this.onState = onState;
        this.limboTime = limboTime;
        this.piston = new Solenoid(port);
        this.delayOn = new DebouncedBoolean(this.limboTime);
        this.delayOff = new DebouncedBoolean(this.limboTime);
    }

    protected void initOn() {
        // TODO: write me! Move the piston, set a variable maybe.
        // Something like this:
        // on = true;
        // piston.set(true);
        piston.set(true);
    }

    protected void initOff() {
        // TODO: write me! Move the piston, set a variable maybe.
        piston.set(false);
    }

    protected void execOn() {
        delayOn.feed(true);
        delayOff.feed(true);
        // Intentionally empty.
    }

    protected void execOff() {
        delayOn.feed(false);
        delayOff.feed(true);
        // Intentionally empty.
    }

    // You'll want two debounced booleans: one for on, one for off.
    // Debounced boolean exists in 2012.
    public boolean isOn() {
        return delayOn.get();
    }

    public boolean isOff() {
        return delayOff.get();
    }
}
