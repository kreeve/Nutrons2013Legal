/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.nutrons.ultimateascent.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author NUTRONs
 */
public class PneumaticOnOffSubsystem extends OnOffSubsystem {

    double limboTime;
    boolean onState;
    // boolean on is inherited from OnOffSubsystem.
    public PneumaticOnOffSubsystem(int port, boolean onState, double limboTime) {
        // Make the solenoid.
        this.onState = onState;
        this.limboTime = limboTime;
        this.on = false;
    }

    protected void initOn() {
        // TODO: write me! Move the piston, set a variable maybe.
        // Something like this:
        // on = true;
        // piston.set(true);
    }

    protected void initOff() {
        // TODO: write me! Move the piston, set a variable maybe.
    }

    protected void execOn() {
        // Intentionally empty.
    }

    protected void execOff() {
        // Intentionally empty.
    }

    // You'll want two debounced booleans: one for on, one for off.
    // Debounced boolean exists in 2012.
    public boolean isOn() {
        // Use a "debounced" boolean here. (Only true if it's been true for
        // a certain amount of time, like limboTime.)
        return false;
        //I don't like red
    }

    public boolean isOff() {
        // Use a "debounced" boolean here. (Only true if it's been true for
        // a certain amount of time, like limboTime.)
        // There's an implementation in 2012, but it's based on number of calls,
        // not elapsed time.
        // You want the false side deounced here, so it'll maybe look like this:
        // offDebounced.feed(!on);
        // return !offDebounced.get();
        return false;
    }
}
